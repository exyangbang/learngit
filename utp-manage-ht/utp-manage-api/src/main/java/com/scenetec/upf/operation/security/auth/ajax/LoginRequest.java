package com.scenetec.upf.operation.security.auth.ajax;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
public class LoginRequest {
    private String username;
    private String password;
    private String id;
    private String validateCode;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("id")String id, @JsonProperty("validateCode")String validateCode) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.validateCode = validateCode;
    }

    public String getId() { return id;}

    public String getValidateCode() { return validateCode; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
