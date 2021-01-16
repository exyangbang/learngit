package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.data.dto.FeeIncomeAccountCollectionRespDTO;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthStat;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthStatCondition;
import cn.kingnet.utp.scheduler.service.FeeIncomeAccountCollectionService;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Description 收益手续费账户月度归集划转至 归集账户
 * 收益手续费账户[冻结-解冻|出金 退汇|退款暂不处理] >> 华通转账接口至 >> 归集账户[行内核心入账-簿记平台定时同步-账户同步上账-后管归集提现]
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
@Component
public class FeeIncomeAccountMonthCollectionTask {

    @Resource
    private FeeIncomeAccountCollectionService feeIncomeAccountCollectionService;

    private final ExecutorService executorService;

    public FeeIncomeAccountMonthCollectionTask() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("FeeIncomeAccountMonthCollectionTask-%s").build();
        this.executorService = new ThreadPoolExecutor(4, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), threadFactory);
    }

    /**
     * 每月5号凌晨3点执行 归集划转上一月份的收益手续费账户统计金额 至 对应的归集账户
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.fee-income-account-month-colection}")
    public void feeIncomeAccountMonthCollection() {
        final String statMonth = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM"));
        LambdaLogger.info(log, "手续费收益账户月[{}]归集划转 开始执行...", statMonth);
        long sTime = System.currentTimeMillis();
        try {
            PlusEntityWrapper<FeeIncomeAccountMonthStat> plusEntityWrapper = FeeIncomeAccountMonthStatCondition.builder().andStatMonthEq(statMonth).andCollectionStatusEq(TrueOrFalseStatus.FALSE.value()).build();
            List<FeeIncomeAccountMonthStat> unCollectedList = MybatisDaoImpl.run().selectList(plusEntityWrapper);
            if (CollectionUtils.isEmpty(unCollectedList)) {
                LambdaLogger.info(log, "手续费收益账户月[{}]归集划转 执行完成,统计归集账户数:{},用时{}ms", statMonth, 0, System.currentTimeMillis() - sTime);
                return;
            }
            unCollectedList = unCollectedList.stream().filter(this::filterTransStatus).collect(Collectors.toList());
            // 每10个收益账户

            CompletableFuture<FeeIncomeAccountCollectionRespDTO>[] completableFutures =
                    unCollectedList.stream().filter(this::filterTransStatus)
                            .map(this::runCollectionSync)
                            .map(future -> future.whenComplete((r, e) -> {
                                if (e != null) {
                                    LambdaLogger.error(log, "月份{} >> 收益账户[{}]归集划转金额[{}]分 处理异常：", statMonth, r.getAccount(), r.getTransAmount(), e.getMessage());
                                }
                                if (r != null) {
                                    LambdaLogger.info(log, "月份{} >> 收益账户[{}]归集划转金额[{}]分完成状态[{}]{}, 共耗时:{}毫秒 .", statMonth, r.getAccount(), r.getTransAmount(), r.getTransStatus(), r.getTransDesc(), (System.currentTimeMillis() - sTime));
                                }
                            }))
                            .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(completableFutures).join();
            LambdaLogger.info(log, "月份{} >> 共{} 收益账户归集划转完成，共耗时:{}毫秒", statMonth, completableFutures.length, (System.currentTimeMillis() - sTime));
        } catch (Exception e) {
            LambdaLogger.error(log, "月份{} >>  收益账户归集划转异常:{}", statMonth, e.getMessage(), e);
        }
    }

    private CompletableFuture<FeeIncomeAccountCollectionRespDTO> runCollectionSync(FeeIncomeAccountMonthStat feeIncomeAccountMonthStat) {
        return CompletableFuture.supplyAsync(() -> {
            FeeIncomeAccountCollectionRespDTO respDTO = feeIncomeAccountCollectionService.doService(feeIncomeAccountMonthStat);
            return respDTO;
        }, executorService);
    }

    private boolean filterTransStatus(FeeIncomeAccountMonthStat feeIncomeAccountMonthStat) {
        if (StringUtil.isEmpty(feeIncomeAccountMonthStat.getTransStatus())) {
            return true;
        }
        if (TransStatus.PRE_CREATE.equals(feeIncomeAccountMonthStat.getTransStatus()) ||
                TransStatus.TRADE_ERROR.equals(feeIncomeAccountMonthStat.getTransStatus()) ||
                TransStatus.TRADE_FAILURE.equals(feeIncomeAccountMonthStat.getTransStatus())
        ) {
            return true;
        }
        if (TransStatus.PROCESSING.equals(feeIncomeAccountMonthStat.getTransStatus())) {
            LambdaLogger.warn(log, "暂无法归集划转，已存在归集划转处理中状态。入参：{}", JSON.toJSONString(feeIncomeAccountMonthStat));
            return false;
        }
        if (TransStatus.TRADE_SUCCESS.equals(feeIncomeAccountMonthStat.getTransStatus())) {
            LambdaLogger.warn(log, "暂无法归集划转，已存在归集划转成功状态。入参：{}", JSON.toJSONString(feeIncomeAccountMonthStat));
            return false;
        }

        LambdaLogger.warn(log, "归集划转未知状态[{}]下依然能够再次划转。入参：{}", feeIncomeAccountMonthStat.getTransStatus(), JSON.toJSONString(feeIncomeAccountMonthStat));
        return true;
    }

}
