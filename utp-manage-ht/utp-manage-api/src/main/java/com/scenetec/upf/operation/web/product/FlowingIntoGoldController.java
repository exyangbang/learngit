package com.scenetec.upf.operation.web.product;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channelincomeflow.ChannelIncomeFlowDO;
import com.scenetec.upf.operation.service.product.FlowingIntoGoldService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "入金流水及关联支付流水查询", tags = {"入金流水及关联支付流水查询"})
@RestController
public class FlowingIntoGoldController {
    @Resource
    private FlowingIntoGoldService service;

    @RequestMapping(value = "/api/flowingIntoGold/list", method = RequestMethod.POST)
    public PageInfo<ChannelIncomeFlowDO> getList(@RequestBody Query query) {
        PageInfo<ChannelIncomeFlowDO> pageInfo = service.list(query);
        return pageInfo;
    }
}
