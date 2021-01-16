package com.scenetec.upf.operation.model.domain.splitinfo;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/06/03
 */
@ApiModel(description = "分账信息查询")
@Data
public class SplitInfoDO {

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
     * 清算日期 格式为yyyyMMdd
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "清算日期 格式为yyyyMMdd")
	private String settleDate;
	
    /**
     * 商户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;
	
    /**
     * 产品编码
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "产品编码")
	private String amount;
	
    /**
     * M	数字， 例如： 1 表示账期为 T+1
     * mysqlType: int(11)
     */
    @ApiModelProperty(value = "M	数字， 例如： 1 表示账期为 T+1")
	private int period;
	
    /**
     * 入账日期 格式yyyyMMdd(清算日期+实际账期天数)
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "入账日期 格式yyyyMMdd(清算日期+实际账期天数)")
	private String splitDate;
	
    /**
     * 账户类型0-对私 1-对公
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "账户类型0-对私 1-对公")
	private String accountType;
	
    /**
     * 收款人账号
     * mysqlType: bigint(50)
     */
    @ApiModelProperty(value = "收款人账号")
	private String accountNo;
	
    /**
     * 收款人名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "收款人名称")
	private String accountName;
	
    /**
     * 收款人清算行行号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "收款人清算行行号")
	private String bankCode;
	
    /**
     * 备注说明
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "备注说明")
	private String remark;

	
    /**
     * 关联支付订单号列表 trans_order_ids
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "关联支付订单号列表 trans_order_ids")
	private String extend_1;
	
    /**
     * 扩展字段2
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "扩展字段2")
	private String extend_2;
	
    /**
     * 扩展字段3
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "扩展字段3")
	private String extend_3;
	
    /**
     * 虚账户分账入账状态（0-未入账 1-已入账）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "虚账户分账入账状态（0-未入账 1-已入账）")
	private String status;
	
    /**
     * 文件提供商
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "文件提供商")
	private String providerCode;
	
    /**
     * 批次Id
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "批次Id")
	private String batchId;
	
    /**
     * 发起提现交易日期yyyyMMdd
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "发起提现交易日期yyyyMMdd")
	private String transDate;
	
    /**
     * 服务端交易流水号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "服务端交易流水号")
	private String serverTransId;
	
    /**
     * 客户端交易流水号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "客户端交易流水号")
	private String clientTransId;
	
    /**
     * 交易状态|同交易表状态
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "交易状态|同交易表状态")
	private String transStatus;
	
    /**
     * 提现结果查询次数
     * mysqlType: varchar(11)
     */
    @ApiModelProperty(value = "提现结果查询次数")
	private int queryTimes;
	
    /**
     * 提现结果描述
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "提现结果描述")
	private String transDesc;
	
    /**
     * 分账主体0-个人 1商户
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "分账主体0-个人 1商户")
	private String subject;
	
    /**
     * 华通清算对账日
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "华通清算对账日")
	private String reconcileDate;
	
    /**
     * 用户账户
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "用户账户")
	private String userAccount;
	
    /**
     * 结算方式0=代付结算 1=记账结算
     * mysqlType: varchar(1)
     */
    @ApiModelProperty(value = "结算方式0=代付结算 1=记账结算")
	private String settleMode;
	
    /**
     * 代付客户号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "代付客户号")
	private String industryCode;
    /**
     * 用户户名
     */
    private String objName;

    /**
     * 代付客户名称
     */
    private String industryName;
}