package cn.kingnet.utp.sdk.core.enums;

/**
 * 账户状态
 *
 * @author zhongli
 * @date 2019-03-06
 */
public enum AccountStatus {
    /**
     * 0未开户 1已开户已绑卡 2已开户未绑卡 3已销户 4冻结
     * 未开户
     */
    NO_OPEN(0, "未开户"),
    OPEN_BIND(1, "已开户已绑卡"),
    OPEN_UNBIND(2, "已开户未绑卡"),
    CANCEL(3, "已销户"),
    FREEZE(4, "冻结");
    Integer code;
    String value;

    AccountStatus(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    public static AccountStatus getEnum(String code) {
        return getEnum(Integer.valueOf(code));
    }

    public static AccountStatus getEnum(Integer code) {
        for (AccountStatus typeEnum : AccountStatus.values()) {
            if (typeEnum.code.intValue() == code.intValue()) {
                return typeEnum;
            }
        }
        return null;
    }


}