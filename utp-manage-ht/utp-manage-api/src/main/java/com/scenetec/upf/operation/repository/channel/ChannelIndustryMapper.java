package com.scenetec.upf.operation.repository.channel;

import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/10/31
 */
@Repository
@Mapper
public interface ChannelIndustryMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_channel_industry (id,user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,industry_code,ind_fee_template_id,chn_fee_template_id,roof_placement,channel_key,channel_mer_no,public_fee_template_id,private_fee_template_id) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{channelCode},#{productNo},#{industryCode},#{indFeeTemplateId},#{chnFeeTemplateId},#{roofPlacement},#{channelKey},#{channelMerNo},#{publicFeeTemplateId},#{privateFeeTemplateId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ChannelIndustryDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_industry ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, product_no, industry_code, ind_fee_template_id,roof_placement, chn_fee_template_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.productNo}, #{item.industryCode}, #{item.indFeeTemplateId},#{item.roofPlacement}, #{item.chnFeeTemplateId})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ChannelIndustryDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_industry ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, product_no, industry_code, ind_fee_template_id,roof_placement, chn_fee_template_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.productNo}, #{item.industryCode}, #{item.indFeeTemplateId},#{item.roofPlacement}, #{item.chnFeeTemplateId})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"channel_code = VALUES(channel_code),"
            +"product_no = VALUES(product_no),"
            +"industry_code = VALUES(industry_code),"
            +"ind_fee_template_id = VALUES(ind_fee_template_id),"
            +"roof_placement = VALUES(roof_placement),"

            +"chn_fee_template_id = VALUES(chn_fee_template_id)"
        +"</script>"
    )
    int modifyList(List<ChannelIndustryDO> obj);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from t_channel_industry where id = #{id}")
    int delete(Long id);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
//    @Delete("update t_channel_industry set status=0 where id = #{id}")
//    int deleteLogic(Long id);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_channel_industry <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode}, </if> "
            +"<if test='productNo != null'> product_no = #{productNo}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='indFeeTemplateId != null'> ind_fee_template_id = #{indFeeTemplateId}, </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId}, </if> "
            +"<if test='roofPlacement != null'> roof_placement = #{roofPlacement}, </if> "
            +"<if test='publicFeeTemplateId != null'> public_fee_template_id = #{publicFeeTemplateId}, </if> "
            +"<if test='privateFeeTemplateId != null'> private_fee_template_id = #{privateFeeTemplateId}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ChannelIndustryDO obj);

    @Update(
            "<script>"
                    +"update t_channel_industry <set> "
                    +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId}, </if> "
                    +"</set> where channel_code = #{channelCode}"
                    +"</script>"
    )
    int updateChannelFee(ChannelIndustryDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select chind.id,chind.channel_mer_no, chind.user_create,chind.gmt_create,chind.user_modified,chind.gmt_modified,chind.channel_code,chind.product_no,chind.industry_code,chind.ind_fee_template_id,chind.chn_fee_template_id" +
            ",fe.name as ind_fee_template_name,fe1.name as public_fee_template_name,fe2.name as private_fee_template_name,chind.roof_placement," +
            "ch.channel_name,ch.channel_mer_name,ch.channel_mer_short_name,ch.channel_mer_category,ch.channel_capital_source,ch.channel_mer_name_dec " +
            "from t_channel_industry chind" +
            " left join t_fee_template fe on fe.id = chind.ind_fee_template_id "+
            "left join t_fee_template fe1 on fe1.id = chind.public_fee_template_id "+
            "left join t_fee_template fe2 on fe2.id = chind.private_fee_template_id "+
            "left join t_channel_info ch on ch.channel_code = chind.channel_code "+
            " where chind.id = #{id}")
 	@Results(id="ChannelIndustryResultMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "userCreate", column = "user_create" )
        ,        @Result(property = "gmtCreate", column = "gmt_create" )
        ,        @Result(property = "userModified", column = "user_modified" )
        ,        @Result(property = "gmtModified", column = "gmt_modified" )
        ,        @Result(property = "channelCode", column = "channel_code" )
        ,        @Result(property = "productNo", column = "product_no" )
        ,        @Result(property = "industryCode", column = "industry_code" )
        ,        @Result(property = "indFeeTemplateId", column = "ind_fee_template_id" )
        ,        @Result(property = "chnFeeTemplateId", column = "chn_fee_template_id" )
        ,        @Result(property = "industryName", column = "industry_name" )
        ,        @Result(property = "productName", column = "product_name" )
        ,        @Result(property = "indFeeTemplateName", column = "ind_fee_template_name" )
        ,        @Result(property = "roofPlacement", column = "roof_placement" )
        ,        @Result(property = "channelName", column = "channel_name" )
        ,        @Result(property = "channelKey", column = "channel_key" )
        ,        @Result(property = "channelMerNo", column = "channel_mer_no" )
        ,        @Result(property = "publicFeeTemplateId", column = "public_fee_template_id" )
        ,        @Result(property = "privateFeeTemplateId", column = "private_fee_template_id" )
        ,        @Result(property = "publicFeeTemplateName", column = "public_fee_template_name" )
        ,        @Result(property = "privateFeeTemplateName", column = "private_fee_template_name" )
        ,        @Result(property = "channelMerName", column = "channel_mer_name" )
        ,        @Result(property = "channelMerShortName", column = "channel_mer_short_name" )
        ,        @Result(property = "channelMerategory", column = "channel_mer_category" )
        ,        @Result(property = "channelCapitalSource", column = "channel_capital_source" )
        ,        @Result(property = "channelMerNameDec", column = "channel_mer_name_dec" )

        }
    )
 	ChannelIndustryDO getById(@Param("id") Long id);

