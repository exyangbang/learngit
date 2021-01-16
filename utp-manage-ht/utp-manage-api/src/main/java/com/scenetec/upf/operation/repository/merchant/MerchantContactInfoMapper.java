package com.scenetec.upf.operation.repository.merchant;

import com.scenetec.upf.operation.model.domain.merchant.MerchantContactInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@Repository
@Mapper
public interface MerchantContactInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_contact_info (user_create,gmt_create,user_modified,gmt_modified,mer_no,contact_name,contact_phone,contact_email) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{contactName},#{contactPhone},#{contactEmail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(MerchantContactInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_contact_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, contact_name, contact_phone, contact_email"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.contactName}, #{item.contactPhone}, #{item.contactEmail})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<MerchantContactInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_contact_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, contact_name, contact_phone, contact_email"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.contactName}, #{item.contactPhone}, #{item.contactEmail})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"mer_no = VALUES(mer_no),"
            +"contact_name = VALUES(contact_name),"
            +"contact_phone = VALUES(contact_phone),"
            +"contact_email = VALUES(contact_email)"
        +"</script>"
    )
    int modifyList(List<MerchantContactInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_contact_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_contact_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='contactName != null'> contact_name = #{contactName}, </if> "
            +"<if test='contactPhone != null'> contact_phone = #{contactPhone}, </if> "
            +"<if test='contactEmail != null'> contact_email = #{contactEmail}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(MerchantContactInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,contact_name,contact_phone,contact_email from t_merchant_contact_info where id = #{id}")
 	@Results(id="MerchantContactInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "merNo", column = "mer_no"),@Result(property = "contactName", column = "contact_name"),@Result(property = "contactPhone", column = "contact_phone"),@Result(property = "contactEmail", column = "contact_email")})
 	MerchantContactInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,contact_name,contact_phone,contact_email from t_merchant_contact_info where 1 = 1"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
        + "</script>"
    )
    @ResultMap("MerchantContactInfoResultMap")
    Page<MerchantContactInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_contact_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='contactName != null'> contact_name = #{contactName} AND </if> "
            +"<if test='contactPhone != null'> contact_phone = #{contactPhone} AND </if> "
            +"<if test='contactEmail != null'> contact_email = #{contactEmail} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(MerchantContactInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,contact_name,contact_phone,contact_email from t_merchant_contact_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='contactName != null'> contact_name = #{contactName} AND </if> "
            +"<if test='contactPhone != null'> contact_phone = #{contactPhone} AND </if> "
            +"<if test='contactEmail != null'> contact_email = #{contactEmail} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantContactInfoResultMap")
    MerchantContactInfoDO selectOne(MerchantContactInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,contact_name,contact_phone,contact_email from t_merchant_contact_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='contactName != null'> contact_name = #{contactName} AND </if> "
            +"<if test='contactPhone != null'> contact_phone = #{contactPhone} AND </if> "
            +"<if test='contactEmail != null'> contact_email = #{contactEmail} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantContactInfoResultMap")
    List<MerchantContactInfoDO> selectList(MerchantContactInfoDO obj);

}

