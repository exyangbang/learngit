package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfo;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrent;
import cn.kingnet.utp.reconciliation.data.entity.TransHistory;
import cn.kingnet.utp.reconciliation.data.mapper.TransCurrentMapper;
import cn.kingnet.utp.reconciliation.exception.ReReconciliationTaskletException;
import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
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
 * @Description : 不需要华通渠道对账交易流水对账处理
 * @Author : linkaigui
 * @Create : 2019/3/18 13:34
 */
@Component
@Slf4j
public class NoChannelReconcileTasklet implements Tasklet {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try {

            JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
            Map<String, JobParameter> map = jobParameters.getParameters();
            final String reconcileDate = map.get("reconcileDate").toString();
            log.info("开始处理交易日期小于等于当前对账日[{}]的所有不需要华通渠道对账记录...", reconcileDate);
            Map<String, Object> parameterMap = new HashMap<>(4);
            //处理日期小于等于当前对账日之前的所有不需要华通渠道对账记录
            parameterMap.put("reconcileDate", reconcileDate);
            List<TransCurrent> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("getNoChannelTransList", parameterMap);
            if (!CollectionUtils.isEmpty(list)) {
                List<TransCurrent> resultList = list.stream()
                        //过滤交易成功或者失败的记录
                        .filter(transCurrent -> TransStatus.TRADE_SUCCESS.name().equals(transCurrent.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(transCurrent.getTransStatus()))
                        .map(transCurrent -> {
                            //原渠道手续费
                            Long orginChannelFee = transCurrent.getChannelFee();
                            transCurrent.setOrginChannelFee(orginChannelFee);
                            transCurrent.setReconcileTime(new Date());
                            transCurrent.setReconcileDate(reconcileDate);
                            transCurrent.setReconcileStatus(TrueOrFalseStatus.TRUE.value());
                            transCurrent.setDescription(String.format("%s;[不需要华通渠道对账]对账前交易状态(%s)", StringUtil.trimToEmpty(transCurrent.getDescription()), transCurrent.getTransStatus()));
                            transCurrent.setGmtModified(new Date());
                            return transCurrent;
                        }).collect(Collectors.toList());

                int size = CollectionUtils.isEmpty(resultList) ? 0 : resultList.size();
                log.info("不需要华通渠道对账交易流水对账处理 ==> 对账日期{} 有{}笔交易状态明确的交易流水记录", reconcileDate, size);

                if (size > 0) {
                    //变更对账记录状态
                    MybatisDaoImpl.run().updateBatchById(resultList, 100);
                    //插历史表|删除当前表
                    List<TransHistory> transHistoryList = resultList.stream().map(this::getTransHistory).collect(Collectors.toList());
                    //插入历史流水表
                    MybatisDaoImpl.run().insertBatch(transHistoryList, 100);
                    //删除当前流水表
                    List<Long> idList = resultList.stream().map(TransCurrent::getId).collect(Collectors.toList());
                    MybatisDaoImpl.run().deleteBatchIds(TransCurrent.class, idList);

                    log.info("不需要华通渠道对账交易流水对账处理 ==> 对账日期{} 有{}笔交易流水迁移历史表成功", reconcileDate, transHistoryList.size());
                }

                // 不需要到华通对账的 E、F处理

                List<TransCurrent> efResultList = list.stream()
                        .filter(transCurrent -> TransStatus.TRADE_ERROR.name().equals(transCurrent.getTransStatus()))
                        .map(transCurrent -> {
                            Long orginChannelFee = transCurrent.getChannelFee();
                            transCurrent.setOrginChannelFee(orginChannelFee);
                            transCurrent.setReconcileTime(new Date());
                            transCurrent.setReconcileDate(reconcileDate);
                            transCurrent.setReconcileStatus(TrueOrFalseStatus.TRUE.value());
                            transCurrent.setDescription(String.format("%s;[不需要华通渠道对账]对账前交易状态(%s)", StringUtil.trimToEmpty(transCurrent.getDescription()), transCurrent.getTransStatus()));
                            transCurrent.setGmtModified(new Date());
                            //本地多流水，系统不自动移至历史表，待人工差错处理后移动
                            transCurrent.setHistoryStatus(TrueOrFalseStatus.FALSE.value());
                            return transCurrent;
                        }).collect(Collectors.toList());

                if (!CollectionUtils.isEmpty(efResultList)) {
                    List<SettleCheckInfo> settleCheckInfoList = efResultList.stream()
                            .map(transCurrent -> {
                                String origTransStatus = transCurrent.getTransStatus();
                                if (TransStatus.TRADE_ERROR.name().equals(origTransStatus)) {
                                    //平台状态不明确,转失败处理 F类型
                                    transCurrent.setTransStatus(TransStatus.TRADE_FAILURE.name());
                                    /** f 如果本地系统该笔状态“处理中”，在银联全渠道的对账文件里找不到交易记录；
                                     * 则直接把交易状态改成“交易失败”，差错标志为“平台状态未知，渠道失败”，处理标志置为“已处理”，处理说明置为“系统对账后修改状态”。
                                     */
                                    return getTSettleCheckInfo(transCurrent, ReconciliationErrorType.F, "未知平台状态转交易失败", TrueOrFalseStatus.FALSE.value(), "需要运营人员人工介入处理", origTransStatus, reconcileDate);
                                }
                                return null;
                            }).collect(Collectors.toList());

                    int settleSize = settleCheckInfoList.size();

                    log.info("不需要华通渠道对账交易流水对账处理 ==> 对账日期{} 有{}笔进F差错交易流水记录", reconcileDate, settleSize);

                    if (settleSize > 0) {
                        MybatisDaoImpl.run().insertBatch(settleCheckInfoList, 100);
                    }
                    MybatisDaoImpl.run().updateBatchById(efResultList, 100);

                }
            }
            log.info("不需要华通渠道对账交易流水对账处理 完成 ==> 对账日期{}", reconcileDate);

        } catch (Exception e) {
            throw new ReReconciliationTaskletException("不需要华通渠道对账交易流水对账处理异常：".concat(e.getMessage()), e);
        }
        return RepeatStatus.FINISHED;
    }

