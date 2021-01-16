package com.scenetec.upf.operation.security.endpoint;


import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.security.auth.jwt.extractor.TokenExtractor;
import com.scenetec.upf.operation.security.auth.jwt.verifier.TokenVerifier;
import com.scenetec.upf.operation.security.config.JwtSettings;
import com.scenetec.upf.operation.security.config.UtpGlobalWebSecurityConfig.WebSecurityConfig;
import com.scenetec.upf.operation.security.exceptions.InvalidJwtTokenException;
import com.scenetec.upf.operation.security.model.UserContext;
import com.scenetec.upf.operation.security.model.token.JwtToken;
import com.scenetec.upf.operation.security.model.token.JwtTokenFactory;
import com.scenetec.upf.operation.security.model.token.RawAccessJwtToken;
import com.scenetec.upf.operation.security.model.token.RefreshToken;
import com.scenetec.upf.operation.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RefreshTokenEndpoint
 *
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
@RestController
public class RefreshTokenEndpoint {
    @Autowired
    private JwtTokenFactory tokenFactory;
    @Autowired
    private JwtSettings jwtSettings;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenVerifier tokenVerifier;

    @Autowired
    @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;

    @RequestMapping(value="/api/auth/token", method= RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtTokenException());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtTokenException();
        }

        String subject = refreshToken.getSubject();
        User user = userService.getByUsername(subject);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + subject);
        }


        if (user.getRoleList() == null) {
            throw new InsufficientAuthenticationException("User has no roles assigned");
        }

        // 暂时不需要控制接口的权限。使用菜单来暂时跳过控制，因为没有权限会报错。
        List<String> funcResource = userService.getUserPerm(user.getId());
        List<GrantedAuthority> authorities =funcResource.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(String.valueOf(user.getId()), user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
