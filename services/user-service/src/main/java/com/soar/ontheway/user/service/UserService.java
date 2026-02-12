package com.soar.ontheway.user.service;

import com.soar.ontheway.common.util.JwtUtil;
import com.soar.ontheway.user.dao.UserDao;
import com.soar.ontheway.user.entity.po.UserPo;
import com.soar.ontheway.user.entity.vo.UserRegisterRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String login(String username, String password) {
        UserPo userPo = userDao.queryUserByUsername(username);
        if(userPo == null || !userPo.getPassword().equals(password)) {
            return "";
        }

        return JwtUtil.generateToken(username);
    }

    public void logout(String token) {
        JwtUtil.addTokenToBlackList(token);
    }

    public String register(UserRegisterRequestVo req) {
        UserPo userPo = userDao.queryUserByUsername(req.getUsername());
        if(userPo != null) {
            return "用户名已存在";
        }

        if(userDao.insertUser(req) == 0) {
            return "注册失败，请稍后再试";
        }

        return "";
    }
}