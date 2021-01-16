package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 开户模式
 * @Author : <a href="zengxiaobin@scenetec.com">Xiaobin.Zeng</a>
 * @Create : 2020/08/28 15:54
 */
public enum OpenAccountMode {
    BIND(0, "鉴权绑卡时上传图片资料(旧)"),
    OPEN(1, "开户时上传图片资料(新)");
    private Integer code;
    private String value;

    OpenAccountMode(Integer code, String value) {
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
