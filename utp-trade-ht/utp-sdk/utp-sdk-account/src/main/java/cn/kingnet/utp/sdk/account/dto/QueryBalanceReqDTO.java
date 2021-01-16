package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 虚拟账户余额查询
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryBalanceReqDTO extends BaseRequestDTO {

    /**用户账户**/
    private String userAccount;
    /**
     * 代付客户号
     */
    private String industryCode;

}
