package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.CardBinInfo;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.TransferSinglerPayReqDTO;
import cn.kingnet.utp.trade.common.dto.account.TransferSinglerPayRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 单笔实时代付
 *
 * @author zhongli
 * @date 2019-03-11
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.SGL_PAYMENT,
        reqClass = TransferSinglerPayReqDTO.class,
        respClass = TransferSinglerPayRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.PROCESSING
)
@Slf4j
public class TransferSinglePayService extends AbstractAccountTradeService<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> {

    @Resource
    protected IPaymentService paymentService;
    @Resource
    protected IAccountHandler accountHandler;
    @Resource
    protected IFeeHandler feeHandler;
    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected IChannelRelevantHandler channelRelevantHandler;
    @Resource
    protected ITransHistoryHandler transHistoryHandler;
    @Resource
    private ICardBinHandler cardBinHandler;
    @Resource
    protected IIndustryHandler industryHandler;
    @Resource
    IClearBankCodeHandler clearBankCodeHandler;

    protected static final String PAYEE_ACC_TYPE = "PAYEE_ACC_TYPE";
    protected static final String PAYER_FUNDACC_TYPE = "PAYER_FUNDACC_TYPE";
    protected static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";
    protected static final String SHOW_PAYER_ACC_NO = "SHOW_PAYER_ACC_NO";
    protected static final String SHOW_PAYER_ACC_NAME = "SHOW_PAYER_ACC_NAME";

