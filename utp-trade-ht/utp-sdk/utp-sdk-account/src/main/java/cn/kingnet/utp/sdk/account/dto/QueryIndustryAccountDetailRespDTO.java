package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 描述
 * @Author : WJH
 * @Create : 2019/03/06 10:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
