package com.scenetec.upf.operation.service.channelrespcode.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.channelrespcode.ChannelRespcodeDO;
import com.scenetec.upf.operation.repository.channelrespcode.ChannelRespcodeMapper;
import com.scenetec.upf.operation.service.channelrespcode.ChannelRespcodeService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ChannelRespcodeServiceImpl implements ChannelRespcodeService {

    @Resource
    ChannelRespcodeMapper channelRespcodeMapper;
    @Resource
    UserService userService;
    /**
     * 渠道响应码 不允许重复
     * @param obj
     * @return
     */
    @Override
    public long create(ChannelRespcodeDO obj) {
        ChannelRespcodeDO temObj = new ChannelRespcodeDO();
        temObj.setChannelRespcode(obj.getChannelRespcode());
        int resCount = channelRespcodeMapper.count(temObj);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.CHARES001);
        }
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        return channelRespcodeMapper.create(obj);
    }

    @Override
    public int delete(Long id) {
        return channelRespcodeMapper.delete(id);
    }
    /**
     * 渠道响应码 不允许重复
     * @param obj
     * @return
     */
    @Override
    public void update(ChannelRespcodeDO obj) {
        ChannelRespcodeDO temObj = new ChannelRespcodeDO();
        temObj.setChannelRespcode(obj.getChannelRespcode());
        temObj.setId(obj.getId());
        int resCount = channelRespcodeMapper.count(temObj);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.CHARES001);
        }
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        channelRespcodeMapper.update(obj);
    }

    @Override
    public ChannelRespcodeDO getById(Long id) {
        if (id < 0 || id == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return channelRespcodeMapper.getById(id);
    }

    @Override
    public PageInfo<ChannelRespcodeDO> pageList(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Page<ChannelRespcodeDO> page = channelRespcodeMapper.list(query.getParameters());
        return new PageInfo<>(page);
    }

}
