package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 *  结算方式
 * @Description
 * @Author WJH
 * @Date 2019/02/25
 */
public enum SettleMode {
    PAYMENT("0","代付结算"),
    CHARGE("1","记账结算"),
    ;


    private String code;
    private String name;

    SettleMode(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public static SettleMode getSettleMode(String code) {
        return Stream.of(values()).filter(item -> item.getCode().equals(code)).findFirst().orElse(null);
    }
}
