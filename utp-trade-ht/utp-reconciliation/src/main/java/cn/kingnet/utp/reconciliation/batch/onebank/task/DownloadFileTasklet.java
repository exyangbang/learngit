package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.redis.cache.RedisHashCache;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrentCondition;
import cn.kingnet.utp.reconciliation.exception.DownloadFileTaskValidateException;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.fts.client.NFtsClientForCommon;
import cn.onebank.fts.common.dto.DownloadResult;
import cn.onebank.fts.common.dto.FileHashInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Optional;

/**
 * @author zhongli
 * @date 2018/9/12
 */
@Component
@Slf4j
public class DownloadFileTasklet implements Tasklet {
    private final static String HASH_KEY = "duizhang-files:v2";
    private final RedisHashCache redisHashCache;
    private final NFtsClientForCommon nFtsClientForCommon;
    private final RetryTemplate retryTemplate;
    private final IPaymentService paymentService;
    @Value("${cn.kingnet.utp.reconciliation.onebank.download-dir}")
    private String downloadDir;
    @Value("${cn.kingnet.utp.reconciliation.onebank.file-type}")
    private String fileType;

    public DownloadFileTasklet(IPaymentService paymentService, RedisHashCache redisHashCache,
                               NFtsClientForCommon nFtsClientForCommon, RetryTemplate retryTemplate) {
        this.paymentService = paymentService;
        this.redisHashCache = redisHashCache;
        this.nFtsClientForCommon = nFtsClientForCommon;
        this.retryTemplate = retryTemplate;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        final String reconcileDate = chunkContext.getStepContext().getJobParameters().get("reconcileDate").toString();

        //缓存文件KEY
        final String cacheFileId = new StringBuffer(reconcileDate).toString();

        ExecutionContext executionContext = getStepExecution(chunkContext.getStepContext().getStepExecution().getJobExecution()).getExecutionContext();
        executionContext.putString("reconcileDate", reconcileDate);

        String filePath = null;
        Optional<String> op = redisHashCache.get(HASH_KEY, cacheFileId);
        if (op.isPresent()) {
            filePath = op.get();
        }
        if (StringUtil.isBlank(filePath)) {
            StringBuilder path = new StringBuilder(downloadDir).append(downloadDir.endsWith(File.separator) ? "" : File.separator).append(reconcileDate);
            File file = new File(path.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            filePath = path.append(File.separator).append("bill-v2-").append(reconcileDate).append(".").append(fileType).toString();
            //如果有异常，重试3次进行文件下载，重试每次间隔5秒
            FileHashInfo result = retryTemplate.execute(retryContext -> {
                ChannelResponseDTO channelResponseDTO = paymentService.statementDownload(reconcileDate);
                log.debug("{}-对账文件渠道返回信息：{}",cacheFileId, JSON.toJSONString(channelResponseDTO));
                if(HttpRespStatus.OK.valueStr().equals(channelResponseDTO.getStatus())){
                    return nFtsClientForCommon.get((String) channelResponseDTO.getSpRespMsg().get("fileId"), path.toString());
                }else{
                    String status = channelResponseDTO.getStatus();
                    if("PCC70020".equals(channelResponseDTO.getChannelRespCode())){
                        status = channelResponseDTO.getChannelRespCode();
                    }else if("PCC70011".equals(channelResponseDTO.getChannelRespCode())){
                        status = channelResponseDTO.getChannelRespCode();
                    }
                    FileHashInfo fileHashInfo = new FileHashInfo();
                    fileHashInfo.setResultCode(status);
                    fileHashInfo.setResultDesc(channelResponseDTO.getMessage());
                    return fileHashInfo;
                }
            });

            if (result != null && DownloadResult.Success.getCode().equals(result.getResultCode())) {
                redisHashCache.set(HASH_KEY, cacheFileId, filePath);
            } else {
                StringBuilder resultDesc = new StringBuilder("对账文件下载失败");
                if(result != null && StringUtil.isNotBlank(result.getResultDesc())){
                    resultDesc.append(":");
                    if(StringUtil.isNotBlank(result.getResultCode())){
                        resultDesc.append("[").append(result.getResultCode()).append("]");
                    }
                    resultDesc.append(result.getResultDesc());
                }

                if(result != null && "PCC70020".equals(result.getResultCode())){
                    int count = MybatisDaoImpl.run().selectCount(TransCurrentCondition.builder().andTransDateEq(reconcileDate).andTransStatusEq(TransStatus.TRADE_SUCCESS).andNeedChannelReconcileEq(TrueOrFalseStatus.TRUE.value()).build());
                    if(count <= 0 ){
                        throw new DownloadFileTaskValidateException(resultDesc.toString(),9564);
                    }
                }
                throw new DownloadFileTaskValidateException(reconcileDate.concat(resultDesc.toString()));
            }
        } else {
            log.debug("{} 对账文件已下载，从缓存中读取路径", reconcileDate);
        }
        if (filePath == null) {
            log.warn("未找到华通{}对账文件", reconcileDate);
            return RepeatStatus.FINISHED;
        }else{
            File fileRecon = new File(filePath);
            if(fileRecon.exists()){
                executionContext.putString("file", filePath);
                //删除缓存
                redisHashCache.delete(HASH_KEY, cacheFileId);
            }else{
                chunkContext.getStepContext()
                        .getStepExecution()
                        .getJobExecution()
                        .getExecutionContext()
                        .put("errorReconMsg" + reconcileDate, "未找到对账日期为：" + reconcileDate + "，的对账文件");
            }
        }

        return RepeatStatus.FINISHED;
    }

    private StepExecution getStepExecution(JobExecution jobExecution) {
        Optional<StepExecution> op = jobExecution.getStepExecutions().stream().filter(stepExecution -> stepExecution.getStepName().equalsIgnoreCase("onebankMainStep")).findAny();
        return op.isPresent() ? op.get() : null;
    }
}
