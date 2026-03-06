package com.soar.ontheway.ticket.vo.response;

import com.soar.ontheway.ticket.po.DistrictsPo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryDistrictsResponseVo {

    // 返回结果状态值，值为0或1，0表示失败；1表示成功
    private Integer status;

    // 返回状态说明，status 为0时，info 返回错误原因，否则返回“OK”。
    private String info;

    // 状态码， 10000代表正确
    private Long infoCode;

    // 建议结果列表
    private List<QueryDistrictsResponseSuggestionVo> suggestion;

    // 行政区列表
    private List<DistrictsPo> districts;

}
