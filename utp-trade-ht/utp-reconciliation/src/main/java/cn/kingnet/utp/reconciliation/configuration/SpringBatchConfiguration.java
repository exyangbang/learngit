package cn.kingnet.utp.reconciliation.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.DefaultJobKeyGenerator;
import org.springframework.batch.core.JobKeyGenerator;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongli
 * @date 2018/9/12
 */
@Configuration
@EnableBatchProcessing
@Slf4j
public class SpringBatchConfiguration {

    @Bean
    public JobKeyGenerator<JobParameters> jobKeyGenerator() {
        return new DefaultJobKeyGenerator();
    }

    /**
     * 重试策略
     * 重试3次，每次间隔5秒中
     *
     * @return
     */
    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        Map<Class<? extends Throwable>, Boolean> map = new HashMap<Class<? extends Throwable>, Boolean>();
        map.put(Exception.class, true);
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(3, map);
        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(5000L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        return retryTemplate;
    }
}
