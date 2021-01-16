package com.scenetec.upf.operation.model.Enum;

/**
 '归集划款状态 0未划转 1已划转',9人工核查
 */
public enum CollectionStatusEnum {
    /**
     *Unscrambled
     */
    UNSCRAMBLED("0", "未划转"),
    /**
     *transferred
     */
    TRANSFERRED("1", "已划转"),
    /**
     *Manual verification
     */
    MANUAL_VERIFICATION("9", "人工核查");

    private String value;
    private String label;

    CollectionStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(CollectionStatusEnum typeEnum : CollectionStatusEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(CollectionStatusEnum typeEnum : CollectionStatusEnum.values()){
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
