package com.scenetec.upf.operation.service.trade.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.vo.SubAccountPaymentFlowVO;
import com.scenetec.upf.operation.repository.trade.SubAccountPaymentFlowMapper;
import com.scenetec.upf.operation.service.trade.SubAccountPaymentService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SubAccountPaymentServiceImpl implements SubAccountPaymentService {

    @Resource
    private SubAccountPaymentFlowMapper subAccountPaymentFlowMapper;

    @Override
    public PageInfo<SubAccountPaymentFlowVO> query(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmtCreate desc");
        Page<SubAccountPaymentFlowVO> page = subAccountPaymentFlowMapper.list(query.getParameters());
        for (SubAccountPaymentFlowVO subAccountPaymentFlowVO : page.getResult()) {
            List<String> transOrderIds = subAccountPaymentFlowMapper.getTransOrderIds(subAccountPaymentFlowVO.getServerTransId());
            Object[] objects = transOrderIds.stream()
                    .filter(transOrderId -> StringUtils.isNotBlank(transOrderId)).toArray();
            subAccountPaymentFlowVO.setTransOrderIds(StringUtils.join(objects, ','));
        }
        return page.toPageInfo();
    }

    @Override
    public Map<String, Long> countTotal(Map<String, Object> parameters) {
        return subAccountPaymentFlowMapper.countTotal(parameters);
    }
}
