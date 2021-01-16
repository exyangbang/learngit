package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 代付客户号对应的华通专有账户明细
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryBankAccountDetailRespDTO extends BaseResponseDTO {

    private String industryCode;

    private String startDate;

    private String endDate;

    /**
     * 明细json字符串
     */
    private String detailJson;


}
