package cn.kingnet.utp.trade.common.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月20日
 */

public enum BatchStatus {
    UPLOAD_SUCCESS("0", "上送文件成功"),
    UPLOAD_FAILURE("9", "上送文件失败"),
    DOWNLOAD_ENABLE("1", "已能够下载批次文件"),
    DOWNLOAD_SUCCESS("2", "已成功下载批次文件"),
    COMPLETED("3", "已处理完批次文件"),;
    private String code;
    private String desc;

    BatchStatus(String code, String desc) {
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
