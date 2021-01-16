package cn.kingnet.utp.scheduler.task;

import cn.kingnet.utp.scheduler.service.MerchantAccountUnbindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 商户账户定时解绑任务
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 16:14
 */
@Slf4j
@RequestMapping(value = "merchantAccount")
@RestController
public class MerchantAccountUnbindTask {

    @Value("${cn.kingnet.utp.schedule.merchant-account.freeze-hour}")
    private int freezeHour = 24;
    @Value("${cn.kingnet.utp.schedule.merchant-account.apply-hour}")
    private int applyHour = 48;

    @Resource
    private MerchantAccountUnbindService merchantAccountUnbindService;

    /**
     * 每隔天中午12点执行
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.merchant-account.corn-time}")
    public void doWork() {
        try {
            merchantAccountUnbindService.work(freezeHour, applyHour);
        } catch (Exception e) {
            log.error("商户账户定时解绑任务异常：{}", e.getMessage(), e);
        }
    }

    /**
     * 手动触发
     */
    @RequestMapping(value = "/unBind/{freezeHour}/{applyHour}", method = RequestMethod.GET)
    public String unBind(@PathVariable("freezeHour") String freezeHour, @PathVariable("applyHour") String applyHour) {
        try {
            Assert.hasText(freezeHour, "参数[freezeHour]不能为空");
            Assert.hasText(applyHour, "参数[applyHour]不能为空");
            merchantAccountUnbindService.work(Integer.parseInt(freezeHour), Integer.parseInt(applyHour));
        } catch (Exception e) {
            log.error("商户账户定时解绑任务异常：{}", e.getMessage(), e);
        }
        return "执行成功";
    }
}