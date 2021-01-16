package com.scenetec.upf.operation.repository.fee;

import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;
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
public interface FeeTemplateMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_fee_template (id,user_create,gmt_create,user_modified,gmt_modified,name,settle_type,charge_mode,calculate_mode,fee,min_fee,max_fee,content,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{name},#{settleType},#{chargeMode},#{calculateMode},#{fee},#{minFee},#{maxFee},#{content},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(FeeTemplateDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_fee_template ("
                    +" user_create, gmt_create, user_modified, gmt_modified, name, settle_type, charge_mode, calculate_mode, fee, min_fee, max_fee, content,remark"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.name}, #{item.settleType}, #{item.chargeMode}, #{item.calculateMode}, #{item.fee}, #{item.minFee}, #{item.maxFee},#{item.content}, #{item.remark})"
                    +"</foreach>"
                    +"</script>"
    )
    int insertList(List<FeeTemplateDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_fee_template ("
                    +" user_create, gmt_create, user_modified, gmt_modified, name, settle_type, charge_mode, calculate_mode, fee, min_fee, max_fee, remark"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.name}, #{item.settleType}, #{item.chargeMode}, #{item.calculateMode}, #{item.fee}, #{item.minFee}, #{item.maxFee}, #{item.remark})"
                    +"</foreach>"
                    +" ON DUPLICATE KEY UPDATE "
                    +"user_create = VALUES(user_create),"
                    +"gmt_create = VALUES(gmt_create),"
                    +"user_modified = VALUES(user_modified),"
                    +"gmt_modified = VALUES(gmt_modified),"
                    +"name = VALUES(name),"
                    +"settle_type = VALUES(settle_type),"
                    +"charge_mode = VALUES(charge_mode),"
                    +"calculate_mode = VALUES(calculate_mode),"
                    +"fee = VALUES(fee),"
                    +"min_fee = VALUES(min_fee),"
                    +"max_fee = VALUES(max_fee),"
                    +"remark = VALUES(remark)"
                    +"</script>"
    )
    int modifyList(List<FeeTemplateDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_fee_template where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    +"update t_fee_template <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='name != null'> name = #{name}, </if> "
                    +"<if test='settleType != null'> settle_type = #{settleType}, </if> "
                    +"<if test='chargeMode != null'> charge_mode = #{chargeMode}, </if> "
                    +"<if test='calculateMode != null'> calculate_mode = #{calculateMode}, </if> "
                    +"<if test='fee != null'> fee = #{fee}, </if> "
                    +"<if test='minFee != null'> min_fee = #{minFee}, </if> "
                    +"<if test='minFee == null'> min_fee = null, </if> "
                    +"<if test='maxFee != null'> max_fee = #{maxFee}, </if> "
                    +"<if test='maxFee == null'> max_fee = null, </if> "
                    +"<if test='content != null'> content = #{content}, </if> "
                    +"<if test='remark != null'> remark = #{remark}, </if> "
                    +"<if test='remark == null'> remark = null, </if> "
                    +"</set> where id = #{id}"
                    +"</script>"
    )
    int update(FeeTemplateDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,name,settle_type,charge_mode,calculate_mode,fee,min_fee,max_fee,content,remark from t_fee_template where id = #{id}")
    @Results(id="FeeTemplateResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "name", column = "name"),@Result(property = "settleType", column = "settle_type"),@Result(property = "chargeMode", column = "charge_mode"),@Result(property = "calculateMode", column = "calculate_mode"),@Result(property = "fee", column = "fee"),@Result(property = "minFee", column = "min_fee"),@Result(property = "maxFee", column = "max_fee"),@Result(property = "content", column = "content"),@Result(property = "remark", column = "remark")})
    FeeTemplateDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,name,settle_type,charge_mode,calculate_mode,fee,min_fee,max_fee,content,remark from t_fee_template where 1 = 1"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if> " +
                    "order by gmt_modified desc"
                    + "</script>"
    )
    @ResultMap("FeeTemplateResultMap")
    Page<FeeTemplateDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_fee_template <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='name != null'> name = #{name} AND </if> "
                    +"<if test='settleType != null'> settle_type = #{settleType} AND </if> "
                    +"<if test='chargeMode != null'> charge_mode = #{chargeMode} AND </if> "
                    +"<if test='calculateMode != null'> calculate_mode = #{calculateMode} AND </if> "
                    +"<if test='fee != null'> fee = #{fee} AND </if> "
                    +"<if test='minFee != null'> min_fee = #{minFee} AND </if> "
                    +"<if test='maxFee != null'> max_fee = #{maxFee} AND </if> "
                    +"<if test='remark != null'> remark = #{remark} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int count(FeeTemplateDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,name,settle_type,charge_mode,calculate_mode,fee,min_fee,max_fee,remark from t_fee_template"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='id != null and id>0'> id = #{id} AND </if>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='name != null'> name = #{name} AND </if> "
                    +"<if test='settleType != null'> settle_type = #{settleType} AND </if> "
                    +"<if test='chargeMode != null'> charge_mode = #{chargeMode} AND </if> "
                    +"<if test='calculateMode != null'> calculate_mode = #{calculateMode} AND </if> "
                    +"<if test='fee != null'> fee = #{fee} AND </if> "
                    +"<if test='minFee != null'> min_fee = #{minFee} AND </if> "
                    +"<if test='maxFee != null'> max_fee = #{maxFee} AND </if> "
                    +"<if test='remark != null'> remark = #{remark} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("FeeTemplateResultMap")
    FeeTemplateDO selectOne(FeeTemplateDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,name,settle_type,charge_mode,calculate_mode,fee,min_fee,max_fee,remark from t_fee_template"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='name != null'> name = #{name} AND </if> "
                    +"<if test='settleType != null'> settle_type = #{settleType} AND </if> "
                    +"<if test='chargeMode != null'> charge_mode = #{chargeMode} AND </if> "
                    +"<if test='calculateMode != null'> calculate_mode = #{calculateMode} AND </if> "
                    +"<if test='fee != null'> fee = #{fee} AND </if> "
                    +"<if test='minFee != null'> min_fee = #{minFee} AND </if> "
                    +"<if test='maxFee != null'> max_fee = #{maxFee} AND </if> "
                    +"<if test='remark != null'> remark = #{remark} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("FeeTemplateResultMap")
    List<FeeTemplateDO> selectList(FeeTemplateDO obj);

}

