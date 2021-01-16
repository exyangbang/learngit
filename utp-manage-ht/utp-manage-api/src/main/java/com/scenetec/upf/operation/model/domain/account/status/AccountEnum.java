package com.scenetec.upf.operation.model.domain.account.status;


/**
 * 虚拟账户
 * Created on 2018/7/16
 *（1-行业 2-商户 3-个人 4-手续费收益 5-手续费支出）
 * @author by Benjamin.Huang
 */
public enum AccountEnum {

    /**
     * 1:行业,
     */
    ACCOUNT_INDUSTRY("1", "行业、平台"),
    /**
     * 2:渠道商户,企业
     */
    ACCOUNT_BUSINESS("2", "商户"),
    /**
     * 3:个人,
     */
    ACCOUNT_PERSONAL("3", "个人"),
    /**
     * 4:手续费收入账户
     */
    ACCOUNT_INCOME_FEEACCOUNT("4", "手续费收入账户"),
    /**
     * 5:手续费支出账户
     */
    ACCOUNT_PAY_FEEACCOUNT("5", "手续费支出账户"),
    /**
     * 7.佣金账户Commission
     */
    ACCOUNT_COMMISSION_ACCOUNT("7", "佣金账户"),

    /**
     *   8-个体工商户账户
     */
    PERSONAL_INFO_AUTH("8", "个体工商户账户"),
    /**
     *  待结算账户
     */
    SETTLEMENT_ACCOUNT("9", "待结算账户");

    private String value;
    private String label;

    AccountEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(AccountEnum typeEnum : AccountEnum.values()){
            if(typeEnum.value.equals(type)){
                return true;
            }
        }
        return false;
    }
    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
