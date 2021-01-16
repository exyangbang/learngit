package com.scenetec.upf.operation.model.Enum;

/**
 * ''WITHDRAW'' ''提现'
 * ''TRANSFER''''平台转账''
 * 'TRANSFER_USER2USER'转账(用户-用户)
 * 'TRANSFER_USER2INDUSTRY' '转账(用户-代付客户平台)''
 * 'SGL_PAYMENT' '单笔实时代付'
 * ''REFUND_ORDERID' '订单退款'
 * ''UPLOAD_ACCOUNT_SETTLE'' '预付费卡清算'
 */
public enum TradeTypeEnum {
    /**
     * 提现
     */
    WITHDRAW("WITHDRAW", "提现"),
    /**
     * 平台转账
     */
    TRANSFER("TRANSFER", "平台转账"),
    /**
     * 转账(用户-用户)
     */
    TRANSFER_USER2USER("TRANSFER_USER2USER", "转账(用户-用户)"),
    /**
     * 转账(用户-代付客户平台)'
     */
    TRANSFER_USER2INDUSTRY("TRANSFER_USER2INDUSTRY", "转账(用户-代付客户平台)"),
    /**
     * 单笔实时代付
     */
    SGL_PAYMENT("SGL_PAYMENT", "单笔实时代付"),
    /**
     * 订单退款
     */
    REFUND_ORDERID("REFUND_ORDERID", "订单退款"),

    FEE_COLLECTION_TRANSFER("FEE_COLLECTION_TRANSFER", "收益账户归集划转"),

    COLLECT_ACCOUNT_WITHDRAW("COLLECT_ACCOUNT_WITHDRAW", "后管归集账户提现"),
    /**
     * 预付费卡清算
     */
    UPLOAD_ACCOUNT_SETTLE("UPLOAD_ACCOUNT_SETTLE", "预付费卡清算"),

    SPLIT_PAYMENT("SPLIT_PAYMENT", "平台分账"),
    /**
     * 平台/子账户分账退款
     */
    SPLIT_PAYMENT_REFUND("SPLIT_PAYMENT_REFUND", "平台/子账户分账退款"),

    SUBACCOUNT_SPLIT_PAYMENT("SUBACCOUNT_SPLIT_PAYMENT", "子账户分账"),

    BALANCE_PAYMENT("BALANCE_PAYMENT", "余额支付"),

    REFUND_BALANCE_PAYMENT("REFUND_BALANCE_PAYMENT", "余额支付退款"),
    ACC_PAYMENT("ACC_PAYMENT", "子账户单笔付款"),
    RANDOM_AMT_PAYMENT_AUTH("RANDOM_AMT_PAYMENT_AUTH", "打款验证");


    private String value;
    private String label;

    TradeTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type) {
        for (TradeTypeEnum typeEnum : TradeTypeEnum.values()) {
            if (typeEnum.value.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getValue(String type) {
        for (TradeTypeEnum typeEnum : TradeTypeEnum.values()) {
            if (typeEnum.value.equals(type)) {
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
