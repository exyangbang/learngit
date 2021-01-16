package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountOrderLogHandler;
import cn.kingnet.utp.service.persistence.api.IBankAccountTransDetailHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IChannelRelevantHandler;
import cn.kingnet.utp.service.persistence.entity.AccountOrderLog;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.FreezeOrderIdReqDTO;
import cn.kingnet.utp.trade.common.dto.account.FreezeOrderIdRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;

import javax.annotation.Resource;

/**
 * @Description 订单金额冻结
 * @Author WJH
 * @Date 2018年11月23日
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.FREEZE_ORDERID,
        reqClass = FreezeOrderIdReqDTO.class,
        respClass = FreezeOrderIdRespDTO.class
)
public class FreezeOrderIdService extends AbstractAccountTradeService<FreezeOrderIdReqDTO, FreezeOrderIdRespDTO> {

    @Resource
    private IBankAccountTransDetailHandler bankAccountTransDetailHandler;
    @Resource
    private IAccountOrderLogHandler iAccountOrderLogHandler;
    @Resource
    private IChannelRelevantHandler channelRelevantHandler;

    public FreezeOrderIdService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<FreezeOrderIdReqDTO, FreezeOrderIdRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        FreezeOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");

        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.isNum(reqDTO.getUserAccount(), true, "用户账户");

        ValidateUtils.maxLength(reqDTO.getOrderId(), 36, true, "订单号");
        ValidateUtils.notSpecialStr(reqDTO.getOrderId(), true, "订单号");

        ValidateUtils.isNum(reqDTO.getPayAmt(), true, "交易金额");
        ValidateUtils.maxLength(reqDTO.getPayAmt(), 15, true, "交易金额");
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

        ChannelInfoBO channelInfoBO = channelRelevantHandler.findChannelInfoBO(tradeContext.getAuthInfo().getAuthNo(), basicConfigInfo.getProductNo(), null);
        if (channelInfoBO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "代付客户号关联渠道未配置");
        }

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<FreezeOrderIdReqDTO, FreezeOrderIdRespDTO> tradeContext) {

        FreezeOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        FreezeOrderIdRespDTO.FreezeOrderIdRespDTOBuilder respDTOBuilder = FreezeOrderIdRespDTO.builder();
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        try {
            BankAccountTransDetail detail = bankAccountTransDetailHandler.queryByOrderId(reqDTO.getUserAccount(), reqDTO.getOrderId());
            if (detail == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此订单入金记录");
            }
            if (Long.valueOf(reqDTO.getPayAmt()).longValue() != detail.getTxnAmount().longValue()) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "交易金额不等于原订单金额");
            }
            AccountOrderStatus orderStatus = AccountOrderStatus.resolve(detail.getOrderStatus());
            if (orderStatus == null || orderStatus != AccountOrderStatus.INITTIALIZE) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("该订单状态%s,不能再冻结", orderStatus == null ? null : orderStatus.getDesc()));
            }
            AccountOrderLog.AccountOrderLogBuilder builder = AccountOrderLog.builder();
            builder.id(IdGenerate.getId()).clientTransId(tradeContext.getClientTradeId())
                    .serverTransId(tradeContext.getServerTransId()).remark("订单金额冻结")
                    .account(reqDTO.getUserAccount()).orderId(reqDTO.getOrderId()).amt(Long.valueOf(reqDTO.getPayAmt()))
                    .tradeType(TradeType.FREEZE_ORDERID.getCode()).transStatus(TransStatus.PRE_CREATE.name())
                    .transDate(DateUtil.getCurrentDate()).transTime(DateUtil.getCurrentTime())
                    .gmtCreate(DateUtil.getSystemDate());
            iAccountOrderLogHandler.saveAccountOrderLog(builder.build().buildVo());

            this.accountHandler.freezeAccountBalance(AccountOperBo.builder().industryCode(basicConfigInfo.getIndustryCode())
                    .accountOperSubType(AccountOperSubType.ORDER_INCOME).userAccount(reqDTO.getUserAccount()).amount(Long.valueOf(reqDTO.getPayAmt()))
                    .peerAccNo(detail.getOtherCustAccountNo()).peerAccName(detail.getOtherCustName()).remark("订单金额冻结")
                    .serverTransId(tradeContext.getServerTransId()).outsideOrderId(detail.getSysReferenceNo())
                    .build()
            );
            bankAccountTransDetailHandler.updateOrderStatusByOrderId(reqDTO.getUserAccount(), reqDTO.getOrderId(), AccountOrderStatus.FREEZED.getCode());

            builder.transStatus(TransStatus.TRADE_SUCCESS.name()).gmtModified(DateUtil.getSystemDate());
            iAccountOrderLogHandler.updateAccountOrderLog(builder.build().buildVo());

        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "订单金额冻结异常:" + StringUtil.truncate(e.getMessage(), 200), e);
        }
        return ChannelResponseUtil.success(respDTOBuilder.build(), null, null);
    }


    @Override
    public void initTransFlow(TradeContext<FreezeOrderIdReqDTO, FreezeOrderIdRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<FreezeOrderIdReqDTO, FreezeOrderIdRespDTO> tradeContext) {

    }


}
