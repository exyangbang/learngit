package com.scenetec.upf.operation.web.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.Role;
import com.scenetec.upf.operation.model.domain.system.status.RoleStatusEnum;
import com.scenetec.upf.operation.model.vo.system.CreateRoleVo;
import com.scenetec.upf.operation.model.vo.system.UpdateRoleVo;
import com.scenetec.upf.operation.service.system.RoleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luoxianjun
 */
@Api(value="角色管理接口",tags={"角色管理"})
@RestController
@Slf4j
public class RoleController {

    @Resource
    private RoleService roleService;

    @ApiOperation(value = "查询角色")
    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNo",value = "页数",dataType = "int",paramType = "query",required = true),
        @ApiImplicitParam(name = "pageSize",value = "每页大小",dataType = "int",paramType = "query",required = true),
        @ApiImplicitParam(name = "rolename",value = "角色名称",dataType = "String",paramType = "query")
    })
    public PageInfo<Role> findPage(int pageNo, int pageSize, String rolename) {
        log.info("查询全部角色开始");
       return roleService.getRoles(pageNo, pageSize,rolename);
    }

    @ApiOperation(value = "查询角色列表")
    @RequestMapping(value = "/api/roleall", method = RequestMethod.GET)
    public List<Role> findAll() {
        log.info("查询全部角色开始");
        return roleService.getRoles();
    }
    @ApiOperation(value = "查询角色详情")
    @RequestMapping(value = "/api/role/{id}", method = RequestMethod.GET)
    public Role findOne(@PathVariable Long id) {
        log.info("查询角色开始");
        return roleService.getRole(id);

    }

    @ApiOperation(value = "创建角色")
    @RequestMapping(value = "/api/role", method = RequestMethod.POST)
    public void createRole(@Validated @RequestBody CreateRoleVo createRoleVo) {
        log.info("保存角色开始");
        Role role = new Role();
        BeanCopier copier = BeanCopier.create(CreateRoleVo.class,Role.class,false);
        copier.copy(createRoleVo,role,null);
        role.setStatus(RoleStatusEnum.NORMAL.toString());
        roleService.saveRole(role);
        log.info("保存角色成功");

    }
    @ApiOperation(value = "修改角色")
    @RequestMapping(value = "/api/role", method = RequestMethod.PUT)
    public void updateRole(@Validated @RequestBody UpdateRoleVo updateRoleVo) {
        log.info("修改角色开始！！！");
        Role role = new Role();
        BeanCopier copier = BeanCopier.create(UpdateRoleVo.class,Role.class,false);
        copier.copy(updateRoleVo,role,null);
        roleService.updateRole(role);
        log.info("修改角色结束！！！");

    }
    @ApiOperation(value = "删除角色")
    @RequestMapping(value = "/api/role/{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable Long id) {
        log.info("删除角色开始！！！");
        roleService.deleteRole(id);
        log.info("删除角色结束！！！");
    }

}
