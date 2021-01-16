package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 代付-对私
 *
 * @author zhongli
 */
@Component("public")
@ServiceContext(bodyClass = OneBankTransferReq.class)
public class OnebankPaymentPublicService extends BaseOnebankPayService<OneBankTransferReq, SpBaseResponse> {

    public OnebankPaymentPublicService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected String apiName() {
        return "对公转账";
    }
}
