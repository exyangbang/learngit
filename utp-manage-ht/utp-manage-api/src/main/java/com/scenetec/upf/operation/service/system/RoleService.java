package com.scenetec.upf.operation.service.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.Role;

import java.util.List;

/**
 * @author luoxianjun
 */
public interface RoleService {
    /**
     * 获取角色分页信息
     * @param pageNo 页号
     * @param pageSize 每页大小
     * @param rolename 角色名称
     * @return 角色分页列表
     */
    PageInfo<Role> getRoles(int pageNo, int pageSize, String rolename) ;

    /**
     * 获取角色列表
     * @return 角色列表
     */
    List<Role> getRoles() ;

    /**
     * 根据编码获取角色信息
     * @param id 角色编码
     * @return 角色信息
     */
    Role getRole(Long id);

    /**
     * 保存角色
     * @param role 角色信息
     */
    void saveRole(Role role);

    /**
     * 更新角色
     * @param role 角色信息
     */
    void updateRole(Role role);

    /**
     * 删除角色
     * @param id 角色编码
     */
    void deleteRole(Long id);

}
