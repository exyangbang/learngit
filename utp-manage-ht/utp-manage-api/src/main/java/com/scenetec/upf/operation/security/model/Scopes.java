package com.scenetec.upf.operation.security.model;

/**
 * Scopes
 *
 * @author vladimir.stankovic
 *
 * Aug 18, 2016
 */
public enum Scopes {
    /**
     * 刷新token
     */
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
