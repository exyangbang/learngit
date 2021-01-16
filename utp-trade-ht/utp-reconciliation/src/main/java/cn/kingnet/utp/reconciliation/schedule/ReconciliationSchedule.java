package cn.kingnet.utp.reconciliation.schedule;

import cn.kingnet.utp.reconciliation.service.ReconciliationTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zhongli
 * @date 2018/9/14
 */
@Component
@Slf4j
public class ReconciliationSchedule {

    private final ReconciliationTaskService reconciliationTaskService;

    public ReconciliationSchedule(ReconciliationTaskService reconciliationTaskService) {
        this.reconciliationTaskService = reconciliationTaskService;
    }

    /**
     * 每天中午12点执行
     */
    @Scheduled(cron = "${cn.kingnet.utp.reconciliation.onebank.corn-time}")
    public void work() {
        // 获取前一天日期
        String currentDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE);
        reconciliationTaskService.doReconciliation(currentDate);
    }

    /**
     * 每天下午5点执行
     */
    @Scheduled(cron = "${cn.kingnet.utp.reconciliation.onebank.minusdayrecon-time}")
    public void minusDayReconWork() {
        // 获取前一天日期
        String currentDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE);
        reconciliationTaskService.doMinusDayRecon(currentDate);
    }
}
