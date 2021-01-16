package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBankAccountTransDetailHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IChannelRelevantHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.AccountDetail;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryUserAccountOrderIdReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryUserAccountOrderIdRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 账户入金查询
 * @Author WJH
 * @Date 2018年11月23日
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_USER_ACCOUNT_ORDERID,
        reqClass = QueryUserAccountOrderIdReqDTO.class,
        respClass = QueryUserAccountOrderIdRespDTO.class
)
public class QueryUserAccountOrderIdService extends AbstractAccountTradeService<QueryUserAccountOrderIdReqDTO, QueryUserAccountOrderIdRespDTO> {

    @Resource
    private IChannelRelevantHandler channelRelevantHandler;

    public QueryUserAccountOrderIdService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryUserAccountOrderIdReqDTO, QueryUserAccountOrderIdRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryUserAccountOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");

        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.isNum(reqDTO.getUserAccount(), true, "用户账户");

        ValidateUtils.maxLength(reqDTO.getOrderId(), 36, true, "订单号");
        ValidateUtils.notSpecialStr(reqDTO.getOrderId(), true, "订单号");


        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        //校验用户账户归属资金账户与当前资金账户是否一致
        if(!basicConfigInfo.getFundAccount().equals(basicConfigInfo.getUserFundAccount())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属资金账户与当前资金账户不一致!");
        }

        ChannelInfoBO channelInfoBO = channelRelevantHandler.findChannelInfoBO(tradeContext.getAuthInfo().getAuthNo(), basicConfigInfo.getProductNo(), null);
        if (channelInfoBO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "代付客户号关联渠道未配置");
        }

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryUserAccountOrderIdReqDTO, QueryUserAccountOrderIdRespDTO> tradeContext) {
        QueryUserAccountOrderIdReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryUserAccountOrderIdRespDTO.QueryUserAccountOrderIdRespDTOBuilder respDTOBuilder = QueryUserAccountOrderIdRespDTO.builder();
        respDTOBuilder.userAccount(reqDTO.getUserAccount());
        try {
            AccountDetail accountDetail = this.accountHandler.getAccountDetail4OrderIncome(reqDTO.getUserAccount(), reqDTO.getOrderId());
            if (accountDetail == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "暂查无此入金订单入账信息");
            }
            respDTOBuilder.userAccount(accountDetail.getAccount());
            respDTOBuilder.orderId(accountDetail.getOutsideOrderId());
            respDTOBuilder.payAmt(accountDetail.getAmount().toString());
            respDTOBuilder.serverTransId(tradeContext.getServerTransId());
            respDTOBuilder.transDate(DateUtil.formateDate(accountDetail.getRecordTime(), "yyyyMMdd"));
            respDTOBuilder.payerAccNo(accountDetail.getPeerAccNo());
            respDTOBuilder.payerAccName(accountDetail.getPeerAccName());

        } catch (TradeException e) {
            throw new TradeException(HttpRespStatus.NOT_ACCEPTABLE, e.getMessage(),e);
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "账户入金查询异常:"+e.getMessage(),e);
        }
        return ChannelResponseUtil.success(respDTOBuilder.build(), null, null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryUserAccountOrderIdReqDTO, QueryUserAccountOrderIdRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryUserAccountOrderIdReqDTO, QueryUserAccountOrderIdRespDTO> tradeContext) {

    }


}
