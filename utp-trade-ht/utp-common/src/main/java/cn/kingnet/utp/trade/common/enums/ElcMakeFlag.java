package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 生成电子回单
 * @Author : linkaigui
 * @Create : 2020/7/10 15:07
 */
public enum ElcMakeFlag {

    NOT_MAKE("0", "未生成"),
    MAKE("1", "已生成"),
    MAKE_FAIL("2", "生成失败"),
    UN_MAKE("3", "不需要生成");

    private String flag;
    private String desc;

    ElcMakeFlag(String flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }
}
