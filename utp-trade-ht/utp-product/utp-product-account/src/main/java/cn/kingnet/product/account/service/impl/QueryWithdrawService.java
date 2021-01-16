package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IProcessTransHandler;
import cn.kingnet.utp.service.persistence.api.ITransCurrentHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryWithdrawRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryReqDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description : 提现结果查询接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 11:31
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_WITHDRAW,
        reqClass = QueryWithdrawReqDTO.class,
        respClass = QueryWithdrawRespDTO.class
)
public class QueryWithdrawService extends AbstractAccountTradeService<QueryWithdrawReqDTO, QueryWithdrawRespDTO> {

    @Resource
    private ITransCurrentHandler transCurrentHandler;

    @Resource
    private ITransHistoryHandler transHistoryHandler;

    @Resource
    private IPaymentService paymentService;

    @Resource
    private IProcessTransHandler processTransHandler;

    public QueryWithdrawService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryWithdrawReqDTO, QueryWithdrawRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        QueryWithdrawReqDTO queryWithdrawReqDTO = tradeContext.getRequestDTO();
        String reqDate = queryWithdrawReqDTO.getReqDate();

        TransCurrent transCurrent = transCurrentHandler.getByIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), queryWithdrawReqDTO.getOrigClientTradeId(), queryWithdrawReqDTO.getOrigServerTradeId());
        if (transCurrent == null) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "查无此客户端流水号/服务端流水号交易记录");
        }
        if (!reqDate.equals(transCurrent.getTransDate())) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "找不到发出日期的交易记录!");
        }
        if (!ProductCode.ACCOUNT.name().equals(transCurrent.getProductCode())) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "查无此产品交易流水记录!");
        }
        String origClientTradeId = transCurrent.getClientTransId();
        String origServerTradeId = transCurrent.getServerTransId();
        String transStatus = transCurrent.getTransStatus();
        String statusDesc = StringUtil.isNotBlank(transCurrent.getChannelRespMsg()) ? transCurrent.getChannelRespMsg() : transCurrent.getRespMessage();
        statusDesc = convertStatusDesc(transStatus, transCurrent.getChannelRespCode(), statusDesc);
        long transId = transCurrent.getId();
        String reconcileDate = transCurrent.getChannelSettleDate();
        String needChannelReconcile = transCurrent.getNeedChannelReconcile();


        QueryWithdrawRespDTO respDTO = new QueryWithdrawRespDTO();
        respDTO.setOrigClientTradeId(origClientTradeId);
        respDTO.setOrigServerTradeId(origServerTradeId);
        respDTO.setTransStatus(transStatus);
        respDTO.setServerTradeId(tradeContext.getServerTransId());
        respDTO.setClientTradeId(tradeContext.getClientTradeId());
        respDTO.setStatusDesc(statusDesc);
        respDTO.setReconcileDate(reconcileDate);
        respDTO.setFeeType(transCurrent.getMerSettleType());
        respDTO.setFeeModel(transCurrent.getMerChargeMode());
        respDTO.setFeeAmount(transCurrent.getMerFee()==null?"0":String.valueOf(transCurrent.getMerFee()));

        if (TransStatus.TRADE_FAILURE.name().equals(transStatus) || TransStatus.TRADE_SUCCESS.name().equals(transStatus)) {//交易有最终状态
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (!TrueOrFalseStatus.TRUE.value().equals(needChannelReconcile)) {//无需调用华通的交易
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (StringUtil.isBlank(origServerTradeId) && StringUtil.isNotBlank(queryWithdrawReqDTO.getOrigClientTradeId())) {
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setStatusDesc("源客户端流水号不存在");
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (StringUtil.isBlank(origServerTradeId)) {
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setStatusDesc("源服务端流水号不存在");
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        } else if (transId < 1) {
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setStatusDesc(String.format("代付客户[%s]:查无此源客户端流水/源服务端流水交易记录", tradeContext.getAuthInfo().getAuthNo()));
            return new ChannelResponseDTO(HttpRespStatus.OK.valueStr(), "查询成功", "", "", BeanMap.create(respDTO));
        }

        ProductAccountProperties.PayerAccountInfo payerAccountInfo = this.productAccountProperties.getPublicAccount();

        if (payerAccountInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "付款账户信息未配置!");
        }

        OneBankTransQueryReqDTO oneBankTransQueryReqDTO = new OneBankTransQueryReqDTO();
        oneBankTransQueryReqDTO.setAcctNo(basicConfigInfo.getCustAccountNo());
        oneBankTransQueryReqDTO.setAcctType(payerAccountInfo.getSysHeaderAcctType());
        oneBankTransQueryReqDTO.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransQueryReqDTO.setOrigServerTradeId(origServerTradeId);
        oneBankTransQueryReqDTO.setReqDate(queryWithdrawReqDTO.getReqDate());
        oneBankTransQueryReqDTO.setTradeDate(tradeContext.getTransDate());
        oneBankTransQueryReqDTO.setTradeTime(tradeContext.getTransTime());
        oneBankTransQueryReqDTO.setPayTransType(HTPayTransType.TRANSFER.getType());

        FundAccType payerFundAccType = FundAccType.resolve(basicConfigInfo.getFundAccType());
        if (null == payerFundAccType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("代付客户归属资金账户类型[%s]错误", basicConfigInfo.getFundAccType()));
        }
        ChannelResponseDTO channelResponseDTO = null;
        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            channelResponseDTO = paymentService.privateTransQuery(oneBankTransQueryReqDTO);
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            channelResponseDTO = paymentService.publicTransQuery(oneBankTransQueryReqDTO);
        } else {
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("%s资金账户类型暂未支持", basicConfigInfo.getFundAccType()));
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
            //合作商提出优化，若有异常，则异常一并随statusDesc
            respDTO.setStatusDesc(String.format("%s:%s",statusDesc,channelResponseDTO.getException()));
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
                logger.warn("原交易流水{} << 交易结果查询 渠道查询 返回状态[{}],暂无需变更状态.原渠道响应码[{}]-{} ", origServerTradeId, transStatus, orgrespcode, orgrespmsg);
            }
        } catch (Exception e) {
            logger.error("原交易流水{} << 交易结果查询 返回状态[{}],变更状态失败.原渠道响应码[{}]-{} ", origServerTradeId, transStatus, orgrespcode, orgrespmsg, e);
        }

    }

    @Override
    protected void verifyReqParam(TradeContext<QueryWithdrawReqDTO, QueryWithdrawRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryWithdrawReqDTO reqDTO = tradeContext.getRequestDTO();

        if (StringUtil.isBlank(reqDTO.getOrigClientTradeId()) && StringUtil.isBlank(reqDTO.getOrigServerTradeId())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "源客户端流水号或源服务端端流水号必填一项!");
        }
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "业务发出日期");

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryWithdrawReqDTO, QueryWithdrawRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryWithdrawReqDTO, QueryWithdrawRespDTO> tradeContext) {

    }
}
