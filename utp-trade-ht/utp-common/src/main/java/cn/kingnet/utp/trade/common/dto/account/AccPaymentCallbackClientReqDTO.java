package cn.kingnet.utp.trade.common.dto.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 子账户付款回调请求客户端信息
 * @Author : linkaigui
 * @Create : 2020/5/15 15:49
 */
@Getter
@Setter
public class AccPaymentCallbackClientReqDTO implements Serializable {
    /**
     * 用户虚拟账户
     */
    private String userAccount;

    /**请求日期*/
    private String reqDate;

    /**源客户端流水号*/
    private String origClientTradeId;

    /**源服务端端流水号*/
    private String origServerTradeId;

    /**交易状态*/
    private String transStatus;

    /**状态描述*/
    private String statusDesc;

    /**对账日期*/
    private String reconcileDate;

    /**
     * 手续费结算类型:1实时 2后结
     */
    private String feeType;

    /**
     * 手续费收费模式：1内扣 2外扣
     */
    private String feeModel;

    /**
     * 手续费金额单位分
     */
    private String feeAmount;
}
