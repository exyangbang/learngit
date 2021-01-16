package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IProcessTransHandler;
import cn.kingnet.utp.service.persistence.api.ITransferHander;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.service.*;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhongli
 * @date 2018/10/18
 */
@RestController
@Slf4j
@RequestMapping("/spi/persistence/process/trans")
public class ProcessTransHandler extends DefaultFeginExceptionHandler implements IProcessTransHandler {

    @Autowired
    private InnerAccountService innerAccountService;

    @Autowired
    private ITransferHander transferHander;

    @Autowired
    private AccountSettleService accountSettleService;

    @Autowired
    private AccountOrderLogService accountOrderLogService;

    @Autowired
    private BankAccountTransDetailService bankAccountTransDetailService;

    @Autowired
    private ChannelAmountLimitService channelAmountLimitService;
    @Autowired
    private IndustryAmountLimitService industryAmountLimitService;
    @Autowired
    SubAccountAmountLimitService subAccountAmountLimitService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private MsgNoticeService msgNoticeService;
    @Resource
    private IndustryService industryService;

    private String fmtKey(String serverTransId) {
        return String.format("callBackServerTransIdKey:%s", serverTransId);
    }

    private boolean lock(String serverTransId, String callbackInfo) {
        String key = fmtKey(serverTransId);
        boolean lock = redisTemplate.opsForValue().setIfAbsent(fmtKey(serverTransId), callbackInfo);
        if (lock) {
            redisTemplate.opsForValue().getOperations().expire(key, 60, TimeUnit.SECONDS);
        }
        return lock;
    }

    private boolean unlock(String serverTransId) {
        return redisTemplate.delete(fmtKey(serverTransId));
    }

