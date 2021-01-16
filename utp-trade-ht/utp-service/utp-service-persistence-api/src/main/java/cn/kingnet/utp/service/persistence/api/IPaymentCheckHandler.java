package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.bo.PaymentCheckBo;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 对公小额打款验证
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/10 14:31
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/paymentCheckHandler")
public interface IPaymentCheckHandler {

    /**
     * 小额打款验证绑卡状态变化通知
     * @param paymentCheckBo
     * @return
     */
    @PostMapping("/notify")
    ServerResponseDTO notify(@RequestBody(required = false) PaymentCheckBo paymentCheckBo);

}