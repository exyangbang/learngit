package com.scenetec.upf.operation.model.Enum;

public enum AccountStatusEnum {

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

    AccountStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
