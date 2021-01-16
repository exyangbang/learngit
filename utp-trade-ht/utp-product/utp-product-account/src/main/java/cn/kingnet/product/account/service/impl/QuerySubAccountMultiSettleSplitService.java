package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ISubAccountMultiSettleDetailHandler;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySubAccountMultiSettleSplitReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySubAccountMultiSettleSplitRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;

import javax.annotation.Resource;

/**
 * @author WJH
 * @description: 子账户多级分账分账结果查询
 * @create 2020/03/29
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_SUBACCOUNT_MULTISETTLE_SPLIT,
        reqClass = QuerySubAccountMultiSettleSplitReqDTO.class,
        respClass = QuerySubAccountMultiSettleSplitRespDTO.class
)
public class QuerySubAccountMultiSettleSplitService extends AbstractAccountTradeService<QuerySubAccountMultiSettleSplitReqDTO, QuerySubAccountMultiSettleSplitRespDTO> {

    @Resource
    private ISubAccountMultiSettleDetailHandler subAccountMultiSettleDetailHandler;

    public QuerySubAccountMultiSettleSplitService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<QuerySubAccountMultiSettleSplitReqDTO, QuerySubAccountMultiSettleSplitRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        QuerySubAccountMultiSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QuerySubAccountMultiSettleSplitReqDTO, QuerySubAccountMultiSettleSplitRespDTO> tradeContext) {
        QuerySubAccountMultiSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();

        QuerySubAccountMultiSettleSplitRespDTO.QuerySubAccountMultiSettleSplitRespDTOBuilder builder = QuerySubAccountMultiSettleSplitRespDTO.builder();
        try {
            //查询子账户清算流水记录
            boolean existsPreCreate = subAccountMultiSettleDetailHandler.existsTransStatusSubAccountMultiSettleDetail(tradeContext.getIndustryCode(), reqDTO.getSettleDate(), reqDTO.getBatchNo(), TransStatus.PRE_CREATE.name());
            if (existsPreCreate) {
                builder.success(Boolean.FALSE.toString());
                return ChannelResponseUtil.build(builder.build(), null, null, HttpRespStatus.MULTIPLE_CHOICES, "存在未处理批次记录,请稍后再查询批次结果");
            }
            boolean batchSuccess = subAccountMultiSettleDetailHandler.existsTransStatusSubAccountMultiSettleDetail(tradeContext.getIndustryCode(), reqDTO.getSettleDate(), reqDTO.getBatchNo(), TransStatus.TRADE_SUCCESS.name());
            if (batchSuccess) {
                builder.success(Boolean.TRUE.toString());
            } else {
                //查无记录即为失败
                builder.success(Boolean.FALSE.toString());
            }
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString());
            throw new ProductException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return ChannelResponseUtil.success(builder.build(), null, null);
    }


    @Override
    public void initTransFlow(TradeContext<QuerySubAccountMultiSettleSplitReqDTO, QuerySubAccountMultiSettleSplitRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QuerySubAccountMultiSettleSplitReqDTO, QuerySubAccountMultiSettleSplitRespDTO> tradeContext) {

    }
}
