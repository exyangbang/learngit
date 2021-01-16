package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.Industry;
import cn.kingnet.utp.scheduler.data.entity.IndustryCondition;
import cn.kingnet.utp.scheduler.service.IndustrySubAccountDailyBalanceFileService;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @Description 4.4.4.子账户日终余额对账单下载(京东定制化)
 * @Author WJH
 * @Date 2020/08/07
 */
@Slf4j
@Component
@RestController
@RequestMapping("/IndustrySubAccountDailyBalanceFileTask")
public class IndustrySubAccountDailyBalanceFileTask {

    @Resource
    private ExecutorService executorService;
    @Resource
    private IndustrySubAccountDailyBalanceFileService industrySubAccountDailyBalanceFileService;

    @Value("${cn.kingnet.utp.schedule.ht-properties.corn.retainSubDailyBalanceFileDayNum:10}")
    private int retainSubDailyBalanceFileDayNum;


    /**
     * "按照客户号配置需要生成日终余额对账的，D+1日凌晨00点，生成D日的客户号下所有子账户的单日余额对账单。
     * 客户D+1日凌晨00:30分后可以下载D日的余额对账单，最多保留10天（参数配置），超过10天的数据自动清理，不允许下载。
     * "
     * */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.makeSubDailyBalanceFilePeriod}")
    public void makeSubDailyBalanceFile() {
        String reconDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE);
        doMakeSubDailyBalanceFile(reconDate);

        deleteBeforeSubDailyBalanceFileDayNum();
    }

    private void doMakeSubDailyBalanceFile(String reconDate) {
        long startTime = System.currentTimeMillis();
        try {
            LambdaLogger.info(log, "余额对账日期[{}] >> 生成子账户的单日余额对账文件服务执行开始...", reconDate);
            DateUtil.isYyyyMMdd(reconDate);

            // 平台客户 逐个生成
            List<Industry> industryList = MybatisDaoImpl.run().selectList(IndustryCondition.builder().build());
            if (CollectionUtils.isEmpty(industryList)) {
                LambdaLogger.warn(log, "余额对账日期[{}] >> 查无可用的平台客户，暂无需生成子账户的单日余额对账文件", reconDate);
                return;
            }

            CompletableFuture<String>[] completableFutures =
                    industryList.stream().map(industry -> this.makeSubDailyBalanceFileByIndustry(reconDate, industry))
                            .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(completableFutures).join();
            LambdaLogger.info(log, "余额对账日期[{}] >> 生成子账户的单日余额对账文件服务执行完成，总耗时[{}]ms", reconDate, System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            LambdaLogger.error(log, "余额对账日期[{}] >> 生成子账户的单日余额对账文件服务执行异常，总耗时[{}]ms", reconDate, System.currentTimeMillis() - startTime, e);
        }
    }

    @GetMapping("/run/{reconDate}/{industryCode}")
    public Object tempDO(@PathVariable("reconDate") String recodeDate, @PathVariable(value = "industryCode", required = false) String industryCode) {
        if ("all".equalsIgnoreCase(industryCode)) {
            doMakeSubDailyBalanceFile(recodeDate);
        } else {
            makeSubDailyBalanceFileByIndustry(recodeDate, Industry.builder().code(industryCode).build());
        }
        deleteBeforeSubDailyBalanceFileDayNum();
        return "completed";
    }

    private CompletableFuture<String> makeSubDailyBalanceFileByIndustry(String reconDate, Industry industry) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                industrySubAccountDailyBalanceFileService.makeSubDailyBalanceFileByIndustry(reconDate, industry.getCode());
            } catch (Exception e) {
                LambdaLogger.error(log, "平台客户[{}:{}],余额对账日期[{}] >> 生成子账户的单日余额对账文件服务执行异常:{}", industry.getCode(), industry.getName(), reconDate, e.getMessage(), e);
            }
            return industry.getCode();
        }, executorService);
    }


    private CompletableFuture<String> deleteBeforeSubDailyBalanceFileDayNum() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                LambdaLogger.info(log,"开始删除[{}]日期之前的子账户日终对账单文件", LocalDate.now().minusDays(retainSubDailyBalanceFileDayNum).format(DateTimeFormatter.ISO_DATE));
                industrySubAccountDailyBalanceFileService.deleteBeforeSubDailyBalanceFileDayNum(retainSubDailyBalanceFileDayNum);
            } catch (Exception e) {
                LambdaLogger.error(log, "删除[{}]天前子账户单日余额对账文件异常:{}",retainSubDailyBalanceFileDayNum,e.getMessage(), e);
            }
            return null;
        }, executorService);
    }




}
