package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.redis.redisson.executor.RedisLockExecutor;
import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimit;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfoCondition;
import cn.kingnet.utp.service.persistence.entity.SubaccountsAmtLimit;
import cn.kingnet.utp.service.persistence.entity.bo.IndustryAmountLimitBO;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountAmountLimitBO;
import cn.kingnet.utp.trade.common.enums.AccountType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Map;

/**
 * @Description 客户号子账户限额服务
 * @Author WJH
 * @Date 2019/07/25
 */
@Slf4j
@Service
public class SubAccountAmountLimitService extends RiskParamCategory {

    private final RedisTemplate redisTemplate;
    private final RedisLockExecutor redisLockExecutor;
    private final MerchantInfoService merchantInfoService;

    public SubAccountAmountLimitService(RedisTemplate redisTemplate, RedisLockExecutor redisLockExecutor, MerchantInfoService merchantInfoService) {
        this.redisLockExecutor = redisLockExecutor;
        this.redisTemplate = redisTemplate;
        this.merchantInfoService = merchantInfoService;
    }


    /**
     * 交易成功时，客户号额度累加
     *
     * @param industryCode 客户号
     * @param transAmount  交易金额
     * @param transDate    yyyyMMdd
     */
    public void accumulateSubAccountAmount(String industryCode, String subAccount, long transAmount, String transDate) {
        SubAccountAmountLimitBO subAccountAmountLimitBO = this.findSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        subAccountAmountLimitBO.setTransAmount(transAmount);
        this.dailyAccumulateAmount(subAccountAmountLimitBO, CHANNEL_TRANSFER_CATEGORY);
    }

    public void accumulateSubAccountBalancePayAmount(String industryCode, String subAccount, long transAmount, String transDate) {
        SubAccountAmountLimitBO subAccountAmountLimitBO = this.findSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        subAccountAmountLimitBO.setTransAmount(transAmount);
        this.dailyAccumulateAmount(subAccountAmountLimitBO, INNER_BALANCE_PAY_CATEGORY);
    }

    /**
     * @param subAccount 客户号
     * @param transDate  交易日期时间
     * @return
     */
    public boolean isOverLimitEachAmount(String industryCode, String subAccount, String transDate, long transAmount) {
        SubAccountAmountLimitBO subAccountAmountLimitBO = this.findSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        return transAmount > subAccountAmountLimitBO.getLimitEachAmount();
    }

    /**
     * 子账户 提现&代付 当日可用额度
     **/
    public long getSubAccountDailyAvailableAmount(String industryCode, String subAccount, String transDate, long defaultLimitAmount) {
        long subAccountDailyAvailableAmount;
        SubAccountAmountLimitBO subAccountAmountLimitBO = this.findSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        if (subAccountAmountLimitBO == null) {
            subAccountDailyAvailableAmount = defaultLimitAmount;
        } else {
            subAccountDailyAvailableAmount = subAccountAmountLimitBO.getDailyLimitTotalAmount() - subAccountAmountLimitBO.getAccumulateAmount();
        }
        return subAccountDailyAvailableAmount;
    }

    /**
     * 子账户余额支付当日可用额度
     **/
    public long getSubAccountBalancePayDailyAvailableAmount(String industryCode, String subAccount, String transDate, long defaultLimitAmount) {
        long subAccountBalancePayDailyAvailableAmount;
        SubAccountAmountLimitBO subAccountAmountLimitBO = this.findSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        if (subAccountAmountLimitBO == null) {
            subAccountBalancePayDailyAvailableAmount = defaultLimitAmount;
        } else {
            subAccountBalancePayDailyAvailableAmount = subAccountAmountLimitBO.getBalancePayDailyLimitTotalAmount() - subAccountAmountLimitBO.getBalancePayAccumulateAmount();
        }
        return subAccountBalancePayDailyAvailableAmount;
    }

