package com.soar.ontheway.ticket.vo.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryDistrictsResponseSuggestionVo {

    // 建议关键字列表
    private List<String> keywords;

    // 建议城市列表
    private List<String> cities;
}
