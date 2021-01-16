package cn.kingnet.utp.trade.common.enums;

import java.util.Arrays;

/**
 * @Description 余额支付及余额支付退款 中的 余额支付类型
 * @Author WJH
 * @Date 2020/03/10
 */
public enum PaymentType {
    USER2INDUSTRY("0", "用户转平台"),
    USER2USER("1", "用户转用户");
    private String type;
    private String name;

    PaymentType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static PaymentType resolve(String type) {
        return Arrays.stream(values()).filter(o -> o.getType().equals(type)).findFirst().orElse(null);
    }

    public String info(){return String.format("[%s:%s]",this.type,this.name);}
}
