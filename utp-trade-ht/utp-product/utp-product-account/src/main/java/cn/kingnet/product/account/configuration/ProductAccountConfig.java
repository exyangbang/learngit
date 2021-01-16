package cn.kingnet.product.account.configuration;

import cn.buyforyou.sign.crypto.api.UnionUAS;
import cn.kingnet.product.account.service.inner.SftpService;
import cn.kingnet.product.account.support.UtpCallbackTemplate;
import cn.kingnet.product.account.support.UtpRestTemplate;
import cn.kingnet.utp.product.common.config.FeignErrorDecoder;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import cn.kingnet.utp.trade.common.security.HTSIGNAuthorization;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.util.concurrent.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月09日
 */
@Configuration
@EnableConfigurationProperties({ProductAccountProperties.class})
@Slf4j
public class ProductAccountConfig {
    @Autowired
    ProductAccountProperties productAccountProperties;
    @Autowired
    UtpConfigProperties utpConfigProperties;

    @Bean
    public BeanApplicationContext beanApplicationContext() {
        return new BeanApplicationContext();
    }

    @Bean
    public FeignErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }

    @Bean
    public UtpRestTemplate restTemplate() {
        return new UtpRestTemplate(productAccountProperties);
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
        String unionApiConfigFile = productAccountProperties.getUnionApiConfigFile();
        log.info("===>unionApiConfigFile 配置文件位置：{}", unionApiConfigFile);
        Assert.hasText(unionApiConfigFile, "未配置 cn.kingnet.utp.product.account.union-api-config-file");
        return new UnionUAS(unionApiConfigFile);
    }

    /**
     * 华通签名验签
     *
     * @return
     */
    @Bean
    public HTSIGNAuthorization htsignAuthorization() {
        log.info("===>签名验证类型[{}],是否验签[{}],签名证书名称[{}],验证根证书名称[{}]", utpConfigProperties.getSignType(),
                utpConfigProperties.getHtSignFlag(), utpConfigProperties.getSignCertName(), utpConfigProperties.getVerifyCertName());
        if (!"0".equals(utpConfigProperties.getHtSignFlag())) {
            Assert.hasText(utpConfigProperties.getSignCertName(), "未配置 cn.kingnet.utp.sign-cert-name");
            Assert.hasText(utpConfigProperties.getVerifyCertName(), "未配置 cn.kingnet.utp.verify-cert-name");
        }
        return new HTSIGNAuthorization(null, utpConfigProperties.getVerifyCertName(), utpConfigProperties.getSignCertName(), utpConfigProperties.getHtSignFlag());
    }

    /**
     * Utp回调辅助类
     *
     * @param utpRestTemplate
     * @param htsignAuthorization
     * @return
     */
    @Bean
    public UtpCallbackTemplate utpCallbackTemplate(UtpRestTemplate utpRestTemplate, HTSIGNAuthorization htsignAuthorization) {
        return new UtpCallbackTemplate(utpRestTemplate, htsignAuthorization);
    }

    @Bean
    public ServerIdGenerate serverIdGenerate() {
        Assert.hasText(productAccountProperties.getDfa(), () -> "未配置 cn.kingnet.utp.product.account.dfa ");
        Assert.hasText(productAccountProperties.getSystemId(), () -> "未配置 cn.kingnet.utp.product.account.systemId ");
        return new ServerIdGenerate(productAccountProperties.getDfa(), productAccountProperties.getSystemId(), UtpServiceId.SYSTEM_ID, UtpServiceId.PRODUCT.getId());
    }

    @Bean
    public CommonRedisService commonRedisService(RedisTemplate redisTemplate) {
        return new CommonRedisService(redisTemplate);
    }

    @Bean
    public SftpService sftpService(SftpConfig sftpConfig) {
        return new SftpService(sftpConfig);
    }
}
