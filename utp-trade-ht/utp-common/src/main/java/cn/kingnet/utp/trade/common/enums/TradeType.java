package cn.kingnet.utp.trade.common.enums;

import org.springframework.lang.Nullable;

/**
 * 交易类型
 *
 * @author Administrator on 2018-05-15.
 * @ 创建日期：2018-05-15
 */
public enum TradeType {

    /**
     * 开户
     */
    OPEN_ACCOUNT("OPEN_ACCOUNT", "个人开户"),
    OPEN_ACCOUNT_ENT("OPEN_ACCOUNT_ENT", "企业开户"),
    NEW_OPEN_ACCOUNT_ENT("NEW_OPEN_ACCOUNT_ENT", "企业开户(京东定制)"),

    /**
     * 销户
     */
    CANCEL("CANCEL", "销户"),

    /**
     * 鉴权绑卡
     */
    BIND("BIND", "个人鉴权绑卡"),

    /**
     * 鉴权绑卡
     */
    BIND_ENT("BIND_ENT", "企业鉴权绑卡"),

    /**
     * 企业证件认证
     */
    AUTH_ENT("AUTH_ENT", "企业证件认证"),

    /**
     * 企业证件认证鉴权绑卡
     */
    AUTH_BIND_ENT("AUTH_BIND_ENT", "企业证件认证鉴权绑卡"),
    NEW_AUTH_BIND_ENT("NEW_AUTH_BIND_ENT", "企业鉴权绑定账户(京东定制)"),

    /**
     * 鉴权解绑
     */
    UNBIND("UNBIND", "鉴权解绑"),
    QUERY_ACCOUNT_STATUS("QUERY_ACCOUNT_STATUS", "账户状态查询"),
    AUTH_ENT_STATUS("AUTH_ENT_STATUS", "企业证件认证状态查询"),

    PAYMENT_CHECK("PAYMENT_CHECK", "对公小额打款验证"),
    BIND_CARD_LIST("BIND_CARD_LIST", "绑卡列表查询"),

    WITHDRAW("WITHDRAW", "提现"),
    INNER_WITHDRAW("INNER_WITHDRAW", "系统提现"),
    INNER_QUERY_WITHDRAW("INNER_QUERY_WITHDRAW", "系统提现查询"),
    QUERY_WITHDRAW("QUERY_WITHDRAW", "交易结果查询"),
    FEE_COLLECTION_TRANSFER("FEE_COLLECTION_TRANSFER", "收益账户归集划转"),

    QUERY_BALANCE("QUERY_BALANCE", "余额查询"),
    BATCH_RECORDED("BATCH_RECORDED", "批量账户入账"),
    UPLOAD_SETTLE_SPLIT("UPLOAD_SETTLE_SPLIT", "清分文件上送"),
    QUERY_SETTLE_SPLIT("QUERY_SETTLE_SPLIT", "清分结果查询"),

    DOWNLOAD_SETTLE_DATA("DOWNLOAD_SETTLE_DATA", "平台对账单下载"),
    DOWNLOAD_INDUSTRY_ACCOUNT_DETAIL("DOWNLOAD_INDUSTRY_ACCOUNT_DETAIL", "平台账户明细下载"),
    QUERY_BANK_ACCOUNT_DETAIL("QUERY_BANK_ACCOUNT_DETAIL", "银行实体账户明细查询"),
    QUERY_ACCOUNT_DETAIL("QUERY_ACCOUNT_DETAIL", "虚拟账户资金明细查询"),
    PLAT_ACCOUNT_LIST("PLAT_ACCOUNT_LIST", "平台账户列表查询"),

    TRANSFER("TRANSFER", "平台间转账"),
    TRANSFER_USER2USER("TRANSFER_USER2USER", "转账(用户-用户)"),
    TRANSFER_USER2INDUSTRY("TRANSFER_USER2INDUSTRY", "转账(用户-平台)"),
    SGL_PAYMENT("SGL_PAYMENT", "单笔实时代付"),
    COLLECT_ACCOUNT_WITHDRAW("COLLECT_ACCOUNT_WITHDRAW", "后管归集账户提现"),
    QUERY_TRANSFER("QUERY_TRANSFER", "平台内部转账结果查询"),
    QUERY_INDUSTRY_ACCOUNT_DETAIL("QUERY_INDUSTRY_ACCOUNT_DETAIL", "平台账户资金明细查询"),
    QUERY_USER_ACCOUNT_ORDERID("QUERY_USER_ACCOUNT_ORDERID", "账户订单入金查询"),
    FREEZE_ORDERID("FREEZE_ORDERID", "订单入金金额冻结"),
    UNFREEZE_ORDERID("UNFREEZE_ORDERID", "订单入金金额解冻"),
    REFUND_ORDERID("REFUND_ORDERID", "订单入金退款"),
    QUERY_RETURN_REMITTANCE("QUERY_RETURN_REMITTANCE", "退汇流水查询"),
    FREEZE_BALANCE("FREEZE_BALANCE", "用户账户资金冻结/解冻"),

