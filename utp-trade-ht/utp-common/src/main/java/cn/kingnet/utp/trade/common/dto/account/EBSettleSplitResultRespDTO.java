package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月03日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EBSettleSplitResultRespDTO extends BaseResponseDTO {

    /**
     * 源上送批次号
     */
    private String batchNo;

    /**
     * 源文件清算日期
     */
    private String settleDate;

    /**
     * 是否整批有明确结果 success true,false
     */
    private String success;

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

    /**
     * 批次状态 FileBatchStatus
     */
    private String batchStatus;

}
