package com.scenetec.upf.operation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: upf-operation
 * @description: 异常码配置
 * @author: luoxianjun@scenetec.com
 * @create: 2018-07-24 17:36
 **/
@Component
@ConfigurationProperties()
@PropertySource(value = {"classpath:config/errorCode.properties"}, encoding = "UTF-8")
public class ErrorCodeConfig {

    private Map<String, String> errorCode = new HashMap<>();

    public Map<String, String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Map<String, String> errorCode) {
        this.errorCode = errorCode;
    }
}

