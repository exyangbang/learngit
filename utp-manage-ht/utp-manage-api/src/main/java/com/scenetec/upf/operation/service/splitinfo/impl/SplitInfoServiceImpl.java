package com.scenetec.upf.operation.service.splitinfo.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.settle.SettleCheckInfoDO;
import com.scenetec.upf.operation.model.domain.splitinfo.SplitInfoDO;
import com.scenetec.upf.operation.repository.splitinfo.SplitInfoMapper;
import com.scenetec.upf.operation.service.splitinfo.SplitInfoService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SplitInfoServiceImpl implements SplitInfoService {

    @Resource
    SplitInfoMapper mapper;

    @Override
    public PageInfo<SplitInfoDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Page<SplitInfoDO> page = mapper.list(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<SplitInfoDO> listDownload(Query query) {
        PageHelper.orderBy("gmt_create desc");
        Page<SplitInfoDO> page = mapper.list(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        Map<String, Long> map = mapper.countSum(parameters);
        return map;
    }

    @Override
    public SplitInfoDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return mapper.getById(id);
    }
}
