package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IJobTaskHandler;
import cn.kingnet.utp.service.persistence.entity.JobTask;
import cn.kingnet.utp.service.persistence.entity.JobTaskCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月30日
 */
@RestController
@RequestMapping("/spi/persistence/jobTask")
public class JobTaskHandler extends DefaultFeginExceptionHandler implements IJobTaskHandler {


    @PostMapping("/saveJobTask")
    @Override
    public void saveJobTask(@RequestBody(required = false) JobTask jobTask) {
        int count = MybatisDaoImpl.run().selectCount(JobTaskCondition.builder()
                .andTaskIdEq(jobTask.getTaskId()).andJobIdEq(jobTask.getJobId()).build());
        if (count > 0) {
            return;
        }
        MybatisDaoImpl.run().insert(jobTask);
    }


}
