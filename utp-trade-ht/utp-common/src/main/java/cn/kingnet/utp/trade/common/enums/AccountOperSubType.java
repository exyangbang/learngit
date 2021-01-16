package cn.kingnet.utp.trade.common.enums;

import lombok.Getter;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月10日
 */
@Getter
public enum AccountOperSubType {

    INCOME("1", "打款"),
    PAYMENT("2", "代付"),
    TRANSFER("3", "转账"),
    FEE("4", "手续费"),
    REFUND("5", "退款"),
    REMITTANCE("6", "退汇"),
    ORDER_INCOME("7", "订单通知入金"),
    MANUAL_INCOME("8", "手工入账"),
    OTHER("9", "其他操作"),
    COLLECTION("10", "归集划转"),
    ;

    AccountOperSubType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;


}
