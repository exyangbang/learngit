package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.data.mapper.TransCurrentMapper;
import cn.kingnet.utp.reconciliation.data.mapper.TransHistoryMapper;
import cn.kingnet.utp.reconciliation.exception.MoveTradeToHistoryTaskletException;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 迁移商户当日交易流水到历史流水表中
 *
 * @author zhongli
 * @date 2018/9/13
 */
@Component
@Slf4j
public class MoveTradeToHistoryTasklet implements Tasklet {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try {
            Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
            String reconcileDate = context.get("reconcileDate").toString();
            Map<String, Object> map = Maps.newHashMap();
            map.put("reconcileDate", reconcileDate);
            map.put("transStatus", TransStatus.TRADE_SUCCESS.name());
            //当前清算日期等于对账日期并且交易明确状态并且是需要进入历史表的记录，才迁移到历史流水表
            MybatisDaoImpl.of(TransHistoryMapper.class).insertBySql("moveTradeFromCurrentDate", map);
            MybatisDaoImpl.of(TransCurrentMapper.class).deleteBySql("deleteCurrentDate", map);
        } catch (Exception e) {
            throw new MoveTradeToHistoryTaskletException("交易流水移至历史表中异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }
}
