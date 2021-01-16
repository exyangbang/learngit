package cn.kingnet.utp.trade.common.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/29
 */
public enum HTBizFlag {

    RECORED("01","已入账"),
    HANDING_ACCOUNT("02","已挂账"),
    REFUNDED("03","已退账"),
    HANDWORK_RECORED("04","已手工入账"),
    ;
    private String flag;
    private String desc;

    HTBizFlag(String flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }
}
