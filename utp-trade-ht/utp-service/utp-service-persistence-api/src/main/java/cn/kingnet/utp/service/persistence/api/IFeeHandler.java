package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 手续费服务
 * @Author : linkaigui
 * @Create : 2019/2/22 11:31
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/feehandler")
public interface IFeeHandler {

    /**
     * 计算手续费
     * @param indFeeTemplateId 平台手续费模板Id
     * @param chnFeeTemplateId 渠道手续费模板Id
     * @return
     */
    @PostMapping("calculateFeeByIndustry")
    FeeInfoBO calculateFeeByIndustry(@RequestParam(value = "indFeeTemplateId",required = false)Long indFeeTemplateId, @RequestParam(value = "chnFeeTemplateId",required = false)Long chnFeeTemplateId, @RequestParam(value = "transAmount",required = false) Long transAmount);
}
