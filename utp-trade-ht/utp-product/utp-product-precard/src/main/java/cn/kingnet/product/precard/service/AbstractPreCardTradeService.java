package cn.kingnet.product.precard.service;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.AbstractTradeService;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import feign.RetryableException;

/**
 * @Description : 预付费卡抽象类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/2 15:05
 */
public abstract class AbstractPreCardTradeService<REQ extends BaseRequestDTO, RESP extends BaseResponseDTO> extends AbstractTradeService<REQ, RESP> {

    protected final IBasicConfigHandler basicConfigHandler;

    protected final ProductPreCardProperties productPreCardProperties;

    public AbstractPreCardTradeService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties);
        this.basicConfigHandler = basicConfigHandler;
        this.productPreCardProperties = productPreCardProperties;
    }

    @Override
    protected String generateServerTransId() {
        return IdGenerate.generateServerTransId(this.productPreCardProperties.getDfa(),this.productPreCardProperties.getSystemId());
    }

    /**
     * 设置基础配置信息
     *
     * @param tradeContext 交易上下文
     */
    public void setBasicConfigInfo(TradeContext<REQ, RESP> tradeContext, String userAccount) {
        BasicConfigInfo basicConfigInfo = null;
        try {
            basicConfigInfo = basicConfigHandler.getBasicConfigInfoByIndustry(tradeContext.getAuthInfo().getAuthNo(), userAccount, tradeContext.getTradeService().productCode().name());
        } catch (RetryableException re) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "找不到获取基础信息接口!");
        }
        if (basicConfigInfo == null) throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到客户号信息!");
        ValidateUtils.hasText(basicConfigInfo.getIndustryCode(), "平台代码");
        ValidateUtils.hasText(basicConfigInfo.getCustAccountNo(), "平台客户账户");
        ValidateUtils.hasText(basicConfigInfo.getCustAccountName(), "平台客户账户名称");
        ValidateUtils.hasText(basicConfigInfo.getFundAccount(), "资金账号");
        ValidateUtils.hasText(basicConfigInfo.getIndustryAccount(), "平台虚拟账号");
        tradeContext.setAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY, basicConfigInfo);
    }

    protected BasicConfigInfo getBasicConfigInfo(TradeContext<REQ, RESP> tradeContext){
        return tradeContext.getAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY);
    }

}
