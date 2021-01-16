package com.scenetec.upf.operation.repository.system;

import com.scenetec.upf.operation.model.domain.system.Organization;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author linkaigui on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Mapper
@Repository
public interface OrganizationMapper {
    /**
     * 根据id查询机构信息
     * @param id 机构编码
     * @return 机构信息
     * */
    @Results(id = "organizationMapper", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "parentId", column = "parent_id"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "simpleName", column = "simple_name"),
            @Result(property = "orgCode", column = "org_code"),
            @Result(property = "contactName", column = "contact_name"),
            @Result(property = "contactTel", column = "contact_tel"),
            @Result(property = "contactEmail", column = "contact_email"),
            @Result(property = "contactAddr", column = "contact_addr"),
            @Result(property = "registeredCapital", column = "registered_capital"),
            @Result(property = "legalName", column = "legal_name"),
            @Result(property = "legalIdcard", column = "legal_idcard"),
            @Result(property = "idcardStartDate", column = "idcard_start_date"),
            @Result(property = "idcardEndDate", column = "idcard_end_date"),
            @Result(property = "businessLicense", column = "business_license"),
            @Result(property = "setupStartDate", column = "setup_start_date"),
            @Result(property = "setupEndDate", column = "setup_end_date"),
            @Result(property = "address", column = "address"),
            @Result(property = "provinceCode", column = "province_code"),
            @Result(property = "cityCode", column = "city_code"),
            @Result(property = "countyCode", column = "county_code"),
            @Result(property = "legalIdcardPic", column = "legal_idcard_pic"),
            @Result(property = "businessLicensePic", column = "business_license_pic"),
            @Result(property = "orgCodeCertPic", column = "org_code_cert_pic"),
            @Result(property = "taxRegCertPic", column = "tax_reg_cert_pic"),
            @Result(property = "accountOpenLicensePic", column = "account_open_license_pic"),
            @Result(property = "delFlag", column = "del_flag"),
            @Result(property = "gmtCreate", column = "gmt_create"),
            @Result(property = "gmtModified", column = "gmt_modified"),
            @Result(property = "technologyContactName",column = "technology_contact_name"),
            @Result(property = "technologyContactTel",column = "technology_contact_tel"),
            @Result(property = "technologyContactEmail",column = "technology_contact_email"),
            @Result(property = "technologyContactAddr",column = "technology_contact_addr")
    })
    @Select("select * from t_organization where id=#{id}")
    Organization findOne(@Param("id") Long id);

    /**
     * 保存机构信息
     * @param organization 机构对象
     * @return 保存结果
     * */
    @Insert("insert into t_organization (id, parent_id, full_name, simple_name, org_code, contact_name, contact_tel, contact_email, contact_addr, " +
            "registered_capital, legal_name, legal_idcard, idcard_start_date, idcard_end_date, business_license, setup_start_date, setup_end_date, " +
            "address, province_code, city_code, county_code, legal_idcard_pic, business_license_pic, org_code_cert_pic, tax_reg_cert_pic, " +
            "account_open_license_pic, del_flag, gmt_create, user_create,gmt_modified,user_modified,technology_contact_name,technology_contact_tel,technology_contact_email,technology_contact_addr) values (" +
            "#{id}, #{parentId}, #{fullName}, #{simpleName}, #{orgCode}, #{contactName}, #{contactTel}, #{contactEmail}, #{contactAddr}, " +
            "#{registeredCapital}, #{legalName}, #{legalIdcard}, #{idcardStartDate}, #{idcardEndDate}, #{businessLicense}, #{setupStartDate}, #{setupEndDate}, " +
            "#{address}, #{provinceCode}, #{cityCode}, #{countyCode}, #{legalIdcardPic}, #{businessLicensePic}, #{orgCodeCertPic}, #{taxRegCertPic}, " +
            "#{accountOpenLicensePic}, #{delFlag}, #{gmtCreate}, #{userCreate},#{gmtModified}, #{userModified},#{technologyContactName},#{technologyContactTel},#{technologyContactEmail},#{technologyContactAddr})")
    int insert(Organization organization);
    /**
     * 更新机构信息
     * @param organization 机构信息
     * @return 更新结果
     * */
    @Update("update t_organization set parent_id=#{parentId}, full_name=#{fullName}, simple_name=#{simpleName}, org_code=#{orgCode}, contact_name=#{contactName}," +
            " contact_tel=#{contactTel}, contact_email=#{contactEmail}, contact_addr=#{contactAddr}, registered_capital=#{registeredCapital}, legal_name=#{legalName}," +
            " legal_idcard=#{legalIdcard}, idcard_start_date=#{idcardStartDate}, idcard_end_date=#{idcardEndDate}, business_license=#{businessLicense}, setup_start_date=#{setupStartDate}," +
            " setup_end_date=#{setupEndDate}, address=#{address}, province_code=#{provinceCode}, city_code=#{cityCode}, county_code=#{countyCode}, legal_idcard_pic=#{legalIdcardPic}," +
            " business_license_pic=#{businessLicensePic}, org_code_cert_pic=#{orgCodeCertPic}, tax_reg_cert_pic=#{taxRegCertPic}, account_open_license_pic=#{accountOpenLicensePic}," +
            " gmt_modified=#{gmtModified},user_modified=#{userModified},technology_contact_name=#{technologyContactName},technology_contact_tel=#{technologyContactTel},technology_contact_email=#{technologyContactEmail},technology_contact_addr=#{technologyContactAddr},del_flag=#{delFlag} where id=#{id}")
    int updateById(Organization organization);

    /**
     * 更新机构状态为删除状态
     * @param id 机构编码
     * @param delFlag 删除标志
     * @return 更新结果
     * */
    @Update("update t_organization set del_flag=#{delFlag} where id=#{id}")
    int updateDelFlagById(@Param("id") Long id, @Param("delFlag") String delFlag);

    /**
     * 根据机构编码查询机构信息
     * @param orgCode 机构编码
     * @return 机构对象
     * */
    @ResultMap("organizationMapper")
    @Select("<script> select * from t_organization where org_code=#{orgCode} <if test='delFlag'> and del_flag = #{delFlag} </if> </script>")
    Organization findOneByOrgCode(@Param("orgCode") String orgCode, @Param("delFlag") String delFlag);

    /**
     * 根据机构全称或机构编码查询机构信息
     * @param fullName 机构全称
     * @return 机构对象
     * */
    @ResultMap("organizationMapper")
    @Select("select * from t_organization where full_name = #{fullName}")
    Organization findOneByFullName(@Param("fullName") String fullName);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_organization"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.delFlag != null'> del_flag = #{params.delFlag} AND </if> "
                    +"<if test='params.name != null'> full_name like CONCAT('%',#{params.name},'%') AND </if> "
                    +"<if test='params.orgCode != null'> org_code = #{params.orgCode} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("organizationMapper")
    List<Organization> findByNameLikeAndOrgCodeAndDelFlag(@Param("params") Map<String, Object> params);
}
