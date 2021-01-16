package cn.kingnet.utp.channel.onebank.service;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.OneBankRespCode;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.client.api.Request;
import cn.onebank.dmb.client.api.Response;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import cn.onebank.dmb.common.message.RetBean;
import cn.onebank.dmb.common.message.SysHeader;
import cn.onebank.dmb.common.protocol.ConstantsForProto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

/**
 * @author zhongli
 */
@Slf4j
public abstract class BaseOnebankPayService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> implements IOnebankPayService<REQ,RESP>{
    protected final ServiceContext serviceContext;
    protected final UtpDbmTemplate utpDbmTemplate;
    protected final OnebankChannelProperties onebankChannelProperties;

    protected ExecutorService executorService;
    protected Class<REQ> spReqClass;

    public BaseOnebankPayService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        serviceContext = this.getClass().getDeclaredAnnotation(ServiceContext.class);
        Assert.notNull(serviceContext, this.getClass().getName().concat("未添加注解 @ServiceContext"));
        this.utpDbmTemplate = utpDbmTemplate;
        this.onebankChannelProperties = onebankChannelProperties;
        this.executorService = executorService;
        this.spReqClass = (Class<REQ>) serviceContext.bodyClass();
    }


    /**
     * 同步调用渠道
     *
     * @param request
     * @return
     */
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

    protected Message preReq(FetureContext<REQ, RESP> fetureContext) {
        SysHeader sysHeader = buildSysHeader(fetureContext);
        AppHeader appHead = buildAppHeader(fetureContext);
        Object request = buildContent(fetureContext);
        LambdaLogger.info(log, "流水号:{} >> [{}] 请求华通渠道 ==>>报文头:{} \n请求报文体:{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> JSON.toJSONString(sysHeader), () -> JSON.toJSONString(request));
        return new Message(sysHeader, appHead, JSONArray.toJSONBytes(request));
    }

    /**
     * 构造系统报文头
     *
     * @param fetureContext
     * @return
     */
    public abstract SysHeader buildSysHeader(FetureContext<REQ, RESP> fetureContext);

    /**
     * 构造应用报文头
     *
     * @param fetureContext
     * @return
     */
    public abstract AppHeader buildAppHeader(FetureContext<REQ, RESP> fetureContext);

    /**
     * 构造请求报文体
     *
     * @param fetureContext
     * @return
     */
    public abstract Object buildContent(FetureContext<REQ, RESP> fetureContext);

    /**
     * 同步请求数据
     *
     * @param fetureContext
     * @return
     */
    protected ChannelResponseDTO syncReq(FetureContext<REQ, RESP> fetureContext) {
        Message message = null;
        try {
            message = preReq(fetureContext);
            /**5秒超时*/
            Request req = new Request(message, onebankChannelProperties.getTimeout());
            Response rsp = utpDbmTemplate.sendRequest(req);
            return postReq(rsp, fetureContext);
        } catch (Exception e) {
            LambdaLogger.error(log, "流水号:{} >> [{}] 请求华通渠道异常：{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> e.getMessage(), () -> e);
            return ChannelResponseDTO.builder()
                    .serverTransId(message == null || message.getSysHead() == null ? null : message.getSysHead().getConsumerSeqNo())
                    .message("渠道异常!")
                    .exception(StringUtil.truncate(e.getMessage(),800))
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    protected ChannelResponseDTO postReq(Response rsp, FetureContext<REQ, RESP> fetureContext) {
        //判断是否系统成功
        if (ConstantsForProto.SYSTEM_FAIL.equals(rsp.getMessage().getSysHead().getTransactionReturnStatus())) {
            LambdaLogger.error(log, "流水号:{} << [{}] 响应系统报文头状态[{}]失败.sysHead<<== {}", fetureContext.getClientTradeId(), apiName(), ConstantsForProto.SYSTEM_FAIL, JSON.toJSONString(rsp.getMessage().getSysHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId(rsp.getMessage().getSysHead().getConsumerSeqNo())
                    .channelRespCode(ConstantsForProto.SYSTEM_FAIL.concat(ConstantsForProto.APP_SUCCESS))
                    .message("华通渠道返回系统报文头 sysHead 状态异常")
                    .status(HttpRespStatus.FORBIDDEN.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否业务成功
        if (rsp.getMessage().getAppHead() != null && rsp.getMessage().getAppHead().getRet() != null) {
            for (RetBean i : rsp.getMessage().getAppHead().getRet()) {
                if (!OneBankRespCode.PCC00000.name().equals(i.getReturnCode())) {
                    LambdaLogger.error(log, "流水号:{} << [{}] 系统报文头响应码非成功，响应报文头sysHead <<== {}; appHead <<== {}", fetureContext.getClientTradeId(), apiName(), JSON.toJSONString(rsp.getMessage().getSysHead()), JSON.toJSONString(rsp.getMessage().getAppHead()));
                    String channelReturnMsg = StringUtil.truncate(i.getReturnMsg(),800);
                    return ChannelResponseDTO.builder()
                            .serverTransId(rsp.getMessage().getSysHead().getConsumerSeqNo())
                            .channelRespCode(i.getReturnCode())
                            .message(channelReturnMsg)
                            .exception(String.format("系统报文头响应码非成功[%s]%s", i.getReturnCode(), channelReturnMsg))
                            .status(HttpRespStatus.FORBIDDEN.valueStr())
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build();
                }
            }
            //成功则取包处理
            String rspString = new String(rsp.getMessage().getBody());
            return convertPostReqBody(rsp.getMessage().getSysHead(), rspString,fetureContext);
        }

        LambdaLogger.warn(log, "流水号:{} << [{}] 响应码状态非成功，响应系统报文头sysHead <<== {}; appHead <<=={}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> JSON.toJSONString(rsp.getMessage().getSysHead()),
                () -> JSON.toJSONString(rsp.getMessage().getAppHead()));
        return ChannelResponseDTO.builder()
                .serverTransId(rsp.getMessage().getSysHead().getConsumerSeqNo())
                .channelRespCode(ConstantsForProto.SYSTEM_FAIL.concat(ConstantsForProto.APP_SUCCESS))
                .message("华通渠道未返回应用报文头 appHead信息")
                .status(HttpRespStatus.FORBIDDEN.valueStr())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    /**
     * 转换应答报文体
     *
     * @param sysHeader
     * @param rspString
     * @return
     */
    protected ChannelResponseDTO convertPostReqBody(SysHeader sysHeader, String rspString,FetureContext<REQ,RESP> fetureContext) {
        JSONObject map = JSON.parseObject(rspString);
        String respCode = null, respMsg = null;
        if (map != null) {
            respCode = map.getString("respCode");
            respMsg = StringUtil.truncate(map.getString("respMsg"),800);
        }
        if (map != null && map.containsKey("respCode")) {
            respCode = map.getString("respCode");
            respMsg = StringUtil.truncate(map.getString("respMsg"),800);
            if (!OneBankRespCode.PCC00000.name().equals(respCode)) {
                LambdaLogger.error(log, "流水号:{} << [{}] 华通渠道系统返回响应码非成功：响应码[{}] 响应码描述[{}] 响应报文体body <<== {}",fetureContext.getClientTradeId(),apiName(), respCode, respMsg, map.toJSONString());
                return ChannelResponseDTO.builder()
                        .serverTransId(sysHeader.getConsumerSeqNo())
                        .status(HttpRespStatus.SERVER_ERROR.valueStr())
                        .channelRespCode(respCode)
                        .exception(String.format("华通渠道系统返回响应码非成功:[%s]%s", respCode, respMsg))
                        .message(respMsg).build();
            }
        } else {
            LambdaLogger.error(log, "流水号:{} << [{}] 华通渠道系统返回报文为空或respCode值为空：响应码[{}] 响应码描述[{}] 响应报文体body <<== {}", fetureContext.getClientTradeId(),apiName(),respCode, respMsg, map == null ? null : map.toJSONString());
            return ChannelResponseDTO.builder()
                    .serverTransId(sysHeader.getConsumerSeqNo())
                    .status(HttpRespStatus.SERVER_ERROR.valueStr())
                    .channelRespCode(respCode)
                    .exception(String.format("华通渠道系统返回报文为空或respCode值为空:[%s]%s", respCode, respMsg))
                    .message(respMsg).build();
        }
        LambdaLogger.info(log, "流水号:{} << [{}] 华通渠道响应 <<== 报文头:{} \n响应报文体:{}", () -> fetureContext.getClientTradeId(), () -> apiName(), () -> JSON.toJSONString(sysHeader), () -> map.toJSONString());
        return ChannelResponseDTO.builder()
                .status(HttpRespStatus.OK.valueStr())
                .channelRespCode(respCode)
                .message(respMsg)
                .spRespMsg(map)
                .serverTransId(sysHeader.getConsumerSeqNo()).build();
    }

    /**
     * @param jsonArray o->underlineToCamel(key)
     * @return
     */
    protected List<Map<String, Object>> convertJsonArray2ListMap(JSONArray jsonArray) {
        List<Map<String, Object>> listMap = null;
        if (jsonArray != null && !jsonArray.isEmpty()) {
            listMap = jsonArray.stream().filter(o -> o != null).map(o -> {
                JSONObject returnObj = (JSONObject) o;
                Map<String, Object> tempMap = Maps.newHashMap();
                returnObj.forEach((key, value) -> tempMap.put(StringUtil.underlineToCamel(key), value));
                return tempMap;
            }).collect(Collectors.toList());
        }
        return listMap;
    }

    /**
     * @param sex 簿记：M男 F女
     * @return 华通：1男2女
     */
    protected String toGenderTpCd(String sex) {
        return "M".equals(sex) ? "1" : "F".equals(sex) ? "2" : null;
    }

    protected abstract String apiName();

}
