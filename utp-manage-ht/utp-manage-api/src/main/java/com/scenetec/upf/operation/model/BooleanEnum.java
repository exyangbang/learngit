package com.scenetec.upf.operation.model;

public enum BooleanEnum {

    /**
     * 是
     */
    TRUE(true, 1),
    /**
     * 否
     */
    FALSE(false, 0);

    private boolean isTrue;
    private int index;

    BooleanEnum(boolean isTrue, int index) {
        this.index = index;
        this.isTrue = isTrue;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public int getIndex() {
        return index;
    }

    public static BooleanEnum getByIsTrue(boolean isTrue) {
        for (BooleanEnum each : BooleanEnum.values()) {
            if (isTrue) {
                return each;
            }
        }
        return FALSE;
    }

}
