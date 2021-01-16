package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.data.bo.OneBankReconciliationBO;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfo;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrent;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrentCondition;
import cn.kingnet.utp.reconciliation.exception.ReconciliationProcessorException;
import cn.kingnet.utp.trade.common.enums.ElcMakeFlag;
import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 对账处理 以银行交易记录为基准。银行存在的成功记录本地都标记为交易成功
 *
 * @author zhongli
 * @date 2018/9/13
 */
@Slf4j
public class ReconciliationProcessor implements ItemProcessor<OneBankReconciliationBO, TransCurrent>, InitializingBean {

    private final String reconcileDate;

    public ReconciliationProcessor(String reconcileDate) {
        this.reconcileDate = reconcileDate;
    }

    /**
     * @param item
     * @return
     * @throws Exception
     */
    @Override
    public TransCurrent process(OneBankReconciliationBO item) throws Exception {
        try {
            log.info("进行对账==> {}", JSON.toJSONString(item));
            //判断收款人账号为910开头的19位账号为华通流水，不做处理
            if (StringUtil.isNotBlank(item.getPayeeAcctNo())) {
                String payeeAcctNo = item.getPayeeAcctNo().trim();
                if (payeeAcctNo.startsWith("910") && payeeAcctNo.length() == 19) {
                    log.info("流水号/批次号：{} ==> 收款帐号 {} 为华通交易流水!", item.getReqTradeId(), item.getPayeeAcctNo());
                    return null;
                }
            }

            PlusEntityWrapper<TransCurrent> condition = TransCurrentCondition.builder().andServerTransIdEq(item.getReqTradeId()).build();
            TransCurrent transCurrent = MybatisDaoImpl.run().selectOne(condition);
            /**
             * 对账文件多出的交易记录
             * b 如果银联全渠道的对账文件里该笔成功，本地系统无记录；
             * 记录差错流水，差错标志为“渠道多流水”，处理标志置为“未处理”，需要运营人员人工介入处理
             * */
            if (transCurrent == null) {
                log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错", item.getReqTradeId(), ReconciliationErrorType.B.value());
                MybatisDaoImpl.run().insert(getSettleCheckInfo(item));
                log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错记录成功", item.getReqTradeId(), ReconciliationErrorType.B.value());
                return null;
            }
            //备注
            transCurrent.setDescription(String.format("%s;对账前交易状态(%s)", StringUtil.trimToEmpty(transCurrent.getDescription()), transCurrent.getTransStatus()));
            transCurrent.setReconcileStatus(TrueOrFalseStatus.TRUE.value());
            transCurrent.setReconcileTime(new Date());
            transCurrent.setReconcileDate(reconcileDate);
            //原系统计算渠道手续费
            transCurrent.setOrginChannelFee(transCurrent.getChannelFee());
            //渠道对账单返回手续费
            transCurrent.setChannelFee(new BigDecimal(item.getFeeAmount()).multiply(new BigDecimal(100)).longValue());
            transCurrent.setGmtModified(new Date());
            if (!TransStatus.TRADE_SUCCESS.toString().equals(transCurrent.getTransStatus())) {
                //标志为成功
                if (TransStatus.TRADE_FAILURE.name().equals(transCurrent.getTransStatus())) {
                    /**
                     * c 如果银联全渠道的对账文件里该笔成功，本地系统该笔失败；本地系统直接把交易状态修改为成功;
                     * 记录差错流水，差错标志为“平台状态失败，渠道成功”，处理标志置为“已处理”，处理说明置为“系统对账后修改状态”。
                     * */
                    log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错", item.getReqTradeId(), ReconciliationErrorType.C.value());
                    SettleCheckInfo settleCheckInfo = getSettleCheckInfo(transCurrent, ReconciliationErrorType.C, "平台状态失败，渠道成功", TrueOrFalseStatus.TRUE.value(), "系统自动对账处理", TransStatus.TRADE_SUCCESS.name());
                    MybatisDaoImpl.run().insert(settleCheckInfo);
                    log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错记录成功", item.getReqTradeId(), ReconciliationErrorType.C.value());
                    // 标志需要移入历史流水表
                    transCurrent.setHistoryStatus("1");
                } else if (TransStatus.PROCESSING.name().equals(transCurrent.getTransStatus())) {
                    /**
                     * d 如果银联全渠道的对账文件里该笔成功，本地系统该笔处理中；本地系统直接把交易状态修改为成功;
                     * 记录差错流水，差错标志为“平台状态未知，渠道成功”，处理标志置为“已处理”，处理说明置为“系统对账后修改状态”。
                     * */
                    log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错", item.getReqTradeId(), ReconciliationErrorType.D.value());
                    SettleCheckInfo settleCheckInfo = getSettleCheckInfo(transCurrent, ReconciliationErrorType.D, "平台状态处理中，渠道成功", TrueOrFalseStatus.TRUE.value(), "系统自动对账处理", TransStatus.TRADE_SUCCESS.name());
                    MybatisDaoImpl.run().insert(settleCheckInfo);
                    log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错记录成功", item.getReqTradeId(), ReconciliationErrorType.D.value());
                    // 标志需要移入历史流水表
                    transCurrent.setHistoryStatus("1");
                } else {
                    /**
                     * d 如果银联全渠道的对账文件里该笔成功，本地系统该笔未知；本地系统直接把交易状态修改为成功;
                     * 记录差错流水，差错标志为“平台状态未知，渠道成功”，处理标志置为“已处理”，处理说明置为“系统对账后修改状态”。
                     * */
                    log.info("流水号/批次号：{} ==> 平台状态{} 差错类型 {} 记录差错", item.getReqTradeId(), transCurrent.getTransStatus(), ReconciliationErrorType.D.value());
                    SettleCheckInfo settleCheckInfo = getSettleCheckInfo(transCurrent, ReconciliationErrorType.D, "平台状态未知，渠道成功", TrueOrFalseStatus.TRUE.value(), "系统自动对账处理", TransStatus.TRADE_SUCCESS.name());
                    MybatisDaoImpl.run().insert(settleCheckInfo);
                    log.info("流水号/批次号：{} ==> 平台状态{} 差错类型 {} 记录差错记录成功", item.getReqTradeId(), transCurrent.getTransStatus(), ReconciliationErrorType.D.value());
                    // 标志需要移入历史流水表
                    transCurrent.setHistoryStatus("1");
                }
                transCurrent.setTransStatus(TransStatus.TRADE_SUCCESS.name());
            } else if (new BigDecimal(item.getAmount()).multiply(new BigDecimal(100)).longValue() != transCurrent.getRealAmount()) {
                //交易金额不等
                log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错", item.getReqTradeId(), ReconciliationErrorType.G.value());
                SettleCheckInfo settleCheckInfo = getSettleCheckInfo(transCurrent, ReconciliationErrorType.G, "交易信息不匹配(如交易金额)", TrueOrFalseStatus.FALSE.value(), "需要运营人员人工介入处理", transCurrent.getTransStatus());
                MybatisDaoImpl.run().insert(settleCheckInfo);
                log.warn("流水号/批次号：{} ==> 差错类型 {} 记录差错记录成功", item.getReqTradeId(), ReconciliationErrorType.G.value());
                // 标志需要移入历史流水表
                transCurrent.setHistoryStatus("1");
            } else if (TransStatus.TRADE_SUCCESS.toString().equals(transCurrent.getTransStatus())) {
                // 标志需要移入历史流水表
                transCurrent.setHistoryStatus("1");
            }
            log.info("流水号/批次号：{} ==> 对账处理完成", item.getReqTradeId());
            return transCurrent;
        } catch (Exception e) {
            log.error("流水号/批次号：{} ==> 对账处理出错", item.getReqTradeId());
            throw new ReconciliationProcessorException("对账处理出错：".concat(e.getMessage()), e);
        }
    }

