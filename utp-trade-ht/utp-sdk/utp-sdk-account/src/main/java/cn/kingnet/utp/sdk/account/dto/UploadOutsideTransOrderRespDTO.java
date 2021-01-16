package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 上送外部支付订单流水 响应
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadOutsideTransOrderRespDTO extends BaseResponseDTO {
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;

    /**
     * 0整批失败 1整批成功
     */
    private String batchStatus;

}
