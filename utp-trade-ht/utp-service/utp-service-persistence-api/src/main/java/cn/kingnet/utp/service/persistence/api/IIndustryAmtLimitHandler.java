package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 客户风控参数管理
 * @Author WTC
 * @Date 2019/10/16
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/industryAmtLimitHandler")
public interface IIndustryAmtLimitHandler {

    @GetMapping("/getIndustryAmtLimitByIndustryNo")
    IndustryAmtLimit findIndustryAmtLimitByIndustryCode(@RequestParam(value = "industryCode", required = true) String industryCode);


    @GetMapping("/getSameOrderMaxSplitNum")
    Integer findSameOrderMaxSplitNum(@RequestParam(value = "industryCode") String industryCode);

}
