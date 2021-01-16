package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author zhongli
 * @date 2019-02-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BindReqDTO extends BaseRequestDTO {
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
    /**====*/
    /**
     * 验证类型 3：三要素验证；4：四要素验证；
     */
    private String verifyType;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 手机号（非必填）
     */
    private String mobile;
    /**
     * 备注/附言
     */
    private String remark;

}
