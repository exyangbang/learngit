package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.WithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.WithdrawRespDTO;
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
 * @Description : 提现接口描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/9 15:03
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.WITHDRAW,
        reqClass = WithdrawReqDTO.class,
        respClass = WithdrawRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.PROCESSING
)
public class WithdrawService extends AbstractAccountTradeService<WithdrawReqDTO, WithdrawRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;

    @Resource
    protected ITransHistoryHandler transHistoryHandler;

    @Resource
    protected IPaymentService paymentService;

    @Resource
    protected IAccountHandler accountHandler;

    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;

    @Resource
    private IChannelRelevantHandler channelRelevantHandler;

    @Resource
    private IFeeHandler feeHandler;
    @Resource
    private IIndustryHandler industryHandler;

    protected static final String FEE_INFO_KEY = "FEE_INFO_KEY";
    protected static final String MERCHANT_ACCOUNT_INFO_KEY = "MERCHANT_ACCOUNT_INFO_KEY";
    protected static final String PAYEE_ACC_TYPE = "PAYEE_ACC_TYPE";
    protected static final String SPLITINFO_ID_KEY = "SPLITINFO_ID_KEY";
    protected static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";
    protected static final String PAYER_FUNDACC_TYPE = "PAYER_FUNDACC_TYPE";
    protected static final String SHOW_PAYER_ACC_NO = "SHOW_PAYER_ACC_NO";
    protected static final String SHOW_PAYER_ACC_NAME = "SHOW_PAYER_ACC_NAME";

    public WithdrawService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到平台商户信息,不能提现!");
        }
        //获取商户账户信息
        MerchantAccountInfo merchantAccountInfo = tradeContext.getAttribute(MERCHANT_ACCOUNT_INFO_KEY);
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }

        WithdrawReqDTO withdrawReqDTO = tradeContext.getRequestDTO();
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(withdrawReqDTO.getReqDate());
        oneBankTransferReq.setTradeTime(withdrawReqDTO.getReqTime());
        //付款人账号
        oneBankTransferReq.setAcctNo(basicConfigInfo.getCustAccountNo());
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());

        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();

        //请求日期&时间
        oneBankTransferReqContent.setReqDate(withdrawReqDTO.getReqDate());
        oneBankTransferReqContent.setReqTime(withdrawReqDTO.getReqTime());
        //卡类型
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //账户类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());

        //付款人账号/名称为显示付款人账号/名称
        String realPayerAccNo = basicConfigInfo.getCustAccountNo();
        String realPayerAccName = basicConfigInfo.getCustAccountName();
        String showPayerAccNo = tradeContext.getAttribute(SHOW_PAYER_ACC_NO);
        String showPayerAccName = tradeContext.getAttribute(SHOW_PAYER_ACC_NAME);

        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //付款人开户行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());
        //实际付款账号&名称
        oneBankTransferReqContent.setRealpayerAcctNo(realPayerAccNo);
        oneBankTransferReqContent.setRealpayerName(realPayerAccName);
        //显示付款账号&名称
        oneBankTransferReqContent.setPayerAcctNo(showPayerAccNo);
        oneBankTransferReqContent.setPayerName(showPayerAccName);

        //收款人清算行行号
        oneBankTransferReqContent.setPayeeOpbk(merchantAccountInfo.getReceiveBankCode());
        //收款人开户行号
        oneBankTransferReqContent.setPayeeSubBank(merchantAccountInfo.getBankCode());
        //收款人账号&名称&手机号码
        oneBankTransferReqContent.setPayeeAcctNo(merchantAccountInfo.getAccountNo());
        oneBankTransferReqContent.setPayeeName(merchantAccountInfo.getAccountName());
        oneBankTransferReqContent.setPhone(withdrawReqDTO.getMobile());

        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(feeInfoBO.getRealAmount());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        //交易金额
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        //备注附言
        oneBankTransferReqContent.setRemark(withdrawReqDTO.getRemark());
        //法人编号
        oneBankTransferReqContent.setPersonCode("8888");

        oneBankTransferReq.setContent(oneBankTransferReqContent);

        //冻结金额
        this.freezeMethod(tradeContext, basicConfigInfo, withdrawReqDTO, feeInfoBO, merchantAccountInfo);
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
                        this.unfreezeMethod(tradeContext, basicConfigInfo, withdrawReqDTO, feeInfoBO, merchantAccountInfo);
                    }
                }
            } catch (Exception e) {
                logger.error("流水号:{} >> 渠道返回[httpRespStatus={}],恢复冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.unfreezeMethod(tradeContext, basicConfigInfo, withdrawReqDTO, feeInfoBO, merchantAccountInfo);
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }


    private ChannelResponseDTO channelTradeService(OneBankTransferReq oneBankTransferReq, OneBankTransferReqContent oneBankTransferReqContent, TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {

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


    @Override
    protected void verifyReqParam(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        WithdrawReqDTO withdrawReqDTO = tradeContext.getRequestDTO();

        ValidateUtils.abcValid(withdrawReqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(withdrawReqDTO.getUserAccount(), 19, true, "用户账户");

        ValidateUtils.isYyyyMMdd(withdrawReqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(withdrawReqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(withdrawReqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }
        ValidateUtils.mobileValid(withdrawReqDTO.getMobile(), false, "手机号码");

        ValidateUtils.abcValid(withdrawReqDTO.getShowPayerAcctNo(), false, "显示付款账号");
        ValidateUtils.maxLength(withdrawReqDTO.getShowPayerAcctNo(), 32, false, "显示付款账号");

        ValidateUtils.notSpecialStrExcludeParenthesis(withdrawReqDTO.getShowPayerName(), false, "显示付款户名");
        ValidateUtils.maxLength(withdrawReqDTO.getShowPayerName(), 60, false, "显示付款户名");

        ValidateUtils.isHttpUrl(withdrawReqDTO.getCallbackUrl(), true, "后端返回地址");

        ValidateUtils.maxLength(withdrawReqDTO.getRemark(), 500,true, "备注说明");

        String payAmt = withdrawReqDTO.getPayAmt();
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

        //交易客户端流水不能重复
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), withdrawReqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, withdrawReqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(basicConfigInfo.getUserIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        VirtualAccountType userNature = VirtualAccountType.resolve(basicConfigInfo.getUserAccountNature());
        if (!(userNature == VirtualAccountType.MERCHANT ||
                userNature == VirtualAccountType.PERSON ||
                userNature == VirtualAccountType.SELFEMPLOYED ||
                userNature == VirtualAccountType.BROKERAGE)
        ) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("用户账户类型[%s],暂不支持提现!", basicConfigInfo.getUserAccountNature()));
        }
        ValidateUtils.hasText(basicConfigInfo.getMerNo(), "用户账户未开户");
        if (AccountStatus.OPEN_BIND.getCode().intValue() != Integer.parseInt(basicConfigInfo.getUserAccountStatus())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("用户账户%s,不能提现!", AccountStatus.getValueByCode(Integer.parseInt(basicConfigInfo.getUserAccountStatus()))));
        }

        //企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(basicConfigInfo.getUserAccountNature())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(basicConfigInfo.getUserAuthStatus());
            if (MerAuthStatus.NORMAL != merAuthStatus) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户审核状态[" + merAuthStatus.getValue() + "],不能提现!");
            }
        }

        //获取商户账户信息
        MerchantAccountInfo merchantAccountInfo;
        if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getAbleBindMultiCard())) {
            ValidateUtils.maxLength(withdrawReqDTO.getAcctNo(), 32, true, "银行卡号");
            merchantAccountInfo = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(basicConfigInfo.getUserAccount(), withdrawReqDTO.getAcctNo());
        } else {
            merchantAccountInfo = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(basicConfigInfo.getUserAccount(), null);
        }
        if (merchantAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到用户账户信息,不能提现!");
        }
        if (!BindCardStatus.NORMAL.getStatus().equals(merchantAccountInfo.getBindStatus())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户绑卡状态[" + merchantAccountInfo.getBindStatus() + "]不正常，请核实后再试");
        }

        AccountType accountType = AccountType.getAccountTypeByCode(merchantAccountInfo.getAccountType());
        if (accountType == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "用户账户类型错误!");
        }
        tradeContext.setAttribute(MERCHANT_ACCOUNT_INFO_KEY, merchantAccountInfo);
        tradeContext.setAttribute(PAYEE_ACC_TYPE, accountType);

        FundAccType payerFundAccType = FundAccType.resolve(basicConfigInfo.getFundAccType());
        if (null == payerFundAccType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("付款方归属资金账户类型[%s]错误", basicConfigInfo.getFundAccType()));
        }

        //校验付款方和收款方资金账户需归属同一个下
        if (!basicConfigInfo.getFundAccount().equals(basicConfigInfo.getUserFundAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "用户账户归属资金账户不一致!");
        }

        //获取渠道配置信息
        String payeeAccType = accountType.getCode();
        String trandeDateTime = withdrawReqDTO.getReqDate().concat(withdrawReqDTO.getReqTime());
        ChannelInfoBO channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), payeeAccType, Long.parseLong(withdrawReqDTO.getPayAmt()), trandeDateTime);
        //用户特指手续费优先级高于平台
        if (basicConfigInfo.getUserFeeTemplateId() != null && basicConfigInfo.getUserFeeTemplateId() > 0) {
            channelInfoBO.setIndFeeTemplateId(basicConfigInfo.getUserFeeTemplateId());
        }
        tradeContext.setAttribute(PAYER_FUNDACC_TYPE, payerFundAccType);
        tradeContext.setAttribute(PAYEE_ACC_TYPE, accountType);
        tradeContext.setAttribute(CHANNEL_INFO_BO_KEY, channelInfoBO);

        // 验证客户号 单日|单笔限额
        industryHandler.validIndustryLimitAmt(basicConfigInfo.getIndustryCode(), accountType, payAmtLong, withdrawReqDTO.getReqDate());
        // 验证客户号子账户 单日|单笔限额
        industryHandler.validSubAccountLimitAmt(basicConfigInfo.getIndustryCode(), basicConfigInfo.getUserAccount(), payAmtLong, withdrawReqDTO.getReqDate());
        // 校验同一平台下的同一用户连续相同提现金额次数限制 和 同一平台下每分钟累计不超过数值限制
        industryHandler.validCashMaxTranAmt(basicConfigInfo.getIndustryCode(), basicConfigInfo.getUserAccount(), payAmtLong);
    }

    @Override
    public void initTransFlow(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        WithdrawReqDTO withdrawReqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        MerchantAccountInfo merchantAccountInfo = tradeContext.getAttribute(MERCHANT_ACCOUNT_INFO_KEY);
        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        //计算手续费
        FeeInfoBO feeInfoBO = feeHandler.calculateFeeByIndustry(channelInfoBO.getIndFeeTemplateId(), channelInfoBO.getChnFeeTemplateId(), Long.valueOf(withdrawReqDTO.getPayAmt()));
        if (feeInfoBO == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "费用计算错误!");
        }
        if (feeInfoBO.getRealAmount() <= 0) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "提现金额超出,无法提现!");
        }
        tradeContext.setAttribute(FEE_INFO_KEY, feeInfoBO);
        List<TransCurrent> transCurrentList = Lists.newArrayList();

        //显示付款人账号&名称
        String showPayerAccountNo = basicConfigInfo.getCustAccountNo();
        String showPayerAccountName = basicConfigInfo.getCustAccountName();

        if(basicConfigInfo.getOpenShowCustomFlag()==1){
            //根据客户号“是否支持自定义显示付款账号及户名”来处理：标志为“是”时，按照现有逻辑处理。

            //1.接口上送显示付款账号、显示付款户名；非必填字段，如果有上送，则需要上送至渠道；
            //2.如果有上送显示付款账号(虚账户910)、显示付款户名(虚账户绑卡的名称)，需要判断户名和账号只能是发起提现的虚户的户名和账号
            if (StringUtil.isNotBlank(withdrawReqDTO.getShowPayerAcctNo()) && StringUtil.isNotBlank(withdrawReqDTO.getShowPayerName())) {
                if (!withdrawReqDTO.getShowPayerAcctNo().equals(withdrawReqDTO.getUserAccount())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "显示付款账号与提现虚户的账号不一致");
                }
                boolean existsBindAccName = merchantAccountHandler.existsMerchantAccount(withdrawReqDTO.getUserAccount(), withdrawReqDTO.getShowPayerName());
                if (!existsBindAccName) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "显示付款名称与提现虚户的绑卡账户名称不一致");
                }
                showPayerAccountNo = withdrawReqDTO.getShowPayerAcctNo();
                showPayerAccountName = withdrawReqDTO.getShowPayerName();
            }
        }
        tradeContext.setAttribute(SHOW_PAYER_ACC_NO, showPayerAccountNo);
        tradeContext.setAttribute(SHOW_PAYER_ACC_NAME, showPayerAccountName);

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
                .tradeType(TradeType.WITHDRAW.getCode())
                .transAmount(Long.valueOf(withdrawReqDTO.getPayAmt()))
                .transCallbackUrl(withdrawReqDTO.getCallbackUrl())
                .transDate(withdrawReqDTO.getReqDate())
                .transTime(withdrawReqDTO.getReqTime())
                .merNo(basicConfigInfo.getMerNo())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(payeeAccType.getCode())
                .userType(basicConfigInfo.getUserType())
                .payerAcctNo(basicConfigInfo.getCustAccountNo())
                .payerName(basicConfigInfo.getCustAccountName())
                .payeeAcctNo(merchantAccountInfo.getAccountNo())
                .payeeName(merchantAccountInfo.getAccountName())
                .industryCode(basicConfigInfo.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .splitInfoId(tradeContext.getAttribute(SPLITINFO_ID_KEY))
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .orginChannelFee(feeInfoBO.getMerFee())
                .payeeAccount(basicConfigInfo.getUserAccount())
                .payerAccount(basicConfigInfo.getIndustryAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccountNo)
                .showPayerAccountName(showPayerAccountName)
                .showPayeeAccountNo(merchantAccountInfo.getAccountNo())
                .showPayeeAccountName(merchantAccountInfo.getAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .summaryDescription(withdrawReqDTO.getRemark())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(merchantAccountInfo.getBankName())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    @Override
    public void updateTransFlow(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        WithdrawRespDTO withdrawRespDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.merNo(basicConfigInfo.getMerNo());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (withdrawRespDTO != null) {
            builder.respCode(withdrawRespDTO.getStatus())
                    .respException(withdrawRespDTO.getException())
                    .respMessage(withdrawRespDTO.getMessage());
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

    /**
     * 冻结金额
     *
     * @param tradeContext
     * @param basicConfigInfo
     * @param withdrawReqDTO
     * @param feeInfoBO
     * @param merchantAccountInfo
     */
    private void freezeMethod(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext, BasicConfigInfo basicConfigInfo, WithdrawReqDTO withdrawReqDTO, FeeInfoBO feeInfoBO, MerchantAccountInfo merchantAccountInfo) {
        //冻结用户账户金额
        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                .peerAccNo(merchantAccountInfo.getAccountNo()).peerAccName(merchantAccountInfo.getAccountName())
                .serverTransId(tradeContext.getServerTransId()).remark("冻结提现金额")
                .build());

        try {
            //冻结手续费金额
            if (feeInfoBO.getMerFee() != null && feeInfoBO.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(feeInfoBO.getMerChargeMode())) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结提现手续费")
                            .build());
                } else if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.INNER.getMode().equals(feeInfoBO.getMerChargeMode())) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getUserAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结提现手续费")
                            .build());
                }
            }
        } catch (Exception e) {
            try {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                        .peerAccNo(merchantAccountInfo.getAccountNo()).peerAccName(merchantAccountInfo.getAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复提现冻结金额")
                        .build());
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            logger.error("流水号:{} >> 交易异常:{} {} 冻结提现手续费异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 恢复冻结金额
     *
     * @param tradeContext
     * @param basicConfigInfo
     * @param withdrawReqDTO
     * @param feeInfoBO
     * @param merchantAccountInfo
     */
    private void unfreezeMethod(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext, BasicConfigInfo basicConfigInfo, WithdrawReqDTO withdrawReqDTO, FeeInfoBO feeInfoBO, MerchantAccountInfo merchantAccountInfo) {
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                .peerAccNo(merchantAccountInfo.getAccountNo()).peerAccName(merchantAccountInfo.getAccountName())
                .serverTransId(tradeContext.getServerTransId()).remark("恢复提现冻结金额")
                .build());
        if (feeInfoBO.getMerFee() != null && feeInfoBO.getMerFee() > 0) {
            if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(feeInfoBO.getMerChargeMode())) {
                //解冻手续费
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复提现冻结手续费")
                        .build());
            } else if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.INNER.getMode().equals(feeInfoBO.getMerChargeMode())) {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getUserAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复提现冻结手续费")
                        .build());
            }
        }
    }

    @Override
    public void insertTransParamFail(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext, Exception e) {
        WithdrawReqDTO reqDTO = tradeContext.getRequestDTO();
        MerchantAccountInfo merchantAccountInfo = tradeContext.getAttribute(MERCHANT_ACCOUNT_INFO_KEY);
        if (merchantAccountInfo == null) {
            merchantAccountInfo = new MerchantAccountInfo();
        }
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        if (channelInfoBO == null) {
            channelInfoBO = new ChannelInfoBO();
        }
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            basicConfigInfo = new BasicConfigInfo();
        }
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        if (feeInfoBO == null) {
            feeInfoBO = new FeeInfoBO();
        }
        String showPayerAccountNo = tradeContext.getAttribute(SHOW_PAYER_ACC_NO);
        String showPayerAccountName = tradeContext.getAttribute(SHOW_PAYER_ACC_NAME);

        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        long transAmount;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (NumberFormatException ex) {
            transAmount = 0L;
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
                .tradeType(TradeType.WITHDRAW.getCode())
                .transAmount(transAmount)
                .transCallbackUrl(reqDTO.getCallbackUrl())
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(basicConfigInfo.getMerNo())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(feeInfoBO.getMerFee())
                .channelFee(feeInfoBO.getChannelFee())
                .realAmount(feeInfoBO.getRealAmount())
                .pcFlag(payeeAccType == null ? null : payeeAccType.getCode())
                .userType(basicConfigInfo.getUserType())
                .payerAcctNo(basicConfigInfo.getCustAccountNo())
                .payerName(basicConfigInfo.getCustAccountName())
                .payeeAcctNo(merchantAccountInfo.getAccountNo())
                .payeeName(merchantAccountInfo.getAccountName())
                .industryCode(tradeContext.getIndustryCode())
                .transStatus(TransStatus.TRADE_FAILURE.name())
                .channelRespCode(OneBankRespCode.PCC90008.name())
                .respCode(HttpRespStatus.BAD_REQUEST.valueStr())
                .respMessage(StringUtil.truncate(e.getMessage(), 200))
                .reconcileDate(reqDTO.getReqDate())
                .channelSettleDate(reqDTO.getReqDate())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .splitInfoId(tradeContext.getAttribute(SPLITINFO_ID_KEY))
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .orginChannelFee(feeInfoBO.getMerFee())
                .payeeAccount(basicConfigInfo.getUserAccount())
                .payerAccount(basicConfigInfo.getIndustryAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccountNo)
                .showPayerAccountName(showPayerAccountName)
                .showPayeeAccountNo(merchantAccountInfo.getAccountNo())
                .showPayeeAccountName(merchantAccountInfo.getAccountName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .summaryDescription(reqDTO.getRemark())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(merchantAccountInfo.getBankName())
                .remoteIp(tradeContext.getRemoteIp())
                .build();

        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
