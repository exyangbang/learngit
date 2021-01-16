package cn.kingnet.utp.scheduler.ext.job;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.product.api.account.InnerAccountWithdrawHandler;
import cn.kingnet.utp.scheduler.data.entity.TransCurrent;
import cn.kingnet.utp.scheduler.data.entity.TransCurrentCondition;
import cn.kingnet.utp.scheduler.data.entity.TransHistory;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 交易结果查询job
 * 每间隔periodseconds秒运行一次
 */
@Component
@Slf4j
public class QueryTransStatusJob {
    private final WorkTask workTask;
    private final ScheduledThreadPoolExecutor dispatchService;
    @Value("${cn.kingnet.utp.schedule.query-trans-status.periodseconds:10}")
    private String periodseconds;

    public QueryTransStatusJob(InnerAccountWithdrawHandler innerAccountWithdrawHandler, ServerIdGenerate serverIdGenerate) {
        this.workTask = new WorkTask(innerAccountWithdrawHandler, serverIdGenerate);
        this.dispatchService = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("QueryTransStatusJob-%d").build());
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
        }, 45, Integer.valueOf(periodseconds), TimeUnit.SECONDS);
    }

    static class WorkTask implements Runnable {
        private final InnerAccountWithdrawHandler innerAccountWithdrawHandler;
        private final ServerIdGenerate serverIdGenerate;
        private ConcurrentMap<String, Integer> cache = new ConcurrentHashMap();

        public WorkTask(InnerAccountWithdrawHandler innerAccountWithdrawHandler, ServerIdGenerate serverIdGenerate) {
            this.innerAccountWithdrawHandler = innerAccountWithdrawHandler;
            this.serverIdGenerate = serverIdGenerate;
        }

        @Override
        public void run() {
            try {
                List<TransCurrent> transCurrentList = MybatisDaoImpl.run()
                        .selectPage(TransCurrentCondition.builder()
                                .andNeedChannelReconcileEq(TrueOrFalseStatus.TRUE.value())
                                .and().andTransStatusNe(TransStatus.TRADE_SUCCESS.name()).orTransStatusIsNull()
                                .and().andTransStatusNe(TransStatus.TRADE_FAILURE.name()).orTransStatusIsNull()
                                .and()
                                .andQueryTimeLe(3)
                                .andGmtCreateLe(Date.from(LocalDateTime.now().minusMinutes(10).toInstant(ZoneOffset.of("+8"))))
                                .orderAsc(TransHistory::getTransDate)
                                .orderAsc(TransCurrent::getTransTime)
                                .build(), 1, 10);
                if (CollectionUtils.isEmpty(transCurrentList)) {
                    return;
                }
                transCurrentList.forEach(transCurrent -> {
                    doQueryStatus(transCurrent.getId(), transCurrent.getIndustryCode(), transCurrent.getServerTransId());
                });
            } catch (Exception e) {
                log.error("定时任务:交易状态查询异常：{}", e.getMessage(), e);
            }
        }


        @Async
        public void doQueryStatus(long id, String industryCode, String origServerTransId) {
            try {
                innerAccountWithdrawHandler.queryTransStatus(industryCode, serverIdGenerate.generateClientTransId(), origServerTransId);
            } catch (Exception e) {
                log.error("serverTransId[{}]交易状态查询异常：{}", origServerTransId, e.getMessage(), e);
            } finally {
                updateQueryTime(id, origServerTransId);
            }
        }

        protected void updateQueryTime(long id, String serverTransId) {
            try {
                Integer tint = cache.get(serverTransId);
                int total = tint == null ? 1 : tint.intValue() + 1;
                if (total > 3) {
                    MybatisDaoImpl.run().updateById(TransCurrent.builder().id(id).gmtModified(new Date()).queryTime(total).build());
                    cache.remove(serverTransId);
                    return;
                }
                cache.put(serverTransId, total);
            } catch (Exception e) {
                log.error("更新交易状态查询次数 出现异常：{}", e.getMessage(), e);
            }
        }

    }
}
