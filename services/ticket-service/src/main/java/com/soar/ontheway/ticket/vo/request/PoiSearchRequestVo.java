package com.soar.ontheway.ticket.vo.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PoiSearchRequestVo {
    /**
     * 请求服务权限标识
     * 用户在高德地图官网申请Web服务API类型KEY
     * 必填
     */
    private String key;

    /**
     * 查询关键字
     * 规则：只支持一个关键字
     * 若不指定city，并且搜索的为泛词（例如“美食”）的情况下，返回的内容为城市列表以及此城市内有多少结果符合要求
     * 必填（keyword或者types二选一必填）
     */
    private String keywords;

    /**
     * 查询POI类型
     * 可选值：分类代码或汉字（若用汉字，请严格按照附件之中的汉字填写）
     * 规则：多个关键字用“|”分割
     * 分类代码由六位数字组成，一共分为三个部分，前两个数字代表大类；中间两个数字代表中类；最后两个数字代表小类
     * 若指定了某个大类，则所属的中类、小类都会被显示
     * 必填（keyword或者types二选一必填）
     */
    private String types;

    /**
     * 查询城市
     * 可选值：城市中文、citycode、adcode（如：北京/010/110000）
     * 填入此参数后，会尽量优先返回此城市数据，但是不一定仅局限此城市结果
     * 若仅需要某个城市数据请调用citylimit参数
     * 可选
     */
    private String city;

    /**
     * 仅返回指定城市数据
     * 可选值：true/false
     * 可选
     */
    private Boolean citylimit;

    /**
     * 是否按照层级展示子POI数据
     * 可选值：children=1
     * 当为0的时候，子POI都会显示
     * 当为1的时候，子POI会归类到父POI之中
     * 在extensions=all或者为空时生效
     * 可选
     */
    private Integer children;

    /**
     * 每页记录数据
     * 强烈建议不超过25，若超过25可能造成访问报错
     * 可选，默认20
     */
    private Integer offset;

    /**
     * 当前页数
     * 可选，默认1
     */
    private Integer page;

    /**
     * 返回结果控制
     * 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息
     * 可选，默认base
     */
    private String extensions;

    /**
     * 数字签名
     * 请参考数字签名获取和使用方法
     * 可选
     */
    private String sig;

    /**
     * 回调函数
     * callback值是用户定义的函数名称，此参数只在output=JSON时有效
     * 可选
     */
    private String callback;

}
