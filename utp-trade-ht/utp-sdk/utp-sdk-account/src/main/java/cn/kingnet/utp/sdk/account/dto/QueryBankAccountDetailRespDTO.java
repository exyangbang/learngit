package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 代付客户号对应的华通专有账户明细
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryBankAccountDetailRespDTO extends BaseResponseDTO {

    private String industryCode;

    private String startDate;

    private String endDate;

    /**
     * 明细json字符串
     */
    private String detailJson;


}
