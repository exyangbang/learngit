package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author sheqingquan@scenetec.com
 * @create 2020/2/11 18:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubaccountSettleSplitResultReqDTO extends BaseRequestDTO {

    /**
     * yyyyMMdd
     * 原交易的清算日期
     */
    private String settleDate;
    /**
     * 用户账户
     * 子账户
     */
    private String userAccount;
    /**
     * 原交易的批次号
     */
    private String batchNo;
}