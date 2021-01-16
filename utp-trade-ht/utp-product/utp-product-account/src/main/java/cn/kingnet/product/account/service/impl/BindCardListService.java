package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.trade.common.bo.CardInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.BindCardListReqDTO;
import cn.kingnet.utp.trade.common.dto.account.BindCardListRespDTO;
import cn.kingnet.utp.trade.common.enums.BindCardStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 绑卡列表查询
 * @Author caixh
 * @Date 2020/3/24.
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.BIND_CARD_LIST,
        reqClass = BindCardListReqDTO.class,
        respClass = BindCardListRespDTO.class
)
public class BindCardListService extends AbstractAccountTradeService<BindCardListReqDTO, BindCardListRespDTO> {

    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;

    public BindCardListService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    /**
     * 验证请求参数
     * @param tradeContext 交易上下文
     */
    @Override
    protected void verifyReqParam(TradeContext<BindCardListReqDTO, BindCardListRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        BindCardListReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getAcctNo(), 32, false, "账号");
        ValidateUtils.abcValid(reqDTO.getAcctNo(), false, "账号");
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        //校验用户账户归属资金账户与当前资金账户是否一致
        if(!basicConfigInfo.getFundAccount().equals(basicConfigInfo.getUserFundAccount())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属资金账户与当前资金账户不一致!");
        }
    }

    /**
     * 请求渠道
     * @param tradeContext 交易上下文
     * @return 渠道响应DTO
     */
    @Override
    public ChannelResponseDTO reqChannel(TradeContext<BindCardListReqDTO, BindCardListRespDTO> tradeContext) {
        BindCardListReqDTO reqDTO = tradeContext.getRequestDTO();
        List<MerchantAccountInfo> merchantAccountInfos = merchantAccountHandler.getMerchantAccountsByAccountAndAcctNo(reqDTO.getUserAccount(), reqDTO.getAcctNo());
        BindCardListRespDTO respDTO = new BindCardListRespDTO();
        respDTO.setUserAccount(reqDTO.getUserAccount());
        List<CardInfoBo> cardInfoList = merchantAccountInfos.stream().map(merchantAccountInfo -> {
            CardInfoBo cardInfo = new CardInfoBo();
            cardInfo.setAcctNo(merchantAccountInfo.getAccountNo());
            cardInfo.setBindStatus(merchantAccountInfo.getBindStatus());
            if (BindCardStatus.FAILURE.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                cardInfo.setErrCode(merchantAccountInfo.getChannelRespCode());
                cardInfo.setErrMsg(merchantAccountInfo.getChannelRespMsg());
            }
            return cardInfo;
        }).collect(Collectors.toList());
        respDTO.setCardList(JSON.toJSONString(cardInfoList));
        return ChannelResponseUtil.success(respDTO, null, null);
    }

    /**
     * 初始化流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void initTransFlow(TradeContext<BindCardListReqDTO, BindCardListRespDTO> tradeContext) {

    }

    /**
     * 更新流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void updateTransFlow(TradeContext<BindCardListReqDTO, BindCardListRespDTO> tradeContext) {

    }
}