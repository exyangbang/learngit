package cn.kingnet.utp.trade.common.enums;

/**
 * 卡类型 C：贷记卡；D：借记卡
 *
 * @Description
 * @Author WJH
 * @Date 2019/04/08
 */
public enum HTCardType {
    C("贷记卡"),
    D("借记卡"),;
    private String desc;

    HTCardType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
