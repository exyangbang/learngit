package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description : 虚拟账户余额查询
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryBalanceReqDTO extends BaseRequestDTO {

    /**用户账户**/
    private String userAccount;
    /**
     * 代付客户号
     */
    private String industryCode;

}
