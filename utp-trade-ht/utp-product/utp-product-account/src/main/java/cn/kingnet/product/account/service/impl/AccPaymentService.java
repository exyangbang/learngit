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
import cn.kingnet.utp.trade.common.dto.account.AccPaymentReqDTO;
import cn.kingnet.utp.trade.common.dto.account.AccPaymentRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description : 子账户单笔付款
 * @Author : linkaigui
 * @Create : 2020/5/14 10:41
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.ACC_PAYMENT,
        reqClass = AccPaymentReqDTO.class,
        respClass = AccPaymentRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.PROCESSING
)
public class AccPaymentService extends AbstractAccountTradeService<AccPaymentReqDTO, AccPaymentRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;

    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;

    @Resource
    protected ISubPayPayeeWhiteListHandler subPayPayeeWhiteListHandler;

    @Resource
    protected ICardBinHandler cardBinHandler;

    @Resource
    protected IClearBankCodeHandler clearBankCodeHandler;

    @Resource
    protected IIndustryHandler industryHandler;

    @Resource
    private IChannelRelevantHandler channelRelevantHandler;

    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;

    @Resource
    private IFeeHandler feeHandler;

    @Resource
    protected IPaymentService paymentService;

    protected static final String FEE_INFO_KEY = "FEE_INFO_KEY";
    protected static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";
    protected static final String PAYER_FUNDACC_TYPE = "PAYER_FUNDACC_TYPE";
    protected static final String PAYEE_ACC_TYPE = "PAYEE_ACC_TYPE";
    protected static final String TRANS_ORDER_RELATION_LIST_KEY = "TRANS_ORDER_RELATION_LIST_KEY";
    protected static final String SHOW_PAYER_ACCT_NO = "SHOW_PAYER_ACCT_NO";
    protected static final String SHOW_PAYER_ACCT_NAME = "SHOW_PAYER_ACCT_NAME";

    public AccPaymentService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到平台商户信息,不能付款!");
        }
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }

        //保存流水关联支付订单信息
        List<TransOrderRelation> transOrderRelationList = tradeContext.getAttribute(TRANS_ORDER_RELATION_LIST_KEY);
        transCurrentHandler.saveTransOrderRelation(transOrderRelationList);

        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(accPaymentReqDTO.getReqDate());
        oneBankTransferReq.setTradeTime(accPaymentReqDTO.getReqTime());
        //付款人账号
        oneBankTransferReq.setAcctNo(basicConfigInfo.getCustAccountNo());
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());

        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        //请求日期
        oneBankTransferReqContent.setReqDate(accPaymentReqDTO.getReqDate());
        //请求时间
        oneBankTransferReqContent.setReqTime(accPaymentReqDTO.getReqTime());
        //卡类型
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //账户类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());
        //显示付款人账号
        oneBankTransferReqContent.setPayerAcctNo(tradeContext.getAttribute(SHOW_PAYER_ACCT_NO));
        //显示付款人名称
        oneBankTransferReqContent.setPayerName(tradeContext.getAttribute(SHOW_PAYER_ACCT_NAME));
        //付款人开户行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());
        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //收款人账号
        oneBankTransferReqContent.setPayeeAcctNo(accPaymentReqDTO.getPayeeAcctNo());
        //收款人名称
        oneBankTransferReqContent.setPayeeName(accPaymentReqDTO.getPayeeAccName());
        //收款人开户行号
        oneBankTransferReqContent.setPayeeSubBank(accPaymentReqDTO.getOpBankCode());
        //收款人清算行行号
        oneBankTransferReqContent.setPayeeOpbk(accPaymentReqDTO.getClBankCode());

        //手机号
