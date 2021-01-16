package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhongli
 * @date 2019-02-19
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryAccountStatusReqDTO extends BaseRequestDTO {

    /**
     * 虚拟账户
     */
    private String userAccount;

}
