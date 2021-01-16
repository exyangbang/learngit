package cn.kingnet.utp.trade.common.enums;

/**
 * 资金明细流水：交易明细状态
 *
 * @Description
 * @Author WJH
 * @Date 2019/03/26
 */
public enum HTReverseFlag {

    NORMAL("0", "正常"),
    BEREVERSE_BALANCE("1", "被冲账"),
    REVERSE_BALANCE("2", "冲账"),;
    private String flag;
    private String desc;

    HTReverseFlag(String flag, String desc) {
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
