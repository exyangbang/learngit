package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryOutsideTransOrderResultReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryOutsideTransOrderResultRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
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
 * @Description : 上送外部支付订单流水结果查询 服务
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_INDUSTRY_PAY_FLOW_RESULT,
        reqClass = QueryOutsideTransOrderResultReqDTO.class,
        respClass = QueryOutsideTransOrderResultRespDTO.class

)
public class QueryOutsideTransOrderResultService extends AbstractAccountTradeService<QueryOutsideTransOrderResultReqDTO, QueryOutsideTransOrderResultRespDTO> {


    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;


    public QueryOutsideTransOrderResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryOutsideTransOrderResultReqDTO, QueryOutsideTransOrderResultRespDTO> tradeContext) {

        QueryOutsideTransOrderResultReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        QueryOutsideTransOrderResultRespDTO.QueryOutsideTransOrderResultRespDTOBuilder builder = QueryOutsideTransOrderResultRespDTO.builder();
        builder.industryCode(industryCode).batchNo(reqDTO.getBatchNo());
        QueryOutsideTransOrderResultRespDTO respDTO;
        try {
            List<OutsideTransOrder> outsideTransOrderList = outsideTransOrderHandler.queryOutsideTransOrderList(industryCode, reqDTO.getBatchNo());
            if (CollectionUtils.isEmpty(outsideTransOrderList)) {
                logger.error("查无此代付客户({})-批次号({}) 支付流水记录.响应批次状态[整批失败]", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo());
                builder.batchStatus(FileBatchStatus.FAILURE.getStatus());
                respDTO = buildRespDTO(builder, "查无此批次上送记录", null);
            } else {
                OutsideTransOrder outsideTransOrder = outsideTransOrderList.get(0);
                FileBatchStatus fileBatchStatus;
                if (PayMode.MIXPAYFLOW.getType().equals(outsideTransOrder.getPayMode())) {
                    fileBatchStatus = FileBatchStatus.ofName(outsideTransOrder.getUploadStatus());
                    builder.batchStatus(fileBatchStatus.getStatus());
                } else {
                    long succNum = outsideTransOrderList.stream().filter(o -> "SUCCESS".equalsIgnoreCase(o.getUploadStatus())).count();
                    fileBatchStatus = succNum == 0 ? FileBatchStatus.FAILURE : (succNum == outsideTransOrderList.size() ? FileBatchStatus.SUCCESS : FileBatchStatus.PART_SUCCESS);
                    builder.batchStatus(fileBatchStatus.getStatus());
                }
                List<Map<String, Object>> listMap = outsideTransOrderList.stream().map(this::toMap).collect(Collectors.toList());
                builder.items(JSON.toJSONString(listMap));
                respDTO = buildRespDTO(builder, fileBatchStatus.getDesc(), null);
            }
        } catch (Exception e) {
            logger.error("代付客户号{}-批次号{}支付流水记录上送结果查询异常:", industryCode, reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水上送结果查询[批次号:%s]异常[%s]", reqDTO.getBatchNo(), StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(respDTO, null, null);
    }

    private QueryOutsideTransOrderResultRespDTO buildRespDTO(QueryOutsideTransOrderResultRespDTO.QueryOutsideTransOrderResultRespDTOBuilder builder, String message, String exception) {
        QueryOutsideTransOrderResultRespDTO respDTO = builder.build();
        respDTO.setMessage(message);
        respDTO.setException(exception);
        return respDTO;
    }

    private Map<String, Object> toMap(OutsideTransOrder outsideTransOrder) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("reqDate", outsideTransOrder.getReqDate());
        map.put("reqTime", outsideTransOrder.getReqTime());
        map.put("transDate", outsideTransOrder.getTransDate());
        map.put("transTime", outsideTransOrder.getTransTime());
        map.put("transOrderId", outsideTransOrder.getTransOrderId());
        map.put("merNo", outsideTransOrder.getMerNo());
        map.put("pay_mode", outsideTransOrder.getPayMode());
        map.put("transAmount", outsideTransOrder.getTransAmount());
        map.put("sellerName", outsideTransOrder.getSellerName());
        map.put("buyerName", outsideTransOrder.getBuyerName());
        map.put("goodsInfo", outsideTransOrder.getGoodsInfo());
        map.put("uploadStatus", outsideTransOrder.getUploadStatus());
        map.put("uploadDesc", outsideTransOrder.getUploadDesc());
        return map;
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryOutsideTransOrderResultReqDTO, QueryOutsideTransOrderResultRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        QueryOutsideTransOrderResultReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 64, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        boolean isExist = outsideTransOrderHandler.isExistIndustryANdBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo());
        if (!isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此代付客户(%s)-批次号(%s)支付流水记录", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo()));
        }

    }

    @Override
    public void initTransFlow(TradeContext<QueryOutsideTransOrderResultReqDTO, QueryOutsideTransOrderResultRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryOutsideTransOrderResultReqDTO, QueryOutsideTransOrderResultRespDTO> tradeContext) {

    }

}
