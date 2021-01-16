package cn.kingnet.utp.sdk.core.enums;

/**
 * 交易状态
 *
 * @author Administrator on 2018-05-15.
 * @ 创建日期：2018-05-15
 */
public enum TransStatus {

    /**
     * 创建订单
     */
    PRE_CREATE("创建订单"),
    /**
     * 处理中
     */
    PROCESSING("处理中"),
    /**
     * 交易成功
     */
    TRADE_SUCCESS("交易成功"),
    /**
     * 交易失败
     */
    TRADE_FAILURE("交易失败"),
    /**
     * 交易错误|不明确状态
     */
    TRADE_ERROR("交易错误|不明确状态"),
    ;

    TransStatus(String transDesc) {
    }

    private String transDesc;

    public String getTransDesc() {
        return transDesc;
    }

    public static TransStatus resolve(String name) {
        for (TransStatus series : values()) {
            if (name.equals(series.name())) {
                return series;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + name + "]");
    }

    public String getTransDesc(String appendStr) {
        return appendStr == null || appendStr.trim().length() == 0 ? this.getTransDesc() : String.format("%:%", this.getTransDesc(), appendStr);
    }
}
