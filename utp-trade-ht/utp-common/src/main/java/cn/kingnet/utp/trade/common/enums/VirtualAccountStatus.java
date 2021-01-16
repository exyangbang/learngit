package cn.kingnet.utp.trade.common.enums;


import java.util.Arrays;

/**
 * @Description 虚拟账户类型|本地账户体系内的账户类型
 * @Author WJH
 * @Date 2018/11/28
 */
public enum VirtualAccountStatus {
    //状态（0-冻结 1-正常 2-销户）
    FREEZE("0", "冻结"),
    NORMAL("1", "正常"),
    CANCEL("2", "销户");


    private String type;
    private String name;

    VirtualAccountStatus(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static boolean isNormal(String type) {
        return VirtualAccountStatus.NORMAL.getType().equals(type);
    }

    public static VirtualAccountStatus resolve(String type) {
        return Arrays.stream(values()).filter(v -> v.getType().equals(type)).findFirst().orElseGet(() -> null);
    }

    public boolean isNormal() {
        return this == VirtualAccountStatus.NORMAL;
    }

}
