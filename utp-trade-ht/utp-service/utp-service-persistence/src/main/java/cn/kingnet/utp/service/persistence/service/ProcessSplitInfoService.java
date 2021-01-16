package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月10日
 */
@Service
@Slf4j
public class ProcessSplitInfoService {

    @Resource
    InnerAccountService innerAccountService;
    @Resource
    TransCurrentAndHistoryService transCurrentAndHistoryService;

    /**
     * T+0 分账数据处理 T0整批次处理
     *
     * @param industryCode 代付客户号
     * @param settleDate   清算分账日期
     * @param batchId      批次Id
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public boolean batchProcessSplitInfo4T0(String industryCode, String settleDate, String batchId) {
        try {
            boolean batchStatus = false;
            String batchDesc = null;
            PlusEntityWrapper<SplitInfo> condition = SplitInfoCondition.builder().andIndustryCodeEq(industryCode).andBatchIdEq(batchId).andSettleDateEq(settleDate).build();
            List<SplitInfo> splitInfoList = MybatisDaoImpl.run().selectList(condition);
            if (!CollectionUtils.isEmpty(splitInfoList)) {
                IndustryPayInfo industryPayInfo = null;
                try {
                    industryPayInfo = innerAccountService.getIndustryPayInfo(industryCode);
                    if (industryPayInfo == null) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "获取平台客户支付信息失败");
                    }
                    long batchRowCount = splitInfoList.stream().filter(o -> o.getPeriod() == 0 && SplitStatus.SPLIT_UNDO.getStatus().equals(o.getStatus())
                            && TransStatus.PRE_CREATE.name().equals(o.getTransStatus())).count();
                    if (batchRowCount != splitInfoList.size()) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, "整批次初始状态不一致");
                    }
                    splitInfoList = innerAccountService.batchProcessSplitInfo4T0(splitInfoList, industryPayInfo);
                    batchStatus = true;
                    batchDesc = "批处理成功";
                } catch (Exception e) {
                    log.error("代付客户号{}-清算日期{}-批次号{}-批处理账户入账异常:{}", industryCode, settleDate, batchId, e.getMessage(), e);
                    //整批出现异常，则全批次失败处理
                    batchStatus = false;
                    batchDesc = "批处理失败:" + StringUtil.truncate(e.getMessage(), 200);
                    String transDesc = batchDesc;
                    splitInfoList.forEach(o -> {
                        o.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
                        o.setTransStatus(TransStatus.TRADE_FAILURE.name());
                        o.setTransDesc(transDesc);
                    });
                } finally {
                    PlusEntityWrapper<SplitInfoUploadLog> logPlusEntityWrapper = SplitInfoUploadLogCondition.builder()
                            .andProviderCodeEq(industryCode).andSettleDateEq(settleDate).andBatchIdEq(batchId).build();
                    SplitInfoUploadLog splitInfoUploadLog = SplitInfoUploadLog.builder().remark(batchDesc).transStatus(batchStatus ? TransStatus.TRADE_SUCCESS.name() : TransStatus.TRADE_FAILURE.name()).gmtModified(new Date()).build();
                    //更新整批次状态
                    MybatisDaoImpl.run().update(splitInfoUploadLog, logPlusEntityWrapper);
                    //更新分账流水记录
                    MybatisDaoImpl.run().updateBatchById(splitInfoList, 100);
                    //批量插入交易表
                    insertTransCurrent4SplitInfo(industryCode, industryPayInfo, splitInfoList);
                }
            }else{
                //查无 清分记录（回滚）
                PlusEntityWrapper<SplitInfoUploadLog> logPlusEntityWrapper = SplitInfoUploadLogCondition.builder()
                        .andProviderCodeEq(industryCode).andSettleDateEq(settleDate).andBatchIdEq(batchId).build();
                SplitInfoUploadLog splitInfoUploadLog = SplitInfoUploadLog.builder().transStatus(TransStatus.TRADE_FAILURE.name()).gmtModified(new Date()).build();
                //更新整批次状态
                MybatisDaoImpl.run().update(splitInfoUploadLog, logPlusEntityWrapper);
            }
            return batchStatus;
        } catch (Exception e) {
            log.error("代付客户号{}-清算日期{}-批次号{}-账户入账持久化异常", industryCode, settleDate, batchId, e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("账户入账持久化异常:%s", StringUtil.truncate(e.getMessage(), 200)), e);
        }
    }

    private void insertTransCurrent4SplitInfo(String industryCode, IndustryPayInfo industryPayInfo, List<SplitInfo> splitInfoList) {
        List<TransCurrent> transCurrentList = splitInfoList.stream().map(o -> buildTransCurrent(industryCode, industryPayInfo, o)).collect(Collectors.toList());
        MybatisDaoImpl.run().insertBatch(transCurrentList, 100);
    }

    private TransCurrent buildTransCurrent(String industryCode, IndustryPayInfo industryPayInfo, SplitInfo splitInfo) {
        if (industryPayInfo == null) {
            industryPayInfo = new IndustryPayInfo();
            industryPayInfo.setIndustryCode(industryCode);
        }
        UserPayInfo userPayInfo = innerAccountService.getUserPayInfo(splitInfo.getUserAccount(),true);
        if (userPayInfo == null) {
            userPayInfo = new UserPayInfo();
        }
        String transDate = DateUtil.getCurrentDate();
        String transTime = DateUtil.getCurrentTime();
        return TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(splitInfo.getClientTransId())
                .clientTransTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .currency("CNY")
                .orgCode(industryPayInfo.getOrgCode())
                .orgName(industryPayInfo.getOrgName())
                .serverTransId(splitInfo.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.SPLIT_PAYMENT.getCode())
                .transAmount(splitInfo.getAmount())
                .transCallbackUrl(null)
                .transDate(transDate)
                .transTime(transTime)
                .merNo(industryPayInfo.getIndustryAccount())
                .userCode(null)
                .accNo(industryPayInfo.getFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(splitInfo.getAmount())
                .pcFlag(userPayInfo.getUserAccType())
                .userType(AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()) == null ? null : AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()).getValue())
                .payerAcctNo(industryPayInfo.getFundAccNo())
                .payerName(industryPayInfo.getFundAccName())
                .payeeAcctNo(userPayInfo.getFundAccNo())
                .payeeName(userPayInfo.getFundAccName())
                .industryCode(industryPayInfo.getIndustryCode())
                .transStatus(splitInfo == null ? TransStatus.TRADE_FAILURE.name() : splitInfo.getTransStatus())
                .respMessage(splitInfo.getTransDesc())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(industryPayInfo.getIndustryAccount())
                .payeeAccount(userPayInfo.getUserAccount())
                .feeAccount(industryPayInfo.getFeeOutAccount())
                .incomeAccount(industryPayInfo.getFeeInAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(industryPayInfo.getIndustryAccount())
                .showPayerAccountName(industryPayInfo.getIndustryName())
                .showPayeeAccountNo(userPayInfo.getUserAccount())
                .showPayeeAccountName(userPayInfo.getUserName())
                .feeAccountName(industryPayInfo.getFeeOutName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .incomeAccountName(industryPayInfo.getFeeInName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(splitInfo.getTransDesc())
                .summaryDescription("分账交易")
                .serverBatchNo(splitInfo.getBatchId())
                .splitInfoId(splitInfo.getId())
                .build();
    }


    /**
     * T+n 分账数据处理
     *
     * @param splitDate 清算分账日期
     * @return unSplitList
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public List<SplitInfo> processSplitInfo4TN(String splitDate) {
        try {
            PlusEntityWrapper<SplitInfo> condition = SplitInfoCondition.builder()
                    .andSplitDateEq(splitDate).andPeriodGt(0).andStatusEq(SplitStatus.SPLIT_UNDO.getStatus()).andTransStatusEq(TransStatus.PRE_CREATE.name()).build();
            List<SplitInfo> unSplitList = MybatisDaoImpl.run().selectList(condition);
            if (!CollectionUtils.isEmpty(unSplitList)) {
                unSplitList.forEach(splitInfo -> {
                    try {
                        //资金处理、分账流水状态变更、交易流水落库
                        splitInfo = innerAccountService.processCurSplitInfo4TN(splitInfo);
                    } catch (Exception e) {
                        log.error("虚拟账户{}-分账日期{}-账户入账异常[{}]", splitInfo.getUserAccount(), splitInfo.getSplitDate(), e.getMessage(), e);
                    }
                });
            }
            return unSplitList;
        } catch (Exception e) {
            log.error("分账日期:{} 的T+n清算分账业务处理异常[{}]", splitDate, e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("分账日期:{%s} 的T+n清算分账业务处理异常:[%s]", splitDate, StringUtil.truncate(e.getMessage(), 200)), e);
        }
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void processSingleSplitPayment(String industryCode, String userAccount, long payAmt, String serverTransId, String remark, String clientTransId) {
        try {
            IndustryPayInfo industryPayInfo = innerAccountService.getIndustryPayInfo(industryCode);
            Account account = innerAccountService.getAccountByUserAccount(userAccount);
            if (account == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户已销户");
            }
            String industryAccount = industryPayInfo.getIndustryAccount();
            String industryAccName = industryPayInfo.getIndustryName();
            // 平台代付出金 及 用户打款入金
            innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, industryAccount, payAmt, userAccount,
                    String.format("平台[%s]单笔实时分账业务代付出金.[%s]", industryCode, remark), serverTransId, account.getObjName(), clientTransId);
            innerAccountService.plusBalance(AccountOperSubType.INCOME, userAccount, payAmt, industryAccount,
                    String.format("平台[%s]单笔实时分账业务分账入金.[%s]", industryCode, remark), serverTransId, industryAccName, clientTransId);
        } catch (Exception e) {
            log.error("服务端流水号[{}] >> 平台[{}]单笔实时分账子账户[{}]业务记账异常.{}", serverTransId, industryCode, userAccount, e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.INTERNAL_SERVER_ERROR, "平台单笔分账记账异常", e);
        }
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void processSingleSplitPaymentRefund(String industryCode, String origPayerAccount, String origPayeeAccount, long payAmt, String serverTransId, String remark, String clientTransId, Long origTransId, String historyStatus) {
        try {
            //原交易付款者 退款操作  变为收款者
            Account payee = innerAccountService.getAccountByUserAccount(origPayerAccount);
            if (payee == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(payee.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户已销户");
            }
            //原交易收款者 退款操作  变为付款者
            Account payer = innerAccountService.getAccountByUserAccount(origPayeeAccount);
            if (payer == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(payer.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户已销户");
            }

            //平台代付入金 及 用户退款出金
            innerAccountService.plusBalance(AccountOperSubType.REFUND, payee.getAccount(), payAmt, payer.getAccount(),
                    String.format("平台[%s]单笔实时分账退款业务退款入金.[%s]", industryCode, remark), serverTransId, payer.getObjName(), clientTransId);
            innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, payer.getAccount(), payAmt, payee.getAccount(),
                    String.format("平台[%s]单笔实时分账退款业务退款出金.[%s]", industryCode, remark), serverTransId, payee.getObjName(), clientTransId);

            TransCurrent transCurrent = TransCurrent.builder().id(origTransId).refundAmount(payAmt).gmtModified(new Date()).build();
            transCurrentAndHistoryService.updateRefundById(transCurrent, historyStatus);
        } catch (Exception e) {
            log.error("服务端流水号[{}] >> 平台[{}]单笔实时分账退款业务记账异常.{}", serverTransId, industryCode, e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.INTERNAL_SERVER_ERROR, "平台单笔分账退款业务记账异常", e);
        }
    }
}
