package cn.kingnet.utp.trade.common.enums;

import org.springframework.lang.Nullable;

/**
 * 交易状态
 * @author zhongli
 * @date 2018/9/13
 */
public enum TransForClientStatus {

    /**
     * 创建订单
     */
    PRE_CREATE("0100", "创建订单"),
    /**
     * 处理中
     */
    PROCESSING("0200", "处理中"),
    /**
     * 交易成功
     */
    TRADE_SUCCESS("0000", "交易成功"),
    /**
     * 交易失败
     */
    TRADE_FAILURE("0400", "交易失败"),
    /**
     * 交易错误、不明确状态
     */
    TRADE_ERROR("9900", "交易错误、不明确状态");

    private String code;
    private String desc;

    TransForClientStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TransForClientStatus valueOf(TransStatus status) {
        for (TransForClientStatus series : values()) {
            if (status.name().equals(series.name())) {
                return series;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + status + "]");
    }

    @Nullable
    public static TransForClientStatus resolve(String code) {
        for (TransForClientStatus series : values()) {
            if (code.equals(series.getCode())) {
                return series;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
