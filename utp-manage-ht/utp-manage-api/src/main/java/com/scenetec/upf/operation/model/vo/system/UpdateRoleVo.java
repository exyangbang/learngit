package com.scenetec.upf.operation.model.vo.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scenetec.upf.operation.model.domain.system.Permission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@ApiModel(description = "角色")
@Data
public class UpdateRoleVo {

    @NotNull(message = "角色编号不能为空")
    private Long id;
    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称不能为空")
    @Size(min=1,max = 100,message = "角色名称最大长度不能超过100")
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

    @ApiModelProperty(value = "权限列表")
    private List<Permission> permissionList;
}
