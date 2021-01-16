package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecord;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecordCondition;
import cn.kingnet.utp.reconciliation.exception.UpdateRecordTaskletException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 更新商户对账记录状态
 *
 * @author zhongli
 * @date 2018/9/13
 */
@Component
@Slf4j
public class UpdateRecordTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try {
            Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
            String reconcileDate = context.get("reconcileDate").toString();
            PlusEntityWrapper<MerchantReconcileRecord> wrap = MerchantReconcileRecordCondition.builder().andReconcileDateEq(reconcileDate).build();
            String updateSql = String.format("reconcile_status = '%s',gmt_modified = '%s'","1", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
            MybatisDaoImpl.run().updateForSet(updateSql, wrap);
        } catch (Exception e) {
            throw new UpdateRecordTaskletException("更新商户对账记录状态异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }
}
