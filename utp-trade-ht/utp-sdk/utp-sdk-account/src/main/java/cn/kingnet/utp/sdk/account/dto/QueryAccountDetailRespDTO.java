package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 账户资金明细查询响应
 * @Author WJH
 * @Date 2018年11月23日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
