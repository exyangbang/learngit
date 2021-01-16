package com.scenetec.upf.operation.repository.whitelist;

import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/01/28
 */
@Repository
@Mapper
public interface WhiteListMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_white_list (id,user_create,gmt_create,user_modified,gmt_modified,mer_name,mer_abb,industry_code,account_name,fund_account) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merName},#{merAbb},#{industryCode},#{accountName},#{fundAccount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(WhiteListDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_white_list ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_name, mer_abb, industry_code, account_name"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merName}, #{item.merAbb}, #{item.industryCode}, #{item.accountName})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<WhiteListDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_white_list ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_name, mer_abb, industry_code, account_name"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merName}, #{item.merAbb}, #{item.industryCode}, #{item.accountName})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"mer_name = VALUES(mer_name),"
            +"mer_abb = VALUES(mer_abb),"
            +"industry_code = VALUES(industry_code),"
            +"account_name = VALUES(account_name)"
        +"</script>"
    )
    int modifyList(List<WhiteListDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_white_list where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_white_list <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='merName != null'> mer_name = #{merName}, </if> "
            +"<if test='merAbb != null'> mer_abb = #{merAbb}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='accountName != null'> account_name = #{accountName}, </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(WhiteListDO obj);

    @Update(
            "<script>"
                    +"update t_white_list <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='merName != null'> mer_name = #{merName}, </if> "
                    +"<if test='merAbb != null'> mer_abb = #{merAbb}, </if> "
                    +"<if test='accountName != null'> account_name = #{accountName}, </if> "
                    +"</set> where industry_code = #{industryCode}"
                    +"</script>"
    )
    int updateByIndustryCode(WhiteListDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select * from t_white_list where id = #{id}")
 	@Results(id="WhiteListResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "merName", column = "mer_name"),@Result(property = "merAbb", column = "mer_abb"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "accountName", column = "account_name"),@Result(property = "fundAccount", column = "fund_account")})
 	WhiteListDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,mer_name,mer_abb,industry_code,account_name from t_white_list where 1 = 1"
        + "</script>"
    )
    @ResultMap("WhiteListResultMap")
    Page<WhiteListDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_white_list <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='merAbb != null'> mer_abb = #{merAbb} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(WhiteListDO obj);

    /**
     * 查询总数 查看不是自己的账号的信息是否存在
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_white_list <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='merName != null'> mer_name = #{merName} AND </if> "
                    +"<if test='merAbb != null'> mer_abb = #{merAbb} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    +"<if test='id != null'> id != #{id} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countChekckId(WhiteListDO obj);
    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,fund_account, user_create,gmt_create,user_modified,gmt_modified,mer_name,mer_abb,industry_code,account_name from t_white_list"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='merAbb != null'> mer_abb = #{merAbb} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("WhiteListResultMap")
    WhiteListDO selectOne(WhiteListDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_name,mer_abb,industry_code,account_name from t_white_list"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='merAbb != null'> mer_abb = #{merAbb} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("WhiteListResultMap")
    List<WhiteListDO> selectList(WhiteListDO obj);

    /**
     * 查询列表(分页)  条件查询
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_white_list"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.userCreate != null'> user_create = #{params.userCreate} AND </if> "
                    +"<if test='params.gmtCreate != null'> gmt_create = #{params.gmtCreate} AND </if> "
                    +"<if test='params.userModified != null'> user_modified = #{params.userModified} AND </if> "
                    +"<if test='params.gmtModified != null'> gmt_modified = #{params.gmtModified} AND </if> "
                    +"<if test='params.merName != null'> mer_name like concat('%',#{params.merName},'%') AND </if> "
                    +"<if test='params.merAbb != null'> mer_abb = #{params.merAbb} AND </if> "
                    +"<if test='params.industryCode != null'> industry_code = #{params.industryCode} AND </if> "
                    +"<if test='params.accountName != null'> account_name like concat('%',#{params.accountName},'%') AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("WhiteListResultMap")
    Page<WhiteListDO> listPage(@Param("params") Map<String, Object> params);


}

