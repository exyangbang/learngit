package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfo;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrent;
import cn.kingnet.utp.reconciliation.data.mapper.TransCurrentMapper;
import cn.kingnet.utp.reconciliation.exception.ReReconciliationTaskletException;
import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 以平台为基准，查找平台多流水记录
 * 查找到的记录交易状态都标记为失败
 *
 * @author zhongli
 * @date 2018/9/13
 */
@Component
@Slf4j
public class ReReconciliationTasklet implements Tasklet {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        try {
            Map<String, Object> context = chunkContext.getStepContext().getStepExecutionContext();
            final String reconcileDate = context.get("reconcileDate").toString();
            Map<String, Object> parameterMap = new HashMap<>(4);
            parameterMap.put("reconcileDate", reconcileDate);
            //等于当前清算日期且未对账状态的记录 即为本地多流水
            List<TransCurrent> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("getPlatMultiTransList", parameterMap);
            if (!CollectionUtils.isEmpty(list)) {
                List<SettleCheckInfo> listInserts = list.stream().filter(transCurrent -> {
                    //原渠道手续费
                    Long orginChannelFee = transCurrent.getChannelFee();
                    transCurrent.setOrginChannelFee(orginChannelFee);

                    transCurrent.setReconcileTime(new Date());
                    transCurrent.setReconcileDate(reconcileDate);
                    transCurrent.setReconcileStatus(TrueOrFalseStatus.TRUE.value());
                    transCurrent.setDescription(String.format("%s;[本地多流水]对账前交易状态(%s)", StringUtil.trimToEmpty(transCurrent.getDescription()), transCurrent.getTransStatus()));
                    transCurrent.setGmtModified(new Date());
                    //本地多流水，系统不自动移至历史表，待人工差错处理后移动
                    transCurrent.setHistoryStatus(TrueOrFalseStatus.FALSE.value());
                    //过滤掉失败的交易记录 明确已经清算日期的交易是失败的，则就是该对账日文件内无此交易记录，则明确其失败交易并移至历史表
                    if (TransStatus.TRADE_FAILURE.name().equals(transCurrent.getTransStatus())) {
                        transCurrent.setHistoryStatus(TrueOrFalseStatus.TRUE.value());
                        return false;
                    }
                    return true;
                }).map(transCurrent -> {
                    String origTransStatus = transCurrent.getTransStatus();
                    if (TransStatus.TRADE_SUCCESS.name().equals(origTransStatus)) {
                        //平台多流水要将平台的记录标记为失败
                        transCurrent.setTransStatus(TransStatus.TRADE_FAILURE.name());
                        /**
                         * e 如果本地系统该笔成功，在银联全渠道的对账文件里找不到交易记录；
                         * 记录差错流水，差错标志为“平台多流水”，处理标志置为“未处理”，需要运营人员人工介入处理。
                         * */
                        return getTSettleCheckInfo(transCurrent, ReconciliationErrorType.E, "平台多流水", TrueOrFalseStatus.FALSE.value(), "需要运营人员人工介入处理", origTransStatus, reconcileDate);
                    }
                    //平台多流水要将平台的记录标记为失败
                    transCurrent.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    /** f 如果本地系统该笔状态“处理中”，在银联全渠道的对账文件里找不到交易记录；
                     * 则直接把交易状态改成“交易失败”，差错标志为“平台状态未知，渠道失败”， 处理标志置为“未处理”，需要运营人员人工介入处理。
                     */
                    return getTSettleCheckInfo(transCurrent, ReconciliationErrorType.F, "平台状态未知，渠道失败", TrueOrFalseStatus.FALSE.value(), "需要运营人员人工介入处理", origTransStatus, reconcileDate);
                }).collect(Collectors.toList());
                int size = listInserts.size();
                log.info("清算日期[{}] >> 以平台为基础对账 ==>  有{}笔差错交易流水记录", reconcileDate, size);
                if (size > 0) {
                    MybatisDaoImpl.run().insertBatch(listInserts,100);
                }
                MybatisDaoImpl.run().updateBatchById(list,100);
            }
        } catch (Exception e) {
            throw new ReReconciliationTaskletException("以平台为基础对账处理异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }

    private SettleCheckInfo getTSettleCheckInfo(TransCurrent transCurrent, ReconciliationErrorType errorType, String errorDes, String status, String remark, String origTransStatus, String reconcileDate) {
        return SettleCheckInfo.builder()
                .errorType(errorType.value())
                .errorDesc(errorDes)
                .status(status)
                .remark(remark)
                .accountHandleFlag(TrueOrFalseStatus.FALSE.value())
                .serverTransId(transCurrent.getServerTransId())
                .clientTransId(transCurrent.getClientTransId())
                .reconcileTime(new Date())
                .reconcileDate(reconcileDate)
                .beforeTransStatus(origTransStatus)
                .transStatus(transCurrent.getTransStatus())
                .transAmount(transCurrent.getTransAmount())
                .merFee(transCurrent.getMerFee())
                .channelFee(transCurrent.getChannelFee())
                .realAmount(transCurrent.getRealAmount())
                .merNo(transCurrent.getMerNo())
                .industryCode(transCurrent.getIndustryCode())
                .productCode(transCurrent.getProductCode())
                .tradeType(transCurrent.getTradeType())
                .transDate(transCurrent.getTransDate())
                .transTime(transCurrent.getTransTime())
                .channelKey(transCurrent.getChannelKey())
                .channelCode(transCurrent.getChannelCode())
                .channelName(transCurrent.getChannelName())
                .channelRespCode(transCurrent.getChannelRespCode())
                .channelRespId(transCurrent.getChannelRespId())
                .channelRespMsg(transCurrent.getChannelRespMsg())
                .channelRespTime(transCurrent.getChannelRespTime())
                .clientTransTime(transCurrent.getClientTransTime())
                .orgCode(transCurrent.getOrgCode())
                .orgName(transCurrent.getOrgName())
                .serverBatchNo(transCurrent.getServerBatchNo())
                .serverLinkId(transCurrent.getServerLinkId())
                .respCode(transCurrent.getRespCode())
                .revokeStatus(transCurrent.getRevokeStatus())
                .refundStatus(transCurrent.getRefundStatus())
                .userCode(transCurrent.getUserCode())
                .batchSubNo(transCurrent.getBatchSubNo())
                .pcFlag(transCurrent.getPcFlag())
                .userType(transCurrent.getUserType())
                .payerAcctNo(transCurrent.getPayerAcctNo())
                .payerName(transCurrent.getPayerName())
                .payeeAcctNo(transCurrent.getPayeeAcctNo())
                .payeeName(transCurrent.getPayeeName())
                .accNo(transCurrent.getAccNo())
                .merSettleType(transCurrent.getMerSettleType())
                .merChargeMode(transCurrent.getMerChargeMode())
                .channelSettleType(transCurrent.getChannelSettleType())
                .channelChargeMode(transCurrent.getChannelChargeMode())
                .channelSettleDate(transCurrent.getChannelSettleDate())
                .orginChannelFee(transCurrent.getOrginChannelFee())
                .payerAccount(transCurrent.getPayerAccount())
                .payeeAccount(transCurrent.getPayeeAccount())
                .feeAccount(transCurrent.getFeeAccount())
                .incomeAccount(transCurrent.getIncomeAccount())
                .needChannelReconcile(transCurrent.getNeedChannelReconcile())
                .showPayerAccountNo(transCurrent.getShowPayerAccountNo())
                .showPayerAccountName(transCurrent.getShowPayerAccountName())
                .showPayeeAccountNo(transCurrent.getShowPayeeAccountNo())
                .showPayeeAccountName(transCurrent.getShowPayeeAccountName())
                .orderId(transCurrent.getOrderId())
                .elcMakeFlag(transCurrent.getElcMakeFlag())
                .feeAccountName(transCurrent.getFeeAccountName())
                .incomeAccountName(transCurrent.getIncomeAccountName())
                .summaryDescription(transCurrent.getSummaryDescription())
                .payerOpbkName(transCurrent.getPayerOpbkName())
                .payeeOpbkName(transCurrent.getPayeeOpbkName())
                .gmtCreate(new Date())
                .userCreate("对账任务")
                .build();
    }
}
