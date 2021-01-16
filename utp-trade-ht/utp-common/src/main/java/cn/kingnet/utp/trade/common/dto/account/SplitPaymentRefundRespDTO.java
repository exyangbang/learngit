package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 单笔实时分账退款
 * @Author caixh
 * @Date 2020/06/29
 */
@Setter
@Getter
@ToString
public class SplitPaymentRefundRespDTO extends BaseResponseDTO {
    /**
     * 交易状态：详见交易状态字典
     */
    private String transStatus;
    /**
     * 状态描述
     */
    private String statusDesc;
    /**
     * 对账日期	varchar(8)			非空时可以作为对账日(yyyyMMdd)
     */
    private String reconcileDate;

}
