package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description : 账户入金通知查询
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryUserAccountOrderIdReqDTO extends BaseRequestDTO {
    /**
     * 请求日期
     */
    private String reqDate;
    /**
     * 用户账户
     */
    private String userAccount;
    /**
     * 订单号
     */
    private String orderId;

}
