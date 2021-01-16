package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/transfer")
public interface ITransferHander {

    @PostMapping("saveTransfer")
    void saveTransfer(@RequestBody(required = false) Transfer transfer);

    @PostMapping("/updateByIndustryCodeAndServerTradeId")
    void updateByIndustryCodeAndServerTransId(@RequestBody(required = false) Transfer transfer,
                                              @RequestParam(value = "industryCode", required = false) String industryCode,
                                              @RequestParam(value = "serverTransId", required = false) String serverTransId);

    @PostMapping("/getByServerTradeId")
    Transfer getByServerTradeId(@RequestParam(value = "serverTransId", required = false) String serverTransId);

}
