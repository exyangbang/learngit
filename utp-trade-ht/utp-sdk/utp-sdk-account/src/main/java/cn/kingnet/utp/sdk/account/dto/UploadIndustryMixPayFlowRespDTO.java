package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadIndustryMixPayFlowRespDTO extends BaseResponseDTO {
    /**
     * batchNo	批次号	varchar(30)		#
     */
    private String batchNo;

    private String mixTransId;
}
