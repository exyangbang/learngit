package cn.kingnet.utp.scheduler.task;

import cn.kingnet.utp.scheduler.service.PersonOrOrgHotspotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description : 个人/企业的客户热点信息关联任务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/11/05 10:00
 */
@Slf4j
@Component
public class PersonOrOrgHotspotTask {

    @Autowired
    private PersonOrOrgHotspotService personOrOrgHotspotService;

    /**
     * 每隔天中午12点执行
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.person-org-hotspot}")
    public void addPersonOrOrgHotspot() {
        try {
            personOrOrgHotspotService.addPersonOrOrgHotspot();
        } catch (Exception e) {
            log.error("个人/企业的客户热点信息关联任务异常：{}", e.getMessage(), e);
        }
    }
}