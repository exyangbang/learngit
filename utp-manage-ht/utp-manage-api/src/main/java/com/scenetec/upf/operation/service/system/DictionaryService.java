package com.scenetec.upf.operation.service.system;

import com.scenetec.upf.operation.model.domain.system.CommonDictionary;

import java.util.List;
import java.util.Map;

/**
 * @author luoxianjun
 */
public interface DictionaryService {
    /**
     * 获取系统数据字典
     * @return {type: [{key: value}]}
     */
    Map<String, List<CommonDictionary>> getDictionary();

}
