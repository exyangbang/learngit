package com.scenetec.upf.operation.model.Enum;

import com.scenetec.upf.operation.model.domain.account.status.AccountEnum;

/**
 * 'PRE_CREATE' '创建订单'
 * 'PROCESSING''处理中'
 * 'TRADE_SUCCESS' '交易成功'
 * 'TRADE_FAILURE''交易失败'
 * 'TRADE_ERROR' '处理中'
 */
public enum  TransStatusEnum {
    /**
     *创建订单
     */
    PRE_CREATE("PRE_CREATE", "创建订单"),
    /**
     * 处理中
     */
    PROCESSING("PROCESSING", "处理中"),
    /**
     * 交易成功,
     */
    TRADE_SUCCESS("TRADE_SUCCESS", "交易成功"),
    /**
     * 交易失败
     */
    TRADE_FAILURE("TRADE_FAILURE", "交易失败"),
    /**
     *
     */
    TRADE_ERROR("TRADE_ERROR", "处理异常");

    private String value;
    private String label;

    TransStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(TransStatusEnum typeEnum : TransStatusEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(TransStatusEnum typeEnum : TransStatusEnum.values()){
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
