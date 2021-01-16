package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 上送外部支付订单流水结果查询 响应
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryOutsideTransOrderResultRespDTO extends BaseResponseDTO {
    /**
     * 代付客户号
     */
    private String industryCode;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 0整批成功 1整批失败
     */
    private String batchStatus;

    /**
     * items jsonArray节点字符串
     */
    private String items;

}
