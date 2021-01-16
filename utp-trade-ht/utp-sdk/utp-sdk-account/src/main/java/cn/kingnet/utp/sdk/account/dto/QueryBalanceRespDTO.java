package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 余额查询响应报文
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
