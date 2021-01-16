package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.dto.manage.ManageContext;
import cn.kingnet.utp.product.common.dto.manage.QueryCollectionAccountWithdrawReqDTO;
import cn.kingnet.utp.product.common.dto.manage.QueryCollectionAccountWithdrawRespDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.CollectAccountWithdraw;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryReqDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * @Description : 后管查询交易结果
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 11:31
 */
@Service
@Slf4j
public class QueryCollectAccountWithdrawService {

    @Resource
    private ITransCurrentHandler transCurrentHandler;

    @Resource
    private ITransHistoryHandler transHistoryHandler;

    @Resource
    private IPaymentService paymentService;

    @Resource
    private IProcessTransHandler processTransHandler;
    @Resource
    private ServerIdGenerate serverIdGenerate;
    @Resource
    private ICollectAccountWithdrawHandler collectAccountWithdrawHandler;
    @Resource
    private IFundAccountHandler fundAccountHandler;

    private UtpConfigProperties utpConfigProperties;
    private ProductAccountProperties productAccountProperties;

    protected static final String COLLECT_ACCOUNT_WITHDRAW = "COLLECT_ACCOUNT_WITHDRAW";

    public QueryCollectAccountWithdrawService(UtpConfigProperties utpConfigProperties, ProductAccountProperties productAccountProperties) {
        this.utpConfigProperties = utpConfigProperties;
        this.productAccountProperties = productAccountProperties;
    }

    public QueryCollectionAccountWithdrawRespDTO doService(QueryCollectionAccountWithdrawReqDTO reqDTO) {
        final QueryCollectionAccountWithdrawRespDTO respClientDTO = new QueryCollectionAccountWithdrawRespDTO();
        final String serverTransId = serverIdGenerate.generateServerTransId();
        LambdaLogger.info(log, "流水号:{} >> 后管归集账户提现结果查询服务", serverTransId);
        LambdaLogger.info(log, "流水号:{} >> 后管请求报文：->{}", serverTransId, JSON.toJSONString(reqDTO));
        respClientDTO.setClientTransId(reqDTO.getClientTransId());
        respClientDTO.setServerTransId(serverTransId);
        respClientDTO.setIndustryCode(reqDTO.getIndustryCode());
        respClientDTO.setOrigClientTradeId(reqDTO.getOrigClientTradeId());

        //1.构造整个服务上下文参数
        ManageContext<QueryCollectionAccountWithdrawReqDTO, QueryCollectionAccountWithdrawRespDTO> manageContext =
                new ManageContext(serverTransId, reqDTO.getClientTransId(), reqDTO.getReqDate(), reqDTO.getReqTime(), reqDTO);
        manageContext.setResponseDTO(respClientDTO);
        try {
            this.verifyReqParam(manageContext);
            try {
                ChannelResponseDTO channelResponseDTO = this.reqChannel(manageContext);
                manageContext.setChannelResponseDTO(channelResponseDTO);
                this.buildRespClientDTO(manageContext, null);
            } catch (Exception e) {
                this.buildRespClientDTO(manageContext, e);
                LambdaLogger.error(log, "流水号:{} >> 归集账户请求渠道异常:{}", serverTransId, e.getMessage(), e);
            }
        } catch (Exception e) {
            this.buildRespClientDTO(manageContext, e);
            LambdaLogger.error(log, "流水号:{} >> 归集账户提现结果查询异常:{}", serverTransId, e.getMessage(), e);
        }

        LambdaLogger.info(log, "流水号:{} >> 归集账户提现结果查询响应报文：->{}", serverTransId, JSON.toJSONString(manageContext.getResponseDTO()));
        return manageContext.getResponseDTO();

    }

