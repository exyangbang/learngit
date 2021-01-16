package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 平台客户信息审核状态
 * @Author WJH
 * @Date 2019/04/03
 */
public enum AuditStatus {

    WAITING("0", "待审核"),
    APPROVED("1", "审核通过"),
    REJECT("2", "审核驳回")
    ;


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
