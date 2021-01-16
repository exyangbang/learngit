package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhongli
 * @date 2019-02-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BindEntReqDTO extends BaseRequestDTO {
    /**清算行号*/
    private String clBankCode;
    /**
     * 开户行号
     */
    private String opBankCode;
    /**
     * 开户行号
     */
    private String opBankName;
    /**
     * 虚拟账户
     */
    private String userAccount;

    /**
     * 账户类型
     */
    private String acctType;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 户名
     */
    private String acctName;

}
