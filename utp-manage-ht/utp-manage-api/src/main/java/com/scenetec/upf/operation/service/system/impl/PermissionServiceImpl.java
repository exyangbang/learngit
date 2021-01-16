package com.scenetec.upf.operation.service.system.impl;

import com.scenetec.upf.operation.model.domain.system.Permission;
import com.scenetec.upf.operation.model.domain.system.Role;
import com.scenetec.upf.operation.repository.system.PermissionMapper;
import com.scenetec.upf.operation.repository.system.RoleMapper;
import com.scenetec.upf.operation.service.system.PermissionService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.PermissionHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author luoxianjun on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserService userService;
    @Override
    public List<Permission> getAll() {
        //查询所有权限列表
        List<Permission> permissionList = permissionMapper.findAll();
        //处理数据
        return PermissionHelper.listToTree(permissionList);
    }

    @Override public List<Permission> getPermissionList() {
        return permissionMapper.findAll();
    }

    @Override public List<String> queryPermissionByUserId() {
       //根据用户id查询当前用户的所有角色
        String userIdString = userService.getUserContext().getId();
        Long userId = Long.parseLong(userIdString);
        List<Role> userRoles = roleMapper.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRoles)){
            return null;
        }
        //根据角色id查询当前角色的所有权限列表
        List<String > list = new ArrayList<>();
        userRoles.forEach(role ->
            roleMapper.findOne(role.getId()).getPermissionList().forEach(permission ->
             list.add(permission.getPath())
            )
        );
        return list.stream().distinct().collect(Collectors.toList());
    }

}
