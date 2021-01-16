package com.scenetec.upf.operation.model.Enum;

/**
 * 结算方式0=代付结算 1=记账结算
 */
public enum SettleModelEnum {
    /**
     * 代付结算
     */
    SETTLE_MODEL_PAYMENT("0", "代付结算"),

    /**
     * 记账结算 Bookkeeping
     */
    SETTLE_MODEL_BOOKKEEPING("1", "记账结算");

    private String value;
    private String label;

    SettleModelEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type) {
        for (SettleModelEnum typeEnum : SettleModelEnum.values()) {
            if (typeEnum.value.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getValue(String type) {
        for (SettleModelEnum typeEnum : SettleModelEnum.values()) {
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
