package com.scenetec.upf.operation.service.outsidetransorder.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.outsidetransorder.OutsideTransOrderDO;
import com.scenetec.upf.operation.repository.outsidetransorder.OutsideTransOrderMapper;
import com.scenetec.upf.operation.service.outsidetransorder.OutsideTransOrderService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class OutsideTransOrderServiceImpl implements OutsideTransOrderService {

    @Resource
    OutsideTransOrderMapper mapper;

    @Override
    public PageInfo<OutsideTransOrderDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Map<String, Object> map = query.getParameters();
        map.put("uploadStatus", "SUCCESS");//只显示成功的
        if (map.containsKey("flowTransOrderId") && map.get("flowTransOrderId") != null) {
            String[] str =  map.get("flowTransOrderId").toString().split(",");
            map.put("flowTransOrderId",str) ;
        }
        Page<OutsideTransOrderDO> page = mapper.list(map);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<OutsideTransOrderDO> listDownload(Query query) {
        PageHelper.orderBy("gmt_create desc");
        Map<String, Object> map = query.getParameters();
        map.put("uploadStatus", "SUCCESS");//只显示成功的
        if (map.containsKey("flowTransOrderId") && map.get("flowTransOrderId") != null) {
            String[] str =  map.get("flowTransOrderId").toString().split(",");
            map.put("flowTransOrderId",str) ;
        }
        Page<OutsideTransOrderDO> page = mapper.list(map);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Object> countSum(Map<String, Object> parameters) {
        Map<String, Object> temMap = parameters;
        temMap.put("uploadStatus", "SUCCESS");//只显示成功的
        Map<String, Object> map = mapper.countSum(temMap);
        return map;
    }

    @Override
    public OutsideTransOrderDO showPDF(Long id) {
        return mapper.getById(id);
    }
}
