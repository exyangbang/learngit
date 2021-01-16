package cn.kingnet.utp.channel.onebank.configuration;

import cfca.paperless.client.servlet.PaperlessClient;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.channel.onebank.support.UtpRedisTemplate;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.onebank.dmb.client.api.DMB;
import cn.onebank.dmb.client.exception.DMBException;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.io.File;
import java.util.concurrent.*;

/**
 * @author zhongli
 */
@Configuration
@EnableConfigurationProperties({OnebankChannelProperties.class,OnebankElectronicProperties.class})
public class ChannelConfiguration {
    @Autowired
    OnebankChannelProperties onebankChannelProperties;

    @Autowired
    OnebankElectronicProperties onebankElectronicProperties;

    @Bean
    public BeanApplicationContext beanApplicationContext() {
        return new BeanApplicationContext();
    }

    @Bean
    public ExecutorService newFixedThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("channel-union-pool-%d").build();
        //使用一个基于FIFO排序的阻塞队列，在所有corePoolSize线程都忙时新任务将在队列中等待
        return new ThreadPoolExecutor(onebankChannelProperties.getThreadPoolNum(), onebankChannelProperties.getMaxThreadPoolNum(),
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(), namedThreadFactory);
    }

    @Bean
    public UtpDbmTemplate dmb() throws DMBException {
        Assert.hasText(onebankChannelProperties.getDmbConfigPath(), "未配置 cn.kingnet.utp.channel.onebank.dmb-config-path");
        DMB dmb = DMB.getInstance();
        try{
            File file = new File(onebankChannelProperties.getDmbConfigPath());
            dmb.init(file.getAbsolutePath());
            dmb.start();
        }catch (Exception e){
            dmb.shutdownNow();
            dmb.destory();
            throw e;
        }
        return new UtpDbmTemplate(dmb);
    }

    @Bean
    public UtpRedisTemplate utpRedisTemplate(RedisTemplate redisTemplate){
        return new UtpRedisTemplate(redisTemplate);
    }

    @Bean
    public PaperlessClient paperlessClient(){
        Assert.hasText(onebankElectronicProperties.getUrl(), "未配置 cn.kingnet.utp.channel.onebank.electronic.url");
        PaperlessClient paperlessClient = new PaperlessClient(onebankElectronicProperties.getUrl(),onebankElectronicProperties.getConnectTimeout(),onebankElectronicProperties.getReadTimeout());
        return paperlessClient;
    }
}
