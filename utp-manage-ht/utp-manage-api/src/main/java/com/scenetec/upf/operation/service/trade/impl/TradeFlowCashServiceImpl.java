package com.scenetec.upf.operation.service.trade.impl;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.vo.trade.TradeFlowQuery;
import com.scenetec.upf.operation.service.trade.TradeFlowCashService;
import com.scenetec.upf.operation.utils.StringUtil;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author LIFA
 * @date 2018/07/25
 */
@Service
public class TradeFlowCashServiceImpl implements TradeFlowCashService{

    @Value("${trade.flow.cash.url}")
    String tradeFlowCashURL;

    @Override
    public String list(Query query) {
		// 组装参数
	    TradeFlowQuery trade = genTradeFlowQuery(query);
		// 执行查询
	    return call(trade);
    }

	/**
	 * 组装请求参数
	 * @param query 请求入参
	 * @return 返回入参
	 */
	private TradeFlowQuery genTradeFlowQuery(Query query) {
		if (query == null) {
			throw new SystemRuntimeException(ErrorCode.BSMTR002);
		}

	    TradeFlowQuery trade = new TradeFlowQuery();

	    trade.setPageNo(query.getPageNo());
	    trade.setPageSize(query.getPageSize());

	    Map<String, Object> param = query.getParameters();
	    if (!param.isEmpty()) {
	    	trade.setBeginTradeDate(StringUtil.toString(param.get("beginTradeDate")));
	    	trade.setEndTradeDate(StringUtil.toString(param.get("endTradeDate")));
			trade.setBizType(StringUtil.toString(param.get("bizType")));
			trade.setTxnType(StringUtil.toString(param.get("txnType")));
			trade.setAcqInsCode(StringUtil.toString(param.get("acqInsCode")));
			trade.setMerId(StringUtil.toString(param.get("merId")));
			trade.setRespCode(StringUtil.toString(param.get("respCode")));
			trade.setQueryId(StringUtil.toString(param.get("queryId")));
			trade.setOrderId(StringUtil.toString(param.get("orderId")));
			trade.setAccNo(StringUtil.toString(param.get("accNo")));
	    }
	    return trade;
    }

	/**
	 * 调用查询服务
	 * @return 返回结果
	 */
	private String call(TradeFlowQuery query) {
	    String response;
	    try {
		    // 执行查询
		    RestTemplate restTemplate = new RestTemplate();

		    response = restTemplate.postForObject(tradeFlowCashURL, query, String.class);
	    } catch (Exception ex) {
		    ex.printStackTrace();
		    throw new SystemRuntimeException(ErrorCode.BSMTR001, ex.getMessage());
	    }
		return response;
    }
}
