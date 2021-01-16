package com.scenetec.upf.operation.repository.channel;

import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/05
 */
@Repository
@Mapper
public interface ChannelInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_channel_info (id,user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code,product_no,amount,join_type,front_url,back_url,trid,trtp,org_code,chn_fee_template_id,status,acc_no,user_code, channel_mer_no,channel_mer_name,channel_mer_short_name,channel_mer_category,channel_capital_source,channel_mer_name_dec)" +
            " values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{channelKey},#{channelName},#{channelCode},#{productNo},#{amount},#{joinType},#{frontUrl},#{backUrl},#{trid},#{trtp},#{orgCode},#{chnFeeTemplateId},#{status},#{accNo},#{userCode},#{channelMerNo},#{channelMerName},#{channelMerShortName},#{channelMerategory},#{channelCapitalSource},#{channelMerNameDec})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(ChannelInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_channel_info ("
                    +" user_create, gmt_create, user_modified, gmt_modified, channel_key, channel_name, channel_code, product_no, amount, join_type, front_url, back_url, trid, trtp, org_code, chn_fee_template_id, status,acc_no,user_code"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelKey}, #{item.channelName}, #{item.channelCode},  #{item.productNo}, #{item.amount},#{item.joinType}, #{item.frontUrl}, #{item.backUrl}, #{item.trid}, #{item.trtp}, #{item.orgCode}, #{item.chnFeeTemplateId}, #{item.status},#{item.accNo},#{item.userCode})"
                    +"</foreach>"
                    +"</script>"
    )
    int insertList(List<ChannelInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_channel_info ("
                    +" user_create, gmt_create, user_modified, gmt_modified, channel_key, channel_name, channel_code, product_no, join_type, front_url, back_url, trid, trtp, org_code, chn_fee_template_id, status"+ ",acc_no,user_code"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelKey}, #{item.channelName}, #{item.channelCode}, #{item.productNo}, #{item.joinType}, #{item.frontUrl}, #{item.backUrl}, #{item.trid}, #{item.trtp}, #{item.orgCode}, #{item.chnFeeTemplateId}, #{item.status},#{item.accNo},#{item.userCode})"
                    +"</foreach>"
                    +" ON DUPLICATE KEY UPDATE "
                    +"user_create = VALUES(user_create),"
                    +"gmt_create = VALUES(gmt_create),"
                    +"user_modified = VALUES(user_modified),"
                    +"gmt_modified = VALUES(gmt_modified),"
                    +"channel_key = VALUES(channel_key),"
                    +"channel_name = VALUES(channel_name),"
                    +"channel_code = VALUES(channel_code),"
                    +"product_no = VALUES(product_no),"
                    +"join_type = VALUES(join_type),"
                    +"front_url = VALUES(front_url),"
                    +"back_url = VALUES(back_url),"
                    +"trid = VALUES(trid),"
                    +"trtp = VALUES(trtp),"
                    +"org_code = VALUES(org_code),"
                    +"chn_fee_template_id = VALUES(chn_fee_template_id),"
                    +"status = VALUES(status)"
                    +"acc_no = VALUES(acc_no)"
                    +"user_code = VALUES(user_code)"
                    +"</script>"
    )
    int modifyList(List<ChannelInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_channel_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    +"update t_channel_info <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='channelKey != null'> channel_key = #{channelKey}, </if> "
                    +"<if test='channelName != null'> channel_name = #{channelName}, </if> "
                    +"<if test='channelCode != null'> channel_code = #{channelCode}, </if> "
                    +"<if test='productNo != null'> product_no = #{productNo}, </if> "
                    +"<if test='amount != null'> amount = #{amount}, </if> "
                    +"<if test='joinType != null'> join_type = #{joinType}, </if> "
                    +"<if test='frontUrl != null'> front_url = #{frontUrl}, </if> "
                    +"<if test='backUrl != null'> back_url = #{backUrl}, </if> "
                    +"<if test='trid != null'> trid = #{trid}, </if> "
                    +"<if test='trtp != null'> trtp = #{trtp}, </if> "
                    +"<if test='orgCode != null'> org_code = #{orgCode}, </if> "
                    +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId}, </if> "
                    +"<if test='status != null'> status = #{status}, </if> "
                    +"<if test='accNo != null'> acc_no = #{accNo}, </if> "
                    +"<if test='userCode != null'> user_code = #{userCode}, </if> "
                    +"<if test='channelMerNo != null'> channel_mer_no = #{channelMerNo}, </if> "
                    +"<if test='channelMerName != null'> channel_mer_name = #{channelMerName}, </if> "
                    +"<if test='channelMerShortName != null'> channel_mer_short_name = #{channelMerShortName}, </if> "
                    +"<if test='channelMerategory != null'> channel_mer_category = #{channelMerategory}, </if> "
                    +"<if test='channelCapitalSource != null'> channel_capital_source = #{channelCapitalSource}, </if> "
                    +"<if test='channelMerNameDec != null'> channel_mer_name_dec = #{channelMerNameDec}, </if> "
                    +"</set> where id = #{id}"
                    +"</script>"
    )
    int update(ChannelInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select id, channel_mer_no, user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code,product_no,(select name from t_pay_product where code=product_no) product_name,amount,join_type,front_url,back_url,trid,trtp,org_code,(select full_name from t_organization where org_code=ci.org_code) org_name," +
            "chn_fee_template_id,(select name from t_fee_template where id=chn_fee_template_id) chn_fee_template_name,status,acc_no,user_code,channel_mer_name,channel_mer_short_name,channel_mer_category,channel_capital_source,channel_mer_name_dec from t_channel_info ci where id = #{id}")
    @Results(id="ChannelInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "channelKey", column = "channel_key"),@Result(property = "channelName", column = "channel_name"),@Result(property = "channelCode", column = "channel_code"),
            @Result(property = "industryCode", column = "industry_code"),@Result(property = "productNo", column = "product_no"),@Result(property = "amount", column = "amount"),@Result(property = "productName", column = "product_name"),@Result(property = "joinType", column = "join_type"),@Result(property = "frontUrl", column = "front_url"),@Result(property = "backUrl", column = "back_url"),@Result(property = "trid", column = "trid"),@Result(property = "trtp", column = "trtp"),
            @Result(property = "orgCode", column = "org_code"),@Result(property = "orgName", column = "org_name"),@Result(property = "chnFeeTemplateId", column = "chn_fee_template_id"),@Result(property = "chnFeeTemplateName", column = "chn_fee_template_name"),@Result(property = "status", column = "status"),@Result(property = "accNo", column = "acc_no"),@Result(property = "userCode", column = "user_code"),@Result(property = "channelMerNo", column = "channel_mer_no"),
            @Result(property = "channelMerName", column = "channel_mer_name"),@Result(property = "channelMerShortName", column = "channel_mer_short_name"),@Result(property = "channelMerategory", column = "channel_mer_category"),@Result(property = "channelCapitalSource", column = "channel_capital_source"),@Result(property = "channelMerNameDec", column = "channel_mer_name_dec")})
    ChannelInfoDO getById(@Param("id") Long id);

    @Select("select channel_name from t_channel_info where channel_code = #{channelCode}")
    @ResultMap("ChannelInfoResultMap")
    ChannelInfoDO getByChannelCode(@Param("channelCode") String channelCode);
    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,channel_mer_name,channel_mer_short_name,channel_mer_category,channel_capital_source, channel_mer_no, user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code," +
                    "product_no,(select name from t_pay_product where code=product_no) product_name,amount,join_type,front_url,back_url,trid,trtp," +
                    "org_code,(select full_name from t_organization where org_code=ci.org_code) org_name," +
                    "chn_fee_template_id,(select name from t_fee_template where id=chn_fee_template_id) chn_fee_template_name,status,acc_no,user_code from t_channel_info ci where 1 = 1"
                    + "<if test='params.channelName != null '> and channel_name like concat('%',#{params.channelName},'%')</if>"
                    + "<if test='params.channelMerNo != null '> and  channel_mer_no like concat('%',#{params.channelMerNo},'%')</if>"
                    + "<if test='params.channelCode != null '> and channel_code = #{params.channelCode}</if>"
                    + "<if test='params.productNo != null '> and product_no = #{params.productNo}</if>"
                    + "<if test='params.status != null '> and status = #{params.status}</if>"
