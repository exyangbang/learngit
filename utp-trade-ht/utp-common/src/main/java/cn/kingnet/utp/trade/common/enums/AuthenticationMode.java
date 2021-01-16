package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 描述枚举
 * @Author : linkaigui
 * @Create : 2020/2/14 11:57
 */
public enum AuthenticationMode {

    THREE("3", "三要素认证"),
    FOUR("4", "四要素认证");

    private String mode;
    private String desc;

    AuthenticationMode(String mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    public String getMode() {
        return mode;
    }

    public String getDesc() {
        return desc;
    }

    public static AuthenticationMode getAuthenticationMode(String mode) {
        return Stream.of(values()).filter(item -> item.getMode().equals(mode)).findFirst().orElse(null);
    }
}
