package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountBalanceQueryRespDTO;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 内部账号余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:53
 */
@Component("innerAccountBalanceQuery")
@ServiceContext(bodyClass = OneBankInnerAccountBalanceQueryReqDTO.class)
@Slf4j
public class InnerAccountBalanceQueryService extends BaseOnebankPayService<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> {

    public InnerAccountBalanceQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected Map<String, Object> buildSpResponse(FetureContext<OneBankInnerAccountBalanceQueryReqDTO, OneBankInnerAccountBalanceQueryRespDTO> fetureContext) {
        OneBankInnerAccountBalanceQueryRespDTO respDTO = new OneBankInnerAccountBalanceQueryRespDTO();
        //单位元
        respDTO.setAccountBalance(9999d);
        Map<String, Object> spMap = new HashMap<>(4);
        spMap.put("data", new OneBankInnerAccountBalanceQueryRespDTO[]{respDTO});
        return spMap;
    }

    @Override
    protected String apiName() {
        return "内部户余额查询";
    }
}
