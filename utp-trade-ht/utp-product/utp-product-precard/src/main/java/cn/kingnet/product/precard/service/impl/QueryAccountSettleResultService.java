package cn.kingnet.product.precard.service.impl;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.product.precard.service.AbstractPreCardTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountSettleHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.AccountSettleDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.precard.QueryAccountSettleReqDTO;
import cn.kingnet.utp.trade.common.dto.precard.QueryAccountSettleRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description : 预付费卡清算结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 14:09
 */
@TradeService(
        productCode = ProductCode.PRECARD,
        tradeType = TradeType.QUERY_ACCOUNT_SETTLE,
        reqClass = QueryAccountSettleReqDTO.class,
        respClass = QueryAccountSettleRespDTO.class
)
public class QueryAccountSettleResultService extends AbstractPreCardTradeService<QueryAccountSettleReqDTO, QueryAccountSettleRespDTO> {

    private static final String SEPARATOR = "|";

    @Resource
    private IAccountSettleHandler accountSettleHandler;

    public QueryAccountSettleResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productPreCardProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryAccountSettleReqDTO, QueryAccountSettleRespDTO> tradeContext) {
        QueryAccountSettleReqDTO reqDTO = tradeContext.getRequestDTO();

        QueryAccountSettleRespDTO queryAccountSettleRespDTO = new QueryAccountSettleRespDTO();
        queryAccountSettleRespDTO.setServerTradeId(tradeContext.getServerTransId());
        queryAccountSettleRespDTO.setSettleDate(reqDTO.getSettleDate());
        queryAccountSettleRespDTO.setBatchNo(reqDTO.getBatchNo());
        queryAccountSettleRespDTO.setSettleAmount("0");

        List<AccountSettleDetail> accountSettleDetailList = accountSettleHandler.findAccountSettleDetailList(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo());

        try {
            AtomicReference<Long> settleAmount = new AtomicReference<>(0L);
            int totalCount = CollectionUtils.isEmpty(accountSettleDetailList) ? 0 : accountSettleDetailList.size();
            //H|settle_result|20180101|222
            StringBuffer fileBuf = new StringBuffer()
                    .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                    .append(UDPSettleSplitFeature.TxType.SETTLE_RESULT.getType()).append(SEPARATOR)
                    .append(reqDTO.getSettleDate()).append(SEPARATOR).append(String.valueOf(totalCount));
            if (totalCount > 0) {
                String linesSeparator = System.getProperty("line.separator");
                accountSettleDetailList.forEach(item -> {
                    fileBuf.append(linesSeparator)
                            .append(item.getAccountNo()).append(SEPARATOR)
                            .append(item.getAmount()).append(SEPARATOR)
                            .append(item.getRemark()).append(SEPARATOR)
                            .append(item.getExtend1()).append(SEPARATOR)
                            .append(item.getExtend2()).append(SEPARATOR)
                            .append(item.getExtend3()).append(SEPARATOR)
                            .append(item.getTransStatus()).append(SEPARATOR)
                            .append(item.getTransDesc()).append(SEPARATOR);
                    if(TransStatus.TRADE_SUCCESS.name().equals(item.getTransStatus())){
                        settleAmount.set(settleAmount.get() + item.getAmount());
                    }
                });
            }

            byte[] fileAy = fileBuf.toString().getBytes("UTF-8");
            String content = DataUtil.deflaterAndEncode64(fileAy);
            queryAccountSettleRespDTO.setSuccess(Boolean.TRUE.toString());
            queryAccountSettleRespDTO.setContent(content);
            queryAccountSettleRespDTO.setSettleAmount(String.valueOf(settleAmount.get()));

        } catch (UnsupportedEncodingException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "不支持的编码格式");
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return ChannelResponseUtil.success(queryAccountSettleRespDTO, null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryAccountSettleReqDTO, QueryAccountSettleRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryAccountSettleReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryAccountSettleReqDTO, QueryAccountSettleRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryAccountSettleReqDTO, QueryAccountSettleRespDTO> tradeContext) {

    }
}
