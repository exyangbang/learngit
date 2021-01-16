package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : remark转换pdf路径
 * @Author : linkaigui
 * @Create : 2020/7/10 15:07
 */
public enum ConvertFlag {

    NOT_CONVERT(0, "未转换"),
    CONVERTED(1, "已转换"),
    CONVERT_FAIL(2, "转换失败"),
    UN_CONVERT(3, "无需转换");

    private int flag;
    private String desc;

    ConvertFlag(int flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public int getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }
}
