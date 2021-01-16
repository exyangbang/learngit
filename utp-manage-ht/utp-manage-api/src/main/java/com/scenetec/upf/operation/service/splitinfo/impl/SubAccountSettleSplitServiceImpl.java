package com.scenetec.upf.operation.service.splitinfo.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.vo.SubAccountSettleSplitVO;
import com.scenetec.upf.operation.repository.splitinfo.SubAccountSettleSplitMapper;
import com.scenetec.upf.operation.service.splitinfo.SubAccountSettleSplitService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author scenetec
 */
@Service
public class SubAccountSettleSplitServiceImpl implements SubAccountSettleSplitService {

    @Resource
    private SubAccountSettleSplitMapper subAccountSettleSplitMapper;

    @Override
    public PageInfo<SubAccountSettleSplitVO> query(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmtCreate desc");
        Page<SubAccountSettleSplitVO> page = subAccountSettleSplitMapper.list(query.getParameters());
        return page.toPageInfo();
    }

    @Override
    public Map<String, Long> countTotal(Map<String, Object> parameters) {
        return subAccountSettleSplitMapper.countTotal(parameters);
    }
}
