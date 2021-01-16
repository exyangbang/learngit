package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.CollectAccountWithdraw;
import cn.kingnet.utp.service.persistence.entity.vo.CollectAccountWithdrawVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/14
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/collectAccountWithdraw")
public interface ICollectAccountWithdrawHandler {

    @GetMapping("getById")
    CollectAccountWithdraw getById(@RequestParam("id") String id);

    @GetMapping("existsAccountAndClientIdOrServerId")
    boolean existsAccountAndClientIdOrServerId(@RequestParam("account") String account, @RequestParam(value = "clientTransId",required = false) String clientTransId, @RequestParam(value = "serverId",required = false) String serverId);

    @GetMapping("getByIndustryCodeAndClientTransId")
    CollectAccountWithdraw getByIndustryCodeAndClientTransId(@RequestParam("industryCode") String industryCode, @RequestParam("clientTransId") String clientTransId);

    @PostMapping("updateByIndustryCodeAndClientTransId")
    void updateByIndustryCodeAndClientTransId(@RequestBody CollectAccountWithdrawVo collectAccountWithdrawVo);

}
