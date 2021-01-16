package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.configuration.UtpProperties;
import cn.kingnet.utp.scheduler.data.entity.OutsideTransOrder;
import cn.kingnet.utp.scheduler.data.entity.OutsideTransOrderCondition;
import cn.kingnet.utp.scheduler.task.service.OutsideTransFLowService;
import cn.kingnet.utp.trade.common.enums.PayMode;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/29
 */
@Component
@Slf4j
public class MixTransDetailBackUpTask {
    private final ExecutorService executorService;
    /**
     * 融合支付中特殊平台客户的流水缓存配置 industryCode:cacheTime(单位天)
     */
    private final Map<String, Long> mixTransMap;
    @Resource
    private OutsideTransFLowService outsideTransFLowService;

    public MixTransDetailBackUpTask(UtpProperties utpProperties) {
        this.mixTransMap = utpProperties.getMixTransMap();
        this.executorService = new ThreadPoolExecutor(4, 16,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(300), new ThreadFactoryBuilder().setNameFormat("MixTransDetailBackUpTask-%d").build(), new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 每天凌晨3点执行备份
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.mixTransDetailBackUpTask}")
    public void balancePaymentTnSettleDaily() {
        LambdaLogger.info(log, "融合支付流水明细备份任务 开始执行...");
        long sTime = System.currentTimeMillis();
        String curDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        try {
            PlusEntityWrapper<OutsideTransOrder> condition = OutsideTransOrderCondition.builder()
                    .andPayModeEq(PayMode.MIXPAYFLOW.getType()).andFileConvertFlagEq(0)
                    .andUploadStatusEq("SUCCESS").build();

            List<OutsideTransOrder> mixTransOrders = MybatisDaoImpl.run().selectList(condition);
            if (mixTransOrders == null || mixTransOrders.isEmpty()) {
                LambdaLogger.info(log, logger -> logger.info("[]查无融合支付流水待备份记录", curDate));
                return;
            }

            CompletableFuture[] cfs = mixTransOrders.stream().filter(o -> {
                String industryCode = o.getIndustryCode();
                Date createDate = o.getGmtCreate();
                if (StringUtil.isBlank(industryCode) || createDate == null) {
                    return false;
                }
                //未配置默认92天
                long delayDays = (this.mixTransMap == null || this.mixTransMap.get(industryCode) == null) ? 92L : this.mixTransMap.get(industryCode);
                //createDate + delayDays < curDateTime
                if (LocalDateTime.ofInstant(createDate.toInstant(), ZoneId.systemDefault()).plusDays(delayDays).isBefore(LocalDateTime.now())) {
                    return true;
                }
                return false;
            }).map(mix -> CompletableFuture.supplyAsync(() -> {
                try {
                    outsideTransFLowService.backupOutsideTransFlow(mix);
                    log.info("备份[{}]-批次号[{}]下支付流水成功", mix.getIndustryCode(), mix.getTransOrderId());
                } catch (Exception e) {
                    log.error("备份[{}]-批次号[{}]下支付流水异常：{}", mix.getIndustryCode(), mix.getTransOrderId(), e.getMessage(), e);
                }
                return mix;
            }, executorService)).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(cfs).join();
            LambdaLogger.info(log, "共{} 批次融合支付备份完成，共耗时:{}毫秒", cfs.length, (System.currentTimeMillis() - sTime));
        } catch (Exception e) {
            log.error("批次融合支付备份异常:{}", e.getMessage(), e);
        }
    }

}
