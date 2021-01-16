package com.scenetec.upf.operation.model.domain.blacklist;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/10/10
 */
@ApiModel(description = "黑名单审批操作记录")
@Data
public class BlacklistDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    
	
    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
	private String userCreate;
	
    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
	private Date gmtCreate;
	
    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
	private Date gmtModified;
	
    /**
     * 姓名
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "姓名")
	private String name;
	
    /**
     * 证件号
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "证件号")
	private String idCode;

    private String auditStatus;
	
    /**
     * 备注
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "备注")
	private String remark;

    /**
     * 1:个人2:企业
     * mysqlType:
     */
    @ApiModelProperty(value = "1:个人2:企业")
    private String objType;

    @ApiModelProperty(value = "营业执照号")
    private String busLicCode;

    @ApiModelProperty(value = "企业名称")
    private String entName;
}