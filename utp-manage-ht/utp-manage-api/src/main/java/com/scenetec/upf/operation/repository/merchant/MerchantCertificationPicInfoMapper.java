package com.scenetec.upf.operation.repository.merchant;

import com.scenetec.upf.operation.model.domain.merchant.MerchantCertificationPicInfoDO;
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
public interface MerchantCertificationPicInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_certification_pic_info (user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_code,cert_pic,cert_pic_path) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{certCode},#{certPic},#{certPicPath})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(MerchantCertificationPicInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_certification_pic_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, cert_code, cert_pic, cert_pic_path"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.certCode}, #{item.certPic}, #{item.certPicPath})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<MerchantCertificationPicInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_certification_pic_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, cert_code, cert_pic, cert_pic_path"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.certCode}, #{item.certPic}, #{item.certPicPath})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"mer_no = VALUES(mer_no),"
            +"cert_code = VALUES(cert_code),"
            +"cert_pic = VALUES(cert_pic),"
            +"cert_pic_path = VALUES(cert_pic_path)"
        +"</script>"
    )
    int modifyList(List<MerchantCertificationPicInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_certification_pic_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_certification_pic_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='certCode != null'> cert_code = #{certCode}, </if> "
            +"<if test='certPic != null'> cert_pic = #{certPic}, </if> "
            +"<if test='certPicPath != null'> cert_pic_path = #{certPicPath}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(MerchantCertificationPicInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_code,cert_pic,cert_pic_path from t_merchant_certification_pic_info where id = #{id}")
 	@Results(id="MerchantCertificationPicInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "merNo", column = "mer_no"),@Result(property = "certCode", column = "cert_code"),@Result(property = "certPic", column = "cert_pic"),@Result(property = "certPicPath", column = "cert_pic_path")})
 	MerchantCertificationPicInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_code,cert_pic,cert_pic_path from t_merchant_certification_pic_info where 1 = 1"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
		        + "<if test='params.certCode != null'> and cert_code = #{params.certCode}</if>"
        + "</script>"
    )
    @ResultMap("MerchantCertificationPicInfoResultMap")
    Page<MerchantCertificationPicInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_certification_pic_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certPic != null'> cert_pic = #{certPic} AND </if> "
            +"<if test='certPicPath != null'> cert_pic_path = #{certPicPath} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(MerchantCertificationPicInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_code,cert_pic,cert_pic_path from t_merchant_certification_pic_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certPic != null'> cert_pic = #{certPic} AND </if> "
            +"<if test='certPicPath != null'> cert_pic_path = #{certPicPath} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantCertificationPicInfoResultMap")
    MerchantCertificationPicInfoDO selectOne(MerchantCertificationPicInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_code,cert_pic,cert_pic_path from t_merchant_certification_pic_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certPic != null'> cert_pic = #{certPic} AND </if> "
            +"<if test='certPicPath != null'> cert_pic_path = #{certPicPath} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantCertificationPicInfoResultMap")
    List<MerchantCertificationPicInfoDO> selectList(MerchantCertificationPicInfoDO obj);

}

