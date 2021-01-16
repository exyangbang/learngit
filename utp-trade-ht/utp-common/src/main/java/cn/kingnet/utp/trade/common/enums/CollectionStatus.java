package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 归集划转状态
 * @Author WJH
 * @Date 2019/08/22
 */
public enum CollectionStatus {
    UN_COLLECT("0", "未归集划转"),
    COLLECTED("1", "已归集划转"),
    MANUAL_CHECK("9", "待人工核查");

    CollectionStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private String status;
    private String desc;

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
