package com.scenetec.upf.operation.service.settle.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.IndSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.MerSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.OrgSettleSumInfoDO;

import com.scenetec.upf.operation.model.domain.settle.TransSumInfoDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.settle.SettleSumInfoMapper;
import com.scenetec.upf.operation.service.settle.SettleSumInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Service
public class SettleSumInfoServiceImpl implements SettleSumInfoService{

    @Resource
    SettleSumInfoMapper mapper;

    @Override
    public int delete(Long id) {
	    return mapper.delete(id);
	}

    @Override
	public void update(OrgSettleSumInfoDO obj) {
	    mapper.update(obj);
	}

    @Override
    public OrgSettleSumInfoDO selectOne(OrgSettleSumInfoDO obj) {
        return mapper.selectOne(obj);
    }

    @Override
    public OrgSettleSumInfoDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<OrgSettleSumInfoDO> orgList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
	    Page<OrgSettleSumInfoDO> page = mapper.orgList(query.getParameters());
	    return new PageInfo<>(page);
	}
    @Override
    public PageInfo<MerSettleSumInfoDO> merList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<MerSettleSumInfoDO> page = mapper.merList(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<IndSettleSumInfoDO> indList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("reconcile_date desc");
        Page<IndSettleSumInfoDO> page = mapper.indList(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<TransSumInfoDO> sumList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<TransSumInfoDO> page = mapper.sumList(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public List<OrgSettleSumInfoDO> selectOrgList(OrgSettleSumInfoDO obj) {
        return mapper.selectOrgList(obj);
    }

    @Override
    public List<MerSettleSumInfoDO> selectMerList(MerSettleSumInfoDO obj) {
        return mapper.selectMerList(obj);
    }

    @Override
    public List<IndSettleSumInfoDO> selectIndList(IndSettleSumInfoDO obj) {
        return mapper.selectIndList(obj);
    }

    @Override
    public List<TransSumInfoDO> selectSumList(Map<String, Object> parameters) {
        return mapper.selectSumList(parameters);
    }

    @Override
    public Map<String, Long> countOrg(String orgCode, String reconcileDate) {
        return mapper.countOrg(orgCode,reconcileDate);
    }

    @Override
    public Map<String, Long> countMer(String merNo, String reconcileDate) {
        return mapper.countMer(merNo,reconcileDate);
    }

    @Override
    public Map<String, Long> countInd(String industryCode, String reconcileDate) {
        return mapper.countInd(industryCode,reconcileDate);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        return mapper.countTrans(parameters);
    }


}

