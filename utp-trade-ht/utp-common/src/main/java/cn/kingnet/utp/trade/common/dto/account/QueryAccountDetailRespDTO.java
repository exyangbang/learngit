package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 账户资金明细查询响应
 * @Author WJH
 * @Date 2018年11月23日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryAccountDetailRespDTO extends BaseResponseDTO {



    /**
     * 必填
     * 用户账户
     */
    private String userAccount;

    /**
     * 虚账户 资金明细
     */
    private String items;

}
