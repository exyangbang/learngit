package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.redis.redisson.executor.RedisLockExecutor;
import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimit;
import cn.kingnet.utp.service.persistence.entity.bo.IndustryAmountLimitBO;
import cn.kingnet.utp.trade.common.enums.AccountType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;

import static cn.kingnet.utp.trade.common.utils.MathUtil.formatAmt;

/**
 * @Description 代付客户限额服务
 * @Author WJH
 * @Date 2019/07/25
 */
@Slf4j
@Service
public class IndustryAmountLimitService extends RiskParamCategory{


    private final RedisTemplate redisTemplate;
    private final RedisLockExecutor redisLockExecutor;
    private final RedisScript<Long> rateLimitScript;
    private final RedisTemplate<String, String> rateLimitRedisTemplate;

    public IndustryAmountLimitService(RedisTemplate redisTemplate, RedisLockExecutor redisLockExecutor, RedisScript<Long> rateLimitScript, RedisTemplate<String, String> rateLimitRedisTemplate) {
        this.redisLockExecutor = redisLockExecutor;
        this.redisTemplate = redisTemplate;
        this.rateLimitScript = rateLimitScript;
        this.rateLimitRedisTemplate = rateLimitRedisTemplate;
    }


    /**
     * 提现&代付 交易成功时，客户号单日提现&代付交易额累加
     *
     * @param industryCode 客户号
     * @param transAmount  交易金额
     * @param transDate    yyyyMMdd
     */
    public void accumulateIndustryAmount(String industryCode, long transAmount, String transDate) {
        IndustryAmountLimitBO industryAmountLimitBO = this.findIndustryAmountLimitBO(industryCode, transDate);
        this.dailyAccumulateAmount(industryAmountLimitBO, transAmount, CHANNEL_TRANSFER_CATEGORY);
    }

    /**
     * 余额支付 交易成功时，客户号单日余额支付交易额累加
     *
     * @param industryCode 客户号
     * @param transAmount  交易金额
     * @param transDate    yyyyMMdd
     */
    public void accumulateIndustryBalancePayAmount(String industryCode, long transAmount, String transDate) {
        IndustryAmountLimitBO industryAmountLimitBO = this.findIndustryAmountLimitBO(industryCode, transDate);
        this.dailyAccumulateAmount(industryAmountLimitBO, transAmount, INNER_BALANCE_PAY_CATEGORY);
    }

