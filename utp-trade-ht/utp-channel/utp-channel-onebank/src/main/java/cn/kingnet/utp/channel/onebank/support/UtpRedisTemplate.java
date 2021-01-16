package cn.kingnet.utp.channel.onebank.support;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/26
 */
public class UtpRedisTemplate {
    private final RedisTemplate redisTemplate;

    public UtpRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate get() {
        return this.redisTemplate;
    }


}
