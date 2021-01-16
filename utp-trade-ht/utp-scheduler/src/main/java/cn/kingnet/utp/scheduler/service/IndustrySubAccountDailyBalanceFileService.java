package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.mapper.AccountMapper;
import cn.kingnet.utp.service.persistence.entity.bo.IndustrySubAccountDailyBalanceReconFileBO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @Description "按照客户号配置需要生成日终余额对账的，D+1日凌晨00点，生成D日的客户号下所有子账户的单日余额对账单。
 * 客户D+1日凌晨00:30分后可以下载D日的余额对账单，最多保留10天（参数配置），超过10天的数据自动清理，不允许下载。
 * "
 * @Author WJH
 * @Date 2020/08/07
 */
@Slf4j
@Service
public class IndustrySubAccountDailyBalanceFileService {
    @Value("${cn.kingnet.utp.subDailyBalanceFile}")
    private String subDailyBalanceFile;

    @PostConstruct
    public void init() {
        Assert.hasText(subDailyBalanceFile, () -> "cn.kingnet.utp.subDailyBalanceFile 未配置");
    }

    private String buildReconFileName(String reconDate, String industryCode) {
        return String.format("%s-%s.txt", reconDate, industryCode);
    }

    static class ReconParam implements Serializable {
        private final String reconDate;
        private final String industryCode;

        private String resultMsg;

        public ReconParam(String reconDate, String industryCode) {
            this.reconDate = reconDate;
            this.industryCode = industryCode;
        }

        public String getReconDate() {
            return reconDate;
        }

        public String getIndustryCode() {
            return industryCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }
    }

    public void deleteBeforeSubDailyBalanceFileDayNum(int retainSubDailyBalanceFileDayNum) throws IOException {
        Path rootPath = Paths.get(subDailyBalanceFile);
        //保留天数
        LocalDateTime curDateTime = LocalDateTime.now();
        try (Stream<Path> subDir = Files.list(rootPath);) {
            subDir.filter(path -> {
                try {
                    return Duration.between(LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault()), curDateTime).toDays() > retainSubDailyBalanceFileDayNum;
                } catch (IOException e) {
                    LambdaLogger.error(log, "path[{}]获取最后修改时间或转换异常：{}", path.getFileName(), e.getMessage(), e);
                }
                return false;
            }).forEach(path -> {
                deleteFiles(path.toFile());
            });
        } catch (Exception e) {
            LambdaLogger.error(log, "获取子账户余额对账子目录异常：{}", e.getMessage(), e);
        }
    }


    private void deleteFiles(File rootFile) {
        if (!rootFile.isFile()) {
            File[] files = rootFile.listFiles();
            for (File x : files) {
                deleteFiles(x);
            }
        }
        rootFile.delete();
    }

    public void makeSubDailyBalanceFileByIndustry(String reconDate, String industryCode) {
        Assert.hasText(reconDate, () -> "余额对账日期不能为空");
        Assert.hasText(industryCode, () -> "余额对账平台客户号不能为空");

        final ReconParam reconParam = new ReconParam(reconDate, industryCode);

        CompletableFuture cf = CompletableFuture.completedFuture(reconParam)
                .thenComposeAsync(this::buildDailyBalanceReconBo)
                .whenCompleteAsync((boList, t) -> {
                    if (t != null) {
                        LambdaLogger.error(log, "平台客户[{}]生成对单日[{}]的子账户余额对账文件异常：{}", reconParam.getIndustryCode(), reconParam.getReconDate(), t.getMessage(), t);
                        reconParam.setResultMsg("异常：" + t.getMessage());
                        return;
                    }
                    try {
                        this.createBalanceReconFile(reconParam, boList);
                        reconParam.setResultMsg("成功");
                    } catch (Exception e) {
                        LambdaLogger.error(log, "平台客户[{}]生成对单日[{}]的子账户余额对账文件异常：{}", reconParam.getIndustryCode(), reconParam.getReconDate(), t.getMessage(), t);
                        reconParam.setResultMsg("异常：" + e.getMessage());
                        throw new SchedulerException(HttpRespStatus.SERVER_ERROR, "生成子账户余额对账文件异常：" + e.getMessage());
                    }
                });

        CompletableFuture.allOf(cf).join();

        LambdaLogger.info(log, "平台客户[{}]生成对单日[{}]的子账户余额对账文件完成：{}", reconParam.getIndustryCode(), reconParam.getReconDate(), reconParam.getResultMsg());

    }

    private void createBalanceReconFile(ReconParam reconParam, List<IndustrySubAccountDailyBalanceReconFileBO> boList) {
        Path path = Paths.get(subDailyBalanceFile, reconParam.getReconDate());
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new TradeException(HttpRespStatus.SERVER_ERROR, "创建子账户余额对账文件目录异常:" + e.getMessage(), e);
            }
        }

        Path filePath = Paths.get(path.toFile().getAbsolutePath(), buildReconFileName(reconParam.getReconDate(), reconParam.getIndustryCode()));
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new TradeException(HttpRespStatus.SERVER_ERROR, "创建子账户余额对账文件异常:" + e.getMessage(), e);
            }
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            long totalRows = boList == null ? 0L : boList.size();
            bufferedWriter.write("H|balance|" + reconParam.getReconDate() + "|" + totalRows);
            if (!CollectionUtils.isEmpty(boList)) {
                for (IndustrySubAccountDailyBalanceReconFileBO bo : boList) {
                    bufferedWriter.newLine();
                    //设置替换交易日期
                    bo.setReconcileDate(reconParam.getReconDate());
                    bufferedWriter.write(bo.toString());
                }
            }
        } catch (IOException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "子账户余额对账文件写入异常:" + e.getMessage(), e);
        }


    }


    private Map<String, String> toParamsMap(ReconParam reconParam) {
        Map<String, String> paramsMap = new HashMap<>(4);
        paramsMap.put("reconDate", reconParam.getReconDate());
        paramsMap.put("industryCode", reconParam.getIndustryCode());
        return paramsMap;
    }

    private CompletableFuture<List<IndustrySubAccountDailyBalanceReconFileBO>> buildDailyBalanceReconBo(final ReconParam reconParam) {
        //待优化，可分页查询处理
        return CompletableFuture.supplyAsync(() -> {
            List<IndustrySubAccountDailyBalanceReconFileBO> list = MybatisDaoImpl.of(AccountMapper.class).selectListBySql("buildDailyBalanceReconBo", toParamsMap(reconParam));
            return list;
        });
    }


}


