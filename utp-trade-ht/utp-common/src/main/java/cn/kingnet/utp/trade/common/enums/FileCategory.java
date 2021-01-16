package cn.kingnet.utp.trade.common.enums;

/**
 * 文件类别
 */
public enum FileCategory {


    SETTLE_SPLIT("SETTLE_SPLIT_UPLOAD", "清算分账文件上送");

    private String code;
    private String desc;

    FileCategory(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
