package cn.kingnet.product.precard.configuration;

import cn.buyforyou.sign.crypto.api.UnionUAS;
import cn.kingnet.utp.product.common.config.FeignErrorDecoder;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.util.concurrent.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月09日
 */
@Configuration
@EnableConfigurationProperties(ProductPreCardProperties.class)
@Slf4j
public class ProductPreCardConfig {

    @Autowired
    ProductPreCardProperties productPreCardProperties;

    @Bean
    public BeanApplicationContext beanApplicationContext() {
        return new BeanApplicationContext();
    }

    @Bean
    public FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }

    @Bean
    @Qualifier("fileExecutorService")
    public ExecutorService newFixedThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("fileManage-service-pool-%d").build();
        //使用一个基于FIFO排序的阻塞队列，在所有corePoolSize线程都忙时新任务将在队列中等待
        return new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(), namedThreadFactory);
    }

    @Bean
    public UnionUAS unionUAS() {
        String unionApiConfigFile = productPreCardProperties.getUnionApiConfigFile();
        log.info("===>unionApiConfigFile 配置文件位置：{}",unionApiConfigFile);
        Assert.hasText(unionApiConfigFile, "未配置 cn.kingnet.utp.product.account.union-api-config-file");
        return new UnionUAS(unionApiConfigFile);
    }

}
