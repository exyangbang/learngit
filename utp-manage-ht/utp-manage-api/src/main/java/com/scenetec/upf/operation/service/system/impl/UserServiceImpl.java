package com.scenetec.upf.operation.service.system.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.system.Role;
import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.model.domain.system.status.UserStatusEnum;
import com.scenetec.upf.operation.repository.system.UserMapper;
import com.scenetec.upf.operation.security.model.UserContext;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.HttpsClientRequestFactory;
import com.scenetec.upf.operation.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author luoxianjun
 * @date 2018/3/18
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Value("${allowFailedTimes}")
    private int allowFailedTimes;

    @Value("${lockInterval}")
    private int lockInterval;

    @Value("${um.login.url}")
    private String umUrl;

    @Value("${um.appkey}")
    private String appKey;


    private RestTemplate restTemplate= new RestTemplate(new HttpsClientRequestFactory());

    @Override
    public User getByUsername(String username) {
        List<User> userList = userMapper.findByUsername(username);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        List<User> newUserList = new ArrayList<>();
        for (User user : userList) {

            if (!user.getStatus().equals(UserStatusEnum.DELETED.name())) {
                newUserList.add(user);
            }
        }
        if (CollectionUtils.isEmpty(newUserList)) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public PageInfo<User> getUsersDoPage(String username, String name, int pageNum, int pageSize, String status) {

        return new PageInfo<>(PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userMapper.findByUsernameLikeOrNameLike(username, name, status)));
    }

    @Override
    public User getUser(Long id) {
        return userMapper.findOne(id);
    }

    @Override
    public boolean checkUmUser(String username) {
        try {
            MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
            request.add("appKey", appKey);
            request.add("loginType","pwd");
            request.add("accountId", username);
            request.add("password", "123456");
            String response="";
            log.debug("查询um用户是否存在 请求地址：{} k={}",umUrl,appKey);
            log.debug("查询um用户是否存在 请求报文：{}",request);
            response=restTemplate.postForObject(umUrl, request,String.class);
            System.out.println(response);
            log.debug("查询um用户是否存在 响应报文：{}",request);
            JSONObject object=JSON.parseObject(response);
            if(object.getString("resultCode").equals("UM-LOGIN-9002")){
                return true;
            }
        }catch (Exception e){
            throw new SystemRuntimeException(ErrorCode.BSMUM001);
        }
        return false;
    }

    @Override
    public boolean loginUm(String username, String password) {
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
        request.add("appKey", appKey);
        request.add("loginType","pwd");
        request.add("accountId", username);
        request.add("password",password);
        String response="";
        log.debug("登录um 请求地址：{} k={}",umUrl,appKey);
        log.debug("登录um 请求报文：{}",request);
        response=restTemplate.postForObject(umUrl, request,String.class);
        log.debug("登录um 响应报文：{}",response);
        System.out.println(response);
        JSONObject object=JSON.parseObject(response);
        if(object.getString("resultCode").equals("UM-LOGIN-1000")){
            return true;
        }else if(object.getString("resultCode").equals("UM-LOGIN-9005")){
            throw new UsernameNotFoundException("账号已经被锁定,请在30分钟后继续尝试或联系管理员!");
        }else {
            throw new UsernameNotFoundException("密码错误!");
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void saveUser(User user) {
        if (user == null) {
            return;
        }
        if(user.getUmLogin().equals("1")&&!checkUmUser(user.getUsername())){
            throw new SystemRuntimeException(ErrorCode.BSMUM007);
        }
        // 判断用户名和状态判断是否重复
        List<User> existUser = userMapper.findByUsernameAndStatusExit(user.getUsername(),UserStatusEnum.DELETED.toString());
        if (!CollectionUtils.isEmpty(existUser)) {
            log.error("创建用户失败， 用户名重复");
            throw new SystemRuntimeException(ErrorCode.BSMUM001, user.getUsername());
        }
        Date current = new Date();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setGmtCreate(current);
        user.setGmtModified(current);
        user.setUserCreate(this.getUserContext().getUsername());
        user.setUserModified(this.getUserContext().getUsername());
        user.setStatus(UserStatusEnum.NORMAL.toString());
        user.setId(IdGenerate.getId());
        userMapper.insertUser(user);
        List<Role> roleList = user.getRoleList();
        if (CollectionUtils.isEmpty(roleList)) {
            log.error("请添加用户角色");
            throw new SystemRuntimeException(ErrorCode.BSMUM002);
        }
        insertUseRole(user, user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,rollbackFor = Exception.class)
    public void updateUser(User user) {
        if (user == null) {
            return;
        }
        List<User> existUser = userMapper.findByUsernameAndStatusExit(user.getUsername(),UserStatusEnum.DELETED.toString());

        if (CollectionUtils.isEmpty(existUser)) {
            log.error("用户不存在");
            throw new SystemRuntimeException(ErrorCode.BSMUM003,user.getUsername());
        }

        List<Role> roleList = user.getRoleList();
        if (CollectionUtils.isEmpty(roleList)) {
            log.error("请添加用户角色");
            throw new SystemRuntimeException(ErrorCode.BSMUM002);
        }

        User userDb = userMapper.findOne(user.getId());

        if (userDb == null) {
            return;
        }

        userDb.setCertNo(user.getCertNo());
        userDb.setEmail(user.getEmail());
        userDb.setMobileNo(user.getMobileNo());
        userDb.setName(user.getName());
        userDb.setPost(user.getPost());
        userDb.setSex(user.getSex());
        userDb.setOrgId(user.getOrgId());
        userDb.setGmtModified(new Date());
        userDb.setUserModified(this.getUserContext().getUsername());
        userMapper.updateUser(userDb);

        // 更新角色
        // 1.删除原有角色
        // 2.插入新角色
        // 删除原有角色
        userMapper.deleteUserRoles(userDb.getId());
        // 插入新角色
        insertUseRole(user, userDb);
    }

    private void insertUseRole(User user, User userDb) {
        List<Role> roles = user.getRoleList();
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        userMapper.insertUserRoles(roleIds, userDb.getId());
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUserRoles(id);
        userMapper.updateUserStatus(id, UserStatusEnum.DELETED.toString());
    }

    @Override
    public void changePassword(String username, String rawpassword, String password) {
        List<User> userList = userMapper.findByUsernameAndStatus(username, UserStatusEnum.NORMAL.toString());

        if (CollectionUtils.isEmpty(userList)) {
            log.error("用户不存在");
            throw new SystemRuntimeException(ErrorCode.BSMUM003,username);
        }
        User user = userList.get(0);
        if (!new BCryptPasswordEncoder().matches(rawpassword, user.getPassword())) {
            log.error("原密码输入错误");
            throw new SystemRuntimeException(ErrorCode.BSMUM004);
        }

        user.setPassword(new BCryptPasswordEncoder().encode(password));
        Date nowDate = new Date();
        userMapper.updateUserPassword(user.getPassword(), user.getId(), nowDate,this.getUserContext().getUsername());
    }

    @Override
    public void resetPassword(Long id, String password) {
        if (id == null || StringUtils.isEmpty(password)) {
            log.error("入参不可为空");
            throw new SystemRuntimeException(ErrorCode.BSMUM005);
        }
        User user = userMapper.findOne(id);
        if (user == null) {
            log.error("用户不存在");
            throw new SystemRuntimeException(ErrorCode.BSMUM003);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        Date nowDate = new Date();
        userMapper.updateUserPassword(user.getPassword(), user.getId(), nowDate,this.getUserContext().getUsername());
    }

    @Override
    public boolean isUserLocked(User user) {
        if (user == null) {
            return false;
        }
        if (user.getStatus().equals(UserStatusEnum.LOCKED.name())) {
            Date lastLockedTime = user.getLastLockedTime();
            Date now = new Date();
            int millisecond = 1000;
            if ((now.getTime() - lastLockedTime.getTime()) >= (lockInterval * millisecond)) {
                unLock(user);
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public void loginError(User user) {

        if (user == null) {
            return;
        }
        //FIXME 暂不执行锁机制，交由um那边处理
        if(user!=null){
            return ;
        }

        if (user.getStatus().equals(UserStatusEnum.LOCKED.name())) {
            return;
        }

        int loginFailTimes = (user.getLoginFailTimes() == null ? 0 : user.getLoginFailTimes());

        if (loginFailTimes >= allowFailedTimes) {
            return;
        }

        user.setLoginFailTimes(++loginFailTimes);

        if (user.getLoginFailTimes() == allowFailedTimes) {
            user.setStatus(UserStatusEnum.LOCKED.name());
            user.setLastLockedTime(new Date());
        }
        userMapper.updateUser(user);
    }

    @Override
    public void unLock(Long userId) {
        User user = userMapper.findOne(userId);
        unLock(user);
    }

    @Override
    public void resetLoginFailTimes(Long userId) {
        userMapper.updateUserLoginFailTimes(0, new Date(), userId);
    }

    @Override
    public List<String> getUserPerm(Long userId) {
        return userMapper.findPermByUserId(userId);
    }

    @Override
    public UserContext getUserContext() {
        return (UserContext)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private void unLock(User user) {

        if (user == null) {
            throw new SystemRuntimeException(ErrorCode.BSMUM003);
        }

        if (!user.getStatus().equals(UserStatusEnum.LOCKED.name())) {
            return;
        }

        user.setStatus(UserStatusEnum.NORMAL.name());
        user.setLoginFailTimes(0);
        userMapper.updateUser(user);
    }
}
