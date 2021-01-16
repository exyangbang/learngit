package com.scenetec.upf.operation.service.product.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;
import com.scenetec.upf.operation.model.domain.product.PayProductDO;

import com.scenetec.upf.operation.repository.channel.ChannelInfoMapper;
import com.scenetec.upf.operation.repository.channel.ChannelMerchantMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.product.PayProductMapper;
import com.scenetec.upf.operation.service.product.PayProductService;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Service
public class PayProductServiceImpl implements PayProductService{

    @Resource
    PayProductMapper mapper;

    @Resource
    UserService userService;

    @Resource
    ChannelInfoMapper cmapper;

    @Resource
    ChannelMerchantMapper cmmapper;
    @Override
    public long create(PayProductDO obj) {
        try {
            obj.setGmtCreate(new Date());
            obj.setUserCreate(userService.getUserContext().getUsername());
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            obj.setId(IdGenerate.getId());
            mapper.create(obj);
        }catch (DataAccessException e){
            throw new SystemRuntimeException(ErrorCode.BSMPM001);
        }
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
        PayProductDO pd=mapper.getById(id);
        ChannelInfoDO cid=new ChannelInfoDO();
        cid.setProductNo(pd.getCode());
        if(cmapper.count(cid)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMPM002);
        }
        ChannelMerchantDO cmd=new ChannelMerchantDO();
        cmd.setProductNo(pd.getCode());
        if(cmmapper.count(cmd)!=0){
            throw new SystemRuntimeException(ErrorCode.BSMPM002);
        }
	    return mapper.delete(id);
	}

    @Override
	public void update(PayProductDO obj) {
        try{
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            mapper.update(obj);
        }catch (DataAccessException e){
            throw new SystemRuntimeException(ErrorCode.BSMPM001);
        }
	}
	
    @Override
    public PayProductDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<PayProductDO> list(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<PayProductDO> page = mapper.list(query.getParameters());
	    return new PageInfo<>(page);
	}
}
