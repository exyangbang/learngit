package com.scenetec.upf.operation.model.domain.withdrawalsrecord.status;


/**
 * 证书类型枚举
 * Created on 2018/7/16
 *
 * @author by Benjamin.Huang
 */
public enum WithdrawalsRecordStatusEnum {

    /**
     * 不可用
     */
    FUND_UNAVAILABLE("0", "不可用"),

    /**
     *可用
     */
    CHAN_AVAILABLE("1", "可用");

    private String value;
    private String label;

    WithdrawalsRecordStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
