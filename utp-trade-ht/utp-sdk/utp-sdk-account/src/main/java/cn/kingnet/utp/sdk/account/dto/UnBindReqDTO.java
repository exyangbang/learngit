package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author zhongli
 * @date 2019-02-19
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnBindReqDTO extends BaseRequestDTO {

    /**
     * 虚拟账户
     */
    private String userAccount;

    /**
     * 指定的解绑账号
     * 支持绑定多张卡需必填
     */
    private String acctNo;
}
