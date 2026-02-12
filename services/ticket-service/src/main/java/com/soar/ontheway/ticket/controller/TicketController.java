package com.soar.ontheway.ticket.controller;

import com.soar.ontheway.common.response.ResponseVo;
import com.soar.ontheway.ticket.service.TicketService;
import com.soar.ontheway.ticket.vo.request.QueryDistrictsRequestVo;
import com.soar.ontheway.ticket.vo.response.QueryDistrictsResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    Logger log = LoggerFactory.getLogger(TicketController.class);

    @RequestMapping("/districts")
    @ResponseBody
    public ResponseVo queryDistricts(QueryDistrictsRequestVo requestVo) {
        ResponseVo responseVo = new ResponseVo();
        try {
            HttpResponse<QueryDistrictsResponseVo> httpResponse = ticketService.queryDistricts(requestVo.getKeywords(), requestVo.getSubdistrict(), requestVo.getExtensions());
            QueryDistrictsResponseVo queryDistrictsResponseVo = httpResponse.body();
            responseVo.setCode(httpResponse.statusCode());
            responseVo.setSuccess(true);
            responseVo.setMessage(queryDistrictsResponseVo.getInfo());
            responseVo.setData(queryDistrictsResponseVo);
            return responseVo;
        } catch (Exception e) {
            log.error("query districts error:{}", e.getMessage());
            responseVo.setCode(500);
            responseVo.setSuccess(false);
            responseVo.setMessage(e.getMessage());
            return responseVo;
        }
    }

}
