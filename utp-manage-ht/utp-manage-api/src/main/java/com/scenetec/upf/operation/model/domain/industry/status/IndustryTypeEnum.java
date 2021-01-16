package com.scenetec.upf.operation.model.domain.industry.status;


/**
 * 证书类型枚举
 * Created on 2018/7/16
 *
 * @author by Benjamin.Huang
 */
public enum IndustryTypeEnum {

    /**
     * 1:渠道商户,
     */
    CHAN_BUSINESS("1", "渠道商户"),

    /**
     * 4:手续费收入账户
     */
    CHAN_INCOME_FEEACCOUNT("4", "手续费收入账户"),
    /**
     * 5:手续费支出账户 industryTypeImputation
     */
    CHAN_PAY_FEEACCOUNT("5", "手续费支出账户"),
    /**
     * 6:归集账户
     */
    CHAN_IMPUTATION_FEEACCOUNT("6", "归集账户"),
    /**
     * 10:小额打款支出账户
     */
    SMALL_AMOUNT_PAYMENT_ACCOUNT("10", "小额打款支出账户");

    private String value;
    private String label;

    IndustryTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static boolean contains(String type){
        for(IndustryTypeEnum typeEnum : IndustryTypeEnum.values()){
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
