package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IIndustryHandler;
import cn.kingnet.utp.service.persistence.api.ITransReexchangeHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.TransReexchange;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.*;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 退汇流水查询
 * @Create : 2018-11-07
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_RETURN_REMITTANCE,
        reqClass = QueryTransReexchangeReqDTO.class,
        respClass = QueryTransReexchangeRespDTO.class
)
public class QueryTransReexChangeService extends AbstractAccountTradeService<QueryTransReexchangeReqDTO, QueryTransReexchangeRespDTO> {


    @Resource
    private IIndustryHandler industryHandler;
    @Resource
    private ITransReexchangeHandler transReexchangeHandler;

    public QueryTransReexChangeService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryTransReexchangeReqDTO, QueryTransReexchangeRespDTO> tradeContext) {

        QueryTransReexchangeReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryTransReexchangeRespDTO.QueryTransReexchangeRespDTOBuilder builder = QueryTransReexchangeRespDTO.builder();
        try {
            List<Industry> industryList = industryHandler.queryAllIndustryList();
            Map<String,Object> industryMap = industryList.stream().collect(Collectors.toMap(Industry::getCode,o->StringUtil.objTrimToEmpty(o.getName()),(k1, k2)->k2));

            List<TransReexchange> list = transReexchangeHandler.queryBySettleDate(tradeContext.getAuthInfo().getAuthNo(),reqDTO.getSettleDate());
            List<Map<String, Object>> items =
                    Optional.ofNullable(list).map(l -> l.stream().map(o -> this.buildItem(o,industryMap)).collect(Collectors.toList()))
                            .orElse(Lists.newArrayList());
            builder.items(JSON.toJSONString(items));
        } catch (RetryableException re) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "退汇流水查询接口异常:"+ re.getMessage(),re);
        }
        return ChannelResponseUtil.success(builder.build(), null, null);

    }


    @Override
    protected void verifyReqParam(TradeContext<QueryTransReexchangeReqDTO, QueryTransReexchangeRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryTransReexchangeReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "开始日期");

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    /**
     * @param item
     * @param industryMap
     * @return
     */
    private Map<String, Object> buildItem(TransReexchange item,Map<String,Object> industryMap) {
        Map<String,Object> map = new HashMap<>(16);
        map.put("industryCode",item.getIndustryCode());
        map.put("industryName",industryMap==null?null:industryMap.get(item.getIndustryCode()));
        map.put("clientTransId",item.getClientTransId());
        map.put("serverTransId",item.getServerTransId());
        map.put("transDate",item.getTransDate());
        map.put("settleDate",item.getChannelSettleDate());
        map.put("payeeAccName",item.getPayeeName());
        map.put("payeeAccNo",item.getPayeeAcctNo());
        map.put("payAmt",item.getTransAmount());
        map.put("solveStatus",item.getSolveStatus());
        map.put("operUser",item.getUserCreate());
        map.put("operTime",DateUtil.formateDate(item.getGmtModified(),"yyyy-MM-dd HH:mm:ss"));
        return map;
    }

    @Override
    public void initTransFlow(TradeContext<QueryTransReexchangeReqDTO, QueryTransReexchangeRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryTransReexchangeReqDTO, QueryTransReexchangeRespDTO> tradeContext) {

    }
}
