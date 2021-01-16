package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.ChannelRespcode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description 渠道响应码对照表
 * @Author WJH
 * @Date 2019-06-17
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/channelRespcode")
public interface IChannelRespcodeHandler {


    @PostMapping("/queryByTransStatus")
    List<ChannelRespcode> queryByTransStatus(@RequestParam("transStatus") String transStatus);


    @PostMapping("/queryByTransStatusAndRespcode")
    ChannelRespcode queryByTransStatusAndRespcode(@RequestParam("transStatus") String transStatus, @RequestParam("respcode") String respcode);


}
