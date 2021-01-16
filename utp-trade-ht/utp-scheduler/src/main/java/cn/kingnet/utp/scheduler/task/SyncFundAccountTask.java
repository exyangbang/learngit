package cn.kingnet.utp.scheduler.task;

import cn.kingnet.utp.scheduler.data.entity.IndustrySyncLog;
import cn.kingnet.utp.scheduler.service.SyncIndustryAccountService;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @Description 实体账户[资金账户]同步拉取 行内资金明细至本地
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
@Component
public class SyncFundAccountTask {
    private final ExecutorService executorService;
    private SyncIndustryAccountService syncIndustryAccountService;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-fund-account.special-period}")
    private int specialPeriod;
    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-fund-account.normal-period}")
    private int normalPeriod;
    /**
     * 这个时间点内的都要往前推一天开始同步
     */
    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-fund-account.early-time:001500}")
    private String earlyTime;
    /**
     * 是否全量同步
     */
    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.sync-fund-account.sync-all:0}")
    private String syncAll;

    private final AtomicLong normalSyncNum = new AtomicLong(0);
    private final AtomicLong specialSyncNum = new AtomicLong(0);

    public SyncFundAccountTask(SyncIndustryAccountService syncIndustryAccountService) {
        this.syncIndustryAccountService = syncIndustryAccountService;
        this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new ThreadPoolExecutor.DiscardPolicy());
        this.executorService = new ThreadPoolExecutor(4, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("SyncFundAccountTask-%d").build(), new ThreadPoolExecutor.DiscardPolicy());
    }

    /**
     * 初始化间隔每分钟执行 定时任务
     */
    @PostConstruct
    public void init() {
        this.scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                log.info("每天早于这个时间点[{}]内同步行内资金明细时，起始同步日期都要在原有基础上往前推一天", this.earlyTime);
                syncFundAccount();
            } catch (Exception e) {
                log.error("实体账户同步拉取行内资金明细定时任务执行异常：{}", e.getMessage(), e);
            }
        }, 30, 60, TimeUnit.SECONDS);
    }

    /**
     * 间隔时间同步资金账户来款资金明细
     */
    private void syncFundAccount() {
        LambdaLogger.info(log, "资金账户明细同步开始执行...");
        long sTime = System.currentTimeMillis();
        List<FundAccountSyncInfo> fundAccountSyncInfos;
        StringBuilder fundTypeName = new StringBuilder();
        try {
            List<FundAccount> fundAccountList = null;
            if (specialSyncNum.incrementAndGet() % specialPeriod == 0) {
                fundAccountList = syncIndustryAccountService.querySpecialFundAccountList();
                specialSyncNum.set(0L);
                fundTypeName.append("特殊配置");
            }
            if (normalSyncNum.incrementAndGet() % normalPeriod == 0) {
                normalSyncNum.set(0L);
                List<FundAccount> normalFundAccountList = syncIndustryAccountService.queryFundAccountList();
                if (fundAccountList != null) {
                    fundAccountList.addAll(normalFundAccountList);
                } else {
                    fundAccountList = normalFundAccountList;
                }
                fundTypeName.append("&普通");
            }
            if (fundAccountList == null || fundAccountList.isEmpty()) {
                log.error("{}资金账户明细同步终止执行，待同步资金账户集合为空", fundTypeName.toString());
                return;
            }
            List<IndustrySyncLog> lastFundAccountSyncList = syncIndustryAccountService.getFundAccountSyncLog();
            fundAccountSyncInfos = buildFundAccountSyncInfos(fundAccountList, lastFundAccountSyncList);
        } catch (Exception e) {
            log.error("{}资金账户明细同步终止执行，获取资金账户或最近同步信息异常[{}]", fundTypeName.toString(), e.getMessage(), e);
            return;
        }
        if (fundAccountSyncInfos == null || fundAccountSyncInfos.isEmpty()) {
            return;
        }
        CompletableFuture<?>[] completableFutures = fundAccountSyncInfos.stream().map(l -> this.runFundAccountSync(l)).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
        LambdaLogger.info(log, "共{}个{}资金账户明细同步完成，共耗时:[{}ms]", fundAccountSyncInfos.size(), fundTypeName.toString(), (System.currentTimeMillis() - sTime));

    }

    private List<FundAccountSyncInfo> buildFundAccountSyncInfos(List<FundAccount> fundAccountList, List<IndustrySyncLog> lastFundAccountSyncList) {
        Set<String> bankAccountNoSet = Sets.newHashSet();
        boolean isEarlyLocalTime = isEarlyLocalTime();
        List<FundAccountSyncInfo> fundAccountSyncInfos =
                fundAccountList.stream().filter(fundAccount -> {
                    if (bankAccountNoSet.contains(fundAccount.getBankAccountNo())) {
                        return false;
                    } else {
                        bankAccountNoSet.add(fundAccount.getBankAccountNo());
                    }
                    if (!TrueOrFalseStatus.TRUE.value().equals(fundAccount.getStatus())) {
                        LambdaLogger.error(log, "资金账户[{}:{}] 状态不可用,暂无需同步资金明细", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName());
                        return false;
                    }
                    if (null == FundAccType.resolve(fundAccount.getAccountType())) {
                        LambdaLogger.error(log, "资金账户[{}:{}] 账户类型[{}]暂不支持,暂无需同步资金明细", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), fundAccount.getAccountType());
                        return false;
                    }
                    return true;
                }).map(fundAccount -> createFundAccountSyncInfo(fundAccount, lastFundAccountSyncList, isEarlyLocalTime)).collect(Collectors.toList());

        return fundAccountSyncInfos;
    }


    /**
     * 获取资金账户上次同步记录
     */
    private FundAccountSyncInfo createFundAccountSyncInfo(FundAccount fundAccount, List<IndustrySyncLog> lists, boolean isEarlyLocalTime) {
        FundAccountSyncInfo.FundAccountSyncInfoBuilder builder = FundAccountSyncInfo.builder();
        builder.fundAccount(fundAccount).fundAccountNo(fundAccount.getBankAccountNo()).bankAccountName(fundAccount.getBankAccountName());
        IndustrySyncLog curFundAccountSyncLog = null;
        if (!CollectionUtils.isEmpty(lists)) {
            curFundAccountSyncLog = lists.stream().filter(syncLog -> fundAccount.getBankAccountNo().equals(syncLog.getFundAccountNo())).findFirst().orElse(null);
        }
        if (curFundAccountSyncLog == null) {
            builder.lastDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)).lastTime("000000");
        } else {
            if (StringUtil.isBlank(curFundAccountSyncLog.getLastDate()) || curFundAccountSyncLog.getLastDate().length() != 8) {
                builder.lastDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            } else {
                builder.lastDate(curFundAccountSyncLog.getLastDate());
            }
            if (StringUtil.isBlank(curFundAccountSyncLog.getLastTime()) || curFundAccountSyncLog.getLastTime().length() != 6) {
                builder.lastTime("000000");
            } else {
                builder.lastTime(curFundAccountSyncLog.getLastTime());
            }
        }
        FundAccountSyncInfo fundAccountSyncInfo = builder.build();
        if (isEarlyLocalTime) {
            String minusLastDate = LocalDate.parse(fundAccountSyncInfo.getLastDate(), DateTimeFormatter.BASIC_ISO_DATE).minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE);
            fundAccountSyncInfo.setLastDate(minusLastDate);
            fundAccountSyncInfo.setLastTime("000000");
        }
        return fundAccountSyncInfo;
    }

    private boolean isEarlyLocalTime() {
        LocalTime curEarlyTime = LocalTime.parse(this.earlyTime, DateTimeFormatter.ofPattern("HHmmss"));
        return LocalTime.now().isBefore(curEarlyTime);
    }


    /**
     * 同步资金账户来款资金明细
     *
     * @param lastLog
     * @return
     */
    private CompletableFuture<FundAccountSyncInfo> runFundAccountSync(FundAccountSyncInfo lastLog) {
        return CompletableFuture.supplyAsync(() -> {
            String startDate = null, endDate = null, startTime = null, endTime = null;
            long sTime = System.currentTimeMillis();
            try {
                if (isFullSync()) {
                    log.warn("当前激活环境[{}],已配置[{}]开启资金账户明细全量同步.", activeProfile, this.syncAll);
                } else {
                    LocalDate lStartDate = LocalDate.parse(lastLog.getLastDate(), DateTimeFormatter.BASIC_ISO_DATE);
                    LocalDate lEndDate = lStartDate.plusDays(5);
                    LocalDate curDate = LocalDate.now();
                    startDate = lastLog.getLastDate();
                    startTime = lastLog.getLastTime();
                    //默认每次至多拉取5天内数据
                    if (lEndDate.compareTo(curDate) >= 0) {
                        endDate = curDate.format(DateTimeFormatter.BASIC_ISO_DATE);
                        endTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
                    } else {
                        endDate = lEndDate.format(DateTimeFormatter.BASIC_ISO_DATE);
                        endTime = "235959";
                    }
                }
                LambdaLogger.info(log, "资金账户[{}:{}] {}{}-{}{}期间内账户明细同步开始执行.", lastLog.getFundAccountNo(), lastLog.getBankAccountName(), startDate, startTime, endDate, endTime);
                syncIndustryAccountService.syncBankAccountTransDetail(lastLog.getFundAccount(), startDate, startTime, endDate, endTime);
                syncIndustryAccountService.syncFundAccountBalance(lastLog.getFundAccount());
                LambdaLogger.info(log, "资金账户[{}:{}] {}{}-{}{}期间内账户明细同步执行完成.共耗时[{}ms]", lastLog.getFundAccountNo(), lastLog.getBankAccountName(), startDate, startTime, endDate, endTime, (System.currentTimeMillis() - sTime));
            } catch (Exception e) {
                LambdaLogger.error(log, "资金账户[{}:{}] {}{}-{}{}期间内账户明细同步异常,共耗时[{}ms].[{}]", lastLog.getFundAccountNo(), lastLog.getBankAccountName(), startDate, startTime, endDate, endTime, (System.currentTimeMillis() - sTime), e.getMessage(), e);
            }
            return lastLog;
        }, executorService);
    }

    /**
     * 仅在pre、live环境下 华通核心交易日期才是自然日，其他环境只能全量同步资金明细
     * 激活环境 [dev,test,sit,uat,pre,live]
     *
     * @return
     */
    private boolean isFullSync() {
        //线上环境绝不开启全量同步，可后管指定同步起始日期
        if("live".equalsIgnoreCase(activeProfile)){
            return false;
        }
        //其他环境根据配置文件指定开启
        if ("1".equals(this.syncAll) || "true".equalsIgnoreCase(this.syncAll)) {
            return true;
        }
        return false;
    }

    @Getter
    @Setter
    @Builder
    private static class FundAccountSyncInfo implements Serializable {
        /**
         * 资金账户表中的资金账号
         */
        private String fundAccountNo;

        /**
         * 上次同步日期 yyyyMMdd
         */
        private String lastDate;

        /**
         * 最后同步时间HHmm
         */
        private String lastTime;
        private String bankAccountName;

        private FundAccount fundAccount;

    }


}
