package com.scenetec.upf.operation.model.Enum;


/**
 * @Description :  “新增”、“修改”、“删除”
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum InduAmtLimitOperationTypeEnum {
    FREEZE_APPROVAL("0", "删除"),
    FREEZE_APPROVAL_REJECTED("1", "修改"),
    FREEZE_PENDING_REVIEW("2", "增加")
    ;


    private String value;

    private String label;

    InduAmtLimitOperationTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type){
        for(InduAmtLimitOperationTypeEnum typeEnum : InduAmtLimitOperationTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(InduAmtLimitOperationTypeEnum typeEnum : InduAmtLimitOperationTypeEnum.values()){
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
