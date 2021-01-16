package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.RefundOrderIdReqDTO;
import cn.kingnet.utp.trade.common.dto.account.RefundOrderIdRespDTO;
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

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description 订单金额解冻
 * @Author WJH
 * @Date 2018年11月23日
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.REFUND_ORDERID,
        reqClass = RefundOrderIdReqDTO.class,
        respClass = RefundOrderIdRespDTO.class,
        successTransStatus = TransStatus.PROCESSING,
        createTransFlow = true,
        chargeFlag = true
)
public class RefundOrderIdService extends AbstractAccountTradeService<RefundOrderIdReqDTO, RefundOrderIdRespDTO> {

    @Resource
    private IBankAccountTransDetailHandler bankAccountTransDetailHandler;
    @Resource
    protected IPaymentService paymentService;
    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected IChannelRelevantHandler channelRelevantHandler;
    @Resource
    protected IAccountOrderLogHandler accountOrderLogHandler;

    private static final String ACCOUNT_ORDER_KEY = "ACCOUNT_ORDER_KEY";
    private static final String CHANNEL_INCOME_FLOW_KEY = "CHANNEL_INCOME_FLOW_KEY";
    private static final String PAYER_ACCOUNT_KEY = "PAYER_ACCOUNT_KEY";
    private static final String PAYER_FUND_ACCOUNT_KEY = "PAYER_FUND_ACCOUNT_KEY";

