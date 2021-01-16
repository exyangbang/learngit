package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhongli
 * @date 2019-03-04 
 *
 */
@Getter
@Setter
public class FreezeBalanceReqDTO extends BaseRequestDTO {
    /**
     * 请求日期 M
     * 按自然日(yyyyMMdd)
     */
    private String reqDate;
    /**
     * 用户账户 M
     */
    private String userAccount;
    /**
     * 交易金额 M
     * 冻结/解冻金额
     */
    private String amount;
    /**
     * 操作类型 M
     * 0=冻结 1=解冻
     */
    private String type;
    /**
     * 原客户端流水/服务端流水
     * 当type=1时，必填
     */
    private String origTradeId;
}