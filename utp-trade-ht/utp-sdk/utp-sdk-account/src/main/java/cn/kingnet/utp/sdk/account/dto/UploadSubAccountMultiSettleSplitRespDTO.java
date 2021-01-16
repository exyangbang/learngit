package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description 上送子账户多级分账文件响应
 * @Author WJH
 * @Date 2020/02/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class UploadSubAccountMultiSettleSplitRespDTO extends BaseResponseDTO {

    /**
     * 清算日期yyyyMMdd
     */
    private String settleDate;
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;

}
