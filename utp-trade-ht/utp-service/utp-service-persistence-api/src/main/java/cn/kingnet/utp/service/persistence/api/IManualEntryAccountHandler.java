package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.vo.ManualEntryAccountVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description : 手工入账服务
 * @Author : linkaigui
 * @Create : 2019/3/22 10:07
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/manualEntryAccountHandler")
public interface IManualEntryAccountHandler {

    /**
     * 手工入账处理
     * @param manualEntryAccountVO
     * @return
     */
    @PostMapping("/manualAccount")
    ServerResponseDTO manualAccount(@RequestBody(required = false) ManualEntryAccountVO manualEntryAccountVO);
}
