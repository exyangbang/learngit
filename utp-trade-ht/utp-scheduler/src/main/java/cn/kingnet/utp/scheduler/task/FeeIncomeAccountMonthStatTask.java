package cn.kingnet.utp.scheduler.task;

import cn.kingnet.utp.scheduler.service.FeeIncomeAccountMonthStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description 收益手续费账户月统计任务
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
@Component
public class FeeIncomeAccountMonthStatTask {

    @Autowired
    private FeeIncomeAccountMonthStatService feeIncomeAccountMonthStatService;

    /**
     * 每月5号凌晨2点执行 统计上一月份的收益手续费账户出入金情况
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.fee-income-account-month-stat}")
    public void feeIncomeAccountMonthStat() {
        final String statMonth = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM"));
        try {
            feeIncomeAccountMonthStatService.feeIncomeAccountMonthStat(statMonth, null);
        } catch (Exception e) {
            log.error("收益账户统计异常：{}", e.getMessage(), e);
        }

    }


}
