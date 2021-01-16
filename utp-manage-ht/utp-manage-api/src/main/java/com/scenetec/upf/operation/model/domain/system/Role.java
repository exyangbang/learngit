package com.scenetec.upf.operation.model.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@ApiModel(description = "角色")
@Data
public class Role {

    private Long id;
    @ApiModelProperty(value = "角色名称")
    private String rolename;

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

    private String status;

    @ApiModelProperty(value = "权限列表")
    private List<Permission> permissionList;
}
