package cn.kingnet.utp.reconciliation.configuration;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2020/04/17
 */
@Configuration
@Slf4j
public class RedisClientConfig {
    @Autowired
    private RedisProperties redisProperties;

    public RedisClientConfig() {
    }
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setCodec(new FastJsonForRedisCodec());
        if (this.redisProperties.getSentinel() != null) {
            SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
            sentinelServersConfig.setMasterName(this.redisProperties.getSentinel().getMaster());
            sentinelServersConfig.addSentinelAddress(this.createAddress(this.redisProperties.getSentinel().getNodes()));
            sentinelServersConfig.setDatabase(this.redisProperties.getDatabase());
            sentinelServersConfig.setReadMode(ReadMode.MASTER_SLAVE);
            if (this.redisProperties.getPassword() != null) {
                sentinelServersConfig.setPassword(this.redisProperties.getPassword());
            }
        } else if (this.redisProperties.getCluster() != null) {
            ClusterServersConfig clusterServersConfig = config.useClusterServers();
            clusterServersConfig.addNodeAddress(this.createAddress(this.redisProperties.getCluster().getNodes()));
            clusterServersConfig.setTimeout((new Long(this.redisProperties.getTimeout().toMillis())).intValue());
            if (this.redisProperties.getPassword() != null) {
                clusterServersConfig.setPassword(this.redisProperties.getPassword());
            }
        } else {
            SingleServerConfig singleServerConfig = config.useSingleServer();
            singleServerConfig.setAddress(this.createAddress(this.redisProperties.getHost(), this.redisProperties.getPort()));
            singleServerConfig.setDatabase(this.redisProperties.getDatabase());
            if (this.redisProperties.getPassword() != null) {
                singleServerConfig.setPassword(this.redisProperties.getPassword());
            }
        }
        log.error(" config = {}", JSON.toJSONString(config));
        return Redisson.create(config);
    }

    private String createAddress(String host, Object port) {
        if (host.contains(":")) {
            host = "[" + host + "]";
        }

        String schema = this.redisProperties.isSsl() ? "rediss://" : "redis://";
        return schema.concat(host).concat(":").concat(String.valueOf(port));
    }

    private String[] createAddress(List<String> list) {
        String schema = this.redisProperties.isSsl() ? "rediss://" : "redis://";
        return (String[])list.stream().map((l) -> {
            return schema.concat(l);
        }).toArray((x$0) -> {
            return new String[x$0];
        });
    }
}
