package cn.kingnet.product.api.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description : UTP回调外部系统
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/utpCallback")
public interface IUtpCallbackHandler {

    /**
     * 回调通知：平台入金、二级账户入金、退汇流水通知及其他
     *
     * @param industryCode
     * @param callbackUrl
     * @param content
     * @return
     */
    @PostMapping("/callbackNotice")
    boolean callbackNotice(@RequestParam("industryCode") String industryCode,@RequestParam("callbackUrl") String callbackUrl, @RequestBody(required = false) Map<String, Object> content);
}
