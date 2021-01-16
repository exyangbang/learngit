package com.scenetec.upf.operation.repository.system;


import com.scenetec.upf.operation.model.domain.system.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by luoxianjun on 2018/3/18.
 * @author luoxianjun
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 根据id用户信息
     * @param id:用户编号
     * @return User对象
     * */

    @Select("select u.id,u.username,u.name,u.password,u.sex,u.mobile_no,u.cert_no,u.email,u.login_fail_times, u.last_locked_time," +
            "u.post,u.status,u.um_login from t_user u  where u.id = #{id}")
    @Results(id="userMapper", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "umLogin", column = "um_login"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "mobileNo", column = "mobile_no"),
            @Result(property = "certNo", column = "cert_no"),
            @Result(property = "email", column = "email"),
            @Result(property = "post", column = "post"),
            @Result(property = "orgId", column = "org_id"),
            @Result(property = "orgName", column = "org_name"),
            @Result(property = "loginFailTimes", column = "login_fail_times"),
            @Result(property = "lastLockedTime", column = "last_locked_time"),
            @Result(property = "gmtModified", column = "gmt_modified"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleList", javaType = List.class, column = "id", many = @Many(select = "com.scenetec.upf.operation.repository.system.RoleMapper.findByUserId"))
    }) User findOne(@Param("id") Long id);
/**
 * 根据用户名模糊查询用户
 * @param name:姓名
 * @param username ：用户名
 * @param status 状态
 * @return List<User> 用户集合
 *
 * */
    @ResultMap("userMapper")
    @Select({"<script>select * from t_user where 1=1 <if test='status'> and status=#{status} </if> <if test='username'> and username like CONCAT('%', #{username} ,'%')</if> " +
            "<if test='name'> and name like CONCAT('%',#{name},'%')</if> order by gmt_modified desc</script>"})
    List<User> findByUsernameLikeOrNameLike(@Param("username") String username, @Param("name") String name,
                                            @Param("status") String status);

    /**
     * 根据用户名和状态查询用户
     * @param status 状态
     * @param username 用户名
     * @return List<User> 用户列表
     * */
    @ResultMap("userMapper")
    @Select("select * from t_user where username=#{username} and status=#{status} order by gmt_modified desc")
    List<User> findByUsernameAndStatus(@Param("username") String username, @Param("status") String status);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @param status 用户状态
     * @return List<User> 用户集合
     * */
    @ResultMap("userMapper")
    @Select("select * from t_user where username=#{username} and (status='NORMAL' or status='LOCKED')")
    List<User> findByUsername(@Param("username") String username);
    /**
     * 保存用户信息
     * @param user 用户对象
     * @return 保存结果
     * */
    @Insert("insert into t_user (id, cert_no, username, name, email, mobile_no, password,um_login, post, sex, org_id, status, gmt_create, user_create,gmt_modified,user_modified)" +
            " values (#{id}, #{certNo}, #{username}, #{name}, #{email}, #{mobileNo}, #{password},#{umLogin}, #{post}, #{sex}, #{orgId},#{status}, #{gmtCreate}, #{userCreate}, #{gmtModified}, #{userModified})")
    @Options(useGeneratedKeys = true)
    int insertUser(User user);
    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 更新结果
     * */
    @Update("update t_user set cert_no=#{certNo}, name=#{name},email=#{email}, mobile_no=#{mobileNo}, post=#{post}, sex=#{sex}, " +
            "org_id=#{orgId},login_fail_times=#{loginFailTimes}, gmt_modified=#{gmtModified},user_modified=#{userModified},status=#{status}, last_locked_time=#{lastLockedTime} where id=#{id}")
    int updateUser(User user);

    /**
     * 更新用户密码
     * @param id 用户编号
     * @param password 密码
     * @param gmtModified 更新时间
     * @return 更新密码结果
     * */
    @Update("update t_user set password=#{password},gmt_modified=#{gmtModified},user_modified=#{userModified} where id=#{id}")
    int updateUserPassword(@Param("password") String password, @Param("id") Long id,
                           @Param("gmtModified") Date gmtModified, @Param("userModified") String userModified);
    /**
     * 更新用户登录失败的次数
     * @param id 用户编号
     * @param time 时间
     * @param times 次数
     * @return 更新结果
     * */
    @Update("update t_user set login_fail_times=#{times},last_locked_time=#{time} where id=#{id}")
    int updateUserLoginFailTimes(@Param("times") int times, @Param("time") Date time, @Param("id") long id);
    /**
     * 删除用户角色列表
     * @param userId 用户编号
     * */
    @Delete("delete from t_user_role where user_id=#{userId}")
    void deleteUserRoles(Long userId);
   /**
    * 保存用户角色列表
    * @param userId 用户编号
    * @param roles 角色编号列表
    * @return  保存用户角色结果
    * */
    @Insert("<script>" +
            "insert into t_user_role (user_id, role_id) values "
            + "<foreach collection =\"roles\" item=\"roleId\" index= \"index\" separator =\",\"> "
            + "(#{userId}, #{roleId}) "
            + "</foreach > "
            + "</script>")
    int insertUserRoles(@Param("roles") List<Long> roles, @Param("userId") Long userId);

    /**
     * 更新用户状态
     * @param id 用户编号
     * @param status 用户状态
     * @return 更新状态结果
     * */
    @Update("update t_user set status=#{status} where id=#{id}")
    int updateUserStatus(@Param("id") Long id, @Param("status") String status);

    /**
     * 查询用户权限
     * @param userId 用户编号
     * @return List<String> 权限列表
     * * */
    @Select("select distinct rp.permission_id from t_user as u inner join t_user_role as ur on (u.id = ur.user_id)\n"
        + "  inner join t_role_permission as rp on (ur.role_id = rp.role_id)\n"
        + "  where u.id=#{userId} or rp.permission_id in(select id from t_permission where path like '%/read')")
    List<String> findPermByUserId(Long userId);
    /**
     * 查询用户是否存在
     * @param username 用户名
     * @param status 状态
     * @return java.util.List<com.scenetec.upf.operation.model.domain.system.User>
     */
    @ResultMap("userMapper")
    @Select("select * from t_user where username=#{username} and status!=#{status} order by gmt_modified desc")
    List<User> findByUsernameAndStatusExit(@Param("username") String username, @Param("status") String status);
}
