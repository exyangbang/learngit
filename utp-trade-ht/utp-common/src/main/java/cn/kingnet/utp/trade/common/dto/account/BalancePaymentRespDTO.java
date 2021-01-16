package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 余额支付
 * @Author WJH
 * @Date 2020/03/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BalancePaymentRespDTO extends BaseResponseDTO {
    /**
     * 余额支付交易状态 M
     */
    private String transStatus;
    /**
     * 状态描述			M
     */
    private String statusDesc;
    /**
     * 对账日期	varchar(8)	O		非空时可以作为对账日(yyyyMMdd)
     */
    private String reconcileDate;
}
