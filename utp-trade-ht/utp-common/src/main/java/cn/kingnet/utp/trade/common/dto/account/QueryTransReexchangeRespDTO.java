package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description : 退汇流水查询
 * @Author : WJH
 * @Create : 2018-03-17
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryTransReexchangeRespDTO extends BaseResponseDTO {

    /**
     * 退汇流水jsonArray字符串
     */
    private String items;
}
