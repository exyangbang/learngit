package cn.kingnet.utp.reconciliation.batch.onebank.support;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecord;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecordCondition;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description : 华通对账处理
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 15:12
 */
@Slf4j
public class OnebankJobRunnable implements Runnable{

    private final JobLauncher jobLauncher;
    private final JobBuilderFactory jobBuilderFactory;
    private final Step onebankMainStep;
    private final OnebankJobExecutionListener onebankJobExecutionListener;
    private final JobKeyGenerator<JobParameters> jobKeyGenerator;
    private String reconcileDate;
    private String jobName;
    private String jobNameHead;

    public OnebankJobRunnable(JobLauncher jobLauncher, JobBuilderFactory jobBuilderFactory, Step onebankMainStep, OnebankJobExecutionListener onebankJobExecutionListener, JobKeyGenerator<JobParameters> jobKeyGenerator) {
        this.jobLauncher = jobLauncher;
        this.jobBuilderFactory = jobBuilderFactory;
        this.onebankMainStep = onebankMainStep;
        this.onebankJobExecutionListener = onebankJobExecutionListener;
        this.jobKeyGenerator = jobKeyGenerator;
    }

    public OnebankJobRunnable create(String reconcileDate) {
        this.reconcileDate = reconcileDate;
        return this;
    }

    public OnebankJobRunnable create(String reconcileDate, String jobName) {
        this.reconcileDate = reconcileDate;
        this.jobName = jobName;
        return this;
    }

    public OnebankJobRunnable create(String reconcileDate, String jobName, String jobNameHead) {
        this.reconcileDate = reconcileDate;
        this.jobName = jobName;
        this.jobNameHead = jobNameHead;
        return this;
    }

    @Override
    public void run() {
        JobParameters jobParameters = new JobParametersBuilder().addString("reconcileDate", reconcileDate).toJobParameters();
        try {
            if (StringUtils.isEmpty(this.jobName)) {
                String key = jobKeyGenerator.generateKey(jobParameters);
                StringBuilder jobNameHead = new StringBuilder("对账-");
                if (!StringUtils.isEmpty(this.jobNameHead)) {
                    jobNameHead.append(this.jobNameHead + "-");
                }
                this.jobName = jobNameHead.append(reconcileDate).append("#").append(key).toString();
                int count = MybatisDaoImpl.run().selectCount(MerchantReconcileRecordCondition.builder().andReconcileDateEq(reconcileDate).build());
                if (count == 0) {
                    Map<String, String> map = jobParameters.getParameters().entrySet().stream()
                            .filter(entry -> entry.getValue().isIdentifying())
                            .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toString()));
                    MerchantReconcileRecord recode = MerchantReconcileRecord.builder()
                            .reconcileDate(reconcileDate)
                            .reconcileStatus(TrueOrFalseStatus.FALSE.value())
                            .jobName(jobName)
                            .jobParams(JSON.toJSONString(map))
                            .gmtCreate(new Date())
                            .gmtModified(new Date())
                            .build();
                    MybatisDaoImpl.run().insert(recode);
                }
            }
        }catch (Exception e){
            log.error("构建该Job[{}]任务异常:{}",this.jobName,e.getMessage(), e);
        }
        try {
            jobLauncher.run(bulidJob(jobName), jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            log.error("该Job已存在且执行完成，状态为COMPLETED", e);
        } catch (JobRestartException e) {
            log.error("该Job重启失败", e);
        } catch (JobInstanceAlreadyCompleteException e) {
            log.error("该Job已经完成", e);
        } catch (JobParametersInvalidException e) {
            log.error("该Job参数无效", e);
        }catch (Exception e){
            log.error("执行该Job[{}]异常:{}",this.jobName,e.getMessage(), e);
        }
    }

    /**
     * 创建 job
     *
     * @param name
     * @return
     */
    public Job bulidJob(String name) {
        return jobBuilderFactory.get(name).start(onebankMainStep).listener(onebankJobExecutionListener).build();
    }
}
