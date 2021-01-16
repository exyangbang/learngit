package cn.kingnet.product.precard.service.impl;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.product.precard.service.AbstractPreCardTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantReconcileRecordHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantReconcileRecord;
import cn.kingnet.utp.service.persistence.entity.vo.TransCurrentVo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryReconcileFileReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryReconcileFileRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author : WJH
 * @Description : 下载代付客户平台的对账单
 * @Create : 2018-11-07
 */
@TradeService(
        productCode = ProductCode.PRECARD,
        tradeType = TradeType.DOWNLOAD_SETTLE_DATA,
        reqClass = DownloadIndustryReconcileFileReqDTO.class,
        respClass = DownloadIndustryReconcileFileRespDTO.class
)
public class DownloadIndustryReconcileFileService extends AbstractPreCardTradeService<DownloadIndustryReconcileFileReqDTO, DownloadIndustryReconcileFileRespDTO> {

    private static final String SEPARATOR = "|";

    @Resource
    private ITransHistoryHandler transHistoryHandler;

    @Resource
    private IMerchantReconcileRecordHandler merchantReconcileRecordHandler;

    public DownloadIndustryReconcileFileService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productPreCardProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadIndustryReconcileFileReqDTO, DownloadIndustryReconcileFileRespDTO> tradeContext) {

        ChannelResponseDTO channelResponseDTO = null;
        DownloadIndustryReconcileFileReqDTO reqDTO = tradeContext.getRequestDTO();
        DownloadIndustryReconcileFileRespDTO.DownloadIndustryReconcileFileRespDTOBuilder builder = DownloadIndustryReconcileFileRespDTO.builder();
        try {
            List<TransCurrentVo> list = transHistoryHandler.downloadReconcileData(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate());
            if(!CollectionUtils.isEmpty(list)){
                String content = buildIndustryReconcileFile(reqDTO.getSettleDate(), list);
                builder.success(Boolean.TRUE.toString()).desc("成功").content(content);
                channelResponseDTO = ChannelResponseUtil.success(builder.build(), null, null);
            }else {
                MerchantReconcileRecord merchantReconcileRecord = merchantReconcileRecordHandler.queryReconcileRecordByDate(reqDTO.getSettleDate());
                if(merchantReconcileRecord != null && TrueOrFalseStatus.TRUE.value().equals(merchantReconcileRecord.getReconcileStatus())){
                    builder.success(Boolean.TRUE.toString()).desc("无对账文件");
                    channelResponseDTO = ChannelResponseUtil.build(builder.build(),null,null,HttpRespStatus.NOT_FOUND,"无对账文件");
                }else {
                    builder.success(Boolean.FALSE.toString()).desc("未出对账文件");
                    channelResponseDTO = ChannelResponseUtil.build(builder.build(),null,null,HttpRespStatus.MULTIPLE_CHOICES,"未出对账文件");
                }
            }
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString()).desc("平台对账单下载失败");
            channelResponseDTO = ChannelResponseUtil.build(builder.build(),null,null,HttpRespStatus.SERVER_ERROR,"未出对账文件");
        }
        return channelResponseDTO;
    }

    private String buildIndustryReconcileFile(String reconcileDate, List<TransCurrentVo> transCurrentVoList) {


        int totalCount = CollectionUtils.isEmpty(transCurrentVoList) ? 0 : transCurrentVoList.size();
        /**
         *  H|reconcile|20180101|222
         */

        StringBuffer fileBuf = new StringBuffer()
                .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                .append(UDPSettleSplitFeature.TxType.RECONCILE.getType()).append(SEPARATOR)
                .append(reconcileDate).append(SEPARATOR).append(String.valueOf(totalCount));
        if (totalCount > 0) {
            /**
             * 清算日期|客户号（平台编号）|用户类型|商户号(身份证号)|客户端流水号|服务端流水号|交易日期|交易时间|交易类型|收款人账号|交易状态|交易金额|交易手续费
             */
            String linesSeparator = System.getProperty("line.separator");
            transCurrentVoList.forEach(item -> {
                fileBuf.append(linesSeparator)
                        .append(reconcileDate).append(SEPARATOR)
                        .append(item.getIndustryCode() == null ? "" : item.getIndustryCode()).append(SEPARATOR)
                        .append(item.getPayeeAccount() == null ? "" : item.getPayeeAccount()).append(SEPARATOR)
                        .append(item.getClientTransId() == null ? "" : item.getClientTransId()).append(SEPARATOR)
                        .append(item.getServerTransId() == null ? "" : item.getServerTransId()).append(SEPARATOR)
                        .append(item.getServerBatchNo() == null ? "" : item.getServerBatchNo()).append(SEPARATOR)
                        .append(item.getTransDate() == null ? "" : item.getTransDate()).append(SEPARATOR)
                        .append(item.getTransTime() == null ? "" : item.getTransTime()).append(SEPARATOR)
                        .append(item.getTradeType() == null ? "" : item.getTradeType()).append(SEPARATOR)
                        .append(item.getPayeeAcctNo() == null ? "" : item.getPayeeAcctNo()).append(SEPARATOR)
                        .append(item.getTransStatus() == null ? "" : item.getTransStatus()).append(SEPARATOR)
                        .append(item.getTransAmount() == null ? 0 : item.getTransAmount()).append(SEPARATOR)
                        .append(item.getMerFee() == null ? 0 : item.getMerFee()).append(SEPARATOR);
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
    protected void verifyReqParam(TradeContext<DownloadIndustryReconcileFileReqDTO, DownloadIndustryReconcileFileRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        DownloadIndustryReconcileFileReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "对账日期");

        if (LocalDate.parse(reqDTO.getSettleDate(), DateTimeFormatter.BASIC_ISO_DATE).compareTo(LocalDate.now()) >= 0) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "对账日期必须小于当前日期");
        }

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    @Override
    public void initTransFlow(TradeContext<DownloadIndustryReconcileFileReqDTO, DownloadIndustryReconcileFileRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadIndustryReconcileFileReqDTO, DownloadIndustryReconcileFileRespDTO> tradeContext) {

    }
}
