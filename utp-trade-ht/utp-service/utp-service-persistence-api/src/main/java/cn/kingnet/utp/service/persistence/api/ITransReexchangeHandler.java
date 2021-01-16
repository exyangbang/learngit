package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.TransReexchange;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description : 退汇账户
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 22:41
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/transReexchangeHandler")
public interface ITransReexchangeHandler {

    /**
     * 退汇账户处理
     * @param id 退汇流水ID
     * @param userModified 操作员
     * @return
     */
    @PostMapping("/adjustAccount")
    ServerResponseDTO adjustAccount(@RequestParam(value = "id",required = false)Long id, @RequestParam(value = "userModified",required = false)String userModified);

    @PostMapping("/queryBySettleDate")
    List<TransReexchange> queryBySettleDate(@RequestParam("industryCode") String industryCode, @RequestParam("settleDate") String settleDate);


}
