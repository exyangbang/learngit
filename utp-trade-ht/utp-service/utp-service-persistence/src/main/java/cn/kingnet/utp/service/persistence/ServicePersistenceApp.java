package cn.kingnet.utp.service.persistence;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.framework.starter.redis.auto.configuration.EnableKingCache;
import cn.kingnet.framework.starter.redis.redisson.EnableKingLock;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 */
@EnableKingEurekaService
@MapperScan(basePackages = "cn.kingnet.utp.service.persistence.mapper")
@EnableKingCache
@EnableKingLock
@EnableAsync
public class ServicePersistenceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServicePersistenceApp.class, args);
        LoggerFactory.getLogger(ServicePersistenceApp.class).info(UtpServiceId.PERSISTENCE.toString());
    }
}
