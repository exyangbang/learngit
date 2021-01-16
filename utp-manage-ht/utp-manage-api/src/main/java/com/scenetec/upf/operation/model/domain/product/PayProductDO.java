package com.scenetec.upf.operation.model.domain.product;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@ApiModel(description = "支付产品表")
@Data
public class PayProductDO {

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
	private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
	private Date gmtModified;

    /**
     * 产品编码
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "产品编码")
	private String code;

    /**
     * 产品名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "产品名称")
	private String name;

    /**
     * 备注信息
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "备注信息")
	private String remark;

    /**
     * 状态
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "状态")
	private String status;

    @Override
	public String toString() {
		return "PayProductDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", code = [" + code +"]"
              + ", name = [" + name +"]"
              + ", remark = [" + remark +"]"
              + ", status = [" + status +"]"
              ;
	}
	
}