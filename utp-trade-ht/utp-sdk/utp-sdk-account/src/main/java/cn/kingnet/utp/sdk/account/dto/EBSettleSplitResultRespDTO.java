package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月03日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
     * 是否成功 success true,false
     */
    private String success;
    /**
     * 0 整批失败 1整批成功 2部分成功
     */
    private String batchStatus;
    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

}
