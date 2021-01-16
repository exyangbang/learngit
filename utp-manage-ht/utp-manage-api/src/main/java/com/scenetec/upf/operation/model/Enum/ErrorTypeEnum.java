package com.scenetec.upf.operation.model.Enum;

/**
* 差错类型
 * 'b''渠道多流水'
 * 'c''平台状态失败，渠道成功'
 * 'd''平台状态未知，渠道成功'
 * 'e'平台多流水'
 * 'f''平台状态未知，渠道失败'
 * 'g''交易信息不匹配'
 */
public enum ErrorTypeEnum {
    /**
     *渠道多流水
     */
    ERROR_MORE("b", "渠道多流水"),
    /**
     * 平台状态失败，渠道成功
     */
    ERROR_SUCCESS("c", "平台状态失败，渠道成功"),
    /**
     * 平台状态未知，渠道成功,
     */
    ERROR_QUDAO_SUCCESS("d", "平台状态未知，渠道成功"),
    /**
     * 平台多流水
     */
    ERROR_PT_MORE("e", "平台多流水"),
    /**
     * 平台状态未知，渠道失败
     */
    ERROR_QD_FILE("f", "平台状态未知，渠道失败"),
    /**
     * 交易信息不匹配
     */
    ERROR_MESSAGE("g", "交易信息不匹配");

    private String value;
    private String label;

    ErrorTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(ErrorTypeEnum typeEnum : ErrorTypeEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(ErrorTypeEnum typeEnum : ErrorTypeEnum.values()){
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
