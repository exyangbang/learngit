package cn.kingnet.product.account.service.inner;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.ITransCurrentHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description : 企业鉴权随机打款验证服务
 * @Author : linkaigui
 * @Create : 2020/3/28 23:53
 */
@Service
@Slf4j
public class AuthBindEntRandomAmtPaymentService {

    public static final String CHANNEL_INFO_BO_KEY = "CHANNEL_INFO_BO_KEY";

    public static final String PAYEE_ACC_TYPE = "PAYEE_ACC_TYPE";

    public static final String MERCHANT_INFO_KEY = "MERCHANT_INFO_KEY";

    public static final String PAYER_FUNDACC_TYPE = "PAYER_FUNDACC_TYPE";

    protected final ProductAccountProperties productAccountProperties;

    @Resource
    private ITransCurrentHandler transCurrentHandler;

    @Resource
    private IAccountHandler accountHandler;

    @Resource
    private IPaymentService paymentService;

    public AuthBindEntRandomAmtPaymentService(ProductAccountProperties productAccountProperties) {
        this.productAccountProperties = productAccountProperties;
    }

    public ChannelResponseDTO randomAmtPayment(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo,BasicConfigInfo basicConfigInfo){
        ChannelResponseDTO channelResponseDTO = null;
        try{
            //1.初始化流水
            this.initTransFlow(tradeContext,merchantAccountInfo,basicConfigInfo);
            try{
                channelResponseDTO = this.reqChannel(tradeContext,merchantAccountInfo,basicConfigInfo);
            }catch (Exception e){
                channelResponseDTO = this.exceptionHandler(tradeContext,e);
                log.error("流水号:{} >> 打款验证调用渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            }
            this.updateTransFlow(tradeContext,channelResponseDTO,basicConfigInfo);
        }catch (Exception e){
            channelResponseDTO = this.exceptionHandler(tradeContext,e);
        }
        return channelResponseDTO;
    }

    private ChannelResponseDTO reqChannel(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo,BasicConfigInfo basicConfigInfo){
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }
        //冻结金额
        this.freezeMethod(tradeContext,merchantAccountInfo,basicConfigInfo);
        try {
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = channelTradeService(tradeContext,merchantAccountInfo,basicConfigInfo);
            } catch (RetryableException e) {
                log.error("流水号:{} >> 打款验证调用渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
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
                        this.unfreezeMethod(tradeContext,merchantAccountInfo,basicConfigInfo);
                    }
                }
            } catch (Exception e) {
                log.error("流水号:{} >> 打款验证渠道返回[httpRespStatus={}],恢复冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.unfreezeMethod(tradeContext,merchantAccountInfo,basicConfigInfo);
            } catch (Exception fe) {
                log.error("流水号:{} >> 交易异常:{} {} 恢复冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }

    /**
     * 冻结金额
     * @param tradeContext
     * @param merchantAccountInfo
     * @param basicConfigInfo
     */
    private void freezeMethod(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo,BasicConfigInfo basicConfigInfo) {
        //冻结平台账户金额
        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getAuthPaymentAccount()).amount(merchantAccountInfo.getAuthAmt())
                .peerAccNo(merchantAccountInfo.getAccountNo()).peerAccName(merchantAccountInfo.getAccountName())
                .serverTransId(tradeContext.getServerTransId()).remark("冻结小额打款验证金额")
                .build());
    }

    /**
     * 恢复冻结金额
     * @param tradeContext
     * @param merchantAccountInfo
     * @param basicConfigInfo
     */
    private void unfreezeMethod(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo,BasicConfigInfo basicConfigInfo) {
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(basicConfigInfo.getAuthPaymentAccount()).amount(merchantAccountInfo.getAuthAmt())
                .peerAccNo(merchantAccountInfo.getAccountNo()).peerAccName(merchantAccountInfo.getAccountName())
                .serverTransId(tradeContext.getServerTransId()).remark("恢复打款验证冻结金额")
                .build());
    }

    private ChannelResponseDTO channelTradeService(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo,BasicConfigInfo basicConfigInfo) {
        FundAccType payerFundAccType = tradeContext.getAttribute(PAYER_FUNDACC_TYPE);
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        //调用渠道转账
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(tradeContext.getTransDate());
        oneBankTransferReq.setTradeTime(tradeContext.getTransTime());
        oneBankTransferReq.setAcctNo(basicConfigInfo.getCustAccountNo());//付款人账号
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());

        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        oneBankTransferReqContent.setReqDate(tradeContext.getTransDate());/**请求日期*/
        oneBankTransferReqContent.setReqTime(tradeContext.getTransTime());/**请求时间*/
        oneBankTransferReqContent.setCardType(HTCardType.D.name());//卡类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());//账户类型

        oneBankTransferReqContent.setPayerAcctNo(basicConfigInfo.getCustAccountNo());//付款人账号
        oneBankTransferReqContent.setPayerName(basicConfigInfo.getCustAccountName());//付款人名称
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());//付款人清算行行号
        oneBankTransferReqContent.setPayeeAcctNo(merchantAccountInfo.getAccountNo());//收款人账号
        oneBankTransferReqContent.setPayeeName(merchantAccountInfo.getAccountName());//收款人名称
        oneBankTransferReqContent.setPayeeOpbk(merchantAccountInfo.getReceiveBankCode());//收款人清算行行号
//        oneBankTransferReqContent.setPhone(withdrawReqDTO.getMobile());//手机号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());//付款人开户行行号
        oneBankTransferReqContent.setPayeeSubBank(merchantAccountInfo.getReceiveBankCode());//收款人开户行号
        oneBankTransferReqContent.setRealpayerAcctNo(basicConfigInfo.getCustAccountNo());//实际付款账号
        oneBankTransferReqContent.setRealpayerName(basicConfigInfo.getCustAccountName());//实际付款户名
        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(merchantAccountInfo.getAuthAmt());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());//交易金额
        oneBankTransferReqContent.setRemark("小额打款验证");//备注附言
        oneBankTransferReqContent.setPersonCode("8888");//法人编号
        //接口路由选择
        if (ChannelKey.HT_CUC.getKey().equals(channelInfoBO.getChannelKey())
                || ChannelKey.HT_POST_CUC.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.UTP_DESIGNATED.getFlag());
            oneBankTransferReqContent.setPayRouteCode(HTPayRouteCode.CUC.name());
        } else if (ChannelKey.HT_CKEY.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.HT_ROUTE.getFlag());
            oneBankTransferReqContent.setPayRouteCode(null);
        }else if (ChannelKey.HT_SIB.getKey().equals(channelInfoBO.getChannelKey())) {
            oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.UTP_DESIGNATED.getFlag());
            oneBankTransferReqContent.setPayRouteCode(HTPayRouteCode.SIB.name());
        }  else {
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
            log.info("流水号:{} >> 调用RDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePivate(oneBankTransferReq);
            log.info("流水号:{} << 调用RDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            oneBankTransferReq.setFundAccType(payerFundAccType);
            oneBankTransferReq.setContent(oneBankTransferReqContent);
            log.info("流水号:{} >> 调用CDFA转账渠道请求报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePublic(oneBankTransferReq);
            log.info("流水号:{} << 调用CDFA转账渠道响应报文:{}", tradeContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", channelInfoBO.getChannelKey()));
        }
    }

    private void initTransFlow(TradeContext<?, ?> tradeContext,MerchantAccountInfo merchantAccountInfo, BasicConfigInfo basicConfigInfo){
        ChannelInfoBO channelInfoBO = tradeContext.getAttribute(CHANNEL_INFO_BO_KEY);
        AccountType payeeAccType = tradeContext.getAttribute(PAYEE_ACC_TYPE);
        MerchantInfo merchantInfo = tradeContext.getAttribute(MERCHANT_INFO_KEY);

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
                .tradeType(TradeType.RANDOM_AMT_PAYMENT_AUTH.getCode())
                .transAmount(merchantAccountInfo.getAuthAmt())
//                .transCallbackUrl(withdrawReqDTO.getCallbackUrl())
                .transDate(tradeContext.getTransDate())
                .transTime(tradeContext.getTransTime())
                .merNo(merchantInfo.getMerNo())
                .userCode(channelInfoBO.getUserCode())
                .accNo(basicConfigInfo.getCustAccountNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(merchantAccountInfo.getAuthAmt())
                .pcFlag(payeeAccType.getCode())
                .userType(merchantInfo.getUserType())
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
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .orginChannelFee(0L)
                .payeeAccount(merchantInfo.getAccount())
                .payerAccount(basicConfigInfo.getAuthPaymentAccount())
                .feeAccount(basicConfigInfo.getFeeAccount())
                .incomeAccount(basicConfigInfo.getFeeIncomeAccount())
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(basicConfigInfo.getCustAccountNo())
                .showPayerAccountName(basicConfigInfo.getCustAccountName())
                .showPayeeAccountNo(merchantAccountInfo.getAccountNo())
                .showPayeeAccountName(merchantAccountInfo.getAccountName())
                .elcMakeFlag(ElcMakeFlag.UN_MAKE.getFlag())
                .feeAccountName(basicConfigInfo.getFeeAccountName())
                .incomeAccountName(basicConfigInfo.getFeeIncomeAccountName())
                .summaryDescription("小额打款验证")
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(merchantAccountInfo.getBankName())
                .remoteIp(tradeContext.getRemoteIp())
                .build();
        List<TransCurrent> transCurrentList = Lists.newArrayList();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);
    }

    private void updateTransFlow(TradeContext<?, ?> tradeContext,ChannelResponseDTO channelResponseDTO,BasicConfigInfo basicConfigInfo) {
        String transStatus = this.getTransStatus(tradeContext,channelResponseDTO);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.industryCode(basicConfigInfo.getIndustryCode());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (channelResponseDTO != null) {
            builder.respCode(channelResponseDTO.getStatus())
                    .respException(channelResponseDTO.getException())
                    .respMessage(channelResponseDTO.getMessage());
        }
        if (channelResponseDTO != null) {
            builder.channelRespCode(channelResponseDTO.getChannelRespCode())
                    .channelRespMsg(channelResponseDTO.getMessage())
                    .channelRespId(channelResponseDTO.getChannelRespId())
                    .channelRespTime(channelResponseDTO.getTimestamp());
        }
        builder.gmtModified(new Date());
        transCurrentHandler.updateByIndustryCodeAndServerTransId(builder.build(), basicConfigInfo.getIndustryCode(), tradeContext.getServerTransId());
    }

    private String getTransStatus(TradeContext<?, ?> tradeContext,ChannelResponseDTO channelResponseDTO) {
        TransStatus status = TransStatus.PROCESSING;
        if (channelResponseDTO != null) {
            if (StringUtil.isNotBlank(channelResponseDTO.getStatus())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(channelResponseDTO.getStatus()));
                if (httpRespStatus.is2xxSuccessful()) {
                    status = TransStatus.PROCESSING;
                } else if (httpRespStatus.is4xxClientError()) {
                    status = TransStatus.TRADE_FAILURE;
                } else if (httpRespStatus.is5xxServerError()) {
                    status = TransStatus.TRADE_ERROR;
                }
            } else {
                status = TransStatus.PROCESSING;
            }
        } else {
            status = TransStatus.TRADE_FAILURE;
        }
        return status.toString();
    }

    public ChannelResponseDTO exceptionHandler(TradeContext<?, ?> tradeContext,Throwable t){
        ChannelResponseDTO channelResponseDTO = new ChannelResponseDTO();
        channelResponseDTO.setServerTransId(tradeContext.getServerTransId());
        if (t instanceof TradeException) {
            TradeException te = (TradeException) t;
            channelResponseDTO.setStatus(String.valueOf(te.getStatus()));
            channelResponseDTO.setMessage(te.getMessage());
            channelResponseDTO.setException(te.getException());
            if(te.getStatus() == HttpRespStatus.BALANCE_INSUFFICIENT.value()){
                channelResponseDTO.setChannelRespCode(OneBankRespCode.PCC22011.name());
            }else {
                channelResponseDTO.setChannelRespCode(OneBankRespCode.PCC90008.name());
            }
        } else {
            channelResponseDTO.setStatus(String.valueOf(HttpRespStatus.SERVER_ERROR.value()));
            channelResponseDTO.setMessage(t.getMessage());
            channelResponseDTO.setException(t.getClass().getName());
            channelResponseDTO.setChannelRespCode(OneBankRespCode.PCC90008.name());
        }
        return channelResponseDTO;
    }
}
