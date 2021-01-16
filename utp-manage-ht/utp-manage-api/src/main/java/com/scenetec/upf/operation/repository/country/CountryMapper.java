package com.scenetec.upf.operation.repository.country;

import com.scenetec.upf.operation.model.domain.country.CountryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/10/09
 */
@Repository
@Mapper
public interface CountryMapper {


    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select * from t_country where id = #{id}")
 	@Results(id="CountryResultMap", value = {@Result(property = "id", column = "id"),@Result(property = "twoBitLetters", column = "two_bit_letters"),@Result(property = "threeBitLetters", column = "three_bit_letters"),@Result(property = "numCode", column = "num_code"),@Result(property = "engName", column = "eng_name"),@Result(property = "chName", column = "ch_name")})
 	CountryDO getById(@Param("id") Long id);

    @Select("select * from t_country where three_bit_letters = #{threeBitLetters}")
    @ResultMap("CountryResultMap")
    CountryDO getByThreeBitLetters(@Param("threeBitLetters") String threeBitLetters);
    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select * from t_country where 1 = 1"
        + "</script>"
    )
    @ResultMap("CountryResultMap")
    Page<CountryDO> list(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "select id,ch_name,three_bit_letters from t_country where 1 = 1"
                    + "</script>"
    )
    @ResultMap("CountryResultMap")
    Page<CountryDO> listBeThreeBitLetters(@Param("params") Map<String, Object> params);
}

