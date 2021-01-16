package com.scenetec.upf.operation.service.blacklist.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.blacklist.BlacklistDO;
import com.scenetec.upf.operation.repository.blacklist.BlacklistMapper;
import com.scenetec.upf.operation.service.blacklist.BlacklistService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class BlacklistServiceImpl implements BlacklistService {
    Logger logger = LoggerFactory.getLogger(BlacklistServiceImpl.class);
    @Resource
    private BlacklistMapper blacklistMapper;
    @Override
    public PageInfo<BlacklistDO> getBlackList(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        List<BlacklistDO> list= new ArrayList<>();
        try {
            list= blacklistMapper.listPage(query.getParameters());
        }catch (Exception e){
            logger.error("信息获取异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC006,"信息获取错误");
        }
        return new PageInfo<>(list);
    }
}
