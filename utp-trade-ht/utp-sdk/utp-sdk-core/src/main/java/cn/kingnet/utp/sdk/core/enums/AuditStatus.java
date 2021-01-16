package cn.kingnet.utp.sdk.core.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2019/04/03
 */
public enum AuditStatus {

    WAITING("0", "待审核"),
    APPROVED("1", "审核通过"),
    REJECT("2", "审核驳回");


    private String auditStatus;
    private String status;
    private String desc;

    AuditStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
