package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 余额查询响应报文
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryBalanceRespDTO extends BaseResponseDTO {
    /**
     * 用户账户
     */
    private String account;

    /**
     * 冻结金额+可用余额
     */
    private String balance;
    /**
     *冻结金额
     */
    private String frozenAmount;
    /**
     *可用余额
     */
    private String availAmount;


}
