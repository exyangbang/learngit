package cn.kingnet.product.account.service.inner;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/21
 */
@FeignClient(value = "${feign.name.scheduler}")
@RequestMapping("/spi/scheduler")
public interface SchedulerServiceProvider {

    @PostMapping("feeIncomeAccount/feeIncomeAccountMonthStat/{statMonth}")
    BaseInnerManageRespDTO feeIncomeAccountMonthStat(@PathVariable("statMonth") String statMonth, @RequestParam(name = "account", required = false) String account);

    @PostMapping("feeIncomeAccount/feeIncomeAccountCollection")
    BaseInnerManageRespDTO feeIncomeAccountMonthCollection(@RequestParam("feeStatId") long feeStatId);

}