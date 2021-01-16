package com.scenetec.upf.operation.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scenetec.upf.operation.filter.CustomCorsFilter;
import com.scenetec.upf.operation.security.RestAuthenticationEntryPoint;
import com.scenetec.upf.operation.security.auth.ajax.AjaxAuthenticationProvider;
import com.scenetec.upf.operation.security.auth.ajax.AjaxLoginProcessingFilter;
import com.scenetec.upf.operation.security.auth.jwt.JwtAuthenticationProvider;
import com.scenetec.upf.operation.security.auth.jwt.JwtTokenAuthenticationProcessingFilter;
import com.scenetec.upf.operation.security.auth.jwt.SkipPathRequestMatcher;
import com.scenetec.upf.operation.security.auth.jwt.extractor.TokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

/**
 * WebSecurityConfig
 *
 * @author vladimir.stankovic
 * <p>
 * Aug 3, 2016
 */
@Configuration
@EnableWebSecurity
public class UtpGlobalWebSecurityConfig {

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
        private static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
        private static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
        private static final String TOKEN_BASED_FILES_POINT = "/files/**";
        private static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";

        @Autowired
        private RestAuthenticationEntryPoint authenticationEntryPoint;
        @Autowired
        private AuthenticationSuccessHandler successHandler;
        @Autowired
        private AuthenticationFailureHandler failureHandler;
        @Autowired
        private AjaxAuthenticationProvider ajaxAuthenticationProvider;
        @Autowired
        private JwtAuthenticationProvider jwtAuthenticationProvider;

        @Autowired
        private TokenExtractor tokenExtractor;

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private ObjectMapper objectMapper;

        protected AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter() {
            AjaxLoginProcessingFilter filter = new AjaxLoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler, objectMapper);
            filter.setAuthenticationManager(this.authenticationManager);
            return filter;
        }

        protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() {
            List<String> pathsToSkip = Arrays.asList(TOKEN_REFRESH_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT);
            SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, TOKEN_BASED_AUTH_ENTRY_POINT);
            JwtTokenAuthenticationProcessingFilter filter
                    = new JwtTokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
            filter.setAuthenticationManager(this.authenticationManager);
            return filter;
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(ajaxAuthenticationProvider);
            auth.authenticationProvider(jwtAuthenticationProvider);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable() // We don't need CSRF for JWT based authentication
                    .exceptionHandling()
                    .authenticationEntryPoint(this.authenticationEntryPoint)

                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    // Login end-point
                    .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll()
                    // Token refresh end-point
                    .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll()
                    .antMatchers(TOKEN_BASED_FILES_POINT).permitAll()
                    .antMatchers("/dictionaries").permitAll()
                    .antMatchers("/api/upload/image").permitAll()
                    .antMatchers("/api/userPermission").permitAll()
                    .and()
                    .authorizeRequests()
                    // Protected API End-points
                    .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).access("@mySecurity.check(authentication, request)")
                    .and()
                    .addFilterBefore(new CustomCorsFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(buildAjaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
        }

    }
}


