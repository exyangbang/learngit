package com.scenetec.upf.operation.service.specialindustrysyncconfig.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.specialindustrysyncconfig.SpecialIndustrySyncConfigDO;
import com.scenetec.upf.operation.repository.specialindustrysyncconfig.SpecialIndustrySyncConfigMapper;
import com.scenetec.upf.operation.service.specialindustrysyncconfig.SpecialIndustrySyncConfigSevice;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SpecialIndustrySyncConfigSeviceImpl implements SpecialIndustrySyncConfigSevice {
    @Autowired
    private SpecialIndustrySyncConfigMapper mapper;
    @Autowired
    private UserService userService;

    @Override
    public long create(List<IndustryDO> list) {
        if (list.size() > 0){
            List<SpecialIndustrySyncConfigDO> tempList = new ArrayList<>();
            for (IndustryDO industryDO :list){
                SpecialIndustrySyncConfigDO ob = new SpecialIndustrySyncConfigDO();
                ob.setId(IdGenerate.getId());
                ob.setName(industryDO.getName());
                ob.setIndustryCode(industryDO.getCode());
                ob.setGmtCreate(new Date());
                ob.setUserCreate(userService.getUserContext().getUsername());
                tempList.add(ob);
            }
            return mapper.insertList(tempList);
        }
        return 0;
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public PageInfo<SpecialIndustrySyncConfigDO> list(Query query) {
        Map map = query.getParameters();
        SpecialIndustrySyncConfigDO tempDo = new SpecialIndustrySyncConfigDO();
        if (map.containsKey("industryCode")){
            tempDo.setIndustryCode(map.get("industryCode").toString());
        }
        if (map.containsKey("name")){
            tempDo.setName(map.get("name").toString());
        }
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("id desc");
        List<SpecialIndustrySyncConfigDO> list = mapper.selectList(tempDo);
        return new PageInfo<>(list);
    }
}