    public ChannelResponseDTO reqChannel(ManageContext<QueryCollectionAccountWithdrawReqDTO, QueryCollectionAccountWithdrawRespDTO> manageContext) {
        QueryCollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        String reqDate = reqDTO.getReqDate();

        TransCurrent transCurrent = transCurrentHandler.getByIndustryAndClientTransIdOrServerTransId(reqDTO.getIndustryCode(), reqDTO.getOrigClientTradeId(),null);
        if (transCurrent == null) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "查无此客户端流水号/服务端流水号交易记录");
        }
        if (!reqDate.equals(transCurrent.getTransDate())) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "找不到发出日期的交易记录!");
        }
        if (!ProductCode.ACCOUNT.name().equals(transCurrent.getProductCode())) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "查无此产品交易流水记录!");
        }
        String origClientTradeId = reqDTO.getOrigClientTradeId();
        String origServerTradeId = transCurrent.getServerTransId();
        String transStatus = transCurrent.getTransStatus();
        String statusDesc = StringUtil.isNotBlank(transCurrent.getChannelRespMsg()) ? transCurrent.getChannelRespMsg() : transCurrent.getRespMessage();
        statusDesc = convertStatusDesc(transStatus, transCurrent.getChannelRespCode(), statusDesc);
        long transId = transCurrent.getId();
        String reconcileDate = transCurrent.getChannelSettleDate();
        String needChannelReconcile = TrueOrFalseStatus.TRUE.value();;


        QueryCollectionAccountWithdrawRespDTO respDTO = manageContext.getResponseDTO();
        respDTO.setOrigClientTradeId(origClientTradeId);
        respDTO.setOrigServerTradeId(origServerTradeId);
        respDTO.setTransStatus(transStatus);
        respDTO.setTransDesc(statusDesc);
        respDTO.setReconcileDate(reconcileDate);

        if (TransStatus.TRADE_FAILURE.name().equals(transStatus) || TransStatus.TRADE_SUCCESS.name().equals(transStatus)) {//交易有最终状态
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (!TrueOrFalseStatus.TRUE.value().equals(needChannelReconcile)) {//无需调用华通的交易
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (transId < 1) {
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setTransDesc(String.format("代付客户[%s]:查无此源客户端流水/源服务端流水交易记录", reqDTO.getIndustryCode()));
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        }

        CollectAccountWithdraw collectAccountWithdraw = manageContext.getAttribute(COLLECT_ACCOUNT_WITHDRAW);
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();

        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }

        OneBankTransQueryReqDTO oneBankTransQueryReqDTO = new OneBankTransQueryReqDTO();
        oneBankTransQueryReqDTO.setAcctNo(collectAccountWithdraw.getFundAccountNo());
        oneBankTransQueryReqDTO.setAcctType(payerAccountInfo.getSysHeaderAcctType());
        oneBankTransQueryReqDTO.setClientTradeId(manageContext.getServerTransId());
        oneBankTransQueryReqDTO.setOrigServerTradeId(origServerTradeId);
        oneBankTransQueryReqDTO.setReqDate(reqDTO.getReqDate());
        oneBankTransQueryReqDTO.setTradeDate(manageContext.getReqDate());
        oneBankTransQueryReqDTO.setTradeTime(manageContext.getReqTime());
        oneBankTransQueryReqDTO.setPayTransType(HTPayTransType.TRANSFER.getType());
        FundAccount fundAccount = fundAccountHandler.getByFundAccountNo(collectAccountWithdraw.getFundAccountNo());
        FundAccType payerFundAccType = FundAccType.resolve(fundAccount.getAccountType());
        if (null == payerFundAccType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("归集客户归属资金账户类型[%s]错误", fundAccount.getAccountType()));
        }
        ChannelResponseDTO channelResponseDTO = null;
        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            channelResponseDTO = paymentService.privateTransQuery(oneBankTransQueryReqDTO);
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            channelResponseDTO = paymentService.publicTransQuery(oneBankTransQueryReqDTO);
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", fundAccount.getAccountType()));
        }

        if (channelResponseDTO == null || channelResponseDTO.getSpRespMsg() == null ||
                ObjectUtils.isEmpty(channelResponseDTO.getSpRespMsg().get("transStatus"))) {
            //查无渠道转换后的transStatus交易状态一律以当前库表查询状态返回
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        }

        if (channelResponseDTO != null) {
            Map<String, Object> spRespMsg = channelResponseDTO.getSpRespMsg();
            transStatus = (String) spRespMsg.get("transStatus");
            statusDesc = (String) spRespMsg.get("statusDesc");

            //原交易流水为非明确状态的 变更为 查询结果返回的明确状态
            String orgrespcode = (String) spRespMsg.get("orgrespcode");
            String orgrespmsg = (String) spRespMsg.get("orgrespmsg");
            String channelSettleDate = StringUtil.objTrimToEmpty(spRespMsg.get("settleDate"));

            updateTransStatusByQuery(transId, orgrespcode, orgrespmsg, transStatus, origServerTradeId, channelSettleDate);

            respDTO.setReconcileDate(channelSettleDate);
            respDTO.setTransStatus(transStatus);
            respDTO.setTransDesc(statusDesc);
            //设置渠道查询返回信息
            channelResponseDTO.setSpRespMsg(BeanMap.create(respDTO));
        } else {
            channelResponseDTO = new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        }
        return channelResponseDTO;
    }

    private String convertStatusDesc(String transStatus, String channelRespCode, String channelRespMsg) {
        channelRespMsg = OneBankRespCode.PCC00000.name().equals(channelRespCode) || StringUtil.isBlank(channelRespCode) ? "" : channelRespMsg;
        if (TransStatus.TRADE_SUCCESS.name().equals(transStatus)) {
            return "交易成功";
        }
        if (TransStatus.TRADE_FAILURE.name().equals(transStatus)) {
            return String.format("交易失败 %s", channelRespMsg);
        }
        if (TransStatus.PROCESSING.name().equals(transStatus)) {
            return "处理中";
        }
        if (TransStatus.TRADE_ERROR.name().equals(transStatus)) {
            return String.format("交易错误、不明确状态 %s", channelRespMsg);
        }
        return channelRespMsg;
    }


    /**
     * 原交易流水为非明确状态的 变更为 查询结果返回的明确状态
     *
     * @param transId
     * @param orgrespcode
     * @param orgrespmsg
     * @param transStatus
     * @param origServerTradeId
     */
    private void updateTransStatusByQuery(long transId, String orgrespcode, String orgrespmsg, String transStatus, String origServerTradeId, String channelSettleDate) {
        try {
            if (transId > 0 && StringUtil.isNotEmpty(origServerTradeId) && (
                    TransStatus.TRADE_SUCCESS.name().equals(transStatus) || TransStatus.TRADE_FAILURE.name().equals(transStatus))) {
                processTransHandler.onebankCallbackUpdate(transId, orgrespcode, orgrespmsg, transStatus, channelSettleDate);
            } else {
                LambdaLogger.warn(log, "原交易流水{} << 交易结果查询 渠道查询 返回状态[{}],暂无需变更状态.原渠道响应码[{}]-{} ", origServerTradeId, transStatus, orgrespcode, orgrespmsg);
            }
        } catch (Exception e) {
            LambdaLogger.error(log, "原交易流水{} << 交易结果查询 返回状态[{}],变更状态失败.原渠道响应码[{}]-{} ", origServerTradeId, transStatus, orgrespcode, orgrespmsg, e);
        }

    }

    protected void verifyReqParam(ManageContext<QueryCollectionAccountWithdrawReqDTO, QueryCollectionAccountWithdrawRespDTO> manageContext) {

        QueryCollectionAccountWithdrawReqDTO reqDTO = manageContext.getRequestDTO();
        ValidateUtils.notNull(reqDTO, "请求参数有误");

        if (!SHA1.genWithAmple(reqDTO.toSHA1()).equals(reqDTO.getSign())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
        }
        ValidateUtils.hasText(reqDTO.getIndustryCode(), "客户号不能为空");
        ValidateUtils.abcValid(reqDTO.getClientTransId(), true, "客户端流水号");
        ValidateUtils.maxLength(reqDTO.getClientTransId(), 32, true, "客户端流水号");

        ValidateUtils.abcValid(reqDTO.getOrigClientTradeId(), true, "源客户端流水号");
        ValidateUtils.maxLength(reqDTO.getOrigClientTradeId(), 32, true, "源客户端流水号");

        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");

        CollectAccountWithdraw collectAccountWithdraw = collectAccountWithdrawHandler.getByIndustryCodeAndClientTransId(reqDTO.getIndustryCode(), reqDTO.getOrigClientTradeId());
        if (collectAccountWithdraw == null) {
            throw new ManageException(HttpRespStatus.BAD_REQUEST, "查无此归集账户源客户端流水号提现记录");
        }
        manageContext.setAttribute(COLLECT_ACCOUNT_WITHDRAW, collectAccountWithdraw);

    }

    private QueryCollectionAccountWithdrawRespDTO buildRespClientDTO(ManageContext<QueryCollectionAccountWithdrawReqDTO, QueryCollectionAccountWithdrawRespDTO> manageContext, Throwable e) {
        QueryCollectionAccountWithdrawRespDTO clientResp = manageContext.getResponseDTO();
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

        manageContext.setResponseDTO(clientResp);
        return clientResp;
    }
}
