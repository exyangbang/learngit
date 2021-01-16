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
public class AuthAccountEntReqDTO extends BaseRequestDTO {
    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 营业执照图片
     */
    private String businessLicensePic;
    /**
     * 法人证件正面照
     */
    private String personPicA;
    /**
     * 法人证件反面照
     */
    private String personPicB;

    /**
     * 认证回调地址
     */
    private String callbackUrl;

}
