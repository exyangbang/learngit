package cn.kingnet.product.api.account;

import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description : 华通回调内部调用
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:40
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/callback")
public interface IOneBankCallbackHandler {

    /**
     * 华通回调内部调用
     * @param oneBankTransferCallbackReqDTO
     * @return
     */
    @PostMapping("/transferCallback")
    OneBankTransferCallbackRespDTO transferCallback(@RequestBody(required = false)OneBankTransferCallbackReqDTO oneBankTransferCallbackReqDTO);
}
