package com.soar.ontheway.ticket.service;

import com.soar.ontheway.common.util.HttpClientUtil;
import com.soar.ontheway.ticket.vo.response.QueryDistrictsResponseVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TicketService {

    @Value("${amap.secrete_key}")
    private static String AMAP_SECRETE_KEY;

    private final HttpClientUtil httpClientUtil = new HttpClientUtil();

    public HttpResponse<QueryDistrictsResponseVo> queryDistricts(String keywords, Integer subdistrict, String extensions) {
        String uriStr = "https://restapi.amap.com/v3/config/district?key=" + AMAP_SECRETE_KEY;
        if(keywords != null && !keywords.trim().isEmpty()) {
            uriStr += "&keywords=" + keywords;
        }
        if(1 <= subdistrict && subdistrict <= 3) {
            uriStr += "&subdistrict=" + subdistrict;
        }
        if(extensions != null) {
            extensions = extensions.trim();
        }
        if("all".equals(extensions) || "base".equals(extensions)) {
            uriStr += "&extensions=" + extensions;
        }

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uriStr))
                .build();
        return HttpClientUtil.sendAndParse(httpRequest, QueryDistrictsResponseVo.class);
    }
}
