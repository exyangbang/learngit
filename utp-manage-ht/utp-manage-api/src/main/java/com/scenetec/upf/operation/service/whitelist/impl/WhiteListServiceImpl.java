package com.scenetec.upf.operation.service.whitelist.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.whitelist.WhiteListMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.whitelist.WhiteListService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WhiteListServiceImpl implements WhiteListService {
    @Autowired
    WhiteListMapper whiteListMapper;

    @Autowired
    IndustryMapper industryMapper;
    @Resource
    UserService userService;

    /**
     * 实体账户号+来款账户名称不允许重复。
     *
     * @param obj
     * @return
     */
    @Override
    public long create(WhiteListVO obj) {
        IndustryDO industryDO = new IndustryDO();
        industryDO.setCode(obj.getIndustryCode());
        industryDO = industryMapper.selectOne(industryDO);
        if (industryDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "客户号不存在");
        }
        WhiteListDO tempList = new WhiteListDO();
        tempList.setAccountName(obj.getAccountName());
        tempList.setFundAccount(industryDO.getFundAccount());
        Integer resCount = whiteListMapper.count(tempList);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "白名单在同一个资金账户不能重复配置");
        }

        WhiteListDO whiteListDO = new WhiteListDO();
        BeanUtils.copyProperties(obj, whiteListDO);
        whiteListDO.setGmtCreate(new Date());
        whiteListDO.setUserCreate(userService.getUserContext().getUsername());
        whiteListDO.setGmtModified(new Date());
        whiteListDO.setUserModified(userService.getUserContext().getUsername());
        whiteListDO.setId(IdGenerate.getId());
        whiteListDO.setFundAccount(industryDO.getFundAccount());
        return whiteListMapper.create(whiteListDO);
    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return whiteListMapper.delete(id);
    }

    @Override
    public void update(WhiteListVO obj) {
        if (obj.getId() == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCD101, "id");
        }
        IndustryDO industryDO = new IndustryDO();
        industryDO.setCode(obj.getIndustryCode());
        industryDO = industryMapper.selectOne(industryDO);
        if (industryDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "客户号不存在");
        }
        WhiteListDO tempList = new WhiteListDO();
        tempList.setAccountName(obj.getAccountName());
        tempList.setFundAccount(industryDO.getFundAccount());
        tempList.setId(obj.getId());
        Integer resCount = whiteListMapper.countChekckId(tempList);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "白名单在同一个资金账户不能重复配置");
        }
        WhiteListDO whiteListDO = new WhiteListDO();
        BeanUtils.copyProperties(obj, whiteListDO);
        whiteListDO.setGmtModified(new Date());
        whiteListDO.setUserModified(userService.getUserContext().getUsername());
        whiteListMapper.update(whiteListDO);
    }

    @Override
    public WhiteListDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return whiteListMapper.getById(id);
    }

    @Override
    public PageInfo<WhiteListDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        List<WhiteListDO> page = whiteListMapper.listPage(obj.getParameters());
        return new PageInfo<>(page);
    }
}
