package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAuthAccountStatusReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAuthAccountStatusRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 企业鉴权绑卡结果查询
 *
 * @author zhongli
 * @date 2019-03-04
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.AUTH_ENT_STATUS,
        reqClass = QueryAuthAccountStatusReqDTO.class,
        respClass = QueryAuthAccountStatusRespDTO.class
)
public class QueryAuthAccountStatusService extends AbstractAccountTradeService<QueryAuthAccountStatusReqDTO, QueryAuthAccountStatusRespDTO> {


    @Autowired
    private IAccountHandler accountHandler;

    public QueryAuthAccountStatusService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public void initTransFlow(TradeContext<QueryAuthAccountStatusReqDTO, QueryAuthAccountStatusRespDTO> tradeContext) {

    }

    @Override
    protected void verifyReqParam(TradeContext<QueryAuthAccountStatusReqDTO, QueryAuthAccountStatusRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryAuthAccountStatusReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        setBasicConfigInfo(tradeContext,null);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryAuthAccountStatusReqDTO, QueryAuthAccountStatusRespDTO> tradeContext) {
        String userAccount = tradeContext.getRequestDTO().getUserAccount();
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(userAccount);
        QueryAuthAccountStatusRespDTO resp = new QueryAuthAccountStatusRespDTO();

        if (merchantInfo == null || StringUtils.isBlank(merchantInfo.getAccount())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户!");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        // 校验用户类型为个人并且类型为个体工商户(8)
        if (UserType.ONE.getType().equals(merchantInfo.getUserType())) {
            if (!merchantInfo.getNature().equals(VirtualAccountType.SELFEMPLOYED.getType())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "该账户不允许此操作");
            }
        }
        if (AccountStatus.CANCEL.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "账号已销户，不允许此操作");
        }

        resp.setClientTradeId(tradeContext.getClientTradeId());
        resp.setServerTradeId(tradeContext.getServerTransId());
        resp.setUserAccount(userAccount);
        resp.setStatus(HttpRespStatus.OK.valueStr());
        resp.setAuthStatus(merchantInfo.getAuthStatus().toString());
        resp.setRemark(merchantInfo.getAuthRemark());
        resp.setMessage(HttpRespStatus.OK.getReasonPhrase());
        resp.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(resp);

        return ChannelResponseUtil.success(resp, null, null);
    }

    @Override
    public void updateTransFlow(TradeContext<QueryAuthAccountStatusReqDTO, QueryAuthAccountStatusRespDTO> tradeContext) {

    }

}
