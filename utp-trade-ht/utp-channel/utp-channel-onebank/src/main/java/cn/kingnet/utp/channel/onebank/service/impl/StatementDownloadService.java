package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankStatementDownLoadReqDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.OneBankRespCode;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
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
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import javax.lang.model.type.NoType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 对账文件下载
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/23 11:14
 */
@Component("statementDownload")
@ServiceContext(bodyClass = NoType.class)
@Slf4j
public class StatementDownloadService extends BaseOnebankPayService<OneBankStatementDownLoadReqDTO, SpBaseResponse> {

    private static final String STATEMENT_DOWNLOAD_KEY = "statementDownload";
    private static final String API_NAME = UnionPaySubTypeEnum.STATEMENT_DOWNLOAD.getDesc();

    public StatementDownloadService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public OneBankStatementDownLoadReqDTO getRequestParam(ServerRequest request) {
        Optional<String> op = request.queryParam("settleDate");
        if (op.isPresent()) {
            OneBankStatementDownLoadReqDTO dto = new OneBankStatementDownLoadReqDTO();
            dto.setSettleDate(op.get());
            return dto;
        }
        throw new ChannelResponseException(HttpStatus.BAD_GATEWAY, "无效的请求参数");
    }

    @Override
    protected ChannelResponseDTO syncReq(FetureContext<OneBankStatementDownLoadReqDTO, SpBaseResponse> fetureContext) {
        OneBankStatementDownLoadReqDTO oneBankStatementDownLoadReqDTO = fetureContext.getSpReq();
        log.info("对账日期:{} >> [渠道对账文件下载] 请求参数 ==>> {}", oneBankStatementDownLoadReqDTO.getSettleDate(), JSON.toJSONString(oneBankStatementDownLoadReqDTO));
        Message message = preReq(fetureContext);
        Request request = new Request(message, this.onebankChannelProperties.getTimeout());
        Response rsp = null;
        try {
            rsp = this.utpDbmTemplate.sendRequest(request);
        } catch (DMBException e) {
            log.error("对账日期:{} >> [渠道对账文件下载] 调用渠道接口异常：==>>{}", e.getMessage(), e);
            String exceptionMsg = StringUtil.truncate(e.getMessage(),800);
            return ChannelResponseDTO.builder()
                    .serverTransId("")
                    .message(String.format("[%s]渠道异常:%s", e.getErrorCode(), exceptionMsg))
                    .exception(e.getClass().getName()+":"+exceptionMsg)
                    .status(HttpRespStatus.MULTIPLE_CHOICES.valueStr())
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        }
        //判断是否系统成功
        if (ConstantsForProto.SYSTEM_FAIL.equals(rsp.getMessage().getSysHead().getTransactionReturnStatus())) {
            log.error("对账日期:{} >> [渠道对账文件下载] 渠道响应系统报文头状态为失败 <<== {}", oneBankStatementDownLoadReqDTO.getSettleDate(), JSON.toJSONString(rsp.getMessage().getSysHead()));

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
            JSONObject respBody = JSON.parseObject(new String(rsp.getMessage().getBody()));
            log.info("对账日期:{} >> [渠道对账文件下载] 响应报文体：{}", oneBankStatementDownLoadReqDTO.getSettleDate(), respBody == null ? null : respBody.toJSONString());

            String respCode = respBody.getString("respCode");
            String respMsg = respBody.getString("respMsg");
            String fileId = respBody.getString("file_id");
            ChannelResponseDTO.ChannelResponseDTOBuilder channelResponseDTOBuilder = ChannelResponseDTO.builder().serverTransId("");
            if (OneBankRespCode.PCC00000.name().equals(respCode)) {
                Map<String, Object> respMap = new HashMap<>(4);
                respMap.put("fileId", fileId);
                channelResponseDTOBuilder
                        .channelRespCode(respCode)
                        .message(respMsg)
                        .status(HttpRespStatus.OK.valueStr())
                        .spRespMsg(respMap)
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            } else {
                log.error("对账日期:{} << [渠道对账文件下载] 暂无法获取fileId <<== 响应码[{}]响应码描述[{}] 响应报文体:{}", oneBankStatementDownLoadReqDTO.getSettleDate(), respCode, respMsg, respBody == null ? null : respBody.toJSONString());
                channelResponseDTOBuilder
                        .channelRespCode(respCode)
                        .status(HttpRespStatus.NOT_ACCEPTABLE.valueStr())
                        .message(respMsg)
                        .exception(String.format("暂无法获取fileId : [%s]%s", respCode, respMsg))
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            return channelResponseDTOBuilder.build();
        } else {
            log.error("对账日期:{} << [渠道对账文件下载] 渠道响应应用报文头appHead为空或报文头内容appHead.ret为空 <<== {}", oneBankStatementDownLoadReqDTO.getSettleDate(), rsp.getMessage().getAppHead() == null ? null : JSON.toJSONString(rsp.getMessage().getAppHead()));
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
    public SysHeader buildSysHeader(FetureContext<OneBankStatementDownLoadReqDTO, SpBaseResponse> fetureContext) {
        SysHeader sysHeader = new SysHeader();
        OneBankStatementDownLoadReqDTO requestDTO = fetureContext.getSpReq();
        /**目标dfa值 ：华通告知无需传值*/

        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(this.onebankChannelProperties.getTransfer(STATEMENT_DOWNLOAD_KEY).getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(this.onebankChannelProperties.getTransfer(STATEMENT_DOWNLOAD_KEY).getSceneId());
        String dfa = DmbUtil.getConsumerDFA();
        String systemId = DmbUtil.getConsumerSystemId();
        String tradeId = IdGenerate.generateServerTransId(dfa, systemId);
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(tradeId);
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(tradeId);
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
    public Object buildContent(FetureContext<OneBankStatementDownLoadReqDTO, SpBaseResponse> fetureContext) {
        OneBankStatementDownLoadReqDTO requestDTO = fetureContext.getSpReq();
        Map<String, Object> content = new HashMap<>(4);
        //对账日期
        content.put("clear_date", requestDTO.getSettleDate());
        //渠道编码
        content.put("chl_code", this.onebankChannelProperties.getChannelId());
        //产品编号 | 兼容新旧产品编码对账文件合并 传值 ALL
        content.put("product_code", this.onebankChannelProperties.getTransfer(STATEMENT_DOWNLOAD_KEY).getProductcode());
        return content;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