    public void refreshLimitAmount(SubAccountAmountLimitBO subAccountAmountLimitBO) {
        Assert.notNull(subAccountAmountLimitBO, () -> "请求报文不能为空");
        Assert.hasText(subAccountAmountLimitBO.getIndustryCode(), () -> "industryCode不能为空");
        Assert.hasText(subAccountAmountLimitBO.getSubAccount(), () -> "subAccount不能为空");
        Assert.hasText(subAccountAmountLimitBO.getDate(), () -> "date不能为空");
        final String curId = genId(subAccountAmountLimitBO.getSubAccount());
        final String curKey = this.getOptionKey(subAccountAmountLimitBO.getDate(), subAccountAmountLimitBO.getIndustryCode());

        SubAccountAmountLimitBO redisBO = this.findSubAccountAmountLimitBO(subAccountAmountLimitBO.getIndustryCode(), subAccountAmountLimitBO.getSubAccount(), subAccountAmountLimitBO.getDate());
        if (redisBO != null) {
            if (subAccountAmountLimitBO.getDailyLimitTotalAmount() > 0) {
                redisBO.setDailyLimitTotalAmount(subAccountAmountLimitBO.getDailyLimitTotalAmount());
            }
            if (subAccountAmountLimitBO.getLimitEachAmount() > 0) {
                redisBO.setLimitEachAmount(subAccountAmountLimitBO.getLimitEachAmount());
            }
        } else {
            redisBO = initSubAccountAmountLimitBO(subAccountAmountLimitBO.getIndustryCode(), subAccountAmountLimitBO.getSubAccount(), subAccountAmountLimitBO.getDate());
        }
        if (redisBO != null) {
            redisTemplate.boundHashOps(curKey).put(curId, redisBO);
            LocalDateTime expireTime = LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(0, 0, 0));
            redisTemplate.expireAt(curKey, Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));
        }
    }


    /**
     * 3秒内获取分布式锁，如果没获取则抛出异常
     *
     * @param subAccountAmountLimitBO 隔天的数据保存生命周期为2天，以晚上12点整为周期。
     */
    private void dailyAccumulateAmount(SubAccountAmountLimitBO subAccountAmountLimitBO, String riskCategory) {
        Assert.notNull(subAccountAmountLimitBO, () -> "请求报文不能为空");
        Assert.hasText(subAccountAmountLimitBO.getSubAccount(), () -> "请求参数subAccount不能为空");
        Assert.hasText(subAccountAmountLimitBO.getDate(), () -> "请求参数date不能为空");
        try {
            redisLockExecutor.execute(genId(subAccountAmountLimitBO.getSubAccount()), 3, subAccountAmountLimitBO, bo -> {
                String curKey = this.getOptionKey(subAccountAmountLimitBO.getDate(), subAccountAmountLimitBO.getIndustryCode());
                String curId = genId(subAccountAmountLimitBO.getSubAccount());
                SubAccountAmountLimitBO redisBO = findSubAccountAmountLimitBO(subAccountAmountLimitBO.getIndustryCode(), subAccountAmountLimitBO.getSubAccount(), subAccountAmountLimitBO.getDate());
                if (redisBO != null) {
                    if (CHANNEL_TRANSFER_CATEGORY.equals(riskCategory)) {
                        redisBO.setAccumulateAmount(redisBO.getAccumulateAmount() + subAccountAmountLimitBO.getTransAmount());
                    } else if (INNER_BALANCE_PAY_CATEGORY.equals(riskCategory)) {
                        redisBO.setBalancePayAccumulateAmount(redisBO.getBalancePayAccumulateAmount() + subAccountAmountLimitBO.getTransAmount());
                    }
                    redisTemplate.boundHashOps(curKey).put(curId, redisBO);
                }
            });
        } catch (InterruptedException e) {
            log.error("dailyAccumulateAmount异常:{}", e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
    }

    private SubAccountAmountLimitBO findSubAccountAmountLimitBO(String industryCode, String subAccount, String transDate) {
        String curKey = this.getOptionKey(transDate, industryCode);
        String curId = this.genId(subAccount);
        SubAccountAmountLimitBO subAccountAmountLimitBO;
        if (redisTemplate.hasKey(curKey)) {
            Object obj = redisTemplate.boundHashOps(curKey).get(curId);
            if (obj instanceof SubAccountAmountLimitBO) {
                subAccountAmountLimitBO = (SubAccountAmountLimitBO) obj;
            } else {
                subAccountAmountLimitBO = initSubAccountAmountLimitBO(industryCode, subAccount, transDate);
            }
        } else {
            subAccountAmountLimitBO = initSubAccountAmountLimitBO(industryCode, subAccount, transDate);
        }
        if (subAccountAmountLimitBO != null) {
            redisTemplate.boundHashOps(curKey).put(curId, subAccountAmountLimitBO);
            LocalDateTime expireTime = LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(0, 0, 0));
            redisTemplate.expireAt(curKey, Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));
        }
        return subAccountAmountLimitBO;
    }


    private SubAccountAmountLimitBO initSubAccountAmountLimitBO(String industryCode, String subAccount, String transDate) {
        SubAccountAmountLimitBO subAccountAmountLimitBO = new SubAccountAmountLimitBO();
        MerchantInfo merchantInfo = this.merchantInfoService.selectOne(MerchantInfoCondition.builder().andIndustryCodeEq(industryCode).andAccountEq(subAccount).build());
        if (merchantInfo == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此客户号[%s]子账户[%s]的基础信息", industryCode, subAccount));
        }

        AccountType accountType = AccountType.getAccountTypeByOuterValue(merchantInfo.getUserType());
        if (accountType == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("此客户号[%s]子账户[%s]的userType[%s]类型有误", industryCode, subAccount, merchantInfo.getUserType()));
        }

        SubaccountsAmtLimit amtLimit = MybatisDaoImpl.run().selectOne(SubaccountsAmtLimit.builder().industryCode(industryCode).subAccount(subAccount).build());
        long subAccountDailyLimitTotalAmount, subAccountLimitEachAmount,subAccountBalancePayDailyLimitTotalAmount;
        // 是否客户号公共配置生效
        boolean isIndustryCommEffect = false;
        //待优化缓存
        IndustryAmtLimit industryAmtLimit = MybatisDaoImpl.run().selectOne(IndustryAmtLimit.builder().industryCode(industryCode).build());
        if (industryAmtLimit == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此客户号[%s]限额配置信息", industryCode));
        }

        // 子账户配置限额信息优先级较高 生效
        if (amtLimit != null) {
            isIndustryCommEffect = false;
            subAccountDailyLimitTotalAmount = amtLimit.getSubaccountsDateAmt();
            subAccountLimitEachAmount = amtLimit.getSubaccountsIndividualAmt();
            if (AccountType.PRIVATE == accountType) {
                subAccountBalancePayDailyLimitTotalAmount = industryAmtLimit.getPrivateSubaccountsBalanceDateAmt();
            } else if (AccountType.PUBLIC == accountType) {
                subAccountBalancePayDailyLimitTotalAmount = industryAmtLimit.getPublicSubaccountsBalanceDateAmt();
            } else {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("此客户号[%s]子账户[%s]的userType[%s]类型有误", industryCode, subAccount, merchantInfo.getUserType()));
            }
        } else {
            // 子账户未配置，则取其归属客户号的统一配置值 生效
            isIndustryCommEffect = true;
            if (AccountType.PRIVATE == accountType) {
                subAccountDailyLimitTotalAmount = industryAmtLimit.getSubaccountsDateAmt();
                subAccountLimitEachAmount = industryAmtLimit.getPrivateIndividualAmt();
                subAccountBalancePayDailyLimitTotalAmount = industryAmtLimit.getPrivateSubaccountsBalanceDateAmt();
            } else if (AccountType.PUBLIC == accountType) {
                subAccountDailyLimitTotalAmount = industryAmtLimit.getPublicSubaccountsDateAmt();
                subAccountLimitEachAmount = industryAmtLimit.getPublicIndividualAmt();
                subAccountBalancePayDailyLimitTotalAmount = industryAmtLimit.getPublicSubaccountsBalanceDateAmt();
            } else {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("此客户号[%s]子账户[%s]的userType[%s]类型有误", industryCode, subAccount, merchantInfo.getUserType()));
            }
        }


        subAccountAmountLimitBO.setIndustryCode(industryCode);
        subAccountAmountLimitBO.setSubAccount(subAccount);
        subAccountAmountLimitBO.setDate(transDate);
        subAccountAmountLimitBO.setDailyLimitTotalAmount(subAccountDailyLimitTotalAmount);
        subAccountAmountLimitBO.setLimitEachAmount(subAccountLimitEachAmount);

        subAccountAmountLimitBO.setAccountType(accountType);
        subAccountAmountLimitBO.setIndustryCommEffect(isIndustryCommEffect);
        subAccountAmountLimitBO.setBalancePayDailyLimitTotalAmount(subAccountBalancePayDailyLimitTotalAmount);

        LambdaLogger.debug(log, "初始化SubAccountAmountLimit ==>> industryCode={},subAccount={},transDate={} 的缓存对象={}", industryCode, subAccount, transDate, JSON.toJSONString(subAccountAmountLimitBO));
        return subAccountAmountLimitBO;
    }

    private void doDailyAccumulateAmount(SubAccountAmountLimitBO subAccountAmountLimitBO) {
        String curKey = this.getOptionKey(subAccountAmountLimitBO.getDate(), subAccountAmountLimitBO.getIndustryCode());
        String curId = genId(subAccountAmountLimitBO.getSubAccount());
        SubAccountAmountLimitBO redisBO = findSubAccountAmountLimitBO(subAccountAmountLimitBO.getIndustryCode(), subAccountAmountLimitBO.getSubAccount(), subAccountAmountLimitBO.getDate());
        if (redisBO != null) {
            redisBO.setAccumulateAmount(redisBO.getAccumulateAmount() + subAccountAmountLimitBO.getTransAmount());
            redisTemplate.boundHashOps(curKey).put(curId, redisBO);
        }
    }

    /**
     * @param date yyyyMMdd
     * @return
     */
    private String getOptionKey(String date, String industryCode) {
        return RedisKey.fmtKey(RedisKey.SUBACCOUNT_DAILY_AMOUNT_HASH_KEY, date, industryCode);
    }

    private final String genId(String subAccount) {
        return String.format("subAccount_%s", subAccount);
    }

    public void deleteLimitAmount(String subAccount, String date, String industryCode) {
        String curKey = this.getOptionKey(date, industryCode);
        String curId = this.genId(subAccount);
        if (redisTemplate.hasKey(curKey)) {
            redisTemplate.boundHashOps(curKey).delete(curId);
        }
    }

    public void deleteLimitAmountByIndustry(String industryCode, String date) {
        final String curKey = getOptionKey(date, industryCode);
        if (redisTemplate.hasKey(curKey)) {
            BoundHashOperations opts = redisTemplate.boundHashOps(curKey);
            opts.entries().entrySet().forEach(o -> {
                Map.Entry<String, Object> entry = (Map.Entry) o;
                Object obj = entry.getValue();
                if (obj instanceof SubAccountAmountLimitBO) {
                    SubAccountAmountLimitBO subAccountAmountLimitBO = (SubAccountAmountLimitBO) obj;
                    if (subAccountAmountLimitBO.isIndustryCommEffect() && subAccountAmountLimitBO.getIndustryCode().equals(industryCode)) {
                        //删除由该客户号生效的 子账户缓存
                        opts.delete(entry.getKey());
                    }
                }
            });
        }
    }

    public void refreshLimitAmountByIndustry(IndustryAmountLimitBO industryAmountLimitBO) {
        String curKey = getOptionKey(industryAmountLimitBO.getDate(), industryAmountLimitBO.getIndustryCode());

        if (redisTemplate.hasKey(curKey)) {
            BoundHashOperations opts = redisTemplate.boundHashOps(curKey);
            opts.entries().entrySet().forEach(o -> {
                Map.Entry<String, Object> entry = (Map.Entry) o;
                Object obj = entry.getValue();
                if (obj instanceof SubAccountAmountLimitBO) {
                    SubAccountAmountLimitBO subAccountAmountLimitBO = (SubAccountAmountLimitBO) obj;
                    if (subAccountAmountLimitBO.isIndustryCommEffect() && subAccountAmountLimitBO.getIndustryCode().equals(industryAmountLimitBO.getIndustryCode())) {
                        if (subAccountAmountLimitBO.getAccountType() == AccountType.PRIVATE) {
                            subAccountAmountLimitBO.setDailyLimitTotalAmount(industryAmountLimitBO.getCommPrivateSubAccountDailyLimitTotalAmount());
                            subAccountAmountLimitBO.setLimitEachAmount(industryAmountLimitBO.getPrivateLimitEachAmount());

                            subAccountAmountLimitBO.setBalancePayDailyLimitTotalAmount(industryAmountLimitBO.getPrivateSubAccountBalancePayDailyLimitTotalAmount());
                        } else if (subAccountAmountLimitBO.getAccountType() == AccountType.PUBLIC) {
                            subAccountAmountLimitBO.setDailyLimitTotalAmount(industryAmountLimitBO.getCommPublicSubAccountDailyLimitTotalAmount());
                            subAccountAmountLimitBO.setLimitEachAmount(industryAmountLimitBO.getPublicLimitEachAmount());

                            subAccountAmountLimitBO.setBalancePayDailyLimitTotalAmount(industryAmountLimitBO.getPublicSubAccountBalancePayDailyLimitTotalAmount());
                        }
                        //设值
                        opts.put(entry.getKey(), subAccountAmountLimitBO);
                    }
                }
            });
        }

    }
}
