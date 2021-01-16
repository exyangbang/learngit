package com.scenetec.upf.operation.repository.system;

import com.scenetec.upf.operation.model.domain.system.PermFunc;
import com.scenetec.upf.operation.model.domain.system.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoxianjun
 */
@Repository
@Mapper
public interface PermissionMapper {
    /**
     * 查询所有权限
     * @return 权限
     */
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "title", column = "title"),
        @Result(property = "desc", column = "desc"),
        @Result(property = "path",column = "path"),
        @Result(property = "parentId",column = "parent_id"),
    })
    @Select("select id, title, `desc`, path, parent_id from t_permission")
    List<Permission> findAll();

    /**
     * 根据角色编码查询权限
     * @param roleId 角色编码
     * @return 角色的权限
     */
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "title", column = "title"),
        @Result(property = "desc", column = "desc"),
        @Result(property = "path",column = "path"),
        @Result(property = "parentId",column = "parent_id"),
    })
    @Select("select id, title, `desc`, path, parent_id from t_permission where id in (select permission_id from t_role_permission where role_id=#{roleId})")
    List<Permission> findByRoleId(@Param("roleId") Long roleId);

    /**
     * 查询权限和功能点的对应
     * @return 权限和功能点的对应
     */
    @Results({
        @Result(property = "permissionId", column = "permission_id"),
        @Result(property = "funcUrl", column = "func_url")
    })
    @Select("select permission_id, func_url from t_permission_func")
    List<PermFunc> findPermFunc();
}
