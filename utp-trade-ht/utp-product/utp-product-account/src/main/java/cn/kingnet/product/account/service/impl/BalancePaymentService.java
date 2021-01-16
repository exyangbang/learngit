package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.CommonPayInfo;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.InnerAccountTransferBo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.BalancePaymentReqDTO;
import cn.kingnet.utp.trade.common.dto.account.BalancePaymentRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Description 余额支付 接口
 * @Author WJH
 * @Date 2020/03/10
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.BALANCE_PAYMENT,
        reqClass = BalancePaymentReqDTO.class,
        respClass = BalancePaymentRespDTO.class,
        createTransFlow = true,
        successTransStatus = TransStatus.PROCESSING
)
public class BalancePaymentService extends AbstractAccountTradeService<BalancePaymentReqDTO, BalancePaymentRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected ITransHistoryHandler transHistoryHandler;
    @Resource
    protected IChannelRelevantHandler channelRelevantHandler;
    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;
    @Resource
    protected IIndustryHandler industryHandler;

    protected static final String PAYER_PAYINFO = "PAYER_PAYINFO";
    protected static final String PAYEE_PAYINFO = "PAYEE_PAYINFO";
    protected static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";

    public BalancePaymentService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<BalancePaymentReqDTO, BalancePaymentRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        BalancePaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        ChannelResponseDTO channelResponseDTO = new ChannelResponseDTO();
        channelResponseDTO.setServerTransId(tradeContext.getServerTransId());
        BalancePaymentRespDTO.BalancePaymentRespDTOBuilder respDTOBuilder = BalancePaymentRespDTO.builder();
        respDTOBuilder.reconcileDate(DateUtil.plusDate(reqDTO.getReqDate(), DateTimeFormatter.BASIC_ISO_DATE, basicConfigInfo.getBalancePayPeriod4Int()));
        try {
            CommonPayInfo payerPayInfo = tradeContext.getAttribute(PAYER_PAYINFO);
            CommonPayInfo payeePayInfo = tradeContext.getAttribute(PAYEE_PAYINFO);
            InnerAccountTransferBo innerAccountTransferBo =
                    InnerAccountTransferBo.builder().freezeFlag(false).industryCode(basicConfigInfo.getIndustryCode())
                            .payerAccount(payerPayInfo.getAccountNo()).payerAccountName(payerPayInfo.getAccountName())
                            .payeeAccount(payeePayInfo.getAccountNo()).payeeAccountName(payeePayInfo.getAccountName())
                            .amount(Long.valueOf(reqDTO.getPayAmt())).remark(reqDTO.getShoppingInfo()).period(basicConfigInfo.getBalancePayPeriod4Int())
                            .serverTransId(tradeContext.getServerTransId()).outsideOrderId(reqDTO.getTransNo()).build();


            logger.info("流水号:{} >> 调用内部转账[余额支付]请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(innerAccountTransferBo));
            ServerResponseDTO serverResponseDTO = accountHandler.balancePayment(innerAccountTransferBo);
            logger.info("流水号:{} << 调用内部转账[余额支付]响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(serverResponseDTO));

            if (serverResponseDTO != null && HttpRespStatus.resolve(serverResponseDTO.getStatus()).is2xxSuccessful()) {
                channelResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
                channelResponseDTO.setMessage("余额支付成功");
                respDTOBuilder.transStatus(TransStatus.TRADE_SUCCESS.name());
                respDTOBuilder.statusDesc("余额支付成功");
            } else {
                channelResponseDTO.setStatus(serverResponseDTO.getStatus());
                channelResponseDTO.setMessage(serverResponseDTO.getMessage());
                respDTOBuilder.transStatus(TransStatus.TRADE_FAILURE.name());
                respDTOBuilder.statusDesc("余额支付失败");
            }
        } catch (Exception e) {
            channelResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setMessage("余额支付异常:" + StringUtil.truncate(e.getMessage(), 200));
            channelResponseDTO.setException(StringUtil.truncate(e.getMessage(), 500));
            respDTOBuilder.transStatus(TransStatus.TRADE_FAILURE.name());
            respDTOBuilder.statusDesc("余额支付失败");
        }
        channelResponseDTO.setSpRespMsg(BeanMap.create(respDTOBuilder.build()));
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<BalancePaymentReqDTO, BalancePaymentRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        BalancePaymentReqDTO reqDTO = tradeContext.getRequestDTO();

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        BasicConfigInfo basicConfigInfo = tradeContext.getAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY);
        if (!TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getIsOpenBalancePay())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "该客户号未开通余额支付功能");
        }

        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(reqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }
        PaymentType paymentType = PaymentType.resolve(reqDTO.getType());
        if (paymentType == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款类型不合法");
        }
        ValidateUtils.maxLength(reqDTO.getPayerUserAccount(), 19, true, "付款账户");
        ValidateUtils.notSpecialStr(reqDTO.getPayerUserAccount(), true, "付款账户");
        if (paymentType == PaymentType.USER2USER) {
            ValidateUtils.maxLength(reqDTO.getPayeeUserAccount(), 19, true, "收款账户");
            ValidateUtils.notSpecialStr(reqDTO.getPayeeUserAccount(), true, "收款账户");
            Assert.isTrue(!reqDTO.getPayerUserAccount().equals(reqDTO.getPayeeUserAccount()), "收款账户不能和付款账户一致");
        }
        ValidateUtils.isPositiveInteger(reqDTO.getPayAmt(), 15, true, "交易金额");
        ValidateUtils.maxLength(reqDTO.getTransNo(), 100, true, "平台交易订单号");
        ValidateUtils.maxLength(reqDTO.getShoppingInfo(), 500, true, "商品信息");


        //交易客户端流水不能重复
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }
        boolean existSuccOrderId = transCurrentHandler.existIndustryAndSuccessOrderId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getTransNo());
        if (existSuccOrderId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "平台交易订单号已存在");
        }

        //校验单日限额
        validBalancePayLimitAmt(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getPayerUserAccount(), Long.valueOf(reqDTO.getPayAmt()), reqDTO.getReqDate());

        //付款者用户只能是 个人|企业|个体工商户
        UserPayInfo payerUserPayInfo = accountHandler.getUserPayInfo(reqDTO.getPayerUserAccount());
        if (payerUserPayInfo == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此付款者信息");
        }
        if (!basicConfigInfo.getIndustryCode().equals(payerUserPayInfo.getIndustryCode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款者不合法[不是该平台下的子账户]");
        }
        if (!(VirtualAccountType.PERSON.getType().equals(payerUserPayInfo.getNature()) ||
                VirtualAccountType.MERCHANT.getType().equals(payerUserPayInfo.getNature()) ||
                VirtualAccountType.SELFEMPLOYED.getType().equals(payerUserPayInfo.getNature()))
        ) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款人用户必须为个人|企业|个体工商户");
        }
        AccountStatus payerAccStatus = AccountStatus.getEnum(Integer.valueOf(payerUserPayInfo.getStatus()));
        if (payerAccStatus != AccountStatus.OPEN_BIND) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款者状态[" + payerAccStatus.getValue() + "]不可用");
        }

        //企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(payerUserPayInfo.getNature())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(payerUserPayInfo.getAuthStatus());
            if (MerAuthStatus.NORMAL != merAuthStatus) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款者审核状态[" + merAuthStatus.getValue() + "]不可用");
            }
        }
        CommonPayInfo payeePayInfo = null;
        if (paymentType == PaymentType.USER2USER) {
            UserPayInfo payeeUserPayInfo = accountHandler.getUserPayInfo(reqDTO.getPayeeUserAccount());
            if (payeeUserPayInfo == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此收款者信息");
            }
            if (!basicConfigInfo.getIndustryCode().equals(payeeUserPayInfo.getIndustryCode())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "收款款者不合法[不是该平台下的子账户]");
            }
            if (!(VirtualAccountType.PERSON.getType().equals(payeeUserPayInfo.getNature()) ||
                    VirtualAccountType.MERCHANT.getType().equals(payeeUserPayInfo.getNature()) ||
                    VirtualAccountType.SELFEMPLOYED.getType().equals(payeeUserPayInfo.getNature()))
            ) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "收款者用户必须为个人|企业|个体工商户");
            }
            AccountStatus payeeAccStatus = AccountStatus.getEnum(Integer.valueOf(payeeUserPayInfo.getStatus()));
            if (payeeAccStatus == AccountStatus.CANCEL) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "收款者状态[" + payeeAccStatus.getValue() + "]不可用");
            }
            //企业用户只有审核通过才可能出入金
            if (VirtualAccountType.MERCHANT.getType().equals(payeeUserPayInfo.getNature())) {
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(payeeUserPayInfo.getAuthStatus());
                if (MerAuthStatus.NORMAL != merAuthStatus) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "收款者审核状态[" + merAuthStatus.getValue() + "]不可用");
                }
            }
            payeePayInfo = CommonPayInfo.build(payeeUserPayInfo);
        } else if (paymentType == PaymentType.USER2INDUSTRY) {
            if (!VirtualAccountType.INDUSTRY.getType().equals(basicConfigInfo.getIndustryType())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求客户必须为平台账户类型");
            }//收款者账户 赋值为 平台虚账户
            reqDTO.setPayeeUserAccount(basicConfigInfo.getIndustryAccount());
            IndustryPayInfo payeeIndustryPayInfo = accountHandler.getIndustryPayInfo(basicConfigInfo.getIndustryCode());
            if (payeeIndustryPayInfo == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此客户关联实体账户信息");
            }
            payeePayInfo = CommonPayInfo.build(payeeIndustryPayInfo);
        } else {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "暂未支持的余额支付类型" + paymentType.info());
        }

        //获取渠道配置信息
        ChannelInfoBO channelInfoBO = channelRelevantHandler.findChannelInfoBO(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), null);
        if (channelInfoBO == null || StringUtil.isBlank(channelInfoBO.getChannelCode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "平台未配置渠道!");
        }
        tradeContext.setAttribute(CHANNEL_INFO_BO_KEY, channelInfoBO);
        tradeContext.setAttribute(PAYER_PAYINFO, CommonPayInfo.build(payerUserPayInfo));
        tradeContext.setAttribute(PAYEE_PAYINFO, payeePayInfo);


    }


    @Override
    public void initTransFlow(TradeContext<BalancePaymentReqDTO, BalancePaymentRespDTO> tradeContext) {
        BalancePaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        CommonPayInfo payerPayInfo = tradeContext.getAttribute(PAYER_PAYINFO);
        CommonPayInfo payeePayInfo = tradeContext.getAttribute(PAYEE_PAYINFO);

        FeeInfoBO feeInfoBO = FeeInfoBO.buildNoConfigFeeInfoBO(Long.valueOf(reqDTO.getPayAmt()));


        List<TransCurrent> transCurrentList = Lists.newArrayList();
        TransCurrent transCurrent = TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(channelInfoBO.getChannelKey())
                .channelCode(channelInfoBO.getChannelCode())
                .channelName(channelInfoBO.getChannelName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(tradeContext.getTransDate() + tradeContext.getTransTime())
                .currency("CNY")
                .orgCode(basicConfigInfo.getOrgCode())
                .orgName(basicConfigInfo.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.BALANCE_PAYMENT.getCode())
                .transAmount(Long.valueOf(reqDTO.getPayAmt()))
                .transCallbackUrl(null)
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(basicConfigInfo.getIndustryAccount())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(PaymentType.USER2USER.getType().equals(reqDTO.getType()) ? AccountType.PRIVATE.getCode() : AccountType.PUBLIC.getCode())
                .payerAcctNo(payerPayInfo.getBankAccountNo())
                .payerName(payerPayInfo.getBankAccountName())
                .payeeAcctNo(payeePayInfo.getBankAccountNo())
                .payeeName(payeePayInfo.getBankAccountName())
                .industryCode(basicConfigInfo.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .payerAccount(payerPayInfo.getAccountNo())
                .payeeAccount(payeePayInfo.getAccountNo())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(payerPayInfo.getAccountNo())
                .showPayerAccountName(payerPayInfo.getAccountName())
                .showPayeeAccountNo(payeePayInfo.getAccountNo())
                .showPayeeAccountName(payeePayInfo.getAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .orderId(reqDTO.getTransNo())
                .summaryDescription(reqDTO.getShoppingInfo())
                .paymentPeriod(basicConfigInfo.getBalancePayPeriod4Int())
                .paymentType(reqDTO.getType())
                .paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_UNDO)
                .reconcileDate(DateUtil.plusDate(reqDTO.getReqDate(), DateTimeFormatter.BASIC_ISO_DATE, basicConfigInfo.getBalancePayPeriod4Int()))
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    @Override
    public void updateTransFlow(TradeContext<BalancePaymentReqDTO, BalancePaymentRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        BalancePaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        BalancePaymentRespDTO respDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        if (HttpRespStatus.resolve(channelResponse.getStatus()).is2xxSuccessful()) {
            transStatus = TransStatus.TRADE_SUCCESS.name();
            if ("0".equals(String.valueOf(basicConfigInfo.getBalancePayPeriod4Int()))) {
                builder.paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_OK);
            }
        }
        builder.industryCode(basicConfigInfo.getIndustryCode());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (respDTO != null) {
            builder.respCode(respDTO.getStatus()).respException(respDTO.getException()).respMessage(respDTO.getMessage());
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());

        // 累计 交易成功交易额度
        if (TransStatus.TRADE_SUCCESS.name().equals(transStatus)) {
            accumulateBalancePayAmount(tradeContext.getIndustryCode(), reqDTO.getPayerUserAccount(), Long.valueOf(reqDTO.getPayAmt()), reqDTO.getReqDate());
        }
    }

    @Async
    public void accumulateBalancePayAmount(String industryCode, String payerUserAccount, Long transAmount, String tradeDate) {
        try {
            industryHandler.accumulateBalancePayAmount(industryCode, payerUserAccount, transAmount, tradeDate);
        } catch (Exception e) {
           logger.error("余额支付单日累计交易额异常：{}",e.getMessage(),e);
        }
    }

    /**
     * 验证客户号&子账户限额
     **/
    private void validBalancePayLimitAmt(String industryCode, String payerUserAccount, Long transAmount, String tradeDate) {
        try {
            industryHandler.validBalancePayLimitAmt(industryCode, payerUserAccount, transAmount, tradeDate);
        } catch (Exception e) {
            logger.error("余额支付单日限额校验异常:{}", e.getMessage(), e);
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "余额支付单日限额校验失败:" + e.getMessage());
        }
    }

    @Override
    public void insertTransParamFail(TradeContext<BalancePaymentReqDTO, BalancePaymentRespDTO> tradeContext, Exception e) {
        BalancePaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            basicConfigInfo = new BasicConfigInfo();
            basicConfigInfo.setIndustryCode(tradeContext.getIndustryCode());
        }

        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        if (channelInfoBO == null) {
            channelInfoBO = new ChannelInfoBO();
        }

        CommonPayInfo payerPayInfo = tradeContext.getAttribute(PAYER_PAYINFO);
        if (payerPayInfo == null) {
            payerPayInfo = new CommonPayInfo();
        }
        CommonPayInfo payeePayInfo = tradeContext.getAttribute(PAYEE_PAYINFO);
        if (payeePayInfo == null) {
            payeePayInfo = new CommonPayInfo();
        }
        long transAmount ;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }
        FeeInfoBO feeInfoBO = FeeInfoBO.buildNoConfigFeeInfoBO(transAmount);

        TransParamFailVo paramFailVo = TransParamFailVo.builder()
                .id(IdGenerate.getId())
                .channelKey(channelInfoBO.getChannelKey())
                .channelCode(channelInfoBO.getChannelCode())
                .channelName(channelInfoBO.getChannelName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(tradeContext.getTransDate() + tradeContext.getTransTime())
                .currency("CNY")
                .orgCode(basicConfigInfo.getOrgCode())
                .orgName(basicConfigInfo.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.BALANCE_PAYMENT.getCode())
                .transAmount(transAmount)
                .transCallbackUrl(null)
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(basicConfigInfo.getIndustryAccount())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(PaymentType.USER2USER.getType().equals(reqDTO.getType()) ? AccountType.PRIVATE.getCode() : AccountType.PUBLIC.getCode())
                .payerAcctNo(payerPayInfo.getBankAccountNo())
                .payerName(payerPayInfo.getBankAccountName())
                .payeeAcctNo(payeePayInfo.getBankAccountNo())
                .payeeName(payeePayInfo.getBankAccountName())
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
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .payerAccount(payerPayInfo.getAccountNo())
                .payeeAccount(payeePayInfo.getAccountNo())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(payerPayInfo.getAccountNo())
                .showPayerAccountName(payerPayInfo.getAccountName())
                .showPayeeAccountNo(payeePayInfo.getAccountNo())
                .showPayeeAccountName(payeePayInfo.getAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .orderId(reqDTO.getTransNo())
                .summaryDescription(reqDTO.getShoppingInfo())
                .paymentPeriod(basicConfigInfo.getBalancePayPeriod4Int())
                .paymentType(reqDTO.getType())
                .paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_UNDO)
                .reconcileDate(DateUtil.plusDate(reqDTO.getReqDate(), DateTimeFormatter.BASIC_ISO_DATE, basicConfigInfo.getBalancePayPeriod4Int()))
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
