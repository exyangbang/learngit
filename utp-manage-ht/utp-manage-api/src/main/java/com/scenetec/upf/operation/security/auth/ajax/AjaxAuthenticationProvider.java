package com.scenetec.upf.operation.security.auth.ajax;

import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.security.model.UserContext;
import com.scenetec.upf.operation.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vladimir.stankovic
 *
 * Aug 3, 2016
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    private final BCryptPasswordEncoder encoder;
    private final UserService userService;
    @Value("${allowFailedTimes}")
    private int allowFailedTimes;
    @Autowired
    public AjaxAuthenticationProvider(final UserService userService, final BCryptPasswordEncoder encoder){
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User user = userService.getByUsername(username);

        if (user  == null) {
            if(userService.checkUmUser(username))
                throw  new UsernameNotFoundException(username+"账号未创建!");
            else
                throw  new UsernameNotFoundException("账号输入有误!");
        }

//        if (userService.isUserLocked(user)) {
//            throw new UserLockedException("用户被锁定");
//        }
        if(user.getUmLogin().equals("1")){
            userService.loginUm(username,password);
        }else
        if (!encoder.matches(password, user.getPassword())) {
            userService.loginError(user);
            int loginFailedTimes = (user.getLoginFailTimes()==null?0:user.getLoginFailTimes());
            throw new BadCredentialsException("无效的用户名密码，剩余输入次数"+ getResidueDegree(loginFailedTimes));
        }

        if (user.getRoleList() == null) {
            throw new InsufficientAuthenticationException("User has no roles assigned");
        }

        List<String> funcResource = userService.getUserPerm(user.getId());
        List<GrantedAuthority> authorities =funcResource.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        UserContext userContext = UserContext.create(String.valueOf(user.getId()),user.getUsername(), authorities);
        // 重置登陆失败次数为0
        userService.resetLoginFailTimes(user.getId());
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private int getResidueDegree(int loginFailedTimes) {
        return (allowFailedTimes-loginFailedTimes)<0?0:(allowFailedTimes-loginFailedTimes);
    }
}
