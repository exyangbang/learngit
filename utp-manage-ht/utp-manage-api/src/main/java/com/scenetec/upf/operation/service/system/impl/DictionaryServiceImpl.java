package com.scenetec.upf.operation.service.system.impl;


import com.scenetec.upf.operation.model.domain.system.CommonDictionary;
import com.scenetec.upf.operation.repository.system.CommonDictionaryMapper;
import com.scenetec.upf.operation.service.system.DictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luoxianjun
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private CommonDictionaryMapper commonDictionaryMapper;

    @Override
    public Map<String, List<CommonDictionary>> getDictionary(){

        List<CommonDictionary> dictionaries  = commonDictionaryMapper.findAll();
        if (CollectionUtils.isEmpty(dictionaries)) {
            return null;
        }
        return dictionaries.stream().collect(Collectors.groupingBy(CommonDictionary::getType));
    }
}
