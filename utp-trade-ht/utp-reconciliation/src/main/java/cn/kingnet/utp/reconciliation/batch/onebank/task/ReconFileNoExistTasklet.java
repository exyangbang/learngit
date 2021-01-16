package cn.kingnet.utp.reconciliation.batch.onebank.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 对账文件不存在
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/14 16:50
 */
@Component
@Slf4j
public class ReconFileNoExistTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
        final String reconcileDate = context.get("reconcileDate").toString();
        log.warn("渠道清算日期[{}] << == 获取渠道对账文件时，渠道明确返回该清算日期[{}]无对账单.", reconcileDate, reconcileDate);
        return RepeatStatus.FINISHED;
    }

}
