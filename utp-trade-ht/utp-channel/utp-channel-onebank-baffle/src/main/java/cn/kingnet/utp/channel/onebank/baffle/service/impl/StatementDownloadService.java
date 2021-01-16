package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankStatementDownLoadReqDTO;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import javax.lang.model.type.NoType;
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
public class StatementDownloadService extends BaseOnebankPayService<SpBaseRequest, SpBaseResponse> {

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
    protected Map<String, Object> buildSpResponse(FetureContext<SpBaseRequest, SpBaseResponse> fetureContext) {
        return super.buildSpResponse(fetureContext);
    }

    @Override
    protected String apiName() {
        return "渠道对账单下载";
    }
}
