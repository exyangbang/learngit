package cn.kingnet.utp.channel.onebank.baffle.service;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @author zhongli
 */
@Slf4j
public abstract class BaseOnebankPayService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> {
    protected final ServiceContext serviceContext;
    protected final UtpDbmTemplate utpDbmTemplate;
    protected final OnebankChannelProperties onebankChannelProperties;

    protected ExecutorService executorService;

    protected final String SUCCESS = "PCC00000";
    protected final Class<REQ> spReqClass;

    public BaseOnebankPayService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        serviceContext = this.getClass().getDeclaredAnnotation(ServiceContext.class);
        Assert.notNull(serviceContext, this.getClass().getName().concat("未添加注解 @ServiceContext"));
        this.utpDbmTemplate = utpDbmTemplate;
        this.onebankChannelProperties = onebankChannelProperties;
        this.executorService = executorService;
        spReqClass = (Class<REQ>) serviceContext.bodyClass();
    }


    /**
     * 同步调用渠道
     *
     * @param request
     * @return
     */
    public CompletableFuture<?> doSyncWork(ServerRequest request) {
        String traceId = IdGenerate.get32UUID();
        CompletableFuture<?> monoFeture = CompletableFuture.supplyAsync(() -> getRequestBody(traceId, request, spReqClass), executorService)
                .thenApply(this::syncReq)
                .exceptionally(e -> {
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
        FetureContext<REQ,RESP> fetureContext = new FetureContext(traceId, IdGenerate.get32UUID(), spReq.getClientTradeId(), spReq.getReqDate(), spReq.getReqTime(), spReq);
        return fetureContext;
    }

    /**
     * 获取参数
     *
     * @param request
     * @return
     */
    public REQ getRequestParam(ServerRequest request) {
        String clientTradeId = request.queryParam("clientTradeId").orElseGet(() -> IdGenerate.generateServerTransId("BAF", "99999"));
        String reqDate = request.queryParam("reqDate").orElseGet(() -> LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        String reqTime = request.queryParam("reqTime").orElseGet(() -> LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        REQ req;
        try {
            req = spReqClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ChannelResponseException(HttpStatus.BAD_GATEWAY, String.format("初始化[%s]请求实例异常:%s", spReqClass.getName(), e.getMessage()));
        }
        req.setClientTradeId(clientTradeId);
        req.setReqDate(reqDate);
        req.setReqTime(reqTime);
        return req;
    }


    protected Map<String,Object> buildSpResponse(FetureContext<REQ, RESP> fetureContext) {
        Map<String,Object> spMap;
        try {
            RESP resp = (RESP) fetureContext.getSpResp().getClass().newInstance();
            resp.setClientTradeId(fetureContext.getClientTradeId());
            resp.setServerTradeId(resp.getClientTradeId());
            resp.setStatus(HttpRespStatus.OK.toString());
            fetureContext.setSpResp(resp);
            spMap = BeanMap.create(resp);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ChannelResponseException(HttpStatus.BAD_GATEWAY, String.format("初始化[%s]实例异常:%s", fetureContext.getSpResp().getClass().getName(), e.getMessage()));
        }
        return spMap;
    }

    protected abstract String apiName();

    protected ChannelResponseDTO syncReq(FetureContext<REQ, RESP> fetureContext) {
        REQ req = fetureContext.getSpReq();
        log.info("流水号:{} >> 挡板模拟[{}] 请求报文：{}", req.getClientTradeId(), apiName(), JSON.toJSONString(req));
        try {
            Object resp = buildSpResponse(fetureContext);
            log.info("流水号:{} << 挡板模拟[{}] 响应报文：{}", req.getClientTradeId(), apiName(), JSON.toJSONString(resp));
            return ChannelResponseDTO.builder()
                    .serverTransId(req.getClientTradeId())
                    .channelRespCode(SUCCESS)
                    .message("挡板模拟华通渠道响应成功")
                    .status(HttpRespStatus.OK.valueStr())
                    .spRespMsg(BeanMap.create(resp))
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        } catch (Exception e) {
            log.error("流水号:{} << 挡板模拟[{}] 响应异常：{}", req.getClientTradeId(), apiName(), e.getMessage(), e);
            return ChannelResponseDTO.builder()
                    .serverTransId(req.getClientTradeId())
                    .message("渠道异常:".concat(e.getMessage()))
                    .exception(e.getMessage())
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }


}
