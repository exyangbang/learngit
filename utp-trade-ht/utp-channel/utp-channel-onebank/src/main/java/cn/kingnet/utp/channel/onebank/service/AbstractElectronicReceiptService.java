package cn.kingnet.utp.channel.onebank.service;

import cfca.paperless.client.bean.FieldBean;
import cfca.paperless.client.bean.SignLocation;
import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.PaperlessUtil;
import cn.kingnet.utp.channel.onebank.configuration.OnebankElectronicProperties;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.ElectronicTemplateKey;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 签章抽象服务
 * @Author : linkaigui
 * @Create : 2020/7/6 10:36
 */
@Slf4j
public abstract class AbstractElectronicReceiptService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> implements IOnebankPayService<REQ,RESP>{

    protected final ServiceContext serviceContext;

    protected final ExecutorService executorService;

    protected Class<REQ> spReqClass;

    protected final PaperlessClient paperlessClient;

    protected final OnebankElectronicProperties onebankElectronicProperties;

    protected AbstractElectronicReceiptService(ExecutorService executorService, PaperlessClient paperlessClient, OnebankElectronicProperties onebankElectronicProperties) {
        this.serviceContext = this.getClass().getDeclaredAnnotation(ServiceContext.class);
        Assert.notNull(serviceContext, this.getClass().getName().concat("未添加注解 @ServiceContext"));
        this.paperlessClient = paperlessClient;
        this.onebankElectronicProperties = onebankElectronicProperties;
        this.executorService = executorService;
        this.spReqClass = (Class<REQ>) serviceContext.bodyClass();
    }

    @Override
    public CompletableFuture<?> doSyncWork(ServerRequest request) {
        String traceId = IdGenerate.get32UUID();
        CompletableFuture<?> monoFeture = CompletableFuture.supplyAsync(() -> getRequestBody(traceId, request, spReqClass), executorService)
                .thenApply(this::syncReq)
                .exceptionally((e) -> {
                    if (e instanceof ChannelResponseException) {
                        throw (ChannelResponseException) e;
                    } else if (e.getCause() instanceof ChannelResponseException) {
                        throw (ChannelResponseException) e.getCause();
                    }
                    throw new ChannelResponseException(e);
                });
        return monoFeture;
    }

    protected FetureContext<REQ, RESP> getRequestBody(String traceId, ServerRequest request, Class<REQ> clazz) {
        REQ spReq;
        if (clazz == null || javax.lang.model.type.NullType.class.getName().equals(clazz.getName())
                || javax.lang.model.type.NoType.class.getName().equals(clazz.getName())) {
            spReq = getRequestParam(request);
        } else {
            spReq = request.bodyToMono(clazz).toProcessor().block();
        }
        LambdaLogger.debug(log, ">> [{}] 请求华通渠道层 ==>> 请求报文体:{}", () -> apiName(), () -> JSON.toJSONString(spReq));
        FetureContext<REQ, RESP> fetureContext = new FetureContext(traceId, IdGenerate.get32UUID(), spReq.getClientTradeId(), spReq.getReqDate(), spReq.getReqTime(), spReq);
        return fetureContext;
    }

    /**
     * 获取参数
     *
     * @param request
     * @return
     */
    public REQ getRequestParam(ServerRequest request) {
        return null;
    }

    /**
     * 同步请求数据
     *
     * @param fetureContext
     * @return
     */
    protected ChannelResponseDTO syncReq(FetureContext<REQ, RESP> fetureContext) {
        try {
            return postReq(fetureContext);
        } catch (Exception e) {
            LambdaLogger.error(log, "流水号:{} >> [{}] 请求华通渠道层异常：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> e.getMessage(), () -> e);
            return ChannelResponseDTO.builder()
                    .serverTransId(fetureContext.getClientTradeId())
                    .message("渠道异常!")
                    .exception(StringUtil.truncate(e.getMessage(),800))
                    .status(HttpRespStatus.SERVER_ERROR.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    /**
     * 获取模版ID
     * @param electronicTemplateKey
     * @return
     */
    protected String getTemplateCode(ElectronicTemplateKey electronicTemplateKey){
        return onebankElectronicProperties.getTemplateConfig(electronicTemplateKey).getTemplateCode();
    }

    /**
     * 合成到PDF文本域的业务数据
     * @param fieldMap
     * @return
     */
    protected String getFieldBeanListXml(Map<String,Object> fieldMap){
        if(fieldMap == null || fieldMap.isEmpty()){
            return null;
        }
        List<FieldBean> fieldBeanList = new ArrayList<>(fieldMap.size());
        fieldMap.entrySet().forEach(field ->{
            String value = field.getValue() == null ? "" : field.getValue().toString();
            FieldBean fieldBean = new FieldBean(field.getKey(),value,"","text");
            fieldBeanList.add(fieldBean);
        });
        return PaperlessUtil.buildFieldBeanListXml(fieldBeanList);
    }

    protected SignLocation getSignLocation(ElectronicTemplateKey electronicTemplateKey){
        OnebankElectronicProperties.TemplateConfig templateConfig = onebankElectronicProperties.getTemplateConfig(electronicTemplateKey);
        String signLocationType = templateConfig.getSignLocationType();
        SignLocation signLocation = null;
        switch (signLocationType){
            case "1" :{
                // 1=按空白标签域签章
                signLocation = new SignLocation();
                signLocation.setType("1");
            }
            break;
            case "2" :{
                // 2=按坐标签章
                // 页数，按坐标签章时不能为空；
                // 左侧的x坐标（单位：像素）；左侧的y坐标（单位：像素）；
                signLocation = new SignLocation(templateConfig.getPage(), templateConfig.getLeftX(), templateConfig.getLeftY());
            }
            break;
            case "3" :{
                // 3=按关键字签章
                // 关键字，按关键字签章时不能为空；
                // 位置风格：（上:U；下:D；左:L；右:R；中:C）；默认：C；
                // 横轴偏移，默认为0（单位：像素）；纵轴偏移，默认为0（单位：像素）
                signLocation = new SignLocation(templateConfig.getKeyword(), templateConfig.getLocationStyle(), templateConfig.getOffsetX(), templateConfig.getOffsetY());
                // 关键字位置索引（1：第一个位置；2：第二个位置；0：默认全部位置盖章，支持1、2、1-3、3-9格式，如果输入非法数字或者负数当做0处理，如果输入的数字大于关键字数量时就在最后一个位置盖章处理）
                signLocation.setKeywordPositionIndex(templateConfig.getKeywordPositionIndex());
            }
            break;
            case "4" :{
                // 4=按位置标识签章（需要提前在服务端管理页面上登录业务模板和签章位置标识信息）
                // 签章位置标识编码
                signLocation = new SignLocation(templateConfig.getLocationCode());
            }
            break;
            default:{
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "模版未配置签章类型:" + electronicTemplateKey.getCode());
            }
        }
        return signLocation;
    }

    protected abstract ChannelResponseDTO postReq(FetureContext<REQ, RESP> fetureContext);

    protected abstract String apiName();
}
