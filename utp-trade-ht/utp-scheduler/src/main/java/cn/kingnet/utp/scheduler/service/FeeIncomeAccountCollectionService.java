package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.AbstractManageTradeService;
import cn.kingnet.utp.scheduler.configuration.ProductAccountProperties;
import cn.kingnet.utp.scheduler.data.bo.FeeIncomeAndCollectionBO;
import cn.kingnet.utp.scheduler.data.dto.FeeIncomeAccountCollectionReqDTO;
import cn.kingnet.utp.scheduler.data.dto.FeeIncomeAccountCollectionRespDTO;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthCollection;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthStat;
import cn.kingnet.utp.scheduler.data.entity.TransCurrent;
import cn.kingnet.utp.scheduler.data.entity.TransCurrentCondition;
import cn.kingnet.utp.scheduler.data.mapper.FeeIncomeAccountMonthStatMapper;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.*;
import com.alibaba.fastjson.JSON;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 手续费账户归集划转及查询
 * @Author WJH
 * @Date 2019/08/13
 */
@Service
@Slf4j
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.FEE_COLLECTION_TRANSFER,
        reqClass = FeeIncomeAccountCollectionReqDTO.class,
        respClass = FeeIncomeAccountCollectionRespDTO.class,
        createTransFlow = true,
        isManageService = true,
        successTransStatus = TransStatus.PROCESSING
)
public class FeeIncomeAccountCollectionService extends AbstractManageTradeService<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> {

    @Resource
    private ProductAccountProperties productAccountProperties;
    @Resource
    private IPaymentService paymentService;

    @Resource
    private IAccountHandler accountHandler;

    @Resource
    private RedisTemplate redisTemplate;

    public FeeIncomeAccountCollectionService(UtpConfigProperties utpConfigProperties, ServerIdGenerate serverIdGenerate) {
        super(utpConfigProperties, serverIdGenerate);
    }

    public FeeIncomeAndCollectionBO selectFeeIncomeAndCollectionBO(String incomeFeeAccount) {
        Map<String, Object> params = new HashMap<>(4);
        params.put("incomeFeeAccount", incomeFeeAccount);
        List<FeeIncomeAndCollectionBO> list = MybatisDaoImpl.of(FeeIncomeAccountMonthStatMapper.class).selectListBySql("selectFeeIncomeAndCollectionBO", params);
        if (CollectionUtils.isEmpty(list)) {
            throw new PersistenceException(HttpRespStatus.NOT_FOUND, String.format("查无此收益账户[%s]关联的归集账户信息", incomeFeeAccount));
        }
        if (list.size() != 1) {
            throw new PersistenceException(HttpRespStatus.NOT_FOUND, String.format("查到此收益账户[%s]关联到多个[%s]归集账户信息", incomeFeeAccount, list.size()));
        }
        return list.get(0);
    }

    public void validParams(FeeIncomeAccountMonthStat feeIncomeAccountMonthStat) {
        if (feeIncomeAccountMonthStat == null) {
            throw new RuntimeException("feeIncomeAccountMonthStat归集划转参数不能为空");
        }
        if (feeIncomeAccountMonthStat.getId() == null || feeIncomeAccountMonthStat.getId() <= 0
                || StringUtil.isEmpty(feeIncomeAccountMonthStat.getAccount())
                || StringUtil.isEmpty(feeIncomeAccountMonthStat.getStatMonth())
        ) {
            throw new RuntimeException(String.format("归集划转入参有误。入参:%s", JSON.toJSONString(feeIncomeAccountMonthStat)));
        }
    }

    public FeeIncomeAccountCollectionRespDTO doService(long feeStatId) {
        FeeIncomeAccountMonthStat feeIncomeAccountMonthStat = MybatisDaoImpl.run().selectById(FeeIncomeAccountMonthStat.class, feeStatId);
        if (feeIncomeAccountMonthStat == null) {
            throw new SchedulerException(HttpRespStatus.BAD_REQUEST, "查无此入参：feeStatId归集统计记录");
        }
        return doService(feeIncomeAccountMonthStat);
    }

