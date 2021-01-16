package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.MerchantInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_merchant_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.MerchantInfoMapper")
public class MerchantInfo extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 虚拟账户
     */
    @TableField(value = "account")
    private String account;

    /**
     * 商户名称
     */
    @TableField(value = "mer_name")
    private String merName;

    /**
     * 商户简称
     */
    @TableField(value = "name_abbreviation")
    private String nameAbbreviation;

    /**
     * 行政区划代码
     */
    @TableField(value = "administrative_code")
    private String administrativeCode;

    /**
     * 所属收单机构代码
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 所属收单机构名称
     */
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 所属行业代码
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 所属行业名称
     */
    @TableField(value = "industry_name")
    private String industryName;

    /**
     * 所属省
     */
    @TableField(value = "province_code")
    private String provinceCode;

    /**
     * 所属市
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 所属县
     */
    @TableField(value = "county_code")
    private String countyCode;

    /**
     * 注册地址
     */
    @TableField(value = "reg_address")
    private String regAddress;

    /**
     * 营业地址
     */
    @TableField(value = "business_address")
    private String businessAddress;

    /**
     * 法人代表姓名
     */
    @TableField(value = "legal_name")
    private String legalName;

    /**
     * 商户状态 0未开户 1已开户已绑卡 2已开户未绑卡 3已销户 4冻结
     */
    @TableField(value = "status")
    private String status;

    /**
     * 商户网站名称
     */
    @TableField(value = "website_name")
    private String websiteName;

    /**
     * 支出商户号
     */
    @TableField(value = "pay_merchant_no")
    private String payMerchantNo;

    /**
     * 模板ID
     */
    @TableField(value = "template_id")
    private String templateId;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 用户类型|0-个人 1-商户
     */
    @TableField(value = "user_type")
    private String userType;

    /**
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    @TableField(value = "id_type")
    private String idType;

    /**
     * 个人/法人证件号
     */
    @TableField(value = "id_code")
    private String idCode;

    /**
     * 用户真实姓名，绑卡时需要的户名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 营业执照号
     */
    @TableField(value = "bus_lic_code")
    private String busLicCode;

    /**
     * 企业名称
     */
    @TableField(value = "ent_name")
    private String entName;

    /**
     * 审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
     */
    @TableField(value = "auth_status")
    private Integer authStatus;

    /**
     * 认证回调地址
     */
    @TableField(value = "auth_call_back")
    private String authCallBack;

    /**
     * 审核备注
     */
    @TableField(value = "auth_remark")
    private String authRemark;

    /**
     * 性别（M男 F女）
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 国籍地区编码
     */
    @TableField(value = "country")
    private String country;

    /**
     * 行业/职业
     */
    @TableField(value = "prosession")
    private String prosession;

    /**
     * 证件有效期（yyyy-MM-dd）
     */
    @TableField(value = "id_indate")
    private String idIndate;

    /**
     * 联系人电话
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 控股股东或实际控制人证明文件类型
     */
    @TableField(value = "file_type")
    private String fileType;

    /**
     * 控股股东或实际控制人其他证明文件类型
     */
    @TableField(value = "other_file_type")
    private String otherFileType;

    /**
     * 控股股东或实际控制人证明文件号码
     */
    @TableField(value = "file_num")
    private String fileNum;

    /**
     * 账户性质(1-平台|行业账户,2-企业商户,3-个人,4-手续费收入账户,5-手续费支出账户,6-归集账户,7-佣金账户,8-个体工商户账户,9-待结算账户) 
     */
    @TableField(value = "nature")
    private String nature;

    /**
     * 待结算虚拟账户
     */
    @TableField(value = "settle_account")
    private String settleAccount;

    /**
     * 营业执照图片
     */
    @TableField(value = "bus_lic_pic")
    private String busLicPic;

    /**
     * 法人证件正面图片
     */
    @TableField(value = "person_pic")
    private String personPic;

    /**
     * 法人证件反面图片
     */
    @TableField(value = "person_reverse_pic")
    private String personReversePic;

    /**
     * 开户许可证（Base64字符串 <200k）
     */
    @TableField(value = "license_pic")
    private String licensePic;

    public MerchantInfoVo buildVo() {
        return new MerchantInfoVo(id, merNo, account, merName, nameAbbreviation, administrativeCode, orgCode, orgName, industryCode, industryName, provinceCode, cityCode, countyCode, regAddress, businessAddress, legalName, status, websiteName, payMerchantNo, templateId, gmtCreate, gmtModified, userCreate, userModified, userType, idType, idCode, realName, busLicCode, entName, authStatus, authCallBack, authRemark, sex, country, prosession, idIndate, telephone, fileType, otherFileType, fileNum, nature, settleAccount, busLicPic, personPic, personReversePic, licensePic);
    }

    public static MerchantInfo of(MerchantInfoVo vo) {
        return new MerchantInfo(vo.getId(), vo.getMerNo(), vo.getAccount(), vo.getMerName(), vo.getNameAbbreviation(), vo.getAdministrativeCode(), vo.getOrgCode(), vo.getOrgName(), vo.getIndustryCode(), vo.getIndustryName(), vo.getProvinceCode(), vo.getCityCode(), vo.getCountyCode(), vo.getRegAddress(), vo.getBusinessAddress(), vo.getLegalName(), vo.getStatus(), vo.getWebsiteName(), vo.getPayMerchantNo(), vo.getTemplateId(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getUserType(), vo.getIdType(), vo.getIdCode(), vo.getRealName(), vo.getBusLicCode(), vo.getEntName(), vo.getAuthStatus(), vo.getAuthCallBack(), vo.getAuthRemark(), vo.getSex(), vo.getCountry(), vo.getProsession(), vo.getIdIndate(), vo.getTelephone(), vo.getFileType(), vo.getOtherFileType(), vo.getFileNum(), vo.getNature(), vo.getSettleAccount(), vo.getBusLicPic(), vo.getPersonPic(), vo.getPersonReversePic(), vo.getLicensePic());
    }
}