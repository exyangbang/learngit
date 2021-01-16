package com.scenetec.upf.operation.repository.account;

import com.scenetec.upf.operation.model.domain.account.FundAcctInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/08/07
 */
@Repository
@Mapper
public interface FundAcctInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into fund_acct_info (industry_code,fund_acct,fund_acct_name) values (#{industryCode},#{fundAcct},#{fundAcctName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(FundAcctInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into fund_acct_info ("
        +" industry_code, fund_acct, fund_acct_name"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.industryCode}, #{item.fundAcct}, #{item.fundAcctName})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<FundAcctInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into fund_acct_info ("
        +" industry_code, fund_acct, fund_acct_name"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.industryCode}, #{item.fundAcct}, #{item.fundAcctName})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"industry_code = VALUES(industry_code),"
            +"fund_acct = VALUES(fund_acct),"
            +"fund_acct_name = VALUES(fund_acct_name)"
        +"</script>"
    )
    int modifyList(List<FundAcctInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from fund_acct_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update fund_acct_info <set> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='fundAcct != null'> fund_acct = #{fundAcct}, </if> "
            +"<if test='fundAcctName != null'> fund_acct_name = #{fundAcctName}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(FundAcctInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, industry_code,fund_acct,fund_acct_name from fund_acct_info where id = #{id}")
 	@Results(id="FundAcctInfoResultMap", value = {@Result(property = "id", column = "id"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "fundAcct", column = "fund_acct"),@Result(property = "fundAcctName", column = "fund_acct_name")})
 	FundAcctInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, industry_code,fund_acct,fund_acct_name from fund_acct_info where 1 = 1"
        + "</script>"
    )
    @ResultMap("FundAcctInfoResultMap")
    Page<FundAcctInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from fund_acct_info <where> <trim suffixOverrides='AND'>"
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='fundAcct != null'> fund_acct = #{fundAcct} AND </if> "
            +"<if test='fundAcctName != null'> fund_acct_name = #{fundAcctName} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(FundAcctInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, industry_code,fund_acct,fund_acct_name from fund_acct_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='fundAcct != null'> fund_acct = #{fundAcct} AND </if> "
            +"<if test='fundAcctName != null'> fund_acct_name = #{fundAcctName} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FundAcctInfoResultMap")
    FundAcctInfoDO selectOne(FundAcctInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,industry_code,fund_acct,fund_acct_name from fund_acct_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='fundAcct != null'> fund_acct = #{fundAcct} AND </if> "
            +"<if test='fundAcctName != null'> fund_acct_name = #{fundAcctName} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FundAcctInfoResultMap")
    List<FundAcctInfoDO> selectList(FundAcctInfoDO obj);

}

