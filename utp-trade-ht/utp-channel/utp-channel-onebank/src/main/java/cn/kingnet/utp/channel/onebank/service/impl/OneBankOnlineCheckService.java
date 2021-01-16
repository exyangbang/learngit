package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOnlineCheckReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOnlineCheckRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.OneBankOnlineCheckCode;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.client.api.Request;
import cn.onebank.dmb.client.api.Response;
import cn.onebank.dmb.client.exception.DMBException;
import cn.onebank.dmb.client.util.CommonUtil;
import cn.onebank.dmb.client.util.DmbUtil;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import cn.onebank.dmb.common.message.SysHeader;
import cn.onebank.dmb.common.protocol.ConstantsForProto;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * @Description: 联网核查接口
 * @Author sheqingquan@scenetec.com
 * @Create 2020/7/2 16:57
 */
@Component("onlineCheck")
@ServiceContext(bodyClass = OneBankOnlineCheckReqDTO.class)
@Slf4j
public class OneBankOnlineCheckService extends BaseOnebankPayService<OneBankOnlineCheckReqDTO, OneBankOnlineCheckRespDTO> {

    private static final String ONLINE_CHECK_KEY = "onlineCheck";
    private static final String API_NAME = UnionPaySubTypeEnum.ONLINE_CHECK.getDesc();

