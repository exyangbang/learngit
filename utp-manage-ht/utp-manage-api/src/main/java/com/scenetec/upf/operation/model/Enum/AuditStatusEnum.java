package com.scenetec.upf.operation.model.Enum;

/***
 * 状态（0-待审核 1-审核通过 2-审核驳回
 */
public enum AuditStatusEnum {
    /**
     * 待审核
     */
    AUDIT_UNTREATED("0", "待审核"),

    /**
     * 审核通过
     */
    AUDIT_PASS("1", "审核通过"),
    /**
     * 审核驳回
     */
    AUDIT_REJECT("2", "审核驳回");

    private String value;
    private String label;

    AuditStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(AuditStatusEnum typeEnum : AuditStatusEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(AuditStatusEnum typeEnum : AuditStatusEnum.values()){
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
