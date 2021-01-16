package com.scenetec.upf.operation.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.system.Permission;
import com.scenetec.upf.operation.model.domain.system.Role;
import com.scenetec.upf.operation.model.domain.system.status.RoleStatusEnum;
import com.scenetec.upf.operation.repository.system.PermissionMapper;
import com.scenetec.upf.operation.repository.system.RoleMapper;
import com.scenetec.upf.operation.service.system.RoleService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.PermissionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luoxianjun on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private UserService userService;

    @Override
    public PageInfo<Role> getRoles(int pageNo, int pageSize,String rolename) {

        Page<Role> rolePages = PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> roleMapper.findAll(rolename,RoleStatusEnum.NORMAL.toString()));

        return new PageInfo<>(rolePages);
    }

    @Override
    public Role getRole(Long id) {
      //查询当前角色id的所有信息（包括权限列表）
        Role role = roleMapper.findOne(id);
        if(role==null){
            return null;
        }
        List<Permission> rolePermissionList = role.getPermissionList();
        List<Long> rolePermissions = rolePermissionList.stream().map(Permission::getId).collect(Collectors.toList());
        List<Long> parentPermissionIds = rolePermissionList.stream().filter(permission -> permission.getParentId()!=null).map(Permission::getParentId).collect(Collectors.toList());
        //移除权限中的父节点
        rolePermissions.removeAll(parentPermissionIds);
        List<Permission> permissions = new ArrayList<>();
        //获取所有权限列表
        List<Permission> permissionList = permissionMapper.findAll();
        for (Permission permission : permissionList){
            if(rolePermissions.contains(permission.getId())){
                permission.setChecked(true);
                permissions.add(permission);
            }else{
                permissions.add(permission);
            }
        }
        role.setPermissionList(PermissionHelper.listToTree(permissions));
        return role;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor=Exception.class)
    public void saveRole(Role role) {
        if (role == null) {
            return;
        }
        //正常状态下的角色
        List<Role> roleList = roleMapper.findByRolename(role.getRolename(), RoleStatusEnum.NORMAL.toString());

        if(!CollectionUtils.isEmpty(roleList)){
            log.error("角色名称重复");
            throw new SystemRuntimeException(ErrorCode.BSMRM001,role.getRolename());
        }
        role.setGmtCreate(new Date());
        role.setUserCreate(userService.getUserContext().getUsername());
        role.setId(IdGenerate.getId());
        roleMapper.insert(role);
        insertRolePerm(role);
    }

    private void insertRolePerm(Role role) {
        // 创建角色权限
        if (CollectionUtils.isEmpty(role.getPermissionList())) {
            log.error("权限为空");
            throw new SystemRuntimeException(ErrorCode.BSMRM002);
        }
        List<Long> permIds = role.getPermissionList().stream().map(Permission::getId).collect(Collectors.toList());
        List<Long> parentPermIds = role.getPermissionList().stream().filter(item-> item.getParentId()!=null).map(Permission::getParentId).collect(Collectors.toList());
        permIds.addAll(parentPermIds);
        permIds = permIds.parallelStream().distinct().collect(Collectors.toList());
        roleMapper.insertRolePermission(permIds, role.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor=Exception.class)
    public void updateRole(Role role) {
        if (role == null) {
            return;
        }
        // 判断角色名称是否重复
        List<Role> roleList = roleMapper.findByRolenameIdNot(role.getRolename(), role.getId(),RoleStatusEnum.NORMAL.toString());
        if (!CollectionUtils.isEmpty(roleList)) {
            log.error("角色名称重复");
            throw new SystemRuntimeException(ErrorCode.BSMRM001,role.getRolename());
        }
        if (CollectionUtils.isEmpty(role.getPermissionList())) {
            log.error("角色的权限不能为空");
            throw new SystemRuntimeException(ErrorCode.BSMRM002);
        }
        roleMapper.update(role.getId(), role.getRolename(),new Date(),userService.getUserContext().getUsername());
        roleMapper.deleteRolePermission(role.getId());
        insertRolePerm(role);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor=Exception.class)
    public void deleteRole(Long id) {

        int count = roleMapper.countUserRoleByRoleId(id);
        if (count > 0) {
            log.error("该角色正在使用");
            throw new SystemRuntimeException(ErrorCode.BSMRM003);
        }
        roleMapper.deleteRolePermission(id);
        //更改为逻辑删除
        //roleMapper.delete(id);
        roleMapper.updateRoleStatus(id,RoleStatusEnum.DELETED.toString());
    }

    @Override
    public List<Role> getRoles() {
        return roleMapper.findAll(null,RoleStatusEnum.NORMAL.toString());
    }

}
