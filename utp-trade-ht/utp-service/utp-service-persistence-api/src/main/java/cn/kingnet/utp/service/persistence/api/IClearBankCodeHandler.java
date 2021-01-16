package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 清算行表
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/10 10:57
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/clearBankCodeHandler")
public interface IClearBankCodeHandler {

    /**
     * 根据开户行号获取清算行号
     * @param openBankCode
     * @return
     */
    @PostMapping("/getClearBankCode")
    String getClearBankCode(@RequestParam(value = "openBankCode") String openBankCode);
}