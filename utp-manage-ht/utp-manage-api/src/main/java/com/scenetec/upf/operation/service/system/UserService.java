package com.scenetec.upf.operation.service.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.security.model.UserContext;

import java.util.List;

/**
 * @author vladimir.stankovic
 * <p>
 * Aug 17, 2016
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户对象
     * */
    User getByUsername(String username);

    /**
     * 分页查询用户列表
     * @param username 用户名
     * @param status 状态
     * @param pageNum 当前页数
     * @param pageSize 每页记录数
     * @param name 姓名
     * @return 分页对象
     *
     * */
    PageInfo<User> getUsersDoPage(String username, String name, int pageNum, int pageSize, String status);

    /**
     * 根据id用户信息
     * @param id 用户编号
     * @return 用户对象
     * */
    User getUser(Long id);

    boolean checkUmUser(String username);

    boolean loginUm(String username, String password);
    /**
     * 保存用户信息
     * @param user 用户对象
     * */
    void saveUser(User user);

    /**
     * 更新用户信息
     * @param user 用户对象
     * */
    void updateUser(User user);

    /**
     * 根据用户id删除用户信息
     * @param id 用户编号
     * */
    void deleteUser(Long id);

    /**
     * 修改密码
     * @param username 用户名
     * @param password 密码
     * @param rawpassword 旧密码
     * */
    void changePassword(String username, String rawpassword, String password);

    /**
     * 重置密码
     * @param id 用户编号
     * @param password 密码
     * */
    void resetPassword(Long id, String password);

    /**
     * 登录错误
     * @param user 用户
     * */
    void loginError(User user);

    /**
     * 查询用户是否锁定状态
     * @param user 用户
     * @return 结果
     * */
    boolean isUserLocked(User user);

    /**
     * 解锁用户状态
     * @param userId 用户编号
     * */
    void unLock(Long userId);

    /**
     * 重置登录失败次数
     * @param userId 用户编号
     * */
    void resetLoginFailTimes(Long userId);

    /**
     * 查询用户权限列表
     * @param userId 用户编号
     * @return 功能列表
     * */
    List<String> getUserPerm(Long userId);

    /**
     * 获取当前登陆的用户的信息
     * @return UserContext
     */
    UserContext getUserContext();
}
