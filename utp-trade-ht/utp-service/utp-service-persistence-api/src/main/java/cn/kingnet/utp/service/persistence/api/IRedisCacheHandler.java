package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.product.common.dto.manage.RefreshRedisDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 *  redis 缓存
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/refreshRedisCache")
public interface IRedisCacheHandler {

    /**
     *  刷新缓存
     * @param refreshRedisDTO
     */
    @PostMapping("/refresh")
    void refreshRedisCache(@RequestBody(required = false) RefreshRedisDTO refreshRedisDTO);

    @PostMapping("/saveNoticeCallbackMessage")
    void saveNoticeCallbackMessage(
            @RequestParam(value = "callbackUrl",required = false) String callbackUrl,
            @RequestParam(value = "industryCode",required = false) String industryCode,
            @RequestParam(value = "serverTransId",required = false) String serverTransId,
            @RequestBody(required = false) Map<String, Object> content);

}
