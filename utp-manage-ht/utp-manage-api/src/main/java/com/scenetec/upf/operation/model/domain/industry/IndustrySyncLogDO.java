package com.scenetec.upf.operation.model.domain.industry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2019/01/22
 */
@ApiModel(description = "账户同步记录")
@Data
public class IndustrySyncLogDO {

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
	
    /**
     * 代付客户号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "代付客户号")
	private String industryCode;

	@ApiModelProperty(value = "代付客户号")
	private String fundAccountNo;
    /**
     * 上次同步日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "上次同步日期")
	private String lastDate;
	
    /**
     * 备注
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "备注")
	private String remark;

    /**
     * 实体账户使用，暂时由后台直接写死000000
     */
    @ApiModelProperty(value = "上次同步时间")
    private String lastTime;
    @Override
	public String toString() {
		return "IndustrySyncLogDO:"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", industryCode = [" + industryCode +"]"
              + ", lastDate = [" + lastDate +"]"
              + ", remark = [" + remark +"]"
              + ", lastTime = [" + lastTime +"]"
              ;
	}
	
}