package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  单笔实时分账退款
 * @Author caixh
 * @Date 2020/06/29
 */
@Setter
@Getter
@ToString
public class SplitPaymentRefundReqDTO extends BaseRequestDTO {

    /**
     * 退款金额	varchar(15)	M		单位分
     */
    private String payAmt;
    /**
     * 备注说明	varchar(1024)	O
     */
    private String remark;
    /**
     * 原客户端流水号	varchar(32)	M		需要退款的原分账交易客户端流水号
     */
    private String origClientTradeId;

}
