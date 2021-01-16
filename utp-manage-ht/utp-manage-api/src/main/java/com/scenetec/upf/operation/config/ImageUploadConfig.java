package com.scenetec.upf.operation.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/20 上午9:56
 */
@Configuration
@ConfigurationProperties(prefix = "upload.image")
@Getter
@Setter

public class ImageUploadConfig {

    private String server;

    private String path;

    private Long maxSize;

    private List<String> type;
}
