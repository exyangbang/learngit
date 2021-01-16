package com.scenetec.upf.operation.model.Enum;


/**
 * @Description :   `account_type` varchar(2) DEFAULT NULL COMMENT '1:内部户，2:一般户',
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum AccountTypeEnum {

    ACCOUNT_GENERAL("2", "一般户"),
    ACCOUNT_INTERNAL("1", "内部户");

    private String value;

    private String label;

    AccountTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(String type){
        for(AccountTypeEnum typeEnum : AccountTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(AccountTypeEnum typeEnum : AccountTypeEnum.values()){
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
