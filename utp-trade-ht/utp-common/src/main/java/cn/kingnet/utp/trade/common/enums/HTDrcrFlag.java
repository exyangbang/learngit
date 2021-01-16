package cn.kingnet.utp.trade.common.enums;

/**
 * 华通借贷标志
 * @Description
 * @Author WJH
 * @Date 2019/03/26
 */
public enum HTDrcrFlag {

    DEBIG("0", "借方[余额扣减]"),
    CREDIT("1", "贷方[余额增加]");
    private String flag;
    private String desc;

    /**
     * drcrFlag借贷标志 0-借方(余额扣减) 1-贷方(余额累加)  状态标识：reverse 0-正常 1-被冲账 2-冲账
     * 仅取正常且入账的明细
     **/

    HTDrcrFlag(String flag, String desc) {
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
