package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.AccountOrderLog;
import cn.kingnet.utp.service.persistence.entity.vo.AccountOrderLogVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description 账户入金订单流水
 * @Author WJH
 * @Date 2019/03/14
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/accountOrderLog")
public interface IAccountOrderLogHandler {

    @PostMapping("/queryAccountOrderLog")
    List<AccountOrderLog> queryAccountOrderLog(@RequestParam(value = "account") String account, @RequestParam(value = "orderId") String orderId);


    @PostMapping("/getAccountOrderLog")
    AccountOrderLog getAccountOrderLog(@RequestParam(value = "serverTransId") String serverTransId);


    @PostMapping("saveAccountOrderLog")
    void saveAccountOrderLog(@RequestBody AccountOrderLogVo accountOrderLogVo);

    @PostMapping("updateAccountOrderLog")
    void updateAccountOrderLog(@RequestBody AccountOrderLogVo accountOrderLogVo);


}
