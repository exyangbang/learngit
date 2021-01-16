package com.scenetec.upf.operation.model.domain.freezingfundsopeapproval;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/10/11
 */
@ApiModel(description = "资金冻结解冻审批记录")
@Data
public class FreezingFundsOpeApprovalDO {

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
     * 虚拟账户账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "虚拟账户账号")
	private String account;
	
    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户）")
	private String objType;
	
    /**
     * 账户名称
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "账户名称")
	private String objName;
	
    /**
     * 客户号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户号")
	private String code;
	
    /**
     * 客户名称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户名称")
	private String indName;
	
    /**
     * 操作类型：0-冻结 1-解冻
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "操作类型：0-冻结 1-解冻")
	private String operationType;
	
    /**
     * 冻结金额（单位分）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "冻结金额（单位分）")
	private Long frozenAmount;
	
    /**
     * 证件号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "证件号")
	private String busLicCode;
	
    /**
     * 备注
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "备注")
	private String auditRemark;
	
    /**
     * 服务端交易流水号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "服务端交易流水号")
	private String serverTransId;
	
    /**
     * 客户端交易流水号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户端交易流水号")
	private String clinetTransId;
	
    /**
     * 发起人：0-后管 1-联机
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "发起人：0-后管 1-联机")
	private String addUsr;
	
    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatus;


    @ApiModelProperty(value = "解冻的id")
    private Long freezeId;

    @ApiModelProperty(value = "冻结状态（0-待审核 1-审核通过 2-审核驳回）")
    private String unfreezeStatus;
}