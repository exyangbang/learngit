package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 上送外部支付订单流水结果查询 响应
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
     * 0整批失败 1整批成功
     */
    private String batchStatus;

    /**
     * items jsonArray节点字符串
     */
    private String items;

}
