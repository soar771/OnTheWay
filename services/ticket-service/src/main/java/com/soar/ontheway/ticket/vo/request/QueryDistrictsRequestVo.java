package com.soar.ontheway.ticket.vo.request;

public class QueryDistrictsRequestVo {
    /**
     * 只支持单个关键词语搜索关键词
     * 支持：行政区名称、citycode、adcode
     */
    private String keywords;

    /**
     *设置显示下级行政区级数（行政区级别包括：国家、省/直辖市、市、区/县4个级别）
     * 0：不返回下级行政区；
     * 1：返回下一级行政区；
     * 2：返回下两级行政区；
     * 3：返回下三级行政区；
     */
    private Integer subdistrict;

    /**
     * 控制行政区信息中返回行政区边界坐标点；
     * 0:不返回行政区边界坐标点(base)
     * 1:只返回当前查询 district 的边界值，不返回子节点的边界值(all)；
     */
    private String extensions;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(Integer subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }
}
