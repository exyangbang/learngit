package com.scenetec.upf.operation.model.Enum;

/**
 * @Description :
 * @Author : <a href="zengxiaobin@scenetec.com">Xiaobin.Zeng</a>
 * @Create : 2020/09/01 16:12
 */
public enum OpenAccountModeEnum {

    BIND(0, "鉴权绑卡时上传图片资料(旧)"),
    OPEN(1, "开户时上传图片资料(新)");
    private Integer code;
    private String value;

    OpenAccountModeEnum(Integer code, String value) {
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
