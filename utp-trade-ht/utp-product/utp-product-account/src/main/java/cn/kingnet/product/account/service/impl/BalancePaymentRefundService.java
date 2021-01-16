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
import cn.kingnet.utp.trade.common.bo.InnerAccountTransferBo;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.BalancePaymentRefundReqDTO;
import cn.kingnet.utp.trade.common.dto.account.BalancePaymentRefundRespDTO;
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

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description 余额支付退款退款 接口
 * @Author WJH
 * @Date 2020/03/10
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.BALANCE_PAYMENT_REFUND,
        reqClass = BalancePaymentRefundReqDTO.class,
        respClass = BalancePaymentRefundRespDTO.class,
        createTransFlow = true,
        successTransStatus = TransStatus.PROCESSING
)
public class BalancePaymentRefundService extends AbstractAccountTradeService<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected IChannelRelevantHandler channelRelevantHandler;
    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;
    @Resource
    protected IIndustryHandler industryHandler;

    protected static final String ORIG_TRANS_CURRENT = "ORIG_TRANS_CURRENT";
    protected static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";

    public BalancePaymentRefundService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        BalancePaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        ChannelResponseDTO channelResponseDTO = new ChannelResponseDTO(tradeContext.getServerTransId());
        BalancePaymentRefundRespDTO.BalancePaymentRefundRespDTOBuilder respDTOBuilder = BalancePaymentRefundRespDTO.builder();
        respDTOBuilder.reconcileDate(tradeContext.getTransDate());
        try {
            TransCurrent origTransCurrent = tradeContext.getAttribute(ORIG_TRANS_CURRENT);
            InnerAccountTransferBo innerAccountTransferBo =
                    InnerAccountTransferBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                            .payerAccount(origTransCurrent.getPayeeAccount()).payerAccountName(origTransCurrent.getPayeeName())
                            .payeeAccount(origTransCurrent.getPayerAccount()).payeeAccountName(origTransCurrent.getPayerName())
                            .amount(Long.valueOf(reqDTO.getPayAmt())).remark(origTransCurrent.getSummaryDescription() + ":退款")
                            .serverTransId(tradeContext.getServerTransId()).outsideOrderId(origTransCurrent.getServerTransId())
                            .transId(origTransCurrent.getId()).historyStatus("1".equals(origTransCurrent.getHistoryStatus()))
                            .paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_OK.equals(origTransCurrent.getPaymentSettleStatus()))
                            .build();

            logger.info("流水号:{} >> 调用内部转账[余额支付退款]请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(innerAccountTransferBo));
            ServerResponseDTO serverResponseDTO = accountHandler.balancePaymentRefund(innerAccountTransferBo);
            logger.info("流水号:{} << 调用内部转账[余额支付退款]响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(serverResponseDTO));

            if (serverResponseDTO != null && HttpRespStatus.resolve(serverResponseDTO.getStatus()).is2xxSuccessful()) {
                channelResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
                channelResponseDTO.setMessage("余额支付退款成功");
                respDTOBuilder.transStatus(TransStatus.TRADE_SUCCESS.name());
                respDTOBuilder.statusDesc("余额支付退款成功");
            } else {
                channelResponseDTO.setStatus(serverResponseDTO.getStatus());
                channelResponseDTO.setMessage(serverResponseDTO.getMessage());
                respDTOBuilder.transStatus(TransStatus.TRADE_FAILURE.name());
                respDTOBuilder.statusDesc("余额支付退款失败");
            }
        } catch (Exception e) {
            channelResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setMessage("余额支付退款异常:" + StringUtil.truncate(e.getMessage(), 200));
            channelResponseDTO.setException(StringUtil.truncate(e.getMessage(), 500));
            respDTOBuilder.transStatus(TransStatus.TRADE_FAILURE.name());
            respDTOBuilder.statusDesc("余额支付退款失败");
        }
        channelResponseDTO.setSpRespMsg(BeanMap.create(respDTOBuilder.build()));
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        BalancePaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        BasicConfigInfo basicConfigInfo = tradeContext.getAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY);
        if(!TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getIsOpenBalancePay())){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"该客户号未开通余额支付退款功能");
        }
        ValidateUtils.isPositiveInteger(reqDTO.getPayAmt(), 15, true, "交易金额");
        if (StringUtil.isBlank(reqDTO.getOrigClientTradeId()) && StringUtil.isBlank(reqDTO.getOrigServerTradeId())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "参数OrigClientTradeId|OrigServerTradeId 不能同时为空");
        }
        ValidateUtils.abcValid(reqDTO.getOrigClientTradeId(), 32, false, "origClientTradeId");
        ValidateUtils.abcValid(reqDTO.getOrigServerTradeId(), 36, false, "OrigServerTradeId");

        //查询交易
        TransCurrent transCurrent = transCurrentHandler.getByIndustryAndClientTransIdOrServerTransId(tradeContext.getIndustryCode(), reqDTO.getOrigClientTradeId(), reqDTO.getOrigServerTradeId());
        tradeContext.setAttribute(ORIG_TRANS_CURRENT, transCurrent);
        if (transCurrent == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此交易流水记录");
        }
        if (!TradeType.BALANCE_PAYMENT.toString().equals(transCurrent.getTradeType()) || !TransStatus.TRADE_SUCCESS.toString().equals(transCurrent.getTransStatus())
        ) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "原交易流水非余额支付退款或交易状态不成功,无法余额支付退款退款");
        }
        if (Long.valueOf(reqDTO.getPayAmt()).longValue() != transCurrent.getTransAmount()) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "退款金额与原交易金额不匹配，暂无法余额支付退款退款");
        }
        if (CommonConstants.REFUND_STATUS_OK.equals(transCurrent.getRefundStatus())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "已全额退款，无法再退款");
        }

        //余额支付类型：0-用户-客户平台 1-用户-用户
        String paymentType = transCurrent.getPaymentType();
        MerchantInfoBo origPayerMerInfo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(transCurrent.getPayerAccount(),false);
        AccountStatus origPayerAccStatus = AccountStatus.getEnum(Integer.parseInt(origPayerMerInfo.getStatus()));
        if(origPayerAccStatus==null || !origPayerAccStatus.ableHandleCashStatus()){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,String.format("原转出账户状态[%s]，暂不支持余额支付退款",origPayerAccStatus==null?null:origPayerAccStatus.getValue()));
        }
        //企业用户只有审核通过才可能出入金
        if(VirtualAccountType.MERCHANT.getType().equals(origPayerMerInfo.getNature())){
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(origPayerMerInfo.getAuthStatus());
            if(MerAuthStatus.NORMAL != merAuthStatus){
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "企业账户审核状态[" + merAuthStatus.getValue() + "]不可用");
            }
        }

        if(PaymentType.USER2USER.getType().equals(paymentType)){
            MerchantInfoBo origPayeeMerInfo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(transCurrent.getPayeeAccount(),false);
            AccountStatus origPayeeAccStatus = AccountStatus.getEnum(Integer.parseInt(origPayeeMerInfo.getStatus()));
            if(origPayeeAccStatus==null || !origPayeeAccStatus.ableHandleCashStatus()){
                throw new TradeException(HttpRespStatus.BAD_REQUEST,String.format("原转入账户状态[%s]，暂不支持余额支付退款",origPayeeAccStatus==null?null:origPayeeAccStatus.getValue()));
            }
            //企业用户只有审核通过才可能出入金
            if(VirtualAccountType.MERCHANT.getType().equals(origPayeeMerInfo.getNature())){
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(origPayeeMerInfo.getAuthStatus());
                if(MerAuthStatus.NORMAL != merAuthStatus){
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "企业账户审核状态[" + merAuthStatus.getValue() + "]不可用");
                }
            }
        }

        //获取渠道配置信息
        ChannelInfoBO channelInfoBO = channelRelevantHandler.findChannelInfoBO(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), null);
        if (channelInfoBO == null || StringUtil.isBlank(channelInfoBO.getChannelCode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "平台未配置渠道!");
        }
        tradeContext.setAttribute(CHANNEL_INFO_BO_KEY, channelInfoBO);
        tradeContext.setAttribute(ORIG_TRANS_CURRENT, transCurrent);

    }

    @Override
    public void initTransFlow(TradeContext<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> tradeContext) {
        BalancePaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        TransCurrent origTransCurrent = tradeContext.getAttribute(ORIG_TRANS_CURRENT);

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
                .serverLinkId(origTransCurrent.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.BALANCE_PAYMENT_REFUND.name())
                .transAmount(origTransCurrent.getTransAmount())
                .transCallbackUrl(null)
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(basicConfigInfo.getIndustryAccount())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(origTransCurrent.getPcFlag())
                .payerAcctNo(origTransCurrent.getPayeeAcctNo())
                .payerName(origTransCurrent.getPayeeName())
                .payeeAcctNo(origTransCurrent.getPayerAcctNo())
                .payeeName(origTransCurrent.getPayerName())
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
                .payerAccount(origTransCurrent.getPayeeAccount())
                .payeeAccount(origTransCurrent.getPayerAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(origTransCurrent.getShowPayeeAccountNo())
                .showPayerAccountName(origTransCurrent.getShowPayeeAccountName())
                .showPayeeAccountNo(origTransCurrent.getShowPayerAccountNo())
                .showPayeeAccountName(origTransCurrent.getShowPayerAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(origTransCurrent.getPayeeOpbkName())
                .payeeOpbkName(origTransCurrent.getPayerOpbkName())
                .orderId(origTransCurrent.getOrderId())
                .summaryDescription(origTransCurrent.getSummaryDescription())
                .paymentPeriod(origTransCurrent.getPaymentPeriod())
                .paymentType(origTransCurrent.getPaymentType())
                .paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_UNDO)
                .reconcileDate(tradeContext.getTransDate())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    @Override
    public void updateTransFlow(TradeContext<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BalancePaymentRefundRespDTO respDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        if (HttpRespStatus.resolve(channelResponse.getStatus()).is2xxSuccessful()) {
            transStatus = TransStatus.TRADE_SUCCESS.name();
            builder.paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_OK);
        }
        builder.industryCode(tradeContext.getIndustryCode());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (respDTO != null) {
            builder.respCode(respDTO.getStatus())
                    .respException(respDTO.getException())
                    .respMessage(respDTO.getMessage());
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), tradeContext.getIndustryCode(), tradeContext.getServerTransId());
    }

    @Override
    public void insertTransParamFail(TradeContext<BalancePaymentRefundReqDTO, BalancePaymentRefundRespDTO> tradeContext, Exception e) {
        BalancePaymentRefundReqDTO reqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);

        if (basicConfigInfo == null) {
            basicConfigInfo = new BasicConfigInfo();
            basicConfigInfo.setIndustryCode(tradeContext.getIndustryCode());
        }

        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        if (channelInfoBO == null) {
            channelInfoBO = new ChannelInfoBO();
        }

        long transAmount ;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }

        TransCurrent origTransCurrent = tradeContext.getAttribute(ORIG_TRANS_CURRENT);
        if (origTransCurrent == null) {
            origTransCurrent = new TransCurrent();
            origTransCurrent.setTransAmount(transAmount);
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
                .serverLinkId(origTransCurrent.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.BALANCE_PAYMENT_REFUND.name())
                .transAmount(origTransCurrent.getTransAmount())
                .transCallbackUrl(null)
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(basicConfigInfo.getIndustryAccount())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(origTransCurrent.getPcFlag())
                .payerAcctNo(origTransCurrent.getPayeeAcctNo())
                .payerName(origTransCurrent.getPayeeName())
                .payeeAcctNo(origTransCurrent.getPayerAcctNo())
                .payeeName(origTransCurrent.getPayerName())
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
                .payerAccount(origTransCurrent.getPayeeAccount())
                .payeeAccount(origTransCurrent.getPayerAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(origTransCurrent.getShowPayeeAccountNo())
                .showPayerAccountName(origTransCurrent.getShowPayeeAccountName())
                .showPayeeAccountNo(origTransCurrent.getShowPayerAccountNo())
                .showPayeeAccountName(origTransCurrent.getShowPayerAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(origTransCurrent.getPayeeOpbkName())
                .payeeOpbkName(origTransCurrent.getPayerOpbkName())
                .orderId(origTransCurrent.getOrderId())
                .summaryDescription(origTransCurrent.getSummaryDescription())
                .paymentPeriod(origTransCurrent.getPaymentPeriod())
                .paymentType(origTransCurrent.getPaymentType())
                .paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_UNDO)
                .reconcileDate(tradeContext.getTransDate())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
