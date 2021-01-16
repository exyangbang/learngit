package cn.kingnet.utp.scheduler.task;

import cn.kingnet.utp.scheduler.data.entity.Industry;
import cn.kingnet.utp.scheduler.data.entity.IndustrySyncLog;
import cn.kingnet.utp.scheduler.service.SyncIndustryAccountService;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.enums.VirtualAccountType;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @Description 客户号根据本地实体账户入金明细匹配白名单|来款账户来上账操作
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
@Component
public class SyncIndustryAccountTask {

    private ExecutorService executorService;
    private SyncIndustryAccountService syncIndustryAccountService;
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-account.special-period}")
    private int specialPeriod;
    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-account.normal-period}")
    private int normalPeriod;
    private final AtomicLong normalSyncNum = new AtomicLong(0);
    private final AtomicLong specialSyncNum = new AtomicLong(0);

    public SyncIndustryAccountTask(SyncIndustryAccountService syncIndustryAccountService) {
        this.syncIndustryAccountService = syncIndustryAccountService;
        this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new ThreadPoolExecutor.DiscardPolicy());
        this.executorService = new ThreadPoolExecutor(4, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("SyncIndustryAccountTask-%d").build(), new ThreadPoolExecutor.DiscardPolicy());
    }

    @PostConstruct
    public void init() {
        this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                syncFunctionAccount();
            } catch (Exception e) {
                log.error("功能账户本地同步上账定时任务执行异常：{}", e.getMessage(), e);
            }
            try {
                syncIndustryAndSubAccount();
            } catch (Exception e) {
                log.error("平台账户&子账户本地同步上账定时任务执行异常：{}", e.getMessage(), e);
            }
        }, 60, 60, TimeUnit.SECONDS);
    }

    private void syncFunctionAccount() {
        LambdaLogger.info(log, "功能账户本地同步上账 开始执行...");
        long sTime = System.currentTimeMillis();
        try {
            syncIndustryAccountService.syncBankAccDetail2LocalFunctionAccount();
            LambdaLogger.info(log, "功能账户本地同步上账 执行完成，共耗时:{}毫秒", (System.currentTimeMillis() - sTime));
        } catch (Exception e) {
            LambdaLogger.error(log, "功能账户本地同步上账 执行异常，共耗时:{}毫秒 [{}]", (System.currentTimeMillis() - sTime), e.getMessage(), e);
        }
    }


    /**
     * 平台客户号 入账处理：间隔时间同步
     */
    private void syncIndustryAndSubAccount() {
        LambdaLogger.info(log, "平台账户&子账户本地同步上账开始执行...");
        long sTime = System.currentTimeMillis();
        final List<IndustryAccountSyncInfo> industryAccountSyncInfos;
        StringBuilder industryTypeName = new StringBuilder();
        try {
            List<Industry> industryList = null;
            if (specialSyncNum.incrementAndGet() % specialPeriod == 0) {
                specialSyncNum.set(0L);
                industryList = syncIndustryAccountService.getNeedSpecialAccountSyncIndustryList();
                industryTypeName.append("特殊配置");
            }
            if (normalSyncNum.incrementAndGet() % normalPeriod == 0) {
                normalSyncNum.set(0L);
                List<Industry> normalIndustryList = syncIndustryAccountService.getNeedAccountSyncIndustryList();
                if (industryList != null) {
                    industryList.addAll(normalIndustryList);
                } else {
                    industryList = normalIndustryList;
                }
                industryTypeName.append("&普通");
            }
            if (CollectionUtils.isEmpty(industryList)) {
                log.info("{}平台账户&子账户本地同步上账终止执行，查无可用的平台客户", industryTypeName.toString());
                return;
            }
            List<IndustrySyncLog> lastIndustrySyncList = syncIndustryAccountService.getIndustrySyncLog();
            industryAccountSyncInfos = buildIndustryAccountSyncInfos(industryList, lastIndustrySyncList);
        } catch (Exception e) {
            log.error("{}平台账户&子账户本地同步上账终止执行，获取平台客户集合或最近同步信息异常[{}]", industryTypeName.toString(), e.getMessage(), e);
            return;
        }
        if (CollectionUtils.isEmpty(industryAccountSyncInfos)) {
            log.info("{}平台账户&子账户本地同步上账终止执行，查无可用的平台客户", industryTypeName.toString());
        }
        CompletableFuture<?>[] completableFutures = industryAccountSyncInfos.stream().map(this::runSubAccountAndIndustrySync).toArray(CompletableFuture[]::new);
        //等待所有任务执行完成
        CompletableFuture.allOf(completableFutures).join();
        LambdaLogger.info(log, "共计{} {}平台账户&子账户本地同步上账完成，共耗时:{}毫秒", industryAccountSyncInfos.size(), industryTypeName.toString(), (System.currentTimeMillis() - sTime));
    }

    private List<IndustryAccountSyncInfo> buildIndustryAccountSyncInfos(List<Industry> industryList, List<IndustrySyncLog> lastIndustrySyncList) {
        Set<String> industryCodeSet = Sets.newHashSet();
        List<IndustryAccountSyncInfo> industryAccountSyncInfos = industryList.stream().filter(industry -> {
            if (industryCodeSet.contains(industry.getCode())) {
                return false;
            } else {
                industryCodeSet.add(industry.getCode());
            }
            if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
                LambdaLogger.error(log, "该客户号[{}:{}]状态不可用，暂无法同步上账", industry.getCode(), industry.getName());
                return false;
            }
            if (VirtualAccountType.INDUSTRY.getType().equals(industry.getIndustryType()) ||
                    VirtualAccountType.COLLECTION.getType().equals(industry.getIndustryType())
            ) {
                return true;
            } else {
                LambdaLogger.error(log, "该客户号[{}:{}]账户类型[{}]不是平台账户或归集账户，暂无法同步上账", industry.getCode(), industry.getName(), industry.getIndustryType());
                return false;
            }
        }).map(industry -> createIndustryAccountSyncInfo(industry, lastIndustrySyncList)).collect(Collectors.toList());
        return industryAccountSyncInfos;
    }

    private IndustryAccountSyncInfo createIndustryAccountSyncInfo(Industry industry, List<IndustrySyncLog> lastIndustrySyncList) {
        IndustryAccountSyncInfo.IndustryAccountSyncInfoBuilder builder = IndustryAccountSyncInfo.builder();
        builder.industry(industry).industryCode(industry.getCode()).industryName(industry.getName());
        if (!CollectionUtils.isEmpty(lastIndustrySyncList)) {
            for (IndustrySyncLog industrySyncLog : lastIndustrySyncList) {
                if (industry.getCode().equals(industrySyncLog.getIndustryCode())) {
                    return builder.lastDate(industrySyncLog.getLastDate()).build();
                }
            }
        }
        return builder.lastDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)).build();
    }

    /**
     * 平台账户&子账户本地同步上账
     *
     * @param lastLog
     * @return
     */
    private CompletableFuture<IndustryAccountSyncInfo> runSubAccountAndIndustrySync(IndustryAccountSyncInfo lastLog) {
        return CompletableFuture.supplyAsync(() -> {
            long sTime = System.currentTimeMillis();
            try {
                LambdaLogger.info(log, "平台客户[{}:{}] 子账户同步上账处理 开始执行...", lastLog.getIndustryCode(), lastLog.getIndustryName());
                syncIndustryAccountService.syncBankAccDetail2LocalSubAccount(lastLog.getIndustryCode());
                LambdaLogger.info(log, "平台客户[{}:{}] 子账户同步上账处理 执行完成共耗时[{}ms]", lastLog.getIndustryCode(), lastLog.getIndustryName(), (System.currentTimeMillis() - sTime));
            } catch (Exception e) {
                LambdaLogger.error(log, "平台客户[{}:{}] 子账户同步上账 执行异常共耗时[{}ms] [{}]", lastLog.getIndustryCode(), lastLog.getIndustryName(), (System.currentTimeMillis() - sTime), e.getMessage(), e);
            }
            return lastLog;
        }, executorService).thenApplyAsync(syncInfo -> {
            long sTime = System.currentTimeMillis();
            try {
                LambdaLogger.info(log, "平台客户[{}:{}] 平台账户同步上账处理 开始执行...", syncInfo.getIndustryCode(), syncInfo.getIndustryName());
                ServerResponseDTO responseDTO = syncIndustryAccountService.syncBankAccDetail2LocalIndustry(syncInfo.getIndustryCode());
                if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
                    LambdaLogger.info(log, "平台客户[{}:{}] 平台同步上账处理 执行完成共耗时[{}ms] {}", syncInfo.getIndustryCode(), syncInfo.getIndustryName(), (System.currentTimeMillis() - sTime), responseDTO != null ? responseDTO.getMessage() : "");
                } else {
                    LambdaLogger.error(log, "平台客户[{}:{}] 平台同步上账处理 执行完成共耗时[{}ms] {}", syncInfo.getIndustryCode(), syncInfo.getIndustryName(), (System.currentTimeMillis() - sTime), responseDTO != null ? responseDTO.getMessage() : "");
                }
            } catch (Exception e) {
                LambdaLogger.error(log, "平台客户[{}:{}] 平台账户同步上账 执行异常共耗时[{}ms] [{}]", syncInfo.getIndustryCode(), syncInfo.getIndustryName(), (System.currentTimeMillis() - sTime), e.getMessage(), e);
            }
            return syncInfo;
        }, executorService);
    }

    @Getter
    @Setter
    @Builder
    private static class IndustryAccountSyncInfo implements Serializable {
        /**
         * 资金账户表中的资金账号
         */
        private String industryCode;

        /**
         * 上次同步日期 yyyyMMdd
         */
        private String lastDate;

        /**
         * 最后同步时间HHmm
         */
        private String lastTime;
        private String industryName;

        private Industry industry;


    }

}
