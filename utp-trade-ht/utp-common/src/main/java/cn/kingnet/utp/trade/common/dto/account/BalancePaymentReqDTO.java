package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
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
public class BalancePaymentReqDTO extends BaseRequestDTO {
    /**
     * 请求日期	varchar(8)	M		按自然日(yyyyMMdd)
     */
    private String reqDate;
    /**
     * 请求时间	varchar(6)	M		HHmmss
     */
    private String reqTime;
    /**
     * 付款类型	varchar(2)	M		0：用户->代付客户平台1：用户->用户
     */
    private String type;
    /**
     * 付款人用户账号	varchar(19)	M
     */
    private String payerUserAccount;
    /**
     * 收款人用户账号	varchar(19)	O		付款类型为1时必填
     */
    private String payeeUserAccount;
    /**
     * 交易金额	varchar(15)	M		单位分
     */
    private String payAmt;
    /**
     * 平台交易订单号	varchar(100)	M
     */
    private String transNo;
    /**
     * 商品信息	varchar(500)	M
     */
    private String shoppingInfo;
}
