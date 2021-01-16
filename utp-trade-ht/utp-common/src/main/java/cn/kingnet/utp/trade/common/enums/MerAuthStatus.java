package cn.kingnet.utp.trade.common.enums;

/**
 * 账户状态
 *
 * @author zhongli
 * @date 2019-03-06
 */
public enum MerAuthStatus {
    /**
     * 商户审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
     */
    PENDING_AUTH(9, "待认证"),
    PENDING_REVIEW(0, "待审核"),
    NORMAL(1, "已认证"),
    TURN_DOWN(2, "审核驳回");
    Integer code;
    String value;

    MerAuthStatus(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByCode(Integer code) {
        for (MerAuthStatus typeEnum : MerAuthStatus.values()) {
            if (typeEnum.code.intValue() == code.intValue()) {
                return typeEnum.getValue();
            }
        }
        return null;
    }

    public static MerAuthStatus getEnum(Integer code) {
        if (code != null) {
            for (MerAuthStatus typeEnum : MerAuthStatus.values()) {
                if (typeEnum.code.intValue() == code.intValue()) {
                    return typeEnum;
                }
            }
        }
        return null;
    }

    public static Integer getCodeByValue(String value) {
        for (MerAuthStatus typeEnum : MerAuthStatus.values()) {
            if (typeEnum.value.equals(value)) {
                return typeEnum.getCode();
            }
        }
        return null;
    }
}
