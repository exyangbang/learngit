package com.scenetec.upf.operation.web.system;

import com.scenetec.upf.operation.model.domain.system.Permission;
import com.scenetec.upf.operation.service.system.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoxianjun on 2018/3/19.
 * @author
 * update by sunquanhu on 2018年7月11日15:46:04
 */
@Api(value="权限管理接口",tags={"权限管理"})
@RestController
public class PermissionController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private PermissionService permissionService;
    @ApiOperation(value = "查询所有权限")
    @RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
    public List<Permission> queryAll() {
        if (log.isInfoEnabled()){
            log.info("---调用查询权限树服务开始---");
        }
        List<Permission> permissionList = permissionService.getAll();
        if(log.isInfoEnabled()){
            log.info("---调用查询权限树服务结束---");
        }
        return permissionList;

   }

   @ApiOperation(value = "查询所有权限路径")
   @RequestMapping(value = "/api/permissionPaths",method = RequestMethod.GET)
   public List<String> queryAllPermissionPath(){
        if (log.isInfoEnabled()){
            log.info("---调用查询所有权限列表服务开始---");
        }
        List<Permission> queryAllPermissions = permissionService.getPermissionList();
        List<String> permissionPaths = new ArrayList<>();
        if(!CollectionUtils.isEmpty(queryAllPermissions)){
            queryAllPermissions.forEach(permission -> permissionPaths.add(permission.getPath()));
        }
       if (log.isInfoEnabled()){
           log.info("---调用查询所有权限列表服务结束---");
       }
        return permissionPaths;
   }
   @ApiOperation(value = "根据用户id查询用户的权限")
   @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query",dataType = "Long")
   @RequestMapping(value = "/api/userPermission",method = RequestMethod.GET)
   public List<String> queryPermissionByUserId(){
        if(log.isInfoEnabled()){
            log.info("---调用根据用户查询用户权限服务开始---");
        }
       List<String> permissions =  permissionService.queryPermissionByUserId();
       if(log.isInfoEnabled()){
           log.info("---调用根据用户查询用户权限服务结束---");
       }
        return permissions;
   }
}
