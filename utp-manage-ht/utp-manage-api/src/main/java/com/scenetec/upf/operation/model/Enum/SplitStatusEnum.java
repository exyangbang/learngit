package com.scenetec.upf.operation.model.Enum;

/**
 *上送支付流水已加关联分账标识 0未关联分账 1已关联分账
 */
public enum SplitStatusEnum {
    /**
     * 未处理
     */
    REFUND_UNTREATED("0", "未关联分账"),

    /**
     * 已处理
     */
    REFUND_PASS("1", "已关联分账");

    private String value;
    private String label;

    SplitStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type) {
        for (SplitStatusEnum typeEnum : SplitStatusEnum.values()) {
            if (typeEnum.value.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getValue(String type) {
        for (SplitStatusEnum typeEnum : SplitStatusEnum.values()) {
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
