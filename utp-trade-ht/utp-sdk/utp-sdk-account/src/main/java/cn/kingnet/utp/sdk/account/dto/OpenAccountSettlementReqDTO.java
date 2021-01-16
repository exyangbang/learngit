package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author sheqingquan@scenetec.com
 * @description: TODO
 * @create 2020/2/12 10:33
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenAccountSettlementReqDTO extends BaseRequestDTO {

    /**
     * 用户账户
     * 用户开通的普通账户
     */
    private String userAccount;
}