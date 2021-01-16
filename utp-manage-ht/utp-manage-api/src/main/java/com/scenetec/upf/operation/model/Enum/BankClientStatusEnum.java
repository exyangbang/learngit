package com.scenetec.upf.operation.model.Enum;
//"银行客户号关联标识0开户未上报 1开户已上报 2更新未上报 3更新已上报 4销户未上报")
public enum BankClientStatusEnum {
    BANK_CLIENT_OPEN_UN_REPORT("0", "开户未上报"),
    BANK_CLIENT_OPEN_REPORT("1", "开户已上报"),
    BANK_CLIENT_UPDATE_UN_REPORT("2", "更新未上报"),
    BANK_CLIENT_UPDATE_REPORT("3", "更新已上报"),
    BANK_CLIENT_CANCEL_REPORT("4", "销户未上报");

    private String value;
    private String label;

    BankClientStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(BankClientStatusEnum typeEnum : BankClientStatusEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(BankClientStatusEnum typeEnum : BankClientStatusEnum.values()){
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
