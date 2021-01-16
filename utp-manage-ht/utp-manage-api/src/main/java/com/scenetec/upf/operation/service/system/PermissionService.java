package com.scenetec.upf.operation.service.system;

import com.scenetec.upf.operation.model.domain.system.Permission;

import java.util.List;

/**
 * @author luoxianjun
 */
public interface PermissionService {


    /**
     * 查询所有权限列表，以层级关系返回
     * @return 权限集合
     * */
    List<Permission> getAll();

    /**
     * 查询所有权限列表，返回列表
     * @return 权限集合
     * */
    List<Permission> getPermissionList();
    /**
     * 查询当前用户的所有权限路径
     * @return 权限路径列表
     * */
    List<String> queryPermissionByUserId();

}