    private SettleCheckInfo getSettleCheckInfo(OneBankReconciliationBO oneBankReconciliationBO) {
        long channelFee = new BigDecimal(oneBankReconciliationBO.getFeeAmount()).multiply(new BigDecimal(100)).longValue();
        long amount = new BigDecimal(oneBankReconciliationBO.getAmount()).multiply(new BigDecimal(100)).longValue();
        return SettleCheckInfo.builder()
                .errorType(ReconciliationErrorType.B.value())
                .errorDesc("渠道多流水,本地系统无记录")
                .status(TrueOrFalseStatus.FALSE.value())
                .remark("需要运营人员人工介入处理")
                .accountHandleFlag(TrueOrFalseStatus.FALSE.value())
                .serverTransId(oneBankReconciliationBO.getReqTradeId())
                .reconcileTime(new Date())
                .reconcileDate(reconcileDate)
                .beforeTransStatus(TransStatus.TRADE_SUCCESS.name())
                .transStatus(TransStatus.TRADE_SUCCESS.name())
                .transAmount(amount)
                .merFee(0L)
                .channelFee(channelFee)
                .realAmount(amount)
                .transDate(oneBankReconciliationBO.getReqDate())
                .transTime(oneBankReconciliationBO.getReqTime())
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .orginChannelFee(channelFee)
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .payerAcctNo(oneBankReconciliationBO.getPayerAcctNo())
                .payerName(oneBankReconciliationBO.getPayerName())
                .showPayerAccountNo(oneBankReconciliationBO.getPayerAcctNo())
                .showPayerAccountName(oneBankReconciliationBO.getPayerName())
                .payeeAcctNo(oneBankReconciliationBO.getPayeeAcctNo())
                .payeeName(oneBankReconciliationBO.getPayeeName())
                .showPayeeAccountNo(oneBankReconciliationBO.getPayeeAcctNo())
                .showPayeeAccountName(oneBankReconciliationBO.getPayeeName())
                .summaryDescription(oneBankReconciliationBO.getRemark())
                .payerOpbkName(oneBankReconciliationBO.getPayerOpbkName())
                .payeeOpbkName(oneBankReconciliationBO.getPayeeOpbkName())
                .gmtCreate(new Date())
                .userCreate("对账任务")
                .build();
    }

    private SettleCheckInfo getSettleCheckInfo(TransCurrent transCurrent, ReconciliationErrorType errorType, String errorDes, String status, String remark, String targetTransStatus) {
        return SettleCheckInfo.builder()
                .errorType(errorType.value())
                .errorDesc(errorDes)
                .status(status)
                .remark(remark)
                .accountHandleFlag(TrueOrFalseStatus.FALSE.value())
                .serverTransId(transCurrent.getServerTransId())
                .clientTransId(transCurrent.getClientTransId())
                .reconcileTime(transCurrent.getReconcileTime())
                .reconcileDate(transCurrent.getReconcileDate())
                .beforeTransStatus(transCurrent.getTransStatus())
                .transStatus(targetTransStatus)
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
                .auditStatus(status)
                .build();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(reconcileDate, "需要对账日期注入");
    }
}