    public FeeIncomeAccountCollectionRespDTO doService(FeeIncomeAccountMonthStat feeIncomeAccountMonthStat) {
        FeeIncomeAccountCollectionRespDTO respDTO = FeeIncomeAccountCollectionRespDTO.builder()
                .statMonth(feeIncomeAccountMonthStat.getStatMonth()).account(feeIncomeAccountMonthStat.getAccount())
                .transAmount(feeIncomeAccountMonthStat.getIncomeAmount() - feeIncomeAccountMonthStat.getOutcomeAmount()).build();
        String clientTransId = serverIdGenerate.generateClientTransId();
        if (CollectionStatus.COLLECTED.getStatus().equals(feeIncomeAccountMonthStat.getCollectionStatus()) || TransStatus.TRADE_SUCCESS.name().equals(feeIncomeAccountMonthStat.getTransStatus())) {
            throw new RuntimeException(String.format("月份[%s]收益账户[%s]已归集划转，不能再次发起划转", feeIncomeAccountMonthStat.getStatMonth(), feeIncomeAccountMonthStat.getAccount()));
        }
        if (TransStatus.PROCESSING.name().equals(feeIncomeAccountMonthStat.getTransStatus())) {
            throw new RuntimeException(String.format("月份[%s]收益账户[%s]归集划转处理中，暂不能再次发起划转", feeIncomeAccountMonthStat.getStatMonth(), feeIncomeAccountMonthStat.getAccount()));
        }
        long transAmount = feeIncomeAccountMonthStat.getIncomeAmount() - feeIncomeAccountMonthStat.getOutcomeAmount();
        if (transAmount <= 0) {
            feeIncomeAccountMonthStat.setRemark(String.format("需人工介入核查：当前归集划转金额[%s]小于等于0,无实际归集划转需人工核查状态", transAmount));
            feeIncomeAccountMonthStat.setCollectionStatus(CollectionStatus.MANUAL_CHECK.getStatus());
            feeIncomeAccountMonthStat.setTransStatus(TransStatus.TRADE_FAILURE.name());
            feeIncomeAccountMonthStat.setTransDesc(feeIncomeAccountMonthStat.getRemark());
            feeIncomeAccountMonthStat.setGmtModified(new Date());
            MybatisDaoImpl.run().updateById(feeIncomeAccountMonthStat);
            LambdaLogger.error(log, "需人工介入核查：当前归集划转金额[{}}]小于等于0,无实际归集划转标记需人工核查状态", transAmount);
            respDTO.setMessage(feeIncomeAccountMonthStat.getRemark());
            respDTO.setStatus(HttpRespStatus.BAD_REQUEST.toString());
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setTransDesc(respDTO.getMessage());
            return respDTO;
        }
        FeeIncomeAccountCollectionReqDTO reqDTO;
        try {
            validParams(feeIncomeAccountMonthStat);
            reqDTO = buildReqDTO(feeIncomeAccountMonthStat, clientTransId);
        } catch (Exception e) {
            feeIncomeAccountMonthStat.setRemark(String.format("收益账户归集划转参数错误:%s", e.getMessage()));
            feeIncomeAccountMonthStat.setTransStatus(TransStatus.TRADE_FAILURE.name());
            feeIncomeAccountMonthStat.setTransDesc(feeIncomeAccountMonthStat.getRemark());
            feeIncomeAccountMonthStat.setGmtModified(new Date());
            MybatisDaoImpl.run().updateById(feeIncomeAccountMonthStat);

            LambdaLogger.error(log, "收益账户归集划转参数错误：{}", e.getMessage(), e);
            respDTO.setException(e.getMessage());
            respDTO.setMessage(e.getMessage());
            respDTO.setStatus(HttpRespStatus.BAD_REQUEST.toString());
            respDTO.setTransStatus(TransStatus.TRADE_FAILURE.name());
            respDTO.setTransDesc(feeIncomeAccountMonthStat.getTransDesc());
            return respDTO;
        }
        return this.doService(reqDTO);
    }