//    @Select("select chind.id,chind.channel_mer_no, chind.user_create,chind.gmt_create,chind.user_modified,chind.gmt_modified,chind.channel_code,chind.product_no,chind.industry_code,chind.ind_fee_template_id,chind.chn_fee_template_id,(select name from t_fee_template where id=chind.ind_fee_template_id) ind_fee_template_name,chind.roof_placement,(select channel_name from t_channel_info where channel_code=chind.channel_code LIMIT 1) channel_name from t_channel_industry chind where chind.id = #{id}")
//    @Results(id="ChannelIndustryResultMap", value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "userCreate", column = "user_create" )
//            ,        @Result(property = "gmtCreate", column = "gmt_create" )
//            ,        @Result(property = "userModified", column = "user_modified" )
//            ,        @Result(property = "gmtModified", column = "gmt_modified" )
//            ,        @Result(property = "channelCode", column = "channel_code" )
//            ,        @Result(property = "productNo", column = "product_no" )
//            ,        @Result(property = "industryCode", column = "industry_code" )
//            ,        @Result(property = "indFeeTemplateId", column = "ind_fee_template_id" )
//            ,        @Result(property = "chnFeeTemplateId", column = "chn_fee_template_id" )
//            ,        @Result(property = "industryName", column = "industry_name" )
//            ,        @Result(property = "productName", column = "product_name" )
//            ,        @Result(property = "indFeeTemplateName", column = "ind_fee_template_name" )
//            ,        @Result(property = "roofPlacement", column = "roof_placement" )
//            ,        @Result(property = "channelName", column = "channel_name" )
//            ,        @Result(property = "channelKey", column = "channel_key" )
//            ,        @Result(property = "channelMerNo", column = "channel_mer_no" )
//            ,        @Result(property = "publicFeeTemplateId", column = "public_fee_template_id" )
//            ,        @Result(property = "privateFeeTemplateId", column = "private_fee_template_id" )
//
//    }
//    )
//    ChannelIndustryDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select chind.id, chind.user_create,chind.gmt_create,chind.user_modified,chind.gmt_modified,chind.channel_code,chind.product_no" +
//                ",(select name from t_pay_product where code=product_no LIMIT 1) product_name" +
                ",chind.industry_code," +
