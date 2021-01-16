package com.scenetec.upf.operation.web.trade;

import com.scenetec.upf.operation.service.trade.TradeFlowCashService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author LIFA
 * @date 2018/07/24
 */

@ApiIgnore
@Api(value="交易流水接口",tags={"交易流水"})
@RestController
public class TradeFlowCashController {

    @Resource
    TradeFlowCashService service;

    @ApiOperation(value = "分页获取交易流水列表", notes = "分页获取交易流水列表")
    @RequestMapping(value = "/api/tradeFlowCash/list", method = RequestMethod.POST)
    public String list(@RequestBody Query query) {
	    return service.list(query);
	}
}
