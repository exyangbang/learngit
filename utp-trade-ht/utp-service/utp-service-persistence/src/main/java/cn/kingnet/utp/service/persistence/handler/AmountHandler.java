package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IAmountHandler;
import cn.kingnet.utp.service.persistence.service.ChannelAmountLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongli
 * @date 2019-03-20
 */
@RestController
@Slf4j
public class AmountHandler implements IAmountHandler {

    @Autowired
    private ChannelAmountLimitService channelAmountLimitService;




}
