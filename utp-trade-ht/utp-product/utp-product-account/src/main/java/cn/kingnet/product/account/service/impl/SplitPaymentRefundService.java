package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.SplitPaymentRefundReqDTO;
import cn.kingnet.utp.trade.common.dto.account.SplitPaymentRefundRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.collect.Lists;
import feign.RetryableException;
import org.springframework.cglib.beans.BeanMap;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description : 平台单笔分账退款接口 split_payment_refund
 * @Author : caixh
 * @Create : 2020/06/29
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.SPLIT_PAYMENT_REFUND,
        reqClass = SplitPaymentRefundReqDTO.class,
        respClass = SplitPaymentRefundRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.TRADE_SUCCESS
)
public class SplitPaymentRefundService extends AbstractAccountTradeService<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected ITransHistoryHandler transHistoryHandler;
    @Resource
    protected IPaymentService paymentService;
    @Resource
    protected IAccountHandler accountHandler;
    @Resource
    private ISplitInfoHandler splitInfoHandler;
    @Resource
    private IBlackListHandler blackListHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;

    public SplitPaymentRefundService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> tradeContext) {
        SplitPaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        //平台往子账户分账
        ChannelResponseDTO channelResponseDTO = new ChannelResponseDTO();
        SplitPaymentRefundRespDTO respDTO = new SplitPaymentRefundRespDTO();
        respDTO.setReconcileDate(tradeContext.getTransDate());

        TransCurrent transCurrentOrg = tradeContext.getAttribute("transCurrent");
        try {
            splitInfoHandler.processSingleSplitPaymentRefund(tradeContext.getAuthInfo().getAuthNo(), transCurrentOrg.getPayerAccount(), transCurrentOrg.getPayeeAccount(), Long.valueOf(reqDTO.getPayAmt()),
                    tradeContext.getServerTransId(), reqDTO.getRemark(), reqDTO.getClientTradeId(), transCurrentOrg.getId(), transCurrentOrg.getHistoryStatus());
            respDTO.setTransStatus(TransStatus.TRADE_SUCCESS.name());
            respDTO.setStatusDesc("交易成功");
            respDTO.setStatus(HttpRespStatus.OK.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
        } catch (RetryableException e) {
            logger.error("流水号:{} >> 调用分账退款服务异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            respDTO.setTransStatus(TransStatus.TRADE_ERROR.name());
            respDTO.setStatusDesc("交易异常,状态未知");
            respDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
            channelResponseDTO.setMessage("交易异常,状态未知");
            channelResponseDTO.setException(e.getMessage());
        } catch (Exception e) {
            logger.error("流水号:{} >> 调用分账退款服务失败:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setStatusDesc("交易失败：" + StringUtil.truncate(e.getMessage(), 200));
            respDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setMessage("交易失败：" + StringUtil.truncate(e.getMessage(), 200));
            channelResponseDTO.setException(e.getMessage());
        }
        channelResponseDTO.setSpRespMsg(BeanMap.create(respDTO));
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        SplitPaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();


        ValidateUtils.isPositiveInteger(reqDTO.getPayAmt(), 15, true, "分账金额");

        long payAmt = new BigDecimal(reqDTO.getPayAmt()).longValue();
        ValidateUtils.abcValid(reqDTO.getOrigClientTradeId(), true, "原客户端流水号");

        ValidateUtils.maxLength(reqDTO.getRemark(), 1000, true, "备注信息");

        //交易客户端流水不能重复：当天交易流水检验
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }

        TransCurrent transCurrent = transCurrentHandler.getByIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getOrigClientTradeId(), null);
        tradeContext.setAttribute("transCurrent", transCurrent);
        if (transCurrent == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "原分账流水不存在!");
        }

        // 原交易状态检查
        if (!(TradeType.SPLIT_PAYMENT.getCode().equals(transCurrent.getTradeType()) || TradeType.SUBACCOUNT_SPLIT_PAYMENT.getCode().equals(transCurrent.getTradeType()))
                || !transCurrent.getTransStatus().equals(TransStatus.TRADE_SUCCESS.name())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "原交易流水非分账交易或交易状态不成功，无法退款!");
        }
        if (CommonConstants.REFUND_STATUS_OK.equals(transCurrent.getRefundStatus())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "原分账交易已全额退款，无法继续退款!");
        }
        // 退款金额大于于原分账金额
        if (payAmt > (transCurrent.getTransAmount() - transCurrent.getRefundAmount())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "退款金额超出可退款金额!");
        }
        if (TradeType.SPLIT_PAYMENT.getCode().equals(transCurrent.getTradeType())) {
            //平台分账校验平台户信息
            //校验查询平台商户基本信息是否存在
            this.setBasicConfigInfo(tradeContext, transCurrent.getPayeeAccount());
            BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
            ValidateUtils.hasText(basicConfigInfo.getMerNo(), "用户账户未开户");

            AccountStatus accountStatus = AccountStatus.getEnum(Integer.parseInt(basicConfigInfo.getUserAccountStatus()));
            if (AccountStatus.NO_OPEN == accountStatus || AccountStatus.CANCEL == accountStatus) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("用户账户%s,不能分账退款!", accountStatus.getValue()));
            }
            //企业用户只有审核通过才可能出入金
            if (VirtualAccountType.MERCHANT.getType().equals(basicConfigInfo.getUserAccountNature()) && basicConfigInfo.getUserAuthStatus() != 1) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户审核未通过,不能分账退款!");
            }
        }
        if (TradeType.SUBACCOUNT_SPLIT_PAYMENT.getCode().equals(transCurrent.getTradeType())) {
            {
                //子账户清分交易：子账户清分文件及子账户多级清分文件上送处理
                Account payerAccount = accountHandler.queryAccountByUserAccount(transCurrent.getPayerAccount());
                ValidateUtils.notNull(payerAccount, "原付款账户不能为空");
                VirtualAccountStatus payerAccountStatus = VirtualAccountStatus.resolve(payerAccount.getStatus());
                if (payerAccountStatus == null || !payerAccountStatus.isNormal()) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("原付款虚账户%s,不能分账退款!", payerAccountStatus == null ? null : payerAccountStatus.getName()));
                }
                if (VirtualAccountType.isSubAccount(payerAccount.getObjType())) {
                    MerchantInfoBo payerMerchantInfo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(transCurrent.getPayerAccount(),false);
                    ValidateUtils.notNull(payerMerchantInfo, "原付款账户不能为空");
                    AccountStatus payerMerStatus = AccountStatus.getEnum(Integer.valueOf(payerMerchantInfo.getStatus()));
                    if (payerMerStatus == null || !payerMerStatus.ableHandleCashStatus()) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("原付款用户账户%s,不能分账退款!", payerMerStatus == null ? null : payerMerStatus.getValue()));
                    }
                    //企业用户只有审核通过才可能出入金
                    if (VirtualAccountType.MERCHANT.getType().equals(payerAccount.getObjType()) && payerMerchantInfo.getAuthStatus() != 1) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, "原付款用户账户审核未通过,不能分账退款!");
                    }
                }

                Account payeeAccount = accountHandler.queryAccountByUserAccount(transCurrent.getPayeeAccount());
                ValidateUtils.notNull(payeeAccount, "原收款账户不能为空");
                VirtualAccountStatus payeeAccountStatus = VirtualAccountStatus.resolve(payeeAccount.getStatus());
                if (payeeAccountStatus == null || !payeeAccountStatus.isNormal()) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("原收款虚账户%s,不能分账退款!", payeeAccountStatus == null ? null : payeeAccountStatus.getName()));
                }
                if (VirtualAccountType.isSubAccount(payeeAccount.getObjType())) {
                    MerchantInfoBo payeeMerchantInfo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(transCurrent.getPayeeAccount(),false);
                    ValidateUtils.notNull(payeeMerchantInfo, "原收款账户不能为空");
                    AccountStatus payeeMerStatus = AccountStatus.getEnum(Integer.valueOf(payeeMerchantInfo.getStatus()));
                    if (payeeMerStatus == null || !payeeMerStatus.ableHandleCashStatus()) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("原收款用户账户%s,不能分账退款!", payeeMerStatus == null ? null : payeeMerStatus.getValue()));
                    }
                    //企业用户只有审核通过才可能出入金
                    if (VirtualAccountType.MERCHANT.getType().equals(payeeAccount.getObjType()) && payeeMerchantInfo.getAuthStatus() != 1) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, "原收款用户账户审核未通过,不能分账退款!");
                    }
                }


            }

        }


        if (!transCurrentHandler.setSplitPaymentRedfund(reqDTO.getOrigClientTradeId())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "已在处理该笔分账交易的其他退款,请稍后再试");
        }

        tradeContext.setAttribute("transCurrent", transCurrent);

    }


    @Override
    public void initTransFlow(TradeContext<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> tradeContext) {
        SplitPaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        TransCurrent transCurrentOrg = tradeContext.getAttribute("transCurrent");

        TransCurrent transCurrent = TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(tradeContext.getTransDate() + tradeContext.getTransTime())
                .currency("CNY")
                .orgCode(transCurrentOrg.getOrgCode())
                .orgName(transCurrentOrg.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(transCurrentOrg.getTradeType().equals(TradeType.SPLIT_PAYMENT.getCode()) ?
                        TradeType.SPLIT_PAYMENT_REFUND.getCode() : TradeType.SUBACCOUNT_SPLIT_PAYMENT_REFUND.getCode())
                .serverLinkId(transCurrentOrg.getServerTransId())
                .transAmount(Long.valueOf(reqDTO.getPayAmt()))
                .transCallbackUrl(null)
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(transCurrentOrg.getMerNo())
                .userCode(null)
                .accNo(transCurrentOrg.getAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(Long.valueOf(reqDTO.getPayAmt()))
                .pcFlag(transCurrentOrg.getPcFlag())
                .userType(transCurrentOrg.getUserType())
                .payerAcctNo(transCurrentOrg.getPayeeAcctNo())
                .payerName(transCurrentOrg.getPayeeName())
                .payeeAcctNo(transCurrentOrg.getPayerAcctNo())
                .payeeName(transCurrentOrg.getPayerName())
                .industryCode(transCurrentOrg.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(transCurrentOrg.getPayeeAccount())
                .payeeAccount(transCurrentOrg.getPayerAccount())
                .feeAccount(transCurrentOrg.getFeeAccount())
                .incomeAccount(transCurrentOrg.getIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .reconcileDate(tradeContext.getTransDate())
                .showPayerAccountNo(transCurrentOrg.getShowPayeeAccountNo())
                .showPayerAccountName(transCurrentOrg.getShowPayeeAccountName())
                .showPayeeAccountNo(transCurrentOrg.getShowPayerAccountNo())
                .showPayeeAccountName(transCurrentOrg.getShowPayerAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(transCurrentOrg.getFeeAccountName())
                .incomeAccountName(transCurrentOrg.getIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(reqDTO.getRemark())
                .summaryDescription("单笔实时分账退款交易")
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransCurrent(Lists.newArrayList(transCurrent));
    }

    @Override
    public void updateTransFlow(TradeContext<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        SplitPaymentRefundRespDTO responseDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        SplitPaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.merNo(basicConfigInfo.getMerNo());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (responseDTO != null) {
            builder.respCode(responseDTO.getStatus())
                    .respException(responseDTO.getException())
                    .respMessage(responseDTO.getMessage());
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());
        transCurrentHandler.deleteSplitPaymentRedfund(reqDTO.getOrigClientTradeId());
    }

    @Override
    public void insertTransParamFail(TradeContext<SplitPaymentRefundReqDTO, SplitPaymentRefundRespDTO> tradeContext, Exception e) {
        SplitPaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        TransCurrent transCurrentOrg = tradeContext.getAttribute("transCurrent");

        long transAmount;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }

        if (transCurrentOrg == null) {
            transCurrentOrg = new TransCurrent();
        }

        TransParamFailVo paramFailVo = TransParamFailVo.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(tradeContext.getTransDate() + tradeContext.getTransTime())
                .currency("CNY")
                .orgCode(transCurrentOrg.getOrgCode())
                .orgName(transCurrentOrg.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(transCurrentOrg == null ? null : (transCurrentOrg.getTradeType().equals(TradeType.SPLIT_PAYMENT.getCode()) ?
                        TradeType.SPLIT_PAYMENT_REFUND.getCode() : TradeType.SUBACCOUNT_SPLIT_PAYMENT_REFUND.getCode()))
                .serverLinkId(transCurrentOrg.getServerTransId())
                .transAmount(transAmount)
                .transCallbackUrl(null)
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(transCurrentOrg.getMerNo())
                .userCode(null)
                .accNo(transCurrentOrg.getAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(transAmount)
                .pcFlag(transCurrentOrg.getPcFlag())
                .userType(transCurrentOrg.getUserType())
                .payerAcctNo(transCurrentOrg.getPayeeAcctNo())
                .payerName(transCurrentOrg.getPayeeName())
                .payeeAcctNo(transCurrentOrg.getPayerAcctNo())
                .payeeName(transCurrentOrg.getPayerName())
                .industryCode(tradeContext.getIndustryCode())
                .transStatus(TransStatus.TRADE_FAILURE.name())
                .channelRespCode(OneBankRespCode.PCC90008.name())
                .respCode(HttpRespStatus.BAD_REQUEST.valueStr())
                .respMessage(StringUtil.truncate(e.getMessage(), 200))
                .reconcileDate(tradeContext.getTransDate())
                .channelSettleDate(tradeContext.getTransTime())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(transCurrentOrg.getPayeeAccount())
                .payeeAccount(transCurrentOrg.getPayerAccount())
                .feeAccount(transCurrentOrg.getFeeAccount())
                .incomeAccount(transCurrentOrg.getIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .reconcileDate(tradeContext.getTransDate())
                .showPayerAccountNo(transCurrentOrg.getShowPayeeAccountNo())
                .showPayerAccountName(transCurrentOrg.getShowPayeeAccountName())
                .showPayeeAccountNo(transCurrentOrg.getShowPayerAccountNo())
                .showPayeeAccountName(transCurrentOrg.getShowPayerAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(transCurrentOrg.getFeeAccountName())
                .incomeAccountName(transCurrentOrg.getIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(reqDTO.getRemark())
                .summaryDescription("单笔实时分账退款交易")
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
