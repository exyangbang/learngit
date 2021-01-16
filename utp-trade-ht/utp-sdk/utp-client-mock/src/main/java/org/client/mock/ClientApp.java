package org.client.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApp {
    private static final Logger log = LoggerFactory.getLogger(ClientApp.class);


    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
        log.info("客户端模拟应用启动成功");
    }


}
