package cn.kingnet.utp.reconciliation;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.framework.starter.redis.auto.configuration.EnableKingCache;
import cn.kingnet.framework.starter.redis.redisson.EnableKingLock;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@EnableKingEurekaService
@EnableKingCache
@EnableKingLock
@EnableScheduling
@EnableFeignClients(basePackages = {"cn.kingnet.utp.channel.api.onebank",
        "cn.kingnet.utp.service.persistence"})
@MapperScan(basePackages = "cn.kingnet.utp.reconciliation.data.mapper")
public class ReconciliationApp {
    public static void main( String[] args ){
        SpringApplication.run(ReconciliationApp.class, args);
        LoggerFactory.getLogger(ReconciliationApp.class).info(UtpServiceId.RECONCILIATION.toString());
    }
}
