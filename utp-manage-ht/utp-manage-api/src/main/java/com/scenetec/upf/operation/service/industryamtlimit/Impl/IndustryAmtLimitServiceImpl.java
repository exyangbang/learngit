package com.scenetec.upf.operation.service.industryamtlimit.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.repository.industryamtlimit.IndustryAmtLimitMapper;
import com.scenetec.upf.operation.service.industryamtlimit.IndustryAmtLimitService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class IndustryAmtLimitServiceImpl implements IndustryAmtLimitService {

    @Resource
    IndustryAmtLimitMapper industryAmtLimitMapper;

    @Override
    public PageInfo<IndustryAmtLimitDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map<String, Object> map = query.getParameters();
        Page<IndustryAmtLimitDO> page = industryAmtLimitMapper.pageList(map);
        return new PageInfo<>(page);
    }

}
