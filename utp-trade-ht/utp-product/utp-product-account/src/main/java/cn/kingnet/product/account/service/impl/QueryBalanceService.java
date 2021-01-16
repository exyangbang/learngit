package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryBalanceReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryBalanceRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : WJH
 * @Description : 虚拟账户余额查询
 * @Create : 2018-10-09
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_BALANCE,
        reqClass = QueryBalanceReqDTO.class,
        respClass = QueryBalanceRespDTO.class,
        successTransStatus = TransStatus.TRADE_SUCCESS
)
public class QueryBalanceService extends AbstractAccountTradeService<QueryBalanceReqDTO, QueryBalanceRespDTO> {

    public QueryBalanceService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryBalanceReqDTO, QueryBalanceRespDTO> tradeContext) {
        QueryBalanceReqDTO reqDTO = tradeContext.getRequestDTO();
        String userAccount = reqDTO.getUserAccount();
        if (StringUtils.isEmpty(reqDTO.getUserAccount())) {
            //行业编号（代付客户号）
            String industryCode = tradeContext.getAuthInfo().getAuthNo();
            Industry industry = accountHandler.findIndustry(industryCode);
            if (industry == null) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到代付客户信息");
            } else if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用");
            }
            userAccount = industry.getAccount();
        }
        Account account = accountHandler.findAccount(userAccount);
        if (account == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户未开户");
        } else if (!VirtualAccountStatus.isNormal(account.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该账户未启用");
        }

        //校验用户账户归属资金账户与当前资金账户是否一致
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if(!basicConfigInfo.getFundAccount().equals(account.getFundAccount())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属资金账户与当前资金账户不一致!");
        }

        QueryBalanceRespDTO.QueryBalanceRespDTOBuilder builder = QueryBalanceRespDTO.builder();
        builder.account(userAccount)
                .balance(String.valueOf(account.getBalance()))
                .frozenAmount(String.valueOf(account.getFrozenAmount()))
                .availAmount(String.valueOf(account.getAvailAmount()));
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryBalanceReqDTO, QueryBalanceRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryBalanceReqDTO reqDTO = tradeContext.getRequestDTO();
        if (StringUtils.isEmpty(reqDTO.getUserAccount())) {
            //行业编号（代付客户号）
            String industryNumber = tradeContext.getAuthInfo().getAuthNo();
            if (!industryNumber.equals(reqDTO.getIndustryCode())) {
                throw new TradeException(HttpRespStatus.FORBIDDEN, "只能查询所属平台的余额信息");
            }
        }else{
            ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
            ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        }
    }

    @Override
    public void initTransFlow(TradeContext<QueryBalanceReqDTO, QueryBalanceRespDTO> tradeContext) {
    }

    @Override
    public void updateTransFlow(TradeContext<QueryBalanceReqDTO, QueryBalanceRespDTO> tradeContext) {
    }

}
