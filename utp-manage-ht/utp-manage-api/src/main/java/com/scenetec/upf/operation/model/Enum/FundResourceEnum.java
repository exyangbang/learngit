package com.scenetec.upf.operation.model.Enum;

public enum FundResourceEnum {
    GENERAL_PAYMENT("00","一般性付款"),
    DOMESTIC_TRANSFER("01","境内转账"),
    CASH_PAYMENT("02","现金付款"),
    MARKETING_CASH_BACK("03","营销返现"),
    MERCHANT_FUND_SETTLEMENT("04","商户资金结算"),
    AGRICULTURAL_ACQUISITION("05","农林牧副渔收购"),
    CROSS_BORDER_TAX_REFUND("06","跨境退税"),
    CROSS_BORDER_REMITTANCE("07","跨境汇款"),
    REDEMPTION_OF_INVESTMENT("11","投资赎回"),
    GOVERNMENT_SERVICES("12","政府服务"),
    CREDIT_CARD_PAYMENT("15","信用卡还款"),
    WITHDRAWAL_FROM_INDIVIDUAL_PAYMENT_ACCOUNT("16","个人支付账户提现"),
    WITHDRAWAL_FROM_UNIT_PAYMENT_ACCOUNT("17","单位支付账户提现"),
    INSURANCE_CLAIMS("18","保险理赔/分红"),
    SALARY_PAYMENT("19","薪资发放"),
    CREDIT_GRANTING("20","信贷发放"),
    TRANSFER_VERIFICATION("21","转账验证");
    private String code;
    private String label;
     FundResourceEnum(String code,String label){
        this.code = code;
        this.label = label;
    }
    public static boolean contains(String code){
        for(FundResourceEnum typeEnum : FundResourceEnum.values()){
            if(typeEnum.code.equals(code)){
                return true;
            }
        }
        return false;
    }
    public static String getValue(String type){
        for(FundResourceEnum typeEnum : FundResourceEnum.values()){
            if(typeEnum.label.equals(type)){
                return typeEnum.label;
            }
        }
        return "";
    }

    public String getCode() {
        return label;
    }

    public String getLabel() {
        return label;
    }
}
/*
00	一般性付款	发送方为单位客户，无其他更准确的业务产品标识可适用时使用
        01	境内转账	付款方使用银行（卡）账户通过网点柜面、网上银行、手机银行或其他移动应用等渠道（ ATM 除外）发起的转账
        02	现金付款	现金存入
        03	营销返现	商户营销
        04	商户资金结算	收单机构向其商户划付结算资金
        05	农林牧副渔收购	助农、惠农等场景下的农林牧副渔收购业务
        06	跨境退税	银联卡跨境退税业务
        07	跨境汇款	银联卡跨境汇款业务
        11	投资赎回	基金、信托、黄金等投资理财产品的资金赎回
        12	政府服务	社保金、公积金、养老金、人才补贴等政府发起的资金发放
        15	信用卡还款	收款卡为信用卡账户的交易场景
        16	个人支付账户提现	个人客户将其支付账户资金回提至银行账户
        17	单位支付账户提现	单位客户将其支付账户资金回提至银行账户
        18	保险理赔/分红	保险理赔或保险红利发放
        19	薪资发放	工资、津贴、奖金、劳务报酬等薪资发放
        20	信贷发放	消费贷款、住房贷款等贷款发放
        21	转账验证	用于收款账户正确性

 */