package com.soar.ontheway.ticket.vo.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 关键字搜索响应结果
 * 格式由请求参数output指定
 */
@Setter
@Getter
public class PoiSearchResponseVo {

    /**
     * 结果状态值，值为0或1
     * 0：请求失败；1：请求成功
     */
    private String status;

    /**
     * 返回状态说明
     * status为0时，info返回错误原因，否则返回“OK”
     */
    private String info;

    /**
     * 搜索方案数目
     */
    private String count;

    /**
     * 城市建议列表
     * 当搜索的文本关键字在限定城市中没有返回时会返回建议城市列表
     */
    private Suggestion suggestion;

    /**
     * 搜索POI信息列表
     */
    private List<PoiInfo> pois;

    /**
     * 城市建议列表
     */
    public static class Suggestion {

        /**
         * 关键字
         */
        private String keywords;

        /**
         * 城市列表
         */
        private List<CityInfo> cities;
    }

    /**
     * 城市信息
     */
    public static class CityInfo {

        /**
         * 名称
         */
        private String name;

        /**
         * 该城市包含此关键字的个数
         */
        private String num;

        /**
         * 该城市的citycode
         */
        private String citycode;

        /**
         * 该城市的adcode
         */
        private String adcode;
    }

    /**
     * POI信息
     */
    public static class PoiInfo {

        /**
         * 唯一ID
         */
        private String id;

        /**
         * 父POI的ID
         * 当前POI如果有父POI，则返回父POI的ID。可能为空
         */
        private String parent;

        /**
         * 名称
         */
        private String name;

        /**
         * 兴趣点类型
         * 顺序为大类、中类、小类
         * 例如：餐饮服务;中餐厅;特色/地方风味餐厅
         */
        private String type;

        /**
         * 兴趣点类型编码
         * 例如：050118
         */
        private String typecode;

        /**
         * 行业类型
         */
        private String biz_type;

        /**
         * 地址
         * 例如：东四环中路189号百盛北门
         */
        private String address;

        /**
         * 经纬度
         * 格式：X,Y
         */
        private String location;

        /**
         * 离中心点距离
         * 单位：米；仅在周边搜索的时候有值返回
         */
        private String distance;

        /**
         * POI的电话
         */
        private String tel;

        /**
         * 邮编
         * extensions=all时返回
         */
        private String postcode;

        /**
         * POI的网址
         * extensions=all时返回
         */
        private String website;

        /**
         * POI的电子邮箱
         * extensions=all时返回
         */
        private String email;

        /**
         * POI所在省份编码
         * extensions=all时返回
         */
        private String pcode;

        /**
         * POI所在省份名称
         * 若是直辖市的时候，此处直接显示市名，例如北京市
         */
        private String pname;

        /**
         * 城市编码
         * extensions=all时返回
         */
        private String citycode;

        /**
         * 城市名
         * 若是直辖市的时候，此处直接显示市名，例如北京市
         */
        private String cityname;

        /**
         * 区域编码
         * extensions=all时返回
         */
        private String adcode;

        /**
         * 区域名称
         * 区县级别的返回，例如朝阳区
         */
        private String adname;

        /**
         * POI的入口经纬度
         * extensions=all时返回，也可用作于POI的到达点
         */
        private String entr_location;

        /**
         * POI的出口经纬度
         * 目前不会返回内容
         */
        private String exit_location;

        /**
         * POI导航id
         * extensions=all时返回
         */
        private String navi_poiid;

        /**
         * 地理格ID
         * extensions=all时返回
         */
        private String gridcode;

        /**
         * 别名
         * extensions=all时返回
         */
        private String alias;

        /**
         * 停车场类型
         * 仅在停车场类型POI的时候显示该字段
         * 展示停车场类型，包括：地下、地面、路边
         * extensions=all的时候显示
         */
        private String parking_type;

        /**
         * 该POI的特色内容
         * 主要出现在美食类POI中，代表特色菜
         * 例如“烤鱼,麻辣香锅,老干妈回锅肉”
         * extensions=all时返回
         */
        private String tag;

        /**
         * 是否有室内地图标志
         * 1，表示有室内相关数据；0，代表没有室内相关数据
         * extensions=all时返回
         */
        private String indoor_map;

        /**
         * 室内地图相关数据
         * 当indoor_map=0时，字段为空
         * extensions=all时返回
         */
        private IndoorData indoor_data;

        /**
         * 当前POI的父级POI
         * 如果当前POI为建筑物类POI，则cpid为自身POI ID
         * 如果当前POI为商铺类POI，则cpid为其所在建筑物的POI ID
         */
        private String cpid;

        /**
         * 楼层索引
         * 一般会用数字表示，例如8
         */
        private String floor;

        /**
         * 所在楼层
         * 一般会带有字母，例如F8
         */
        private String truefloor;

        /**
         * 团购数据
         * 此字段逐渐废弃
         */
        private String groupbuy_num;

        /**
         * 所属商圈
         * extensions=all时返回
         */
        private String business_area;

        /**
         * 优惠信息数目
         * 此字段逐渐废弃
         */
        private String discount_num;

        /**
         * 深度信息
         * extensions=all时返回
         */
        private BizExt biz_ext;

        /**
         * 照片相关信息
         * extensions=all时返回
         */
        private List<Photo> photos;
    }

    /**
     * 室内地图相关数据
     */
    public static class IndoorData {

        /**
         * 当前POI的父级POI
         */
        private String cpid;

        /**
         * 楼层索引
         */
        private String floor;

        /**
         * 所在楼层
         */
        private String truefloor;
    }

    /**
     * 深度信息
     */
    public static class BizExt {

        /**
         * 评分
         * 仅存在于餐饮、酒店、景点、影院类POI之下
         */
        private String rating;

        /**
         * 人均消费
         * 仅存在于餐饮、酒店、景点、影院类POI之下
         */
        private String cost;

        /**
         * 是否可订餐
         * 仅存在于餐饮相关POI之下（此字段逐渐废弃）
         */
        private String meal_ordering;

        /**
         * 是否可选座
         * 仅存在于影院相关POI之下（此字段逐渐废弃）
         */
        private String seat_ordering;

        /**
         * 是否可订票
         * 仅存在于景点相关POI之下（此字段逐渐废弃）
         */
        private String ticket_ordering;

        /**
         * 是否可以订房
         * 仅存在于酒店相关POI之下（此字段逐渐废弃）
         */
        private String hotel_ordering;
    }

    /**
     * 照片信息
     */
    public static class Photo {

        /**
         * 图片介绍
         */
        private String title;

        /**
         * 具体链接
         */
        private String url;
    }

}