    public RefundOrderIdService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    protected void verifyReqParam(TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        RefundOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");

        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.isNum(reqDTO.getUserAccount(), true, "用户账户");

        ValidateUtils.maxLength(reqDTO.getOrderId(), 36, true, "订单号");
        ValidateUtils.notSpecialStr(reqDTO.getOrderId(), true, "订单号");

        ValidateUtils.isNum(reqDTO.getPayAmt(), true, "交易金额");
        ValidateUtils.maxLength(reqDTO.getPayAmt(), 15, true, "交易金额");

        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "订单退款回调地址");

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(basicConfigInfo.getUserIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        //企业用户只有审核通过才可能出入金
        if(VirtualAccountType.MERCHANT.getType().equals(basicConfigInfo.getUserAccountNature())){
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(basicConfigInfo.getUserAuthStatus());
            if(MerAuthStatus.NORMAL != merAuthStatus){
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户审核状态[" + merAuthStatus.getValue() + "],不允许操作!");
            }
        }

        BankAccountTransDetail detail = bankAccountTransDetailHandler.queryByOrderId(reqDTO.getUserAccount(), reqDTO.getOrderId());
        if (detail == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此订单入金记录");
        }
        AccountOrderStatus orderStatus = AccountOrderStatus.resolve(detail.getOrderStatus());
        if (orderStatus == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "暂不支持的订单状态" + String.valueOf(detail.getOrderStatus()));
        }
        if (!(orderStatus == AccountOrderStatus.FREEZED || orderStatus == AccountOrderStatus.INITTIALIZE
                || orderStatus == AccountOrderStatus.REFUND_FAIL)) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("该订单状态%s,不能再退款", orderStatus.getDesc()));
        }
        if (Long.valueOf(reqDTO.getPayAmt()).longValue() != detail.getTxnAmount().longValue()) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "交易金额不等于原订单冻结金额");
        }

        //原收款者的入金通知记录
        ChannelIncomeFlow channelIncomeFlow = this.accountHandler.getChannelIncomeFlow(reqDTO.getUserAccount(), reqDTO.getOrderId());
        if (channelIncomeFlow == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此银行订单入金通知记录");
        }
        Account payerAccount = this.accountHandler.queryAccountByUserAccount(reqDTO.getUserAccount());
        if (payerAccount == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "查无此用户账户信息");
        }
        FundAccount payerFundAccount = this.accountHandler.findFundAccount(payerAccount.getFundAccount());
        if (payerAccount == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户未配置关联资金账户");
        }
        tradeContext.setAttribute(CHANNEL_INCOME_FLOW_KEY, channelIncomeFlow);
        tradeContext.setAttribute(PAYER_ACCOUNT_KEY, payerAccount);
        tradeContext.setAttribute(PAYER_FUND_ACCOUNT_KEY, payerFundAccount);
        tradeContext.setAttribute("orderStatus", orderStatus);

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext) {

        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);

        if (basicConfigInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "查无此代付客户平台,不能订单退款");
        }

        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置");
        }

        ChannelIncomeFlow channelIncomeFlow = tradeContext.getAttribute(CHANNEL_INCOME_FLOW_KEY);
        Account payerAccount = tradeContext.getAttribute(PAYER_ACCOUNT_KEY);
        FundAccount payerFundAccount = tradeContext.getAttribute(PAYER_FUND_ACCOUNT_KEY);


        //调用渠道转账
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(tradeContext.getTransDate());
        oneBankTransferReq.setTradeTime(tradeContext.getTransTime());
        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        //请求日期
        oneBankTransferReqContent.setReqDate(tradeContext.getTransDate());
        //请求时间
        oneBankTransferReqContent.setReqTime(tradeContext.getTransTime());
        //卡类型
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //收款人账号
        oneBankTransferReqContent.setPayeeAcctNo(channelIncomeFlow.getExAcctNo());
        //收款人名称
        oneBankTransferReqContent.setPayeeName(channelIncomeFlow.getExAcctName());
        //收款人清算行行号
        oneBankTransferReqContent.setPayeeOpbk(channelIncomeFlow.getClearBankno());
        //收款人开户行号
        oneBankTransferReqContent.setPayeeSubBank(channelIncomeFlow.getClearBankno());

        //实际付款者
        String realPayerAcctNo = payerFundAccount.getBankAccountNo();
        String realPayerName = payerFundAccount.getBankAccountName();
        //回执单显示付款者
        String payerAcctNo = payerAccount.getAccount();
        String payerName = payerAccount.getObjName();

        oneBankTransferReqContent.setRealpayerName(realPayerName);
        oneBankTransferReqContent.setRealpayerAcctNo(realPayerAcctNo);
        //备注附言
        oneBankTransferReqContent.setRemark("订单退款");

        //付款人账号
        oneBankTransferReq.setAcctNo(realPayerAcctNo);
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());
        //账户类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());
        //显示付款人账号
        oneBankTransferReqContent.setPayerAcctNo(payerAcctNo);
        //显示付款人名称
        oneBankTransferReqContent.setPayerName(payerName);
        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //付款人开户行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());
        oneBankTransferReqContent.setPc_flag(HTPcFlag.PRIVATE.getFlag());

        oneBankTransferReq.setContent(oneBankTransferReqContent);
        FeeInfoBO feeInfoBO = tradeContext.getAttribute("indFee");

        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(feeInfoBO.getRealAmount());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        //交易金额
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        AccountOrderStatus orderStatus = tradeContext.getAttribute("orderStatus");
        if (orderStatus != AccountOrderStatus.FREEZED) {
            //订单已冻结，这无需再冻结；冻结付款者转账金额
            accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                    .accountOperSubType(AccountOperSubType.REFUND).userAccount(payerAccount.getAccount()).amount(feeInfoBO.getRealAmount())
                    .peerAccNo(channelIncomeFlow.getExAcctNo()).peerAccName(channelIncomeFlow.getExAcctName())
                    .serverTransId(tradeContext.getServerTransId()).outsideOrderId(channelIncomeFlow.getCoreNo()).remark("订单金额退款")
                    .build());
        }
        try {
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = channelTradeService(oneBankTransferReq, oneBankTransferReqContent, tradeContext);
            } catch (RetryableException e) {
                logger.error("退款流水号:{} >> 调用转账渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
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
                        this.forback(basicConfigInfo, tradeContext, feeInfoBO);
                    }
                }
            } catch (Exception e) {
                logger.error("退款流水号:{} >> 渠道返回[httpRespStatus={}],恢复订单退款冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.forback(basicConfigInfo, tradeContext, feeInfoBO);
            } catch (Exception fe) {
                logger.error("退款流水号:{} >> 交易异常:{} {} 恢复订单退款冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }


    private ChannelResponseDTO channelTradeService(OneBankTransferReq oneBankTransferReq, OneBankTransferReqContent oneBankTransferReqContent, TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext) {

        FundAccount payerFundAcc = tradeContext.getAttribute(PAYER_FUND_ACCOUNT_KEY);
        FundAccType payerFundAccType = FundAccType.resolve(payerFundAcc.getAccountType());

        //业务上规定：订单退款只能走人行大小额
        oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.HT_ROUTE.getFlag());
        oneBankTransferReqContent.setPayRouteCode(null);

        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            oneBankTransferReq.setFundAccType(payerFundAccType);
            oneBankTransferReqContent.setPc_flag(HTPcFlag.PRIVATE.getFlag());
            oneBankTransferReq.setContent(oneBankTransferReqContent);
            logger.info("流水号:{} >> 调用RDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePivate(oneBankTransferReq);
            logger.info("流水号:{} >> 调用RDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            oneBankTransferReq.setFundAccType(payerFundAccType);
            oneBankTransferReqContent.setPc_flag(HTPcFlag.PUBLIC.getFlag());
            oneBankTransferReq.setContent(oneBankTransferReqContent);
            logger.info("流水号:{} >> 调用CDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePublic(oneBankTransferReq);
            logger.info("流水号:{} >> 调用CDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", payerFundAccType.getType()));
        }


    }


    private void forback(BasicConfigInfo basicConfigInfo, TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext, FeeInfoBO feeInfoBO) {

        ChannelIncomeFlow channelIncomeFlow = tradeContext.getAttribute(CHANNEL_INCOME_FLOW_KEY);
        Account payerAccount = tradeContext.getAttribute(PAYER_ACCOUNT_KEY);

        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                .accountOperSubType(AccountOperSubType.REFUND).userAccount(payerAccount.getAccount()).amount(feeInfoBO.getRealAmount())
                .peerAccNo(channelIncomeFlow.getExAcctNo()).peerAccName(channelIncomeFlow.getExAcctName())
                .serverTransId(tradeContext.getServerTransId()).outsideOrderId(channelIncomeFlow.getCoreNo())
                .remark("恢复订单退款冻结金额")
                .build());
    }

    @Override
    public void initTransFlow(TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        RefundOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        //获取渠道配置信息
        String payeeAccType = AccountType.PUBLIC.getCode();
        String tradeDateTime = tradeContext.getTransDate().concat(tradeContext.getTransTime());
        ChannelInfoBO channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), payeeAccType, Long.parseLong(reqDTO.getPayAmt()), tradeDateTime);
        //获取渠道配置信息
        if (channelInfoBO == null || StringUtil.isBlank(channelInfoBO.getChannelCode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "未配置渠道!");
        }

        //订单退款不收取手续费
        FeeInfoBO feeInfoBO = new FeeInfoBO();
        feeInfoBO.setTransAmount(Long.valueOf(reqDTO.getPayAmt()));
        feeInfoBO.setRealAmount(feeInfoBO.getTransAmount());
        feeInfoBO.setMerFee(0L);
        feeInfoBO.setChannelFee(0L);

        tradeContext.setAttribute("indFee", feeInfoBO);

        ChannelIncomeFlow channelIncomeFlow = tradeContext.getAttribute(CHANNEL_INCOME_FLOW_KEY);
        Account payerAccount = tradeContext.getAttribute(PAYER_ACCOUNT_KEY);
        FundAccount payerFundAccount = tradeContext.getAttribute(PAYER_FUND_ACCOUNT_KEY);

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
                .tradeType(TradeType.REFUND_ORDERID.getCode())
                .transAmount(feeInfoBO.getTransAmount())
                .transCallbackUrl(reqDTO.getCallbackUrl())
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(null)
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(AccountType.PRIVATE.getCode())
                .payerAcctNo(payerFundAccount.getBankAccountNo())
                .payerName(payerFundAccount.getBankAccountName())
                .payeeAcctNo(channelIncomeFlow.getExAcctNo())
                .payeeName(channelIncomeFlow.getExAcctName())
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
                .payerAccount(payerAccount.getAccount())
                .payeeAccount(null)
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile("1")
                .showPayerAccountNo(payerAccount.getAccount())
                .showPayerAccountName(payerAccount.getObjName())
                .showPayeeAccountNo(channelIncomeFlow.getExAcctNo())
                .showPayeeAccountName(channelIncomeFlow.getExAcctName())
                .orderId(reqDTO.getOrderId())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(channelIncomeFlow.getBankName())
                .summaryDescription("订单金额退款")
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);


        AccountOrderLog.AccountOrderLogBuilder builder = AccountOrderLog.builder();
        builder.id(IdGenerate.getId()).clientTransId(tradeContext.getClientTradeId())
                .serverTransId(tradeContext.getServerTransId()).remark("订单金额退款")
                .account(reqDTO.getUserAccount()).orderId(reqDTO.getOrderId()).amt(Long.valueOf(reqDTO.getPayAmt()))
                .tradeType(TradeType.REFUND_ORDERID.getCode()).transStatus(TransStatus.PRE_CREATE.name())
                .transDate(DateUtil.getCurrentDate()).transTime(DateUtil.getCurrentTime())
                .gmtCreate(DateUtil.getSystemDate());
        accountOrderLogHandler.saveAccountOrderLog(builder.build().buildVo());
        bankAccountTransDetailHandler.updateOrderStatusByOrderId(reqDTO.getUserAccount(), reqDTO.getOrderId(), AccountOrderStatus.PROCESSING.getCode());
        tradeContext.setAttribute(ACCOUNT_ORDER_KEY, builder);


    }

    @Override
    public void updateTransFlow(TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        RefundOrderIdRespDTO respDTO = tradeContext.getResponseDTO();

        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.industryCode(basicConfigInfo.getIndustryCode());
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
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());

        AccountOrderLog.AccountOrderLogBuilder accountOrderBuilder = tradeContext.getAttribute(ACCOUNT_ORDER_KEY);
        builder.transStatus(TransStatus.PROCESSING.name()).gmtModified(DateUtil.getSystemDate());
        accountOrderLogHandler.updateAccountOrderLog(accountOrderBuilder.build().buildVo());
    }

    @Override
    public void insertTransParamFail(TradeContext<RefundOrderIdReqDTO, RefundOrderIdRespDTO> tradeContext, Exception e) {
        RefundOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            basicConfigInfo = new BasicConfigInfo();
            basicConfigInfo.setIndustryCode(tradeContext.getIndustryCode());
            basicConfigInfo.setProductNo(ProductNo.ACCOUNT.getNo());
        }

        long transAmount ;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }

        String payeeAccType = AccountType.PUBLIC.getCode();
        String tradeDateTime = tradeContext.getTransDate().concat(tradeContext.getTransTime());
        ChannelInfoBO channelInfoBO ;
        try {
            channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), payeeAccType, transAmount, tradeDateTime);
        } catch (Exception ex) {
            channelInfoBO = new ChannelInfoBO();
        }


        //订单退款不收取手续费
        FeeInfoBO feeInfoBO =  tradeContext.getAttribute("indFee");
        if (feeInfoBO == null) {
            feeInfoBO = FeeInfoBO.buildNoConfigFeeInfoBO(transAmount);
        }

        ChannelIncomeFlow channelIncomeFlow = tradeContext.getAttribute(CHANNEL_INCOME_FLOW_KEY);
        if (channelIncomeFlow == null) {
            channelIncomeFlow = new ChannelIncomeFlow();
        }

        Account payerAccount = tradeContext.getAttribute(PAYER_ACCOUNT_KEY);
        if (payerAccount == null) {
            payerAccount = new Account();
            payerAccount.setAccount(reqDTO.getUserAccount());
        }
        FundAccount payerFundAccount = tradeContext.getAttribute(PAYER_FUND_ACCOUNT_KEY);
        if (payerFundAccount == null) {
            payerFundAccount = new FundAccount();
        }

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
                .tradeType(TradeType.REFUND_ORDERID.getCode())
                .transAmount(feeInfoBO.getTransAmount())
                .transCallbackUrl(reqDTO.getCallbackUrl())
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(null)
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(AccountType.PRIVATE.getCode())
                .payerAcctNo(payerFundAccount.getBankAccountNo())
                .payerName(payerFundAccount.getBankAccountName())
                .payeeAcctNo(channelIncomeFlow.getExAcctNo())
                .payeeName(channelIncomeFlow.getExAcctName())
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
                .payerAccount(payerAccount.getAccount())
                .payeeAccount(null)
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile("1")
                .showPayerAccountNo(payerAccount.getAccount())
                .showPayerAccountName(payerAccount.getObjName())
                .showPayeeAccountNo(channelIncomeFlow.getExAcctNo())
                .showPayeeAccountName(channelIncomeFlow.getExAcctName())
                .orderId(reqDTO.getOrderId())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(channelIncomeFlow.getBankName())
                .summaryDescription("订单金额退款")
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);

    }
}
