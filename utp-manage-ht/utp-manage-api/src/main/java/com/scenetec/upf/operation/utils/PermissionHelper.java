package com.scenetec.upf.operation.utils;

import com.scenetec.upf.operation.model.domain.system.Permission;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限数据结构帮助类
 * @author sunquanhu 2018年7月12日21:10:26
 * */
public class PermissionHelper {

    /**
     * 将list转换成树形结构
     * */
    public static List<Permission> listToTree(List<Permission> permissions){
        List<Permission> list = new ArrayList<Permission>();
        if(CollectionUtils.isEmpty(permissions)){
            return null;
        }
        for (Permission permission : permissions){
            if (StringUtils.isEmpty(permission.getParentId())){
                list.add(findChild(permission,permissions));
            }
        }
        return list;
    }
    /**递归查找子节点*/
    private  static Permission findChild(Permission permission,List<Permission> permissions){
        for (Permission perm : permissions){
            if(permission.getId().equals(perm.getParentId())){
                if(permission.getChildren() == null){
                    permission.setChildren(new ArrayList<Permission>());
                }
                permission.getChildren().add(findChild(perm,permissions));
            }
        }
        return permission;
    }
}
