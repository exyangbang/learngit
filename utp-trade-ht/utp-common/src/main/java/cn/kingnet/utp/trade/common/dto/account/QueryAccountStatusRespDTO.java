package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
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
public class QueryAccountStatusRespDTO extends BaseResponseDTO {
    private String accountStatus;
}
