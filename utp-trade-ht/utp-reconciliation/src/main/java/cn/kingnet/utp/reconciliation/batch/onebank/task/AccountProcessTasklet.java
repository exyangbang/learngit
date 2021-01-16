package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfo;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfoCondition;
import cn.kingnet.utp.reconciliation.exception.AccountProcessException;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @Description : 账户处理
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 19:21
 */
@Component
@Slf4j
public class AccountProcessTasklet implements Tasklet {

    private final IAccountHandler accountHandler;

    public AccountProcessTasklet(IAccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try {
            Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
            String reconcileDate = context.get("reconcileDate").toString();
            PlusEntityWrapper<SettleCheckInfo> condition = SettleCheckInfoCondition.builder()
                    .andReconcileDateEq(reconcileDate)
                    .andStatusEq(TrueOrFalseStatus.TRUE.value())
                    .andAccountHandleFlagEq(TrueOrFalseStatus.FALSE.value())
                    .build();
            List<SettleCheckInfo> settleCheckInfoList = MybatisDaoImpl.run().selectList(condition);
            if (!CollectionUtils.isEmpty(settleCheckInfoList)) {
                settleCheckInfoList.stream().filter(item -> {
                    //系统自动调账仅C、D差错类型
                    if (ReconciliationErrorType.C.value().equals(item.getErrorType()) ||
                            ReconciliationErrorType.D.value().equals(item.getErrorType())) {
                        return true;
                    }
                    return false;
                }).forEach(item -> {
                    log.info("流水号：{} ==> 交易类型{},差错类型 {} 账户处理 start .", item.getServerTransId(), item.getTradeType(), item.getErrorType());
                    try {
                        accountHandler.adjustAccount4SettleCheck(item.getId(), item.getErrorType(), item.getTradeType(), item.getTransStatus(), item.getErrorDesc(), item.getServerTransId(), false);
                    } catch (Exception e) {
                        log.error("流水号：{} ==> 交易类型{},差错类型 {} 账户处理异常{}", item.getServerTransId(), item.getTradeType(), item.getErrorType(), e.getMessage(), e);
                    }
                    log.info("流水号：{} ==> 差错类型 {} 账户处理 end .", item.getServerTransId(), item.getErrorType());
                });
            }
        } catch (Exception e) {
            throw new AccountProcessException("账户处理异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }
}