//                    + "<if test='params.channelMerNo != null '> and channel_mer_no = #{params.channelMerNo}</if>"
                    +"order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    Page<ChannelInfoDO> pageList(@Param("params") Map<String, Object> params);

//    /**
//     * 查询列表(分页)  通过产品获取产品关联的渠道，一个产品可以对应多个渠道
//     * @param params
//     * @return
//     */
//    @Select(
//            "<script>"
//                    + "select * from t_channel_info ci where 1 = 1"
//                    + "<if test='params.channelCode != null '> and channel_code like concat('%',#{params.channelCode},'%')</if>"
//                    + "<if test='params.channelName != null '> and channel_name = #{params.channelName}</if>"
//                    + "<if test='params.productNo != null '> and product_no = #{params.productNo}</if>"
//                    + "<if test='params.status != null '> and status = #{params.status}</if>"
//                    +"order by gmt_modified desc ,gmt_create desc"
//                    + "</script>"
//    )
//    @ResultMap("ChannelInfoResultMap")
//    Page<ChannelInfoDO> pageListDistinct(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(无分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, channel_mer_no, user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code," +
                    "product_no,(select name from t_pay_product where code=product_no) product_name,amount,join_type,front_url,back_url,trid,trtp," +
                    "org_code,(select full_name from t_organization where org_code=ci.org_code) org_name," +
                    "chn_fee_template_id,(select name from t_fee_template where id=chn_fee_template_id) chn_fee_template_name,status,acc_no,user_code from t_channel_info ci where 1 = 1"
                    + "<if test='params.channelCode != null '> and channel_code like concat('%',#{params.channelCode},'%')</if>"
                    + "<if test='params.channelName != null '> and channel_name = #{params.channelName}</if>"
                    + "<if test='params.productNo != null '> and product_no = #{params.productNo}</if>"
                    + "<if test='params.status != null '> and status = #{params.status}</if>"
                    + "<if test='params. channelMerNo != null '> and  channel_mer_no like concat('%',#{params. channelMerNo},'%')</if>"
                    + "</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    List<ChannelInfoDO> list(@Param("params") Map<String, Object> params);



    /**
     * 代付客户管理，添加关联--》 过滤已经被选过的渠道
     * 获取商户号列表的条件：product_no,channel_key 获取到对应的商户列表--》同时过滤掉已经选过的对应商户号）
     * @param
     * @return
     */
    @Select(
            "<script>"

                    +"select ci.* from t_channel_info ci where 1 = 1"
                    + "<if test='params.channelKey != null '> and ci.channel_key = #{params.channelKey}</if>"
                    + "<if test='params.productNo != null '> and ci.product_no = #{params.productNo}</if>"
                    +"and ci.channel_mer_no not in (select channel_mer_no from t_channel_industry where 1=1"
                    + "<if test='params.industryCode != null '> and industry_code = #{params.industryCode}</if>"
                    +")"
                    + "</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    List<ChannelInfoDO> channelMerNoList(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"

                    +"select ci.* from t_channel_info ci where 1 = 1"
                    + "<if test='params.channelKey != null '> and ci.channel_key = #{params.channelKey}</if>"
                    + "<if test='params.productNo != null '> and ci.product_no = #{params.productNo}</if>"
                    +"and ci.channel_key not in (select channel_key from t_channel_industry where 1=1"
                    + "<if test='params.industryCode != null '> and industry_code = #{params.industryCode}</if>"
                    +")"
                    +"group by ci.channel_key"
                    + "</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    List<ChannelInfoDO> filterList(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_channel_info <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                    +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
                    +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
                    +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
                    +"<if test='joinType != null'> join_type = #{joinType} AND </if> "
                    +"<if test='frontUrl != null'> front_url = #{frontUrl} AND </if> "
                    +"<if test='backUrl != null'> back_url = #{backUrl} AND </if> "
                    +"<if test='trid != null'> trid = #{trid} AND </if> "
                    +"<if test='trtp != null'> trtp = #{trtp} AND </if> "
                    +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int count(ChannelInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code,product_no,join_type,front_url,back_url,trid,trtp,org_code,chn_fee_template_id,status,acc_no,user_code from t_channel_info"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='id != null and id>0'> id = #{id} AND </if>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                    +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
                    +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
                    +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
                    +"<if test='joinType != null'> join_type = #{joinType} AND </if> "
                    +"<if test='frontUrl != null'> front_url = #{frontUrl} AND </if> "
                    +"<if test='backUrl != null'> back_url = #{backUrl} AND </if> "
                    +"<if test='trid != null'> trid = #{trid} AND </if> "
                    +"<if test='trtp != null'> trtp = #{trtp} AND </if> "
                    +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    ChannelInfoDO selectOne(ChannelInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, channel_mer_no, user_create,gmt_create,user_modified,gmt_modified,channel_key,channel_name,channel_code,product_no,amount,join_type,front_url,back_url,trid,trtp,org_code,chn_fee_template_id,status,acc_no,user_code from t_channel_info"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                    +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
                    +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
                    +"<if test='productNo != null'> product_no = #{productNo} AND </if> "
                    +"<if test='joinType != null'> join_type = #{joinType} AND </if> "
                    +"<if test='frontUrl != null'> front_url = #{frontUrl} AND </if> "
                    +"<if test='backUrl != null'> back_url = #{backUrl} AND </if> "
                    +"<if test='trid != null'> trid = #{trid} AND </if> "
                    +"<if test='trtp != null'> trtp = #{trtp} AND </if> "
                    +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    +"<if test='chnFeeTemplateId != null'> chn_fee_template_id = #{chnFeeTemplateId} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='params. channelMerNo != null '> and  channel_mer_no like concat('%',#{params. channelMerNo},'%')</if>"
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("ChannelInfoResultMap")
    List<ChannelInfoDO> selectList(ChannelInfoDO obj);

}

