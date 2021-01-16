package cn.kingnet.utp.channel.onebank.service.impl;

import cfca.paperless.client.servlet.PaperlessClient;
import cn.kingnet.utp.channel.onebank.configuration.OnebankElectronicProperties;
import cn.kingnet.utp.channel.onebank.service.AbstractElectronicReceiptService;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeTemplateWithPdfIdReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeTemplateWithPdfIdRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;

/**
 * @Description : PDF自动化合成模板业务数据接口
 *  合成业务数据到模板生成单据，业务数据包括文本、图片；不返回合成后pdf文件，只返回保存在临时表中的pdfId
 * @Author : linkaigui
 * @Create : 2020/7/6 16:44
 */
@Component("synthesizeTemplateWithPdfId")
@ServiceContext(bodyClass = OneBankSynthesizeTemplateWithPdfIdReqDTO.class)
@Slf4j
public class OneBankSynthesizeTemplateWithPdfIdService extends AbstractElectronicReceiptService<OneBankSynthesizeTemplateWithPdfIdReqDTO, OneBankSynthesizeTemplateWithPdfIdRespDTO> {

    private static final String API_NAME = UnionPaySubTypeEnum.SYNTHESIZE_TEMPLATE_WITH_PDF_ID.getDesc();

    protected OneBankSynthesizeTemplateWithPdfIdService(ExecutorService executorService, PaperlessClient paperlessClient, OnebankElectronicProperties onebankElectronicProperties) {
        super(executorService, paperlessClient, onebankElectronicProperties);
    }

    @Override
    protected ChannelResponseDTO postReq(FetureContext<OneBankSynthesizeTemplateWithPdfIdReqDTO, OneBankSynthesizeTemplateWithPdfIdRespDTO> fetureContext) {
        OneBankSynthesizeTemplateWithPdfIdReqDTO reqDTO = fetureContext.getSpReq();
        ValidateUtils.notNull(reqDTO.getElectronicTemplateKey(),"印章模版KEY不能为空!");
        String templateCode = this.getTemplateCode(reqDTO.getElectronicTemplateKey());
        String fieldBeanListXml = this.getFieldBeanListXml(reqDTO.getFieldMap());
        try {
            LambdaLogger.debug(log, "流水号:{} >> [{}] 电子印章系统请求填充数据：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> fieldBeanListXml);
            String savedPdfId = reqDTO.getSavedPdfId() == null ? "" : reqDTO.getSavedPdfId();
            String synthesizeResult = this.paperlessClient.synthesizeTemplateWithPdfId(reqDTO.getClientTradeId(),templateCode,savedPdfId,fieldBeanListXml,null,null,onebankElectronicProperties.getOperatorCode(),onebankElectronicProperties.getChannelCode());
            LambdaLogger.info(log, "流水号:{} >> [{}] 电子印章系统返回数据：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> synthesizeResult);
            String code = cfca.paperless.client.util.StringUtil.getNodeText(synthesizeResult,"Code");
            if("200".equals(code)){
                String respononseSavedPdfId = cfca.paperless.client.util.StringUtil.getNodeText(synthesizeResult,"SavedPdfId");
                OneBankSynthesizeTemplateWithPdfIdRespDTO oneBankSynthesizeTemplateWithPdfIdRespDTO = new OneBankSynthesizeTemplateWithPdfIdRespDTO();
                oneBankSynthesizeTemplateWithPdfIdRespDTO.setSavedPdfId(respononseSavedPdfId);
                ChannelResponseDTO channelResponseDTO = ChannelResponseUtil.success(oneBankSynthesizeTemplateWithPdfIdRespDTO,null,code);
                channelResponseDTO.setServerTransId(fetureContext.getClientTradeId());
                channelResponseDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                return channelResponseDTO;
            }else {
                String message = cfca.paperless.client.util.StringUtil.getNodeText(synthesizeResult,"Message");
                if(StringUtil.isBlank(message)){
                    message = "电子印章系统异常";
                }
                return ChannelResponseDTO.builder()
                        .serverTransId(fetureContext.getClientTradeId())
                        .message(message)
                        .exception(StringUtil.truncate(message,800))
                        .channelRespCode(code)
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
