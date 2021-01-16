package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 证件类型枚举
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/17 10:06
 */
public enum CertType {

    ID_CARD("01", "身份证"),
    OFFICIAL_CARD("02", "军官证"),
    PASSPORT("03", "护照"),
    RESIDENCE("04", "户口薄"),
    REENTRY_PERMIT("05", "回乡证"),
    OTHER_CERT("06", "其他");

    private String type;

    private String desc;

    CertType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static CertType getCertType(String type) {
        return Stream.of(values()).filter(item -> item.getType().equals(type)).findFirst().orElse(null);
    }
}
