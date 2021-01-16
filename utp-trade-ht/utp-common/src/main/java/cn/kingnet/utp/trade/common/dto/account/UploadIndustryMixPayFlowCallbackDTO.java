package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 融合支付结果回调报文
 * @Author WJH
 * @Date 2020/12/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadIndustryMixPayFlowCallbackDTO extends BaseResponseDTO {
    /**
     * batchNo	批次号	varchar(30)		#
     */
    private String batchNo;

    private String mixTransId;
    /**
     * success	上送结果	varchar(20)		M	成功：true 失败：false
     */
    private String success;
    /**
     * batchStatus	批次状态	varchar(2)		M	详见5.23 仅会0或1
     */
    private String batchStatus;
}
