package com.scenetec.upf.operation.model.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@ApiModel(description = "用户")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 初始登陆密码
     */
    private String password;

    /**
     * 初始登陆密码
     */
    private String umLogin;

    /**
     * 性别 UNKNOWN：未知 MALE：男 FEMALE：女
     */
    private String sex;

    /**
     * 联系方式
     */
    private String mobileNo;

    /**
     * 证件号码
     */
    private String certNo;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 职务
     */
    private String post;

    /**
     * 状态  NORMAL：正常 DELETED：被删 LOCKED：被锁
     */
    private String status;

    /**
     * 所属部门编号
     */
    private Long orgId;

    /**
     * 部门名称
     */
    private String orgName;

    /**
     * 一个用户具有多个角色
     */
    private List<Role> roleList;

    /**
     * 登录失败次数
     */
    private Integer loginFailTimes;

    /**
     * 上次被锁时间
     */
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
    private Date gmtModified;
}
