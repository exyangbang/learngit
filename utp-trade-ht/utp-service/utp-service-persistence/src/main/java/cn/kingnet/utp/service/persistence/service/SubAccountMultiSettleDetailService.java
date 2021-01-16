package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetail;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountMultiSettleDetailBo;
import cn.kingnet.utp.service.persistence.entity.bo.UserAccountInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/16
 */
@Service
@Slf4j
public class SubAccountMultiSettleDetailService {
    @Resource
    private ServerIdGenerate serverIdGenerate;
    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private OutsideTransOrderService outsideTransOrderService;

    @Async
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void processSubAccountMulSettleDetail(SubAccountMultiSettleDetailBo subAccountMultiSettleDetailBo) {
        List<SubAccountMulTiSettleDetail> subAccountMulTiSettleDetailList = subAccountMultiSettleDetailBo.getSubAccountMulTiSettleDetailList();
        try {
            //子账户多级分账只支持账期为0
            try {
                processSubAccountMultiSettleDetailRealTime(subAccountMulTiSettleDetailList, subAccountMultiSettleDetailBo.getSubAccountMap());
                updateOutTransOrderStatus(subAccountMulTiSettleDetailList);
            } catch (Exception e) {
                subAccountMulTiSettleDetailList.stream().forEach(detail -> {
                    detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
                    detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    detail.setTransDesc("整批次失败：" + e.getMessage());
                    detail.setReconcileDate(DateUtil.getCurrentDate());
                    detail.setGmtModified(new Date());
                });
            } finally {
                List<TransCurrent> transCurrentList = subAccountMulTiSettleDetailList.parallelStream().map(o -> this.buildTransCurrent(o)).collect(Collectors.toList());
                MybatisDaoImpl.run().insertBatch(transCurrentList, 100);
                MybatisDaoImpl.run().updateBatchById(subAccountMulTiSettleDetailList, 100);
            }
        } catch (Exception e) {
            log.error("子账户[{}]多级分账 批次[{}]处理异常：{}", subAccountMultiSettleDetailBo.getUserAccount(), subAccountMultiSettleDetailBo.getBatchNo(), e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("子账户多级分账异常:%s", e.getMessage()), e);
        }

    }


    @Transactional(rollbackFor = Exception.class)
    public void updateOutTransOrderStatus(List<SubAccountMulTiSettleDetail> subAccountMulTiSettleDetails) {
        CompletableFuture.runAsync(() -> {
            try {
                subAccountMulTiSettleDetails.stream().filter(o -> TransStatus.TRADE_SUCCESS.name().equals(o.getTransStatus())).forEach(o -> {
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

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void processSubAccountMultiSettleDetailRealTime(List<SubAccountMulTiSettleDetail> subAccountMulTiSettleDetailList, Map<String, UserAccountInfo> subAccountMap) {
        try {
            long count = subAccountMulTiSettleDetailList.stream()
                    .filter(detail -> SplitStatus.SPLIT_UNDO.getStatus().equals(detail.getStatus()) && TransStatus.PRE_CREATE.name().equals(detail.getTransStatus()))
                    .count();
            if (count != subAccountMulTiSettleDetailList.size()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "整批次分账记录状态不一致");
            }

            subAccountMulTiSettleDetailList.stream().forEach(detail -> {
                String serverTransId = serverIdGenerate.generateServerTransId();
                try {
                    //1.出金账户 余额扣减
                    //2.入金账户 余额增加
                    //3.交易流水表 新增子账户分账交易
                    //记账结算模式
                    Assert.isTrue(SettleMode.CHARGE.getCode().equals(detail.getSettleMode()), () -> "结算方式必须是记账模式");
                    Assert.isTrue(detail.getPeriod() == 0, () -> "账期必须为0（即实时记账业务）");

                    UserAccountInfo payerSubAccount = subAccountMap.get(detail.getPayerSubAccount());
                    UserAccountInfo payeeSubAccount = subAccountMap.get(detail.getPayeeSubAccount());

                    // 转出子账户余额扣减 及 转入子账户打款入金
                    innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, payerSubAccount.getAccount(), detail.getAmount(), payeeSubAccount.getAccount(),
                            String.format("子账户多级分账余额出金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, payeeSubAccount.getObjName(), detail.getClientTransId());
                    innerAccountService.plusBalance(AccountOperSubType.INCOME, payeeSubAccount.getAccount(), detail.getAmount(), payerSubAccount.getAccount(),
                            String.format("子账户多级分账打款入金. 批次号:%s 客户流水号:%s", detail.getBatchNo(), detail.getClientTransId()), serverTransId, payerSubAccount.getObjName(), detail.getClientTransId());

                    detail.setStatus(SplitStatus.SPLIT_OK.getStatus());
                    detail.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                    detail.setTransDesc("子账户多级分账已记账,待客户自行提现");
                    detail.setServerTransId(serverTransId);
                    detail.setReconcileDate(DateUtil.getCurrentDate());
                    detail.setGmtModified(new Date());
                } catch (Exception e) {
                    detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
                    detail.setTransStatus(TransStatus.TRADE_FAILURE.name());
                    detail.setTransDesc("子账户多级分账记账失败：" + StringUtil.truncate(e.getMessage(), 200));
                    detail.setServerTransId(serverTransId);
                    detail.setReconcileDate(DateUtil.getCurrentDate());
                    detail.setGmtModified(new Date());
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("批次号[%s]客户端流水号[%s]子账户多级分账异常:%s", detail.getBatchNo(), detail.getClientTransId(), e.getMessage()));
                }
            });
        } catch (Exception e) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "子账户多级分账失败：" + e.getMessage());
        }
    }


    private TransCurrent buildTransCurrent(SubAccountMulTiSettleDetail detail) {
        UserPayInfo payerUserInfo = innerAccountService.getUserPayInfo(detail.getPayerSubAccount(),true);
        UserPayInfo incomeUserInfo = innerAccountService.getUserPayInfo(detail.getPayeeSubAccount(),true);
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
                .transDate(detail.getTransDate())
                .transTime(detail.getTransTime())
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
                .reconcileDate(detail.getReqDate())
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
                .summaryDescription("子账户多级分账交易")
                .serverBatchNo(detail.getBatchNo())
                .splitInfoId(null)
                .build();
    }


}
