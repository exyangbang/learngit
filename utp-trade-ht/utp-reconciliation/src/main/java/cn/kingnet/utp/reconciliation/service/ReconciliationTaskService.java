package cn.kingnet.utp.reconciliation.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.batch.onebank.support.OnebankJobExecutionListener;
import cn.kingnet.utp.reconciliation.batch.onebank.support.OnebankJobRunnable;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecord;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecordCondition;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobKeyGenerator;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.*;

/**
 * @author zhongli
 * @date 2018/9/12
 */
@Component
@Slf4j
public class ReconciliationTaskService {

    private final ExecutorService poolExecutor;
    private final ExecutorService reStartPoolExecutor;
    private final JobLauncher jobLauncher;
    private final JobBuilderFactory jobBuilderFactory;
    private final OnebankJobExecutionListener jobListener;
    private final JobKeyGenerator jobKeyGenerator;

    @Autowired
    @Qualifier("onebankMainStep")
    private Step onebankMainStep;

    @Autowired
    @Qualifier("minusDayReconStep")
    private Step minusDayReconStep;

    public ReconciliationTaskService(JobLauncher jobLauncher, JobBuilderFactory jobBuilderFactory, OnebankJobExecutionListener jobListener, JobKeyGenerator<JobParameters> jobKeyGenerator) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("对账Job线程-%d").build();
        this.jobLauncher = jobLauncher;
        this.jobBuilderFactory = jobBuilderFactory;
        this.jobListener = jobListener;
        this.poolExecutor = Executors.newFixedThreadPool(1, namedThreadFactory);
        this.reStartPoolExecutor = Executors.newFixedThreadPool(1, namedThreadFactory);
        this.jobKeyGenerator = jobKeyGenerator;
    }

    /**
     * 按10个商户一组组成1个 JOB，每组 JOB 在同一个线程池运行，线程池为单个线程
     * 一组 JOB 10个商户分10个区在批量 job线程池中独立运行
     * 对账
     */
    public void doReconciliation(String reconcileDate) {
        Assert.hasText(reconcileDate, "对账日期不能为空");
        poolExecutor.execute(new OnebankJobRunnable(jobLauncher, jobBuilderFactory, onebankMainStep, jobListener, jobKeyGenerator).create(reconcileDate));
    }

    /**
     * 重启对账任务
     * @param reconcileDate
     */
    public void doRestartJob(String reconcileDate) {
        Assert.hasText(reconcileDate, "对账日期不能为空");
        PlusEntityWrapper<MerchantReconcileRecord> wrap = MerchantReconcileRecordCondition.builder().andReconcileDateEq(reconcileDate).build();
        MerchantReconcileRecord reconcileRecord = MybatisDaoImpl.run().selectOne(wrap);
        String finalDate = reconcileDate;
        Assert.notNull(reconcileRecord, () -> "未找到对账记录".concat("reconcileDate=").concat(finalDate));
        JSONObject jObj = JSON.parseObject(reconcileRecord.getJobParams());
        reconcileDate = jObj.getString("reconcileDate");
        reStartPoolExecutor.execute(new OnebankJobRunnable(jobLauncher, jobBuilderFactory, onebankMainStep, jobListener, jobKeyGenerator).create(reconcileDate, reconcileRecord.getJobName()));

        //每次后管重新发起对账，同时异步延时10min后触发[无需到渠道对账标识的记录以及超过N天未对账的 业务处理]
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.MINUTES.sleep(10);
                doMinusDayRecon(finalDate);
            } catch (InterruptedException e) {
                log.error("doRestartJob 子任务 doMinusDayRecon 异常",e);
            }
        });

    }

    /**
     * 只针对交易记录超过N天未进行对账
     * 并且这些交易清算日期字段为空的相关流水进行处理
     * @param reconcileDate
     */
    public void doMinusDayRecon(String reconcileDate){
        Assert.hasText(reconcileDate, "对账日期不能为空");
        poolExecutor.execute(new OnebankJobRunnable(jobLauncher, jobBuilderFactory, minusDayReconStep, jobListener, jobKeyGenerator).create(reconcileDate,null, "minusDayRecon"));
    }
}
