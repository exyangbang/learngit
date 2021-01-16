package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description: 文件类型
 * @Author sheqingquan@scenetec.com
 * @Create 2020/5/15 15:17
 */
public enum FileType {

    /**
     * 文件类型
     */
    JPG("1","jpg"),
    PDF("2","pdf"),
    TXT("3","txt");

    private String code;
    private String type;

    FileType(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public static FileType getFileType(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }
}
