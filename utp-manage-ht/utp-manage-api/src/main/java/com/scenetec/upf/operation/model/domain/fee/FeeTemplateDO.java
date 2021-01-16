package com.scenetec.upf.operation.model.domain.fee;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@ApiModel(description = "手续费模板管理")
@Data
public class FeeTemplateDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    

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
     * 模板名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "模板名称")
	private String name;

    /**
     * 结算类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "结算类型")
	private String settleType;

    /**
     * 收费模式
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "收费模式")
	private String chargeMode;

    /**
     * 计算方式
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "计算方式")
	private String calculateMode;

    /**
     * 手续费
     * mysqlType: double
     */
    @ApiModelProperty(value = "手续费")
	private Long fee;

    /**
     * 最小手续费
     * mysqlType: double
     */
    @ApiModelProperty(value = "最小手续费")
	private Long minFee;

    /**
     * 最大手续费
     * mysqlType: double
     */
    @ApiModelProperty(value = "最大手续费")
	private Long maxFee;
    /**
     * 区间内容
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "区间内容")
    private String content;
    /**
     * 备注信息
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "备注信息")
	private String remark;

    @Override
	public String toString() {
		return "FeeTemplateDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", name = [" + name +"]"
              + ", settleType = [" + settleType +"]"
              + ", chargeMode = [" + chargeMode +"]"
              + ", calculateMode = [" + calculateMode +"]"
              + ", fee = [" + fee +"]"
              + ", minFee = [" + minFee +"]"
              + ", maxFee = [" + maxFee +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}