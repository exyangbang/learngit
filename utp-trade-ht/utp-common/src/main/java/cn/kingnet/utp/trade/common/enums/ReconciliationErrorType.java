package cn.kingnet.utp.trade.common.enums;

import org.springframework.lang.Nullable;

/**对账差错类型
 * @author zhongli
 * @date 2018/9/13
 */
public enum ReconciliationErrorType {

    /**
     * 如果银联全渠道的对账文件里该笔成功，本地系统该笔成功；状态一致。
     */
    A("a"),
    /**
     * 如果银联全渠道的对账文件里该笔成功，本地系统无记录
     */
    B("b"),
    /**
     * 如果银联全渠道的对账文件里该笔成功，本地系统该笔失败
     */
    C("c"),
    /**
     * 如果银联全渠道的对账文件里该笔成功，本地系统该笔处理中
     */
    D("d"),
    /**
     * 如果本地系统该笔成功，在银联全渠道的对账文件里找不到交易记录
     */
    E("e"),
    /**
     * 如果本地系统该笔状态“处理中”，在银联全渠道的对账文件里找不到交易记录
     */
    F("f"),
    /**
     * 交易信息不匹配
     */
    G("g");


    private final String code;

    ReconciliationErrorType(String code) {
        this.code = code;
    }

    public static ReconciliationErrorType valueOfCode(String code) {
        ReconciliationErrorType status = resolve(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Nullable
    public static ReconciliationErrorType resolve(String code) {
        for (ReconciliationErrorType status : values()) {
            if (status.value().equals(code)) {
                return status;
            }
        }
        return null;
    }

    public String value() {
        return this.code;
    }
}
