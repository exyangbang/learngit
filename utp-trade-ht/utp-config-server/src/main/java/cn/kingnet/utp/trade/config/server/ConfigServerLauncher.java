package cn.kingnet.utp.trade.config.server;


import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerLauncher {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerLauncher.class, args);
        LoggerFactory.getLogger(ConfigServerLauncher.class).info("==========华通簿记平台[参数配置中心]启动成功==========");
    }
}
