package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description 余额支付退款
 * @Author WJH
 * @Date 2020/03/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BalancePaymentRefundReqDTO extends BaseRequestDTO {
    /**
     * 	退款金额	varchar(15)	M
     */
   private String payAmt;
    /**
     * 原客户端流水号	<=32	C   与origServerTradeId 二选一必填
     */
    private String origClientTradeId;
    /**
     * 	原服务端端流水号	<=36	C 原服务端端流水号 二选一必填
     */
    private String origServerTradeId;
}
