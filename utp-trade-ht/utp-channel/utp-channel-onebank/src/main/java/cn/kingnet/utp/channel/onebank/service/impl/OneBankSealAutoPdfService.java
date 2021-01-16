package cn.kingnet.utp.channel.onebank.service.impl;

import cfca.paperless.client.bean.SealUserInfo;
import cfca.paperless.client.bean.SignLocation;
import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.PaperlessUtil;
import cfca.paperless.client.util.PwdEncryptUtil;
import cfca.paperless.client.util.StrategyUtil;
import cn.kingnet.utp.channel.onebank.configuration.OnebankElectronicProperties;
import cn.kingnet.utp.channel.onebank.service.AbstractElectronicReceiptService;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSealAutoPdfReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSealAutoPdfRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;

/**
 * @Description : PDF自动化签章接口
 * @Author : linkaigui
 * @Create : 2020/7/6 19:05
 */
@Component("sealAutoPdf")
@ServiceContext(bodyClass = OneBankSealAutoPdfReqDTO.class)
@Slf4j
public class OneBankSealAutoPdfService extends AbstractElectronicReceiptService<OneBankSealAutoPdfReqDTO, OneBankSealAutoPdfRespDTO> {

    private static final String API_NAME = UnionPaySubTypeEnum.SEAL_AUTO_PDF.getDesc();

    protected OneBankSealAutoPdfService(ExecutorService executorService, PaperlessClient paperlessClient, OnebankElectronicProperties onebankElectronicProperties) {
        super(executorService, paperlessClient, onebankElectronicProperties);
    }

    @Override
    protected ChannelResponseDTO postReq(FetureContext<OneBankSealAutoPdfReqDTO, OneBankSealAutoPdfRespDTO> fetureContext) {
        OneBankSealAutoPdfReqDTO oneBankSealAutoPdfReqDTO = fetureContext.getSpReq();
        ValidateUtils.notNull(oneBankSealAutoPdfReqDTO.getElectronicTemplateKey(),"印章模版KEY不能为空!");
        ValidateUtils.hasText(oneBankSealAutoPdfReqDTO.getPdf(),"原PDF信息");
        try {
            byte[] pdfId = oneBankSealAutoPdfReqDTO.getPdf().getBytes("UTF-8");
            String sealPassword = PwdEncryptUtil.encrypto(onebankElectronicProperties.getSealPassword());
            //签章杂项信息
            SealUserInfo sealUserInfo = new SealUserInfo();
            //签章
            SignLocation signLocation = this.getSignLocation(oneBankSealAutoPdfReqDTO.getElectronicTemplateKey());
            //生成签章策略文件
            String sealStrategyXml = StrategyUtil.createSealStrategyXml(onebankElectronicProperties.getSealCode(),sealPassword,sealUserInfo,signLocation);
            //取得签章后的PDF文件数据
//            log.debug("SavedPdfId:="+oneBankSealAutoPdfReqDTO.getSavedPdfId());
//            log.debug("sealStrategyXml:="+sealStrategyXml);
            String savedPdfId = oneBankSealAutoPdfReqDTO.getSavedPdfId() == null ? "" : oneBankSealAutoPdfReqDTO.getSavedPdfId();
            byte[] sealedPdfData = paperlessClient.sealAutoPdf(pdfId,savedPdfId,sealStrategyXml,onebankElectronicProperties.getOperatorCode(),
                    onebankElectronicProperties.getChannelCode(),onebankElectronicProperties.getTimestampChannel(),onebankElectronicProperties.getEncrypt());
            String errorRsString = PaperlessUtil.isError(sealedPdfData);
            if ("".equals(errorRsString)) {
//                IoUtil.write("/data/app/app/utp/nfsfiles/pdf/"+ oneBankSealAutoPdfReqDTO.getSavedPdfId() + ".pdf", sealedPdfData);
                OneBankSealAutoPdfRespDTO oneBankSealAutoPdfRespDTO = new OneBankSealAutoPdfRespDTO();
                oneBankSealAutoPdfRespDTO.setSealedPdfData(DataUtil.deflaterAndEncode64(sealedPdfData));
                ChannelResponseDTO channelResponseDTO = ChannelResponseUtil.success(oneBankSealAutoPdfRespDTO,null,null);
                channelResponseDTO.setServerTransId(fetureContext.getClientTradeId());
                channelResponseDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                LambdaLogger.debug(log, "流水号:{} >> [{}] 电子签章生成模板结束：OK", () -> fetureContext.getClientTradeId(), () -> apiName());
                return channelResponseDTO;
            } else {
                LambdaLogger.info(log, "流水号:{} >> [{}] 电子印章系统返回数据：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> errorRsString);
                String errorCode = cfca.paperless.client.util.StringUtil.getNodeText(errorRsString,"ErrorCode");
                String errorMessage = cfca.paperless.client.util.StringUtil.getNodeText(errorRsString,"ErrorMessage");
                if(StringUtil.isBlank(errorMessage)){
                    errorMessage = "电子印章系统异常";
                }
                return ChannelResponseDTO.builder()
                        .serverTransId(fetureContext.getClientTradeId())
                        .message(errorMessage)
                        .exception(cn.kingnet.utp.trade.common.utils.StringUtil.truncate(errorMessage,800))
                        .channelRespCode(errorCode)
                        .status(HttpRespStatus.SERVER_ERROR.valueStr())
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build();
            }
        } catch (Exception e) {
            LambdaLogger.error(log, "流水号:{} >> [{}] 请求华通电子印章系统异常：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> e.getMessage(), () -> e);
            return ChannelResponseDTO.builder()
                    .serverTransId(fetureContext.getClientTradeId())
                    .message("电子印章渠道异常!")
                    .exception(StringUtil.truncate(e.getMessage(),800))
                    .status(HttpRespStatus.SERVER_ERROR.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
