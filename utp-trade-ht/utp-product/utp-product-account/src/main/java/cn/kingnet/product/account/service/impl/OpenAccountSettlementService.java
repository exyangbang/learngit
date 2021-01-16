package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IOpenAccountSettlementHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountSettlementReqDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountSettlementRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;

import javax.annotation.Resource;

/**
 * @author sheqingquan@scenetec.com
 * @description: 待结算账户开户
 * @create 2020/2/12 10:32
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.OPEN_ACCOUNT_SETTLEMENT,
        reqClass = OpenAccountSettlementReqDTO.class,
        respClass = OpenAccountSettlementRespDTO.class
)
public class OpenAccountSettlementService extends AbstractAccountTradeService<OpenAccountSettlementReqDTO, OpenAccountSettlementRespDTO> {

    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";

    private final static String CUR_MERCHANT_INFO = "CUR_MERCHANT_INFO";

    @Resource
    private IOpenAccountSettlementHandler openAccountSettlementHandler;

    public OpenAccountSettlementService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<OpenAccountSettlementReqDTO, OpenAccountSettlementRespDTO> tradeContext) {
        OpenAccountSettlementReqDTO reqDTO = tradeContext.getRequestDTO();
        MerchantInfo merchantInfo = tradeContext.getAttribute(CUR_MERCHANT_INFO);
        OpenAccountSettlementRespDTO respDTO = new OpenAccountSettlementRespDTO();
        respDTO.setUserAccount(reqDTO.getUserAccount());
        respDTO.setClientTradeId(reqDTO.getClientTradeId());
        respDTO.setServerTradeId(tradeContext.getServerTransId());
        if (StringUtil.isBlank(merchantInfo.getSettleAccount())) {
            String userSettleAccount = openAccountSettlementHandler.createSettleAccount(reqDTO.getUserAccount());
            respDTO.setUserSettleAccount(userSettleAccount);
            return ChannelResponseUtil.success(respDTO, null, null);
        } else {
            respDTO.setUserSettleAccount(merchantInfo.getSettleAccount());
            return ChannelResponseUtil.success(respDTO, null, null);
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<OpenAccountSettlementReqDTO, OpenAccountSettlementRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        OpenAccountSettlementReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        //查找代付客户号信息
        Industry industry = accountHandler.findIndustry(tradeContext.getAuthInfo().getAuthNo());
        if (industry == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到客户号信息,拒绝请求!");
        }
        ValidateUtils.hasText(industry.getCode(), "平台代码");
        ValidateUtils.hasText(industry.getFundAccount(), "资金账号");
        ValidateUtils.hasText(industry.getAccount(), "平台虚拟账号");
        if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用");
        }
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(reqDTO.getUserAccount());
        if (null == merchantInfo) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "用户账户不存在!");
        }
        if (!StringUtil.isBlank(merchantInfo.getSettleAccount())) {
            //兼容若之前开通过待结算账户，则直接返回其原待结算账户号
        } else {
            if (!TrueOrFalseStatus.TRUE.value().equals(industry.getIsOpneDoubleAcc())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "该客户号未开通多开子账户权限");
            }
        }

        //只能在相同客户号下创建
        if (!merchantInfo.getIndustryCode().equals(tradeContext.getAuthInfo().getAuthNo())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "当前代付客户号与用户账户客户号不一致!");
        }
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
        tradeContext.setAttribute(CUR_MERCHANT_INFO, merchantInfo);
    }

    @Override
    public void initTransFlow(TradeContext<OpenAccountSettlementReqDTO, OpenAccountSettlementRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<OpenAccountSettlementReqDTO, OpenAccountSettlementRespDTO> tradeContext) {

    }
}
