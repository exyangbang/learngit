package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.FeeIncomeAccountMonthStat;
import cn.kingnet.utp.service.persistence.entity.vo.FeeIncomeAccountMonthStatVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/14
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/feeIncomeAccountMonthStat")
public interface IFeeIncomeAccountMonthStatHandler {

    @GetMapping("getById")
    FeeIncomeAccountMonthStat getById(@RequestParam("id") Long id);

    @GetMapping("getAccountAndServerTransId")
    FeeIncomeAccountMonthStat getAccountAndServerTransId(@RequestParam("account") String account, @RequestParam("serverTransId") String serverTransId);

    @PostMapping("updateByAccountAndServerTransId")
    void updateByAccountAndServerTransId(@RequestBody FeeIncomeAccountMonthStatVo feeIncomeAccountMonthStatVo);

}
