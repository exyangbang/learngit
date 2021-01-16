package com.scenetec.upf.operation.service.settle.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.MerReconcileRecordDO;

import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.settle.MerReconcileRecordMapper;
import com.scenetec.upf.operation.service.settle.MerReconcileRecordService;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/19
 */
@Service
public class MerReconcileRecordServiceImpl implements MerReconcileRecordService{

    @Resource
    MerReconcileRecordMapper mapper;

    @Override
    public long create(MerReconcileRecordDO obj) {
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
	    return mapper.delete(id);
	}

    @Override
	public void update(MerReconcileRecordDO obj) {
	    mapper.update(obj);
	}
	
    @Override
    public MerReconcileRecordDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<MerReconcileRecordDO> list(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<MerReconcileRecordDO> page = mapper.list(query.getParameters());
	    return new PageInfo<>(page);
	}

    @Override
    public Integer reconcileStatus() {
        MerReconcileRecordDO  rec = new MerReconcileRecordDO();
        rec.setReconcileStatus("0");
        Integer res = mapper.count(rec);
        return res;
    }
}
