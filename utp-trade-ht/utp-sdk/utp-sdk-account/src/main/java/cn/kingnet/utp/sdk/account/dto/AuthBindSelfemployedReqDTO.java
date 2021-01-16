package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 个体工商户鉴权绑定账户
 * @Author : linkaigui
 * @Create : 2020/2/11 9:56
 */
@Setter
@Getter
public class AuthBindSelfemployedReqDTO extends BaseRequestDTO {
    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 验证类型 3：三要素验证；4：四要素验证；
     */
    private String verifyType;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 手机号（非必填）
     */
    private String mobile;
    /**
     * 备注/附言
     */
    private String remark;
    /**
     * 营业执照号 M
     */
    private String businessLicenseNo;
    /**
     * 营业执照图片 M
     */
    private String businessLicensePic;
    /**
     * 认证回调地址 M
     */
    private String callbackUrl;
}
