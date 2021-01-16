package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 交易流水数据处理接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 15:51
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/process/trans")
public interface IProcessTransHandler {


    /**
     * 华通交易回调更新
     *
     * @param id
     * @param status
     */
    @PostMapping("onebank/callback/update")
    TransCurrent onebankCallbackUpdate(@RequestParam(value = "id", required = false) long id, @RequestParam(value = "respCode", required = false) String respCode, @RequestParam(value = "respMsg", required = false) String respMsg, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "channelSettleDate", required = false) String channelSettleDate);


}