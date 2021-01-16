package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description 账户入金订单标识
 * @Author WJH
 * @Date 2019/03/14
 */
public enum AccountOrderStatus {

    INITTIALIZE("0", "未处理"),
    PROCESSING("1", "退款处理中"),
    FREEZED("2", "已冻结"),
    UNFREEZED("3", "已解冻"),
    REFUNDED("4", "已退款"),
    REFUND_FAIL("5", "退款失败"),
    ;
    /**
     *  未处理 仅能 冻结 ->成功：已冻结 失败：未处理
     *  已冻结 可以 解冻[成功状态变更为已解冻；失败状态变更为已冻结] 退款[请求成功状态变更为处理中，回调处理成功状态变更为已退款，处理失败状态变更为已冻结]
     *  已解冻 都不能处理其他操作
     *  已退款 都不能处理其他操作
     */
    String code;
    String desc;

    AccountOrderStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static AccountOrderStatus resolve(String code){
        return Stream.of(values()).filter(o->o.getCode().equals(code)).findFirst().orElse(null);
    }
}
