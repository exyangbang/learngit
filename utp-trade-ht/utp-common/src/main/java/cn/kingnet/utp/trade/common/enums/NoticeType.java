package cn.kingnet.utp.trade.common.enums;

/**
 * @Description 通知类型
 * @Author WJH
 * @Date 2019/03/17
 */
public enum NoticeType {
    INDUSTRY_ACC_INCOME("01","平台入金通知"),
    REEXCHANGE_FLOW("02","退汇流水通知"),
    SECONDARY_ACC_INCOME("03","二级账户入金通知"),
    AUTH_BIND_STATUS_CHANGE("04","小额打款验证绑卡状态变化通知"),
    ;
    private String type;
    private String desc;

    NoticeType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
