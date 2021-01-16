package cn.kingnet.utp.service.persistence.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

/**
 * @Description : 虚拟账户编号生成工具
 * @Author : linkaigui
 * @Create : 2019/3/6 11:25
 */
public class VirtualAccountNoGenerate {

    private final RedisAtomicLong redisAtomicLong;

    /**
     * 虚拟账户前缀
     */
    @Value("${cn.kingnet.utp.virtual-account-prefix}")
    private String virtualAccountPrefix;

    /**
     * 预付费卡虚拟账户前缀
     */
    @Value("${cn.kingnet.utp.precard-account-prefix}")
    private String precardAccountPrefix;

    public VirtualAccountNoGenerate(String key, RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        redisTemplate.setExposeConnection(true);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();
        this.redisAtomicLong = new RedisAtomicLong(key, redisTemplate);
    }

    public long get() {
        return this.redisAtomicLong.get();
    }

    public long incrementAndGet() {
        return this.redisAtomicLong.incrementAndGet();
    }

    /**
     * 虚拟账户命名规则
     * 总长度19位，说明如下：
     * 1、        910(3位，值固定)
     * 2、        平台编号(4位)
     * 3、        华通预留位(3位，默认填写101)
     * 4、        顺序号(9位)
     * 如：910 0001 101 000000001
     * 预付费卡的 910改为999.
     *
     * @return 虚拟账户编号
     */
    public String createAccountNo() {
        long seqNo = this.incrementAndGet();
        String seqNoStr = String.format("%09d", seqNo);
        return new StringBuilder(virtualAccountPrefix).append(seqNoStr).toString();
    }

    /**
     * 预付费卡虚拟账户命名规则
     * 总长度19位，说明如下：
     * 1、        999(3位，值固定)
     * 2、        平台编号(4位)
     * 3、        华通预留位(3位，默认填写101)
     * 4、        顺序号(9位)
     * 如：999 0001 101 000000001
     * 预付费卡的 910改为999.
     *
     * @return 虚拟账户编号
     */
    public String createPrecardAccountNo() {
        long seqNo = this.incrementAndGet();
        String seqNoStr = String.format("%09d", seqNo);
        return new StringBuilder(precardAccountPrefix).append(seqNoStr).toString();
    }
}
