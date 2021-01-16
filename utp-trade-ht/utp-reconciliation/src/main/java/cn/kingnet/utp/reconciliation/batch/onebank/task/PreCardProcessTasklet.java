package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfo;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfoCondition;
import cn.kingnet.utp.reconciliation.exception.ReReconciliationTaskletException;
import cn.kingnet.utp.service.persistence.api.IAccountSettleHandler;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TradeType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description : 预付费卡清算对账处理
 * @Author : linkaigui
 * @Create : 2019/3/18 15:07
 */
@Component
@Slf4j
public class PreCardProcessTasklet implements Tasklet {

    private final IAccountSettleHandler accountSettleHandler;

    public PreCardProcessTasklet(IAccountSettleHandler accountSettleHandler) {
        this.accountSettleHandler = accountSettleHandler;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try{
            Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
            final String reconcileDate = context.get("reconcileDate").toString();
            log.info("日期:{} - 预付费卡清算对账处理",reconcileDate);
            PlusEntityWrapper<SettleCheckInfo> condition = SettleCheckInfoCondition.builder()
                    .andReconcileDateEq(reconcileDate)
                    .andProductCodeEq(ProductCode.PRECARD.name())
                    .andTradeTypeEq(TradeType.UPLOAD_ACCOUNT_SETTLE.getCode())
                    .build();
            List<SettleCheckInfo> settleCheckInfoList = MybatisDaoImpl.run().selectList(condition);
            if(!CollectionUtils.isEmpty(settleCheckInfoList)){
                settleCheckInfoList.stream()
                        .filter(settleCheckInfo -> !ReconciliationErrorType.B.value().equals(settleCheckInfo.getErrorType())) //渠道多流水的过滤掉
                        .filter(settleCheckInfo -> !settleCheckInfo.getTransStatus().equals(settleCheckInfo.getBeforeTransStatus())) //改变前状态和最终状态不一致才需要进行处理
                        .forEach(item ->{
                            boolean flag = accountSettleHandler.reconciliationProcess(item.getIndustryCode(),item.getServerTransId(),item.getTransStatus(),item.getErrorDesc());
                            log.info("流水号：{} ==> 预付费卡清算对账处理结果 {}", item.getServerTransId(), flag);
                        });
            }
        }catch (Exception e){
            throw new ReReconciliationTaskletException("预付费卡清算对账处理异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }
}
