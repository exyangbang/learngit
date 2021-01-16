package cn.kingnet.utp.trade.common.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/19
 */
public enum FundUseType {
    GENERAL("0", "普通用途"),
    COLLECTION("1", "归集用途"),

    ;
    private String type;
    private String desc;

    FundUseType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
