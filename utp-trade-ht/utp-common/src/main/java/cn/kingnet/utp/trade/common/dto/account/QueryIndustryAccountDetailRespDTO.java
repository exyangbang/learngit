package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description : 描述
 * @Author : WJH
 * @Create : 2019/03/06 10:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryIndustryAccountDetailRespDTO extends BaseResponseDTO {


    /**
     * 必填
     * 代付客户号
     */
    private String industryCode;

    /**
     * 虚账户 资金明细
     */
    private String items;
}
