package com.scenetec.upf.operation.service.country.impl;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import com.scenetec.upf.operation.repository.country.CountryMapper;
import com.scenetec.upf.operation.service.country.CountryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountryServiceImpl implements CountryService {
    @Resource
    public CountryMapper countryMapper;

    @Override
    public Page<CountryDO> getCountList() {
        Map map = new HashMap<>();
        Page<CountryDO> list = countryMapper.list(map);
        list.forEach(c -> {
            c.setChName(c.getChName() + "(" + c.getThreeBitLetters() + ")");
        });
        if (list == null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "信息获取失败");
        }
        return list;
    }
}
