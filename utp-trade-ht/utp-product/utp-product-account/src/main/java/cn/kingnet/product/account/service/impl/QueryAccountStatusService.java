package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAccountStatusReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAccountStatusRespDTO;
import cn.kingnet.utp.trade.common.enums.AccountStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  账户状态查询
 * @author zhongli
 * @date 2019-03-04
 *
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_ACCOUNT_STATUS,
        reqClass = QueryAccountStatusReqDTO.class,
        respClass = QueryAccountStatusRespDTO.class
)
public class QueryAccountStatusService extends AbstractAccountTradeService<QueryAccountStatusReqDTO, QueryAccountStatusRespDTO> {

    @Autowired
    private IMerchantAccountHandler merchantAccountHandler;

    public QueryAccountStatusService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryAccountStatusReqDTO, QueryAccountStatusRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryAccountStatusReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        Account account = this.accountHandler.findAccountByNo(reqDTO.getUserAccount());
        if (null == account) {
            throw new ProductException(HttpRespStatus.FORBIDDEN.value(), "查无此虚拟账户:".concat(reqDTO.getUserAccount()));
        }
        //校验用户账户归属资金账户与当前资金账户是否一致
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if(!basicConfigInfo.getFundAccount().equals(account.getFundAccount())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属资金账户与当前资金账户不一致!");
        }
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryAccountStatusReqDTO, QueryAccountStatusRespDTO> tradeContext) {
        String userAccount = tradeContext.getRequestDTO().getUserAccount();
        MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(userAccount,false);
        QueryAccountStatusRespDTO queryAccountStatusRespDTO = new QueryAccountStatusRespDTO();
        if (merchantInfoBo != null) {
            queryAccountStatusRespDTO.setAccountStatus(merchantInfoBo.getStatus());
        } else {
            queryAccountStatusRespDTO.setAccountStatus(AccountStatus.NO_OPEN.getCode().toString());
        }
        queryAccountStatusRespDTO.setClientTradeId(tradeContext.getClientTradeId());
        queryAccountStatusRespDTO.setServerTradeId(tradeContext.getServerTransId());
        queryAccountStatusRespDTO.setStatus(HttpRespStatus.OK.valueStr());
        queryAccountStatusRespDTO.setMessage(HttpRespStatus.OK.getReasonPhrase());
        queryAccountStatusRespDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(queryAccountStatusRespDTO);
        return ChannelResponseUtil.success(queryAccountStatusRespDTO,null,null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryAccountStatusReqDTO, QueryAccountStatusRespDTO> tradeContext) {
    }

    @Override
    public void updateTransFlow(TradeContext<QueryAccountStatusReqDTO, QueryAccountStatusRespDTO> tradeContext) {
    }

}
