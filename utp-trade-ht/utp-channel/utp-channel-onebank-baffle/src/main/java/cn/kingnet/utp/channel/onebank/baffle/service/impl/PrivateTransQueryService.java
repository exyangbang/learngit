package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 对私交易结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 13:54
 */
@Component("privateTransQuery")
@ServiceContext(bodyClass = OneBankTransQueryReqDTO.class)
@Slf4j
public class PrivateTransQueryService extends BaseOnebankPayService<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO> {

    public PrivateTransQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> buildSpResponse(FetureContext<OneBankTransQueryReqDTO, OneBankTransQueryRespDTO> fetureContext) {
        OneBankTransQueryReqDTO reqDTO = fetureContext.getSpReq();

        Map<String, Object> spRespMsg = new HashMap<>(8);
        spRespMsg.put("transStatus", TransStatus.TRADE_SUCCESS.name());
        spRespMsg.put("statusDesc", TransStatus.TRADE_SUCCESS.getTransDesc());
        spRespMsg.put("settleDate", reqDTO.getTradeDate());

        return spRespMsg;
    }

    @Override
    protected String apiName() {
        return "对私转账结果查询";
    }
}
