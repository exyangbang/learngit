package com.scenetec.upf.operation.service.channel.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.upf.operation.repository.channel.ChannelMerchantMapper;
import com.scenetec.upf.operation.service.channel.ChannelMerchantService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Service
public class ChannelMerchantServiceImpl implements ChannelMerchantService{

    @Resource
    ChannelMerchantMapper mapper;

    @Resource
    UserService userService;

    @Override
    public long create(ChannelMerchantDO obj) {
        try {
            obj.setGmtCreate(new Date());
            obj.setUserCreate(userService.getUserContext().getUsername());
            obj.setId(IdGenerate.getId());
            mapper.create(obj);
        }catch (DataAccessException e){
            throw new SystemRuntimeException(ErrorCode.BSMCD003);
        }
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
	    return mapper.delete(id);
	}

    @Override
	public void update(ChannelMerchantDO obj) {
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
	    mapper.update(obj);
	}
	
    @Override
    public ChannelMerchantDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<ChannelMerchantDO> list(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<ChannelMerchantDO> page = mapper.list(query.getParameters());
	    return new PageInfo<>(page);
	}
}
