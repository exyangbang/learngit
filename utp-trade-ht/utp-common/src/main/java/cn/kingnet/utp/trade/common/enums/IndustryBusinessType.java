package cn.kingnet.utp.trade.common.enums;

import java.util.Arrays;

/**
 * @Description 平台业务类型枚举
 * @Author WJH
 * @Date 2019/06/04
 */
public enum IndustryBusinessType {
    SPLIT("1", "分账业务"),
    PAYMENT("2", "代付业务");
    private String type;
    private String name;

    IndustryBusinessType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static IndustryBusinessType resolve(String type) {
        IndustryBusinessType businessType = Arrays.stream(values()).filter(o -> o.getType().equals(type)).findFirst().orElse(null);
        if (businessType == null) {
            throw new RuntimeException("暂不支持该业务类型[" + type + "]");
        }
        return businessType;
    }
}
