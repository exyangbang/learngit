package com.scenetec.upf.operation.model.domain.channelincomeflow;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2020/03/16
 */
@ApiModel(description = "渠道入金通知流水表")
@Data
public class ChannelIncomeFlowDO {

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
     * 虚拟账户账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "虚拟账户账号")
	private String accNo;
	
    /**
     * 虚拟账户客户姓名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "虚拟账户客户姓名")
	private String accName;
	
    /**
     * 充值金额,单位:分 无小数点
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "充值金额,单位:分 无小数点")
	private Long amt;
	
    /**
     * 核心主交易流水
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "核心主交易流水")
	private String coreNo;
	
    /**
     * 请求业务流水号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "请求业务流水号")
	private String rid;
	
    /**
     * 来账账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "来账账号")
	private String exAcctNo;
	
    /**
     * 来账户名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "来账户名")
	private String exAcctName;
	
    /**
     * 来款账户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "来款账户名称")
	private String accountName;
	
    /**
     * 来账账号清算行号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "来账账号清算行号")
	private String clearBankno;
	
    /**
     * 来款银行行号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "来款银行行号")
	private String bankCode;
	
    /**
     * 来账账号行名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "来账账号行名")
	private String bankName;
	
    /**
     * 支付系统业务流水号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "支付系统业务流水号")
	private String tranNo;
	
    /**
     * 对账日期,yyyyMMdd
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "对账日期,yyyyMMdd")
	private String tranDate;
	
    /**
     * 入账账户
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "入账账户")
	private String autoPayeeAcctAo;
	
    /**
     * 入账户名
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "入账户名")
	private String autoPayeeAcctName;
	
    /**
     * 手工提入账户
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "手工提入账户")
	private String manualPayeeAcctNo;
	
    /**
     * 手工提入户名
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "手工提入户名")
	private String manualPayeeAcctName;
	
    /**
     * 业务状态,(01-已入账,02-已挂账,03-已退账,04-已手工入账)
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "业务状态,(01-已入账,02-已挂账,03-已退账,04-已手工入账)")
	private String bizFlag;
	
    /**
     * 电子回单生成标识0未生成 1已生成
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "电子回单生成标识0未生成 1已生成")
	private String elcMakeFlag;
	
    /**
     * beizhu
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "beizhu")
	private String remark;
	
    /**
     * 处理状态,(0-未入账,1-已入账)
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "处理状态,(0-未入账,1-已入账)")
	private String handleFlag;
    @ApiModelProperty(value = "入金流水")
    private String incomeFlowId;


    @ApiModelProperty(value = "客户名称")
    private String industryName;
    @ApiModelProperty(value = "代付客户号")
    private String industryCode;
    @ApiModelProperty(value = "账户类型1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户")
    private String accountType;
}