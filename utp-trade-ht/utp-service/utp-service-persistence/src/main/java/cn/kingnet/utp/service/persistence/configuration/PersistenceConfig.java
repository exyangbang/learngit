package cn.kingnet.utp.service.persistence.configuration;

import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.service.persistence.service.TransCallbackListener;
import cn.kingnet.utp.service.persistence.support.RedisBloomFilter;
import cn.kingnet.utp.service.persistence.support.VirtualAccountNoGenerate;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.security.RsaUtils;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @Description : 描述
 * @Author : linkaigui
 * @Create : 2019/2/25 13:40
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({ProductAccountProperties.class, PersistenceProperties.class})
@EnableAspectJAutoProxy(exposeProxy = true)
public class PersistenceConfig {

    @Resource
    private ProductAccountProperties productAccountProperties;

    @Bean
    public VirtualAccountNoGenerate virtualAccountNoGenerate(RedisConnectionFactory redisConnectionFactory) {
        return new VirtualAccountNoGenerate(RedisKey.ACCOUNT_NO_SEGMENT_KEY.name(), redisConnectionFactory);
    }


    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            TransCallbackListener transCallbackListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(transCallbackListener, new PatternTopic(RedisKey.TOPIC_HT_CALLBACK_RESP.name()));
        return container;
    }

    @Bean
    public ServerIdGenerate serverIdGenerate() {
        return new ServerIdGenerate(productAccountProperties.getDfa(), productAccountProperties.getSystemId(), UtpServiceId.SYSTEM_ID, UtpServiceId.PERSISTENCE.getId());
    }

    @Bean("rateLimitScript")
    public RedisScript<Long> RateLimitScript() {
        RedisScript redisScript = null;
        try {
            ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("/scripts/rateLimit.lua"));
            log.info("script:{}", scriptSource.getScriptAsString());
            redisScript = RedisScript.of(scriptSource.getScriptAsString(), Long.class);
        } catch (Exception e) {
            log.error("加载 rateLimit.lua脚本异常", e);
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "加载 rateLimit.lua脚本异常:" + e.getMessage());
        }
        return redisScript;
    }

    /**
     * 基于redis的 布隆过滤器
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisBloomFilter redisBloomFilter(RedisTemplate redisTemplate) {
        return new RedisBloomFilter(10000000, 0.008d, redisTemplate);
    }

    @Bean
    public CommonRedisService commonRedisService(RedisTemplate redisTemplate) {
        return new CommonRedisService(redisTemplate);
    }


    @Bean
    public RsaUtils rsaUtils(PersistenceProperties persistenceProperties) {
        Assert.hasText(persistenceProperties.getCipher().getPrivateKey(), () -> "ras解密私钥未配置");
        Assert.hasText(persistenceProperties.getCipher().getPublicKey(), () -> "ras加密公钥未配置,与私钥成对匹配，需提供合作商");
        return new RsaUtils(persistenceProperties.getCipher().getPrivateKey(), persistenceProperties.getCipher().getPublicKey());
    }
}