    /**
     * 华通交易回调更新
     *
     * @param id     交易表主键Id
     * @param status 回调转换 交易状态：TransStatus
     */
    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public TransCurrent onebankCallbackUpdate(@RequestParam(value = "id", required = false) long id, @RequestParam(value = "respCode", required = false) String respCode, @RequestParam(value = "respMsg", required = false) String respMsg, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "channelSettleDate", required = false) String channelSettleDate) {
        Assert.notNull(id, "交易表主键Id为空!");
        TransCurrent transCurrent = MybatisDaoImpl.run().selectById(TransCurrent.class, id);
        Assert.notNull(transCurrent, () -> "未找到交易记录 主键id=" + id);
        log.info("<<== 服务端交易流水号[{}],回调更新处理。respCode:{},respMsg:{},status:{},channelSettleDate:{}",
                transCurrent.getServerTransId(), respCode, respMsg, status, channelSettleDate);

        Assert.hasText(transCurrent.getServerTransId(), () -> "渠道回调处理,服务端流水号为空.");

        String curInfo = String.format("流水号:%s >> 开始处理时间:%s,响应码:%s[%s] 交易状态:%s", transCurrent.getServerTransId(), DateUtil.getDatetime(), respCode, respMsg, status);
        if (!lock(transCurrent.getServerTransId(), curInfo)) {
            log.warn("<<== 服务端流水号:{},当前已存在该服务端流水号进行回调业务处理中，策略上暂不处理.", transCurrent.getServerTransId());
            return null;
        }
        try {
            if (!(TransStatus.TRADE_SUCCESS.name().equals(transCurrent.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(transCurrent.getTransStatus()))) {
                String beforeTransStatus = transCurrent.getTransStatus();
                TransStatus transStatus = TransStatus.resolve(status);
                transCurrent.setTransStatus(transStatus.name());
                transCurrent.setRespMessage(transStatus.getTransDesc());
                transCurrent.setGmtModified(new Date());
                transCurrent.setChannelRespCode(respCode);
                transCurrent.setChannelRespMsg(respMsg);
                transCurrent.setRespException(null);
                transCurrent.setRespMessage(null);
                if (StringUtil.isNotBlank(channelSettleDate)) {
                    transCurrent.setChannelSettleDate(channelSettleDate);
                }
                if (StringUtil.isNotBlank(channelSettleDate) && StringUtil.isBlank(transCurrent.getReconcileDate())) {
                    transCurrent.setReconcileDate(channelSettleDate);
                }
                MybatisDaoImpl.run().updateById(transCurrent);

                if (!TransStatus.PROCESSING.name().equals(beforeTransStatus)) {
                    log.warn(" 服务端流水号:{} >> 原交易状态[{}]仅变更状态为[{}],无账户调账。", transCurrent.getServerTransId(), beforeTransStatus, status);
                    return transCurrent;
                }

                //提现
                if (transCurrent.getTradeType().equals(TradeType.WITHDRAW.getCode())) {
                    this.withdrawUpdate(transCurrent, transStatus);
                    //系统自动提现时分账流水更新
                    updateSplitInfoById(transCurrent, transCurrent.getSplitInfoId(), respMsg, channelSettleDate);
                } //平台转账
                else if (transCurrent.getTradeType().equals(TradeType.TRANSFER.getCode())) {
                    this.transferUpdate(transCurrent, transStatus);
                }//单笔实时代付
                else if (transCurrent.getTradeType().equals(TradeType.SGL_PAYMENT.getCode())) {
                    this.singlePayment(transCurrent, transStatus);
                } //预付费卡清算上送
                else if (transCurrent.getProductCode().equals(ProductCode.PRECARD.name()) && transCurrent.getTradeType().equals(TradeType.UPLOAD_ACCOUNT_SETTLE.getCode())) {
                    this.uploadAccountSettleUpdate(transCurrent, transStatus);
                }//订单退款
                else if (transCurrent.getTradeType().equals(TradeType.REFUND_ORDERID.getCode())) {
                    this.update4RefundOrderId(transCurrent, transStatus);
                }//归集账户提现
                else if (transCurrent.getTradeType().equals(TradeType.COLLECT_ACCOUNT_WITHDRAW.getCode())) {
                    this.collectAccountWithraw(transCurrent, transStatus);
                    this.updateCollectAccountWithdraw(transCurrent, respMsg, channelSettleDate);
                }//系统手续费收益账户归集划转
                else if (transCurrent.getTradeType().equals(TradeType.FEE_COLLECTION_TRANSFER.getCode())) {
                    this.feeIncomeAccountCollection(transCurrent, transStatus);
                }
                //随机金额打款认证
                else if (transCurrent.getTradeType().equals(TradeType.RANDOM_AMT_PAYMENT_AUTH.getCode())) {
                    this.randomAmtPaymentAuth(transCurrent,transStatus);
                    this.updateMerAcctInfoRandomAmtPaymentAuth(transCurrent,transStatus);
                }
                //子账户单笔付款
                else if (transCurrent.getTradeType().equals(TradeType.ACC_PAYMENT.getCode())) {
                    this.accPaymentUpdate(transCurrent,transStatus);
                }

                //已用渠道&客户号&子账户额度累加
                accumulateChannelIndustryAmount(transCurrent, transStatus);

            } else {
                log.error("交易记录主键id={} 服务端流水号={} >> 明确交易状态[{}],暂无法进行更新操作", id, transCurrent.getTransStatus(), transCurrent.getServerTransId());
            }

        }catch(Exception e){
            log.error("交易记录主键id={} 服务端流水号={} >> 渠道回调业务处理异常：{}", id, transCurrent.getServerTransId(),e.getMessage(),e);
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST,"渠道回调业务处理异常:"+e.getMessage(),e);
        }finally {
            unlock(transCurrent.getServerTransId());
        }

        return transCurrent;
    }


    /**
     * 回调成功后要扣除渠道额度||差错处理以及退汇处理 暂没有处理渠道额度
     *
     * @param transCurrent
     * @param transStatus
     */
    @Async
    public void accumulateChannelIndustryAmount(TransCurrent transCurrent, TransStatus transStatus) {

        if (TradeType.COLLECT_ACCOUNT_WITHDRAW.getCode().equals(transCurrent.getTradeType())
                || TradeType.FEE_COLLECTION_TRANSFER.getCode().equals(transCurrent.getTradeType())
        ) {
            return;
        }

        if (TransStatus.TRADE_SUCCESS == transStatus) {
            try {
                channelAmountLimitService.accumulateChannelAmount(transCurrent.getChannelCode(), transCurrent.getRealAmount(), transCurrent.getTransDate());
            } catch (Exception e) {
                log.error("服务端流水号:{} >> 已用渠道额度单日累加异常：", transCurrent.getServerTransId(), e);
            }
            try {
                industryAmountLimitService.accumulateIndustryAmount(transCurrent.getIndustryCode(), transCurrent.getTransAmount(), transCurrent.getTransDate());
            } catch (Exception e) {
                log.error("服务端流水号:{} >> 已用客户号额度单日累加异常：", transCurrent.getServerTransId(), e);
            }
            try {
                if (TradeType.WITHDRAW.getCode().equals(transCurrent.getTradeType())) {
                    subAccountAmountLimitService.accumulateSubAccountAmount(transCurrent.getIndustryCode(), transCurrent.getPayeeAccount(), transCurrent.getTransAmount(), transCurrent.getTransDate());
                }else if (TradeType.ACC_PAYMENT.getCode().equals(transCurrent.getTradeType())) {
                    subAccountAmountLimitService.accumulateSubAccountAmount(transCurrent.getIndustryCode(), transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getTransDate());
                }
            } catch (Exception e) {
                log.error("服务端流水号:{} >> 已用子账户额度单日累加异常：", transCurrent.getServerTransId(), e);
            }
        }

    }

    private void withdrawUpdate(TransCurrent transCurrent, TransStatus transStatus) {
        //交易成功
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            //防止重复以及前置记录是否存在
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())) {
                innerAccountService.minusBalance(AccountOperSubType.PAYMENT, transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "提现成功，代付出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 提现：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中扣减实际金额或不存在提现实际金额冻结记录.", transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }

            if (transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode())) {
                    //手续费支出账户出金
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "提现成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 提现：冻结金额中扣减手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中扣减手续费金额或不存在提现手续费冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    //手续费收益账户入金
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getFeeAccount(), "提现成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getFeeAccountName(), null);
                    } else {
                        log.error(" 提现：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                } else if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.INNER.getMode().equals(transCurrent.getMerChargeMode())) {
                    //手续费支出账户出金
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount().longValue())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "提现成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 提现：冻结金额中扣减手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中扣减手续费金额或不存在手续费冻结记录.", transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    //手续费收益账户入金
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getPayeeAcctNo(), "提现成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
                    } else {
                        log.error(" 提现：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                }
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())) {
                innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "提现失败，恢复提现冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 提现：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode())) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "提现失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 提现：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中解冻手续费金额或不存在手续费金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                } else if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.INNER.getMode().equals(transCurrent.getMerChargeMode())) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount())) {
                        innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "提现失败，恢复提现冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 提现：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在提现 冻结金额中解冻手续费金额或不存在手续费冻结记录.", transCurrent.getPayeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                }
            }
        }
    }


    boolean isRealtimeInner(TransCurrent transCurrent) {
        return SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) &&
                ChargeMode.INNER.getMode().equals(transCurrent.getMerChargeMode());
    }

    boolean isRealtimeBuckle(TransCurrent transCurrent) {
        return SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) &&
                ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode());
    }

    boolean isMerFeeZero(TransCurrent transCurrent) {
        return transCurrent.getMerFee() == null || transCurrent.getMerFee().longValue() <= 0;
    }

    /**
     * 转账仅支持实时外扣模式
     **/
    private void transferUpdate(TransCurrent transCurrent, TransStatus transStatus) {
        transferHander.updateByIndustryCodeAndServerTransId(Transfer.builder().status(transStatus.name()).build(), transCurrent.getIndustryCode(), transCurrent.getServerTransId());
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.minusBalance(AccountOperSubType.TRANSFER, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAccount(), "转账成功，转账出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 内部虚转：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())) {
                innerAccountService.plusBalance(AccountOperSubType.TRANSFER, transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getPayerAccount(), "转账成功,转账入金", transCurrent.getServerTransId(), transCurrent.getPayerName(), null);
            } else {
                log.error(" 内部虚转：收款者打款入金实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 收款者打款入金实际金额记录.", transCurrent.getPayeeAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (isRealtimeBuckle(transCurrent) && !isMerFeeZero(transCurrent)) {
                if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                        && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                ) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                } else {
                    log.error(" 内部虚转：冻结金额中扣减手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 冻结金额中扣减手续费或不存在手续费金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                }
                if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getFeeAccount(), "转账成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getFeeAccountName(), null);
                } else {
                    log.error(" 内部虚转：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                }
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.unfreezeBalance(AccountOperSubType.TRANSFER, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAccount(), "转账失败，恢复转账冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 内部虚转：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (isRealtimeBuckle(transCurrent) && !isMerFeeZero(transCurrent)) {
                if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                        && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                ) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                } else {
                    log.error(" 内部虚转：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在内部虚转 冻结金额中解冻手续费金额或不存在手续费金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                }
            }
        }

    }

    private void singlePayment(TransCurrent transCurrent, TransStatus transStatus) {
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.minusBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "转账成功，转账出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 单笔实时代付：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }

            if (!isMerFeeZero(transCurrent)) {
                if (isRealtimeBuckle(transCurrent)) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 单笔实时代付：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getFeeAccount(), "转账成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getFeeAccountName(), null);
                    } else {
                        log.error(" 单笔实时代付：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                } else if (isRealtimeInner(transCurrent)) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 单笔实时代付：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getPayerAccount(), "转账成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getPayerName(), null);
                    } else {
                        log.error(" 单笔实时代付：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                }
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "转账失败，恢复转账冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 单笔实时代付：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (isRealtimeBuckle(transCurrent) && !isMerFeeZero(transCurrent)) {
                if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                        && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                ) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                } else {
                    log.error(" 单笔实时代付：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中解冻手续费金额或不存在手续费金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                }
            } else if (isRealtimeInner(transCurrent) && !isMerFeeZero(transCurrent)) {
                if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                        && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount())
                ) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "转账失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                } else {
                    log.error(" 单笔实时代付：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在单笔实时代付 冻结金额中解冻手续费金额或不存在手续费金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                }
            }
        }

    }

    private void uploadAccountSettleUpdate(TransCurrent transCurrent, TransStatus transStatus) {
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            accountSettleService.callbackSuccess(transCurrent, transStatus);
        } else {
            accountSettleService.callbackFailure(transCurrent, transStatus);
        }
    }

    /**
     * 订单退款不收取手续费
     **/
    private void update4RefundOrderId(TransCurrent transCurrent, TransStatus transStatus) {
        accountOrderLogService.updateByServerTransId(transCurrent.getServerTransId(), transStatus, transCurrent.getChannelRespMsg());
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            //退款明确成功才需要变更状态，
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId())) {
                innerAccountService.minusBalance(AccountOperSubType.REFUND, transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getPayeeAcctNo(), "订单退款成功，退款出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), transCurrent.getOrderId());
                bankAccountTransDetailService.updateOrderStatusByOrderId(transCurrent.getPayerAccount(), transCurrent.getOrderId(), AccountOrderStatus.REFUNDED.getCode());
            } else {
                log.error(" 订单退款：冻结金额中扣减退款实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 冻结金额中扣减退款实际金额或不存在退款实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId());
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId())) {
                innerAccountService.unfreezeBalance(AccountOperSubType.REFUND, transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getPayeeAcctNo(), "订单退款失败，恢复退款冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), transCurrent.getOrderId());
                bankAccountTransDetailService.updateOrderStatusByOrderId(transCurrent.getPayerAccount(), transCurrent.getOrderId(), AccountOrderStatus.REFUND_FAIL.getCode());
            } else {
                log.error(" 订单退款：冻结金额中解冻退款实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 冻结金额中解冻退款实际金额或不存在退款实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getTransAmount(), transCurrent.getServerTransId());
            }
        }
    }

    /**
     * 附属更新分账流水（T+0 自动提现）
     *
     * @param transCurrent
     * @param splitInfoId
     * @param respMsg
     */
    @Async
    public void updateSplitInfoById(TransCurrent transCurrent, Long splitInfoId, String respMsg, String
            channelSettleDate) {
        if (splitInfoId == null || splitInfoId.longValue() <= 0) {
            return;
        }
        // 清算分账上送 T+0是通过提现准实时分账到商户或个人的
        if (!transCurrent.getTradeType().equals(TradeType.WITHDRAW.getCode())) {
            return;
        }
        try {
            SplitInfo splitInfo = MybatisDaoImpl.run().selectById(SplitInfo.class, splitInfoId);
            if (splitInfo != null) {
                if (!(TransStatus.TRADE_SUCCESS.name().equals(splitInfo.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(splitInfo.getTransStatus()))) {
                    splitInfo.setTransStatus(transCurrent.getTransStatus());
                    splitInfo.setGmtModified(new Date());
                    splitInfo.setTransDesc(StringUtil.substring(respMsg, 0, 50));
                    splitInfo.setClientTransId(transCurrent.getClientTransId());
                    splitInfo.setServerTransId(transCurrent.getServerTransId());
                    if (StringUtil.isNotEmpty(channelSettleDate)) {
                        splitInfo.setReconcileDate(channelSettleDate);
                    }
                    MybatisDaoImpl.run().updateById(splitInfo);
                } else {
                    log.error("分账记录id={} 状态={}，无法进行更新操作", splitInfoId, splitInfo.getTransStatus());
                }
            }
        } catch (Exception e) {
            log.error("分账记录id={} 提现更新状态为{}操作异常", splitInfoId, transCurrent.getTransStatus());
        }

    }


    private void collectAccountWithraw(TransCurrent transCurrent, TransStatus transStatus) {
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.minusBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "归集账户提现成功，转账出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 归集账户提现：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在归集账户提现 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "归集账户提现失败，恢复转账冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 归集账户提现：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在归集账户提现 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        }
    }

    @Async
    public void updateCollectAccountWithdraw(TransCurrent transCurrent, String respMsg, String channelSettleDate) {
        if (!transCurrent.getTradeType().equals(TradeType.COLLECT_ACCOUNT_WITHDRAW.getCode())) {
            return;
        }
        try {
            List<CollectAccountWithdraw> list = MybatisDaoImpl.run().selectList(CollectAccountWithdrawCondition.builder()
                    .andIndustryCodeEq(transCurrent.getIndustryCode()).andClientTransIdEq(transCurrent.getClientTransId()).andServerTransIdEq(transCurrent.getServerTransId()).build());
            if (list != null && list.size() != 1) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "归集账户提现记录为空或多记录");
            }
            CollectAccountWithdraw collectAccountWithdraw = list.get(0);
            if (!(TransStatus.TRADE_SUCCESS.name().equals(collectAccountWithdraw.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(collectAccountWithdraw.getTransStatus()))) {
                collectAccountWithdraw.setTransStatus(transCurrent.getTransStatus());
                collectAccountWithdraw.setGmtModified(new Date());
                collectAccountWithdraw.setTransDesc(StringUtil.truncate(respMsg, 100));
                MybatisDaoImpl.run().updateById(collectAccountWithdraw);
            }
        } catch (Exception e) {
            log.error("归集账户提现 服务端流水号:{} >> 更新状态为{} 操作异常", transCurrent.getServerTransId(), transCurrent.getTransStatus());
        }

    }

    private void feeIncomeAccountCollection(TransCurrent transCurrent, TransStatus transStatus) {
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.minusBalance(AccountOperSubType.COLLECTION, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), transCurrent.getSummaryDescription()+" 成功，转账出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 收益账户归集划转：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在收益账户归集划转 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.unfreezeBalance(AccountOperSubType.COLLECTION, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), transCurrent.getSummaryDescription()+" 失败，恢复转账冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 收益账户归集划转：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在收益账户归集划转 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        }

        // 更新状态
        String collectionStatus = TransStatus.TRADE_SUCCESS.name().equals(transCurrent.getTransStatus()) ? CollectionStatus.COLLECTED.getStatus() : null;
        FeeIncomeAccountMonthStat feeIncomeAccountMonthStat = FeeIncomeAccountMonthStat.builder()
                .account(transCurrent.getPayerAccount()).serverTransId(transCurrent.getServerTransId()).collectionStatus(collectionStatus)
                .transStatus(transCurrent.getTransStatus()).transDesc(transCurrent.getRespMessage())
                .remark(transCurrent.getRespMessage()).gmtModified(new Date()).build();

        PlusEntityWrapper<FeeIncomeAccountMonthStat> wrapper = FeeIncomeAccountMonthStatCondition.builder()
                .andAccountEq(transCurrent.getPayerAccount()).andServerTransIdEq(transCurrent.getServerTransId())
                .and().andCollectionStatusNe(CollectionStatus.COLLECTED.getStatus()).orCollectionStatusIsNull()
                .and().andTransStatusNe(TransStatus.TRADE_SUCCESS.name()).orTransStatusIsNull().build();
        MybatisDaoImpl.run().update(feeIncomeAccountMonthStat, wrapper);

    }

    /**
     * 随机金额打款认证
     * @param transCurrent
     * @param transStatus
     */
    private void randomAmtPaymentAuth(TransCurrent transCurrent, TransStatus transStatus) {
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.minusBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "随机金额打款成功，打款出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 随机金额打款认证：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在随机金额打款认证 冻结金额中扣减实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
            ) {
                innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "随机金额打款失败，恢复打款冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 随机金额打款认证：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在随机金额打款认证 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
        }
    }

    /**
     * 随机金额打款认证
     * @param transCurrent
     * @param transStatus
     */
    private void updateMerAcctInfoRandomAmtPaymentAuth(TransCurrent transCurrent, TransStatus transStatus){
        if(StringUtil.isNotBlank(transCurrent.getPayeeAccount()) && StringUtil.isNotBlank(transCurrent.getPayeeAcctNo())){
            MerchantAccountInfo updateMerchantAccountInfo = MerchantAccountInfo.builder()
                    .channelRespCode(transCurrent.getChannelRespCode())
                    .channelRespMsg(transCurrent.getChannelRespMsg())
                    .gmtModified(DateUtil.getSystemDate())
                    .build();
            if (transStatus == TransStatus.TRADE_SUCCESS) {
                updateMerchantAccountInfo.setBindStatus(BindCardStatus.WAITING_AUTH.getStatus());
            }else {
                updateMerchantAccountInfo.setBindStatus(BindCardStatus.FAILURE.getStatus());
            }
            int updateCount = MybatisDaoImpl.run().update(updateMerchantAccountInfo,MerchantAccountInfoCondition.builder().andAccountEq(transCurrent.getPayeeAccount()).andAccountNoEq(transCurrent.getPayeeAcctNo()).andBindStatusEq(BindCardStatus.PROCESSING.getStatus()).build());

            //绑卡异步通知
            if(updateCount > 0 && StringUtil.isNotBlank(transCurrent.getIndustryCode())){
                Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(transCurrent.getIndustryCode()).build());
                if(industry != null && StringUtil.isNotBlank(industry.getInnerNoticeUrl())){
                    Map<String, Object> map = new HashMap<>(8);
                    map.put("userAccount", transCurrent.getPayeeAccount());
                    map.put("acctNo", transCurrent.getPayeeAcctNo());
                    map.put("bindStatus", updateMerchantAccountInfo.getBindStatus());
                    map.put("errCode", updateMerchantAccountInfo.getChannelRespCode());
                    map.put("errMsg", updateMerchantAccountInfo.getChannelRespMsg());

                    Map<String, Object> content = new HashMap(8);
                    content.put("noticeType", NoticeType.AUTH_BIND_STATUS_CHANGE.getType());
                    content.put("industryCode", transCurrent.getIndustryCode());
                    content.put("items", map);
                    try {
                        msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(),industry.getCode(),transCurrent.getServerTransId(),content);
                    } catch (Exception e) {
                        log.error("代付客户号{},服务端流水号{},绑定卡号{},触发redis存储回调下游消息异常:{}", transCurrent.getIndustryCode(), transCurrent.getServerTransId(), updateMerchantAccountInfo.getAccountNo(),e.getMessage(),e);
                    }
                }else {
                    log.error("代付客户号{},服务端流水号{},绑定卡号{},未配置通知URL地址,无进行通知!", transCurrent.getIndustryCode(), transCurrent.getServerTransId(), updateMerchantAccountInfo.getAccountNo());
                }
            }else {
                log.error("代付客户号{},服务端流水号{},绑定卡号{},更新绑卡信息数{},无进行通知!", transCurrent.getIndustryCode(), transCurrent.getServerTransId(), updateMerchantAccountInfo.getAccountNo(),updateCount);
            }
        }
    }


    private void accPaymentUpdate(TransCurrent transCurrent, TransStatus transStatus) {
        //交易成功
        if (transStatus == TransStatus.TRADE_SUCCESS) {
            //防止重复以及前置记录是否存在
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())) {
                innerAccountService.minusBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "子账户单笔付款成功，代付出金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 子账户单笔付款：冻结金额中扣减实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中扣减实际金额或不存在提现实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }

            if (transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode())) {
                    //手续费支出账户出金
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "子账户单笔付款成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 子账户单笔付款：冻结金额中扣减手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中扣减手续费金额或不存在提现手续费冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    //手续费收益账户入金
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getFeeAccount(), "子账户单笔付款成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getFeeAccountName(), null);
                    } else {
                        log.error(" 子账户单笔付款：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                } else if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.INNER.getMode().equals(transCurrent.getMerChargeMode())) {
                    //手续费支出账户出金
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Minus(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount().longValue())
                    ) {
                        innerAccountService.minusBalance(AccountOperSubType.FEE, transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "子账户单笔付款成功，手续费出金", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 子账户单笔付款：冻结金额中扣减手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中扣减手续费金额或不存在手续费冻结记录.", transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                    //手续费收益账户入金
                    if (!innerAccountService.isExistAccountDetail4Plus(transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getPayeeAcctNo(), "子账户单笔付款成功，手续费入金", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
                    } else {
                        log.error(" 子账户单笔付款：手续费收益账户打款入金手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 手续费收益账户打款入金手续费金额记录.", transCurrent.getIncomeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                }
            }
        } else {
            if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())
                    && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId())) {
                innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getPayeeAcctNo(), "子账户单笔付款失败，恢复冻结金额", transCurrent.getServerTransId(), transCurrent.getPayeeName(), null);
            } else {
                log.error(" 子账户单笔付款：冻结金额中解冻实际金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中解冻实际金额或不存在实际金额冻结记录.", transCurrent.getPayerAccount(), transCurrent.getRealAmount(), transCurrent.getServerTransId());
            }
            if (transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode())) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())) {
                        innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "子账户单笔付款失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 子账户单笔付款：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中解冻手续费金额或不存在手续费金额冻结记录.", transCurrent.getFeeAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                } else if (SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.INNER.getMode().equals(transCurrent.getMerChargeMode())) {
                    if (innerAccountService.isExistAccountDetail4Freezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId())
                            && !innerAccountService.isExistAccountDetail4Unfreezen(transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId(), transCurrent.getMerFee().longValue() == transCurrent.getRealAmount())) {
                        innerAccountService.unfreezeBalance(AccountOperSubType.FEE, transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "子账户单笔付款失败，恢复冻结手续费", transCurrent.getServerTransId(), transCurrent.getIncomeAccountName(), null);
                    } else {
                        log.error(" 子账户单笔付款：冻结金额中解冻手续费金额 暂无法操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在子账户单笔付款 冻结金额中解冻手续费金额或不存在手续费冻结记录.", transCurrent.getPayerAccount(), transCurrent.getMerFee(), transCurrent.getServerTransId());
                    }
                }
            }
        }
    }
}
