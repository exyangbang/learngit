package cn.kingnet.utp.reconciliation.batch.onebank.configuration;

import cn.kingnet.utp.reconciliation.batch.onebank.support.CustomRecordSeparatorPolicy;
import cn.kingnet.utp.reconciliation.batch.onebank.support.DownloadFileStepExecutionListener;
import cn.kingnet.utp.reconciliation.batch.onebank.task.*;
import cn.kingnet.utp.reconciliation.data.bo.OneBankReconciliationBO;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrent;
import cn.onebank.fts.client.NFtsClientForCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.Map;

/**
 * @author zhongli
 * @date 2018/9/12
 */
@Configuration
@EnableBatchProcessing
@EnableConfigurationProperties(OnebankChannelProperties.class)
@Slf4j
public class OnebankBatchConfiguration {

    @Bean
    public NFtsClientForCommon nFtsClientForCommon(OnebankChannelProperties onebankChannelProperties) throws Exception {
        return new NFtsClientForCommon(onebankChannelProperties.getHost(), onebankChannelProperties.getPort(),
                onebankChannelProperties.getHttpsPort(), onebankChannelProperties.getSysId(),
                onebankChannelProperties.getUserName(), onebankChannelProperties.getPassword());
    }

    /**
     * 正常渠道对账流程处理
     *
     * @param stepBuilderFactory
     * @param jobRepository
     * @param onebankDownloadFileStep        下载渠道对账单任务
     * @param getReconFileNoExistStep        渠道明确无对账单
     * @param onebankReconStep               以渠道对账单为基准匹配本地流水[可能产生差错类型有B、C、D、G]
     * @param onebankMoveTradeToHistoryStep  正常对账并且校正状态成功且需要移到历史表
     * @param onebankAccountProcessStep      C、D需要账户调账处理
     * @param onebankUpdateRecordTaskletStep 标记该对账单对账完成
     * @return
     */
    @Bean(name = "onebankMainStep")
    public Step onebankMainStep(StepBuilderFactory stepBuilderFactory,
                                JobRepository jobRepository,
                                @Qualifier("onebankDownloadFileStep") Step onebankDownloadFileStep,
                                @Qualifier("onebankNoExistsReconFileStep") Step onebankNoExistsReconFileStep,
                                @Qualifier("onebankReconStep") Step onebankReconStep,
                                @Qualifier("onebankReReconStep") Step onebankReReconStep,
                                @Qualifier("onebankMoveTradeToHistoryStep") Step onebankMoveTradeToHistoryStep,
                                @Qualifier("onebankAccountProcessStep") Step onebankAccountProcessStep,
                                @Qualifier("onebankUpdateRecordTaskletStep") Step onebankUpdateRecordTaskletStep) {
        return stepBuilderFactory.get("onebankMainStep").flow(new FlowBuilder<SimpleFlow>("mainFlow")
                .start(onebankDownloadFileStep).on("FAILED").fail()
                .from(onebankDownloadFileStep).on("FINISH WITH END").to(onebankNoExistsReconFileStep)
                .next(onebankUpdateRecordTaskletStep)
                .from(onebankDownloadFileStep).on("COMPLETED").to(onebankReconStep)
                .next(onebankReReconStep)
                .next(onebankMoveTradeToHistoryStep)
                .next(onebankAccountProcessStep)
                .next(onebankUpdateRecordTaskletStep)
                .build())
                .repository(jobRepository)
                .build();
    }

    /**
     * 下载渠道对账单
     */
    @Bean("onebankDownloadFileStep")
    public Step onebankDownloadFileStep(StepBuilderFactory stepBuilderFactory, DownloadFileTasklet downloadFileTasklet, DownloadFileStepExecutionListener downloadFileStepExecutionListener) {
        return stepBuilderFactory.get("main:first:step-downloadFile").tasklet(downloadFileTasklet).listener(downloadFileStepExecutionListener).build();
    }

    /**
     * 以渠道对账单为基准进行正常对账处理
     */
    @Bean("onebankReconStep")
    public Step onebankReconStep(StepBuilderFactory stepBuilderFactory,
                                 FlatFileItemReader flatFileItemReader,
                                 ItemWriter itemWriter,
                                 ReconciliationProcessor reconciliationProcessor) {
        return stepBuilderFactory.get("main:second:onebankReconStep")
                .<OneBankReconciliationBO, TransCurrent>chunk(100)
                .reader(flatFileItemReader)
                .processor(reconciliationProcessor)
                .writer(itemWriter)
                .faultTolerant().retryLimit(3).retry(Exception.class)
                .taskExecutor(new SimpleAsyncTaskExecutor("单个商户对账线程-"))
                .throttleLimit(3)
                .build();
    }

    /**
     * 渠道明确返回该对单日不存在对账文件，本地无需对账即可视为对账完成
     */
    @Bean("onebankNoExistsReconFileStep")
    public Step onebankNoExistsReconFileStep(StepBuilderFactory stepBuilderFactory, ReconFileNoExistTasklet reconFileNoExistTasklet) {
        return stepBuilderFactory.get("main:two:step-onebankNoExistsReconFileStep").tasklet(reconFileNoExistTasklet).build();
    }

