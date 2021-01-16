//package cn.kingnet.product.account.service.impl;
//
//import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
//import cn.kingnet.utp.trade.common.enums.RedisKey;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * @Description
// * @Author WJH
// * @Date 2020/02/15
// */
//@Service
//public class CommonRedisService {
//
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public RedisTemplate<String, Object> getRedisTemplate() {
//        return this.redisTemplate;
//    }
//
//    /**
//     * 是否存在已上传成功的 外部支付流水订单号
//     */
//    boolean isExistOutSideTransOrderIdByRedis(String industryCode, String outSideTransOrderId) {
//        return redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId)).hasKey(outSideTransOrderId);
//    }
//
//    /**
//     * 生成 上送外部支付流水成功的 hashKey 每个桶至多10000 拆分 大key 拆分小key 处理
//     */
//    private String genOutSideTransOrderHashKey(String industryCode, String outSideTransOrderId) {
//        return RedisKey.fmtKey(RedisKey.ORDER_VALUE_KEY, industryCode, String.valueOf(Math.abs(outSideTransOrderId.hashCode() % 10000)));
//    }
//
//    /**
//     * 添加上送成功的 外部支付流水订单号
//     */
//    void addOutSideTransOrderByRedis(String industryCode, String outSideTransOrderId, OutsideTransOrder transOrder) {
//        redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId)).putIfAbsent(outSideTransOrderId, transOrder);
//    }
//
//    OutsideTransOrder getOutsideTransOrder(String industryCode, String outSideTransOrderId) {
//        Object obj = redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId)).get(outSideTransOrderId);
//        if (obj == null) {
//            return null;
//        }
//        if (obj instanceof OutsideTransOrder) {
//            return (OutsideTransOrder) obj;
//        } else {
//            //兼容原存储值非OutsideTransOrder对象处理
//        }
//        return null;
//    }
//
//
//    /**
//     * 生成支付订单流水被入金流水关联的 hashKey 10000拆分
//     */
//    private String genTransOrderIdLinkedByIncomeHashKey(String outSideTransOrderId) {
//        return RedisKey.fmtKey(RedisKey.ORDER_INCOME_KEY, String.valueOf(outSideTransOrderId.hashCode() % 10000));
//    }
//
//    /**
//     * 支付流水号是否已关联报备入金流水号
//     */
//    boolean isExistTransOrderIdLinkedIncomeByRedis(String outSideTransOrderId) {
//        return redisTemplate.boundHashOps(genTransOrderIdLinkedByIncomeHashKey(outSideTransOrderId)).hasKey(outSideTransOrderId);
//    }
//
//    /**
//     * 添加支付流水号已关联入金流水
//     */
//    void addTransOrderIdLinkedIncomeByRedis(String outSideTransOrderId) {
//        redisTemplate.boundHashOps(genTransOrderIdLinkedByIncomeHashKey(outSideTransOrderId)).putIfAbsent(outSideTransOrderId, outSideTransOrderId);
//    }
//
//
//    /**
//     * 生成子账户清分客户端流水号idList的 hashKey 10000拆分
//     */
//    private String genSubAccountSettleSplitClientTransIdHashKey(String subAccountSettleSplitClientTransId) {
//        return RedisKey.fmtKey(RedisKey.SUBACCOUNT_CLIENTTRANSID_LIST, String.valueOf(subAccountSettleSplitClientTransId.hashCode() % 10000));
//    }
//
//    /**
//     * 是否存在子账户清分客户端流水号记录
//     */
//    boolean isExistSubAccountSettleSplitClientTransId(String subAccountSettleSplitClientTransId) {
//        return redisTemplate.boundHashOps(genSubAccountSettleSplitClientTransIdHashKey(subAccountSettleSplitClientTransId)).hasKey(subAccountSettleSplitClientTransId);
//    }
//
//    void addSubAccountSettleSplitClientTransId(String subAccountSettleSplitClientTransId, String batchNo) {
//        redisTemplate.boundHashOps(genSubAccountSettleSplitClientTransIdHashKey(subAccountSettleSplitClientTransId)).putIfAbsent(subAccountSettleSplitClientTransId, batchNo);
//    }
//
//
//    /**
//     * 生成子账户多级客户端流水号idList hashKey 10000拆分
//     */
//    private String genSubAccountMultiSettleDetailClientTransIdHashKey(String subAccountMultiSettleDetailClientTransId) {
//        return RedisKey.fmtKey(RedisKey.SUBACCOUNT_MULTI_CLIENTTRANSID_LIST, String.valueOf(subAccountMultiSettleDetailClientTransId.hashCode() % 10000));
//    }
//
//    /**
//     * 是否存在子账户多级清分客户端流水号记录
//     */
//    boolean isExistSubAccountMultiSettleDetailClientTransId(String subAccountMultiSettleDetailClientTransId) {
//        return redisTemplate.boundHashOps(genSubAccountMultiSettleDetailClientTransIdHashKey(subAccountMultiSettleDetailClientTransId)).hasKey(subAccountMultiSettleDetailClientTransId);
//    }
//
//    void addSubAccountMultiSettleDetailClientTransId(String subAccountMultiSettleDetailClientTransId, String batchNo) {
//        redisTemplate.boundHashOps(genSubAccountMultiSettleDetailClientTransIdHashKey(subAccountMultiSettleDetailClientTransId)).putIfAbsent(subAccountMultiSettleDetailClientTransId, batchNo);
//    }
//
//}
