package com.scenetec.upf.operation.model.domain.merchant;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhongli
 * @date 2019-03-12 
 *
 */
@Setter
@Getter
public class MerchantInfoAuthDo {
    private static final String appid = "utp-manager-ht";
    /**
     * 记录ID
     */
    private String id;
    /**
     * 审核结果 1=审核成功 2=审核失败
     */
    private Integer authStatus;
    /**
     * 审核备注
     */
    private String authRemark;

    private String userModified;

    /**
     * 签名
     */
    private String sign;

    public String[] toSHA1(String secret) {
        return new String[]{"appid=" + appid, "secret=" + secret, "id=" + id, "authStatus=" + authStatus.toString(),
                "authRemark=" + authRemark};
    }
}
