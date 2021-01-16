package com.scenetec.upf.operation.model.Enum;

/***
 *
 */
public enum ChannelKeyEnum {
    /**
     * 人行大小额 Pedestrian
     */
    PENDESTRIAN("0001", "人行大小额"),

    /**
     * 银联代付（实时划账） Real-time billing
     */
    REAL_TIME_BILLING("0002", "银联代付（实时划账）"),
    /**
     * 银联代付（事后划账） Afterwards Payment
     */
    AFTERWARDS_PAYMENT("0004", "银联代付（事后划账）");

    private String value;
    private String label;

    ChannelKeyEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(ChannelKeyEnum typeEnum : ChannelKeyEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(ChannelKeyEnum typeEnum : ChannelKeyEnum.values()){
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
