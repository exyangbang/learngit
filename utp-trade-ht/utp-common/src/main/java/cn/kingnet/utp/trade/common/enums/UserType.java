package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 客户类型
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/31 17:19
 */
public enum UserType {

    ONE("0", "个人"),
    MER("1", "商户");

    private String type;

    private String name;

    UserType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static UserType getUserType(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }
}
