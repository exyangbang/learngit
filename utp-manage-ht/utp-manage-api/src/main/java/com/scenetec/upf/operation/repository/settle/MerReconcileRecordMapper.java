package com.scenetec.upf.operation.repository.settle;

import com.scenetec.upf.operation.model.domain.settle.MerReconcileRecordDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/19
 */
@Repository
@Mapper
public interface MerReconcileRecordMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_reconcile_record (id,user_create,gmt_create,user_modified,gmt_modified,reconcile_date,mer_no,reconcile_status) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{reconcileDate},#{merNo},#{reconcileStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(MerReconcileRecordDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_reconcile_record ("
        +" user_create, gmt_create, user_modified, gmt_modified, reconcile_date, mer_no, reconcile_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.reconcileDate}, #{item.merNo}, #{item.reconcileStatus})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<MerReconcileRecordDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_reconcile_record ("
        +" user_create, gmt_create, user_modified, gmt_modified, reconcile_date, mer_no, reconcile_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.reconcileDate}, #{item.merNo}, #{item.reconcileStatus})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"reconcile_date = VALUES(reconcile_date),"
            +"mer_no = VALUES(mer_no),"
            +"reconcile_status = VALUES(reconcile_status)"
        +"</script>"
    )
    int modifyList(List<MerReconcileRecordDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_reconcile_record where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_reconcile_record <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(MerReconcileRecordDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,reconcile_date,mer_no,reconcile_status from t_merchant_reconcile_record where id = #{id}")
 	@Results(id="MerReconcileRecordResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "channelKey", column = "channel_key"),@Result(property = "merNo", column = "mer_no"),@Result(property = "orgName", column = "org_name"),@Result(property = "reconcileStatus", column = "reconcile_status")})
 	MerReconcileRecordDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,reconcile_date,channel_key,mer_no,(select org_name from t_merchant_info where mer_no = tmrr.mer_no) org_name,reconcile_status from t_merchant_reconcile_record tmrr where 1 = 1"
		        + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
                + "<if test='params.channelKey != null'> and channel_key = #{params.channelKey}</if>"
                + "<if test='params.reconcileStatus != null'> and reconcile_status = #{params.reconcileStatus}</if>"
                +"order by gmt_create desc"
        + "</script>"
    )
    @ResultMap("MerReconcileRecordResultMap")
    Page<MerReconcileRecordDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_reconcile_record <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(MerReconcileRecordDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,reconcile_date,mer_no,reconcile_status from t_merchant_reconcile_record"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerReconcileRecordResultMap")
    MerReconcileRecordDO selectOne(MerReconcileRecordDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,reconcile_date,mer_no,reconcile_status from t_merchant_reconcile_record"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerReconcileRecordResultMap")
    List<MerReconcileRecordDO> selectList(MerReconcileRecordDO obj);

}

