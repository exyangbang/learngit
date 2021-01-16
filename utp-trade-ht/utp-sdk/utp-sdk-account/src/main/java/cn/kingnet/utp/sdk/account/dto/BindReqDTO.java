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
public class BindReqDTO extends BaseRequestDTO {

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
     * 手机号（非必填）
     */
    private String mobile;
    /**
     * 备注/附言
     */
    private String remark;

}
