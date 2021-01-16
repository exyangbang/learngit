package com.scenetec.upf.operation.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * fpt 配置
 * @author luoxianjun@scenetec.com
 * 2018/7/16 下午2:20
 */
@Configuration
@ConfigurationProperties(prefix = "ftp")
@Getter
@Setter
public class FtpConfig {

    /**
     * ftp 地址
     */
    private String address;
    /**
     * ftp 根目录
     */
    private String basePath;
    /**
     * ftp 端口号
     */
    private Integer port;
    /**
     * ftp 用户名
     */
    private String username;
    /**
     * ftp 密码
     */
    private String password;

}
