package com.scenetec.upf.operation.repository.channel;

import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
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
public interface ChannelMerchantMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_channel_merchant (id,user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,mer_no,mer_fee_template_id,chn_fee_template_id) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{channelCode},#{productNo},#{merNo},#{merFeeTemplateId},#{chnFeeTemplateId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ChannelMerchantDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_merchant ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, product_no, mer_no, mer_fee_template_id, chn_fee_template_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.productNo}, #{item.merNo}, #{item.merFeeTemplateId}, #{item.chnFeeTemplateId})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ChannelMerchantDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_merchant ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, product_no, mer_no, mer_fee_template_id, chn_fee_template_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.productNo}, #{item.merNo}, #{item.merFeeTemplateId}, #{item.chnFeeTemplateId})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"channel_code = VALUES(channel_code),"
            +"product_no = VALUES(product_no),"
            +"mer_no = VALUES(mer_no),"
            +"mer_fee_template_id = VALUES(mer_fee_template_id),"
            +"chn_fee_template_id = VALUES(chn_fee_template_id)"
        +"</script>"
    )
    int modifyList(List<ChannelMerchantDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_channel_merchant where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_channel_merchant <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode}, </if> "
            +"<if test='productNo != null'> product_no = #{productNo}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='merFeeTemplateId != null'> mer_fee_template_id = #{merFeeTemplateId}, </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ChannelMerchantDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,mer_no,mer_fee_template_id,(select name from t_fee_template where id=mer_fee_template_id) mer_fee_template_name,chn_fee_template_id from t_channel_merchant where id = #{id}")
 	@Results(id="ChannelMerchantResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "channelCode", column = "channel_code"),@Result(property = "productNo", column = "product_no"),@Result(property = "productName", column = "product_name"),@Result(property = "merNo", column = "mer_no"),@Result(property = "merName", column = "mer_name"),@Result(property = "merFeeTemplateId", column = "mer_fee_template_id"),@Result(property = "merFeeTemplateName", column = "mer_fee_template_name"),@Result(property = "merFeeTemplateName", column = "mer_fee_template_name"),@Result(property = "chnFeeTemplateId", column = "chn_fee_template_id")})
 	ChannelMerchantDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,(select name from t_pay_product where code=product_no) product_name,mer_no,(select mer_name from t_merchant_info where mer_no=cm.mer_no) mer_name,mer_fee_template_id,chn_fee_template_id,(select name from t_fee_template where id=mer_fee_template_id) mer_fee_template_name from t_channel_merchant cm where 1 = 1"
		        + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
		        + "<if test='params.productNo != null'> and product_no = #{params.productNo}</if>"
        + "</script>"
    )
    @ResultMap("ChannelMerchantResultMap")
    Page<ChannelMerchantDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_channel_merchant <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='merFeeTemplateId != null'> mer_fee_template_id = #{merFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ChannelMerchantDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,mer_no,mer_fee_template_id,chn_fee_template_id from t_channel_merchant"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='merFeeTemplateId != null'> mer_fee_template_id = #{merFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelMerchantResultMap")
    ChannelMerchantDO selectOne(ChannelMerchantDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,mer_no,mer_fee_template_id,chn_fee_template_id from t_channel_merchant"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='merFeeTemplateId != null'> mer_fee_template_id = #{merFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelMerchantResultMap")
    List<ChannelMerchantDO> selectList(ChannelMerchantDO obj);

}