    UPLOAD_ACCOUNT_ENTRY("UPLOAD_ACCOUNT_ENTRY", "预付费卡入账文件上送"),
    QUERY_ACCOUNT_ENTRY("QUERY_ACCOUNT_ENTRY", "预付费卡入账结果查询"),
    UPLOAD_ACCOUNT_SETTLE("UPLOAD_ACCOUNT_SETTLE", "预付费卡清算文件上送"),
    QUERY_ACCOUNT_SETTLE("QUERY_ACCOUNT_SETTLE", "预付费卡清算结果查询"),

    DOWNLOAD_ELECTRONIC_RECEIPT("DOWNLOAD_ELECTRONIC_RECEIPT", "电子回单下载"),
    VALIDATE_ELECTRONIC_RECEIPT("VALIDATE_ELECTRONIC_RECEIPT", "电子回单验证"),

    UPLOAD_INDUSTRY_PAY_FLOW("UPLOAD_INDUSTRY_PAY_FLOW", "收单交易流水上送"),
    UPLOAD_SPLIT_PAY_FLOW("UPLOAD_SPLIT_PAY_FLOW", "清分-收单补登信息上送"),
    QUERY_INDUSTRY_PAY_FLOW_RESULT("QUERY_INDUSTRY_PAY_FLOW_RESULT", "收单交易流水上送结果查询"),
    QUERY_SPLIT_PAY_FLOW_RESULT("QUERY_SPLIT_PAY_FLOW_RESULT", "清分-收单补登信息上送结果查询"),
    SPLIT_PAYMENT("SPLIT_PAYMENT", "平台分账"),
    SUBACCOUNT_SPLIT_PAYMENT("SUBACCOUNT_SPLIT_PAYMENT", "子账户清分"),
    SPLIT_PAYMENT_REFUND("SPLIT_PAYMENT_REFUND", "平台分账退款"),
    SUBACCOUNT_SPLIT_PAYMENT_REFUND("SUBACCOUNT_SPLIT_PAYMENT_REFUND", "子账户分账退款"),

    OPEN_ACCOUNT_SELFEMPLOYED("OPEN_ACCOUNT_SELFEMPLOYED", "个体工商户开户"),
    AUTH_BIND_SELFEMPLOYED("AUTH_BIND_SELFEMPLOYED", "个体工商户鉴权绑定账户"),
    OPEN_ACCOUNT_SETTLEMENT("OPEN_ACCOUNT_SETTLEMENT", "待结算账户开户"),

    UPLOAD_SUBACCOUNT_PAY_FLOW("UPLOAD_SUBACCOUNT_PAY_FLOW", "子账户入金流水报备"),
    QUERY_SUBACCOUNT_PAY_FLOW_RESULT("QUERY_SUBACCOUNT_PAY_FLOW_RESULT", "子账户入金流水报备结果查询"),
    UPLOAD_SUBACCOUNT_SETTLE_SPLIT("UPLOAD_SUBACCOUNT_SETTLE_SPLIT", "子账户清算分账文件上送"),
    QUERY_SUBACCOUNT_SETTLE_SPLIT("QUERY_SUBACCOUNT_SETTLE_SPLIT", "子账户清算分账结果查询下载"),
    BALANCE_PAYMENT("BALANCE_PAYMENT", "余额支付"),
    BALANCE_PAYMENT_REFUND("BALANCE_PAYMENT_REFUND", "余额支付退款"),
    RANDOM_AMT_PAYMENT_AUTH("RANDOM_AMT_PAYMENT_AUTH", "随机金额打款认证"),
    UPLOAD_SUBACCOUNT_MULTISETTLE_SPLIT("UPLOAD_SUBACCOUNT_MULTISETTLE_SPLIT", "上送子账户多级分账文件"),
    QUERY_SUBACCOUNT_MULTISETTLE_SPLIT("QUERY_SUBACCOUNT_MULTISETTLE_SPLIT", "查询子账户多级分账处理结果"),

    DOWNLOAD_ACCOUNT_ELECTRONIC_RECEIPT("DOWNLOAD_ACCOUNT_ELECTRONIC_RECEIPT", "开户电子回单下载"),
    VALIDATE_ACCOUNT_ELECTRONIC_RECEIPT("VALIDATE_ACCOUNT_ELECTRONIC_RECEIPT", "开户电子回单验证"),

    CHANNEL_INCOME_RECEIPT("CHANNEL_INCOME_RECEIPT", "渠道入金电子回单"),
    ACC_PAYMENT("ACC_PAYMENT", "子账户单笔付款"),

    DOWNLOAD_DAYTX_DATA("DOWNLOAD_DAYTX_DATA", "D日对账文件下载(京东定制化)"),
    DOWNLOAD_BALANCE_DATA("DOWNLOAD_BALANCE_DATA", "子账户日终余额对账单下载(京东定制化)"),

    UPLOAD_INDUSTRY_MIXPAY_FLOW("UPLOAD_INDUSTRY_MIXPAY_FLOW", "融合支付交易流水上送"),

    ;
    private String code;
    private String desc;

    TradeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    @Nullable
    public static TradeType resolve(String name) {
        for (TradeType tradeType : values()) {
            if (tradeType.name().equals(name)) {
                return tradeType;
            }
        }
        return null;
    }

}
