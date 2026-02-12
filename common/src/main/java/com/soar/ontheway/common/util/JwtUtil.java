package com.soar.ontheway.common.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtUtil {

    @Value("${jwt.secrete_key}")
    private static String SECRETE_KEY_STR;

    private static final Key SECRETE_KEY = Keys.hmacShaKeyFor(SECRETE_KEY_STR.getBytes());
    private static final long EXPIRATION_TIME =  86400000;

    @Autowired
    private static RedisTemplate<String, Object> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);


    public static String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRETE_KEY)
                .compact();
    }

    public static Boolean validateToken(String token) {
        String key = "JwtBlacklist:" + DigestUtils.md5DigestAsHex(token.getBytes());
        if(redisTemplate.hasKey(key)) {
            return false;
        }

        try{
            Jwts.parser()
                    .verifyWith((SecretKey) SECRETE_KEY)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Token expired: {}", e.getMessage());
            return false;
        } catch (MalformedJwtException e) {
            logger.error("Invalid token format: {}", e.getMessage());
            return false;
        } catch (SecurityException e) {
            logger.error("Signature verification failed: {}", e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            logger.error("Token is null or empty: {}", e.getMessage());
            return false;
        } catch (JwtException e) {
            logger.error("JWT error: {}", e.getMessage());
            return false;
        }
    }

    public static String getUsername(String token) {
        Claims claims = Jwts.parser()
                .verifyWith((SecretKey) SECRETE_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public static String getUsernameSafely(String token) {
        try {
            return getUsername(token);
        } catch (ExpiredJwtException e) {
            return e.getClaims().getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getValidateTime(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith((SecretKey) SECRETE_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getExpiration();
        } catch (ExpiredJwtException e) {
            return e.getClaims().getExpiration();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid token" + e.getMessage());
        }
    }

    public static String refreshToken(String token) {
        try {
            String username = getUsername(token);
            if (username == null) {
                throw new IllegalArgumentException("Get username from token failed");
            }
            return generateToken(token);
        }  catch (Exception e) {
            throw new IllegalArgumentException("RefreshToken error: " + e.getMessage());
        }
    }

    public static void addTokenToBlackList(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith((SecretKey) SECRETE_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            Date expiration = claims.getExpiration();
            long ttl = expiration.getTime() - System.currentTimeMillis();
            if(ttl > 0) {
                String key = "JwtBlacklist:" + DigestUtils.md5DigestAsHex(token.getBytes());
                redisTemplate.opsForValue().set(key, "1", ttl, TimeUnit.MILLISECONDS);
            }
        } catch (ExpiredJwtException _) {

        } catch (Exception e) {
            logger.error("AddTokenToBlackList error{}", e.getMessage());
        }
    }

}
