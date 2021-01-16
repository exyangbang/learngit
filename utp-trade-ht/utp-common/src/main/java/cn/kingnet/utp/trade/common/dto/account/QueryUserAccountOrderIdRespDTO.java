package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 账户入金查询
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryUserAccountOrderIdRespDTO extends BaseResponseDTO {

    /**
     * 收款用户虚拟账号
     */
    private String userAccount;
    /**
     * 流水号
     */
    private String serverTransId;
    /**
     * 入金金额
     */
    private String payAmt;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 交易日期
     */
    private String transDate;
    /**
     * 来款账号
     */
    private String payerAccNo;
    /**
     * 来款户名
     */
    private String payerAccName;


}
