package com.scenetec.upf.operation.security.exceptions;

import org.springframework.security.core.AuthenticationException;
/**
 * @author luoxianjun
 * */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

}