    /**
     * 以本地清算日期记录为基准进行对账处理[进差错E、F，需要后管人工介入处理]
     */
    @Bean("onebankReReconStep")
    public Step onebankReReconStep(StepBuilderFactory stepBuilderFactory, ReReconciliationTasklet reReconciliationTasklet) {
        return stepBuilderFactory.get("main:four:re-onebankReconStep").tasklet(reReconciliationTasklet).build();
    }

    /**
     * 正常对账并且校正状态成功且需要移到历史表
     */
    @Bean("onebankMoveTradeToHistoryStep")
    public Step onebankMoveTradeToHistoryStep(StepBuilderFactory stepBuilderFactory, MoveTradeToHistoryTasklet moveTradeToHistoryTasklet) {
        return stepBuilderFactory.get("main:five:onebank-move-tradeStep").tasklet(moveTradeToHistoryTasklet).build();
    }

    /**
     * 差错类型为C、D需要系统自动进行账户调账处理
     */
    @Bean("onebankAccountProcessStep")
    public Step onebankAccountProcessStep(StepBuilderFactory stepBuilderFactory, AccountProcessTasklet accountProcessTasklet) {
        return stepBuilderFactory.get("main:seven:onebank-account-tradeStep").tasklet(accountProcessTasklet).build();
    }

    /**
     * 标记该对账单对账完成
     */
    @Bean("onebankUpdateRecordTaskletStep")
    public Step onebankUpdateRecordTaskletStep(StepBuilderFactory stepBuilderFactory, UpdateRecordTasklet updateRecordTasklet) {
        return stepBuilderFactory.get("main:six:onebank-updateRecord-tradeStep").tasklet(updateRecordTasklet).build();
    }

    /**
     * 渠道对账单文件读取解析
     */
    @Bean
    @StepScope
    public FlatFileItemReader getReader(@Value("#{stepExecutionContext[file]}") final String file) {
        return new FlatFileItemReaderBuilder<OneBankReconciliationBO>()
                .name("fileRead")
                .resource(new FileSystemResource(file))
                .targetType(OneBankReconciliationBO.class)
                .linesToSkip(1)
                .recordSeparatorPolicy(new CustomRecordSeparatorPolicy())
                .delimited()
                .delimiter("|")
                .names(new String[]{"reqTradeId", "reqDate", "reqTime",
                        "bizSeqNo", "amount", "ccy", "feeAmount", "feeCcy", "payTransType", "productCode"
                })
                .encoding("UTF-8")
                .build();
    }

    /**
     * 渠道对账单文件内容逐条匹配对账处理
     */
    @Bean
    @StepScope
    public ReconciliationProcessor reconciliationProcessor(@Value("#{stepExecutionContext[reconcileDate]}") String reconcileDate) {
        return new ReconciliationProcessor(reconcileDate);
    }


    /**
     * 无需渠道对账记录的本地对账处理[即默认对账成功处理]
     */
    @Bean("onebankNoChannelReconStep")
    public Step onebankNoChannelReconStep(StepBuilderFactory stepBuilderFactory, NoChannelReconcileTasklet noChannelReconcileTasklet) {
        return stepBuilderFactory.get("main:one:nochannelReconStep").tasklet(noChannelReconcileTasklet).build();
    }

    /**
     * 需要渠道对账且超过指定天数且无渠道清算日期的 进行 默认业务对账处理[]
     */
    @Bean("onebankMinusDayReconciliationStep")
    public Step onebankMinusDayReconciliationStep(StepBuilderFactory stepBuilderFactory, MinusDayReconciliationTasklet minusDayReconciliationTasklet) {
        return stepBuilderFactory.get("main:tow:MinusDay-ReconciliationStep").tasklet(minusDayReconciliationTasklet).build();
    }

    /**
     * 针对交易记录超过N天,未对账的，交易清算日期字段为空的当前流水记录做处理
     *
     * @param stepBuilderFactory
     * @param jobRepository
     * @param onebankNoChannelReconStep         华通不需要对账情况，针对对账当日前一天之前的流水进行处理
     * @param onebankMinusDayReconciliationStep 处理N天，之前的，所有未对账的，交易清算日期字段为空的当前流水[进差错E、F，需要后管人工介入处理]
     * @return
     */
    @Bean(name = "minusDayReconStep")
    public Step minusDayReconStep(StepBuilderFactory stepBuilderFactory,
                                  JobRepository jobRepository,
                                  @Qualifier("onebankNoChannelReconStep") Step onebankNoChannelReconStep,
                                  @Qualifier("onebankMinusDayReconciliationStep") Step onebankMinusDayReconciliationStep) {
        return stepBuilderFactory.get("minusDayReconStep").flow(new FlowBuilder<SimpleFlow>("mainFlow")
                .start(onebankNoChannelReconStep)
                .next(onebankMinusDayReconciliationStep)
                .build())
                .repository(jobRepository)
                .build();
    }


}