    public TransferSinglePayService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "查无此代付客户平台,不能转账!");
        }

        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();

        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }

        //调用渠道转账
        TransferSinglerPayReqDTO transferReqDTO = tradeContext.getRequestDTO();
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(transferReqDTO.getReqDate());
        oneBankTransferReq.setTradeTime(transferReqDTO.getReqTime());
        oneBankTransferReq.setAcctNo(basicConfigInfo.getCustAccountNo());
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());

        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        //请求日期
        oneBankTransferReqContent.setReqDate(transferReqDTO.getReqDate());
        //请求时间
        oneBankTransferReqContent.setReqTime(transferReqDTO.getReqTime());
        //卡类型
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //收款人账号
        oneBankTransferReqContent.setPayeeAcctNo(transferReqDTO.getAcctNo());
        //收款人名称
        oneBankTransferReqContent.setPayeeName(transferReqDTO.getAccName());
        //收款人清算行行号
        oneBankTransferReqContent.setPayeeOpbk(transferReqDTO.getClBankCode());
        //收款人开户行号
        oneBankTransferReqContent.setPayeeSubBank(transferReqDTO.getOpBankCode());

        //真实付款账户，注：华通那边反过来用 行内业务要求显示付款账户、真实付款账户都必须是真实账户，故都取值实体账户
        String realPayerAcctNo = basicConfigInfo.getCustAccountNo();
        String realPayerName = basicConfigInfo.getCustAccountName();
        String showPayerAcctNo = tradeContext.getAttribute(SHOW_PAYER_ACC_NO);
        String showPayerName = tradeContext.getAttribute(SHOW_PAYER_ACC_NAME);

        //账户类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());
        //实际付款人账号及名称
        oneBankTransferReqContent.setRealpayerAcctNo(realPayerAcctNo);
        oneBankTransferReqContent.setRealpayerName(realPayerName);
        //显示付款人账号及名称
        oneBankTransferReqContent.setPayerAcctNo(showPayerAcctNo);
        oneBankTransferReqContent.setPayerName(showPayerName);
        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //付款人开户行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());
        //备注附言
        oneBankTransferReqContent.setRemark(transferReqDTO.getRemark());

        FeeInfoBO feeInfoBO = tradeContext.getAttribute("indFee");
        Long indFee = feeInfoBO.getRealAmount();
        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(indFee.longValue());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        //交易金额
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        //冻结金额
        this.freezeMethod(tradeContext, basicConfigInfo, transferReqDTO, feeInfoBO);
        try {
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = channelTradeService(oneBankTransferReq, oneBankTransferReqContent, tradeContext);
            } catch (RetryableException e) {
                logger.error("流水号:{} >> 调用转账渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
                channelResponseDTO = new ChannelResponseDTO();
                channelResponseDTO.setServerTransId(tradeContext.getServerTransId());
                channelResponseDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
                channelResponseDTO.setMessage("渠道超时或其他错误,状态未知。");
                channelResponseDTO.setException(e.getMessage());
                return channelResponseDTO;
            }
            try {
                if (channelResponseDTO != null) {
                    HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(channelResponseDTO.getStatus()));
                    if (!(httpRespStatus.is2xxSuccessful() || httpRespStatus.is3xxRedirection())) {
                        this.unfreezeMethod(basicConfigInfo, tradeContext, feeInfoBO);
                    }
                }
            } catch (Exception e) {
                logger.error("流水号:{} >> 渠道返回[httpRespStatus={}],恢复单笔实时代付冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.unfreezeMethod(basicConfigInfo, tradeContext, feeInfoBO);
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复单笔实时代付冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }

    /**
     * 冻结实时代付金额以及手续费
     */
    private void freezeMethod(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext, BasicConfigInfo basicConfigInfo, TransferSinglerPayReqDTO transferReqDTO, FeeInfoBO feeInfoBO) {
        //冻结平台账户金额
        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getIndustryAccount()).amount(feeInfoBO.getRealAmount())
                .peerAccNo(transferReqDTO.getAcctNo()).peerAccName(transferReqDTO.getAccName())
                .serverTransId(tradeContext.getServerTransId()).remark("冻结单笔实时代付金额")
                .build());
        try {
            //冻结手续费金额
            if (!isMerFeeZero(feeInfoBO.getMerFee())) {
                SettleType settleType = SettleType.resolve(feeInfoBO.getMerSettleType());
                ChargeMode chargeMode = ChargeMode.resolve(feeInfoBO.getMerChargeMode());
                if (SettleType.REAL_TIME == settleType && ChargeMode.INNER == chargeMode) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getIndustryAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结单笔实时代付手续费")
                            .build());
                } else if (SettleType.REAL_TIME == settleType && ChargeMode.BUCKLE == chargeMode) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结单笔实时代付手续费")
                            .build());
                }
            }
        } catch (Exception e) {
            try {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                        .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getIndustryAccount()).amount(feeInfoBO.getRealAmount())
                        .peerAccNo(transferReqDTO.getAcctNo()).peerAccName(transferReqDTO.getAccName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复单笔实时代付冻结金额")
                        .build());
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复单笔实时代付冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            logger.error("流水号:{} >> 交易异常:{} {} 冻结单笔实时代付手续费异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, e.getMessage(), e);
            throw e;
        }
    }

    private ChannelResponseDTO channelTradeService(OneBankTransferReq oneBankTransferReq, OneBankTransferReqContent oneBankTransferReqContent, TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext) {

        FundAccType payerFundAccType = tradeContext.getAttribute(PAYER_FUNDACC_TYPE);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        //接口路由选择
        if (ChannelKey.HT_CUC.getKey().equals(channelInfoBO.getChannelKey())
                || ChannelKey.HT_POST_CUC.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.UTP_DESIGNATED.getFlag());
            oneBankTransferReqContent.setPayRouteCode(HTPayRouteCode.CUC.name());
        } else if (ChannelKey.HT_CKEY.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.HT_ROUTE.getFlag());
            oneBankTransferReqContent.setPayRouteCode(null);
        } else if (ChannelKey.HT_SIB.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.UTP_DESIGNATED.getFlag());
            oneBankTransferReqContent.setPayRouteCode(HTPayRouteCode.SIB.name());
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s渠道暂未支持", channelInfoBO.getChannelKey()));
        }
        oneBankTransferReq.setChannelKey(channelInfoBO.getChannelKey());
        oneBankTransferReqContent.setMerID(channelInfoBO.getChannelMerNo());
        oneBankTransferReqContent.setMerName(channelInfoBO.getChannelMerName());
        oneBankTransferReqContent.setMerAbbr(channelInfoBO.getChannelMerShortName());
        oneBankTransferReqContent.setMerCatCode(channelInfoBO.getChannelMerCategory());
        oneBankTransferReqContent.setSourcesOfFunds(channelInfoBO.getChannelCapitalSource());
        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        oneBankTransferReqContent.setPc_flag(AccountType2HtPcFlag.getHTPcFlag(payeeAccType).getFlag());
        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            oneBankTransferReq.setFundAccType(payerFundAccType);
            oneBankTransferReq.setContent(oneBankTransferReqContent);
            logger.info("流水号:{} >> 调用RDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePivate(oneBankTransferReq);
            logger.info("流水号:{} << 调用RDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            oneBankTransferReq.setFundAccType(payerFundAccType);
            oneBankTransferReq.setContent(oneBankTransferReqContent);
            logger.info("流水号:{} >> 调用CDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePublic(oneBankTransferReq);
            logger.info("流水号:{} << 调用CDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", channelInfoBO.getChannelKey()));
        }


    }

    /**
     * 恢复解冻金额
     */
    private void unfreezeMethod(BasicConfigInfo basicConfigInfo, TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext, FeeInfoBO feeInfoBO) {
        SettleType settleType = SettleType.resolve(feeInfoBO.getMerSettleType());
        ChargeMode chargeMode = ChargeMode.resolve(feeInfoBO.getMerChargeMode());
        TransferSinglerPayReqDTO reqDTO = tradeContext.getRequestDTO();
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getIndustryAccount()).amount(feeInfoBO.getRealAmount())
                .peerAccNo(reqDTO.getAcctNo()).peerAccName(reqDTO.getAccName())
                .serverTransId(tradeContext.getServerTransId()).remark("恢复单笔实时代付冻结金额")
                .build());
        if (!isMerFeeZero(feeInfoBO.getMerFee())) {
            if (SettleType.REAL_TIME == settleType && ChargeMode.INNER == chargeMode) {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getIndustryAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复单笔实时代付冻结手续费")
                        .build());
            } else if (SettleType.REAL_TIME == settleType && ChargeMode.BUCKLE == chargeMode) {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复单笔实时代付冻结手续费")
                        .build());
            }
        }
    }


    @Override
    public void initTransFlow(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        TransferSinglerPayReqDTO reqDTO = tradeContext.getRequestDTO();

        //获取渠道配置信息
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        //获取渠道配置信息
        if (channelInfoBO == null || StringUtil.isBlank(channelInfoBO.getChannelCode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "未配置渠道!");
        }

        Long feeTid = channelInfoBO.getIndFeeTemplateId();
        FeeInfoBO feeInfoBO = feeHandler.calculateFeeByIndustry(feeTid, channelInfoBO.getChnFeeTemplateId(), Long.valueOf(reqDTO.getPayAmt()));
        tradeContext.setAttribute("indFee", feeInfoBO);

        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);

        String showPayerAccNo = basicConfigInfo.getCustAccountNo();
        String showPayerAccName = basicConfigInfo.getCustAccountName();

        if(basicConfigInfo.getOpenShowCustomFlag()==1){
            //根据客户号“是否支持自定义显示付款账号及户名”来处理：标志为“是”时，按照现有逻辑处理。

            if (StringUtil.isNotBlank(reqDTO.getShowPayerAcctNo()) && StringUtil.isNotBlank(reqDTO.getShowPayerName())) {
                showPayerAccNo = reqDTO.getShowPayerAcctNo();
                showPayerAccName = reqDTO.getShowPayerName();
            }
        }
        tradeContext.setAttribute(SHOW_PAYER_ACC_NO, showPayerAccNo);
        tradeContext.setAttribute(SHOW_PAYER_ACC_NAME, showPayerAccName);

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
                .tradeType(TradeType.SGL_PAYMENT.getCode())
                .transAmount(feeInfoBO.getTransAmount())
                .transCallbackUrl(reqDTO.getCallbackUrl())
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(null)
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(payeeAccType.getCode())
                .payerAcctNo(basicConfigInfo.getCustAccountNo())
                .payerName(basicConfigInfo.getCustAccountName())
                .payeeAcctNo(reqDTO.getAcctNo())
                .payeeName(reqDTO.getAccName())
                .industryCode(basicConfigInfo.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .payerOpbkName(CommonConstants.payerOpbkName)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .payerAccount(basicConfigInfo.getIndustryAccount())
                .payeeAccount(null)
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccNo)
                .showPayerAccountName(showPayerAccName)
                .showPayeeAccountNo(reqDTO.getAcctNo())
                .showPayeeAccountName(reqDTO.getAccName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(reqDTO.getOpBankName())
                .summaryDescription(reqDTO.getRemark())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    @Override
    public void updateTransFlow(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        TransferSinglerPayRespDTO transferRespDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.industryCode(basicConfigInfo.getIndustryCode());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (transferRespDTO != null) {
            builder.respCode(transferRespDTO.getStatus())
                    .respException(transferRespDTO.getException())
                    .respMessage(transferRespDTO.getMessage());
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());
    }

    @Override
    protected void verifyReqParam(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        TransferSinglerPayReqDTO transferReqDTO = tradeContext.getRequestDTO();

        ValidateUtils.isYyyyMMdd(transferReqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(transferReqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(transferReqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }

        ValidateUtils.notSpecialStr(transferReqDTO.getShowPayerAcctNo(), false, "显示付款账号");
        ValidateUtils.maxLength(transferReqDTO.getShowPayerAcctNo(), 32, false, "显示付款账号");
        ValidateUtils.notSpecialStrExcludeParenthesis(transferReqDTO.getShowPayerName(), false, "显示付款户名");
        ValidateUtils.maxLength(transferReqDTO.getShowPayerName(), 60, false, "显示付款户名");
        ValidateUtils.notSpecialStr(transferReqDTO.getAcctNo(), true, "收款账户");
        ValidateUtils.maxLength(transferReqDTO.getAcctNo(), 32, true, "收款账户");
        ValidateUtils.notSpecialStrExcludeParenthesis(transferReqDTO.getAccName(), true, "收款账户名称");
        ValidateUtils.maxLength(transferReqDTO.getAccName(), 100, true, "收款账户名称");

        ValidateUtils.maxLength(transferReqDTO.getAcctType(), 1, true, "acctType");
        if (AccountType.getAccountTypeByOuterValue(transferReqDTO.getAcctType()) == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "账户类型[acctType]取值不正确");
        }
        if (AccountType.PUBLIC.getValue().equals(transferReqDTO.getAcctType())) {
            if (StringUtil.isNoneBlank(transferReqDTO.getClBankCode())) {
                ValidateUtils.notSpecialStr(transferReqDTO.getClBankCode(), true, "清算行号");
                ValidateUtils.maxLength(transferReqDTO.getClBankCode(), 20, true, "清算行号");
            }
        } else {
            ValidateUtils.maxLength(transferReqDTO.getIdType(), 3, true, "证件类型");
            IdType idType = IdType.getEnum(transferReqDTO.getIdType());
            ValidateUtils.notNull(idType, "证件类型不支持");
            ValidateUtils.maxLength(transferReqDTO.getIdCode(), 32, true, "证件号");
        }
        if (AccountType.BILLING_CARD.getValue().equals(transferReqDTO.getAcctType())) {
            ValidateUtils.maxLength(transferReqDTO.getBusinessLicenseCode(), 32, true, "营业执照号");
        }
        /**按第9次需求调整，对私开户行信息不上送由卡BIN获取*/
        if (AccountType.PRIVATE.getValue().equals(transferReqDTO.getAcctType())) {
            CardBinInfo cardBinInfo = cardBinHandler.getCardBinInfo(transferReqDTO.getAcctNo());
            if (cardBinInfo == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]的卡BIN信息", transferReqDTO.getAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getClearbankno())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的清算行号", transferReqDTO.getAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getBankcode())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行号", transferReqDTO.getAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getBankname())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行名", transferReqDTO.getAcctNo()));
            }
            transferReqDTO.setClBankCode(cardBinInfo.getClearbankno());
            transferReqDTO.setOpBankCode(cardBinInfo.getBankcode());
            transferReqDTO.setOpBankName(cardBinInfo.getBankname());
        } else {
            ValidateUtils.notSpecialStr(transferReqDTO.getOpBankCode(), true, "开户行号");
            ValidateUtils.maxLength(transferReqDTO.getOpBankCode(), 32, true, "开户行号");
            ValidateUtils.notSpecialStr(transferReqDTO.getOpBankName(), true, "开户行名称");
            ValidateUtils.maxLength(transferReqDTO.getOpBankName(), 100, true, "开户行名称");
            //校验清算行号是否正确，从清算行表 t_clear_bank_code 匹配
            String clearBankCode = clearBankCodeHandler.getClearBankCode(transferReqDTO.getOpBankCode());
            //库里找到匹配的数据
            if (StringUtil.isNoneBlank(clearBankCode)) {
                //上送的清算行号不为空，做比较
                if (StringUtil.isNoneBlank(transferReqDTO.getClBankCode())) {
                    if (!clearBankCode.equals(transferReqDTO.getClBankCode())) {
                        throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("开户行[%s]，对应的清算行号为[%s]", transferReqDTO.getOpBankCode(), clearBankCode));
                    }
                } else {
                    transferReqDTO.setClBankCode(clearBankCode);
                }
            } else {
                if (StringUtil.isBlank(transferReqDTO.getClBankCode())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "系统查无匹配的开户行");
                }
            }
        }
        ValidateUtils.maxLength(transferReqDTO.getCallbackUrl(), 200, true, "回调地址");
        String payAmt = transferReqDTO.getPayAmt();
        ValidateUtils.isIntegerNegative(payAmt, true, "交易金额");
        long payAmtLong;
        try {
            payAmtLong = Long.parseLong(payAmt);
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易金额格式不对!");
        }
        if (payAmtLong <= 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易金额须大于零的整数!");
        }
        if (payAmt.length() > 15) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易金额超出范围!");
        }

        //交易客户端流水不能重复：当天交易流水检验
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), transferReqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        FundAccType payerFundAccType = FundAccType.resolve(getBasicConfigInfo(tradeContext).getFundAccType());
        if (null == payerFundAccType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("付款方归属资金账户类型[%s]错误", getBasicConfigInfo(tradeContext).getFundAccType()));
        }
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        AccountType payeeAccType = AccountType.getAccountTypeByOuterValue(transferReqDTO.getAcctType());

        //获取渠道配置信息||实时代付仅支持 银联代付
        String trandeDateTime = transferReqDTO.getReqDate().concat(transferReqDTO.getReqTime());
        ChannelInfoBO channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), payeeAccType.getCode(), Long.parseLong(transferReqDTO.getPayAmt()), trandeDateTime);

        tradeContext.setAttribute(PAYER_FUNDACC_TYPE, payerFundAccType);
        tradeContext.setAttribute(PAYEE_ACC_TYPE, payeeAccType);
        tradeContext.setAttribute(CHANNEL_INFO_BO_KEY, channelInfoBO);

        // 验证客户号 单日|单笔限额
        industryHandler.validIndustryLimitAmt(basicConfigInfo.getIndustryCode(), payeeAccType, payAmtLong, transferReqDTO.getReqDate());
        // 校验同一平台下的同一用户连续相同提现金额次数限制 和 同一平台下每分钟累计不超过数值限制
        industryHandler.validCashMaxTranAmt(basicConfigInfo.getIndustryCode(), transferReqDTO.getAcctNo(), payAmtLong);
    }

    @Override
    public void insertTransParamFail(TradeContext<TransferSinglerPayReqDTO, TransferSinglerPayRespDTO> tradeContext, Exception e) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        TransferSinglerPayReqDTO reqDTO = tradeContext.getRequestDTO();

        //获取渠道配置信息
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        if (channelInfoBO == null) {
            channelInfoBO = new ChannelInfoBO();
        }

        long transAmount;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }

        FeeInfoBO feeInfoBO = tradeContext.getAttribute("indFee");
        if (feeInfoBO == null) {
            feeInfoBO = new FeeInfoBO();
            feeInfoBO.setTransAmount(transAmount);
        }

        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);

        String showPayerAccNo = tradeContext.getAttribute(SHOW_PAYER_ACC_NO);
        String showPayerAccName = tradeContext.getAttribute(SHOW_PAYER_ACC_NAME);

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
                .tradeType(TradeType.SGL_PAYMENT.getCode())
                .transAmount(feeInfoBO.getTransAmount())
                .transCallbackUrl(reqDTO.getCallbackUrl())
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(null)
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(payeeAccType.getCode())
                .payerAcctNo(basicConfigInfo.getCustAccountNo())
                .payerName(basicConfigInfo.getCustAccountName())
                .payeeAcctNo(reqDTO.getAcctNo())
                .payeeName(reqDTO.getAccName())
                .industryCode(basicConfigInfo.getIndustryCode())
                .transStatus(TransStatus.TRADE_FAILURE.name())
                .channelRespCode(OneBankRespCode.PCC90008.name())
                .respCode(HttpRespStatus.BAD_REQUEST.valueStr())
                .respMessage(StringUtil.truncate(e.getMessage(), 200))
                .reconcileDate(reqDTO.getReqDate())
                .channelSettleDate(reqDTO.getReqDate())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .payerOpbkName(CommonConstants.payerOpbkName)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .payerAccount(basicConfigInfo.getIndustryAccount())
                .payeeAccount(null)
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccNo)
                .showPayerAccountName(showPayerAccName)
                .showPayeeAccountNo(reqDTO.getAcctNo())
                .showPayeeAccountName(reqDTO.getAccName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(reqDTO.getOpBankName())
                .summaryDescription(reqDTO.getRemark())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
