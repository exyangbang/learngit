package com.scenetec.upf.operation.model.Enum;


/**
 * @Description :   状态（0-冻结审批通过 1-冻结审批驳回 2-冻结待审核 3-解冻待审核 4-解冻审核驳回 5-解冻审核通过）',,
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum OperationTypeEnum {

    FREEZE_APPROVAL("0", "冻结审批通过"),
    FREEZE_APPROVAL_REJECTED("1", "冻结审批驳回"),
    FREEZE_PENDING_REVIEW("2", "冻结待审核"),
    THAWING_PENDING_REVIEW("3", "解冻待审核"),
    THAWING_AUDIT_REJECTED("4", "解冻审核驳回"),
    THAWING_APPROVAL("5", "解冻审核通过");


    private String value;

    private String label;

    OperationTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type){
        for(OperationTypeEnum typeEnum : OperationTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(OperationTypeEnum typeEnum : OperationTypeEnum.values()){
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
