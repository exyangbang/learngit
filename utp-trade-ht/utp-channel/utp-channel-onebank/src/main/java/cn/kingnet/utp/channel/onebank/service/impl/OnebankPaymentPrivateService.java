package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 代付-对私
 *
 * @author zhongli
 */
@Component("private")
@ServiceContext(bodyClass = OneBankTransferReq.class)
public class OnebankPaymentPrivateService extends AbstractOnebankPaymentService<OneBankTransferReq, SpBaseResponse> {

    private static final String API_NAME = UnionPaySubTypeEnum.PRIVATE.getDesc();
    public OnebankPaymentPrivateService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public String key() {
        return "private";
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
