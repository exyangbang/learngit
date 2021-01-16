package com.scenetec.upf.operation.model.Enum;

/**
 * '使用类型(0-普通用途 1-归集用途)
 */
public enum FundUserTypeEnum {
    /**
     * 普通用途 General purpose
     */
    GENERAL_PUPOSE("0", "普通用途"),
    /**
     * 归集用途 Aggregation purpose
     */
    AGGREGATION_PURPOSE("1", "归集用途");

    private String value;
    private String label;

    FundUserTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(FundUserTypeEnum typeEnum : FundUserTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(FundUserTypeEnum typeEnum : FundUserTypeEnum.values()){
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
