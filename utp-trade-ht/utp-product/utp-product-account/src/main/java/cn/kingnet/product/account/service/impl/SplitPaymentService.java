package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.BlackList;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.SplitPaymentReqDTO;
import cn.kingnet.utp.trade.common.dto.account.SplitPaymentRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
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
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description : 平台单笔分账接口 single_settle_split
 * @Author : WJH
 * @Create : 2019/11/29
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.SPLIT_PAYMENT,
        reqClass = SplitPaymentReqDTO.class,
        respClass = SplitPaymentRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.TRADE_SUCCESS
)
public class SplitPaymentService extends AbstractAccountTradeService<SplitPaymentReqDTO, SplitPaymentRespDTO> {

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
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private IBlackListHandler blackListHandler;
    private static final String SPLIT_INFO = "split_info";

    public SplitPaymentService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext) {
        SplitPaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        //平台往子账户分账
        ChannelResponseDTO channelResponseDTO = new ChannelResponseDTO();
        SplitPaymentRespDTO respDTO = new SplitPaymentRespDTO();
        respDTO.setReconcileDate(tradeContext.getTransDate());
        try {
            splitInfoHandler.processSingleSplitPayment(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getAccount(), Long.valueOf(reqDTO.getPayAmt()),
                    tradeContext.getServerTransId(), reqDTO.getRemark(), reqDTO.getClientTradeId());
            respDTO.setTransStatus(TransStatus.TRADE_SUCCESS.name());
            respDTO.setStatusDesc("交易成功");
            respDTO.setStatus(HttpRespStatus.OK.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
        } catch (RetryableException e) {
            logger.error("流水号:{} >> 调用平台单笔分账服务异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            respDTO.setTransStatus(TransStatus.TRADE_ERROR.name());
            respDTO.setStatusDesc("交易异常,状态未知");
            respDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
            channelResponseDTO.setMessage("交易异常,状态未知");
            channelResponseDTO.setException(e.getMessage());
        } catch (Exception e) {
            logger.error("流水号:{} >> 调用平台单笔分账服务交易失败:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setStatusDesc("交易失败");
            respDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            channelResponseDTO.setMessage("交易失败");
            channelResponseDTO.setException(e.getMessage());
        }
        channelResponseDTO.setSpRespMsg(BeanMap.create(respDTO));
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        SplitPaymentReqDTO reqDTO = tradeContext.getRequestDTO();

        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(reqDTO.getReqDate())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }
        ValidateUtils.abcValid(reqDTO.getAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getAccount(), 19, true, "用户账户");

        ValidateUtils.isIntegerNegative(reqDTO.getPayAmt(), true, "分账金额");
        if (reqDTO.getPayAmt().length() > 15) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易金额超出范围!");
        }
        long payAmt = new BigDecimal(reqDTO.getPayAmt()).longValue();

        //交易客户端流水不能重复：当天交易流水检验
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        ValidateUtils.hasText(basicConfigInfo.getMerNo(), "用户账户未开户");

        AccountStatus accountStatus = AccountStatus.getEnum(Integer.parseInt(basicConfigInfo.getUserAccountStatus()));
        if (AccountStatus.NO_OPEN == accountStatus || AccountStatus.CANCEL == accountStatus) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("用户账户%s,不能分账!", accountStatus.getValue()));
        }
        //企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(basicConfigInfo.getUserAccountNature())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(basicConfigInfo.getUserAuthStatus());
            if (MerAuthStatus.NORMAL != merAuthStatus) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("企业账户审核状态[%s],暂不能参与平台分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
            }
        }

        //校验付款方和收款方资金账户需归属同一个下
        if (!basicConfigInfo.getFundAccount().equals(basicConfigInfo.getUserFundAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "平台、用户账户归属资金账户不一致!");
        }
        ValidateUtils.maxLength(reqDTO.getTradeOrderIds(), 20000, true, "交易订单号列表");

        boolean isExistsSplitInfo = splitInfoHandler.isExistsSplitInfo4Success(tradeContext.getAuthInfo().getAuthNo(), tradeContext.getClientTradeId());
        if (isExistsSplitInfo) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "客户端流水号[" + tradeContext.getClientTradeId() + "]已存在成功分账记录");
        }

        //校验支付订单[transOrderIds]是否存在及金额大于分账金额
        outsideTransOrderHandler.validTransOrderIds(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getTradeOrderIds(), payAmt, false, 0L);
        if (isBlackUserAccount(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该账户[%s]的绑卡信息已被列入黑名单，暂不能分账", reqDTO.getAccount()));
        }
    }

    private boolean isBlackUserAccount(String industryCode, String userAccount) {
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(userAccount);
        if (merchantInfo != null) {
            if (!StringUtil.equals(industryCode, merchantInfo.getIndustryCode())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该分账用户归属代付客户[%s]与上送代付客户号不一致", merchantInfo.getIndustryCode()));
            }
        } else {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此子账户[%s]的基本信息", userAccount));
        }
        String userType = merchantInfo.getUserType();
        String code, name;
        if (userType.equals(UserType.MER.getType())) {
            code = merchantInfo.getBusLicCode();
            name = merchantInfo.getEntName();
        } else {
            code = merchantInfo.getIdCode();
            name = merchantInfo.getMerName();
        }
        List<BlackList> allBlackList = blackListHandler.selectAllBlackList();
        if (!CollectionUtils.isEmpty(allBlackList)) {
            return allBlackList.parallelStream().filter(o -> o.getIdCode().equals(code) && o.getName().equals(name)).count() > 0;
        }
        return false;
    }

    @Override
    public void initTransFlow(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext) {
        SplitPaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        String userAccount = reqDTO.getAccount();
        IndustryPayInfo industryPayInfo = splitInfoHandler.getIndustryPayInfo(industryCode);
        UserPayInfo userPayInfo = splitInfoHandler.getUserPayInfo(userAccount);

        SplitInfo splitInfo = this.buildSplitInfo(tradeContext);
        splitInfoHandler.saveSplitInfo(splitInfo);
        tradeContext.setAttribute(SPLIT_INFO, splitInfo);

        TransCurrent transCurrent = TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(String.format("%s%s", reqDTO.getReqDate(), reqDTO.getReqTime()))
                .currency("CNY")
                .orgCode(industryPayInfo.getOrgCode())
                .orgName(industryPayInfo.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.SPLIT_PAYMENT.getCode())
                .transAmount(Long.valueOf(reqDTO.getPayAmt()))
                .transCallbackUrl(null)
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(industryPayInfo.getIndustryAccount())
                .userCode(null)
                .accNo(industryPayInfo.getFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(Long.valueOf(reqDTO.getPayAmt()))
                .pcFlag(userPayInfo.getUserAccType())
                .userType(AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()) == null ? null : AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()).getValue())
                .payerAcctNo(industryPayInfo.getFundAccNo())
                .payerName(industryPayInfo.getFundAccName())
                .payeeAcctNo(userPayInfo.getFundAccNo())
                .payeeName(userPayInfo.getFundAccName())
                .industryCode(industryPayInfo.getIndustryCode())
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
                .payerAccount(industryPayInfo.getIndustryAccount())
                .payeeAccount(userPayInfo.getUserAccount())
                .feeAccount(industryPayInfo.getFeeOutAccount())
                .incomeAccount(industryPayInfo.getFeeInAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .reconcileDate(reqDTO.getReqDate())
                .showPayerAccountNo(industryPayInfo.getIndustryAccount())
                .showPayerAccountName(industryPayInfo.getIndustryName())
                .showPayeeAccountNo(userPayInfo.getUserAccount())
                .showPayeeAccountName(userPayInfo.getUserName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(industryPayInfo.getFeeOutName())
                .incomeAccountName(industryPayInfo.getFeeInName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(reqDTO.getRemark())
                .summaryDescription("单笔实时分账交易")
                .remoteIp(tradeContext.getRemoteIp())
                .splitInfoId(splitInfo.getId())
                .build();
        transCurrentHandler.saveTransCurrent(Lists.newArrayList(transCurrent));
    }

    @Override
    public void updateTransFlow(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        SplitPaymentRespDTO responseDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.merNo(basicConfigInfo.getMerNo());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (responseDTO != null) {
            builder.respCode(responseDTO.getStatus())
                    .respException(responseDTO.getException())
                    .respMessage(String.format("%s:%s", responseDTO.getStatusDesc(), responseDTO.getMessage()));
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        TransCurrent transCurrent = builder.build();

        SplitInfo splitInfo = tradeContext.getAttribute(SPLIT_INFO);
        if (splitInfo != null) {
            splitInfo.setTransStatus(transCurrent.getTransStatus());
            splitInfo.setTransDesc(transCurrent.getRespMessage());
            splitInfo.setGmtModified(transCurrent.getGmtModified());
            if (TransStatus.TRADE_SUCCESS.name().equals(transCurrent.getTransStatus())) {
                splitInfo.setStatus(SplitStatus.SPLIT_OK.getStatus());
            }
            splitInfoHandler.updateTransStatusById(splitInfo);
        }

        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());
    }

    @Override
    public void insertTransParamFail(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext, Exception e) {
        SplitPaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        String userAccount = reqDTO.getAccount();
        IndustryPayInfo industryPayInfo = splitInfoHandler.getIndustryPayInfo(industryCode);
        if (industryPayInfo == null) {
            industryPayInfo = new IndustryPayInfo();
            industryPayInfo.setIndustryCode(industryCode);
        }
        UserPayInfo userPayInfo = splitInfoHandler.getUserPayInfo(userAccount);
        if (userPayInfo == null) {
            userPayInfo = new UserPayInfo();
            userPayInfo.setUserAccount(userAccount);
        }
        long transAmount;
        try {
            transAmount = Long.parseLong(reqDTO.getPayAmt());
        } catch (NumberFormatException ex) {
            transAmount = 0L;
        }

        TransParamFailVo paramFailVo = TransParamFailVo.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(tradeContext.getClientTradeId())
                .clientTransTime(String.format("%s%s", reqDTO.getReqDate(), reqDTO.getReqTime()))
                .currency("CNY")
                .orgCode(industryPayInfo.getOrgCode())
                .orgName(industryPayInfo.getOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.SPLIT_PAYMENT.getCode())
                .transAmount(transAmount)
                .transCallbackUrl(null)
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(industryPayInfo.getIndustryAccount())
                .userCode(null)
                .accNo(industryPayInfo.getFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(transAmount)
                .pcFlag(userPayInfo.getUserAccType())
                .userType(AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()) == null ? null : AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()).getValue())
                .payerAcctNo(industryPayInfo.getFundAccNo())
                .payerName(industryPayInfo.getFundAccName())
                .payeeAcctNo(userPayInfo.getFundAccNo())
                .payeeName(userPayInfo.getFundAccName())
                .industryCode(industryPayInfo.getIndustryCode())
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
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(industryPayInfo.getIndustryAccount())
                .payeeAccount(userPayInfo.getUserAccount())
                .feeAccount(industryPayInfo.getFeeOutAccount())
                .incomeAccount(industryPayInfo.getFeeInAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .reconcileDate(reqDTO.getReqDate())
                .showPayerAccountNo(industryPayInfo.getIndustryAccount())
                .showPayerAccountName(industryPayInfo.getIndustryName())
                .showPayeeAccountNo(userPayInfo.getUserAccount())
                .showPayeeAccountName(userPayInfo.getUserName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .feeAccountName(industryPayInfo.getFeeOutName())
                .incomeAccountName(industryPayInfo.getFeeInName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(reqDTO.getRemark())
                .summaryDescription("单笔实时分账交易")
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        transCurrentHandler.saveTransParamFail(paramFailVo);
    }

    private SplitInfo buildSplitInfo(TradeContext<SplitPaymentReqDTO, SplitPaymentRespDTO> tradeContext) {
        SplitPaymentReqDTO reqDTO = tradeContext.getRequestDTO();
        return SplitInfo.builder().id(IdGenerate.getId())
                .industryCode(tradeContext.getIndustryCode())
                .providerCode(tradeContext.getIndustryCode())
                .batchId(null)
                .settleDate(reqDTO.getReqDate())
                .clientTransId(tradeContext.getClientTradeId())
                .userAccount(reqDTO.getAccount())
                .amount(Long.valueOf(reqDTO.getPayAmt()))
                .settleMode(SettleMode.CHARGE.getCode())
                .period(0)
                .remark(reqDTO.getRemark())
                .extend1(reqDTO.getTradeOrderIds())
                .extend2(null).extend3(null)
                .gmtCreate(new Date()).gmtModified(new Date())
                .splitDate(reqDTO.getReqDate())
                .status(SplitStatus.SPLIT_UNDO.getStatus())
                .transStatus(TransStatus.PRE_CREATE.name())
                .transDesc(TransStatus.PRE_CREATE.getTransDesc())
                .transDate(DateUtil.getCurrentDate())
                .build();

    }
}
