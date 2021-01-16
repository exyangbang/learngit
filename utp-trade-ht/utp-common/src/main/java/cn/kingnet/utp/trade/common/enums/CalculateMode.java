package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 手续费计算方式
 * @Author : linkaigui
 * @Create : 2019/2/22 11:14
 */
public enum CalculateMode {

    MODE1("1","按笔定额"),
    MODE2("2","按固定费率"),
    MODE3("3","按笔定额-区间");

    private String mode;

    private String desc;

    CalculateMode(String mode, String desc) {
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

    public static CalculateMode getCalculateByMode(String mode){
        return Stream.of(values()).filter(item -> item.getMode().equals(mode)).findFirst().orElse(null);
    }
}
