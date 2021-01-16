package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOrcIdentityReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOrcIdentityRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description: ORC身份识别
 * @Author sheqingquan@scenetec.com
 * @Create 2020/6/30 10:51
 */
@Component("orcIdentity")
@ServiceContext(bodyClass = OneBankOrcIdentityReqDTO.class)
@Slf4j
public class OneBankOrcIdentityService extends BaseOnebankPayService<OneBankOrcIdentityReqDTO, OneBankOrcIdentityRespDTO> {

    private static final String ORC_IDENTITY_KEY = "orcIdentity";
    private static final String API_NAME = UnionPaySubTypeEnum.ORC_IDENTITY.getDesc();

    public OneBankOrcIdentityService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected ChannelResponseDTO syncReq(FetureContext<OneBankOrcIdentityReqDTO, OneBankOrcIdentityRespDTO> fetureContext) {
        OneBankOrcIdentityReqDTO oneBankOrcIdentityReqDTO = fetureContext.getSpReq();
        log.info("[ORC身份识别] 请求参数 ==>> {}", JSON.toJSONString(oneBankOrcIdentityReqDTO));
        Message message = preReq(fetureContext);
        Request request = new Request(message, this.onebankChannelProperties.getTimeout());
        Response rsp = null;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("[ORC身份识别] 调用渠道接口异常：==>>{}", e.getMessage(), e);
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
            log.error("[ORC身份识别] 渠道响应系统报文头状态为失败 <<== {}", JSON.toJSONString(rsp.getMessage().getSysHead()));

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
            OneBankOrcIdentityRespDTO respDTO = JSON.parseObject(rsp.getMessage().getBody(), OneBankOrcIdentityRespDTO.class);
            log.info("[ORC身份识别] 响应报文体：{}", respDTO == null ? null : JSON.toJSONString(respDTO));

            String respCode = respDTO.getRetCode();
            String respMsg = respDTO.getRetMsg();
            ChannelResponseDTO.ChannelResponseDTOBuilder channelResponseDTOBuilder = ChannelResponseDTO.builder().serverTransId("");
            if ("0".equals(respCode)) {
                String name = respDTO.getName();
                String idNumber = respDTO.getIdNumber();
                //校验姓名 FIXME ocr识别中文有一定概率误差 20200901业务调整不校验
               /* if (!oneBankOrcIdentityReqDTO.getName().equals(name)) {
                    return ChannelResponseDTO.builder()
                            .serverTransId("")
                            .channelRespCode(respCode)
                            .message("姓名与身份证照片不符")
                            .status(HttpRespStatus.FORBIDDEN.valueStr())
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build();
                }*/
                //校验身份证号
                if (!oneBankOrcIdentityReqDTO.getIdcard().equals(idNumber)) {
                    return ChannelResponseDTO.builder()
                            .serverTransId("")
                            .channelRespCode(respCode)
                            .message("身份证号与身份证照片不符")
                            .status(HttpRespStatus.FORBIDDEN.valueStr())
                            .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                            .build();
                }

                Map<String, Object> respMap = new HashMap<>(4);
                respMap.put("name", name);
                respMap.put("idNumber", idNumber);
                channelResponseDTOBuilder
                        .channelRespCode(respCode)
                        .message(respMsg)
                        .status(HttpRespStatus.OK.valueStr())
                        .spRespMsg(respMap)
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            } else {
                log.error("[ORC身份识别] 识别失败 <<== 响应码[{}]响应码描述[{}] 响应报文体:{}", respCode, respMsg, respDTO == null ? null : JSON.toJSONString(respDTO));
                channelResponseDTOBuilder
                        .channelRespCode(respCode)
                        .status(HttpRespStatus.NOT_ACCEPTABLE.valueStr())
                        .message(respMsg)
                        .exception(String.format("识别失败 : [%s]%s", respCode, respMsg))
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            return channelResponseDTOBuilder.build();
        } else {
            log.error("[ORC身份识别] 渠道响应应用报文头appHead为空或报文头内容appHead.ret为空 <<== {}", rsp.getMessage().getAppHead() == null ? null : JSON.toJSONString(rsp.getMessage().getAppHead()));
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
    public SysHeader buildSysHeader(FetureContext<OneBankOrcIdentityReqDTO, OneBankOrcIdentityRespDTO> fetureContext) {
        OneBankOrcIdentityReqDTO requestDTO = fetureContext.getSpReq();
        SysHeader sysHeader = new SysHeader();
        /**目标dfa值 ：华通告知无需传值*/

        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(this.onebankChannelProperties.getTransfer(ORC_IDENTITY_KEY).getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(this.onebankChannelProperties.getTransfer(ORC_IDENTITY_KEY).getSceneId());
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(requestDTO.getClientTradeId());
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(requestDTO.getClientTradeId());
        /**交易发生日期*/
        sysHeader.setTransactionDateTime(CommonUtil.getDateTimeStrForTran(new Date()));
        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext fetureContext) {
        AppHeader appHeader = new AppHeader();
        return appHeader;
    }

    @Override
    public Object buildContent(FetureContext<OneBankOrcIdentityReqDTO, OneBankOrcIdentityRespDTO> fetureContext) {
        OneBankOrcIdentityReqDTO reqDTO = fetureContext.getSpReq();

        Assert.hasText(reqDTO.getClientTradeId(), "请求参数[clientTradeId]不能为空");
        Assert.hasText(reqDTO.getIdcard(), "请求参数[idcard]不能为空");
        Assert.hasText(reqDTO.getIdcardImage(), "请求参数[idcardImage]不能为空");
        Assert.hasText(reqDTO.getName(), "请求参数[name]不能为空");

        Map<String, Object> content = new HashMap<>(8);
        //身份证号码
        content.put("idcard", reqDTO.getIdcard());
        //身份证照片base64
        content.put("idcardImage", reqDTO.getIdcardImage());
        //渠道编码
        content.put("chlCode", this.onebankChannelProperties.getChannelId());
        //产品编号 | 兼容新旧产品编码对账文件合并 传值 ALL
        content.put("productCode", this.onebankChannelProperties.getTransfer(ORC_IDENTITY_KEY).getProductcode());
        return content;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
