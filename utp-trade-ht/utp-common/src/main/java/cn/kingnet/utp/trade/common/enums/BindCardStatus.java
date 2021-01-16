package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description
 * @Author WJH
 * @Date 2020/03/23
 */
public enum BindCardStatus {
    NORMAL("0", "正常"),
    PROCESSING("1", "打款处理中"),
    FAILURE("2", "打款失败"),
    WAITING_AUTH("3", "打款成功，待验证"),
    AUTH_FAILURE("4", "验证失败"),
    FROZEN("5", "冻结"),
    UN_BIND("6", "解绑"),
    ;

    BindCardStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private String status;
    private String desc;

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }


    public static BindCardStatus getBindCardStatus(String status) {
        return Stream.of(values()).filter(item -> item.getStatus().equals(status)).findFirst().orElse(null);
    }
}
