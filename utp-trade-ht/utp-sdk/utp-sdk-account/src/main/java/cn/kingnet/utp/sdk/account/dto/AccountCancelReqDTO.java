package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author zhongli
 * @date 2019-03-04 
 *
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCancelReqDTO extends BaseRequestDTO {

    /**
     * 虚拟账户
     */
    private String userAccount;
}
