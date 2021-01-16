package cn.kingnet.utp.scheduler.configuration;

import cn.kingnet.utp.product.common.config.FeignErrorDecoder;
import cn.kingnet.utp.scheduler.service.SftpService;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @Description : 调度任务配置
 */
@Configuration
@EnableConfigurationProperties({HTScheduleProperties.class, ProductAccountProperties.class, SftpConfig.class})
@Slf4j
public class SchedulerConfiguration {
    @Resource
    private HTScheduleProperties htScheduleProperties;

    @Resource
    private ProductAccountProperties productAccountProperties;

    @Bean
    public UDPSettleSplitFeature udpSettleSplitFeature(HTScheduleProperties htScheduleProperties) {
        Assert.hasText(htScheduleProperties.getSettleSplitDir(), "cn.kingnet.utp.schedule.ht-properties.settle-split-dir 未配置");
        UDPSettleSplitFeature udpSettleSplitFeature = new UDPSettleSplitFeature();
        udpSettleSplitFeature.setSettleSplitDir(htScheduleProperties.getSettleSplitDir());
        udpSettleSplitFeature.setResultDir(htScheduleProperties.getResultDir());
        return udpSettleSplitFeature;
    }

    @Bean
    public ExecutorService newFixedThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("scheduler-pool-%d").build();
        //使用一个基于FIFO排序的阻塞队列，在所有corePoolSize线程都忙时新任务将在队列中等待
        return new ThreadPoolExecutor(htScheduleProperties.getThreadPoolNum(), htScheduleProperties.getMaxThreadPoolNum(),
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(htScheduleProperties.getBlockingQueueNum()), namedThreadFactory);
    }

    @Bean
    public FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }

    @Bean
    public ServerIdGenerate serverIdGenerate() {
        return new ServerIdGenerate(productAccountProperties.getDfa(), productAccountProperties.getSystemId(), UtpServiceId.SYSTEM_ID, UtpServiceId.SCHEDULER.getId());
    }

    @Bean
    public SftpService SftpService(SftpConfig sftpConfig) {
        return new SftpService(sftpConfig);
    }

}
