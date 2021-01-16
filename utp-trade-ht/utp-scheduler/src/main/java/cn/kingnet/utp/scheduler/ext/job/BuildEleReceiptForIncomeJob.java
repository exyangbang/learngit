package cn.kingnet.utp.scheduler.ext.job;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.*;
import cn.kingnet.utp.scheduler.pdf.OneBankEleReceiptPdf;
import cn.kingnet.utp.trade.common.enums.ElcMakeFlag;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 订单入金类电子回执单生成job
 * 每间隔periodseconds秒运行一次
 * 检测需要发送的通知
 *
 * @author zhongli
 * @date 2019-02-26
 */
@Component
@Slf4j
public class BuildEleReceiptForIncomeJob {
    private final WorkTask workTask;
    private final ScheduledThreadPoolExecutor dispatchService;
    @Value("${cn.kingnet.utp.schedule.create-ele-receipt.periodseconds}")
    private String periodseconds;

    public BuildEleReceiptForIncomeJob(OneBankEleReceiptPdf oneBankEleReceiptPdf) {
        ExecutorService createEleService = new ThreadPoolExecutor(4, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200),
                new ThreadFactoryBuilder().setNameFormat("BuildEleReceiptForIncome-createEle-%d").build());
        this.workTask = new WorkTask(oneBankEleReceiptPdf, createEleService);
        this.dispatchService = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("BuildEleReceiptForIncome-Dispatch-%d").build());
    }

    @PostConstruct
    public void init() {
        run();
    }

    private void run() {
        dispatchService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                workTask.run();
            }
        }, 50, Integer.valueOf(periodseconds), TimeUnit.SECONDS);
    }

    static class WorkTask implements Runnable {
        private final OneBankEleReceiptPdf oneBankEleReceiptPdf;
        private ConcurrentMap<String, Integer> cache = new ConcurrentHashMap();
        private final ExecutorService createEleService;

        public WorkTask(OneBankEleReceiptPdf oneBankEleReceiptPdf, ExecutorService createEleService) {
            this.oneBankEleReceiptPdf = oneBankEleReceiptPdf;
            this.createEleService = createEleService;
        }

        @Override
        public void run() {
            LambdaLogger.info(log, "订单入金类电子回执单生成开始执行...");
            List<ChannelIncomeFlow> channelIncomeFlowList = MybatisDaoImpl.run()
                    .selectList(ChannelIncomeFlowCondition.builder()
                            .andElcMakeFlagEq(ElcMakeFlag.NOT_MAKE.getFlag())
                            .andHandleFlagEq(TrueOrFalseStatus.TRUE.value())
                            .orderAsc(ChannelIncomeFlow::getGmtCreate).build().last(" limit 100"));
            LambdaLogger.info(log, "订单入金类电子回执单 >> 入金流水表 >> {}条流水待生成...",channelIncomeFlowList != null ? channelIncomeFlowList.size() : 0);
            if (!CollectionUtils.isEmpty(channelIncomeFlowList)) {
                channelIncomeFlowList.forEach(channelIncomeFlow -> {
                    try {
                        createEleService.execute(() -> {
                            this.createEleRec(channelIncomeFlow);
                        });
                    } catch (Exception e) {
                        if (e instanceof RejectedExecutionException) {
                            log.error("拒绝创建入金流水coreNo[{}]电子回单任务线程,失败原因：{}", channelIncomeFlow.getCoreNo(), e.getMessage(), e);
                        } else {
                            log.error("创建入金流水coreNo[{}]电子回单任务线程异常,异常信息：{}", channelIncomeFlow.getCoreNo(), e.getMessage(), e);
                        }
                    }
                });
            }
        }

        private void createEleRec(ChannelIncomeFlow channelIncomeFlow) {
            try {
                if (channelIncomeFlow == null) {
                    return;
                }
                Date date = channelIncomeFlow.getGmtCreate();
                String trdate = "";
                String trtime = "";
                if (date == null) {
                    trdate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
                    trtime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
                } else {
                    LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
                    trdate = ldt.format(DateTimeFormatter.BASIC_ISO_DATE);
                    trtime = ldt.format(DateTimeFormatter.ofPattern("HHmmss"));
                }
                TransHistory history = TransHistory.builder()
                        //随便给一个交易类型不与有交易流水的冲突就行|单独定义一个渠道入金电子回单
                        .tradeType(TradeType.CHANNEL_INCOME_RECEIPT.getCode())
                        .payeeAccount(channelIncomeFlow.getAccNo())
                        .payeeName(channelIncomeFlow.getAccName())
                        .payerAcctNo(channelIncomeFlow.getExAcctNo())
                        .payerName(channelIncomeFlow.getExAcctName())
                        .showPayeeAccountNo(channelIncomeFlow.getAccNo())
                        .showPayeeAccountName(channelIncomeFlow.getAccName())
                        .showPayerAccountNo(channelIncomeFlow.getExAcctNo())
                        .showPayerAccountName(channelIncomeFlow.getExAcctName())
                        .summaryDescription(channelIncomeFlow.getRemark())
                        .payeeOpbkName(CommonConstants.payerOpbkName)
                        .payerOpbkName(channelIncomeFlow.getBankName())
                        .transAmount(channelIncomeFlow.getAmt())
                        .reconcileDate(StringUtils.isBlank(channelIncomeFlow.getTranDate()) ? trdate : channelIncomeFlow.getTranDate())
                        .transDate(trdate)
                        .transTime(trtime)
                        .clientTransId(channelIncomeFlow.getCoreNo())
                        .serverTransId(channelIncomeFlow.getCoreNo())
                        .id(channelIncomeFlow.getId())
                        .userType("9090")
                        .industryCode(channelIncomeFlow.getIndustryCode())
                        .build();
                ElectronicReceipts electronicReceipt = MybatisDaoImpl.run().selectOne(ElectronicReceiptsCondition.builder().andServerTransIdEq(history.getServerTransId()).build());
                oneBankEleReceiptPdf.buildTransHistory(history,electronicReceipt);
            } catch (Exception e) {
                log.error("核心主交易流水(订单号)[{}]创建电子回单异常：{}", channelIncomeFlow.getCoreNo(), e.getMessage(), e);
                failUpdateCreate(channelIncomeFlow);
            }
        }

        /**
         * 单个记录电子回单创建失败，此线程完成5次尝试后进行记录【创建电子回单标识】字段标为2
         *
         * @param channelIncomeFlow
         */
        protected void failUpdateCreate(ChannelIncomeFlow channelIncomeFlow) {
            try {
                String key = channelIncomeFlow.getCoreNo();
                Integer tint = cache.get(key);
                int total = tint == null ? 1 : tint.intValue() + 1;
                if (total > 5) {
                    MybatisDaoImpl.run().updateById(ChannelIncomeFlow.builder().id(channelIncomeFlow.getId()).elcMakeFlag(ElcMakeFlag.MAKE_FAIL.getFlag()).build());
                    cache.remove(key);
                    return;
                }
                cache.put(key, total);
            } catch (Exception e) {
                log.error("failUpdateCreate 出现异常：{}", e.getMessage(), e);
            }
        }

    }
}
