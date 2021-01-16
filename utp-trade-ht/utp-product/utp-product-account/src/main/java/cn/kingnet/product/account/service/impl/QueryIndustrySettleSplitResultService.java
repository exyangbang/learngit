package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.EBSettleSplitResultReqDTO;
import cn.kingnet.utp.trade.common.dto.account.EBSettleSplitResultRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : WJH
 * @Description : 代付客户平台清分文件处理结果查询
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_SETTLE_SPLIT,
        reqClass = EBSettleSplitResultReqDTO.class,
        respClass = EBSettleSplitResultRespDTO.class
)
public class QueryIndustrySettleSplitResultService extends AbstractAccountTradeService<EBSettleSplitResultReqDTO, EBSettleSplitResultRespDTO> {
    static final String SEPARATOR = "|";

    @Resource
    private ISplitInfoHandler iSplitInfoHandler;

    public QueryIndustrySettleSplitResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<EBSettleSplitResultReqDTO, EBSettleSplitResultRespDTO> tradeContext) {

        EBSettleSplitResultReqDTO reqDTO = tradeContext.getRequestDTO();

        EBSettleSplitResultRespDTO.EBSettleSplitResultRespDTOBuilder builder = EBSettleSplitResultRespDTO.builder();
        builder.success(Boolean.TRUE.toString()).settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo());
        try {
            List<SplitInfo> list = iSplitInfoHandler.querySplitInfoByBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo());
            if (!CollectionUtils.isEmpty(list)) {
                AtomicInteger succNum = new AtomicInteger();
                list.stream().forEach(splitInfo -> {
                    if (TransStatus.PRE_CREATE.name().equals(splitInfo.getTransStatus())) {
                        throw new ProductException(HttpRespStatus.MULTIPLE_CHOICES, "该批次存在未处理分账记录，稍后再查询批次结果");
                    }
                    if (TransStatus.TRADE_SUCCESS.name().equals(splitInfo.getTransStatus())) {
                        succNum.incrementAndGet();
                    }
                });

                String batchStatus = succNum.get() == 0 ? FileBatchStatus.FAILURE.getStatus() : (succNum.get() == list.size() ? FileBatchStatus.SUCCESS.getStatus() : FileBatchStatus.PART_SUCCESS.getStatus());
                builder.batchStatus(batchStatus).success(Boolean.TRUE.toString());
            } else {
                builder.success(Boolean.FALSE.toString()).batchStatus(FileBatchStatus.FAILURE.getStatus());
                throw new ProductException(HttpRespStatus.NOT_FOUND, String.format("查无此清算日期[%s]-批次号[%s]记录",reqDTO.getSettleDate(),reqDTO.getBatchNo()));
            }
            String content = buildSettleSplitResult(reqDTO.getSettleDate(), list);
            builder.content(content);
        } catch (ProductException e) {
            throw e;
        } catch (Exception e) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    private String buildSettleSplitResult(String settleDate, List<SplitInfo> splitInfoList) {

        // 按规范生成文件并推送到文件提供方
        int totalCount = CollectionUtils.isEmpty(splitInfoList) ? 0 : splitInfoList.size();
        //H|settle_result|20180101|222
        StringBuffer fileBuf = new StringBuffer()
                .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                .append(UDPSettleSplitFeature.TxType.SETTLE_RESULT.getType()).append(SEPARATOR)
                .append(settleDate).append(SEPARATOR).append(String.valueOf(totalCount));
        if (totalCount > 0) {
            //清算日期|客户端流水号|用户账户|金额|结算方式|账期|备注|扩展1|扩展2|扩展3|交易状态|结果说明|对账日期
            splitInfoList.forEach(item -> {
                fileBuf.append("\n")
                        .append(StringUtil.objTrimToEmpty(item.getSettleDate())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getClientTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getUserAccount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAmount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getSettleMode())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getPeriod())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getRemark())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend1())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getServerTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend3())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransStatus())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransDesc())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getReconcileDate()));

            });
        }
        try {
            byte[] fileAy = fileBuf.toString().getBytes("UTF-8");
            return DataUtil.deflaterAndEncode64(fileAy);
        } catch (UnsupportedEncodingException e) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "不支持的编码格式");
        }
    }


    @Override
    protected void verifyReqParam(TradeContext<EBSettleSplitResultReqDTO, EBSettleSplitResultRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        EBSettleSplitResultReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        if (!iSplitInfoHandler.isExistSplitInfo(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此清算流水记录");
        }


    }

    @Override
    public void initTransFlow(TradeContext<EBSettleSplitResultReqDTO, EBSettleSplitResultRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<EBSettleSplitResultReqDTO, EBSettleSplitResultRespDTO> tradeContext) {

    }
}
