package com.scenetec.upf.operation.model.Enum;

/**
* 处理标志
 */
public enum ProcessingMarkEnum {
    /**
     *创建订单
     */
    PRE_UNF("0", "未处理"),
    /**
     * 处理中
     */
    PRE_HANDLE("1", "已经处理");

    private String value;
    private String label;

    ProcessingMarkEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(ProcessingMarkEnum typeEnum : ProcessingMarkEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(ProcessingMarkEnum typeEnum : ProcessingMarkEnum.values()){
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
