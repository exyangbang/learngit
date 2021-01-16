package com.scenetec.upf.operation.security.exceptions;

import org.springframework.security.core.AuthenticationException;
/**
 * @author sunquanhu
 * */
public class UserLockedException extends AuthenticationException {

    public UserLockedException(String msg) {
        super(msg);
    }

    public UserLockedException(String msg, Throwable t) {
        super(msg, t);
    }
}
