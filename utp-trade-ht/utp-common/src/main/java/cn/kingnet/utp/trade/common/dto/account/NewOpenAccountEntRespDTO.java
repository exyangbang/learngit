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
public class NewOpenAccountEntRespDTO extends BaseResponseDTO {

    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 账户状态	varchar（2）		M	详见账户状态
     */
    private String accountStatus;
    /**
     * 审核状态	varchar(2)		M	审核状态
     * 0=待审核
     * 1=审核通过
     * 2=审核驳回
     */
    private String authStatus;
}
