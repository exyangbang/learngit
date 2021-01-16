package cn.kingnet.utp.trade.common.enums;

import java.util.Arrays;

/**
 * @Description 华通银行客户号关联状态
 * @Author WJH
 * @Date 2020/05/14
 */
public enum BankClientStatus {

    OPENED_UNREPORTED(0, "开户未上报"),
    OPENED_REPORTED(1, "开户已上报"),
    UPDATED_UNREPORTED(2, "更新未上报"),
    UPDATED_REPORTED(3, "更新已上报"),
    CANCELED_UNREPORTED(4, "销户未上报"),
    ;

    BankClientStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private int status;
    private String desc;

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static BankClientStatus resolve(int status) {
        return Arrays.stream(values()).filter(e -> e.getStatus() == status).findFirst().orElseThrow(() -> new RuntimeException("银行客户号关联状态值非法[" + status + "]"));
    }
}
