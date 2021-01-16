package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.FreezingFundsOpeApproval;
import cn.kingnet.utp.service.persistence.entity.vo.FreezingFundsOpeApprovalVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 针对后管提供的服务接口
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/manage")
public interface IManageHandler {

    @PostMapping("selectFreezingFundsOpeApproval")
    FreezingFundsOpeApproval selectFreezingFundsOpeApproval(@RequestBody FreezingFundsOpeApprovalVo vo);


}
