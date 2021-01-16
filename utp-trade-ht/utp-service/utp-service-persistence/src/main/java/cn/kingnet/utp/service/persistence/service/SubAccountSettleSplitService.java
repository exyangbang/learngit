package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.*;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/16
 */
@Service
@Slf4j
public class SubAccountSettleSplitService {
    private static String SEPARATOR = "|";
    @Resource
    private ServerIdGenerate serverIdGenerate;
    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private MsgNoticeService msgNoticeService;
    @Resource
    private OutsideTransOrderService outsideTransOrderService;

    @Async
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
    public void processSubAccountSettleSplit(UploadSubAccountSettleSplitLog settleSplitLog, List<UploadSubAccountSettleSplitDetail> subAccountSettleSplitDetailList) {
        try {
            TransStatus transStatus = TransStatus.resolve(settleSplitLog.getTransStatus());
            if (transStatus == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("清分状态为[%s]暂不支持的状态,不能清分", settleSplitLog.getTransStatus()));
            }
            if (transStatus != TransStatus.PRE_CREATE) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("清分状态为[%s-%s],暂不能清分", transStatus.name(), transStatus.getTransDesc()));
            }
            UserPayInfo userAccount = innerAccountService.getUserPayInfo(settleSplitLog.getUserAccount(),true);
            settleSplitLog.setGmtModified(new Date());
            //账期为0，则实时处理
            if ("0".equals(settleSplitLog.getPeriod())) {
                try {
                    //资金处理、子账户分账信息变更
                    processSubAccountSettleSplitRealTime(userAccount, subAccountSettleSplitDetailList);
                    settleSplitLog.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                    settleSplitLog.setRemark("子账户清分成功");
                    updateOutTransOrderStatus(subAccountSettleSplitDetailList);
                } catch (Exception e) {
                    log.error("子账户[{}]T0批次[{}]处理异常：{}", settleSplitLog.getUserAccount(), settleSplitLog.getBatchNo(), e.getMessage(), e);
                    settleSplitLog.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    settleSplitLog.setRemark("子账户清分整批次失败:" + StringUtil.truncate(e.getMessage(), 100));
                    subAccountSettleSplitDetailList.stream().forEach(
                            detail -> {
                                detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
                                detail.setTransDesc("整批次失败：" + e.getMessage());
                                detail.setStatus(SplitStatus.SPLIT_OK.getStatus());
                                detail.setGmtModified(settleSplitLog.getGmtModified());
                            });
                } finally {
                    settleSplitLog.setCallbackStatus(TrueOrFalseStatus.TRUE.value());

                    //更新子账户分账及明细
                    MybatisDaoImpl.run().updateById(settleSplitLog);
                    MybatisDaoImpl.run().updateBatchById(subAccountSettleSplitDetailList, 100);
                    //整批落库交易表
                    List<TransCurrent> transCurrentList = subAccountSettleSplitDetailList.stream().map(o -> this.buildTransCurrent(userAccount, o)).collect(Collectors.toList());
                    MybatisDaoImpl.run().insertBatch(transCurrentList, 100);
                    //子账户分账结果回调通知
                    noticeSubAccountSettleSplitResult(settleSplitLog, subAccountSettleSplitDetailList);
                }
            } else {
                //Tn子账户分账处理
                UploadSubAccountSettleSplitDetail detail = null;
                try {
                    detail = subAccountSettleSplitDetailList.get(0);
                    processSubAccountSettleSplit4Tn(userAccount, detail);
                } catch (Exception e) {
                    log.error("Tn子账户[{}]批次[{}]处理异常：{}", settleSplitLog.getUserAccount(), settleSplitLog.getBatchNo(), e.getMessage(), e);
                    detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    detail.setTransDesc("异常:" + StringUtil.truncate(e.getMessage(), 200));
                } finally {
                    if (detail != null) {
                        MybatisDaoImpl.run().updateById(detail);
                        TransCurrent transCurrent = buildTransCurrent(userAccount, detail);
                        MybatisDaoImpl.run().insert(transCurrent);
                    }
                    boolean batchCompleted = isBatchCompleted(detail);
                    if (batchCompleted) {
                        UploadSubAccountSettleSplitLog settleSplitLogDb = MybatisDaoImpl.run().selectOne(UploadSubAccountSettleSplitLogCondition
                                .builder().andUserAccountEq(detail.getUserAccount()).andBatchNoEq(detail.getBatchNo()).build());
                        settleSplitLogDb.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                        settleSplitLogDb.setRemark("Tn处理完成");
                        settleSplitLogDb.setCallbackStatus(TrueOrFalseStatus.TRUE.value());
                        MybatisDaoImpl.run().updateById(settleSplitLogDb);

                        //Tn子账户分账结果通知
                        List<UploadSubAccountSettleSplitDetail> detailList = MybatisDaoImpl.run().selectList(UploadSubAccountSettleSplitDetailCondition.builder()
                                .andUserAccountEq(detail.getUserAccount()).andBatchNoEq(detail.getBatchNo()).build());
                        noticeSubAccountSettleSplitResult(settleSplitLogDb, detailList);
                    }
                }
            }

        } catch (Exception e) {
            throw new PersistenceException(HttpRespStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }

    private boolean isBatchCompleted(UploadSubAccountSettleSplitDetail detail) {
        // 查无该批次的待处理记录数
        long count = MybatisDaoImpl.run().selectCount(UploadSubAccountSettleSplitDetailCondition.builder()
                .andUserAccountEq(detail.getUserAccount()).andBatchNoEq(detail.getBatchNo()).andTransStatusEq(TransStatus.PRE_CREATE.name())
                .build());
        return count == 0;
    }

    @Async
    public void noticeSubAccountSettleSplitResult(UploadSubAccountSettleSplitLog settleSplitLog, List<UploadSubAccountSettleSplitDetail> settleSplitDetails) {
        try {
            Map<String, Object> content = Maps.newHashMap();
            content.put("industryCode", settleSplitLog.getIndustryCode());
            content.put("userAccount", settleSplitLog.getUserAccount());
            content.put("settleDate", settleSplitLog.getSettleDate());
            content.put("batchNo", settleSplitLog.getBatchNo());
            content.put("success", TransStatus.TRADE_SUCCESS.name().equals(settleSplitLog.getTransStatus()) ? "true" : "false");

            int totalCount = CollectionUtils.isEmpty(settleSplitDetails) ? 0 : settleSplitDetails.size();
            //H|subaccount_settle_result|20180101|222
            StringBuffer stringBuffer = new StringBuffer()
                    .append(UDPSettleSplitFeature.HEADMARK).append("|")
                    .append(UDPSettleSplitFeature.TxType.SUBACCOUNT_SETTLE_RESULT.getType()).append("|")
                    .append(settleSplitLog.getSettleDate()).append(SEPARATOR).append(totalCount);
            if (totalCount > 0) {
                //序号|清算日期|客户端流水号|分账子账户|金额|结算方式|账期|备注信息|子账户支付订单号列表|扩展字段2|扩展字段3|交易状态|结果说明|对账日期|
                AtomicInteger succNum = new AtomicInteger();
                settleSplitDetails.forEach(item -> {
                    stringBuffer.append("\n").append(Joiner.on(SEPARATOR).join(
                            item.getSeqNo(), item.getSettleDate(), item.getClientTransId(),
                            item.getSubAccount(), item.getAmount(), item.getSettleMode(),
                            item.getPeriod(), item.getRemark(), item.getTransOrderIds(),
                            item.getExtend2(), item.getExtend3(), item.getTransStatus(),
                            item.getTransDesc(), item.getReconcileDate()
                    ));
                    if (TransStatus.TRADE_SUCCESS.name().equals(item.getTransStatus())) {
                        succNum.incrementAndGet();
                    }
                });
                content.put("batchStatus", succNum.get() == 0 ? FileBatchStatus.FAILURE.getStatus() : (totalCount == succNum.get()) ? FileBatchStatus.SUCCESS.getStatus() : FileBatchStatus.PART_SUCCESS.getStatus());
            } else {
                content.put("batchStatus", FileBatchStatus.FAILURE.getStatus());
            }
            byte[] fileAy = stringBuffer.toString().getBytes(StandardCharsets.UTF_8);
            content.put("content", DataUtil.deflaterAndEncode64(fileAy));
            msgNoticeService.saveNoticeCallbackMessage(settleSplitLog.getCallbackUrl(), settleSplitLog.getIndustryCode(), settleSplitLog.getBatchNo(), content);

        } catch (Exception e) {
            log.error("子账户清分结果异步通知回调异常", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateOutTransOrderStatus(List<UploadSubAccountSettleSplitDetail> settleSplitDetails) {
        CompletableFuture.runAsync(() -> {
            try {
                if (settleSplitDetails == null || settleSplitDetails.isEmpty()) {
                    return;
                }
                settleSplitDetails.stream().filter(o -> TransStatus.TRADE_SUCCESS.name().equals(o.getTransStatus())).forEach(o -> {
                    outsideTransOrderService.updateSplitStatusAndLinkedSplitNum(o.getIndustryCode(),o.getTransOrderIds());

//                    Map<String, String> params = new HashMap<>(4);
//                    params.put("transOrderIds", o.getTransOrderIds());
//                    MybatisDaoImpl.of(OutsideTransOrderMapper.class).updateBySql("updateByTransOrderIdsAndSuccess", params);
                });
            } catch (Exception e) {
                log.error("更新支付流水分账状态异常：{}", e.getMessage(), e);
            }
        });
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
    public void processSubAccountSettleSplitRealTime(UserPayInfo payerUserPayInfo, List<UploadSubAccountSettleSplitDetail> subAccountSettleSplitDetailList) {
        try {
            long count = subAccountSettleSplitDetailList.stream()
                    .filter(detail -> SplitStatus.SPLIT_UNDO.getStatus().equals(detail.getStatus()) && TransStatus.PRE_CREATE.name().equals(detail.getTransStatus()))
                    .count();
            if (count != subAccountSettleSplitDetailList.size()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "整批次清分记录状态不一致");
            }
            subAccountSettleSplitDetailList.stream().forEach(detail -> {
                String serverTransId = serverIdGenerate.generateServerTransId();
                try {
                    //1.出金账户 余额扣减
                    //2.入金账户 余额增加
                    //3.交易流水表 新增子账户清分交易
                    detail.setGmtModified(new Date());
                    //记账结算模式
                    if (!SettleMode.CHARGE.getCode().equals(detail.getSettleMode())) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "结算方式非记账模式");
                    }
                    Account subAccount = innerAccountService.getAccountByUserAccount(detail.getUserAccount());
                    if (subAccount == null) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户不存在");
                    }
                    if (VirtualAccountStatus.CANCEL.getType().equals(subAccount.getStatus())) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户已销户");
                    }
                    // 实时代付及实时记账先记账，T+n代付及记账，待T+n后处理
                    if (detail.getPeriod() != 0) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "账期不等于0，非实时记账业务");
                    }

                    // 出金子账户余额扣减 及 入金子账户打款入金
                    innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, payerUserPayInfo.getUserAccount(), detail.getAmount(), detail.getSubAccount(),
                            String.format("子账户清分余额出金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, subAccount.getObjName(), detail.getClientTransId());
                    innerAccountService.plusBalance(AccountOperSubType.INCOME, detail.getSubAccount(), detail.getAmount(), payerUserPayInfo.getUserAccount(),
                            String.format("子账户清分打款入金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, payerUserPayInfo.getUserName(), detail.getClientTransId());
                    detail.setStatus(SplitStatus.SPLIT_OK.getStatus());
                    detail.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                    detail.setTransDesc("子账户已记账,待客户自行提现");
                    detail.setServerTransId(serverTransId);
                    detail.setReconcileDate(DateUtil.getCurrentDate());
                } catch (Exception e) {
                    detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
                    detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    detail.setTransDesc("子账户分账记账失败:" + StringUtil.truncate(e.getMessage(), 200));
                    detail.setServerTransId(serverTransId);
                    detail.setReconcileDate(DateUtil.getCurrentDate());
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("批次号[%s]客户端流水号[%s]子账户清分异常:%s", detail.getBatchNo(), detail.getClientTransId(), e.getMessage()));
                }
            });
        } catch (Exception e) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户清分失败：" + e.getMessage());
        }
    }


    private TransCurrent buildTransCurrent(UserPayInfo payerUserInfo, UploadSubAccountSettleSplitDetail detail) {
        UserPayInfo incomeUserInfo = innerAccountService.getUserPayInfo(detail.getSubAccount(),true);
        return TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(detail.getClientTransId())
                .clientTransTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .currency("CNY")
                .orgCode(payerUserInfo.getOrgCode())
                .orgName(payerUserInfo.getOrgName())
                .serverTransId(detail.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.SUBACCOUNT_SPLIT_PAYMENT.getCode())
                .transAmount(detail.getAmount())
                .transCallbackUrl(null)
                .transDate(DateUtil.getCurrentDate())
                .transTime(DateUtil.getCurrentTime())
                .merNo(payerUserInfo.getMerNo())
                .userCode(null)
                .accNo(payerUserInfo.getFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(detail.getAmount())
                .pcFlag(incomeUserInfo.getUserAccType())
                .userType(AccountType.getAccountTypeByCode(incomeUserInfo.getUserAccType()) == null ? null : AccountType.getAccountTypeByCode(incomeUserInfo.getUserAccType()).getValue())
                .payerAcctNo(payerUserInfo.getFundAccNo())
                .payerName(payerUserInfo.getFundAccName())
                .payeeAcctNo(incomeUserInfo.getFundAccNo())
                .payeeName(incomeUserInfo.getFundAccName())
                .industryCode(payerUserInfo.getIndustryCode())
                .transStatus(detail.getTransStatus())
                .respMessage(detail.getTransDesc())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(payerUserInfo.getUserAccount())
                .payeeAccount(incomeUserInfo.getUserAccount())
                .feeAccount(null)
                .incomeAccount(null)
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .reconcileDate(detail.getSplitDate())
                .showPayerAccountNo(payerUserInfo.getUserAccount())
                .showPayerAccountName(payerUserInfo.getUserName())
                .showPayeeAccountNo(incomeUserInfo.getUserAccount())
                .showPayeeAccountName(incomeUserInfo.getUserName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(null)
                .incomeAccountName(null)
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(detail.getTransDesc())
                .summaryDescription("子账户分账交易")
                .serverBatchNo(detail.getBatchNo())
                .splitInfoId(null)
                .build();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
    public void processSubAccountSettleSplit4Tn(UserPayInfo payerUserPayInfo, UploadSubAccountSettleSplitDetail detail) {
        String serverTransId = serverIdGenerate.generateServerTransId();
        try {
            //1.出金账户 余额扣减
            //2.入金账户 余额增加
            //3.交易流水表 新增子账户清分交易
            detail.setGmtModified(new Date());
            //记账结算模式
            if (!SettleMode.CHARGE.getCode().equals(detail.getSettleMode())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "结算方式非记账模式");
            }
            Account subAccount = innerAccountService.getAccountByUserAccount(detail.getUserAccount());
            if (subAccount == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(subAccount.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户已销户");
            }
            // Tn
            if (detail.getPeriod() == 0) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "账期为0，非Tn分账业务");
            }
            if (SplitStatus.SPLIT_OK.getStatus().equals(detail.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "该笔已分账，不能重复分账处理");
            }
            // 出金子账户余额扣减 及 入金子账户打款入金
            innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, payerUserPayInfo.getUserAccount(), detail.getAmount(), detail.getSubAccount(),
                    String.format("Tn子账户清分余额出金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, subAccount.getObjName(), detail.getClientTransId());
            innerAccountService.plusBalance(AccountOperSubType.INCOME, detail.getSubAccount(), detail.getAmount(), payerUserPayInfo.getUserAccount(),
                    String.format("Tn子账户清分打款入金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, payerUserPayInfo.getUserName(), detail.getClientTransId());
            detail.setStatus(SplitStatus.SPLIT_OK.getStatus());
            detail.setTransStatus(TransStatus.TRADE_SUCCESS.name());
            detail.setTransDesc("Tn子账户已记账,待客户自行提现");
            detail.setServerTransId(serverTransId);
            detail.setReconcileDate(DateUtil.getCurrentDate());
            //更新支付订单 关联状态及次数
            updateOutTransOrderStatus(Lists.newArrayList(detail));
        } catch (Exception e) {
            detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
            detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
            detail.setTransDesc("Tn子账户分账记账失败：" + StringUtil.truncate(e.getMessage(), 200));
            detail.setServerTransId(serverTransId);
            detail.setReconcileDate(DateUtil.getCurrentDate());
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("Tn 批次号[%s]客户端流水号[%s]子账户清分异常:%s", detail.getBatchNo(), detail.getClientTransId(), e.getMessage()));
        }

    }

}
