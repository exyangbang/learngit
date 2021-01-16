package com.scenetec.upf.operation.repository.system;

import com.scenetec.upf.operation.model.domain.system.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author luoxianjun
 */
@Repository
@Mapper
public interface RoleMapper {
    /**
     * 根据主键查询角色
     * @param id 角色主键
     * @return 角色
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "permissionList", javaType=List.class, column ="id", many = @Many(select = "com.scenetec.upf.operation.repository.system.PermissionMapper.findByRoleId"))
    })
    @Select("select id, rolename from t_role where id=#{id}")
    Role findOne(Long id);

    /**
     * 根据角色名称查询角色列表
     * @param rolename 角色名称
     * @return 角色列表
     */
    @Select("select id, rolename,status from t_role where rolename=#{rolename} and status=#{status}")
    List<Role> findByRolename(@Param("rolename") String rolename, @Param("status") String status);

    /**
     * 根据角色名称和id不为此查询
     * @param rolename 角色名称
     * @param id 编码
     * @return 角色列表
     */
    @Select("select * from t_role where rolename=#{rolename} and id<>#{id} and status=#{status}")
    List<Role> findByRolenameIdNot(@Param("rolename") String rolename, @Param("id") Long id, @Param("status") String status);

    /**
     * 根据角色名称模糊查询
     * @param rolename 角色名称
     * @return 根据角色名称模糊匹配的结果
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "status",column = "status"),
            @Result(property = "permissionList", javaType=List.class, column ="id", many = @Many(select = "com.scenetec.upf.operation.repository.system.PermissionMapper.findByRoleId"))
    })
    @Select({"<script>"+
          "select id,rolename,status from t_role where 1=1 and status = #{status} <if test='rolename'> and rolename like CONCAT('%', #{rolename} ,'%')</if> "
        + "</script>"})
    List<Role> findAll(@Param("rolename") String rolename, @Param("status") String status);

    /**
     * 查询用户的角色
     * @param userId 用户编码
     * @return 角色列表
     */
    @Select("select * from t_role r where r.id in (select role_id from t_user_role as ur where ur.user_id=#{userId})")
    List<Role> findByUserId(@Param("userId") Long userId);

    /**
     * 查询该角色是正在被使用
     * @param roleId 角色编码
     * @return 角色被关联数
     */
    @Select("select count(*) from t_user_role where role_id=#{roleId}")
    int countUserRoleByRoleId(@Param("roleId") Long roleId);

    /**
     * 插入角色
     * @param role 角色实体
     * @return 插入实体
     */
    @Insert("insert into t_role (id, rolename,status,gmt_create,user_create) values (#{id}, #{rolename},#{status},#{gmtCreate},#{userCreate}) ")
    @Options(useGeneratedKeys = true)
    int insert(Role role);

    /**
     * 插入角色和权限的关联信息
     * @param permIds 权限
     * @param roleId 角色编码
     */
    @Insert("<script>"+
            "insert into t_role_permission (role_id, permission_id) values "
            + "<foreach collection =\"permIds\" item=\"rolePerm\" index= \"index\" separator =\",\"> "
            + "(#{roleId}, #{rolePerm}) "
            + "</foreach > "
            + "</script>")
    void insertRolePermission(@Param("permIds") List<Long> permIds, @Param("roleId") Long roleId);

    /**
     * 删除角色和权限的关联关系
     * @param roleId 角色编码
     */
    @Delete("delete from t_role_permission where role_id=#{roleId}")
    void deleteRolePermission(@Param("roleId") Long roleId);

    /**
     * 更新角色
     * @param id 角色编码
     * @param rolename 角色名称
     * @return 成功更新数量
     */
    @Update("update t_role set rolename=#{rolename},gmt_modified=#{gmtModified},user_modified=#{userModified} where id=#{id}")
    int update(@Param("id") Long id, @Param("rolename") String rolename, @Param("gmtModified") Date gmtModified, @Param("userModified") String userModified);

    /**
     * 根据编码删除角色
     * @param id 角色编码
     * @return 成功删除数量
     */
    @Delete("delete from t_role where id=#{id}")
    int delete(@Param("id") Long id);

    /**
     * 更新角色状态
     * @param id
     * @param status
     * @return
     */
    @Update("update t_role set status = #{status} where id = #{id}")
    int updateRoleStatus(@Param("id") Long id, @Param("status") String status);
}
