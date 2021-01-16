package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.FundAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/25
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/fundAccount")
public interface IFundAccountHandler {

    @PostMapping("/queryFundAccountList")
    List<FundAccount> queryFundAccountList();


    @PostMapping("/querySpecialFundAccountList")
    List<FundAccount> querySpecialFundAccountList();

    @PostMapping("/getByFundAccountNo")
    FundAccount getByFundAccountNo(@RequestParam("fundAccountNo") String fundAccountNo);
}
