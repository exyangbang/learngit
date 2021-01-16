package cn.kingnet.utp.scheduler.ext.job;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.*;
import cn.kingnet.utp.scheduler.pdf.OneBankEleReceiptPdf;
import cn.kingnet.utp.trade.common.enums.ElcMakeFlag;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.*;

/**
 * 交易电子回执单生成job
 * 每间隔periodseconds秒运行一次
 * 检测需要发送的通知
 *
 * @author zhongli
 * @date 2019-02-26
 */
@Component
@Slf4j
public class BuildEleReceiptJob {
    private final WorkTask workTask;
    private final ScheduledThreadPoolExecutor dispatchService;
    @Value("${cn.kingnet.utp.schedule.create-ele-receipt.periodseconds}")
    private String periodseconds;

    public BuildEleReceiptJob(OneBankEleReceiptPdf oneBankEleReceiptPdf) {
        ExecutorService createEleService = new ThreadPoolExecutor(4, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200),
                new ThreadFactoryBuilder().setNameFormat("BuildEleReceipt-createEle-%d").build());
        this.workTask = new WorkTask(oneBankEleReceiptPdf, createEleService);
        this.dispatchService = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("BuildEleReceipt-Dispatch-%d").build());
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
        }, 30, Integer.valueOf(periodseconds), TimeUnit.SECONDS);
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
            LambdaLogger.info(log, "交易电子回执单生成开始执行...");
            //交易当前表
            List<TransCurrent> currentList = MybatisDaoImpl.run()
                    .selectList(TransCurrentCondition.builder()
                            .andElcMakeFlagEq(ElcMakeFlag.NOT_MAKE.getFlag())
                            .andTransStatusEq(TransStatus.TRADE_SUCCESS.name())
                            .orderAsc(TransCurrent::getGmtCreate).build().last(" limit 100 "));
            LambdaLogger.info(log, "交易电子回执单>>当前表>>{}条流水待生成...",currentList != null ? currentList.size() : 0);
            if (!CollectionUtils.isEmpty(currentList)) {
                currentList.forEach(current -> {
                    try {
                        createEleService.execute(() -> {
                            this.createEle4Current(current);
                        });
                    } catch (Exception e) {
                        if (e instanceof RejectedExecutionException) {
                            log.error("当前表流水拒绝创建serverTransId[{}]电子回单任务线程,失败原因：{}", current.getServerTransId(), e.getMessage(), e);
                        } else {
                            log.error("当前表流水创建serverTransId[{}]电子回单任务线程异常,异常信息：{}", current.getServerTransId(), e.getMessage(), e);
                        }
                    }
                });
            }

            //交易历史表
            List<TransHistory> historyList = MybatisDaoImpl.run()
                    .selectList(TransHistoryCondition.builder()
                            .andElcMakeFlagEq(ElcMakeFlag.NOT_MAKE.getFlag())
                            .andTransStatusEq(TransStatus.TRADE_SUCCESS.name())
                            .orderAsc(TransHistory::getTransDate).build().last(" limit 80 "));
            LambdaLogger.info(log, "交易电子回执单>>历史表>>{}条流水待生成...",historyList != null ? historyList.size() : 0);
            if (CollectionUtils.isEmpty(historyList)) {
                return;
            }
            historyList.forEach(history -> {
                try {
                    createEleService.execute(() -> {
                        this.createEle4His(history);
                    });
                } catch (Exception e) {
                    if (e instanceof RejectedExecutionException) {
                        log.error("历史表拒绝创建serverTransId[{}]电子回单任务线程,失败原因：{}", history.getServerTransId(), e.getMessage(), e);
                    } else {
                        log.error("历史表创建serverTransId[{}]电子回单任务线程异常,异常信息：{}", history.getServerTransId(), e.getMessage(), e);
                    }
                }
            });
        }

        private void createEle4Current(TransCurrent transCurrent) {
            try {
                ElectronicReceipts electronicReceipt = MybatisDaoImpl.run().selectOne(ElectronicReceiptsCondition.builder().andServerTransIdEq(transCurrent.getServerTransId()).build());
                oneBankEleReceiptPdf.buildTransCurrent(transCurrent,electronicReceipt);
            } catch (Exception e) {
                log.error("serverTransId[{}]创建电子回单异常：{}", transCurrent.getServerTransId(), e.getMessage(), e);
                //回滚缓存
                failUpdateCreate4Current(transCurrent);
            }
        }

        /**
         * 单个记录电子回单创建失败，此线程完成5次尝试后进行记录【创建电子回单标识】字段标为2
         *
         * @param transCurrent
         */
        private void failUpdateCreate4Current(TransCurrent transCurrent) {
            try {
                String key = transCurrent.getServerTransId();
                Integer tint = cache.get(key);
                int total = tint == null ? 1 : tint.intValue() + 1;
                if (total > 5) {
                    MybatisDaoImpl.run().updateById(TransCurrent.builder().id(transCurrent.getId()).elcMakeFlag(ElcMakeFlag.MAKE_FAIL.getFlag()).build());
                    cache.remove(key);
                    return;
                }
                cache.put(key, total);
            } catch (Exception e) {
                log.error("serverTransId[{}] failUpdateCreate出现异常：{}",transCurrent.getServerTransId(), e.getMessage(), e);
            }
        }

        private void createEle4His(TransHistory transHistory) {
            try {
                ElectronicReceipts electronicReceipt = MybatisDaoImpl.run().selectOne(ElectronicReceiptsCondition.builder().andServerTransIdEq(transHistory.getServerTransId()).build());
                oneBankEleReceiptPdf.buildTransHistory(transHistory,electronicReceipt);
            } catch (Exception e) {
                log.error("serverTransId[{}]创建电子回单异常：{}", transHistory.getServerTransId(), e.getMessage(), e);
                //回滚缓存
                failUpdateCreate4His(transHistory);
            }
        }

        /**
         * 单个记录电子回单创建失败，此线程完成5次尝试后进行记录【创建电子回单标识】字段标为2
         *
         * @param content
         */
        private void failUpdateCreate4His(TransHistory content) {
            try {
                String key = content.getServerTransId();
                Integer tint = cache.get(key);
                int total = tint == null ? 1 : tint.intValue() + 1;
                if (total > 5) {
                    MybatisDaoImpl.run().updateById(TransHistory.builder().id(content.getId()).elcMakeFlag(ElcMakeFlag.MAKE_FAIL.getFlag()).build());
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
