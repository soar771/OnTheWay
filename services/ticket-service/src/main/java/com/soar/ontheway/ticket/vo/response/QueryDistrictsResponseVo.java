package com.soar.ontheway.ticket.vo.response;

import com.soar.ontheway.ticket.po.DistrictsPo;

import java.util.List;

public class QueryDistrictsResponseVo {

    // 返回结果状态值，值为0或1，0表示失败；1表示成功
    private Integer status;

    // 返回状态说明，status 为0时，info 返回错误原因，否则返回“OK”。
    private String info;

    // 状态码， 10000代表正确
    private Long infocode;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getInfocode() {
        return infocode;
    }

    public void setInfocode(Long infocode) {
        this.infocode = infocode;
    }

    public List<QueryDistrictsResponseSuggestionVo> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<QueryDistrictsResponseSuggestionVo> suggestion) {
        this.suggestion = suggestion;
    }

    public List<DistrictsPo> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsPo> districts) {
        this.districts = districts;
    }

    // 建议结果列表
    private List<QueryDistrictsResponseSuggestionVo> suggestion;

    // 行政区列表
    private List<DistrictsPo> districts;

}
