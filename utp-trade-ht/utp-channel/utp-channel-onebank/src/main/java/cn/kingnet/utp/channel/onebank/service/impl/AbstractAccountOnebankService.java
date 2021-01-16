package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description 行内存款账户接口超类
 * @Author WJH
 * @Date 2019/11/04
 */
@Slf4j
public abstract class AbstractAccountOnebankService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> extends BaseOnebankPayService<REQ, RESP> {


    public AbstractAccountOnebankService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
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
        Assert.hasText(transfer.getPrcscd(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".prcscd"));
    }


    @Override
    protected Message preReq(FetureContext<REQ, RESP> fetureContext) {
        SysHeader sysHeader = buildSysHeader(fetureContext);
        AppHeader appHead = buildAppHeader(fetureContext);
        Object request = buildContent(fetureContext);
        LambdaLogger.info(log, "流水号:{} >> [{}] 请求华通渠道 ==>>报文头:{} \n请求报文体:{}", sysHeader.getConsumerSeqNo(), apiName(), JSON.toJSONString(sysHeader), JSON.toJSONString(request));
        return new Message(sysHeader, appHead, JSONArray.toJSONBytes(request));
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
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .message(String.format("[%s]构造渠道请求报文异常:%s", spReq.getClientTradeId(), e.getMessage()))
                    .exception(e.getClass().getName())
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        Response rsp;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("流水号:{} >> [{}}] 调用渠道接口异常：==>> {}", spReq.getClientTradeId(), apiName(), e.getMessage(), e);
            return ChannelResponseDTO.builder()
                    .serverTransId(spReq.getClientTradeId())
                    .message(String.format("[%s]渠道异常:%s", e.getErrorCode(), e.getMessage()))
                    .exception(e.getClass().getName())
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
                    .message("渠道系统失败")
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
                    return ChannelResponseDTO.builder()
                            .serverTransId(spReq.getClientTradeId())
                            .channelRespCode(i.getReturnCode())
                            .message(i.getReturnMsg())
                            .exception(String.format("[%s]%s", i.getReturnCode(), i.getReturnMsg()))
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
                    .message("渠道系统失败")
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
        sysHeader.setServiceId(transfer.getServiceId());
        sysHeader.setSceneId(transfer.getSceneId());
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        sysHeader.setBizSeqNo(spReq.getClientTradeId());
        sysHeader.setConsumerSeqNo(spReq.getClientTradeId());
        sysHeader.setTransactionDateTime(new StringBuilder(spReq.getReqDate()).append(":").append(spReq.getReqTime()).toString());

        REQ req = fetureContext.getSpReq();
        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**全局业务流水号**/
        sysHeader.setBizSeqNo(req.getClientTradeId());
        /**服务调用流水号**/
        sysHeader.setConsumerSeqNo(req.getClientTradeId());
        /**服务调用服务id**/
        sysHeader.setServiceId(transfer.getServiceId());
        /**服务调用场景id**/
        sysHeader.setSceneId(transfer.getSceneId());
        /**交易发生日期 yyyyMMdd:HHmmss**/
        sysHeader.setTransactionDateTime(String.format("%s:%s", req.getReqDate(), req.getReqTime()));

        /**目标dfa值 ：由一般户|内部户选择 对公对私区*/
        /**帐号**/
        /**帐号类型**/
        sysHeader = addSpecificSysHeader(sysHeader, fetureContext);

        return sysHeader;
    }

    @Override
    public Object buildContent(FetureContext<REQ, RESP> fetureContext) {
        OnebankChannelProperties.Transfer transfer = getTransfer(key());
        /**报文体内的公共报文头**/
        Map<String, Object> comm_req = new HashMap<>(8);
        comm_req.put("CHANNEL_ID", this.onebankChannelProperties.getChannelId());
        comm_req.put("LEGAL_ENTITY", "8888");
        comm_req.put("TXN_BRANCH_CODE", this.onebankChannelProperties.getTxnBranchCode());
        comm_req.put("TXN_TELLER_ID", this.onebankChannelProperties.getTxnTellerId());

        /**报文体内的系统内部报文头**/
        Map<String, Object> sys = new HashMap<>(8);
        sys.put("isInnerSys", "false");
        sys.put("language", "en");
        sys.put("prcscd", transfer.getPrcscd());

        Map<String, Object> content = new HashMap<>(8);
        content.put("comm_req", comm_req);
        content.put("sys", sys);
        content.put("input", addInputContent(fetureContext));

        return content;
    }

    /**
     * 添加报文体内的业务入参
     *
     * @param fetureContext
     * @return
     */
    protected abstract Map<String, Object> addInputContent(FetureContext<REQ, RESP> fetureContext);

    /**
     * 通用系统报文头基础上新增具体话的参数
     * 主要包含 acctNo acctType 及targetDfa
     *
     * @param commonSysheadder
     * @return
     */
    protected abstract SysHeader addSpecificSysHeader(SysHeader commonSysheadder, FetureContext<REQ, RESP> fetureContext);

    @Override
    public AppHeader buildAppHeader(FetureContext<REQ, RESP> fetureContext) {
        AppHeader appHead = new AppHeader();
        return appHead;
    }

    /**
     * 响应成功的取包处理
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

}
