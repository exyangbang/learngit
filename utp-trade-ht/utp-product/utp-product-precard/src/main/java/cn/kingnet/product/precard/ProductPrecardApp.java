package cn.kingnet.product.precard;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableKingEurekaService
@EnableFeignClients(basePackages = {"cn.kingnet.utp.channel","cn.kingnet.utp.service.persistence"})
@ComponentScan(basePackages = {"cn.kingnet"})
public class ProductPrecardApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductPrecardApp.class, args);
        LoggerFactory.getLogger(ProductPrecardApp.class).info("==========预付费卡服务启动成功==========");
    }

}