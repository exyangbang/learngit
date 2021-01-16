package com.scenetec.upf.operation.web.system;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.User;
import com.scenetec.upf.operation.model.domain.system.status.UserStatusEnum;
import com.scenetec.upf.operation.model.vo.system.CreateUserVo;
import com.scenetec.upf.operation.model.vo.system.UpdateUserVo;
import com.scenetec.upf.operation.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author luoxianjun
 * @date 2018/3/18
 */
@RestController
@Api(value = "用户管理接口", tags = {"用户管理"})
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户列表查询接口",notes = "根据登录账号(模糊查找)、用户名(模糊查找)、状态查找用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "页数",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(name = "username",value = "登录账号(模糊查找)",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "用户名(模糊查找)",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "status",value = "状态->NORMAL:正常,DELETED:被删,LOCKED:被被锁",dataType = "String",paramType = "query",allowableValues = "NORMAL, DELETED, LOCKED")
    })
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public PageInfo<User> findAll(int pageNo, int pageSize, String username, String name, String status) {
        log.info("查询用户信息开始");
        if (StringUtils.isEmpty(status)) {
            status = UserStatusEnum.NORMAL.toString();
        }
        return userService.getUsersDoPage(username, name, pageNo, pageSize, status);
    }

    @ApiOperation(value = "获取用户信息接口",notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "long",paramType = "path",required = true)
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User u = userService.getUser(id);
        u.setPassword(null);
        u.setCertNo(null);
        return u;
    }

    @ApiOperation(value = "新增用户信息接口",notes = "新增用户信息")
    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void createUser(@Validated @RequestBody CreateUserVo createUserVo) {
        User user = new User();
        BeanCopier copier = BeanCopier.create(CreateUserVo.class,User.class,false);
        copier.copy(createUserVo,user,null);
        userService.saveUser(user);
    }

    @ApiOperation(value = "修改用户信息接口",notes = "修改用户信息")
    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public void modifyUser(@Validated @RequestBody UpdateUserVo updateUserVo) {
        User user = new User();
        BeanCopier copier = BeanCopier.create(UpdateUserVo.class,User.class,false);
        copier.copy(updateUserVo,user,null);
        userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户信息接口",notes = "根据用户id删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "long",paramType = "path",required = true)
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        log.info("删除用户开始！！！");
        userService.deleteUser(id);
    }

    @ApiOperation(value = "修改用户密码接口",notes = "根据登录账号修改用户密码")
    @ApiImplicitParam(name = "param",value = "json格式 例如:{\"username\":登录账号,\"rawpassword\":原密码,\"password\":新密码}",dataType = "Map",paramType = "body",required = true)
    @RequestMapping(value = "/api/user/password", method = RequestMethod.PUT)
    public void changePassword(@RequestBody Map<String, String> param) {
        userService.changePassword(param.get("username"), param.get("rawpassword"), param.get("password"));
    }

    @ApiOperation(value = "重置用户密码接口",notes = "根据用户id重置用户密码")
    @ApiImplicitParam(name = "param",value = "json格式 例如:{\"id\":用户id,\"password\":新密码}",dataType = "Map",paramType = "body",required = true)
    @RequestMapping(value = "/api/user/reset/password", method = RequestMethod.PUT)
    public void resetPassword(@RequestBody Map<String, String> param) {
        Long id = Long.parseLong(param.get("id"));
        String password = param.get("password");
        userService.resetPassword(id, password);
    }

    @ApiOperation(value = "解锁用户接口",notes = "根据用户id解锁用户")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "long",paramType = "path",required = true)
    @RequestMapping(value = "/api/user/unlock/{id}", method = RequestMethod.PUT)
    public void unlock(@PathVariable Long id) {
        userService.unLock(id);
    }
}
