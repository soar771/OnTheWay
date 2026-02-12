package com.soar.ontheway.ticket.po;

import lombok.Data;

import java.util.List;

@Data
public class DistrictsPo {

    // 城市编码
    private Long citycode;

    // 区域编码（街道没有独有的 adcode，均继承父类（区县）的 adcode）
    private Long adcode;

    // 行政区名称
    private String name;

    // 行政区边界坐标点
    private String polyline;

    // 区域中心点
    private String center;

    public Long getCitycode() {
        return citycode;
    }

    public void setCitycode(Long citycode) {
        this.citycode = citycode;
    }

    public Long getAdcode() {
        return adcode;
    }

    public void setAdcode(Long adcode) {
        this.adcode = adcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<DistrictsPo> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsPo> districts) {
        this.districts = districts;
    }

    // 行政区划级别
    private String level;

    // 国家
    private String country;

    // 省份（直辖市会在province显示）
    private String province;

    // 市（直辖市会在province显示）
    private String city;

    // 区县
    private String district;

    // 街道
    private String street;

    // 下级行政区列表
    private List<DistrictsPo> districts;

}
