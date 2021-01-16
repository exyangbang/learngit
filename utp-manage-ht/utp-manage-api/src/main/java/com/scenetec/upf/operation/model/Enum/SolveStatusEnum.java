package com.scenetec.upf.operation.model.Enum;

public enum  SolveStatusEnum {
    /**
     * 未处理
     */
    REFUND_UNTREATED("0", "未处理"),

    /**
     * 已处理
     */
    REFUND_PASS("1", "已处理");

    private String value;
    private String label;

    SolveStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(SolveStatusEnum typeEnum : SolveStatusEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(SolveStatusEnum typeEnum : SolveStatusEnum.values()){
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
