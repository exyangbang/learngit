package cn.kingnet.utp.reconciliation.endpoint;

import cn.kingnet.utp.reconciliation.service.ReconciliationTaskService;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongli
 * @date 2018/9/13
 */
@RestController
@Slf4j
public class TaskEndpoint {
    private final ReconciliationTaskService reconciliationTaskService;

    public TaskEndpoint(ReconciliationTaskService reconciliationTaskService) {
        this.reconciliationTaskService = reconciliationTaskService;
    }

    @RequestMapping(value = "reconcile/start")
    public String t(@RequestParam("date") String date) {
        Assert.hasText(date, "请提供对账日期");
        reconciliationTaskService.doReconciliation(date);
        return TrueOrFalseStatus.TRUE.value();
    }

    /**
     * 重跑对账
     * @param date 对账日期
     * @return
     */
    @RequestMapping(value = "reconcile/restart")
    public String restart(@RequestParam(value = "date")String date) {
        Assert.hasText(date, "请提供对账日期");
        reconciliationTaskService.doRestartJob(date);
        return TrueOrFalseStatus.TRUE.value();
    }

    /**
     * n天对账处理
     * @param date
     * @return
     */
    @RequestMapping(value = "reconcile/minusDay")
    public String doMinusDayRecon(@RequestParam("date") String date) {
        Assert.hasText(date, "请提供对账日期");
        reconciliationTaskService.doMinusDayRecon(date);
        return TrueOrFalseStatus.TRUE.value();
    }
}
