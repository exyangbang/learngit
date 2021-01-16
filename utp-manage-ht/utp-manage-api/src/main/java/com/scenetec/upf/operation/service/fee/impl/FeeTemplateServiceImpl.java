package com.scenetec.upf.operation.service.fee.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;

import com.scenetec.upf.operation.repository.channel.ChannelInfoMapper;
import com.scenetec.upf.operation.repository.channel.ChannelMerchantMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.fee.FeeTemplateMapper;
import com.scenetec.upf.operation.service.fee.FeeTemplateService;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Service
public class FeeTemplateServiceImpl implements FeeTemplateService{

    @Resource
    FeeTemplateMapper mapper;
    @Resource
    UserService userService;

    @Resource
    ChannelInfoMapper cmapper;

    @Resource
    ChannelMerchantMapper cmmapper;

    @Override
    public long create(FeeTemplateDO obj) {
        FeeTemplateDO fee=new FeeTemplateDO();
        fee.setName(obj.getName());
        if(mapper.count(fee)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMFM001);
        }
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
        ChannelInfoDO cid=new ChannelInfoDO();
        cid.setChnFeeTemplateId(id);
        if(cmapper.count(cid)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMFM002);
        }
        ChannelMerchantDO cmd=new ChannelMerchantDO();
        cmd.setMerFeeTemplateId(id);
        if(cmmapper.count(cmd)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMFM002);
        }
	    return mapper.delete(id);
	}

    @Override
	public void update(FeeTemplateDO obj) {
        try {
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            mapper.update(obj);
        }catch (DataAccessException e){
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }

	}
	
    @Override
    public FeeTemplateDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<FeeTemplateDO> list(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<FeeTemplateDO> page = mapper.list(query.getParameters());
	    return new PageInfo<>(page);
	}
}
