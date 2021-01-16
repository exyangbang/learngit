package com.scenetec.upf.operation.model.domain.settle;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/19
 */
@ApiModel(description = "商户对账记录")
@Data
public class MerReconcileRecordDO {

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
	private Date gmtModified;

    /**
     * 对账时间
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "对账时间")
	private String reconcileDate;

    /**
     * 商户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;


    @ApiModelProperty(value = "渠道标识")
    private String channelKey;

    /**
     * 机构名称
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 对账状态 0-未对账 1-已对账
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "对账状态 0-未对账 1-已对账")
	private String reconcileStatus;

    @Override
	public String toString() {
		return "MerReconcileRecordDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", reconcileDate = [" + reconcileDate +"]"
              + ", merNo = [" + merNo +"]"
              + ", reconcileStatus = [" + reconcileStatus +"]"
              ;
	}
	
}