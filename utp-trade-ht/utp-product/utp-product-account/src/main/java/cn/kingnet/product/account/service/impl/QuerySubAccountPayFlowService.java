package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IUploadSubAccountIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountIncomeFlow;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySubAccountPayFlowReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QuerySubAccountPayFlowRespDTO;
import cn.kingnet.utp.trade.common.enums.FileBatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 查询子账户入金流水报备 结果
 * @Create : 2020.02.12
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_SUBACCOUNT_PAY_FLOW_RESULT,
        reqClass = QuerySubAccountPayFlowReqDTO.class,
        respClass = QuerySubAccountPayFlowRespDTO.class
)
@Slf4j
public class QuerySubAccountPayFlowService extends AbstractAccountTradeService<QuerySubAccountPayFlowReqDTO, QuerySubAccountPayFlowRespDTO> {

    @Resource
    private IUploadSubAccountIncomeFlowHandler uploadSubAccountIncomeFlowHandler;

    public QuerySubAccountPayFlowService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QuerySubAccountPayFlowReqDTO, QuerySubAccountPayFlowRespDTO> tradeContext) {

        QuerySubAccountPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        QuerySubAccountPayFlowRespDTO.QuerySubAccountPayFlowRespDTOBuilder builder = QuerySubAccountPayFlowRespDTO.builder();
        builder.industryCode(industryCode).batchNo(reqDTO.getBatchNo());

        try {
            List<UploadSubAccountIncomeFlow> list = uploadSubAccountIncomeFlowHandler.queryByIndustryAndBatchNo(industryCode, reqDTO.getBatchNo());
            if (!CollectionUtils.isEmpty(list)) {
                List<Map<String, Object>> items = list.stream().map(this::buildItem).collect(Collectors.toList());
                builder.batchStatus(FileBatchStatus.SUCCESS.getStatus()).items(JSON.toJSONString(items));
            } else {
                builder.batchStatus(FileBatchStatus.FAILURE.getStatus()).items(null);
            }
        } catch (Exception e) {
            logger.error("查询客户号[{}]批次号[{}] 子账户入金流水报备结果异常:", industryCode, reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查询子账户入金流水报备结果异常[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    /**
     * 同步处理：批次成功才落库
     *
     * @param subAccountIncomeFlow
     * @return
     */
    private Map<String, Object> buildItem(UploadSubAccountIncomeFlow subAccountIncomeFlow) {
        Map<String, Object> item = new HashMap<>(16);
        item.put("userAccount", subAccountIncomeFlow.getSubAccount());
        item.put("incomeFlowId", subAccountIncomeFlow.getIncomeFlowId());
        item.put("transAmount", subAccountIncomeFlow.getIncomeAmount());
        item.put("linkPayFlowIds", subAccountIncomeFlow.getPayFlowIds());
        item.put("uploadStatus", "SUCCESS");
        item.put("uploadDesc", "成功");
        return item;
    }

    @Override
    protected void verifyReqParam(TradeContext<QuerySubAccountPayFlowReqDTO, QuerySubAccountPayFlowRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        QuerySubAccountPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        if (!uploadSubAccountIncomeFlowHandler.isExistBatchNo(reqDTO.getBatchNo())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "批次号不存在");
        }
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    @Override
    public void initTransFlow(TradeContext<QuerySubAccountPayFlowReqDTO, QuerySubAccountPayFlowRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QuerySubAccountPayFlowReqDTO, QuerySubAccountPayFlowRespDTO> tradeContext) {

    }


}
