package cn.kingnet.utp.trade.common.enums;

/**
 * 华通账户性质：对公对私标志
 *
 * @Description
 * @Author WJH
 * @Date 2019/03/22
 */
public enum HTPcFlag {

    PRIVATE("0", "对私"),
    PUBLIC("1", "对公"),;

    private String flag;
    private String desc;

    HTPcFlag(String flag, String desc) {
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
