package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.JobTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月30日
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/jobTask")
public interface IJobTaskHandler {

    @PostMapping("/saveJobTask")
    void saveJobTask(@RequestBody(required = false) JobTask jobTask);

}
