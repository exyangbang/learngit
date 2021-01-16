package com.scenetec.upf.operation.service.industryamtlimit.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
import com.scenetec.upf.operation.repository.industryamtlimit.SubaccountsAmtLimitMapper;
import com.scenetec.upf.operation.service.industryamtlimit.SubaccountsAmtLimitService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SubaccountsAmtLimitServiceImpl implements SubaccountsAmtLimitService {

    @Resource
    SubaccountsAmtLimitMapper subaccountsAmtLimitMapper;
//
    @Override
    public PageInfo<SubaccountsAmtLimitDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map<String, Object> map = query.getParameters();
        Page<SubaccountsAmtLimitDO> page = subaccountsAmtLimitMapper.pageList(map);
        return new PageInfo<>(page);
    }

}
