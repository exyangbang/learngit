package cn.kingnet.utp.trade.common.enums;

import org.springframework.lang.Nullable;

/**
 * @author zhongli
 * @date 2018/9/17
 */
public enum TrueOrFalseStatus {

    TRUE("1"),
    FALSE("0");
    private final String code;

    TrueOrFalseStatus(String code) {
        this.code = code;
    }

    public static TrueOrFalseStatus valueOfCode(String code) {
        TrueOrFalseStatus status = resolve(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Nullable
    public static TrueOrFalseStatus resolve(String code) {
        for (TrueOrFalseStatus status : values()) {
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
