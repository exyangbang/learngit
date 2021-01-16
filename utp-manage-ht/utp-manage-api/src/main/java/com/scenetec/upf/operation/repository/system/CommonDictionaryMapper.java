package com.scenetec.upf.operation.repository.system;

import com.scenetec.upf.operation.model.domain.system.CommonDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoxianjun
 */
@Repository
@Mapper
public interface CommonDictionaryMapper {

    /**
     *查询字典
     * @return 字典信息列表
     * */
    @Select("select id,type,`key`,`value`,description from t_common_dictionary")
    List<CommonDictionary> findAll();

}
