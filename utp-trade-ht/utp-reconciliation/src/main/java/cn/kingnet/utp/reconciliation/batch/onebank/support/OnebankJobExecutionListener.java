package cn.kingnet.utp.reconciliation.batch.onebank.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @Description : 华通对账任务监听
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 9:18
 */
@Component
@Slf4j
public class OnebankJobExecutionListener implements JobExecutionListener {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime.set(System.currentTimeMillis());
        log.info("华通对账任务开始:{}",jobExecution.getJobParameters());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("华通对账任务处理结束,任务耗时：{}", (System.currentTimeMillis() - startTime.get().longValue()) + " ms");
    }
}
