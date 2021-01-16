package com.scenetec.upf.operation.model.domain.trade;


import lombok.Data;

/**
 * @author LIFA
 * @date 2018/07/25
 */
@Data
public class TradeFlowCashDO {
    private long id;

    /**
     * 客户端流水号
     * mysqlType: varchar(32)
     */ 	
	private String clientFlowId;
	
    /**
     * 前置平台商户号
     * mysqlType: varchar(32)
     */ 	
	private String platformMerId;
	
    /**
     * 交易日期
     * mysqlType: varchar(8)
     */ 	
	private String tradeDate;
	
    /**
     * 交易时间
     * mysqlType: varchar(6)
     */ 	
	private String tradeTime;
	
    /**
     * 交易类型
     * mysqlType: varchar(2)
     */ 	
	private String txnType;
	
    /**
     * 交易子类
     * mysqlType: varchar(2)
     */ 	
	private String txnSubType;
	
    /**
     * 批次号
     * mysqlType: varchar(100)
     */ 	
	private String batchNo;
	
    /**
     * 收单机构代码
     * mysqlType: varchar(32)
     */ 	
	private String acqInsCode;
	
    /**
     * 产品类型
     * mysqlType: varchar(10)
     */ 	
	private String bizType;
	
    /**
     * 商户订单号
     * mysqlType: varchar(100)
     */ 	
	private String orderId;

    /**
     * 商户类别
     * mysqlType: varchar(10)
     */ 	
	private String merType;
	
    /**
     * 商户代码
     * mysqlType: varchar(32)
     */ 	
	private String merCode;
	
    /**
     * 商户名称
     * mysqlType: varchar(100)
     */ 	
	private String merName;
	
    /**
     * 商户简称
     * mysqlType: varchar(32)
     */ 	
	private String merAbbr;
	
    /**
     * 二级商户代码
     * mysqlType: varchar(10)
     */ 	
	private String subMerId;
	
    /**
     * 二级商户全称
     * mysqlType: varchar(100)
     */ 	
	private String subMerName;
	
    /**
     * 二级商户简称
     * mysqlType: varchar(100)
     */ 	
	private String subMerAbbr;
	
    /**
     * 订单发送时间
     * mysqlType: varchar(32)
     */ 	
	private String txnTime;
	
    /**
     * 账号类型
     * mysqlType: varchar(2)
     */ 	
	private String accType;
	
    /**
     * 账号
     * mysqlType: varchar(100)
     */ 	
	private String accNo;
	
    /**
     * 交易金额
     * mysqlType: bigint
     */ 	
	private long txnAmt;
	
    /**
     * 交易币种
     * mysqlType: varchar(3)
     */ 	
	private String currencyCode;
	
    /**
     * 请求方保留域
     * mysqlType: varchar(100)
     */ 	
	private String reqReserved;
	
    /**
     * 支付方式
     * mysqlType: varchar(2)
     */ 	
	private String payMode;
	
    /**
     * 账单类型
     * mysqlType: varchar(2)
     */ 	
	private String billType;
	
    /**
     * 账单号码 
     * mysqlType: varchar(32)
     */ 	
	private String billNo;
	
    /**
     * 交互方式
     * mysqlType: varchar(10)
     */ 	
	private String interactiveMode;
	
    /**
     * 交易查询流水号
     * mysqlType: varchar(32)
     */ 	
	private String queryId;
	
    /**
     * 对账标识
     * mysqlType: char(1)
     */ 	
	private String recheckFlag;
	
    /**
     * 交易状态
     * mysqlType: varchar(10)
     */ 	
	private String tradeStatus;
	
    /**
     * 回调次数 
     * mysqlType: int
     */ 	
	private int callbackNumber;
	
    /**
     * 回调状态
     * mysqlType: char(1)
     */ 	
	private String callbackStatus;
	
    /**
     * 回调时间
     * mysqlType: datetime
     */ 	
	private String callbackTime;
	
    /**
     * 备注
     * mysqlType: varchar(100)
     */ 	
	private String remark;

	/**
	 * 创建时间
	 * mysqlType: datetime
	 */
	private String createTime;

	/**
	 * 更新时间
	 * mysqlType: datetime
	 */
	private String updateTime;
	
 }