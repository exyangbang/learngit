package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author WJH
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NewOpenAccountEntReqDTO extends BaseRequestDTO {
    /**
     * 接入方用户号（接入方系统用户的唯一标志）
     */
    private String userNo;
    /**
     * 法人名称
     */
    private String personName;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 企业注册地址
     */
    private String regAddress;

    /**
     * 法人证件类型
     */
    private String personIdType;
    /**
     * 法人证件号
     */
    private String personIdCode;
    /**
     * 法人证件有效期yyyy-MM-dd
     */
    private String personIdIndate;

    /**
     * 营业执照号码
     */
    private String businessLicenseCode;
    /**
     * 营业执照有效期	varchar(10)	M		证件有效期截止日期，格式：yyyy-MM-dd
     * 长期有效，填值9999-12-31
     */
    private String idIndate;
    /**
     * 用户昵称（非必填）
     */
    private String nickName;
    /**
     * 手机号（非必填）
     */
    private String mobile;
    /**
     * 邮箱（非必填）
     */
    private String email;
    /**
     * 账户性质：普通账户/佣金账户
     */
    private String nature;
    /**
     * 国籍、地区编码
     */
    private String country;
    /**
     * 行业
     */
    private String occupation;

    /**
     * 营业执照图片 M
     * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
     */
    private String businessLicensePic;
    /**
     * 法人证件正面照 M
     * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
     */
    private String personPicA;
    /**
     * 法人证件反面照 M
     * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
     */
    private String personPicB;
    /**
     * 认证回调地址 M
     */
    private String callbackUrl;
    /**
     * 开户许可证
     * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
     */
    private String licensePic;
}
