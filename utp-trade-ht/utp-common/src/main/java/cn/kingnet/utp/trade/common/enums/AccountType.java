package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 描述枚举
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 10:19
 */
public enum AccountType {

    /**
     * 对私账户
     */
    PRIVATE("private", "0","对私账户"),
    /**
     * 对公账户
     */
    PUBLIC("public", "1","对公账户"),

    /**
     * 单位结算卡
     */
    BILLING_CARD("billing_card",  "2","单位结算卡");

    /**
     * 内部账户类型标识字符
     */
    private String code;
    /**
     * 外部系统传入值
     */
    private String value;

    /**
     * 描述
     */
    private String desc;

    AccountType(String code, String value,String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static AccountType getAccountTypeByCode(String code) {
        return Stream.of(values()).filter(item -> item.getCode().equals(code)).findFirst().orElse(null);
    }

    public static AccountType getAccountTypeByOuterValue(String value) {
        return Stream.of(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }


}