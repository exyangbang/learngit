package com.scenetec.upf.operation.security.auth.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.ErrorResponse;
import com.scenetec.upf.operation.security.exceptions.AuthMethodNotSupportedException;
import com.scenetec.upf.operation.security.exceptions.JwtExpiredTokenException;
import com.scenetec.upf.operation.security.exceptions.UserLockedException;
import com.scenetec.upf.operation.security.exceptions.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper mapper;

    @Autowired
    public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private Environment env;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        if (e instanceof BadCredentialsException) {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(getMsg(ErrorCode.BSMSC001, env), ErrorCode.BSMSC001.name(), HttpStatus.UNAUTHORIZED));
        } else if (e instanceof JwtExpiredTokenException) {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(getMsg(ErrorCode.BSMSC002, env), ErrorCode.BSMSC002.name(), HttpStatus.UNAUTHORIZED));
        } else if (e instanceof AuthMethodNotSupportedException) {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(getMsg(ErrorCode.BSMSC003, env), ErrorCode.BSMSC003.name(), HttpStatus.UNAUTHORIZED));
        } else if (e instanceof UserLockedException) {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(getMsg(ErrorCode.BSMSC004, env), ErrorCode.BSMSC004.name(), HttpStatus.UNAUTHORIZED));
        } else if (e instanceof ValidateCodeException) {
            mapper.writeValue(response.getWriter(), ErrorResponse.of(getMsg(ErrorCode.BSMSC005, env), ErrorCode.BSMSC005.name(), HttpStatus.UNAUTHORIZED));
        }else if (e instanceof UsernameNotFoundException)
            mapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.BSMSC006.name(), HttpStatus.UNAUTHORIZED));
    }

    private String getMsg(ErrorCode errorCode, Environment env) {
        return env.getProperty(errorCode.name());
    }
}
