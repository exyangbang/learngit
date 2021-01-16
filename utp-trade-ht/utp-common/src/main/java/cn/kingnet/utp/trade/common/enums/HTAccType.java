package cn.kingnet.utp.trade.common.enums;

/**
 * 01 银行卡;02 存折; 03 IC卡
 *
 * @Description
 * @Author WJH
 * @Date 2019/04/08
 */
public enum HTAccType {
    BANKCARD("01", "银行卡"),
    BANKBOOK("02", "存折"),
    ICCARD("03", "IC卡"),;
    private String type;
    private String desc;

    HTAccType(String type, String desc) {
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
