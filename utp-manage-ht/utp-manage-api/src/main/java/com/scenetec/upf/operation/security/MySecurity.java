package com.scenetec.upf.operation.security;

import com.scenetec.upf.operation.initialization.LoadPermFuncMap;
import com.scenetec.upf.operation.model.domain.system.PermFunc;
import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.model.domain.system.status.UserStatusEnum;
import com.scenetec.upf.operation.security.model.UserContext;
import com.scenetec.upf.operation.service.system.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/16 下午3:59
 */
@Component("mySecurity")
@Slf4j
public class MySecurity {
    @Autowired
    UserService userService;
    public boolean check(Authentication authentication, HttpServletRequest request){
        //校验用户状态是否为正常状态，防止当前登录用户被删除后还能正常操作的问题
        //start
        UserContext userContext = userService.getUserContext();
        if(userContext == null){
            return false;
        }
        User user = userService.getUser(Long.parseLong(userContext.getId()));
        if(UserStatusEnum.DELETED.toString().equals(user.getStatus())){
            throw new UsernameNotFoundException(user.getUsername()+"用户被删除!");
        }
        //end
        Object principal  = authentication.getPrincipal();
        if(principal  != null){
            List<String> permList = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(permList)) {
                return false;
            }

            List<Long> allowAccessFuncs = permList.stream().map(Long::parseLong).collect(Collectors.toList());
            List<String> funcList = getAllowAccessFunc(allowAccessFuncs);
            if (CollectionUtils.isEmpty(funcList)) {
                if (log.isDebugEnabled()) {
                    log.debug("无允许进入权限");
                }
                return false;
            }
            boolean isAllowUrl = false;
            String requestPathFormat = getRequestUrlFormat(request);
            if (log.isDebugEnabled()) {
                log.debug("请求路径为： "+ requestPathFormat);
                log.debug("允许路径列表为: "+ Arrays.toString(funcList.toArray()));
            }
            for (String funcUrl: funcList) {
                if (funcUrl.equals(requestPathFormat) || requestPathFormat.matches(funcUrl)) {
                    isAllowUrl = true;
                    break;
                }
            }
            return isAllowUrl;
        }
        return false;
    }

    private String getRequestUrlFormat(HttpServletRequest request){
        String method = request.getMethod().toLowerCase();
        String path = request.getServletPath();
        return path+":"+method;
    }

    private List<String> getAllowAccessFunc(List<Long> permIds) {
        if (LoadPermFuncMap.permFuncMap.size() == 0) {
            return null;
        }
        List<String> funcList = new ArrayList<>();
        for (Long perm: permIds) {
            List<PermFunc> funcURLList = LoadPermFuncMap.permFuncMap.get(perm);
            if (funcURLList == null) {
                continue;
            }
            List<String> funcURLString = funcURLList.stream().map(PermFunc::getFuncUrl).collect(Collectors.toList());
            funcList.addAll(funcURLString);
        }
        return funcList;
    }
}
