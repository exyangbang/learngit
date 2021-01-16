package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 华通行内的数据区域标识
 * @Author WJH
 * @Date 2019/09/04
 */
public enum DFA {

    RDFA("对私区域"),
    CDFA("对共区域"),

    ;
    private String desc;

    DFA(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
