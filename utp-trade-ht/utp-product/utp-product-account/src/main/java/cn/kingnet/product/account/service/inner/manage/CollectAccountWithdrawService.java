package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.dto.manage.CollectionAccountWithdrawReqDTO;
import cn.kingnet.utp.product.common.dto.manage.CollectionAccountWithdrawRespDTO;
import cn.kingnet.utp.product.common.dto.manage.ManageContext;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.CollectAccountWithdraw;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.vo.CollectAccountWithdrawVo;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 后管归集账户提现[不收取任何相关手续费 限定为 实时代付对公户]
 *
 * @author WJH
 * @date 2019-05-09
 */
@Slf4j
@Service
public class CollectAccountWithdrawService {


    @Resource
    protected IPaymentService paymentService;
    @Resource
    protected IAccountHandler accountHandler;
    @Resource
    protected ITransCurrentHandler transCurrentHandler;
    @Resource
    protected ITransHistoryHandler transHistoryHandler;
    @Resource
    private ServerIdGenerate serverIdGenerate;
    @Resource
    private ICollectAccountWithdrawHandler collectAccountWithdrawHandler;
    @Resource
    private IFundAccountHandler fundAccountHandler;
    @Resource
    private IIndustryHandler industryHandler;

    protected static final String PAYEE_ACC_TYPE = "PAYEE_ACC_TYPE";
    protected static final String PAYER_FUNDACC_TYPE = "PAYER_FUNDACC_TYPE";
    protected static final String COLLECTION_INDUSTRY = "COLLECTION_INDUSTRY";
    protected static final String COLLECT_ACCOUNT_WITHDRAW = "COLLECT_ACCOUNT_WITHDRAW";

    private UtpConfigProperties utpConfigProperties;
    private ProductAccountProperties productAccountProperties;

    public CollectAccountWithdrawService(UtpConfigProperties utpConfigProperties, ProductAccountProperties productAccountProperties) {
        this.utpConfigProperties = utpConfigProperties;
        this.productAccountProperties = productAccountProperties;
    }

    public CollectionAccountWithdrawRespDTO doService(CollectionAccountWithdrawReqDTO reqDTO) {
        final CollectionAccountWithdrawRespDTO respClientDTO = new CollectionAccountWithdrawRespDTO();
        final String serverTransId = serverIdGenerate.generateServerTransId();
        LambdaLogger.info(log, "流水号:{} >> 后管归集账户提现交易服务", serverTransId);
        LambdaLogger.info(log, "流水号:{} >> 后管请求报文：->{}", serverTransId, JSON.toJSONString(reqDTO));
        respClientDTO.setClientTransId(reqDTO.getClientTransId());
        respClientDTO.setServerTransId(serverTransId);
        respClientDTO.setIndustryCode(reqDTO.getIndustryCode());
        respClientDTO.setAccount(reqDTO.getAccount());
        respClientDTO.setTransAmount(reqDTO.getTransAmount());
        //1.构造整个服务上下文参数
        ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext =
                new ManageContext(serverTransId, reqDTO.getClientTransId(), reqDTO.getReqDate(), reqDTO.getReqTime(), reqDTO);
        manageContext.setResponseDTO(respClientDTO);
        try {
            this.verifyReqParam(manageContext);
            this.initTransFlow(manageContext);
            try {
                ChannelResponseDTO channelResponseDTO = this.reqChannel(manageContext);
                manageContext.setChannelResponseDTO(channelResponseDTO);
                this.buildRespClientDTO(manageContext, null);
            } catch (Exception e) {
                this.buildRespClientDTO(manageContext, e);
                LambdaLogger.error(log, "流水号:{} >> 归集账户请求渠道异常:{}", serverTransId, e.getMessage(), e);
            } finally {
                this.updateTransFlow(manageContext);
            }
        } catch (Exception e) {
            this.buildRespClientDTO(manageContext, e);
            LambdaLogger.error(log, "流水号:{} >> 归集账户提现交易异常:{}", serverTransId, e.getMessage(), e);
        }

        LambdaLogger.info(log, "流水号:{} >> 归集账户提现响应报文：->{}", serverTransId, JSON.toJSONString(respClientDTO));
        return respClientDTO;

    }

