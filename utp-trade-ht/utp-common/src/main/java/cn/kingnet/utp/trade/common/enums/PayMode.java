package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description
 * @Author WJH
 * @Date 2019/05/29
 */
public enum PayMode {
    ALIPAY("0", "支付宝支付"),
    WEPAY("1", "微信支付"),
    UNIONPAY("2", "银联支付"),
    NOPAYFLOW("3", "无正向支付流水"),
    MIXPAYFLOW("4", "虚拟融合支付流水"),
    OTHERPAY("9", "其他支付方式"),
    CUSTOMER_INIT("99", "客户初始化"),
    ;
    private String type;
    private String name;

    PayMode(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static PayMode getPayMode(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }

}
