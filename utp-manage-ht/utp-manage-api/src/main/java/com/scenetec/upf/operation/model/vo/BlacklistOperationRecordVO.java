package com.scenetec.upf.operation.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/10/10
 */
@ApiModel(description = "黑名单审批操作记录")
@Data
public class BlacklistOperationRecordVO {
	private Long id;
    /**
     * 姓名
     * mysqlType: varchar(20)
     */
//	@NotNull(message = "证姓名不能为空")
//	@Size(min=1,max = 20,message = "姓名最大长度不能超过20")
	private String name;
	
    /**
     * 证件号
     * mysqlType: varchar(200)
     */
//	@NotNull(message = "证件号不能为空")
//	@Size(min=1,max = 200,message = "证件号最大长度不能超过200")
	private String idCode;
	
    /**
     * 备注
     * mysqlType: varchar(1000)
     */
//	@Size(min=1,max = 1000,message = "类型最大长度不能超过1000")
	private String remark;
	
    /**
     * 0-删除 1-修改 2-增加
     * mysqlType: varchar(10)
     */
	@NotNull(message = "类型不能为空")
	@Size(min=1,max = 10,message = "类型最大长度不能超过10")
	private String operationType;

	/**
	 * 状态（0-待审核 1-审核通过 2-审核驳回）
	 */
	private String auditStatus;

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