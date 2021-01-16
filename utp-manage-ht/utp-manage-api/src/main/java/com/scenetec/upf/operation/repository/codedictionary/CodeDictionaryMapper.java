package com.scenetec.upf.operation.repository.codedictionary;

import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/10/30
 */
@Repository
@Mapper
public interface CodeDictionaryMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_code_dictionary (id,user_create,gmt_create,user_modified,gmt_modified,type,code,value,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{type},#{code},#{value},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(CodeDictionaryDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_code_dictionary ("
        +" user_create, gmt_create, user_modified, gmt_modified, type, code, value, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.type}, #{item.code}, #{item.value}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<CodeDictionaryDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_code_dictionary ("
        +" user_create, gmt_create, user_modified, gmt_modified, type, code, value, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.type}, #{item.code}, #{item.value}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"type = VALUES(type),"
            +"code = VALUES(code),"
            +"value = VALUES(value),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<CodeDictionaryDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_code_dictionary where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_code_dictionary <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='type != null'> type = #{type}, </if> "
            +"<if test='code != null'> code = #{code}, </if> "
            +"<if test='value != null'> value = #{value}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(CodeDictionaryDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,type,code,value,remark from t_code_dictionary where id = #{id}")
 	@Results(id="CodeDictionaryResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "type", column = "type"),@Result(property = "code", column = "code"),@Result(property = "value", column = "value"),@Result(property = "remark", column = "remark")})
 	CodeDictionaryDO getById(@Param("id") Long id);

    @Select("select id,type,code,value from t_code_dictionary where code = #{code}")
    @ResultMap("CodeDictionaryResultMap")
    CodeDictionaryDO getByCode(@Param("code") String code);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,type,code,value,remark from t_code_dictionary where 1 = 1"
		        + "<if test='params.code != null'> and code = #{params.code}</if>"
		        + "<if test='params.type != null'> and type = #{params.type}</if>"
        + "</script>"
    )
    @ResultMap("CodeDictionaryResultMap")
    Page<CodeDictionaryDO> list(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "select id, code,value from t_code_dictionary where 1 = 1"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.codeBus != null'> and code REGEXP #{params.codeBus}</if>"
                    + "<if test='params.type != null'> and type = #{params.type}</if>"
                    + "</script>"
    )
    @ResultMap("CodeDictionaryResultMap")
    Page<CodeDictionaryDO> listBeCodeAndValue(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_code_dictionary <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='type != null'> type = #{type} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='value != null'> value = #{value} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(CodeDictionaryDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,type,code,value,remark from t_code_dictionary"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='type != null'> type = #{type} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='value != null'> value = #{value} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CodeDictionaryResultMap")
    CodeDictionaryDO selectOne(CodeDictionaryDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,type,code,value,remark from t_code_dictionary"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='type != null'> type = #{type} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='value != null'> value = #{value} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CodeDictionaryResultMap")
    List<CodeDictionaryDO> selectList(CodeDictionaryDO obj);


    @Select(
            "<script>"
                    + "select * from t_code_dictionary where 1 = 1"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.type != null'> and type = #{params.type}</if>"
                    + "<if test='params.value != null '> and value like concat('%',#{params.value},'%')</if>"
                    + "order by gmt_modified desc"
                    + "</script>"
    )
    @ResultMap("CodeDictionaryResultMap")
    Page<CodeDictionaryDO> pageList(@Param("params") Map<String, Object> params);

}