    private FeeIncomeAccountCollectionReqDTO buildReqDTO(FeeIncomeAccountMonthStat feeIncomeAccountMonthStat, String clientTransId) {
        //1.查询手续费收益账户及对应的归集账户的 资金账户关联信息
        String feeIncomeAccount = feeIncomeAccountMonthStat.getAccount();
        FeeIncomeAndCollectionBO feeIncomeAndCollectionBO = selectFeeIncomeAndCollectionBO(feeIncomeAccount);

        FeeIncomeAccountCollectionReqDTO reqDTO = new FeeIncomeAccountCollectionReqDTO();
        BeanUtils.copyProperties(feeIncomeAndCollectionBO, reqDTO);
        reqDTO.setAccount(feeIncomeAccountMonthStat.getAccount());
        reqDTO.setStatMonth(feeIncomeAccountMonthStat.getStatMonth());
        reqDTO.setTransAmount(feeIncomeAccountMonthStat.getIncomeAmount() - feeIncomeAccountMonthStat.getOutcomeAmount());
        reqDTO.setClientTradeId(clientTransId);
        reqDTO.setFeeStatId(feeIncomeAccountMonthStat.getId());

        return reqDTO;
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> tradeContext) {
        FeeIncomeAccountCollectionReqDTO reqDTO = tradeContext.getRequestDTO();
        OneBankTransferReq oneBankTransferReq = buildTransferReq(tradeContext);

        accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(reqDTO.getFeeIndustryCode())
                .accountOperSubType(AccountOperSubType.COLLECTION).userAccount(reqDTO.getFeeIndustryAccount()).amount(reqDTO.getTransAmount())
                .peerAccNo(reqDTO.getCollectionFundAccNo()).peerAccName(reqDTO.getCollectionFundAccName())
                .serverTransId(tradeContext.getServerTransId()).remark(String.format("冻结%s月份收益账户归集划转金额",reqDTO.getStatMonth()))
                .build());

