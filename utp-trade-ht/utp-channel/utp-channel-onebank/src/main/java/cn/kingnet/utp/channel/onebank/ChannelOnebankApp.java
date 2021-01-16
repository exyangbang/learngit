package cn.kingnet.utp.channel.onebank;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.framework.starter.redis.auto.configuration.EnableKingCache;
import cn.kingnet.utp.channel.onebank.configuration.ChannelConfiguration;
import cn.kingnet.utp.trade.common.enums.UtpServiceId;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhongli
 */
@EnableKingEurekaService
@EnableFeignClients(basePackages = {"cn.kingnet.product.api.account","cn.kingnet.utp.service.persistence.api"})
@EnableKingCache
@EnableAsync
@Slf4j
@Import(ChannelConfiguration.class)
public class ChannelOnebankApp {
    public static void main(String[] args) {
        SpringApplication.run(ChannelOnebankApp.class, args);
        LoggerFactory.getLogger(ChannelOnebankApp.class).info(UtpServiceId.CHANNEL.toString());
    }
}
