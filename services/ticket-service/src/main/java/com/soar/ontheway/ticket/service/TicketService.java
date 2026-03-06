package com.soar.ontheway.ticket.service;

import com.soar.ontheway.common.util.HttpClientUtil;
import com.soar.ontheway.ticket.vo.request.PoiSearchRequestVo;
import com.soar.ontheway.ticket.vo.response.PoiSearchResponseVo;
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

    public HttpResponse<PoiSearchResponseVo> queryStations(PoiSearchRequestVo requestVo) {
        String uriStr = "https://restapi.amap.com/v3/place/text?parameters?key=" + AMAP_SECRETE_KEY;
        if(requestVo.getKeywords() != null && !requestVo.getKeywords().trim().isEmpty()) {
            uriStr += "&keywords=" + requestVo.getKeywords();
        }
        if(requestVo.getTypes() != null && !requestVo.getTypes().trim().isEmpty()) {
            uriStr += "&types=" + requestVo.getTypes();
        }
        if(requestVo.getCity() != null && !requestVo.getCity().trim().isEmpty()) {
            uriStr += "&city=" + requestVo.getCity();
        }
        if(requestVo.getCitylimit() != null) {
            uriStr += "&citylimit=" + requestVo.getCitylimit();
        }
        if(requestVo.getChildren() != null) {
            uriStr += "&children=" + requestVo.getChildren();
        }
        if(requestVo.getOffset() != null) {
            uriStr += "&offset=" + requestVo.getOffset();
        }
        if(requestVo.getPage() != null) {
            uriStr += "&page=" + requestVo.getPage();
        }
        if(requestVo.getExtensions() != null && !requestVo.getExtensions().trim().isEmpty()) {
            uriStr += "&extensions=" + requestVo.getExtensions();
        }
        if(requestVo.getSig() != null && !requestVo.getSig().trim().isEmpty()) {
            uriStr += "&sig=" + requestVo.getSig();
        }
        if(requestVo.getCallback() != null && !requestVo.getCallback().trim().isEmpty()) {
            uriStr += "&callback=" + requestVo.getCallback();
        }

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uriStr))
                .build();
        return HttpClientUtil.sendAndParse(httpRequest, PoiSearchResponseVo.class);
    }
}
