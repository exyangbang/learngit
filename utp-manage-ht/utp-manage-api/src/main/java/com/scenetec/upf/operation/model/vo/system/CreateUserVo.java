package com.scenetec.upf.operation.model.vo.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scenetec.upf.operation.model.domain.system.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author sunquanhu@scenetec.com
 * @date 2018/7/26
 */
@ApiModel(value = "用户")
@Data
public class CreateUserVo {
    /**
     * 登陆账号
     */
    @ApiModelProperty(value = "登陆账号")
    @NotNull(message = "登陆账号不能为空")
    @Size(min=1, max = 20,message = "登陆账号长度不能超过20位")
    private String username;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @NotNull(message = "用户姓名不能为空")
    @Size(min=1,max = 20,message = "用户姓名长度不能超过20位")
    private String name;

    /**
     * 初始登陆密码
     */
    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "是否um登录")
    @NotNull(message = "是否um登录不能为空")
    private String umLogin;

    /**
     * 性别 UNKNOWN：未知 MALE：男 FEMALE：女
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    @NotNull(message = "联系电话不能为空")
    @Size(min=1,max=20,message = "联系电话长度不能超过20位")
    private String mobileNo;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String certNo;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
    @NotNull(message = "邮箱不能为空")
    @Size(min=1,max = 100,message = "邮箱最大长度不能超过100位")
    private String email;

    /**
     * 职务
     */
    @ApiModelProperty(value = "职务")
    private String post;

    /**
     * 状态  NORMAL：正常 DELETED：被删 LOCKED：被锁
     */
    @ApiModelProperty(value = "状态")
    @JsonIgnore
    private String status;

    /**
     * 所属部门编号
     */
    @ApiModelProperty(value = "所属部门编号")
    private Long orgId;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String orgName;

    /**
     * 一个用户具有多个角色
     */
    @ApiModelProperty(value = "角色")
    @NotNull(message = "角色列表不能为空")
    private List<Role> roleList;

    /**
     * 登录失败次数
     */
    @ApiModelProperty(value = "登录失败次数")
    @JsonIgnore
    private Integer loginFailTimes;

    /**
     * 上次被锁时间
     */
    @ApiModelProperty(value = "上次被锁时间")
    @JsonIgnore
    private Date lastLockedTime;

    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
    private String userCreate;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
    private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
    private Date gmtModified;
}
