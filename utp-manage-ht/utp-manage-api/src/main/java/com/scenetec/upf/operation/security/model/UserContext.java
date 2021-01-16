package com.scenetec.upf.operation.security.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 *
 * @author vladimir.stankovic
 *
 * Aug 4, 2016
 */
public class UserContext {
    private final String id;
    private final String username;
    private final List<GrantedAuthority> authorities;

    private UserContext(String id, String username,  List<GrantedAuthority> authorities) {
        this.username = username;
        this.id = id;
        this.authorities = authorities;
    }

    public static UserContext create(String id, String username, List<GrantedAuthority> authorities) {
        if (StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("Username is blank: " + username);
        }
        return new UserContext(id, username, authorities);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
