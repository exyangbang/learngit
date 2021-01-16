package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.Industry;
import cn.kingnet.utp.scheduler.data.entity.IndustryCondition;
import cn.kingnet.utp.scheduler.service.IndustryD1SpecialReconFileService;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
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
 * @Description 4.4.3.D日对账文件下载(京东定制化)
 * @Author WJH
 * @Date 2020/08/07
 */
@Slf4j
@Component
@RestController
@RequestMapping("/industryD1SpecialReconFileTask")
public class IndustryD1SpecialReconFileTask {

    @Resource
    private ExecutorService executorService;
    @Resource
    private IndustryD1SpecialReconFileService industryD1SpecialReconFileService;

    /**
     * "D+1日凌晨12:30生成D日对账文件，京东于凌晨1点可以通过该接口下载对应的客户号的对账文件。
     * D+1日凌晨12:30生成D日对账文件，对账文件包含以下几部分内容：
     *  D日交易明确成功及明确失败的交易记录。
     *  D日进行处理的差错交易记录。
     *  D日进行处理的退汇的交易记录。
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.makeDSpecialReconFilePeriod}")
    public void MakeDSpecialReconFile() {
        String transDate = LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE);
        doMakeDSpecialReconFile(transDate);
    }

    private void doMakeDSpecialReconFile(String transDate) {
        long startTime = System.currentTimeMillis();
        try {
            LambdaLogger.info(log, "交易日期[{}] >> 生成D+1日特殊对账文件服务执行开始...", transDate);
            DateUtil.isYyyyMMdd(transDate);

            //查特殊对账单 平台客户 逐个生成
            List<Industry> dSpecialIndustrys = MybatisDaoImpl.run().selectList(IndustryCondition.builder().andReconciliationModeEq("1").build());
            if (CollectionUtils.isEmpty(dSpecialIndustrys)) {
                LambdaLogger.info(log, "查无配置D+1日特殊对账方式的平台客户,交易日期[{}]暂无需生成D+1日特殊对账文件", transDate);
                return;
            }

            CompletableFuture<String>[] completableFutures =
                    dSpecialIndustrys.stream().map(industry -> this.makeD1SpecialReconFileByIndustry(transDate, industry))
                            .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(completableFutures).join();
            LambdaLogger.info(log, "交易日期[{}] >> 生成D+1日特殊对账文件服务执行完成，总耗时[{}]ms", transDate, System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            LambdaLogger.error(log, "交易日期[{}] >> 生成D+1日特殊对账文件服务执行异常，总耗时[{}]ms", transDate, System.currentTimeMillis() - startTime, e);
        }
    }

    @GetMapping("/run/{transDate}/{industryCode}")
    public Object tempDO(@PathVariable("transDate") String transDate, @PathVariable(value = "industryCode", required = false) String industryCode) {
        if ("all".equalsIgnoreCase(industryCode)) {
            doMakeDSpecialReconFile(transDate);
        } else {
            makeD1SpecialReconFileByIndustry(transDate, Industry.builder().code(industryCode).build());
        }
        return "completed";
    }

    private CompletableFuture<String> makeD1SpecialReconFileByIndustry(String transDate, Industry industry) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                industryD1SpecialReconFileService.makeD1SpecialReconFileByIndustry(transDate, industry.getCode());
            } catch (Exception e) {
                LambdaLogger.error(log, "平台客户[{}:{}],交易日期[{}] >>生成D+1日特殊对账文件服务执行异常:{}", industry.getCode(), industry.getName(), transDate, e.getMessage(), e);
            }
            return industry.getCode();
        }, executorService);
    }

}
