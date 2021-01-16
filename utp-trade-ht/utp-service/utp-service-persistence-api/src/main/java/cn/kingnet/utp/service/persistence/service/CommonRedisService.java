package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/15
 */
public class CommonRedisService {

    private RedisTemplate<String, Object> redisTemplate;

    public CommonRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        Assert.notNull(this.redisTemplate, () -> "redisTemplate 注入失败");
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return this.redisTemplate;
    }

    /**
     * 是否存在已上传成功的 外部支付流水订单号
     */
    public boolean isExistOutSideTransOrderIdByRedis(String industryCode, String outSideTransOrderId) {
        boolean exists = redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId, false)).hasKey(outSideTransOrderId);
        return exists ? true : redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId, true)).hasKey(outSideTransOrderId);
    }

    /**
     * 生成 上送外部支付流水成功的 hashKey 每个桶至多10000 拆分 大key 拆分小key 处理
     */
    public String genOutSideTransOrderHashKey(String industryCode, String outSideTransOrderId, boolean oldKeyMode) {
        if (oldKeyMode) {
            return RedisKey.fmtKey(RedisKey.ORDER_VALUE_KEY, String.valueOf(outSideTransOrderId.hashCode() % 10000));
        }
        return RedisKey.fmtKey(RedisKey.ORDER_VALUE_KEY,"NEW", industryCode, String.valueOf(Math.abs(outSideTransOrderId.hashCode() % 10000)));
    }

    /**
     * 添加上送成功的 外部支付流水订单号
     */
    public void addOutSideTransOrderByRedis(String industryCode, String outSideTransOrderId, OutsideTransOrder transOrder) {
        redisTemplate.boundHashOps(genOutSideTransOrderHashKey(industryCode, outSideTransOrderId, false)).put(outSideTransOrderId, transOrder);
    }

    /**
     * 生成支付订单流水被入金流水关联的 hashKey 10000拆分
     */
    private String genTransOrderIdLinkedByIncomeHashKey(String industryCode, String outSideTransOrderId, boolean oldKeyMode) {
        if (oldKeyMode) {
            return RedisKey.fmtKey(RedisKey.ORDER_INCOME_KEY, String.valueOf(outSideTransOrderId.hashCode() % 10000));
        }
        return RedisKey.fmtKey(RedisKey.ORDER_INCOME_KEY, industryCode, String.valueOf(Math.abs(outSideTransOrderId.hashCode() % 10000)));
    }

    /**
     * 支付流水号是否已关联报备入金流水号
     */
    public boolean isExistTransOrderIdLinkedIncomeByRedis(String industryCode, String outSideTransOrderId) {
        boolean exists = redisTemplate.boundHashOps(genTransOrderIdLinkedByIncomeHashKey(industryCode, outSideTransOrderId, false)).hasKey(outSideTransOrderId);
        return exists ? true : redisTemplate.boundHashOps(genTransOrderIdLinkedByIncomeHashKey(industryCode, outSideTransOrderId, true)).hasKey(outSideTransOrderId);
    }

    /**
     * 添加支付流水号已关联入金流水
     */
    public void addTransOrderIdLinkedIncomeByRedis(String industryCode, String outSideTransOrderId) {
        redisTemplate.boundHashOps(genTransOrderIdLinkedByIncomeHashKey(industryCode, outSideTransOrderId, false)).putIfAbsent(outSideTransOrderId, outSideTransOrderId);
    }


    /**
     * 生成子账户清分客户端流水号idList的 hashKey 10000拆分
     */
    private String genSubAccountSettleSplitClientTransIdHashKey(String subAccountSettleSplitClientTransId) {
        return RedisKey.fmtKey(RedisKey.SUBACCOUNT_CLIENTTRANSID_LIST, String.valueOf(subAccountSettleSplitClientTransId.hashCode() % 10000));
    }

    /**
     * 是否存在子账户清分客户端流水号记录
     */
    public boolean isExistSubAccountSettleSplitClientTransId(String subAccountSettleSplitClientTransId) {
        return redisTemplate.boundHashOps(genSubAccountSettleSplitClientTransIdHashKey(subAccountSettleSplitClientTransId)).hasKey(subAccountSettleSplitClientTransId);
    }

    public void addSubAccountSettleSplitClientTransId(String subAccountSettleSplitClientTransId, String batchNo) {
        redisTemplate.boundHashOps(genSubAccountSettleSplitClientTransIdHashKey(subAccountSettleSplitClientTransId)).putIfAbsent(subAccountSettleSplitClientTransId, batchNo);
    }


    /**
     * 生成子账户多级客户端流水号idList hashKey 10000拆分
     */
    private String genSubAccountMultiSettleDetailClientTransIdHashKey(String subAccountMultiSettleDetailClientTransId) {
        return RedisKey.fmtKey(RedisKey.SUBACCOUNT_MULTI_CLIENTTRANSID_LIST, String.valueOf(subAccountMultiSettleDetailClientTransId.hashCode() % 10000));
    }

    /**
     * 是否存在子账户多级清分客户端流水号记录
     */
    public boolean isExistSubAccountMultiSettleDetailClientTransId(String subAccountMultiSettleDetailClientTransId) {
        return redisTemplate.boundHashOps(genSubAccountMultiSettleDetailClientTransIdHashKey(subAccountMultiSettleDetailClientTransId)).hasKey(subAccountMultiSettleDetailClientTransId);
    }

    public void addSubAccountMultiSettleDetailClientTransId(String subAccountMultiSettleDetailClientTransId, String batchNo) {
        redisTemplate.boundHashOps(genSubAccountMultiSettleDetailClientTransIdHashKey(subAccountMultiSettleDetailClientTransId)).putIfAbsent(subAccountMultiSettleDetailClientTransId, batchNo);
    }

}
