package com.scenetec.upf.operation.service.product.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.account.AccIncomeFlowDO;
import com.scenetec.upf.operation.model.domain.channelincomeflow.ChannelIncomeFlowDO;
import com.scenetec.upf.operation.repository.account.AccIncomeFlowMapper;
import com.scenetec.upf.operation.repository.channelincomeflow.ChannelIncomeFlowMapper;
import com.scenetec.upf.operation.service.product.FlowingIntoGoldService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;

@Service
public class FlowingIntoGoldServiceImpl implements FlowingIntoGoldService {
    @Resource
    private AccIncomeFlowMapper accIncomeFlowMapper;
    @Resource
    private ChannelIncomeFlowMapper channelIncomeFlowMapper;

    @Override
    public PageInfo<ChannelIncomeFlowDO> list(Query query) {
        Instant start = Instant.now();
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Page<ChannelIncomeFlowDO> pageInfo = channelIncomeFlowMapper.pageList(query.getParameters());
        pageInfo.stream().forEach(e->{
            AccIncomeFlowDO incomeFlowDO = new AccIncomeFlowDO();
            incomeFlowDO.setIncomeFlowId(e.getRid());
            AccIncomeFlowDO tep =  accIncomeFlowMapper.selectOneByIncomeFlowId(incomeFlowDO);
            if (tep != null){
                e.setIncomeFlowId(tep.getIncomeFlowId());
            }
        });
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end));
        return new PageInfo<>(pageInfo);
    }


//    @Override
//    public PageInfo<OutsideTransOrderDO> listDetail(Query query) {
//        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
//        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
//        PageHelper.startPage(query.getPageNo(), query.getPageSize());
//        PageHelper.orderBy("gmt_create desc");
//        Map<String,Object> map = query.getParameters();
//        map.put("uploadStatus","SUCCESS");//只显示成功的
//        Page<OutsideTransOrderDO> page = accIncomeFlowMapper.list(map);
//        return new PageInfo<>(page);
//    }


}
