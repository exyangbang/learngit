package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 收费模式
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/21 15:29
 */
public enum ChargeMode {

    INNER("1","内扣"),
    BUCKLE("2","外扣");

    private String mode;

    private String desc;

    ChargeMode(String mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ChargeMode resolve(String mode){
        return Stream.of(values()).filter(o->o.getMode().equals(mode)).findFirst().orElse(null);
    }
}
