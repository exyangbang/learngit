package com.scenetec.upf.operation.repository.electronicreceipt;

import com.scenetec.upf.operation.model.domain.electronicreceipt.ElectronicReceiptDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/03/19
 */
@Repository
@Mapper
public interface ElectronicReceiptMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_electronic_receipt (user_create,gmt_create,user_modified,gmt_modified,order_no,md5_hex,params,file_content,server_trans_id,trade_type,client_trans_id,industry_code) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{orderNo},#{md5Hex},#{params},#{fileContent},#{serverTransId},#{tradeType},#{clientTransId},#{industryCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ElectronicReceiptDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_electronic_receipt ("
        +" user_create, gmt_create, user_modified, gmt_modified, order_no, md5_hex, params, file_content, server_trans_id, trade_type, client_trans_id, industry_code"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.orderNo}, #{item.md5Hex}, #{item.params}, #{item.fileContent}, #{item.serverTransId}, #{item.tradeType}, #{item.clientTransId}, #{item.industryCode})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ElectronicReceiptDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_electronic_receipt ("
        +" user_create, gmt_create, user_modified, gmt_modified, order_no, md5_hex, params, file_content, server_trans_id, trade_type, client_trans_id, industry_code"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.orderNo}, #{item.md5Hex}, #{item.params}, #{item.fileContent}, #{item.serverTransId}, #{item.tradeType}, #{item.clientTransId}, #{item.industryCode})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"order_no = VALUES(order_no),"
            +"md5_hex = VALUES(md5_hex),"
            +"params = VALUES(params),"
            +"file_content = VALUES(file_content),"
            +"server_trans_id = VALUES(server_trans_id),"
            +"trade_type = VALUES(trade_type),"
            +"client_trans_id = VALUES(client_trans_id),"
            +"industry_code = VALUES(industry_code)"
        +"</script>"
    )
    int modifyList(List<ElectronicReceiptDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_electronic_receipt where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_electronic_receipt <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='orderNo != null'> order_no = #{orderNo}, </if> "
            +"<if test='md5Hex != null'> md5_hex = #{md5Hex}, </if> "
            +"<if test='params != null'> params = #{params}, </if> "
            +"<if test='fileContent != null'> file_content = #{fileContent}, </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType}, </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ElectronicReceiptDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,order_no,md5_hex,params,file_content,server_trans_id,trade_type,client_trans_id,industry_code from t_electronic_receipt where id = #{id}")
 	@Results(id="ElectronicReceiptResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "orderNo", column = "order_no"),@Result(property = "md5Hex", column = "md5_hex")
            ,@Result(property = "params", column = "params"),@Result(property = "filePath", column = "file_path"),@Result(property = "fileContent", column = "file_content"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "industryCode", column = "industry_code")})
 	ElectronicReceiptDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,order_no,md5_hex,params,file_content,server_trans_id,trade_type,client_trans_id,industry_code from t_electronic_receipt where 1 = 1"
		        + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
		        + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
		        + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
        + "</script>"
    )
    @ResultMap("ElectronicReceiptResultMap")
    Page<ElectronicReceiptDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_electronic_receipt <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orderNo != null'> order_no = #{orderNo} AND </if> "
            +"<if test='md5Hex != null'> md5_hex = #{md5Hex} AND </if> "
            +"<if test='params != null'> params = #{params} AND </if> "
            +"<if test='fileContent != null'> file_content = #{fileContent} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ElectronicReceiptDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,order_no,md5_hex,params,file_content,server_trans_id,trade_type,client_trans_id,industry_code,file_path from t_electronic_receipt"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orderNo != null'> order_no = #{orderNo} AND </if> "
            +"<if test='md5Hex != null'> md5_hex = #{md5Hex} AND </if> "
            +"<if test='params != null'> params = #{params} AND </if> "
            +"<if test='fileContent != null'> file_content = #{fileContent} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ElectronicReceiptResultMap")
    ElectronicReceiptDO selectOne(ElectronicReceiptDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,order_no,md5_hex,params,file_content,server_trans_id,trade_type,client_trans_id,industry_code from t_electronic_receipt"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orderNo != null'> order_no = #{orderNo} AND </if> "
            +"<if test='md5Hex != null'> md5_hex = #{md5Hex} AND </if> "
            +"<if test='params != null'> params = #{params} AND </if> "
            +"<if test='fileContent != null'> file_content = #{fileContent} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ElectronicReceiptResultMap")
    List<ElectronicReceiptDO> selectList(ElectronicReceiptDO obj);

}

