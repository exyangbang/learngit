package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description: 企业证件认证鉴权绑卡请求[京东定制化]
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 16:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NewAuthBindEntReqDTO extends BaseRequestDTO {

    /**
     * 虚拟账户(用户开户账户) M
     */
    private String userAccount;
    /**
     * 账号(认证账号) M
     */
    private String acctNo;
    /**
     * 账户名称 M
     */
    private String acctName;
    /**
     * 开户行号 M
     */
    private String opBankCode;
    /**
     * 开户行名称 M
     */
    private String opBankName;
    /**
     * 清算行号 O
     */
    private String clBankCode;

}
