package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * 资金账户类型
 *
 * @Description
 * @Author WJH
 * @Date 2019/03/21
 */
public enum FundAccType {
    INNER_ACC("1", "内部户"),
    GENERAL_ACC("2", "一般户"),;
    private String type;
    private String desc;

    FundAccType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FundAccType resolve(String type){
        return Stream.of(values()).filter(o->o.getType().equals(type)).findFirst().orElse(null);
    }
}
