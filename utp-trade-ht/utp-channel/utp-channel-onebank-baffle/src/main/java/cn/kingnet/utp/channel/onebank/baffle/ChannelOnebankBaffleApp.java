package cn.kingnet.utp.channel.onebank.baffle;

import cn.kingnet.cloud.eureka.service.EnableKingEurekaService;
import cn.kingnet.utp.channel.onebank.baffle.configuration.ChannelConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author zhongli
 */
@EnableKingEurekaService
@EnableFeignClients(basePackages = {"cn.kingnet.product.api.account"})
@Slf4j
@Import(ChannelConfiguration.class)
public class ChannelOnebankBaffleApp {
    public static void main(String[] args) {
        SpringApplication.run(ChannelOnebankBaffleApp.class, args);
        LoggerFactory.getLogger(ChannelOnebankBaffleApp.class).info("==========【渠道挡板】华通簿记平台[华通渠道服务]启动成功==========");
    }
}