    private TransHistory getTransHistory(TransCurrent transCurrent) {
        return TransHistory.builder()
                .id(transCurrent.getId())
                .channelKey(transCurrent.getChannelKey())
                .channelCode(transCurrent.getChannelCode())
                .channelName(transCurrent.getChannelName())
                .merNo(transCurrent.getMerNo())
                .clientTransId(transCurrent.getClientTransId())
                .clientTransTime(transCurrent.getClientTransTime())
                .serverTransId(transCurrent.getServerTransId())
                .productCode(transCurrent.getProductCode())
                .tradeType(transCurrent.getTradeType())
                .orgCode(transCurrent.getOrgCode())
                .orgName(transCurrent.getOrgName())
                .serverBatchNo(transCurrent.getServerBatchNo())
                .serverLinkId(transCurrent.getServerLinkId())
                .transAmount(transCurrent.getTransAmount())
                .realAmount(transCurrent.getRealAmount())
                .transStatus(transCurrent.getTransStatus())
                .transDate(transCurrent.getTransDate())
                .transTime(transCurrent.getTransTime())
                .channelRespTime(transCurrent.getChannelRespTime())
                .channelRespCode(transCurrent.getChannelRespCode())
                .channelRespId(transCurrent.getChannelRespId())
                .channelRespMsg(transCurrent.getChannelRespMsg())
                .respCode(transCurrent.getRespCode())
                .respException(transCurrent.getRespException())
                .respMessage(transCurrent.getRespMessage())
                .revokeStatus(transCurrent.getRevokeStatus())
                .refundStatus(transCurrent.getRefundStatus())
                .refundAmount(transCurrent.getRefundAmount())
                .reconcileStatus(transCurrent.getReconcileStatus())
                .transCallbackUrl(transCurrent.getTransCallbackUrl())
                .reconcileTime(transCurrent.getReconcileTime())
                .reconcileDate(transCurrent.getReconcileDate())
                .description(transCurrent.getDescription())
                .batchSubNo(transCurrent.getBatchSubNo())
                .currency(transCurrent.getCurrency())
                .gmtCreate(transCurrent.getGmtCreate())
                .gmtModified(transCurrent.getGmtModified())
                .userCreate(transCurrent.getUserCreate())
                .userModified(transCurrent.getUserModified())
                .userCode(transCurrent.getUserCode())
                .accNo(transCurrent.getAccNo())
                .merFee(transCurrent.getMerFee())
                .channelFee(transCurrent.getChannelFee())
                .pcFlag(transCurrent.getPcFlag())
                .userType(transCurrent.getUserType())
                .payeeAcctNo(transCurrent.getPayeeAcctNo())
                .payeeName(transCurrent.getPayeeName())
                .payerAcctNo(transCurrent.getPayerAcctNo())
                .payerName(transCurrent.getPayerName())
                .industryCode(transCurrent.getIndustryCode())
                .splitInfoId(transCurrent.getSplitInfoId())
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
                .payerOpbkName(transCurrent.getPayerOpbkName())
                .payeeOpbkName(transCurrent.getPayeeOpbkName())
                .summaryDescription(transCurrent.getSummaryDescription())
                .historyStatus("1")
                .queryTime(transCurrent.getQueryTime())
                .remoteIp(transCurrent.getRemoteIp())
                .paymentType(transCurrent.getPaymentType())
                .paymentPeriod(transCurrent.getPaymentPeriod())
                .paymentSettleStatus(transCurrent.getPaymentSettleStatus())
                .build();
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
