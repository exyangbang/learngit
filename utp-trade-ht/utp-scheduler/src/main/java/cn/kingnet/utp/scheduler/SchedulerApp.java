package cn.kingnet.utp.scheduler;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.framework.starter.redis.auto.configuration.EnableKingCache;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 任务调度应用
 *
 */
@EnableKingEurekaService
@EnableKingCache
@EnableScheduling
@MapperScan(basePackages = "cn.kingnet.utp.scheduler.data.mapper")
@EnableFeignClients(basePackages = "cn.kingnet")
@ComponentScan(basePackages = {"cn.kingnet"})
@EnableAsync
public class SchedulerApp {
    public static void main( String[] args ){
        SpringApplication.run(SchedulerApp.class, args);
        LoggerFactory.getLogger(SchedulerApp.class).info(UtpServiceId.SCHEDULER.toString());
    }
}
