package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 订单退款
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefundOrderIdReqDTO extends BaseRequestDTO {
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

    /**
     * 交易金额
     */
    private String payAmt;

    /**
     * 回调地址
     */
    private String callbackUrl;

}
