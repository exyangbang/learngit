package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sheqingquan@scenetec.com
 * @description: 待结算账户处理
 * @create 2020/2/12 10:52
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/openAccountSettlement")
public interface IOpenAccountSettlementHandler {

    /**
     * 查询关联的待结算账户
     * @param userAccount
     * @return
     */
    @GetMapping("/findSettleAccount")
    String findSettleAccount(@RequestParam(value = "userAccount", required = false) String userAccount);

    /**
     * 创建待结算账户
     * @param userAccount
     * @return
     */
    @GetMapping("/createSettleAccount")
    String createSettleAccount(@RequestParam(value = "userAccount", required = false) String userAccount);
}
