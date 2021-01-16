package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 华通电子回单模版KEY
 * @Author : linkaigui
 * @Create : 2020/7/6 16:51
 */
public enum ElectronicTemplateKey {

    KHDZHD("KHDZHD","帝网科技客户电子回单"),
    KHDZHD002("KHDZHD002","帝网科技客户电子回单"),
    KLHD("KLHD","帝网科技开立回单");

    private String code;

    private String desc;

    ElectronicTemplateKey(String code, String desc) {
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
