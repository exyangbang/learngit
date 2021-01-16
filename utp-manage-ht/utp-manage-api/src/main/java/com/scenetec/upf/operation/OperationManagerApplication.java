package com.scenetec.upf.operation;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author luoxianjun
 */
@SpringBootApplication()
@ComponentScan(basePackages = "com.scenetec.upf")
@MapperScan(basePackages = {"com.scenetec.upf.operation.repository"})
@EnableSwagger2
@ServletComponentScan
@EnableScheduling
public class OperationManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationManagerApplication.class, args);
        LoggerFactory.getLogger(OperationManagerApplication.class).info("==========后管服务启动成功==========");
    }
}
