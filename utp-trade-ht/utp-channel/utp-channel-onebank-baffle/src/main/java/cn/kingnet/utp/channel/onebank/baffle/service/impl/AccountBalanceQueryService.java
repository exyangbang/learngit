package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountBalanceQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountBalanceQueryRespDTO;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 客户账号余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 9:53
 */
@Component("accountBalanceQuery")
@ServiceContext(bodyClass = OneBankAccountBalanceQueryReqDTO.class)
@Slf4j
public class AccountBalanceQueryService extends BaseOnebankPayService<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> {

    public AccountBalanceQueryService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected String apiName() {
        return "一般户账户余额查询";
    }

    @Override
    protected Map<String, Object> buildSpResponse(FetureContext<OneBankAccountBalanceQueryReqDTO, OneBankAccountBalanceQueryRespDTO> fetureContext) {
        OneBankAccountBalanceQueryRespDTO respDTO = new OneBankAccountBalanceQueryRespDTO();
        //单位元
        respDTO.setAvailableBalance(10000d);
        Map<String, Object> spMap = new HashMap<String, Object>(4) {{
            put("data", new OneBankAccountBalanceQueryRespDTO[]{respDTO});
        }};
        return spMap;
    }
}
