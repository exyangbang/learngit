package cn.kingnet.utp.trade.common.enums;

import java.util.Arrays;

/**
 * @Description : 描述
 * @Author : linkaigui
 * @Create : 2019/2/25 13:42
 */
public enum RedisKey {

    /**
     * 帐号编号序号KEY
     */
    ACCOUNT_NO_SEGMENT_KEY,

    /**
     * 回调通知列表KEY
     */
    CALLBACK_NOTICE_ZSET_KEY,
    CALLBACK_NOTICE_HASH_KEY,

    /**
     * 渠道每日交易限额
     */
    CHANNEL_DAILY_AMOUNT_HASH_KEY,
    /**
     * 平台商户(客户号)每日交易限额
     */
    INDUSTRY_DAILY_AMOUNT_HASH_KEY,
    /**
     * 客户号子账户单日交易限额
     */
    SUBACCOUNT_DAILY_AMOUNT_HASH_KEY,
    /**
     * 交易类电子回单 & 开户类电子回单
     */
    ELE_RECEIPT_NO_SEGMENT_KEY,

    /**
     * redis 发布华通回调内容消息 topic
     */
    TOPIC_HT_CALLBACK_RESP,
    /**
     * 支付流水关联子账户入金流水
     */
    ORDER_INCOME_KEY,
    /**
     * 成功的外部支付流水
     */
    ORDER_VALUE_KEY,
    /**
     * 子账户清分客户端流水号idList
     */
    SUBACCOUNT_CLIENTTRANSID_LIST,
    /**
     * 子账户多级客户端流水号idList
     */
    SUBACCOUNT_MULTI_CLIENTTRANSID_LIST,
    /**
     * 子账户Tn分账处理
     */
    SUBACCOUNT_TN_SPLIT,
    /**
     * 客户号关联基本信息：utp:BASIC_INDUSTRY_CONFIG:industryCode
     */
    BASIC_INDUSTRY_CONFIG,
    /**
     * 其他通用或临时
     */
    COMMON,
    /**
     * 子账户连续相同金额交易次数阈值
     */
    SAME_CASH_MAX_AMT,
    /**
     * 簿记交易流水：客户端，服务端
     */
    TRANS_ID,
    /**
     * 实体账户资金明细 核心流水号
     */
    CORE_NO,
    ;


    private static final String PREFIX = "UTP:";

    public static String fmtKey(RedisKey redisKey, String... subKey) {
        StringBuilder stringBuilder = new StringBuilder(PREFIX).append(redisKey.name());
        Arrays.stream(subKey).forEach(sk -> stringBuilder.append(":").append(sk));
        return stringBuilder.toString();
    }

    public String fmtKey(String... subKey) {
        return fmtKey(this, subKey);
    }


}