//                "(select name from t_industry where code=industry_code LIMIT 1) industry_name," +
                "chind.ind_fee_template_id," +
                "fe.name as ind_fee_template_name,fe1.name as public_fee_template_name,fe2.name as private_fee_template_name,chind.chn_fee_template_id" +
                ",roof_placement,public_fee_template_id,private_fee_template_id from t_channel_industry chind " +
                " left join t_fee_template fe on fe.id = chind.ind_fee_template_id "+
                "left join t_fee_template fe1 on fe1.id = chind.public_fee_template_id "+
                "left join t_fee_template fe2 on fe2.id = chind.private_fee_template_id "
+"                  where 1 = 1"
		        + "<if test='params.channelCode != null'> and chind.channel_code = #{params.channelCode}</if>"
		        + "<if test='params.industryCode != null'> and chind.industry_code = #{params.industryCode}</if>"
		        + "<if test='params.productNo != null'> and chind.product_no = #{params.productNo}</if>"
        + "</script>"
    )
    @ResultMap("ChannelIndustryResultMap")
    Page<ChannelIndustryDO> pageList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页) 代付客户管理--》关联--》分组（支付产品）--》多个渠道
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,(select name from t_pay_product where code=product_no) product_name,industry_code,ind_fee_template_id,chn_fee_template_id" +
                    ",roof_placement,public_fee_template_id,private_fee_template_id from t_channel_industry where 1 = 1"
                    + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.productNo != null'> and product_no = #{params.productNo}</if>"

                    +"group by product_no"
                    + "</script>"
    )
    @ResultMap("ChannelIndustryResultMap")
    Page<ChannelIndustryDO> pageListGroup(@Param("params") Map<String, Object> params);
//    @Select(
//            "<script>"
//                    + "select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,(select name from t_pay_product where code=product_no) product_name,industry_code,(select name from t_industry where code=industry_code) industry_name,ind_fee_template_id,(select name from t_fee_template where id=ind_fee_template_id) ind_fee_template_name,chn_fee_template_id,roof_placement from t_channel_industry where 1 = 1"
//                    + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
//                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
//                    + "<if test='params.productNo != null'> and product_no = #{params.productNo}</if>"
//
//                    +"group by product_no"
//                    + "</script>"
//    )
//    @ResultMap("ChannelIndustryResultMap")
//    Page<ChannelIndustryDO> pageListGroup(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
            + "select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,industry_code,ind_fee_template_id,chn_fee_template_id,roof_placement,public_fee_template_id,private_fee_template_id from t_channel_industry where 1 = 1"
                + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
                + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                + "<if test='params.productNo != null'> and product_no = #{params.productNo}</if>"


        + "</script>"
    )
    @ResultMap("ChannelIndustryResultMap")
    List<ChannelIndustryDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_channel_industry <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='indFeeTemplateId != null'> ind_fee_template_id = #{indFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
            +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ChannelIndustryDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,industry_code,ind_fee_template_id,chn_fee_template_id,roof_placement,public_fee_template_id,private_fee_template_id from t_channel_industry"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='indFeeTemplateId != null'> ind_fee_template_id = #{indFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelIndustryResultMap")
    ChannelIndustryDO selectOne(ChannelIndustryDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,product_no,industry_code,ind_fee_template_id,chn_fee_template_id,roof_placement from t_channel_industry"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='indFeeTemplateId != null'> ind_fee_template_id = #{indFeeTemplateId} AND </if> "
            +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "


        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelIndustryResultMap")
    List<ChannelIndustryDO> selectList(ChannelIndustryDO obj);

    @Update(
            "update t_channel_industry set roof_placement=#{roofPlacement} where id = #{id}"
    )
    int updateRoofPlacement(Long id,Long roofPlacement);
}

