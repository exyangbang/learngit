package cn.kingnet.utp.trade.common.enums;


/**
 * @Description 虚拟账户类型|本地账户体系内的账户类型
 * @Author WJH
 * @Date 2018/11/28
 */
public enum VirtualAccountType {

    INDUSTRY("1", "平台账户"),
    MERCHANT("2", "商户账户"),
    PERSON("3", "个人账户"),
    FEEINCOME("4", "手续费收益账户"),
    FEEOUTCOME("5", "手续费支出账户"),
    COLLECTION("6", "归集账户"),
    BROKERAGE("7", "佣金账户"),
    SELFEMPLOYED("8", "个体工商户"),
    SETTLEACCOUNT("9", "待结算账户"),
    AUTHOUTCOME("10", "小额打款支出账户"),
    ;


    private String type;
    private String desc;

    VirtualAccountType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static VirtualAccountType resolve(String type) {
        for (VirtualAccountType cur : values()) {
            if (cur.getType().equals(type)) {
                return cur;
            }
        }
        throw new RuntimeException(String.format("未知虚账户类型:%s", type));
    }


    /**
     * 子账户
     * @param type
     * @return
     */
    public static boolean isSubAccount(String type) {
        VirtualAccountType vType = resolve(type);
        if (vType == MERCHANT || vType == PERSON || vType == SELFEMPLOYED || vType == BROKERAGE || vType == SETTLEACCOUNT) {
            return true;
        }
        return false;
    }

    /**
     * 功能性账户
     * @param type
     * @return
     */
    public static boolean isFunctionAccount(String type) {
        VirtualAccountType vType = resolve(type);
        if (vType == INDUSTRY || vType == FEEINCOME || vType == FEEOUTCOME || vType == COLLECTION || vType == AUTHOUTCOME) {
            return true;
        }
        return false;
    }

}
