package com.scenetec.upf.operation.repository.product;

import com.scenetec.upf.operation.model.domain.product.PayProductDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Repository
@Mapper
public interface PayProductMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_pay_product (id,user_create,gmt_create,user_modified,gmt_modified,code,name,remark,status) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{code},#{name},#{remark},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(PayProductDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_pay_product ("
        +" user_create, gmt_create, user_modified, gmt_modified, code, name, remark, status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.code}, #{item.name}, #{item.remark}, #{item.status})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<PayProductDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_pay_product ("
        +" user_create, gmt_create, user_modified, gmt_modified, code, name, remark, status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.code}, #{item.name}, #{item.remark}, #{item.status})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"code = VALUES(code),"
            +"name = VALUES(name),"
            +"remark = VALUES(remark),"
            +"status = VALUES(status)"
        +"</script>"
    )
    int modifyList(List<PayProductDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_pay_product where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_pay_product <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='code != null'> code = #{code}, </if> "
            +"<if test='name != null'> name = #{name}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(PayProductDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,code,name,remark,status from t_pay_product where id = #{id}")
 	@Results(id="PayProductResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "code", column = "code"),@Result(property = "name", column = "name"),@Result(property = "remark", column = "remark"),@Result(property = "status", column = "status")})
 	PayProductDO getById(@Param("id") Long id);


    @Select("select name from t_pay_product where code = #{code}")
    @ResultMap("PayProductResultMap")
    PayProductDO getByCode(@Param("code") String code);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,code,name,remark,status from t_pay_product where 1 = 1"
		        + "<if test='params.code != null'> and code = #{params.code}</if>"
		        + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>" +"order by gmt_modified desc ,gmt_create desc"
            + "</script>"
    )
    @ResultMap("PayProductResultMap")
    Page<PayProductDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_pay_product <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(PayProductDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,code,name,remark,status from t_pay_product"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("PayProductResultMap")
    PayProductDO selectOne(PayProductDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,code,name,remark,status from t_pay_product"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("PayProductResultMap")
    List<PayProductDO> selectList(PayProductDO obj);

}

