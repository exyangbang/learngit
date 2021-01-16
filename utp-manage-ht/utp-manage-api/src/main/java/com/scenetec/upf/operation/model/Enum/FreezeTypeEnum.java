package com.scenetec.upf.operation.model.Enum;


/**
 * @Description :
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum FreezeTypeEnum {
    FREEZE_TYPE("0", "冻结"),
    FREEZE_TYPE_REJECTED("1", "解冻");


    private String value;

    private String label;

    FreezeTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type){
        for(FreezeTypeEnum typeEnum : FreezeTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(FreezeTypeEnum typeEnum : FreezeTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return typeEnum.label;
            }
        }
        return "";
    }

    public String getCode() {
        return value;
    }

    public String getNo() {
        return label;
    }
}
