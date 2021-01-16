package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.ContactMethod;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.client.api.Request;
import cn.onebank.dmb.client.api.Response;
import cn.onebank.dmb.client.exception.DMBException;
import cn.onebank.dmb.client.util.DmbUtil;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import cn.onebank.dmb.common.message.RetBean;
import cn.onebank.dmb.common.message.SysHeader;
import cn.onebank.dmb.common.protocol.ConstantsForProto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @author WJH
 * @date 2019/10/30
 */
@Slf4j
public abstract class AbstractEcifOnebankPaymentService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> extends BaseOnebankPayService<REQ, RESP> {


    public AbstractEcifOnebankPaymentService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @PostConstruct
    public void init() {
        initCheck();
    }


    protected void initCheck() {
        OnebankChannelProperties.Transfer transfer = getTransfer(key());
        Assert.hasText(transfer.getServiceId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".service_id"));
        Assert.hasText(transfer.getSceneId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".scene_id"));
    }


    @Override
    protected Message preReq(FetureContext<REQ, RESP> fetureContext) {
        SysHeader sysHeader = buildSysHeader(fetureContext);
        AppHeader appHead = buildAppHeader(fetureContext);
        Object request = buildContent(fetureContext);
        LambdaLogger.info(log, "流水号:{} >> [{}] 请求华通渠道 ==>>报文头:{} \n请求报文体:{}", () -> sysHeader.getConsumerSeqNo(), () -> apiName(), () -> JSON.toJSONString(sysHeader), () -> JSON.toJSONString(request, new PascalNameFilter()));
        //PascalNameFilter 字段首字母自动转换为大写
        return new Message(sysHeader, appHead, JSONArray.toJSONBytes(request, new PascalNameFilter()));
    }

    @Override
    protected ChannelResponseDTO syncReq(FetureContext<REQ, RESP> fetureContext) {
        REQ spReq = fetureContext.getSpReq();
        Request request = null;
        try {
            log.info("流水号:{} >> [{}] 请求参数 ==>> {}", spReq.getClientTradeId(), apiName(), JSON.toJSONString(spReq));
            Message message = preReq(fetureContext);
            request = new Request(message, this.onebankChannelProperties.getTimeout());
        } catch (Exception e) {
            log.error("流水号:{} >> [{}}] 构造渠道请求报文异常：==>> {}", spReq.getClientTradeId(), apiName(), e.getMessage(), e);
            String exceptionMsg = StringUtil.truncate(e.getMessage(),800);
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .message(String.format("[%s]构造渠道请求报文异常:%s", spReq.getClientTradeId(), exceptionMsg))
                    .exception(e.getClass().getName()+":"+exceptionMsg)
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        Response rsp;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("流水号:{} >> [{}}] 调用渠道接口异常：==>> {}", spReq.getClientTradeId(), apiName(), e.getMessage(), e);
            String exceptionMsg = StringUtil.truncate(e.getMessage(),800);
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .message(String.format("[%s]渠道异常:%s", e.getErrorCode(), exceptionMsg))
                    .exception(e.getClass().getName()+":"+exceptionMsg)
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否系统成功
        if (ConstantsForProto.SYSTEM_FAIL.equals(rsp.getMessage().getSysHead().getTransactionReturnStatus())) {
            log.error("流水号:{} << [{}}] 渠道响应系统报文头状态为失败 <<== {}", spReq.getClientTradeId(), apiName(), JSON.toJSONString(rsp.getMessage().getSysHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道响应系统报文头状态为失败")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否业务成功
        if (rsp.getMessage().getAppHead() != null && rsp.getMessage().getAppHead().getRet() != null) {
            String returnCode = "";
            for (RetBean i : rsp.getMessage().getAppHead().getRet()) {
                returnCode = i.getReturnCode();
                if (!ConstantsForProto.APP_SUCCESS.equals(i.getReturnCode())) {
                    log.error("流水号:{} << [{}}] 渠道响应应用报文头状态为非成功 <<== {}", spReq.getClientTradeId(), apiName(), JSON.toJSONString(i));
                    String channelReturnMsg = StringUtil.truncate(i.getReturnMsg(),800);
                    return ChannelResponseDTO.builder()
                            .serverTransId(spReq.getClientTradeId())
                            .channelRespCode(i.getReturnCode())
                            .message(channelReturnMsg)
                            .exception(String.format("[%s]%s", i.getReturnCode(), channelReturnMsg))
                            .status(HttpRespStatus.FORBIDDEN.valueStr())
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build();
                }
            }

            //成功则取包处理
            JSONObject respBody = JSON.parseObject(new String(rsp.getMessage().getBody()));
            log.info("流水号:{} << [{}}] 响应报文体：{}", spReq.getClientTradeId(), apiName(), respBody == null ? null : respBody.toJSONString());
            Map<String, Object> reMap = parseRespBody(fetureContext, rsp.getMessage().getBody());

            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .channelRespCode(returnCode)
                    .status(HttpRespStatus.OK.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .spRespMsg(reMap)
                    .build();
        } else {
            log.error("流水号:{} << [{}}] 渠道响应应用报文头appHead为空或报文头内容appHead.ret为空 <<== {}", spReq.getClientTradeId(), apiName(), rsp.getMessage().getAppHead() == null ? null : JSON.toJSONString(rsp.getMessage().getAppHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道响应应用报文头appHead|appHead.ret为空")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    @Override
    public SysHeader buildSysHeader(FetureContext<REQ, RESP> fetureContext) {
        OnebankChannelProperties.Transfer transfer = getTransfer(key());
        REQ spReq = fetureContext.getSpReq();
        SysHeader sysHeader = new SysHeader();
        sysHeader.setChannelDetail(this.onebankChannelProperties.getChannelId());
        sysHeader.setServiceId(transfer.getServiceId());
        sysHeader.setSceneId(transfer.getSceneId());
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        sysHeader.setBizSeqNo(spReq.getClientTradeId());
        sysHeader.setConsumerSeqNo(spReq.getClientTradeId());
        sysHeader.setTransactionDateTime(new StringBuilder(spReq.getReqDate()).append(":").append(spReq.getReqTime()).toString());
        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext<REQ, RESP> fetureContext) {
        AppHeader appHead = new AppHeader();
        return appHead;
    }

    /**
     * 默认sp渠道透传 | 若需要定制继承
     *
     * @param fetureContext
     * @param respBody
     * @return
     */
    protected Map<String, Object> parseRespBody(FetureContext<REQ, RESP> fetureContext, byte[] respBody) {
        return JSON.parseObject(respBody, new TypeReference<Map<String, Object>>() {
        }.getType());
    }

    public abstract String key();

    @Override
    protected abstract String apiName();

    public OnebankChannelProperties.Transfer getTransfer(String key) {
        Assert.hasText(key, () -> this.getClass().getName().concat(" is not defined method key(), the method return null."));
        return onebankChannelProperties.getTransfer(key);
    }

    /**
     * 根据 手机号码|固话 获取 ecif定义的类型
     * 103移动电话 301办公电话[产品设计0开头的为办公电话，其他为移动电话]
     *
     * @param telphone
     * @return
     */
    protected ContactMethod instanceContactMethodByTelphone(String telphone) {
        telphone = StringUtil.trimToEmpty(telphone);
        if (telphone.startsWith("0")) {
            return new ContactMethod("301", telphone);
        }
        return new ContactMethod("103", telphone);
    }

}
