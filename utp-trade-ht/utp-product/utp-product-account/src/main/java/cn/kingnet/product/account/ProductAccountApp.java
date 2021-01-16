package cn.kingnet.product.account;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.framework.starter.redis.auto.configuration.EnableKingCache;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableKingEurekaService
@EnableFeignClients(basePackages = {"cn.kingnet.utp.channel","cn.kingnet.utp.service.persistence","cn.kingnet.product.account.service"})
@ComponentScan(basePackages = {"cn.kingnet"})
@EnableAsync
@EnableKingCache
public class ProductAccountApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductAccountApp.class, args);
        LoggerFactory.getLogger(ProductAccountApp.class).info(UtpServiceId.PRODUCT.toString());
    }

}
