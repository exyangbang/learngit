package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 上送分账-支付流水结果查询 响应
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuerySplitPayFlowResultRespDTO extends BaseResponseDTO {
    /**
     * 代付客户号
     */
    private String industryCode;
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * items jsonArray节点字符串
     */
    private String items;

}
