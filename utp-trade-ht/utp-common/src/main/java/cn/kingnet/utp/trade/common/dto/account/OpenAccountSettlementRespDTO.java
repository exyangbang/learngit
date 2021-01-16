package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @author sheqingquan@scenetec.com
 * @description: TODO
 * @create 2020/2/12 10:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenAccountSettlementRespDTO extends BaseResponseDTO {

    /**
     * 用户账户
     * 原上送的普通账户
     */
    private String userAccount;
    /**
     * 关联开通的待结算账户
     */
    private String userSettleAccount;
}