package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 借贷标记枚举
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/18 10:06
 */
public enum DCType {

    LEND_CARD("0", "借记卡"),
    LOAN_CARD("1", "贷记卡");

    private String type;
    private String desc;

    DCType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static DCType getDCType(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }
}
