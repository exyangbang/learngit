package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 国籍代码类Handler
 * @Author TianChao Wang
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/country")
public interface ICountryHandler {

    /**
     * 校验国籍、地区编码
     * @param country
     * @return
     */
    @PostMapping("findBy/threeBitLetters")
    boolean isExistByThreeBitLetters(@RequestParam(value = "country", required = false) String country);
}
