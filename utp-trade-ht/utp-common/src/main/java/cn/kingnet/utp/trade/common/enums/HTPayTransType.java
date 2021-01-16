package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description
 * @Author WJH
 * @Date 2019/04/02
 */
public enum HTPayTransType {

    PAYMENT("01", "代付"),
    COLLECTION("02", "代收"),
    TRANSFER("04", "转账"),;
    private String type;
    private String name;

    HTPayTransType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static HTPayTransType resolve(String transType) {
        return Stream.of(values()).filter(o -> o.getType().equals(transType)).findFirst().orElseThrow(() -> new RuntimeException("未知华通交易类型:" + transType));
    }
}
