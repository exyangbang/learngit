package com.scenetec.upf.operation.model.domain.account;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@ApiModel(description = "账户管理")
@Data
public class AccountDO {

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
    @JsonIgnore
	private Date gmtModified;

    /**
     * 账号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "账号")
	private String account;

    /**
     * 归属对象类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "归属对象类型")
	private String objType;

    /**
     * 归属对象编号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "归属对象编号")
	private String objCode;

    /**
     * 归属对象名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "归属对象名称")
	private String objName;

    /**
     * 账户余额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "账户余额")
	private Long balance;

    /**
     * 冻结金额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "冻结金额")
	private Long frozenAmount;

    /**
     * 可用金额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "可用金额")
	private Long availAmount;

    /**
     * 状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "状态")
	private String status;
    /**
     * 客户名称
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "客户名称")
    private String name;
    /**
     * 状态
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "手续费模板id")
    private Long feeTemplateId;
    /**
     * 资金账户
     */
    @ApiModelProperty(value = "资金账户")
    private String fundAccount;
    /**
     * 资金账户
     */
    @ApiModelProperty(value = "证件号")
    private String accountNo;
    /**
     * 营业执照号
     */
    @ApiModelProperty(value = "营业执照号")
    private String busLicCode;
    /**
     * 个人/法人证件号
     */
    @ApiModelProperty(value = "个人/法人证件号")
    private String idCode;
    /**
     * 个人/法人证件号
     */
    @ApiModelProperty(value = "手续费模板id 解除")
    private Long feeTemplateIdRelieve;

    /**
     * 操作类型 01 入金 02 冻结 03 解冻 04 出金
     */
    @ApiModelProperty(value = "操作类型 01 入金 02 冻结 03 解冻 04 出金")
    private String operateType;

    @ApiModelProperty(value = "开始时间")
    private String  transBeginDate;
    @ApiModelProperty(value = "结束时间")
    private String transEndDate;

    @ApiModelProperty(value = "代付客户号")
    private String  code;
    @ApiModelProperty(value = "代付客户名称")
    private String indName;
    @ApiModelProperty(value = "资金账号")
    private String  bankAccountNo;
    @ApiModelProperty(value = "资金账号名称")
    private String bankAccountName;
    @ApiModelProperty(value = "平台id")
    private Long industryId;
    @ApiModelProperty(value = "审批状态")
    private String operationType;

    @ApiModelProperty(value = "用户类型|0-个人 1-商户")
    private String userType;
    @ApiModelProperty(value = "银行客户号")
    private String bankClientNo;


    @ApiModelProperty(value = "银行客户号关联标识0开户未上报 1开户已上报 2更新未上报 3更新已上报 4销户未上报")
    private String bankClientStatus;
    @ApiModelProperty(value = "银行客户号开户渠道标识 0簿记自有渠道 1簿记其他渠道")
    private String bankClientChnFlag;

    @ApiModelProperty(value = "商户基本信息审核状态0=待审核 1=已认证 2=审核驳回 9=待认证")
    private String merAuthStatus;

    @ApiModelProperty(value = "证件有效期")
    private String idValidity;

    @ApiModelProperty(value = "商户状态")
    private String merStatus;
}