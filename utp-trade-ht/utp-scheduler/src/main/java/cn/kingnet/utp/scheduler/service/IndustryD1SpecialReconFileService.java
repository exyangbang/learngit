package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.mapper.TransCurrentMapper;
import cn.kingnet.utp.service.persistence.entity.bo.IndustryDSpecialReconFileBO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Description "D+1日凌晨12:30生成D日对账文件，京东于凌晨1点可以通过该接口下载对应的客户号的对账文件。
 * D+1日凌晨12:30生成D日对账文件，对账文件包含以下几部分内容：
 *  D日交易明确成功及明确失败的交易记录。
 *  D日进行处理的差错交易记录。
 *  D日进行处理的退汇的交易记录。
 * @Author WJH
 * @Date 2020/08/07
 */
@Slf4j
@Service
public class IndustryD1SpecialReconFileService {
    @Value("${cn.kingnet.utp.dSpecialReconFile}")
    private String dSpecialReconFile;

    @PostConstruct
    public void init() {
        Assert.hasText(dSpecialReconFile, () -> "cn.kingnet.utp.dSpecialReconFile 未配置");
    }

    private String buildReconFileName(String transDate, String industryCode) {
        return String.format("%s-%s.txt", transDate, industryCode);
    }

    static class ReconParam implements Serializable {
        private final String transDate;
        private final String industryCode;

        private String resultMsg;

        public ReconParam(String transDate, String industryCode) {
            this.transDate = transDate;
            this.industryCode = industryCode;
        }

        public String getTransDate() {
            return transDate;
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

    public void makeD1SpecialReconFileByIndustry(String transDate, String industryCode) {
        Assert.hasText(transDate, () -> "D1特殊交易日期不能为空");
        Assert.hasText(industryCode, () -> "D1特殊对账平台客户号不能为空");

        final ReconParam reconParam = new ReconParam(transDate, industryCode);

        CompletableFuture cf = CompletableFuture.completedFuture(reconParam)
                .thenComposeAsync(this::buildReconBo4TransCurrent)
                .thenCombineAsync(this.buildReconBo4TransParamFail(reconParam), this::addAll)
                .thenCombineAsync(this.buildReconBo4SettleCheckInfo(reconParam), this::addAll)
                .thenCombineAsync(this.buildReconBo4TransReexchange(reconParam), this::addAll)
                .whenCompleteAsync((boList, t) -> {
                    if (t != null) {
                        LambdaLogger.error(log, "平台客户{}生成对单日[{}]的D1特殊对账文件异常：{}", reconParam.getIndustryCode(), reconParam.getTransDate(), t.getMessage(), t);
                        reconParam.setResultMsg("异常：" + t.getMessage());
                        return;
                    }
                    this.createReconFile(reconParam, boList);
                });

        CompletableFuture.allOf(cf).join();

        LambdaLogger.info(log, "平台客户{}生成对单日[{}]的D1特殊对账文件完成：{}", reconParam.getIndustryCode(), reconParam.getTransDate(), reconParam.getResultMsg());

    }

    private void createReconFile(ReconParam reconParam, List<IndustryDSpecialReconFileBO> boList) {
        Path path = Paths.get(dSpecialReconFile,reconParam.getTransDate());
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new TradeException(HttpRespStatus.SERVER_ERROR, "创建D1特殊对账文件目录异常:" + e.getMessage(), e);
            }
        }

        Path filePath = Paths.get(path.toFile().getAbsolutePath(), buildReconFileName(reconParam.getTransDate(), reconParam.getIndustryCode()));
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new TradeException(HttpRespStatus.SERVER_ERROR, "创建D1特殊对账文件异常:" + e.getMessage(), e);
            }
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            long totalRows = boList == null ? 0L : boList.size();
            bufferedWriter.write("H|dayReconcile|" + totalRows);
            if (!CollectionUtils.isEmpty(boList)) {
                for (IndustryDSpecialReconFileBO bo : boList) {
                    bufferedWriter.newLine();
                    //设置替换清算日期[为空或差错表清算日不可用统一这边设置查询交易日]
                    bo.setReconcileDate(reconParam.getTransDate());
                    bufferedWriter.write(bo.toString());
                }
            }
        } catch (IOException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "生成D1特殊对账文件写入异常:" + e.getMessage(), e);
        }


    }

    private List<IndustryDSpecialReconFileBO> addAll(List<IndustryDSpecialReconFileBO> all, List<IndustryDSpecialReconFileBO> in) {
        if (all != null && in != null) {
            all.addAll(in);
            return all;
        }
        return all != null ? all : (in != null ? in : new ArrayList<>());
    }

    private Map<String, String> toParamsMap(ReconParam reconParam) {
        Map<String, String> paramsMap = new HashMap<>(4);
        paramsMap.put("transDate", reconParam.getTransDate());
        paramsMap.put("industryCode", reconParam.getIndustryCode());
        return paramsMap;
    }

    private CompletableFuture<List<IndustryDSpecialReconFileBO>> buildReconBo4TransCurrent(final ReconParam reconParam) {
        return CompletableFuture.supplyAsync(() -> {
            List<IndustryDSpecialReconFileBO> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("buildReconBo4TransCurrent", toParamsMap(reconParam));
            return list;
        });

    }

    private CompletableFuture<List<IndustryDSpecialReconFileBO>> buildReconBo4SettleCheckInfo(final ReconParam reconParam) {
        return CompletableFuture.supplyAsync(() -> {
            List<IndustryDSpecialReconFileBO> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("buildReconBo4SettleCheckInfo", toParamsMap(reconParam));
            return list;
        });
    }

    private CompletableFuture<List<IndustryDSpecialReconFileBO>> buildReconBo4TransReexchange(final ReconParam reconParam) {
        return CompletableFuture.supplyAsync(() -> {
            List<IndustryDSpecialReconFileBO> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("buildReconBo4TransReexchange", toParamsMap(reconParam));
            return list;
        });
    }

    private CompletableFuture<List<IndustryDSpecialReconFileBO>> buildReconBo4TransParamFail(final ReconParam reconParam) {
        return CompletableFuture.supplyAsync(() -> {
            List<IndustryDSpecialReconFileBO> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("buildReconBo4TransParamFail", toParamsMap(reconParam));
            return list;
        });
    }

}


