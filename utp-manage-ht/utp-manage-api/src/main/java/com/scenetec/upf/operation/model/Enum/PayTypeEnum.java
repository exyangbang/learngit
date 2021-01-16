package com.scenetec.upf.operation.model.Enum;

/**
 `pay_mode` '支付方式|0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式',
 */
public enum PayTypeEnum {

    PRE_CREATE("0", "支付宝"),
    /**
     *
     */
    PROCESSING("1", "微信"),
    /**
     *
     */
    TRADE_SUCCESS("2", "银联"),
    /**
     *
     */
    TRADE_FAILURE("3", "无正向支付流水"),
    /**
     *
     */
    TRADE_ERROR("9", "其他支付方式"),

    CUSTOMER_INITIALIZATION("99", "客户初始化");

    private String value;
    private String label;

    PayTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(PayTypeEnum typeEnum : PayTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(PayTypeEnum typeEnum : PayTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return typeEnum.label;
            }
        }
        return "";
    }
    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
