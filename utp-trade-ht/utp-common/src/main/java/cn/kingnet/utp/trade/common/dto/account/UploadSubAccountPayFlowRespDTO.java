package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
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
@Builder
public class UploadSubAccountPayFlowRespDTO extends BaseResponseDTO {

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
