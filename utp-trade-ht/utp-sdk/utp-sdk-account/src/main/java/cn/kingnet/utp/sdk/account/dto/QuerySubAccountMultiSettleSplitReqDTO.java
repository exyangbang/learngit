package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuerySubAccountMultiSettleSplitReqDTO extends BaseRequestDTO {

    /**
     * 清算日期yyyyMMdd
     */
    private String settleDate;
    /**
     * 批次号
     */
    private String batchNo;


}
