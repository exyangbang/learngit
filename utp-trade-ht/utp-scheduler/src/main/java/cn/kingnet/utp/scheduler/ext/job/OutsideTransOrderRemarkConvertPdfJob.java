package cn.kingnet.utp.scheduler.ext.job;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.OutsideTransOrder;
import cn.kingnet.utp.scheduler.data.entity.OutsideTransOrderCondition;
import cn.kingnet.utp.scheduler.service.SftpService;
import cn.kingnet.utp.trade.common.enums.ConvertFlag;
import cn.kingnet.utp.trade.common.enums.FileType;
import cn.kingnet.utp.trade.common.enums.PayMode;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description :4.3.4 支付交易流水上送 remark 获取pdf
 * 对于 无正向支付流水的 需要上送分账协议PDF，
 * 需要客户先通过行内开通的SFTP把协议文件上传至指定的服务器，
 * 并在上送支付流水的备注说明字段，上送分账协议PDF上传的服务器完整路径（包含文件名），
 * 簿记平台根据路径从SFTP服务器把文件下载至项目挂载服务器。
 * @Author : WJH
 * @Create : 2020/08/13 15:50
 */
@Component
@Slf4j
public class OutsideTransOrderRemarkConvertPdfJob {
    private final WorkTask workTask;
    private final ScheduledThreadPoolExecutor dispatchService;
    private final SftpService sftpService;

    @Value("${cn.kingnet.utp.schedule.remark-convert-pdf.periodseconds}")
    private String periodseconds;


    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String pdfDir;


    public OutsideTransOrderRemarkConvertPdfJob(SftpService sftpService) {
        ExecutorService convertPdfService = new ThreadPoolExecutor(4, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(200),
                new ThreadFactoryBuilder().setNameFormat("remark-convert-pdf-%d").build());
        this.workTask = new WorkTask(sftpService, convertPdfService);
        this.sftpService = sftpService;
        this.dispatchService = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("remarkConvertPdf-Dispatch-%d").build());
    }

    @PostConstruct
    public void init() {
        run();
    }

    private void run() {
        dispatchService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                workTask.run();
            }
        }, 30, Integer.valueOf(periodseconds), TimeUnit.SECONDS);
    }

    private class WorkTask implements Runnable {
        private final SftpService sftpService;
        private final ExecutorService convertPdfService;
        private ConcurrentMap<String, Integer> cache = new ConcurrentHashMap();

        public WorkTask(SftpService sftpService, ExecutorService convertPdfService) {
            this.sftpService = sftpService;
            this.convertPdfService = convertPdfService;
        }

        @Override
        public void run() {
            LambdaLogger.info(log, "备注sftp路径转换本地Pdf路径开始执行...");
            //外部订单表
            List<OutsideTransOrder> orderList = MybatisDaoImpl.run()
                    .selectList(OutsideTransOrderCondition.builder()
                            .andPayModeEq(PayMode.NOPAYFLOW.getType())
                            .andUploadStatusEq("SUCCESS")
                            .andFileConvertFlagEq("0") //0 未转换 1转换 2终止 3无需
                            .orderAsc(OutsideTransOrder::getGmtCreate).build().last(" limit 100 "));
            LambdaLogger.info(log, "备注sftp路径转换本地Pdf路径 >>{}条记录待转换...", orderList != null ? orderList.size() : 0);
            if (!CollectionUtils.isEmpty(orderList)) {
                orderList.forEach(order -> {
                    try {
                        convertPdfService.execute(() -> {
                            this.convertPdfPath(order);
                        });
                    } catch (Exception e) {
                        if (e instanceof RejectedExecutionException) {
                            log.error("备注sftp路径转换本地Pdf路径 支付流水[{}]转换pdf任务线程,失败原因：{}", order.getTransOrderId(), e.getMessage(), e);
                        } else {
                            log.error("备注sftp路径转换本地Pdf路径 支付流水[{}]转换pdf任务线程,异常信息：{}", order.getTransOrderId(), e.getMessage(), e);
                        }
                    }
                });
            }

        }

        private void convertPdfPath(OutsideTransOrder order) {
            try {
                // 识别remark内容 为正常 上送路径的完整路径
                String remark = order.getRemark();
                if (StringUtil.isBlank(remark)) {
                    throw new RuntimeException("备注字段为空");
                }
                Path origPath = Paths.get(remark.trim());
                String remoteDir = origPath.getNameCount() == 1 ? null : origPath.getParent().toFile().toString();
                String remoteFileName = origPath.toFile().getName();

                SftpService.Sftp sftp = sftpService.connectSftp();
                Path localSavePath = buildProtocolPdfPath(order.getIndustryCode(), order.getReqDate(), order.getBatchId(), order.getTransOrderId());
                try {
                    if (localSavePath != null && Files.exists(localSavePath) && Files.size(localSavePath) > 0) {
                        log.warn("已下载转换pdf文件[{}],无需再下载转换", localSavePath.getFileName().toFile().getName());
                        return;
                    }

                    sftp.download(remoteDir, remoteFileName, localSavePath);

                    String newRemark = localSavePath.toFile().getCanonicalPath().replaceAll("\\\\", "/");
                    String newDesc = StringUtil.truncate("下载转换成功.原remark值:" + remark, 200);
                    MybatisDaoImpl.run().updateById(OutsideTransOrder.builder().id(order.getId()).fileConvertFlag(ConvertFlag.CONVERTED.getFlag()).fileConvertDesc(newDesc).remark(newRemark).gmtModified(new Date()).build());
                } catch (Exception e) {
                    log.error("transOrderId[{}] sftp下载pdf失败：{}", order.getTransOrderId(), e.getMessage(), e);
                    throw new RuntimeException("sftp下载pdf失败:" + e.getMessage());
                } finally {
                    sftp.closeSFTP();
                }
            } catch (Exception e) {
                log.error("transOrderId[{}] 备注sftp路径转换本地Pdf路径 异常：{}", order.getTransOrderId(), e.getMessage(), e);
                //回滚缓存
                failUpdateOrder(order, e.getMessage());
            }
        }


        /**
         * 单个记录电子回单创建失败，此线程完成5次尝试后进行记录【转换标识】字段标为2 3无需转换
         */
        private void failUpdateOrder(OutsideTransOrder order, String errorMsg) {
            try {
                String key = order.getTransOrderId();
                Integer tint = cache.get(key);
                int total = tint == null ? 1 : tint.intValue() + 1;
                if (total > 5) {
                    String desc = StringUtil.truncate("超过5次转换失败." + errorMsg, 200);
                    MybatisDaoImpl.run().updateById(OutsideTransOrder.builder().id(order.getId()).fileConvertFlag(ConvertFlag.CONVERT_FAIL.getFlag()).fileConvertDesc(desc).gmtModified(new Date()).build());
                    cache.remove(key);
                    return;
                }
                cache.put(key, total);
            } catch (Exception e) {
                log.error("支付流水[{}] >> failUpdateOrder异常：{}", order.getTransOrderId(), e.getMessage(), e);
            }
        }
    }

    public Path buildProtocolPdfPath(String industry, String reqDate, String batchId, String outsideOrderId) throws IOException {
        Path parentPath = Paths.get(pdfDir, "protocol", industry, reqDate);
        if (Files.notExists(parentPath)) {
            Files.createDirectories(parentPath);
        }
        String parentDir = parentPath.toFile().getCanonicalPath();
        //生成 随机16位UUID + 当天日期 的文件名
        String fileName = batchId.concat("_").concat(outsideOrderId).concat(".").concat(FileType.PDF.getType());
        return Paths.get(parentDir, fileName);
    }
}
