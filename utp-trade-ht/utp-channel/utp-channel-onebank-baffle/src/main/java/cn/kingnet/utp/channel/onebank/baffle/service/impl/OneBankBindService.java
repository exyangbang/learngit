package cn.kingnet.utp.channel.onebank.baffle.service.impl;

import cn.kingnet.utp.channel.onebank.baffle.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.baffle.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.baffle.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankBindReq;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 鉴权绑定--账户验证（华通）
 *
 * @author zhongli
 */
@Component("bind")
@ServiceContext(bodyClass = OneBankBindReq.class)
@Slf4j
public class OneBankBindService extends BaseOnebankPayService<OneBankBindReq, SpBaseResponse> {

    public OneBankBindService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    protected String apiName() {
        return "个人四要素绑卡认证";
    }
}
