package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 华通ecif地址类型
 * @Author WJH
 * @Date 2020/05/18
 */
public enum HTAddressType {

    FAMILY("101", "家庭地址"),
    UNIT("102", "单位地址"),
    OFFICE("103", "办公地址"),
    BIRTH("104", "户籍地址"),
    CERTIFICATE("105", "证件地址"),

    REGISTER("201", "注册地址"),
    BUSINESS("202", "营业地址"),

    CONTACT("301", "联系地址"),
    HOUSE("302", "房产地址"),
    ENGLISH("303", "英文地址"),

    OTHER("999", "其他地址"),

    ;
    private String code;
    private String desc;

    HTAddressType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
