package com.scenetec.upf.operation.model.Enum;

/**
 *
 */
public enum ObjTypeEnum {
    /**
     * 个人
     */
    OBJ_TYPE_PER("1", "个人"),

    /**
     * 企业
     */
    OBJ_TYPE_ENT("2", "企业");

    private String value;
    private String label;

    ObjTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type) {
        for (ObjTypeEnum typeEnum : ObjTypeEnum.values()) {
            if (typeEnum.value.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getValue(String type) {
        for (ObjTypeEnum typeEnum : ObjTypeEnum.values()) {
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
