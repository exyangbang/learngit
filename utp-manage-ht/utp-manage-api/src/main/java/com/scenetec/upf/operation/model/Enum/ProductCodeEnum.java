package com.scenetec.upf.operation.model.Enum;

/**
 * ''ACCOUNT'' ''代付'
 * ''PRECARD''''预付汇卡''
 */
public enum ProductCodeEnum {
    /**
     *提现
     */
    ACCOUNT("ACCOUNT", "代付"),
    /**
     * 平台转账
     */
    PRECARD("PRECARD", "平台预付汇卡转账");

    private String value;
    private String label;

    ProductCodeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(ProductCodeEnum typeEnum : ProductCodeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(ProductCodeEnum typeEnum : ProductCodeEnum.values()){
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
