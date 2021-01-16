package com.scenetec.upf.operation.model.vo.trade;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/8/3
 */
@ApiModel(description = "交易流水查询")
@Data
public class TradeFlowQuery {
	/**
	 * 交易开始日期
	 */
	private String beginTradeDate;

	/**
	 * 交易结束日期
	 */
	private String endTradeDate;
	/**
	 * 产品类型
	 */
	private String bizType;
	/**
	 * 交易类型
	 */
	private String txnType;
	/**
	 * 机构
	 */
	private String acqInsCode;
	/**
	 * 商户号
	 */
	private String merId;
	/**
	 * 页号
	 */
	private Integer pageNo;
	/**
	 * 页大小
	 */
	private Integer pageSize;
	/**
	 * 状态
	 */
	private String respCode;
	/**
	 * 查询码
	 */
	private String queryId;
	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 账号
	 * */
	private String accNo;
}
