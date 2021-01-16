package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IUploadSplitPayFlowHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSplitPayFlow;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySplitPayFlowResultReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySplitPayFlowResultRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 上送分账-支付订单流水补登结果查询 服务
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_SPLIT_PAY_FLOW_RESULT,
        reqClass = QuerySplitPayFlowResultReqDTO.class,
        respClass = QuerySplitPayFlowResultRespDTO.class
)
public class QuerySplitPayFlowResultService extends AbstractAccountTradeService<QuerySplitPayFlowResultReqDTO, QuerySplitPayFlowResultRespDTO> {

    @Resource
    private IUploadSplitPayFlowHandler uploadSplitPayFlowHandler;


    public QuerySplitPayFlowResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QuerySplitPayFlowResultReqDTO, QuerySplitPayFlowResultRespDTO> tradeContext) {

        QuerySplitPayFlowResultReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        QuerySplitPayFlowResultRespDTO.QuerySplitPayFlowResultRespDTOBuilder builder = QuerySplitPayFlowResultRespDTO.builder();
        builder.industryCode(industryCode).batchNo(reqDTO.getBatchNo());

        try {
            List<UploadSplitPayFlow> uploadSplitPayFlowList = uploadSplitPayFlowHandler.queryUploadSplitPayFlowList(industryCode, reqDTO.getBatchNo());
            if (CollectionUtils.isEmpty(uploadSplitPayFlowList)) {
                logger.error("查无此代付客户({})-批次号({}) 分账-支付流水补登记录", industryCode, reqDTO.getBatchNo());
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此代付客户(%s)-批次号(%s) 分账-支付流水补登记录", industryCode, reqDTO.getBatchNo()));
            }
            List<Map<String, Object>> listMap = uploadSplitPayFlowList.stream().map(this::toMap).collect(Collectors.toList());
            builder.items(JSON.toJSONString(listMap));
        } catch (Exception e) {
            logger.error("代付客户号{}-批次号{} 分账-支付流水补登记录上送结果查询异常:", industryCode, reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("代付客户号%s-批次号%s 分账-支付流水补登记录上送结果查询异常[%s]", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo(), StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    private Map<String, Object> toMap(UploadSplitPayFlow uploadSplitPayFlow) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("settleDate", uploadSplitPayFlow.getSettleDate());
        map.put("clientTransId", uploadSplitPayFlow.getClientTransId());
        map.put("userAccount", uploadSplitPayFlow.getUserAccount());
        map.put("amount", uploadSplitPayFlow.getAmount());
        map.put("settleMode", uploadSplitPayFlow.getSettleMode());
        map.put("period", uploadSplitPayFlow.getPeriod());
        map.put("remark", uploadSplitPayFlow.getRemark());
        map.put("extend_1", uploadSplitPayFlow.getExtend1());
        map.put("extend_2", uploadSplitPayFlow.getExtend2());
        map.put("extend_3", uploadSplitPayFlow.getExtend3());
        map.put("uploadStatus", uploadSplitPayFlow.getUploadStatus());
        map.put("uploadDesc", uploadSplitPayFlow.getUploadDesc());

        return map;
    }

    @Override
    protected void verifyReqParam(TradeContext<QuerySplitPayFlowResultReqDTO, QuerySplitPayFlowResultRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        QuerySplitPayFlowResultReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        boolean isExist = uploadSplitPayFlowHandler.isExistIndustryAndBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo());
        if (!isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此代付客户(%s)-批次号(%s) 分账-支付流水补登记录", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo()));
        }

    }

    @Override
    public void initTransFlow(TradeContext<QuerySplitPayFlowResultReqDTO, QuerySplitPayFlowResultRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QuerySplitPayFlowResultReqDTO, QuerySplitPayFlowResultRespDTO> tradeContext) {

    }

}
