package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ISubAccountSettleSplitHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.SubaccountSettleSplitResultReqDTO;
import cn.kingnet.utp.trade.common.dto.account.SubaccountSettleSplitResultRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author sheqingquan@scenetec.com
 * @description: 子账户清算分账结果查询
 * @create 2020/2/11 18:02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_SUBACCOUNT_SETTLE_SPLIT,
        reqClass = SubaccountSettleSplitResultReqDTO.class,
        respClass = SubaccountSettleSplitResultRespDTO.class
)
public class QuerySubAccountSettleSplitResultService extends AbstractAccountTradeService<SubaccountSettleSplitResultReqDTO, SubaccountSettleSplitResultRespDTO> {

    private static final String SEPARATOR = "|";
    @Resource
    private ISubAccountSettleSplitHandler iSubAccountSettleSplitHandler;

    public QuerySubAccountSettleSplitResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<SubaccountSettleSplitResultReqDTO, SubaccountSettleSplitResultRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        SubaccountSettleSplitResultReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        //查询子账户清算流水记录
        if (!iSubAccountSettleSplitHandler.isExistSubAccountSettleSplitInfo(
                reqDTO.getSettleDate(), reqDTO.getUserAccount(), reqDTO.getBatchNo(), tradeContext.getAuthInfo().getAuthNo())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此清算流水记录");
        }
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<SubaccountSettleSplitResultReqDTO, SubaccountSettleSplitResultRespDTO> tradeContext) {
        SubaccountSettleSplitResultReqDTO reqDTO = tradeContext.getRequestDTO();

        SubaccountSettleSplitResultRespDTO.SubaccountSettleSplitResultRespDTOBuilder builder = SubaccountSettleSplitResultRespDTO.builder();
        try {
            List<UploadSubAccountSettleSplitDetail> list = iSubAccountSettleSplitHandler.querySubAccountSettleSplitDetail(
                    reqDTO.getSettleDate(), reqDTO.getUserAccount(), reqDTO.getBatchNo(), tradeContext.getAuthInfo().getAuthNo());
            builder.success(Boolean.TRUE.toString()).userAccount(reqDTO.getUserAccount()).settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo());
            if (!CollectionUtils.isEmpty(list)) {
                AtomicInteger succNum = new AtomicInteger();
                list.forEach(l -> {
                    if (TransStatus.PRE_CREATE.name().equals(l.getTransStatus())) {
                        throw new ProductException(HttpRespStatus.MULTIPLE_CHOICES, "存在未处理批次记录,请稍后再查询批次结果");
                    }
                    if (TransStatus.TRADE_SUCCESS.name().equals(l.getTransStatus())) {
                        succNum.incrementAndGet();
                    }
                });
                String batchStatus = succNum.get() == 0 ? FileBatchStatus.FAILURE.getStatus() : (succNum.get() == list.size() ? FileBatchStatus.SUCCESS.getStatus() : FileBatchStatus.PART_SUCCESS.getStatus());
                builder.success(Boolean.TRUE.toString()).batchStatus(batchStatus);
            } else {
                builder.success(Boolean.FALSE.toString()).batchStatus(FileBatchStatus.FAILURE.getStatus());
            }
            String content = buildSubaccountSettleSplitResult(reqDTO.getSettleDate(), list);
            builder.content(content);
        } catch (ProductException e) {
            throw e;
        } catch (Exception e) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    /**
     * 构建子账户清算分账结果
     *
     * @param settleDate    清算日期
     * @param splitInfoList 子账户清算分账明细
     * @return
     */
    private String buildSubaccountSettleSplitResult(String settleDate, List<UploadSubAccountSettleSplitDetail> splitInfoList) {
        //数据总行数
        int totalCount = CollectionUtils.isEmpty(splitInfoList) ? 0 : splitInfoList.size();
        //头部格式： H|subaccount_settle_result|20181104|2
        StringBuffer fileBuf = new StringBuffer()
                .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                .append(UDPSettleSplitFeature.TxType.SUBACCOUNT_SETTLE_RESULT.getType()).append(SEPARATOR)
                .append(settleDate).append(SEPARATOR)
                .append(totalCount);
        if (totalCount > 0) {
            //序号|清算日期|客户端流水号|分账子账户|金额|结算方式|账期|备注信息|子账户支付订单号列表|扩展字段2|扩展字段3|交易状态|结果说明|对账日期|
            IntStream.range(0, totalCount).forEach(index -> {
                UploadSubAccountSettleSplitDetail item = splitInfoList.get(index);
                fileBuf.append("\n")
                        .append(index + 1).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getSettleDate())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getClientTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getUserAccount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAmount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getSettleMode())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getPeriod())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getRemark())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransOrderIds())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend2())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend3())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransStatus())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransDesc())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getReconcileDate())).append(SEPARATOR);
            });
        }
        byte[] fileAy = fileBuf.toString().getBytes(StandardCharsets.UTF_8);
        return DataUtil.deflaterAndEncode64(fileAy);
    }

    @Override
    public void initTransFlow(TradeContext<SubaccountSettleSplitResultReqDTO, SubaccountSettleSplitResultRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<SubaccountSettleSplitResultReqDTO, SubaccountSettleSplitResultRespDTO> tradeContext) {

    }
}
