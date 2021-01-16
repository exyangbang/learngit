package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.ChannelRespcodeUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.client.api.Request;
import cn.onebank.dmb.client.api.Response;
import cn.onebank.dmb.client.exception.DMBException;
import cn.onebank.dmb.client.util.DmbUtil;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import cn.onebank.dmb.common.message.SysHeader;
import cn.onebank.dmb.common.protocol.ConstantsForProto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 对公交易结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 13:53
 */
@Component("publicTransQuery")
@ServiceContext(bodyClass = OneBankTransQueryReqDTO.class)
@Slf4j
public class PublicTransQueryService extends BaseOnebankPayService<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO> {

    private static final String PUBLIC_TRANS_QUERY_KEY = "publicTransQuery";
    private static final String API_NAME = UnionPaySubTypeEnum.PUBLIC_TRANS_QUERY.getDesc();
    @Resource
    private ChannelRespcodeUtil channelRespcodeUtil;

    public PublicTransQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected ChannelResponseDTO syncReq(FetureContext<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO>  fetureContext) {
        OneBankTransQueryReqDTO oneBankTransQueryReqDTO = fetureContext.getSpReq();
        log.info("流水号:{} >> [CDFA异步对公转账交易结果查询] 请求参数：==>> {}", oneBankTransQueryReqDTO.getClientTradeId(), JSON.toJSONString(oneBankTransQueryReqDTO));
        Message message = preReq(fetureContext);
        Request request = new Request(message, this.onebankChannelProperties.getTimeout());
        Response rsp = null;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("流水号:{} >> [CDFA异步对公转账交易结果查询] 调用渠道接口异常：==>> {}", oneBankTransQueryReqDTO.getClientTradeId(), e.getMessage(), e);
            String exceptionMsg = StringUtil.truncate(e.getMessage(),800);
            return ChannelResponseDTO.builder()
                    .serverTransId(oneBankTransQueryReqDTO.getClientTradeId())
                    .message(String.format("[%s]渠道异常:%s", e.getErrorCode(), exceptionMsg))
                    .exception(e.getClass().getName()+":"+exceptionMsg)
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否系统成功
        if (ConstantsForProto.SYSTEM_FAIL.equals(rsp.getMessage().getSysHead().getTransactionReturnStatus())) {
            log.error("流水号:{} << [CDFA异步对公转账交易结果查询] 渠道响应系统报文头状态为失败 <<== {}", oneBankTransQueryReqDTO.getClientTradeId(), JSON.toJSONString(rsp.getMessage().getSysHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId(oneBankTransQueryReqDTO.getClientTradeId())
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道响应系统报文头状态为失败")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否业务成功
        if (rsp.getMessage().getAppHead() != null && rsp.getMessage().getAppHead().getRet() != null) {
            //成功则取包处理
            JSONObject respBody = JSON.parseObject(new String(rsp.getMessage().getBody()));
            log.info("流水号:{} << [CDFA异步对公转账交易结果查询] 响应报文体：{}", oneBankTransQueryReqDTO.getClientTradeId(), respBody == null ? null : respBody.toJSONString());

            String respCode = respBody.getString("respCode");
            String respMsg = respBody.getString("respMsg");
            String payTranStatus = respBody.getString("payTranStatus");
            //未识别的默认交易状态及描述
            String transStatus = "", statusDesc = "";
            String status = HttpRespStatus.OK.valueStr(), exceptionMsg = String.format("[%s] %s", StringUtil.trimToEmpty(respCode), StringUtil.trimToEmpty(respMsg));
            ChannelResponseDTO.ChannelResponseDTOBuilder channelResponseDTOBuilder = ChannelResponseDTO.builder().serverTransId(oneBankTransQueryReqDTO.getClientTradeId());

            if (OneBankRespCode.PCC00000.name().equals(respCode)) {
                respBody.put("orgrespcode", respBody.get("orgrespcode"));
                respBody.put("orgrespmsg", respBody.get("orgrespmsg"));
                respBody.put("reconcileDate", respBody.get("settleDate"));
                if (HTPayTranStatus.PR03.name().equalsIgnoreCase(payTranStatus)) {
                    transStatus = TransStatus.TRADE_SUCCESS.name();
                    statusDesc = "交易成功";
                } else if (HTPayTranStatus.PR02.name().equalsIgnoreCase(payTranStatus)) {
                    transStatus = TransStatus.TRADE_FAILURE.name();
                    statusDesc = "交易失败";
                    exceptionMsg = String.format("[%s] %s,原响应码[%s]-%s", StringUtil.trimToEmpty(respCode), StringUtil.trimToEmpty(respMsg), respBody.get("orgrespcode"), respBody.get("orgrespmsg"));
                } else if (HTPayTranStatus.PR00.name().equalsIgnoreCase(payTranStatus)) {
                    transStatus = TransStatus.PROCESSING.name();
                    statusDesc = "处理中";
                    exceptionMsg = String.format("[%s] %s,原响应码[%s]-%s", StringUtil.trimToEmpty(respCode), StringUtil.trimToEmpty(respMsg), respBody.get("orgrespcode"), respBody.get("orgrespmsg"));
                } else {
                    status = HttpRespStatus.NOT_ACCEPTABLE.valueStr();
                    exceptionMsg = String.format("[%s] %s,原响应码[%s]-%s;未识别其他渠道返回交易状态[%s]", StringUtil.trimToEmpty(respCode), StringUtil.trimToEmpty(respMsg), respBody.get("orgrespcode"), respBody.get("orgrespmsg"), payTranStatus);
                }
            } else if (OneBankRespCode.PCC000002.name().equals(respCode) || channelRespcodeUtil.isFailureRespcode(respCode)) {
                transStatus = TransStatus.TRADE_FAILURE.name();
                statusDesc = "交易失败";
            } else {
                status = HttpRespStatus.NOT_ACCEPTABLE.valueStr();
                exceptionMsg = String.format("[%s] %s ,未识别其他渠道返回响应码[%s]", StringUtil.trimToEmpty(respCode), StringUtil.trimToEmpty(respMsg), respCode);
            }


            respBody.put("transStatus", transStatus);
            respBody.put("statusDesc", statusDesc);
            return channelResponseDTOBuilder
                    .channelRespCode(respCode)
                    .message(respMsg)
                    .status(status)
                    .spRespMsg(respBody)
                    .exception(exceptionMsg)
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        } else {
            log.error("流水号:{} << [CDFA异步对公转账交易结果查询] 渠道响应应用报文头appHead为空或报文头内容appHead.ret为空 <<== {}", oneBankTransQueryReqDTO.getClientTradeId(), rsp.getMessage().getAppHead() == null ? null : JSON.toJSONString(rsp.getMessage().getAppHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId(oneBankTransQueryReqDTO.getClientTradeId())
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道响应应用报文头appHead为空或报文头内容appHead.ret为空")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    @Override
    public SysHeader buildSysHeader(FetureContext<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO>  fetureContext) {
        OneBankTransQueryReqDTO requestDTO = fetureContext.getSpReq();
        SysHeader sysHeader = new SysHeader();
        /**目标dfa值 ：由华通提供*/
        sysHeader.setTargetDfa(UtpDMBUtil.getCDfaNumSync());
        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(this.onebankChannelProperties.getTransfer(PUBLIC_TRANS_QUERY_KEY).getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(this.onebankChannelProperties.getTransfer(PUBLIC_TRANS_QUERY_KEY).getSceneId());
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(requestDTO.getClientTradeId());
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(requestDTO.getClientTradeId());
        /**交易发生日期*/
        sysHeader.setTransactionDateTime(new StringBuilder(requestDTO.getTradeDate()).append(":").append(requestDTO.getTradeTime()).toString());
        /**账号*/
        sysHeader.setAcctNo(requestDTO.getAcctNo());
        /**账号类型*/
        sysHeader.setAcctType(requestDTO.getAcctType());
        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO>  fetureContext) {
        AppHeader appHeader = new AppHeader();
        return appHeader;
    }

    @Override
    public Object buildContent(FetureContext<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO>  fetureContext) {
        OneBankTransQueryReqDTO requestDTO = fetureContext.getSpReq();
        Map<String, Object> content = new HashMap<>(8);
//        content.put("orgId", this.onebankChannelProperties.getTxnBranchCode());//交易机构号
        content.put("payTransType", requestDTO.getPayTransType());//交易类型
        content.put("chlCode", this.onebankChannelProperties.getChannelId());//渠道编码
        content.put("oldReqDate", requestDTO.getReqDate());//原订单委托日期
        content.put("oldBusinessId", requestDTO.getOrigServerTradeId());//原业务流水
        content.put("oldTransId", requestDTO.getOrigServerTradeId());//原交易流水
        return content;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