    public OneBankOnlineCheckService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected ChannelResponseDTO syncReq(FetureContext<OneBankOnlineCheckReqDTO, OneBankOnlineCheckRespDTO> fetureContext) {
        OneBankOnlineCheckReqDTO oneBankOnlineCheckReqDTO = fetureContext.getSpReq();
        log.info("[联网核查] 请求参数 ==>> {}", JSON.toJSONString(oneBankOnlineCheckReqDTO));
        Message message = preReq(fetureContext);
        Request request = new Request(message, this.onebankChannelProperties.getTimeout());
        Response rsp = null;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("[联网核查] 调用渠道接口异常：==>>{}", e.getMessage(), e);
            String exceptionMsg = StringUtil.truncate(e.getMessage(), 800);
            return ChannelResponseDTO.builder()
                    .serverTransId("")
                    .message(String.format("[%s]渠道异常:%s", e.getErrorCode(), exceptionMsg))
                    .exception(e.getClass().getName() + ":" + exceptionMsg)
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否系统成功
        if (ConstantsForProto.SYSTEM_FAIL.equals(rsp.getMessage().getSysHead().getTransactionReturnStatus())) {
            log.error("[联网核查] 渠道响应系统报文头状态为失败 <<== {}", JSON.toJSONString(rsp.getMessage().getSysHead()));

            return ChannelResponseDTO.builder()
                    .serverTransId("")
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道系统失败[渠道响应系统报文头状态为失败]")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否业务成功
        if (rsp.getMessage().getAppHead() != null && rsp.getMessage().getAppHead().getRet() != null) {
            //成功则取包处理
            OneBankOnlineCheckRespDTO respDTO = JSON.parseObject(rsp.getMessage().getBody(), OneBankOnlineCheckRespDTO.class);
            log.info("[联网核查] 响应报文体：{}", JSON.toJSONString(respDTO));

            String respCode = respDTO.getReturnCode();
            String respMsg = respDTO.getReturnMsg();
            String msgServError = respDTO.getMsgServError();
            ChannelResponseDTO.ChannelResponseDTOBuilder channelResponseDTOBuilder = ChannelResponseDTO.builder().serverTransId("");
            if (OneBankOnlineCheckCode.SUCCESS.getRespCode().equals(respCode)) {
                List<OneBankOnlineCheckRespDTO.idArray> idArrayList = respDTO.getIdArray();
                OneBankOnlineCheckRespDTO.idArray idArray = idArrayList.get(0);
                //查询结果描述
                String msgIdResult = idArray.getMsgIdError();
                if (OneBankOnlineCheckCode.M00.getRespCode().equals(msgIdResult) || OneBankOnlineCheckCode.M01.getRespCode().equals(msgIdResult)) {
                    Map<String, Object> respMap = new HashMap<>(8);
                    respMap.put("msgIdError", idArray.getMsgIdError());
                    respMap.put("resultPersonId", idArray.getResultPersonId());
                    respMap.put("resultPersonName", idArray.getResultPersonName());
                    respMap.put("personName", idArray.getPersonName());
                    respMap.put("personId", idArray.getPersonId());
                    channelResponseDTOBuilder
                            .channelRespCode(respCode)
                            .message(respMsg)
                            .status(HttpRespStatus.OK.valueStr())
                            .spRespMsg(respMap)
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                } else {
                    OneBankOnlineCheckCode oneBankOnlineCheckCode = OneBankOnlineCheckCode.resolve(msgIdResult);
                    channelResponseDTOBuilder
                            .channelRespCode(oneBankOnlineCheckCode.getRespCode())
                            .status(HttpRespStatus.FORBIDDEN.valueStr())
                            .message(oneBankOnlineCheckCode.getDesc())
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            } else {
                log.error("[联网核查] 核查失败 <<== 响应码[{}]响应码描述[{}] 响应报文体:{}", respCode, respMsg, JSON.toJSONString(respDTO));
                channelResponseDTOBuilder
                        .channelRespCode(respCode)
                        .status(HttpRespStatus.NOT_ACCEPTABLE.valueStr())
                        .message(String.format("%s,%s", respMsg, msgServError))
                        .exception(String.format("核查失败 : [%s]%s", respCode, respMsg))
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            return channelResponseDTOBuilder.build();
        } else {
            log.error("[联网核查] 渠道响应应用报文头appHead为空或报文头内容appHead.ret为空 <<== {}", rsp.getMessage().getAppHead() == null ? null : JSON.toJSONString(rsp.getMessage().getAppHead()));
            return ChannelResponseDTO.builder()
                    .serverTransId("")
                    .channelRespCode(rsp.getMessage().getSysHead().getTransactionReturnStatus())
                    .message("渠道系统失败[渠道响应应用报文头appHead为空或报文头内容appHead.ret为空]")
                    .status(HttpRespStatus.BAD_GATEWAY.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
    }

    @Override
    public SysHeader buildSysHeader(FetureContext<OneBankOnlineCheckReqDTO, OneBankOnlineCheckRespDTO> fetureContext) {
        /**目标dfa值 ：华通告知无需传值*/

        OneBankOnlineCheckReqDTO requestDTO = fetureContext.getSpReq();
        SysHeader sysHeader = new SysHeader();
        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(this.onebankChannelProperties.getTransfer(ONLINE_CHECK_KEY).getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(this.onebankChannelProperties.getTransfer(ONLINE_CHECK_KEY).getSceneId());
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(requestDTO.getClientTradeId());
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(requestDTO.getClientTradeId());
        /**交易发生日期*/
        sysHeader.setTransactionDateTime(CommonUtil.getDateTimeStrForTran(new Date()));
        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext<OneBankOnlineCheckReqDTO, OneBankOnlineCheckRespDTO> fetureContext) {
        AppHeader appHeader = new AppHeader();
        return appHeader;
    }

    @Override
    public Object buildContent(FetureContext<OneBankOnlineCheckReqDTO, OneBankOnlineCheckRespDTO> fetureContext) {
        OneBankOnlineCheckReqDTO reqDTO = fetureContext.getSpReq();

        Assert.hasText(reqDTO.getClientTradeId(), "请求参数[clientTradeId]不能为空");
        Assert.hasText(reqDTO.getPersonId(), "请求参数[personId]不能为空");
        Assert.hasText(reqDTO.getPersonName(), "请求参数[personName]不能为空");
        Assert.hasText(reqDTO.getBusinessPlace(), "请求参数[businessPlace]不能为空");

        Map<String, Object> content = new HashMap<>(8);
        //渠道编码
        content.put("chlCode", this.onebankChannelProperties.getChannelId());

        //交易码(非必填) 可空
        // content.put("trans_code", "");
        //产品编号
        content.put("product_id", this.onebankChannelProperties.getTransfer(ONLINE_CHECK_KEY).getProductcode());
        //是否返回照片(非必填)  0：不返回照片 1：需要返回照片；默认0
        content.put("do_return_photo", 0);
        //是否简项核查(非必填)  0：多项查询 1：简项核对，默认  2：仅查询本地缓存 3：公安多项及黑名单查询
        content.put("is_simple_check", 1);
        //要求查询渠道(非必填)  0：只查公安，默认值 3：先查公安后查人行
        content.put("check_channel", 3);

        //证件数组id_array
        List<Map<String, Object>> idList = new ArrayList<>();
        HashMap<String, Object> arrMap = new HashMap<>(8);
        //业务发生地 为客户办理业务时的所在地，6位的行政区划编号，如深圳市 440300
//        arrMap.put("business_place", reqDTO.getBusinessPlace());
        //20201230 联网核查接口 行政编码默认310000
        arrMap.put("business_place", "310000");
        //业务类型 01 银行账户业务 02 信贷及征信业务 03 支付结算业务 04 反洗钱业务 05 其他业务
        arrMap.put("business_type", "05");
        //公民证件号码
        arrMap.put("person_id", reqDTO.getPersonId());
        //公民姓名
        arrMap.put("person_name", reqDTO.getPersonName());
        //证件类型 默认：01
        arrMap.put("id_type", "01");
        idList.add(arrMap);
        content.put("id_array", idList);
        return content;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
