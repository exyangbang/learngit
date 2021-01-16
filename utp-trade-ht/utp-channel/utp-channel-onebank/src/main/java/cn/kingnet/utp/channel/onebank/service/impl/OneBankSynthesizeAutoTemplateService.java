package cn.kingnet.utp.channel.onebank.service.impl;

import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.PaperlessUtil;
import cn.kingnet.utp.channel.onebank.configuration.OnebankElectronicProperties;
import cn.kingnet.utp.channel.onebank.service.AbstractElectronicReceiptService;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeAutoTemplateReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeAutoTemplateRespDTO;
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
 * @Description : 合成业务数据到模板生成单据，业务数据包括文本、图片；返回合成后pdf文件
 * @Author : linkaigui
 * @Create : 2020/7/7 10:20
 */
@Component("synthesizeAutoTemplate")
@ServiceContext(bodyClass = OneBankSynthesizeAutoTemplateReqDTO.class)
@Slf4j
public class OneBankSynthesizeAutoTemplateService extends AbstractElectronicReceiptService<OneBankSynthesizeAutoTemplateReqDTO, OneBankSynthesizeAutoTemplateRespDTO> {

    private static final String API_NAME = UnionPaySubTypeEnum.SYNTHESIZE_AUTO_TEMPLATE.getDesc();

    protected OneBankSynthesizeAutoTemplateService(ExecutorService executorService, PaperlessClient paperlessClient, OnebankElectronicProperties onebankElectronicProperties) {
        super(executorService, paperlessClient, onebankElectronicProperties);
    }

    @Override
    protected ChannelResponseDTO postReq(FetureContext<OneBankSynthesizeAutoTemplateReqDTO, OneBankSynthesizeAutoTemplateRespDTO> fetureContext) {
        OneBankSynthesizeAutoTemplateReqDTO reqDTO = fetureContext.getSpReq();
        ValidateUtils.notNull(reqDTO.getElectronicTemplateKey(),"印章模版KEY不能为空!");
        String templateCode = this.getTemplateCode(reqDTO.getElectronicTemplateKey());
        String fieldBeanListXml = this.getFieldBeanListXml(reqDTO.getFieldMap());
        try {
            String savedPdfId = reqDTO.getSavedPdfId() == null ? "" : reqDTO.getSavedPdfId();
            byte[] synthesizeResult = this.paperlessClient.synthesizeAutoTemplate(reqDTO.getClientTradeId(),templateCode,savedPdfId,fieldBeanListXml,null,null,onebankElectronicProperties.getOperatorCode(),onebankElectronicProperties.getChannelCode());
            String errorRsString = PaperlessUtil.isError(synthesizeResult);
            if ("".equals(errorRsString)) {
                OneBankSynthesizeAutoTemplateRespDTO oneBankSynthesizeAutoTemplateRespDTO = new OneBankSynthesizeAutoTemplateRespDTO();
                oneBankSynthesizeAutoTemplateRespDTO.setSealedPdfData(DataUtil.deflaterAndEncode64(synthesizeResult));
                ChannelResponseDTO channelResponseDTO = ChannelResponseUtil.success(oneBankSynthesizeAutoTemplateRespDTO,null,null);
                channelResponseDTO.setServerTransId(fetureContext.getClientTradeId());
                channelResponseDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                LambdaLogger.debug(log, "流水号:{} >> [{}] 电子签章生成模板结束：OK", () -> fetureContext.getClientTradeId(), () -> apiName());
                return channelResponseDTO;
            }else {
                LambdaLogger.error(log, "流水号:{} >> [{}] 电子印章系统返回数据：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> synthesizeResult);
                String errorCode = cfca.paperless.client.util.StringUtil.getNodeText(errorRsString,"ErrorCode");
                String errorMessage = cfca.paperless.client.util.StringUtil.getNodeText(errorRsString,"ErrorMessage");
                if(StringUtil.isBlank(errorMessage)){
                    errorMessage = "电子印章系统异常";
                }
                return ChannelResponseDTO.builder()
                        .serverTransId(fetureContext.getClientTradeId())
                        .message(errorMessage)
                        .exception(StringUtil.truncate(errorMessage,800))
                        .channelRespCode(errorCode)
                        .status(HttpRespStatus.SERVER_ERROR.valueStr())
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build();
            }
        } catch (Exception e) {
            LambdaLogger.error(log, "流水号:{} >> [{}] 请求华通电子印章系统异常：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> e.getMessage(), () -> e);
            return ChannelResponseDTO.builder()
                    .serverTransId(fetureContext.getClientTradeId())
                    .message("电子印章系统异常!")
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
