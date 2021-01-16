package cn.kingnet.utp.trade.discovery;

import cn.kingnet.cloud.eureka.server.EnableKingEurekaServer;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@EnableKingEurekaServer
public class DiscoveryLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryLauncher.class, args);
        LoggerFactory.getLogger(DiscoveryLauncher.class).info("==========华通簿记平台[注册中心服务]启动成功==========");
    }
}