        try {
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = channelTradeService(oneBankTransferReq);
            } catch (RetryableException e) {
                LambdaLogger.error(log, "流水号:{} >> 调用转账渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
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
                        this.forback(tradeContext);
                    }
                }
            } catch (Exception e) {
                LambdaLogger.error(log, "流水号:{} >> 渠道返回[httpRespStatus={}],恢复收益账户归集划转冻结金额异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } catch (Exception e) {
            try {
                this.forback(tradeContext);
            } catch (Exception fe) {
                LambdaLogger.error(log, "流水号:{} >> 交易异常:{} {} 恢复收益账户归集划转冻结金额异常:{}", tradeContext.getServerTransId(), e.getMessage(), e, fe.getMessage(), fe);
            }
            throw e;
        }
    }


    private void forback(TradeContext<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> tradeContext) {
        FeeIncomeAccountCollectionReqDTO reqDTO = tradeContext.getRequestDTO();
        accountHandler.unfreezeAccountBalance(AccountOperBo.builder().industryCode(reqDTO.getFeeIndustryCode())
                .accountOperSubType(AccountOperSubType.COLLECTION).userAccount(reqDTO.getFeeIndustryAccount()).amount(reqDTO.getTransAmount())
                .peerAccNo(reqDTO.getCollectionFundAccNo()).peerAccName(reqDTO.getCollectionFundAccName())
                .serverTransId(tradeContext.getServerTransId()).remark(String.format("恢复%s月份收益账户归集划转金额",reqDTO.getStatMonth()))
                .build());
    }


    private OneBankTransferReq buildTransferReq(TradeContext<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> tradeContext) {
        FeeIncomeAccountCollectionReqDTO reqDTO = tradeContext.getRequestDTO();
        long transAmount = reqDTO.getTransAmount();
        FundAccType payerFundAccType = FundAccType.resolve(reqDTO.getFeeFundAccType());
        ProductAccountProperties.PayerAccountInfo payerAccountInfo = productAccountProperties.getPublicAccount();
        OneBankTransferReq oneBankTransferReq = new OneBankTransferReq();
        // 报文头
        oneBankTransferReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankTransferReq.setTradeDate(DateUtil.getCurrentDate());
        oneBankTransferReq.setTradeTime(DateUtil.getCurrentTime());
        oneBankTransferReq.setAcctType(this.productAccountProperties.getPublicAccount().getSysHeaderAcctType());
        oneBankTransferReq.setAcctNo(reqDTO.getFeeFundAccNo());

        //报文体
        OneBankTransferReqContent oneBankTransferReqContent = new OneBankTransferReqContent();
        //请求日期 yyyyMMdd
        oneBankTransferReqContent.setReqDate(oneBankTransferReq.getTradeDate());
        //请求时间 HHmmss
        oneBankTransferReqContent.setReqTime(oneBankTransferReq.getTradeTime());
        //卡类型 借记卡
        oneBankTransferReqContent.setCardType(HTCardType.D.name());
        //账户类型 银行卡
        oneBankTransferReqContent.setAcctType(payerAccountInfo.getAcctType());
        oneBankTransferReqContent.setPayerAcctNo(reqDTO.getFeeFundAccNo());
        oneBankTransferReqContent.setPayerName(reqDTO.getFeeFundAccName());
        //付款人清算行行号
        oneBankTransferReqContent.setPayerOpbk(payerAccountInfo.getPayerOpbk());
        //付款人开户行行号 没有开户行行号取值清算行行号
        oneBankTransferReqContent.setPayerSubBank(payerAccountInfo.getPayerOpbk());
        //实际付款账号
        oneBankTransferReqContent.setRealpayerAcctNo(reqDTO.getFeeFundAccNo());
        //实际付款户名
        oneBankTransferReqContent.setRealpayerName(reqDTO.getFeeFundAccName());

        //收款人账号
        oneBankTransferReqContent.setPayeeAcctNo(reqDTO.getCollectionFundAccNo());
        //收款人名称
        oneBankTransferReqContent.setPayeeName(reqDTO.getCollectionFundAccName());
        //收款人清算行行号 || 业务规定归集账户一定是在华通开通账户
        oneBankTransferReqContent.setPayeeOpbk(payerAccountInfo.getPayerOpbk());
        //收款人开户行号 || 业务规定归集账户一定是在华通开通账户
        oneBankTransferReqContent.setPayeeSubBank(payerAccountInfo.getPayerOpbk());

        //设置金额为元单位
        BigDecimal bigDecimal = new BigDecimal(transAmount);
        BigDecimal payAmtBigDecimal = MathUtil.divide(bigDecimal, new BigDecimal(100), 2);
        oneBankTransferReqContent.setAmount(payAmtBigDecimal.toString());
        //备注附言
        oneBankTransferReqContent.setRemark("手续费账户归集划转");
        //法人编号
        oneBankTransferReqContent.setPersonCode(CommonConstants.DEFAULT_HT_PERSON_CODE);


        //仅能走 行内智能路由
        oneBankTransferReqContent.setPayRouteFlag(HTPayRouteFlag.HT_ROUTE.getFlag());
        oneBankTransferReqContent.setPayRouteCode(null);
        //仅能走 人行大小额渠道
        oneBankTransferReq.setChannelKey(ChannelKey.HT_CKEY.getKey());
        //收款方为归集账户即其类型一定是对公户
        oneBankTransferReqContent.setPc_flag(HTPcFlag.PUBLIC.getFlag());
        oneBankTransferReq.setFundAccType(payerFundAccType);

        oneBankTransferReq.setContent(oneBankTransferReqContent);
        return oneBankTransferReq;
    }

    private ChannelResponseDTO channelTradeService(final OneBankTransferReq oneBankTransferReq) {
        FundAccType payerFundAccType = oneBankTransferReq.getFundAccType();
        final String serverTransId = oneBankTransferReq.getClientTradeId();
        //华通告知内部户一定是调用RDFA 异步对私
        if (FundAccType.INNER_ACC == payerFundAccType) {
            log.info("归集划转流水号:{} >> 调用RDFA转账渠道请求报文:{}", serverTransId, JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePivate(oneBankTransferReq);
            log.info("归集划转流水号:{} << 调用RDFA转账渠道响应报文:{}", serverTransId, JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else if (FundAccType.GENERAL_ACC == payerFundAccType) {
            log.info("归集划转流水号:{} >> 调用CDFA转账渠道请求报文:{}", serverTransId, JSON.toJSONString(oneBankTransferReq));
            ChannelResponseDTO channelResponseDTO = paymentService.tradePublic(oneBankTransferReq);
            log.info("归集划转流水号:{} << 调用CDFA转账渠道响应报文:{}", serverTransId, JSON.toJSONString(channelResponseDTO));
            return channelResponseDTO;
        } else {
            log.info("归集划转流水号:{} >> 资金账户类型暂未支持", serverTransId);
            throw new SchedulerException(HttpRespStatus.FORBIDDEN, "资金账户类型暂未支持");
        }


    }


    @Override
    public void initTransFlow(TradeContext<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> tradeContext) {
        FeeIncomeAccountCollectionReqDTO reqDTO = tradeContext.getRequestDTO();
        TransCurrent transCurrent = TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(serverIdGenerate.generateClientTransId())
                .clientTransTime(DateUtil.getFulltime())
                .currency("CNY")
                .orgCode(reqDTO.getFeeOrgCode())
                .orgName(reqDTO.getFeeOrgName())
                .serverTransId(tradeContext.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.FEE_COLLECTION_TRANSFER.getCode())
                .transAmount(reqDTO.getTransAmount())
                .transCallbackUrl(InnerCallBackUrl.FEE_COLLECTION_TRANSFER_CALLBACK.getUrl())
                .transDate(DateUtil.getCurrentDate())
                .transTime(DateUtil.getCurrentTime())
                .accNo(reqDTO.getFeeFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(reqDTO.getTransAmount())
                .pcFlag(AccountType.PUBLIC.getCode())
                .userType(AccountType.PUBLIC.getValue())
                .payerAcctNo(reqDTO.getFeeFundAccNo())
                .payerName(reqDTO.getFeeFundAccName())
                .payeeAcctNo(reqDTO.getCollectionFundAccNo())
                .payeeName(reqDTO.getCollectionFundAccName())
                .industryCode(reqDTO.getFeeIndustryCode())
                .transStatus(TransStatus.PROCESSING.name())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .splitInfoId(null)
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .orginChannelFee(0L)
                .payeeAccount(reqDTO.getCollectionIndustryAccount())
                .payerAccount(reqDTO.getFeeIndustryAccount())
                .feeAccount(null)
                .incomeAccount(null)
                .needChannelReconcile(TrueOrFalseStatus.TRUE.value())
                .showPayerAccountNo(reqDTO.getFeeFundAccNo())
                .showPayerAccountName(reqDTO.getFeeFundAccName())
                .showPayeeAccountNo(reqDTO.getCollectionFundAccNo())
                .showPayeeAccountName(reqDTO.getCollectionFundAccName())
                .elcMakeFlag(ElcMakeFlag.UN_MAKE.getFlag())
                .feeAccountName(null)
                .incomeAccountName(null)
                .summaryDescription(String.format("%s月份收益账户归集划转",reqDTO.getStatMonth()))
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .build();

        MybatisDaoImpl.run().insert(transCurrent);

        //赋值|更新表
        reqDTO.setTransId(transCurrent.getId());
        FeeIncomeAccountMonthCollection feeIncomeAccountMonthCollection = FeeIncomeAccountMonthCollection.builder()
                .id(IdGenerate.getId()).statMonth(reqDTO.getStatMonth()).feeStatId(reqDTO.getFeeStatId()).transId(reqDTO.getTransId()).build();
        MybatisDaoImpl.run().insert(feeIncomeAccountMonthCollection);

        FeeIncomeAccountMonthStat feeIncomeAccountMonthStat = FeeIncomeAccountMonthStat.builder()
                .id(reqDTO.getFeeStatId()).transStatus(transCurrent.getTransStatus()).transDesc(transCurrent.getRespMessage())
                .serverTransId(transCurrent.getServerTransId()).gmtModified(new Date()).build();
        MybatisDaoImpl.run().updateById(feeIncomeAccountMonthStat);

        this.setRedisTransIdHashField(transCurrent.getIndustryCode(), transCurrent.getClientTransId(), transCurrent.getServerTransId());
    }

    private static String genRedisTransIdHashKey(String industryCode, String transId) {
        return RedisKey.fmtKey(RedisKey.TRANS_ID, industryCode, String.valueOf(Math.abs(transId.hashCode()) % 1000));
    }
    private void setRedisTransIdHashField(String industryCode, String clientTransId, String serverTransId) {
        if (StringUtil.isBlank(industryCode)) {
            return;
        }
        if (StringUtil.isNotBlank(clientTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode,clientTransId)).putIfAbsent(clientTransId, serverTransId);
        }
        if (StringUtil.isNotBlank(serverTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode,serverTransId)).putIfAbsent(serverTransId, clientTransId);
        }
    }

    @Override
    public void updateTransFlow(TradeContext<FeeIncomeAccountCollectionReqDTO, FeeIncomeAccountCollectionRespDTO> tradeContext) {
        ChannelResponseDTO channelResponse = tradeContext.getChannelResponseDTO();
        FeeIncomeAccountCollectionReqDTO reqDTO = tradeContext.getRequestDTO();
        FeeIncomeAccountCollectionRespDTO respDTO = tradeContext.getResponseDTO();
        String transStatus = this.getTransStatus(tradeContext);
        TransCurrent.TransCurrentBuilder builder = TransCurrent.builder();
        builder.industryCode(reqDTO.getFeeIndustryCode());
        builder.serverTransId(tradeContext.getServerTransId());
        builder.transStatus(transStatus);
        if (respDTO != null) {
            builder.respCode(respDTO.getStatus())
                    .respException(respDTO.getException())
                    .respMessage("受理情况：" + respDTO.getMessage());
        }
        if (channelResponse != null) {
            builder.channelRespCode(channelResponse.getChannelRespCode())
                    .channelRespMsg(channelResponse.getMessage())
                    .channelRespId(channelResponse.getChannelRespId())
                    .channelRespTime(channelResponse.getTimestamp());
        }
        builder.gmtModified(new Date());
        TransCurrent transCurrent = builder.build();
        MybatisDaoImpl.run().update(transCurrent, TransCurrentCondition.builder().andIndustryCodeEq(reqDTO.getFeeIndustryCode()).andServerTransIdEq(tradeContext.getServerTransId()).build());

        //更新表
        FeeIncomeAccountMonthStat feeIncomeAccountMonthStat = FeeIncomeAccountMonthStat.builder()
                .id(reqDTO.getFeeStatId()).transStatus(transCurrent.getTransStatus()).transDesc(transCurrent.getRespMessage())
                .remark(transCurrent.getRespMessage())
                .serverTransId(transCurrent.getServerTransId()).gmtModified(new Date()).build();
        MybatisDaoImpl.run().updateById(feeIncomeAccountMonthStat);

    }


}
