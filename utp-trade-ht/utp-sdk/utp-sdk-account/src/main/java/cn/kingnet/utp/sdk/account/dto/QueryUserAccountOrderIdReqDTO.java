package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 账户入金通知查询
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
