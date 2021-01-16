package cn.kingnet.utp.scheduler.data.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MerchantInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 虚拟账户
     */
    private String account;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 商户简称
     */
    private String nameAbbreviation;

    /**
     * 行政区划代码
     */
    private String administrativeCode;

    /**
     * 所属收单机构代码
     */
    private String orgCode;

    /**
     * 所属收单机构名称
     */
    private String orgName;

    /**
     * 所属行业代码
     */
    private String industryCode;

    /**
     * 所属行业名称
     */
    private String industryName;

    /**
     * 所属省
     */
    private String provinceCode;

    /**
     * 所属市
     */
    private String cityCode;

    /**
     * 所属县
     */
    private String countyCode;

    /**
     * 注册地址
     */
    private String regAddress;

    /**
     * 营业地址
     */
    private String businessAddress;

    /**
     * 法人代表姓名
     */
    private String legalName;

    /**
     * 商户状态 0未开户 1已开户已绑卡 2已开户未绑卡 3已销户 4冻结
     */
    private String status;

    /**
     * 商户网站名称
     */
    private String websiteName;

    /**
     * 支出商户号
     */
    private String payMerchantNo;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 用户类型|0-个人 1-商户
     */
    private String userType;

    /**
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    private String idType;

    /**
     * 个人/法人证件号
     */
    private String idCode;

    /**
     * 用户真实姓名，绑卡时需要的户名
     */
    private String realName;

    /**
     * 营业执照号
     */
    private String busLicCode;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
     */
    private Integer authStatus;

    /**
     * 认证回调地址
     */
    private String authCallBack;

    /**
     * 审核备注
     */
    private String authRemark;

    /**
     * 性别（M男 F女）
     */
    private String sex;

    /**
     * 国籍地区编码
     */
    private String country;

    /**
     * 行业/职业
     */
    private String prosession;

    /**
     * 证件有效期（yyyy-MM-dd）
     */
    private String idIndate;

    /**
     * 联系人电话
     */
    private String telephone;

    /**
     * 控股股东或实际控制人证明文件类型
     */
    private String fileType;

    /**
     * 控股股东或实际控制人其他证明文件类型
     */
    private String otherFileType;

    /**
     * 控股股东或实际控制人证明文件号码
     */
    private String fileNum;

    /**
     * 账户性质(1-平台|行业账户,2-企业商户,3-个人,4-手续费收入账户,5-手续费支出账户,6-归集账户,7-佣金账户,8-个体工商户账户,9-待结算账户) 
     */
    private String nature;

    /**
     * 待结算虚拟账户
     */
    private String settleAccount;

    /**
     * 营业执照图片
     */
    private String busLicPic;

    /**
     * 法人证件正面图片
     */
    private String personPic;

    /**
     * 法人证件反面图片
     */
    private String personReversePic;

    /**
     * 开户许可证（Base64字符串 <200k）
     */
    private String licensePic;
}