    /**
     * @param industryCode 客户号
     * @param transDate    交易日期时间
     * @return
     */
    public void isOverLimitEachAmount(String industryCode, String transDate, AccountType accountType, long transAmount) {
        IndustryAmountLimitBO industryAmountLimitBO = this.findIndustryAmountLimitBO(industryCode, transDate);
        switch (accountType) {
            case PUBLIC: {
                if (transAmount > industryAmountLimitBO.getPublicLimitEachAmount()) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]交易金额[%s元]超出单笔对公限额[%s元]", industryCode, formatAmt(transAmount), formatAmt(industryAmountLimitBO.getPublicLimitEachAmount())));
                }
            }
            break;
            case PRIVATE: {
                if (transAmount > industryAmountLimitBO.getPrivateLimitEachAmount()) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]交易金额[%s元]超出单笔对私限额[%s元]", industryCode, formatAmt(transAmount), formatAmt(industryAmountLimitBO.getPrivateLimitEachAmount())));
                }
            }
            break;
            case BILLING_CARD: {
                if (transAmount > industryAmountLimitBO.getBillingCardLimitEachAmount()) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]交易金额[%s元]超出单笔单位结算卡限额[%s元]", industryCode, formatAmt(transAmount), (industryAmountLimitBO.getBillingCardLimitEachAmount())));
                }
                break;
            }
            default: {
                LambdaLogger.error(log, (l) -> l.error("暂未支持的账户类型[{}] {}", accountType.getValue(), accountType.getCode()));
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]交易金额[%s元],暂未支持的账户类型[%s] %s", industryCode, formatAmt(transAmount), accountType.getValue(), accountType.getCode()));
            }
        }
    }

    /**
     * 获取客户号（提现&代付）单日剩余可用额度 【发往渠道转账】
     */
    public long getIndustryDailyAvailableAmount(String industryCode, String transDate, long defaultLimitAmount) {
        long industryDailyAvailableAmount;
        IndustryAmountLimitBO industryAmountLimitBO = this.findIndustryAmountLimitBO(industryCode, transDate);
        if (industryAmountLimitBO == null) {
            industryDailyAvailableAmount = defaultLimitAmount;
        } else {
            industryDailyAvailableAmount = industryAmountLimitBO.getDailyLimitTotalAmount() - industryAmountLimitBO.getAccumulateAmount();
        }
        return industryDailyAvailableAmount;
    }

    /**
     * 获取客户号（余额支付）单日剩余可用额度 【内部系统支付】
     */
    public long getIndustryBalancePayDailyAvailableAmount(String industryCode, String transDate, long defaultLimitAmount) {
        long industryBalancePayDailyAvailableAmount;
        IndustryAmountLimitBO industryAmountLimitBO = this.findIndustryAmountLimitBO(industryCode, transDate);
        if (industryAmountLimitBO == null) {
            industryBalancePayDailyAvailableAmount = defaultLimitAmount;
        } else {
            industryBalancePayDailyAvailableAmount = industryAmountLimitBO.getIndustryBalancePayDailyLimitTotalAmount() - industryAmountLimitBO.getIndustryBalancePayAccumulateAmount();
        }
        return industryBalancePayDailyAvailableAmount;
    }

    public Long deleteLimitAmount(String industryCode, String date) {
        final String curKey = this.getOptionKey(date);
        if (redisTemplate.hasKey(curKey)) {
            final String curId = genId(industryCode);
            return redisTemplate.boundHashOps(curKey).delete(curId);
        }
        return 0L;
    }

    public void refreshLimitAmount(IndustryAmountLimitBO industryAmountLimitBO) {
        Assert.notNull(industryAmountLimitBO, () -> "请求报文不能为空");
        Assert.hasText(industryAmountLimitBO.getIndustryCode(), () -> "industryCode不能为空");
        Assert.hasText(industryAmountLimitBO.getDate(), () -> "date不能为空");

        IndustryAmountLimitBO redisBO = this.findIndustryAmountLimitBO(industryAmountLimitBO.getIndustryCode(), industryAmountLimitBO.getDate());
        if (redisBO != null) {
            if (industryAmountLimitBO.getDailyLimitTotalAmount() > 0) {
                redisBO.setDailyLimitTotalAmount(industryAmountLimitBO.getDailyLimitTotalAmount());
            }
            if (industryAmountLimitBO.getPublicLimitEachAmount() > 0) {
                redisBO.setPublicLimitEachAmount(industryAmountLimitBO.getPublicLimitEachAmount());
            }
            if (industryAmountLimitBO.getPrivateLimitEachAmount() > 0) {
                redisBO.setPrivateLimitEachAmount(industryAmountLimitBO.getPrivateLimitEachAmount());
            }
            if (industryAmountLimitBO.getBillingCardLimitEachAmount() > 0) {
                redisBO.setBillingCardLimitEachAmount(industryAmountLimitBO.getBillingCardLimitEachAmount());
            }
            if (industryAmountLimitBO.getCommPrivateSubAccountDailyLimitTotalAmount() > 0) {
                redisBO.setCommPrivateSubAccountDailyLimitTotalAmount(industryAmountLimitBO.getCommPrivateSubAccountDailyLimitTotalAmount());
            }
            if (Integer.valueOf(industryAmountLimitBO.getSameCashMaxAmt()) > 0) {
                redisBO.setSameCashMaxAmt(industryAmountLimitBO.getSameCashMaxAmt());
            }
            if (Integer.valueOf(industryAmountLimitBO.getMinuteMaxCashTranAmt()) > 0) {
                redisBO.setMinuteMaxCashTranAmt(industryAmountLimitBO.getMinuteMaxCashTranAmt());
            }

            if(industryAmountLimitBO.getCommPublicSubAccountDailyLimitTotalAmount()>0){
                redisBO.setCommPublicSubAccountDailyLimitTotalAmount(industryAmountLimitBO.getCommPublicSubAccountDailyLimitTotalAmount());
            }
            if(industryAmountLimitBO.getIndustryBalancePayDailyLimitTotalAmount()>0){
                redisBO.setIndustryBalancePayDailyLimitTotalAmount(industryAmountLimitBO.getIndustryBalancePayDailyLimitTotalAmount());
            }
            if(industryAmountLimitBO.getPrivateSubAccountBalancePayDailyLimitTotalAmount()>0){
                redisBO.setPrivateSubAccountBalancePayDailyLimitTotalAmount(industryAmountLimitBO.getPrivateSubAccountBalancePayDailyLimitTotalAmount());
            }
            if(industryAmountLimitBO.getPublicSubAccountBalancePayDailyLimitTotalAmount()>0){
                redisBO.setPublicSubAccountBalancePayDailyLimitTotalAmount(industryAmountLimitBO.getPublicSubAccountBalancePayDailyLimitTotalAmount());
            }

            setIndustryAmountLimitBO(redisBO);

        } else {
            log.warn("刷新客户号交易限额缓存失败.原因：查无此缓存记录");
        }

    }


    /**
     * 3秒内获取分布式锁，如果没获取则抛出异常
     *
     * @param industryAmountLimitBO 隔天的数据保存生命周期为2天，以晚上12点整为周期。
     */
    private void dailyAccumulateAmount(IndustryAmountLimitBO industryAmountLimitBO, long transAmount, String handleType) {
        Assert.notNull(industryAmountLimitBO, () -> "请求报文不能为空");
        Assert.hasText(industryAmountLimitBO.getIndustryCode(), () -> "请求参数industryCode不能为空");
        Assert.hasText(industryAmountLimitBO.getDate(), () -> "请求参数date不能为空");
        try {
            industryAmountLimitBO.setTransAmount(transAmount);
            redisLockExecutor.execute(genId(industryAmountLimitBO.getIndustryCode()), 3, industryAmountLimitBO, bo -> {
                if (CHANNEL_TRANSFER_CATEGORY.equals(handleType)) {
                    industryAmountLimitBO.setAccumulateAmount(industryAmountLimitBO.getAccumulateAmount() + industryAmountLimitBO.getTransAmount());
                } else if (INNER_BALANCE_PAY_CATEGORY.equals(handleType)) {
                    industryAmountLimitBO.setIndustryBalancePayAccumulateAmount(industryAmountLimitBO.getIndustryBalancePayAccumulateAmount() + industryAmountLimitBO.getTransAmount());
                }
                setIndustryAmountLimitBO(industryAmountLimitBO);
            });
        } catch (InterruptedException e) {
            log.error("dailyAccumulateAmount异常:{}", e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
    }

    private IndustryAmountLimitBO findIndustryAmountLimitBO(String industryCode, String transDate) {
        String curKey = this.getOptionKey(transDate);
        String curId = this.genId(industryCode);

        IndustryAmountLimitBO industryAmountLimitBO;
        if (redisTemplate.hasKey(curKey)) {
            Object obj = redisTemplate.boundHashOps(curKey).get(curId);
            if (obj instanceof IndustryAmountLimitBO) {
                industryAmountLimitBO = (IndustryAmountLimitBO) obj;
                return industryAmountLimitBO;
            } else {
                industryAmountLimitBO = initIndustryAmountLimitBo(industryCode, transDate);
            }
        } else {
            industryAmountLimitBO = initIndustryAmountLimitBo(industryCode, transDate);
        }
        setIndustryAmountLimitBO(industryAmountLimitBO);
        return industryAmountLimitBO;
    }

    private void setIndustryAmountLimitBO(IndustryAmountLimitBO industryAmountLimitBO) {
        String curKey = this.getOptionKey(industryAmountLimitBO.getDate());
        String curId = this.genId(industryAmountLimitBO.getIndustryCode());

        redisTemplate.boundHashOps(curKey).put(curId, industryAmountLimitBO);
        LocalDateTime expireTime = LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(0, 0, 0));
        redisTemplate.expireAt(curKey, Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    private IndustryAmountLimitBO initIndustryAmountLimitBo(String industryCode, String transDate) {
        IndustryAmtLimit amtLimit = MybatisDaoImpl.run().selectOne(IndustryAmtLimit.builder().industryCode(industryCode).build());
        if (amtLimit == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此客户号[%s]的限额信息记录", industryCode));
        }
        IndustryAmountLimitBO industryAmountLimitBO = new IndustryAmountLimitBO();
        industryAmountLimitBO.setIndustryCode(industryCode);
        industryAmountLimitBO.setDate(transDate);

        industryAmountLimitBO.setDailyLimitTotalAmount(amtLimit.getIndustryDateAmt());
        industryAmountLimitBO.setPublicLimitEachAmount(amtLimit.getPublicIndividualAmt());
        industryAmountLimitBO.setPrivateLimitEachAmount(amtLimit.getPrivateIndividualAmt());
        industryAmountLimitBO.setBillingCardLimitEachAmount(amtLimit.getUnitIndividualAmt());

        industryAmountLimitBO.setSameCashMaxAmt(amtLimit.getSameCashMaxAmt());
        industryAmountLimitBO.setMinuteMaxCashTranAmt(amtLimit.getMinuteMaxCashTranAmt());

        industryAmountLimitBO.setCommPrivateSubAccountDailyLimitTotalAmount(amtLimit.getSubaccountsDateAmt());
        industryAmountLimitBO.setCommPublicSubAccountDailyLimitTotalAmount(amtLimit.getPublicSubaccountsDateAmt());

        industryAmountLimitBO.setIndustryBalancePayDailyLimitTotalAmount(amtLimit.getIndustryBalanceDateAmt());
        industryAmountLimitBO.setPrivateSubAccountBalancePayDailyLimitTotalAmount(amtLimit.getPrivateSubaccountsBalanceDateAmt());
        industryAmountLimitBO.setPublicSubAccountBalancePayDailyLimitTotalAmount(amtLimit.getPublicSubaccountsBalanceDateAmt());

        log.info("初始化industryAmountLimitBO ==>> industryCode={},transDate={} 的缓存对象={}", industryCode, transDate, JSON.toJSONString(industryAmountLimitBO));
        return industryAmountLimitBO;
    }

    /**
     * 校验同一平台下的同一用户连续相同提现金额次数限制
     * 校验同一平台下每分钟累计不超过数值限制
     *
     * @param industryCode
     * @param userAccount
     * @param transAmount
     */
    public void validCashMaxTranAmt(String industryCode, String userAccount, long transAmount) {
        Assert.hasText(industryCode, () -> "请求参数[industryCode]不能为空");
        Assert.hasText(userAccount, () -> "请求参数[userAccount]不能为空");
        Assert.hasText(String.valueOf(transAmount), () -> "请求参数[transAmount]不能为空");

        //先从redis缓存获取数据，如果没有则从库表查询
        String transDate = DateUtil.getToday();
        String curKey = this.getOptionKey(transDate);
        String curId = this.genId(industryCode);
        IndustryAmountLimitBO industryAmountLimitBO;
        if (redisTemplate.hasKey(curKey)) {
            Object obj = redisTemplate.boundHashOps(curKey).get(curId);
            if (obj instanceof IndustryAmountLimitBO) {
                industryAmountLimitBO = (IndustryAmountLimitBO) obj;
            } else {
                industryAmountLimitBO = initIndustryAmountLimitBo(industryCode, transDate);
            }
        } else {
            industryAmountLimitBO = initIndustryAmountLimitBo(industryCode, transDate);
        }

        if (industryAmountLimitBO != null) {
            //校验同一平台下的同一用户连续相同提现金额次数限制
            validSameCashMaxTranAmt(industryAmountLimitBO, industryCode, userAccount, transAmount);
            //校验同一平台下每分钟累计不超过数值限制
            validMinuteMaxCashTranAmt(industryAmountLimitBO, industryCode);
        }
    }

    private String fmtSameCashMaxAmtKey(String industryCode, String userAccount) {
        return RedisKey.fmtKey(RedisKey.SAME_CASH_MAX_AMT, industryCode, userAccount);
    }

    /**
     * 校验同一平台下的同一用户连续相同提现金额次数限制
     *
     * @param industryAmountLimitBO
     * @param industryCode
     * @param userAccount
     * @param transAmount
     */
    private void validSameCashMaxTranAmt(IndustryAmountLimitBO industryAmountLimitBO, String industryCode, String userAccount, long transAmount) {
        //相同提现金额最大次数
        Integer sameCashMaxAmt = StringUtil.isEmpty(industryAmountLimitBO.getSameCashMaxAmt()) ? 3 : Integer.valueOf(industryAmountLimitBO.getSameCashMaxAmt());
        //从redis获取数据
        String key = fmtSameCashMaxAmtKey(industryCode, userAccount);
        String key_transAmount = String.valueOf(transAmount);
        //存在缓存数据
        if (redisTemplate.hasKey(key)) {
            //对比交易金额
            Object sameCashMaxAmtCache = redisTemplate.boundHashOps(key).get(key_transAmount);
            if (sameCashMaxAmtCache == null) {
                //删除原先key
                redisTemplate.delete(key);
                // 重置规则
                redisTemplate.boundHashOps(key).put(key_transAmount, 1);
            } else {
                Integer sameCashMaxAmtCacheNum = Integer.valueOf(sameCashMaxAmtCache.toString());
                //超过最大次数
                if (sameCashMaxAmtCacheNum >= sameCashMaxAmt) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "此账户已超过连续相同交易金额的最大次数 " + sameCashMaxAmt);
                } else {//未超过最大次数
                    redisTemplate.boundHashOps(key).put(key_transAmount, sameCashMaxAmtCacheNum + 1);
                }
            }
        } else {//不存在缓存
            redisTemplate.boundHashOps(key).put(key_transAmount, "1");
        }
    }


    /**
     * 校验同一平台下每分钟累计不超过数值限制
     *
     * @param industryAmountLimitBO
     * @param industryCode
     */
    private void validMinuteMaxCashTranAmt(IndustryAmountLimitBO industryAmountLimitBO, String industryCode) {
        //同一平台下每分钟累计不超过数值
        Integer minuteMaxCashTranAmt = StringUtil.isEmpty(industryAmountLimitBO.getMinuteMaxCashTranAmt()) ? 60 : Integer.valueOf(industryAmountLimitBO.getMinuteMaxCashTranAmt());
        if (isWithdrawLimit(industryCode, minuteMaxCashTranAmt, 60)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "此平台已超过每分钟累计最大次数 " + minuteMaxCashTranAmt);
        }
    }

    /**
     * 是否触发提现|单笔实时代付  限流
     *
     * @param limitCount 限流大小
     * @param ratePeriod 单位时间 默认单位秒
     * @return boolean
     */
    private boolean isWithdrawLimit(String industryCode, long limitCount, long ratePeriod) {
        Long curentLimit = 0L;
        String key = String.format("INDUSTRY_WITHDRAW_RATE_LIMIT:%s", industryCode);
        try {
            curentLimit = rateLimitRedisTemplate.execute(rateLimitScript, Collections.singletonList(key), String.valueOf(limitCount), String.valueOf(ratePeriod));
            log.info("客户号：{} >> 当前提现限流大小:{},总限流{}/{}s", industryCode, curentLimit, limitCount, ratePeriod);
        } catch (Exception e) {
            log.error("客户号：{} 提现限流异常:{}", industryCode, e.getMessage(), e);
        }
        return curentLimit == 0;
    }

    /**
     * @param date yyyyMMdd
     * @return
     */
    private String getOptionKey(String date) {
        return RedisKey.fmtKey(RedisKey.INDUSTRY_DAILY_AMOUNT_HASH_KEY, date);
    }

    private final String genId(String industryCode) {
        return String.format("industryCode_%s", industryCode);
    }


}
