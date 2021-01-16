package cn.kingnet.utp.sdk.core.enums;

/** 用户账户审核状态 审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
 * @author zhongli
 * @date 2019-03-06
 *
 */
public enum MerAuthStatus {
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


    public static MerAuthStatus getEnum(Integer code) {
        for (MerAuthStatus typeEnum : MerAuthStatus.values()) {
            if (typeEnum.code.intValue() == code.intValue()) {
                return typeEnum;
            }
        }
        return null;
    }
    public static MerAuthStatus getEnum(String code) {
      return getEnum(Integer.parseInt(code));
    }

}
