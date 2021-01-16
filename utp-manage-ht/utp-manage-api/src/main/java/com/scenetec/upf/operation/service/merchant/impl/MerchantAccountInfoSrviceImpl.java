package com.scenetec.upf.operation.service.merchant.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
import com.scenetec.upf.operation.repository.merchant.MerchantAccountInfoMapper;
import com.scenetec.upf.operation.service.merchant.MerchantAccountInfoSrvice;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MerchantAccountInfoSrviceImpl implements MerchantAccountInfoSrvice {

    @Resource
    private MerchantAccountInfoMapper merchantAccountInfoMapper;

    @Override
    public PageInfo<MerchantAccountInfoDO> getBankList(Query query) {
        PageHelper.startPage(query.getPageNo()==0?1:query.getPageNo()
                ,query.getPageSize()==0?10:query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        List list = merchantAccountInfoMapper.list(query.getParameters());
        return new PageInfo<>(list);
    }
}
