package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
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
public class QueryAuthAccountStatusRespDTO extends BaseResponseDTO {
    private String userAccount;
    private String authStatus;
    private String remark;
}
