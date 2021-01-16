package com.scenetec.upf.operation.repository.merchant;

import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
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
public interface MerchantAccountInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_account_info (user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name,receive_bank_code) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{accountType},#{accountNo},#{accountName},#{bankCode},#{bankName},#{receiveBankCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(MerchantAccountInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_account_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, account_type, account_no, account_name, bank_code, bank_name, receive_bank_code"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.accountType}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.bankName}, #{item.receiveBankCode})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<MerchantAccountInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_account_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, account_type, account_no, account_name, bank_code, bank_name, receive_bank_code"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.accountType}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.bankName}, #{item.receiveBankCode})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"mer_no = VALUES(mer_no),"
            +"account_type = VALUES(account_type),"
            +"account_no = VALUES(account_no),"
            +"account_name = VALUES(account_name),"
            +"bank_code = VALUES(bank_code),"
            +"bank_name = VALUES(bank_name),"
            +"receive_bank_code = VALUES(receive_bank_code)"
        +"</script>"
    )
    int modifyList(List<MerchantAccountInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_account_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_account_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='accountType != null'> account_type = #{accountType}, </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo}, </if> "
            +"<if test='accountName != null'> account_name = #{accountName}, </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
            +"<if test='bankName != null'> bank_name = #{bankName}, </if> "
            +"<if test='receiveBankCode != null'> receive_bank_code = #{receiveBankCode}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(MerchantAccountInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name,receive_bank_code from t_merchant_account_info where id = #{id}")
 	@Results(id="MerchantAccountInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "merNo", column = "mer_no"),@Result(property = "accountType", column = "account_type"),@Result(property = "accountNo", column = "account_no"),@Result(property = "accountName", column = "account_name"),@Result(property = "bankCode", column = "bank_code"),@Result(property = "bankName", column = "bank_name"),@Result(property = "receiveBankCode", column = "receive_bank_code"),@Result(property = "bindStatus", column = "bind_status")})
 	MerchantAccountInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id,bind_status,account, user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name,receive_bank_code from t_merchant_account_info where 1 = 1"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
		        + "<if test='params.accountType != null'> and account_type = #{params.accountType}</if>"
		        + "<if test='params.account != null'> and account = #{params.account}</if>"
		        + "<if test='params.bindStatus != null'> and bind_status = #{params.bindStatus}</if>"
        + "</script>"
    )
    @ResultMap("MerchantAccountInfoResultMap")
    Page<MerchantAccountInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_account_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='accountType != null'> account_type = #{accountType} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='receiveBankCode != null'> receive_bank_code = #{receiveBankCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(MerchantAccountInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name,receive_bank_code from t_merchant_account_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='accountType != null'> account_type = #{accountType} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='receiveBankCode != null'> receive_bank_code = #{receiveBankCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantAccountInfoResultMap")
    MerchantAccountInfoDO selectOne(MerchantAccountInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,account, user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name,receive_bank_code from t_merchant_account_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='accountType != null'> account_type = #{accountType} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='receiveBankCode != null'> receive_bank_code = #{receiveBankCode} AND </if> "
        +"</trim></where> "
                +" order by gmt_create desc"
        +"</script>"
    )
    @ResultMap("MerchantAccountInfoResultMap")
    List<MerchantAccountInfoDO> selectList(MerchantAccountInfoDO obj);

}