    private CollectionAccountWithdrawRespDTO buildRespClientDTO(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext, Throwable e) {
        CollectionAccountWithdrawRespDTO clientResp = manageContext.getResponseDTO();
        Optional<ChannelResponseDTO> channelResponseDTOOptional = Optional.ofNullable(manageContext.getChannelResponseDTO());

        channelResponseDTOOptional.ifPresent(cResDTO -> {
            clientResp.setStatus(cResDTO.getStatus());
            clientResp.setException(cResDTO.getException());
            clientResp.setMessage(cResDTO.getMessage());
        });

        if (e != null) {
            if (e instanceof ManageException) {
                ManageException te = (ManageException) e;
                clientResp.setStatus(String.valueOf(te.getStatus()));
                clientResp.setMessage(te.getMessage());
                clientResp.setException(te.getException());
            } else {
                clientResp.setStatus(String.valueOf(HttpRespStatus.SERVER_ERROR.value()));
                clientResp.setMessage(e.getMessage());
                clientResp.setException(e.getClass().getName());
            }
        }
        if (StringUtil.isNotBlank(clientResp.getException())) {
            clientResp.setException(StringUtil.truncate(clientResp.getException(), 150));
        }
        if (StringUtil.isNotBlank(clientResp.getMessage())) {
            clientResp.setMessage(StringUtil.truncate(clientResp.getMessage(), 150));
        }
        if (StringUtil.isBlank(clientResp.getMessage())) {
            if (StringUtil.isBlank(clientResp.getException())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(clientResp.getStatus()));
                if (httpRespStatus.is2xxSuccessful()) {
                    clientResp.setMessage("交易成功");
                }
            } else {
                clientResp.setMessage(clientResp.getException());
            }
        }
        clientResp.setTimestamp(DateUtil.getCurrentDate(DateUtil.FORMAT_TIMESTAMP));
        clientResp.setTransStatus(manageContext.getTransStatus());
        clientResp.setTransDesc(clientResp.getMessage());
        manageContext.setResponseDTO(clientResp);
        return clientResp;
    }


    public ChannelResponseDTO reqChannel(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {

        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();
        CollectAccountWithdraw collectAccountWithdraw = manageContext.getAttribute(COLLECT_ACCOUNT_WITHDRAW);

        //调用渠道转账
        CollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        oneBankTransferReq.setClientTradeId(manageContext.getServerTransId());
        oneBankTransferReq.setTradeDate(reqDTO.getReqDate());
        oneBankTransferReq.setTradeTime(reqDTO.getReqTime());
        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        //请求日期
        oneBankTransferReqContent.setReqDate(reqDTO.getReqDate());
        //请求时间
        oneBankTransferReqContent.setReqTime(reqDTO.getReqTime());
        //卡类型
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //收款人账号
        oneBankTransferReqContent.setPayeeAcctNo(collectAccountWithdraw.getReciveAccountNo());
        //收款人名称
        oneBankTransferReqContent.setPayeeName(collectAccountWithdraw.getReciveAccountName());
        //收款人清算行行号
        oneBankTransferReqContent.setPayeeOpbk(collectAccountWithdraw.getReciveClBankCode());
        //收款人开户行号
        oneBankTransferReqContent.setPayeeSubBank(collectAccountWithdraw.getReciveOpBankCode());

        //真实付款账户，注：华通那边反过来用
        String realPayerAcctNo = collectAccountWithdraw.getFundAccountNo();
        String realPayerName = collectAccountWithdraw.getFundAccountName();
        String payerAcctNo = realPayerAcctNo;
        String payerName = realPayerName;
        oneBankTransferReqContent.setRealpayerAcctNo(realPayerAcctNo);
        oneBankTransferReqContent.setRealpayerName(realPayerName);
        //备注附言
        oneBankTransferReqContent.setRemark("归集账户提现");

        //付款人账号
        oneBankTransferReq.setAcctNo(payerAcctNo);
        oneBankTransferReq.setAcctType(payerAccountInfo.getSysHeaderAcctType());
        //账户类型
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());
        //付款人账号
        oneBankTransferReqContent.setPayerAcctNo(payerAcctNo);
        //付款人名称
        oneBankTransferReqContent.setPayerName(payerName);
        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //付款人开户行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());

        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(reqDTO.getTransAmount());
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        //交易金额
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        //冻结付款者转账金额

        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(reqDTO.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(reqDTO.getAccount()).amount(reqDTO.getTransAmount())
                .peerAccNo(collectAccountWithdraw.getReciveAccountNo()).peerAccName(collectAccountWithdraw.getReciveAccountName())
                .serverTransId(manageContext.getServerTransId()).remark("冻结归集账户提现金额")
                .build());
        try {
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = channelTradeService(oneBankTransferReq, oneBankTransferReqContent, manageContext);
            } catch (RetryableException e) {
                LambdaLogger.error(log, "流水号:{} >> 调用转账渠道异常:{}", manageContext.getServerTransId(), e.getMessage(), e);
                channelResponseDTO = new ChannelResponseDTO();
                channelResponseDTO.setServerTransId(manageContext.getServerTransId());
                channelResponseDTO.setStatus(HttpRespStatus.MULTIPLE_CHOICES.valueStr());
                channelResponseDTO.setMessage("渠道超时或其他错误,状态未知。");
                channelResponseDTO.setException(e.getMessage());
                return channelResponseDTO;
            }
            try {
                if (channelResponseDTO != null) {
                    HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(channelResponseDTO.getStatus()));
                    if (!(httpRespStatus.is2xxSuccessful() || httpRespStatus.is3xxRedirection())) {
                        this.forback(manageContext);
                    }
                }
            } catch (Exception e) {
                LambdaLogger.error(log, "流水号:{} >> 渠道返回[httpRespStatus={}],恢复归集账户提现冻结金额异常:{}", manageContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.forback(manageContext);
            } catch (Exception fe) {
                LambdaLogger.error(log, "流水号:{} >> 交易异常:{} {} 恢复归集账户提现冻结金额异常:{}", manageContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }

    private ChannelResponseDTO channelTradeService(OneBankTransferReq oneBankTransferReq, OneBankTransferReqContent oneBankTransferReqContent, ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {
        FundAccType payerFundAccType = manageContext.getAttribute(PAYER_FUNDACC_TYPE);
        //接口路由选择
        oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.HT_ROUTE.getFlag());
        oneBankTransferReqContent.setPayRouteCode(null);
        //归集账户提现 收款账户规定未对公户
        oneBankTransferReqContent.setPc_flag(HTPcFlag.PUBLIC.getFlag());
        oneBankTransferReq.setFundAccType(payerFundAccType);
        oneBankTransferReq.setContent(oneBankTransferReqContent);
        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            LambdaLogger.info(log, "流水号:{} >> 调用RDFA转账渠道请求报文:{}", manageContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePivate(oneBankTransferReq);
            LambdaLogger.info(log, "流水号:{} >> 调用RDFA转账渠道响应报文:{}", manageContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            LambdaLogger.info(log, "流水号:{} >> 调用CDFA转账渠道请求报文:{}", manageContext.getServerTransId(), JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePublic(oneBankTransferReq);
            LambdaLogger.info(log, "流水号:{} >> 调用CDFA转账渠道响应报文:{}", manageContext.getServerTransId(), JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else {
            throw new ManageException(HttpRespStatus.FORBIDDEN, String.format("资金账户类型[%s]暂未支持", payerFundAccType));
        }
    }

    private void forback(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {
        CollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        CollectAccountWithdraw collectAccountWithdraw = manageContext.getAttribute(COLLECT_ACCOUNT_WITHDRAW);
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(reqDTO.getIndustryCode())
                .accountOperSubType(AccountOperSubType.PAYMENT).userAccount(reqDTO.getAccount()).amount(reqDTO.getTransAmount())
                .peerAccNo(collectAccountWithdraw.getReciveAccountNo()).peerAccName(collectAccountWithdraw.getReciveAccountName())
                .serverTransId(manageContext.getServerTransId()).remark("恢复归集账户提现冻结金额")
                .build());
    }


    public void initTransFlow(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {
        CollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        Industry collectionIndustry = manageContext.getAttribute(COLLECTION_INDUSTRY);
        CollectAccountWithdraw collectAccountWithdraw = manageContext.getAttribute(COLLECT_ACCOUNT_WITHDRAW);
        String payeeAccType = manageContext.getAttribute(PAYEE_ACC_TYPE);

        List<TransCurrent> transCurrentList = Lists.newArrayList();
        TransCurrent transCurrent = TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(manageContext.getClientTransId())
                .clientTransTime(manageContext.getReqDate() + manageContext.getReqTime())
                .currency("CNY")
                .orgCode(collectionIndustry.getOrgCode())
                .orgName(collectionIndustry.getOrgName())
                .serverTransId(manageContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.COLLECT_ACCOUNT_WITHDRAW.getCode())
                .transAmount(reqDTO.getTransAmount())
                .transCallbackUrl(InnerCallBackUrl.COLLECT_ACCOUNT_WITHDRAW.getUrl())
                .transDate(reqDTO.getReqDate())
                .transTime(reqDTO.getReqTime())
                .merNo(null)
                .accNo(collectAccountWithdraw.getFundAccountNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(reqDTO.getTransAmount())
                .pcFlag(payeeAccType)
                .payerAcctNo(collectAccountWithdraw.getFundAccountNo())
                .payerName(collectAccountWithdraw.getFundAccountName())
                .payeeAcctNo(collectAccountWithdraw.getReciveAccountNo())
                .payeeName(collectAccountWithdraw.getReciveAccountName())
                .industryCode(reqDTO.getIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .payerOpbkName(CommonConstants.payerOpbkName)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(reqDTO.getAccount())
                .payeeAccount(null)
                .feeAccount(null)
                .incomeAccount(null)
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(collectionIndustry.getAccount())
                .showPayerAccountName(collectionIndustry.getName())
                .showPayeeAccountNo(collectAccountWithdraw.getReciveAccountNo())
                .showPayeeAccountName(collectAccountWithdraw.getReciveAccountName())
                .elcMakeFlag(ElcMakeFlag.UN_MAKE.getFlag())
                .feeAccountName(null)
                .incomeAccountName(null)
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(collectAccountWithdraw.getReciveOpBankName())
                .summaryDescription(String.format("归集账户提现:%s", "备注"))
                .build();
        transCurrentList.add(transCurrent);
        transCurrentHandler.saveTransCurrent(transCurrentList);

        //同步更新归集账户提现表状态
        CollectAccountWithdrawVo collectAccountWithdrawVo = CollectAccountWithdrawVo.builder()
                .industryCode(transCurrent.getIndustryCode()).clientTransId(transCurrent.getClientTransId()).gmtModified(new Date())
                .transStatus(transCurrent.getTransStatus()).transDesc("处理中").serverTransId(transCurrent.getServerTransId()).build();

        collectAccountWithdrawHandler.updateByIndustryCodeAndClientTransId(collectAccountWithdrawVo);
    }

    public void updateTransFlow(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {
        ChannelResponseDTO channelResponse = manageContext.getChannelResponseDTO();
        CollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        CollectionAccountWithdrawRespDTO respDTO = manageContext.getResponseDTO();
        String transStatus = manageContext.getTransStatus();
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.industryCode(reqDTO.getIndustryCode());
        builder.serverTransId(manageContext.getServerTransId());
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
        TransCurrent transCurrent = builder.build();
        transCurrentHandler.updateByIndustryCodeAndServerTransId(transCurrent, reqDTO.getIndustryCode(), manageContext.getServerTransId());

        //同步更新归集账户提现表状态
        CollectAccountWithdrawVo collectAccountWithdrawVo = CollectAccountWithdrawVo.builder()
                .industryCode(transCurrent.getIndustryCode()).clientTransId(manageContext.getClientTransId()).gmtModified(new Date())
                .transStatus(transCurrent.getTransStatus()).transDesc(String.format("%s[%s]", transCurrent.getRespCode(), transCurrent.getRespMessage())).serverTransId(transCurrent.getServerTransId()).build();

        collectAccountWithdrawHandler.updateByIndustryCodeAndClientTransId(collectAccountWithdrawVo);

    }


    protected void verifyReqParam(ManageContext<CollectionAccountWithdrawReqDTO, CollectionAccountWithdrawRespDTO> manageContext) {
        CollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();

        if (!SHA1.genWithAmple(reqDTO.toSHA1()).equals(reqDTO.getSign())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }

        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(reqDTO.getReqDate())) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        }
        CollectAccountWithdraw collectAccountWithdraw = collectAccountWithdrawHandler.getById(reqDTO.getId());
        if (collectAccountWithdraw == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("查无此关联id[%s]的归集提现记录", reqDTO.getId()));
        }
        if (!reqDTO.getClientTransId().equals(collectAccountWithdraw.getClientTransId()) ||
                !reqDTO.getReqDate().equals(collectAccountWithdraw.getReqDate()) ||
                !reqDTO.getReqTime().equals(collectAccountWithdraw.getReqTime()) ||
                !reqDTO.getAccount().equals(collectAccountWithdraw.getAccount()) ||
                !reqDTO.getIndustryCode().equals(collectAccountWithdraw.getIndustryCode()) ||
                reqDTO.getTransAmount().longValue() != reqDTO.getTransAmount()
        ) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("归集提现申请记录id[%s]信息与请求参数未完全匹配", reqDTO.getId()));
        }

        LambdaLogger.info(log, "流水号:{} >> 归集提现申请记录信息:{}", manageContext.getServerTransId(), JSON.toJSONString(collectAccountWithdraw));

        ValidateUtils.notSpecialStr(collectAccountWithdraw.getReciveAccountNo(), true, "收款账户");
        ValidateUtils.maxLength(collectAccountWithdraw.getReciveAccountNo(), 32, true, "收款账户");
        ValidateUtils.notSpecialStr(collectAccountWithdraw.getReciveAccountName(), true, "收款账户名称");
        ValidateUtils.maxLength(collectAccountWithdraw.getReciveAccountName(), 100, true, "收款账户名称");

        ValidateUtils.notSpecialStr(collectAccountWithdraw.getReciveClBankCode(), true, "收款方清算行号");
        ValidateUtils.maxLength(collectAccountWithdraw.getReciveClBankCode(), 20, true, "收款方清算行号");
        ValidateUtils.notSpecialStr(collectAccountWithdraw.getReciveOpBankCode(), true, "收款方开户行号");
        ValidateUtils.maxLength(collectAccountWithdraw.getReciveOpBankCode(), 32, true, "收款方开户行号");
        ValidateUtils.notSpecialStr(collectAccountWithdraw.getReciveOpBankName(), true, "收款方开户行名称");
        ValidateUtils.maxLength(collectAccountWithdraw.getReciveOpBankName(), 100, true, "收款方开户行名称");

        long payAmtLong = reqDTO.getTransAmount();
        if (payAmtLong <= 0) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "交易金额须大于零的整数!");
        }
        if (String.valueOf(payAmtLong).length() > 15) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "交易金额超出范围!");
        }
        //交易客户端流水不能重复
        boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(reqDTO.getIndustryCode(), reqDTO.getClientTransId(), null);
        if (existClientId) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }

        FundAccount fundAccount = fundAccountHandler.getByFundAccountNo(collectAccountWithdraw.getFundAccountNo());
        if (fundAccount == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("查无此资金账户[%s]信息", collectAccountWithdraw.getFundAccountNo()));
        }
        Industry industry = industryHandler.getIndustryByCode(reqDTO.getIndustryCode());
        if (industry == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, String.format("查无此归集客户号[%s]信息", reqDTO.getIndustryCode()));
        }

        //归集账户 提现 业务规定 仅支持对公卡交易
        String payeeAccType = AccountType.PUBLIC.getCode();
        manageContext.setAttribute(PAYER_FUNDACC_TYPE, FundAccType.resolve(fundAccount.getAccountType()));
        manageContext.setAttribute(PAYEE_ACC_TYPE, payeeAccType);
        manageContext.setAttribute(COLLECTION_INDUSTRY, industry);
        manageContext.setAttribute(COLLECT_ACCOUNT_WITHDRAW, collectAccountWithdraw);

    }


}
