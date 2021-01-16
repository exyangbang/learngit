package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 卡折标志
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/17 19:34
 */
public enum CardType {

    CARD("0", "卡"),
    BANKBOOK("1", "存折");

    private String type;
    private String desc;

    CardType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static CardType getCardType(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }
}
