package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 收款人白名单
 * @Author : linkaigui
 * @Create : 2020/5/15 10:02
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/payeeWhite")
public interface ISubPayPayeeWhiteListHandler {

    @GetMapping("/selectCountByIndustryAndPayee")
    Integer selectCountByIndustryAndPayee(@RequestParam(value = "industryId", required = false) Long industryId,
                                                         @RequestParam(value = "payeeAccount", required = false) String payeeAccount,
                                                         @RequestParam(value = "payeeName", required = false) String payeeName);
}
