package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.bo.IndustryAccountBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.PlatAccountListReqDTO;
import cn.kingnet.utp.trade.common.dto.account.PlatAccountListRespDTO;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 平台账户列表查询
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 10:20
 */
@TradeService(productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.PLAT_ACCOUNT_LIST,
        reqClass = PlatAccountListReqDTO.class,
        respClass = PlatAccountListRespDTO.class
)
public class QueryPlatAccountInfoService extends AbstractAccountTradeService<PlatAccountListReqDTO, PlatAccountListRespDTO> {

    @Resource
    private IAccountHandler accountHandler;

    public QueryPlatAccountInfoService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    /**
     * 验证请求参数
     * @param tradeContext 交易上下文
     */
    @Override
    protected void verifyReqParam(TradeContext<PlatAccountListReqDTO, PlatAccountListRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
    }

    /**
     * 请求渠道
     * @param tradeContext 交易上下文
     * @return
     */
    @Override
    public ChannelResponseDTO reqChannel(TradeContext<PlatAccountListReqDTO, PlatAccountListRespDTO> tradeContext) {

        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        // 查询类型为 1-平台账户|5-手续费支出账户|10-小额打款支出账户
        List<IndustryAccountBo> industryAccountInfoList = accountHandler.getIndustryAccountByCode(industryCode);

        PlatAccountListRespDTO respDTO = new PlatAccountListRespDTO();
        respDTO.setAccountList(JSON.toJSONString(industryAccountInfoList));

        return ChannelResponseUtil.success(respDTO, null, null);
    }

    /**
     * 初始化流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void initTransFlow(TradeContext<PlatAccountListReqDTO, PlatAccountListRespDTO> tradeContext) {

    }

    /**
     * 更新流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void updateTransFlow(TradeContext<PlatAccountListReqDTO, PlatAccountListRespDTO> tradeContext) {

    }
}