package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryD1SpecailReconFileReqDTO;
import cn.kingnet.utp.trade.common.dto.account.DownloadIndustryD1SpecailReconFileRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author : WJH
 * @Description : 4.5.13. D日对账文件下载(京东定制化)
 * "D+1日凌晨12:30生成D日对账文件，京东于凌晨1点可以通过该接口下载对应的客户号的对账文件。
 * D+1日凌晨12:30生成D日对账文件，对账文件包含以下几部分内容：
 *  D日交易明确成功及明确失败的交易记录。
 *  D日进行处理的差错交易记录。
 *  D日进行处理的退汇的交易记录。
 * "
 * @Create : 2018-11-07
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.DOWNLOAD_DAYTX_DATA,
        reqClass = DownloadIndustryD1SpecailReconFileReqDTO.class,
        respClass = DownloadIndustryD1SpecailReconFileRespDTO.class
)
@Slf4j
public class DownloadIndustryD1SpecialReconFileService extends AbstractAccountTradeService<DownloadIndustryD1SpecailReconFileReqDTO, DownloadIndustryD1SpecailReconFileRespDTO> {

    @Resource
    private ITransHistoryHandler transHistoryHandler;

    public DownloadIndustryD1SpecialReconFileService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<DownloadIndustryD1SpecailReconFileReqDTO, DownloadIndustryD1SpecailReconFileRespDTO> tradeContext) {

        ChannelResponseDTO channelResponseDTO = null;
        DownloadIndustryD1SpecailReconFileReqDTO reqDTO = tradeContext.getRequestDTO();
        DownloadIndustryD1SpecailReconFileRespDTO.DownloadIndustryD1SpecailReconFileRespDTOBuilder builder = DownloadIndustryD1SpecailReconFileRespDTO.builder();
        builder.success(Boolean.FALSE.toString());
        try {
            byte[] d1SpecailReconFile = transHistoryHandler.downloadIndustryD1SpecailReconFile(tradeContext.getIndustryCode(), reqDTO.getTxDate());
            String content = DataUtil.deflaterAndEncode64(d1SpecailReconFile);
            builder.success(Boolean.TRUE.toString()).content(content);
            channelResponseDTO = ChannelResponseUtil.success(builder.build(),null,null);
        } catch (TradeException e) {
            builder.success(Boolean.FALSE.toString()).desc("D日对账单下载失败");
            channelResponseDTO = ChannelResponseUtil.build(builder.build(), null, null, HttpRespStatus.resolve(e.getStatus()), "D日对账单下载失败:"+e.getMessage());
            LambdaLogger.error(log, "流水号:{} >> D日对账单下载失败.{}", tradeContext.getServerTransId(), e.getMessage(), e);
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString()).desc("D日对账单下载异常");
            channelResponseDTO = ChannelResponseUtil.build(builder.build(), null, null, HttpRespStatus.SERVER_ERROR, "D日对账单下载异常:"+e.getMessage());
            LambdaLogger.error(log, "流水号:{} >> D日对账单下载异常.{}", tradeContext.getServerTransId(), e.getMessage(), e);
        }
        return channelResponseDTO;
    }


    @Override
    protected void verifyReqParam(TradeContext<DownloadIndustryD1SpecailReconFileReqDTO, DownloadIndustryD1SpecailReconFileRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        DownloadIndustryD1SpecailReconFileReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getTxDate(), true, "交易日期");

        if (LocalDate.parse(reqDTO.getTxDate(), DateTimeFormatter.BASIC_ISO_DATE).compareTo(LocalDate.now()) >= 0) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "交易日期必须小于当前日期");
        }
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        Integer reconciliationMode = getBasicConfigInfo(tradeContext).getReconciliationMode();
        if(reconciliationMode==null || reconciliationMode.intValue()!=1){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该平台客户不允许下载D日对账文件");
        }

    }

    @Override
    public void initTransFlow(TradeContext<DownloadIndustryD1SpecailReconFileReqDTO, DownloadIndustryD1SpecailReconFileRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<DownloadIndustryD1SpecailReconFileReqDTO, DownloadIndustryD1SpecailReconFileRespDTO> tradeContext) {

    }
}
