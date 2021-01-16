package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.redis.redisson.executor.RedisLockExecutor;
import cn.kingnet.utp.service.persistence.entity.ChannelInfo;
import cn.kingnet.utp.service.persistence.entity.ChannelInfoCondition;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelAmountLimitBO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @Description 渠道限额服务
 * @Author WJH
 * @Date 2019/07/25
 */
@Slf4j
@Service
public class ChannelAmountLimitService {

    private final RedisTemplate redisTemplate;
    private final RedisLockExecutor redisLockExecutor;

    public ChannelAmountLimitService(RedisTemplate redisTemplate, RedisLockExecutor redisLockExecutor) {
        this.redisTemplate = redisTemplate;
        this.redisLockExecutor = redisLockExecutor;
    }

    /**
     * 交易成功时，渠道额度累加
     *
     * @param channelCode 渠道编码
     * @param transAmount 交易金额
     * @param transDate   yyyyMMdd
     */
    public void accumulateChannelAmount(String channelCode, long transAmount, String transDate) {
        ChannelAmountLimitBO channelAmountLimitBO = this.findChannelAmountLimitBO(channelCode, transDate);
        channelAmountLimitBO.setTransAmount(transAmount);
        this.dailyChange(channelAmountLimitBO);
    }

    /**
     * @param channelCode        渠道编号
     * @param transDate          交易日期时间
     * @param defaultLimitAmount 渠道配置额度
     * @return
     */
    public long getChannelDailyAvailableAmount(String channelCode, String transDate, long defaultLimitAmount) {
        long channelDailyAvailableAmount;
        ChannelAmountLimitBO channelAmountLimitBO = this.findChannelAmountLimitBO(channelCode, transDate);
        if (channelAmountLimitBO == null) {
            channelDailyAvailableAmount = defaultLimitAmount;
        } else {
            channelDailyAvailableAmount = channelAmountLimitBO.getDailyLimitTotalAmount() - channelAmountLimitBO.getAccumulateAmount();
        }
        return channelDailyAvailableAmount;
    }

    public Long deleteLimitAmount(String channelCode, String transDate) {
        String key = this.getOptionKey(transDate);
        if (redisTemplate.hasKey(key)) {
            return redisTemplate.boundHashOps(key).delete(this.genId(channelCode));
        }
        return 0L;
    }

    public void refreshLimitAmount(String channelCode, String transDate, long limitTotalAmount) {
        Assert.hasText(channelCode, "渠道编码不能为空");
        Assert.hasText(transDate, "date不能为空");
        final String curId = genId(channelCode);
        final String curKey = this.getOptionKey(transDate);

        ChannelAmountLimitBO channelAmountLimitBO = this.findChannelAmountLimitBO(channelCode, transDate);
        if (channelAmountLimitBO != null) {
            if (limitTotalAmount >= 0) {
                channelAmountLimitBO.setDailyLimitTotalAmount(limitTotalAmount);
            }
            redisTemplate.boundHashOps(curKey).put(curId, channelAmountLimitBO);
            LocalDateTime expireTime = LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(0, 0, 0));
            redisTemplate.expireAt(curKey, Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));

            log.info("刷新后key={},id={} 缓存对象：{}", curKey, curId, JSON.toJSONString(channelAmountLimitBO));
        } else {
            log.warn("刷新渠道交易限额缓存失败.原因：查无此缓存记录");
        }

    }


    /**
     * 3秒内获取分布式锁，如果没获取则抛出异常
     *
     * @param channelAmountLimitBO 隔天的数据保存生命周期为2天，以晚上12点整为周期。
     */
    private void dailyChange(ChannelAmountLimitBO channelAmountLimitBO) {
        Assert.notNull(channelAmountLimitBO, () -> "请求报文不能为空");
        Assert.hasText(channelAmountLimitBO.getChannelCode(), () -> "请求参数channelCode不能为空");
        Assert.hasText(channelAmountLimitBO.getDate(), () -> "请求参数date不能为空");
        try {
            redisLockExecutor.execute(genId(channelAmountLimitBO.getChannelCode()), 3, channelAmountLimitBO, this::doChange);
        } catch (InterruptedException e) {
            log.error("dailyChange异常:{}",e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
    }

    private ChannelAmountLimitBO findChannelAmountLimitBO(String channelCode, String transDate) {
        String key = this.getOptionKey(transDate);
        String id = this.genId(channelCode);
        ChannelAmountLimitBO channelAmountLimitBO;
        if (redisTemplate.hasKey(key)) {
            Object obj = redisTemplate.boundHashOps(key).get(id);
            if (obj instanceof ChannelAmountLimitBO) {
                channelAmountLimitBO = (ChannelAmountLimitBO) obj;
            } else {
                channelAmountLimitBO = initChannelAmountLimitBO(channelCode, transDate);
            }
        } else {
            channelAmountLimitBO = initChannelAmountLimitBO(channelCode, transDate);
        }
        if (channelAmountLimitBO != null) {
            redisTemplate.boundHashOps(key).put(id, channelAmountLimitBO);
            LocalDateTime expireTime = LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(0, 0, 0));
            redisTemplate.expireAt(key, Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));
        }
        return channelAmountLimitBO;
    }

    private ChannelAmountLimitBO initChannelAmountLimitBO(String channelCode, String transDate) {
        ChannelInfo channelInfo = MybatisDaoImpl.run().selectOne(ChannelInfoCondition.builder().andChannelCodeEq(channelCode).build());
        if (channelInfo == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此渠道编号[%s]基础信息", channelCode));
        }
        ChannelAmountLimitBO channelAmountLimitBO = new ChannelAmountLimitBO();
        channelAmountLimitBO.setChannelCode(channelCode);
        channelAmountLimitBO.setDate(transDate);
        channelAmountLimitBO.setDailyLimitTotalAmount(channelInfo.getAmount());
        log.info("初始化 channelAmountLimitBO ==>> channelCode={},transDate={} 的缓存对象={}", channelCode, transDate, JSON.toJSONString(channelAmountLimitBO));
        return channelAmountLimitBO;
    }


    private void doChange(ChannelAmountLimitBO channelAmountLimitBO) {
        String curKey = this.getOptionKey(channelAmountLimitBO.getDate());
        String curId = this.genId(channelAmountLimitBO.getChannelCode());
        ChannelAmountLimitBO redisBO = this.findChannelAmountLimitBO(channelAmountLimitBO.getChannelCode(), channelAmountLimitBO.getDate());
        redisBO.setAccumulateAmount(redisBO.getAccumulateAmount() + channelAmountLimitBO.getTransAmount());
        this.redisTemplate.boundHashOps(curKey).put(curId, redisBO);
    }

    /**
     * @param date yyyyMMdd
     * @return
     */
    private String getOptionKey(String date) {
        return RedisKey.fmtKey(RedisKey.CHANNEL_DAILY_AMOUNT_HASH_KEY, date);
    }

    private final String genId(String channelCode) {
        return String.format("CHANNEL_CODE_%s", channelCode);
    }

}