//        oneBankTransferReqContent.setPhone(withdrawReqDTO.getMobile());
        //实际付款账号
        oneBankTransferReqContent.setRealpayerAcctNo(basicConfigInfo.getCustAccountNo());
        //实际付款户名
        oneBankTransferReqContent.setRealpayerName(basicConfigInfo.getCustAccountName());
        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(feeInfoBO.getRealAmount());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        //交易金额
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        //备注附言
        oneBankTransferReqContent.setRemark(accPaymentReqDTO.getRemark());
        //法人编号
        oneBankTransferReqContent.setPersonCode("8888");
        oneBankTransferReq.setContent(oneBankTransferReqContent);
        //冻结金额
        this.freezeMethod(tradeContext);
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
                        this.unfreezeMethod(tradeContext);
                    }
                }
            } catch (Exception e) {
                logger.error("流水号:{} >> 渠道返回[httpRespStatus={}],恢复冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.unfreezeMethod(tradeContext);
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }

    private ChannelResponseDTO channelTradeService(OneBankTransferReq oneBankTransferReq, OneBankTransferReqContent oneBankTransferReqContent, TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {

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
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("%s渠道暂未支持", channelInfoBO.getChannelKey()));
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
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", channelInfoBO.getChannelKey()));
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(accPaymentReqDTO.getUserAccount(), true, "付款子账户");
        ValidateUtils.maxLength(accPaymentReqDTO.getUserAccount(), 19, true, "付款子账户");

        ValidateUtils.isYyyyMMdd(accPaymentReqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(accPaymentReqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(accPaymentReqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }

        String payAmt = accPaymentReqDTO.getPayAmt();
        ValidateUtils.isIntegerNegative(payAmt, true, "付款金额");
        long payAmtLong;
        try {
            payAmtLong = Long.parseLong(payAmt);
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款金额格式不对!");
        }
        if (payAmtLong <= 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款金额须大于零的整数!");
        }
        if (payAmt.length() > 15) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款金额超出范围!");
        }

        ValidateUtils.maxLength(accPaymentReqDTO.getPayeeAcctType(), 1, true, "收款人账户类型");
        AccountType reqPayeeAcctType = AccountType.getAccountTypeByOuterValue(accPaymentReqDTO.getPayeeAcctType());
        if (reqPayeeAcctType == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "收款人账户类型不正确");
        }

        ValidateUtils.abcValid(accPaymentReqDTO.getPayeeAcctNo(), true, "收款人账户");
        ValidateUtils.maxLength(accPaymentReqDTO.getPayeeAcctNo(), 32, true, "收款人账户");

        ValidateUtils.notSpecialStrExcludeParenthesis(accPaymentReqDTO.getPayeeAccName(), true, "收款人账户名称");
        ValidateUtils.maxLength(accPaymentReqDTO.getPayeeAccName(), 100, true, "收款人账户名称");

        ValidateUtils.maxLength(accPaymentReqDTO.getRemark(), 100, false, "备注说明");

        ValidateUtils.abcValid(accPaymentReqDTO.getShowPayerAcctNo(), false, "显示付款账号");
        ValidateUtils.maxLength(accPaymentReqDTO.getShowPayerAcctNo(), 32, false, "显示付款账号");

        ValidateUtils.notSpecialStrExcludeParenthesis(accPaymentReqDTO.getShowPayerName(), false, "显示付款户名");
        ValidateUtils.maxLength(accPaymentReqDTO.getShowPayerName(), 100, false, "显示付款户名");

        //校验收款人开户行号和开户行名称
        //对公或单位结算卡
        if (!AccountType.PRIVATE.getValue().equals(accPaymentReqDTO.getPayeeAcctType())) {
            ValidateUtils.abcValid(accPaymentReqDTO.getOpBankCode(), true, "收款人开户行号");
            ValidateUtils.maxLength(accPaymentReqDTO.getOpBankCode(), 32, true, "收款人开户行号");

            ValidateUtils.notSpecialStr(accPaymentReqDTO.getOpBankName(), true, "收款人开户行名称");
            ValidateUtils.maxLength(accPaymentReqDTO.getOpBankName(), 100, true, "收款人开户行名称");
        } else {
            ValidateUtils.abcValid(accPaymentReqDTO.getOpBankCode(), false, "收款人开户行号");
            ValidateUtils.maxLength(accPaymentReqDTO.getOpBankCode(), 32, false, "收款人开户行号");

            ValidateUtils.notSpecialStr(accPaymentReqDTO.getOpBankName(), false, "收款人开户行名称");
            ValidateUtils.maxLength(accPaymentReqDTO.getOpBankName(), 100, false, "收款人开户行名称");
        }

        //校验收款人证件类型和证件号
        if (AccountType.BILLING_CARD.getValue().equals(accPaymentReqDTO.getPayeeAcctType())) {
            ValidateUtils.maxLength(accPaymentReqDTO.getIdType(), 3, true, "收款人证件类型");
            ValidateUtils.maxLength(accPaymentReqDTO.getIdCode(), 32, true, "收款人证件号");
        } else {
            ValidateUtils.maxLength(accPaymentReqDTO.getIdType(), 3, false, "收款人证件类型");
            ValidateUtils.maxLength(accPaymentReqDTO.getIdCode(), 32, false, "收款人证件号");
        }
        if (StringUtil.isNotBlank(accPaymentReqDTO.getIdType())) {
            IdType idType = IdType.getEnum(accPaymentReqDTO.getIdType());
            ValidateUtils.notNull(idType, "收款人证件类型不支持");
        }

        //营业执照号
        if (AccountType.BILLING_CARD.getValue().equals(accPaymentReqDTO.getPayeeAcctType())) {
            ValidateUtils.maxLength(accPaymentReqDTO.getBusinessLicenseCode(), 32, true, "营业执照号");
        }

        //支付订单号列表
        ValidateUtils.hasText(accPaymentReqDTO.getTradeOrderIds(), "支付订单号列表");
        List<String> tradeOrderIdList = Arrays.asList(accPaymentReqDTO.getTradeOrderIds().split(","));
        if (tradeOrderIdList == null || tradeOrderIdList.size() <= 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "支付订单号列表不能为空!");
        }
        for (String tradeOrderId : tradeOrderIdList) {
            ValidateUtils.abcValid(tradeOrderId, true, "支付订单号列表");
        }

        ValidateUtils.isHttpUrl(accPaymentReqDTO.getCallbackUrl(), true, "回调地址");

        //交易客户端流水不能重复
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), accPaymentReqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, accPaymentReqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        FundAccType payerFundAccType = FundAccType.resolve(basicConfigInfo.getFundAccType());
        if (null == payerFundAccType) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("付款方归属资金账户类型[%s]错误", basicConfigInfo.getFundAccType()));
        }

        if (!TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getOpenSubSinglePay())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "暂未开通子账户单笔付款功能!");
        }

        if (StringUtil.isBlank(basicConfigInfo.getPayerSubType())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "未配置支持的付款子账户类型!");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(basicConfigInfo.getUserIndustryCode())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款子账户归属客户号与当前客户号不一致!");
        }



        //企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(basicConfigInfo.getUserAccountNature())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(basicConfigInfo.getUserAuthStatus());
            if (MerAuthStatus.NORMAL != merAuthStatus) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款子账户审核状态[" + merAuthStatus.getValue() + "],不允许操作!");
            }
        }

        List<String> payerSubTypeList = Arrays.asList(basicConfigInfo.getPayerSubType().split(","));
        if (payerSubTypeList == null || payerSubTypeList.size() <= 0) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "未配置支持的付款子账户类型!");
        }
        if (!payerSubTypeList.contains(basicConfigInfo.getUserAccountNature())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, String.format("子账户类型[%s],暂不支持子账户单笔付款!", basicConfigInfo.getUserAccountNature()));
        }

        //是否校验收款人开通虚户
        if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getVerifyPayeeAccountSign())) {
            List<MerchantAccountInfo> bindMerAcctNoList = merchantAccountHandler.findMerAccountByIndustryCodeAndAcctNo(basicConfigInfo.getIndustryCode(), accPaymentReqDTO.getPayeeAcctNo());
            if (bindMerAcctNoList == null || bindMerAcctNoList.size() <= 0) {
                throw new TradeException(HttpRespStatus.FORBIDDEN, "收款人账号未开通虚户绑定!");
            }
            MerchantAccountInfo merchantAccountInfo = bindMerAcctNoList.stream().filter(info -> reqPayeeAcctType.getCode().equals(info.getAccountType())).findFirst().orElse(null);
            if (merchantAccountInfo == null) {
                throw new TradeException(HttpRespStatus.FORBIDDEN, "收款人账户类型与开通虚户绑定账户类型不一致!");
            }
            if (!accPaymentReqDTO.getPayeeAccName().equals(merchantAccountInfo.getAccountName())) {
                throw new TradeException(HttpRespStatus.FORBIDDEN, "收款人账户名称与开通虚户绑定账户名称不一致!");
            }
        } else {
            //是否校验收款人白名单标志
            if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getVerifyPayeeWhiteListSign())) {
                Integer whiteCount = subPayPayeeWhiteListHandler.selectCountByIndustryAndPayee(basicConfigInfo.getIndustryId(), accPaymentReqDTO.getPayeeAcctNo(), accPaymentReqDTO.getPayeeAccName());
                if (whiteCount == null || whiteCount.intValue() <= 0) {
                    throw new TradeException(HttpRespStatus.FORBIDDEN, "收款人白名单不通过!");
                }
            }
        }

        //对私开户行信息不上送由卡BIN获取
        if (AccountType.PRIVATE.getValue().equals(accPaymentReqDTO.getPayeeAcctType())) {
            CardBinInfo cardBinInfo = cardBinHandler.getCardBinInfo(accPaymentReqDTO.getPayeeAcctNo());
            if (cardBinInfo == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]的卡BIN信息", accPaymentReqDTO.getPayeeAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getClearbankno())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的清算行号", accPaymentReqDTO.getPayeeAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getBankcode())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行号", accPaymentReqDTO.getPayeeAcctNo()));
            }
            if (StringUtils.isBlank(cardBinInfo.getBankname())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行名", accPaymentReqDTO.getPayeeAcctNo()));
            }
            tradeContext.getRequestDTO().setOpBankCode(cardBinInfo.getBankcode());
            tradeContext.getRequestDTO().setOpBankName(cardBinInfo.getBankname());
            tradeContext.getRequestDTO().setClBankCode(cardBinInfo.getClearbankno());
        } else {
            //校验清算行号是否正确，从清算行表 t_clear_bank_code 匹配
            String clearBankCode = clearBankCodeHandler.getClearBankCode(accPaymentReqDTO.getOpBankCode());
            if (StringUtil.isBlank(clearBankCode)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "系统查无匹配的开户行");
            }
            tradeContext.getRequestDTO().setClBankCode(clearBankCode);
        }

        //校验支付订单号列表
        List<TransOrderRelation> transOrderRelationList = new ArrayList<>(tradeOrderIdList.size());
        if (tradeOrderIdList.size() == 1) {
            OutsideTransOrder outsideTransOrder = outsideTransOrderHandler.selectByTransOrderIdAndSuccess(basicConfigInfo.getIndustryCode(), tradeOrderIdList.get(0));
            if (outsideTransOrder == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "支付订单号未能完全匹配!");
            }
            if (payAmtLong > outsideTransOrder.getTransAmount().longValue()) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款金额超过支付订单号总金额!");
            }
            transOrderRelationList.add(TransOrderRelation.builder()
                    .id(IdGenerate.getId())
                    .clientTransId(tradeContext.getClientTradeId())
                    .serverTransId(tradeContext.getServerTransId())
                    .outsideTransOrderId(outsideTransOrder.getId())
                    .transOrderId(outsideTransOrder.getTransOrderId())
                    .transAmount(outsideTransOrder.getTransAmount())
                    .gmtCreate(DateUtil.getSystemDate())
                    .gmtModified(DateUtil.getSystemDate())
                    .build());
        } else {
            List<OutsideTransOrder> outsideTransOrderList = outsideTransOrderHandler.selectByTransOrderIdsAndSuccess(basicConfigInfo.getIndustryCode(), accPaymentReqDTO.getTradeOrderIds());
            if (CollectionUtils.isEmpty(outsideTransOrderList) || outsideTransOrderList.size() < tradeOrderIdList.size()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "支付订单号未能完全匹配!");
            }
            Long transAmtSum = outsideTransOrderList.stream().mapToLong(OutsideTransOrder::getTransAmount).sum();
            if (payAmtLong > transAmtSum.longValue()) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "付款金额超过支付订单号总金额!");
            }
            for (OutsideTransOrder outsideTransOrder : outsideTransOrderList) {
                transOrderRelationList.add(TransOrderRelation.builder()
                        .id(IdGenerate.getId())
                        .clientTransId(tradeContext.getClientTradeId())
                        .serverTransId(tradeContext.getServerTransId())
                        .outsideTransOrderId(outsideTransOrder.getId())
                        .transOrderId(outsideTransOrder.getTransOrderId())
                        .transAmount(outsideTransOrder.getTransAmount())
                        .gmtCreate(DateUtil.getSystemDate())
                        .gmtModified(DateUtil.getSystemDate())
                        .build());
            }
        }

        //获取渠道配置信息
        String trandeDateTime = accPaymentReqDTO.getReqDate().concat(accPaymentReqDTO.getReqTime());
        ChannelInfoBO channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), reqPayeeAcctType.getCode(), Long.parseLong(accPaymentReqDTO.getPayAmt()), trandeDateTime);
        //用户特指手续费优先级高于平台
        if (basicConfigInfo.getUserFeeTemplateId() != null && basicConfigInfo.getUserFeeTemplateId() > 0) {
            channelInfoBO.setIndFeeTemplateId(basicConfigInfo.getUserFeeTemplateId());
        }

        tradeContext.setAttribute(PAYEE_ACC_TYPE, reqPayeeAcctType);
        tradeContext.setAttribute(PAYER_FUNDACC_TYPE, payerFundAccType);
        tradeContext.setAttribute(CHANNEL_INFO_BO_KEY, channelInfoBO);
        tradeContext.setAttribute(TRANS_ORDER_RELATION_LIST_KEY, transOrderRelationList);

        // 验证客户号 单日|单笔限额
        industryHandler.validIndustryLimitAmt(basicConfigInfo.getIndustryCode(), reqPayeeAcctType, payAmtLong, accPaymentReqDTO.getReqDate());
        // 验证客户号子账户 单日|单笔限额
        industryHandler.validSubAccountLimitAmt(basicConfigInfo.getIndustryCode(), basicConfigInfo.getUserAccount(), payAmtLong, accPaymentReqDTO.getReqDate());
        // 校验同一平台下的同一用户连续相同提现金额次数限制 和 同一平台下每分钟累计不超过数值限制
        industryHandler.validCashMaxTranAmt(basicConfigInfo.getIndustryCode(), basicConfigInfo.getUserAccount(), payAmtLong);
    }

    @Override
    public void initTransFlow(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        //计算手续费
        FeeInfoBO feeInfoBO = feeHandler.calculateFeeByIndustry(channelInfoBO.getIndFeeTemplateId(), channelInfoBO.getChnFeeTemplateId(), Long.valueOf(accPaymentReqDTO.getPayAmt()));
        if (feeInfoBO == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "费用计算错误!");
        }
        if (feeInfoBO.getRealAmount() <= 0) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款金额超出,无法提现!");
        }
        tradeContext.setAttribute(FEE_INFO_KEY, feeInfoBO);
        List<TransCurrent> transCurrentList = Lists.newArrayList();
        //显示付款人账号
        String showPayerAccountNo = basicConfigInfo.getCustAccountNo();
        //显示付款人名称
        String showPayerAccountName = basicConfigInfo.getCustAccountName();

        if(basicConfigInfo.getOpenShowCustomFlag()==1) {
            //根据客户号“是否支持自定义显示付款账号及户名”来处理：标志为“是”时，按照现有逻辑处理。

            //1.接口上送显示付款账号、显示付款户名；非必填字段，如果有上送，则需要上送至渠道；
            //2.如果有上送显示付款账号(虚账户910)、显示付款户名(虚账户绑卡的名称)，需要判断户名和账号只能是发起提现的虚户的户名和账号是否一致
            if (StringUtil.isNotBlank(accPaymentReqDTO.getShowPayerAcctNo()) && StringUtil.isNotBlank(accPaymentReqDTO.getShowPayerName())) {
                if (!accPaymentReqDTO.getShowPayerAcctNo().equals(accPaymentReqDTO.getUserAccount())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "显示付款账号与付款子账户不一致!");
                }
                boolean exists = merchantAccountHandler.existsMerchantAccount(accPaymentReqDTO.getUserAccount(), accPaymentReqDTO.getShowPayerName());
                if (!exists) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "显示付款户名不符合规则!");
                }
                showPayerAccountNo = accPaymentReqDTO.getShowPayerAcctNo();
                showPayerAccountName = accPaymentReqDTO.getShowPayerName();
            }
        }

        tradeContext.setAttribute(SHOW_PAYER_ACCT_NO, showPayerAccountNo);
        tradeContext.setAttribute(SHOW_PAYER_ACCT_NAME, showPayerAccountName);

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
                .tradeType(TradeType.ACC_PAYMENT.getCode())
                .transAmount(Long.valueOf(accPaymentReqDTO.getPayAmt()))
                .transCallbackUrl(accPaymentReqDTO.getCallbackUrl())
                .transDate(accPaymentReqDTO.getReqDate())
                .transTime(accPaymentReqDTO.getReqTime())
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
                .payeeAcctNo(accPaymentReqDTO.getPayeeAcctNo())
                .payeeName(accPaymentReqDTO.getPayeeAccName())
                .industryCode(basicConfigInfo.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
//                .splitInfoId(tradeContext.getAttribute(SPLITINFO_ID_KEY))
                .merSettleType(feeInfoBO.getMerSettleType())
                .merChargeMode(feeInfoBO.getMerChargeMode())
                .channelSettleType(feeInfoBO.getChannelSettleType())
                .channelChargeMode(feeInfoBO.getChannelChargeMode())
                .orginChannelFee(feeInfoBO.getMerFee())
                .payeeAccount(null)
                .payerAccount(basicConfigInfo.getUserAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccountNo)
                .showPayerAccountName(showPayerAccountName)
                .showPayeeAccountNo(accPaymentReqDTO.getPayeeAcctNo())
                .showPayeeAccountName(accPaymentReqDTO.getPayeeAccName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .summaryDescription(accPaymentReqDTO.getRemark())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(accPaymentReqDTO.getOpBankName())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    @Override
    public void updateTransFlow(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        AccPaymentRespDTO accPaymentRespDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.merNo(basicConfigInfo.getMerNo());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (accPaymentRespDTO != null) {
            builder.respCode(accPaymentRespDTO.getStatus())
                    .respException(accPaymentRespDTO.getException())
                    .respMessage(accPaymentRespDTO.getMessage());
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
     */
    private void freezeMethod(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        //冻结付款子账户金额
        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(accPaymentReqDTO.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                .peerAccNo(accPaymentReqDTO.getPayeeAcctNo()).peerAccName(accPaymentReqDTO.getPayeeAccName())
                .serverTransId(tradeContext.getServerTransId()).remark("冻结子账户单笔付款金额")
                .build());
        try {
            //冻结手续费金额
            if (feeInfoBO.getMerFee() != null && feeInfoBO.getMerFee() > 0) {
                if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(feeInfoBO.getMerChargeMode())) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结子账户单笔付款手续费")
                            .build());
                } else if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.INNER.getMode().equals(feeInfoBO.getMerChargeMode())) {
                    accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                            .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getUserAccount()).amount(feeInfoBO.getMerFee())
                            .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                            .serverTransId(tradeContext.getServerTransId()).remark("冻结子账户单笔付款手续费")
                            .build());
                }
            }
        } catch (Exception e) {
            try {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(accPaymentReqDTO.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                        .peerAccNo(accPaymentReqDTO.getPayeeAcctNo()).peerAccName(accPaymentReqDTO.getPayeeAccName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复子账户单笔付款冻结金额")
                        .build());
            } catch (Exception fe) {
                logger.error("流水号:{} >> 交易异常:{} {} 恢复子账户单笔付款冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            logger.error("流水号:{} >> 交易异常:{} {} 冻结子账户单笔付款手续费异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 恢复冻结金额
     *
     * @param tradeContext
     */
    private void unfreezeMethod(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(accPaymentReqDTO.getUserAccount()).amount(Long.valueOf(feeInfoBO.getRealAmount()))
                .peerAccNo(accPaymentReqDTO.getPayeeAcctNo()).peerAccName(accPaymentReqDTO.getPayeeAccName())
                .serverTransId(tradeContext.getServerTransId()).remark("恢复子账户单笔付款冻结金额")
                .build());
        if (feeInfoBO.getMerFee() != null && feeInfoBO.getMerFee() > 0) {
            if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(feeInfoBO.getMerChargeMode())) {
                //解冻手续费
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getFeeAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复子账户单笔付款冻结手续费")
                        .build());
            } else if (SettleType.REAL_TIME.getType().equals(feeInfoBO.getMerSettleType()) && ChargeMode.INNER.getMode().equals(feeInfoBO.getMerChargeMode())) {
                accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .accountOperSubType(AccountOperSubType.FEE).userAccount(basicConfigInfo.getUserAccount()).amount(feeInfoBO.getMerFee())
                        .peerAccNo(basicConfigInfo.getFeeIncomeAccount()).peerAccName(basicConfigInfo.getFeeIncomeAccountName())
                        .serverTransId(tradeContext.getServerTransId()).remark("恢复子账户单笔付款冻结手续费")
                        .build());
            }
        }
    }

    @Override
    public void insertTransParamFail(TradeContext<AccPaymentReqDTO, AccPaymentRespDTO> tradeContext, Exception e) {
        AccPaymentReqDTO accPaymentReqDTO = tradeContext.getRequestDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (basicConfigInfo == null) {
            basicConfigInfo = new BasicConfigInfo();
            basicConfigInfo.setIndustryCode(tradeContext.getIndustryCode());
        }
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        if (channelInfoBO == null) {
            channelInfoBO = new ChannelInfoBO();
        }

        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        long transAmount;
        try {
            transAmount = Long.parseLong(accPaymentReqDTO.getPayAmt());
        } catch (Exception ex) {
            transAmount = 0L;
        }
        FeeInfoBO feeInfoBO = tradeContext.getAttribute(FEE_INFO_KEY);
        if (feeInfoBO == null) {
            feeInfoBO = new FeeInfoBO();
            feeInfoBO.setTransAmount(transAmount);
        }

        String showPayerAccountNo = tradeContext.getAttribute(SHOW_PAYER_ACCT_NO);
        String showPayerAccountName = tradeContext.getAttribute(SHOW_PAYER_ACCT_NAME);

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
                .tradeType(TradeType.ACC_PAYMENT.getCode())
                .transAmount(transAmount)
                .transCallbackUrl(accPaymentReqDTO.getCallbackUrl())
                .transDate(accPaymentReqDTO.getReqDate())
                .transTime(accPaymentReqDTO.getReqTime())
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
                .payeeAcctNo(accPaymentReqDTO.getPayeeAcctNo())
                .payeeName(accPaymentReqDTO.getPayeeAccName())
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
                .orginChannelFee(feeInfoBO.getMerFee())
                .payeeAccount(null)
                .payerAccount(basicConfigInfo.getUserAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(showPayerAccountNo)
                .showPayerAccountName(showPayerAccountName)
                .showPayeeAccountNo(accPaymentReqDTO.getPayeeAcctNo())
                .showPayeeAccountName(accPaymentReqDTO.getPayeeAccName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .summaryDescription(accPaymentReqDTO.getRemark())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(accPaymentReqDTO.getOpBankName())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }
}
