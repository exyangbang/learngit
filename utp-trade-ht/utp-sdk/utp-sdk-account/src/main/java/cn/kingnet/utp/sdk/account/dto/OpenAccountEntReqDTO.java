package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhongli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAccountEntReqDTO extends BaseRequestDTO {
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
     * 营业执照号码
     */
    private String businessLicenseCode;
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
}
