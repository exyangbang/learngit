package cn.kingnet.product.precard.service.impl;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.product.precard.service.AbstractPreCardTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountEntryHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.AccountEntryDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.precard.QueryAccountEntryReqDTO;
import cn.kingnet.utp.trade.common.dto.precard.QueryAccountEntryRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description : 预付费卡入账结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/18 14:32
 */
@TradeService(
        productCode = ProductCode.PRECARD,
        tradeType = TradeType.QUERY_ACCOUNT_ENTRY,
        reqClass = QueryAccountEntryReqDTO.class,
        respClass = QueryAccountEntryRespDTO.class
)
public class QueryAccountEntryResultService extends AbstractPreCardTradeService<QueryAccountEntryReqDTO, QueryAccountEntryRespDTO> {

    private static final String SEPARATOR = "|";

    @Resource
    private IAccountEntryHandler accountEntryHandler;

    public QueryAccountEntryResultService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productPreCardProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryAccountEntryReqDTO, QueryAccountEntryRespDTO> tradeContext) {
        QueryAccountEntryReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryAccountEntryRespDTO queryAccountEntryRespDTO = new QueryAccountEntryRespDTO();
        queryAccountEntryRespDTO.setServerTradeId(tradeContext.getServerTransId());
        queryAccountEntryRespDTO.setEntryDate(reqDTO.getEntryDate());
        queryAccountEntryRespDTO.setBatchNo(reqDTO.getBatchNo());

        List<AccountEntryDetail> accountEntryDetailList = accountEntryHandler.findAccountEntryDetailList(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getEntryDate(), reqDTO.getBatchNo());

        try {
            int totalCount = CollectionUtils.isEmpty(accountEntryDetailList) ? 0 : accountEntryDetailList.size();
            //H|entry_result|20180101|222
            StringBuffer fileBuf = new StringBuffer()
                    .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                    .append(UDPSettleSplitFeature.TxType.ENTRY_RESULT.getType()).append(SEPARATOR)
                    .append(reqDTO.getEntryDate()).append(SEPARATOR).append(String.valueOf(totalCount));
            if (totalCount > 0) {
                String linesSeparator = System.getProperty("line.separator");
                accountEntryDetailList.forEach(item -> {
                    fileBuf.append(linesSeparator)
                            .append(item.getAccountNo()).append(SEPARATOR)
                            .append(item.getAmount()).append(SEPARATOR)
                            .append(item.getCardFlag()).append(SEPARATOR)
                            .append(item.getAccountName()).append(SEPARATOR)
                            .append(item.getCertNo()).append(SEPARATOR)
                            .append(item.getRemark()).append(SEPARATOR)
                            .append(item.getExtend1()).append(SEPARATOR)
                            .append(item.getExtend2()).append(SEPARATOR)
                            .append(item.getExtend3()).append(SEPARATOR)
                            .append(item.getTransStatus()).append(SEPARATOR)
                            .append(item.getTransDesc()).append(SEPARATOR);
                });
            }

            byte[] fileAy = fileBuf.toString().getBytes("UTF-8");
            String content = DataUtil.deflaterAndEncode64(fileAy);
            queryAccountEntryRespDTO.setSuccess(Boolean.TRUE.toString());
            queryAccountEntryRespDTO.setContent(content);

        } catch (UnsupportedEncodingException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "不支持的编码格式");
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return ChannelResponseUtil.success(queryAccountEntryRespDTO, null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryAccountEntryReqDTO, QueryAccountEntryRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryAccountEntryReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getEntryDate(), true, "入账日期");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryAccountEntryReqDTO, QueryAccountEntryRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryAccountEntryReqDTO, QueryAccountEntryRespDTO> tradeContext) {

    }
}
