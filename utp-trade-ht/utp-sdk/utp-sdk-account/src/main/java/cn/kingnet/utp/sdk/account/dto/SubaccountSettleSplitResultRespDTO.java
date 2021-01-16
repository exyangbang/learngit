package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.*;

/**
 * @author sheqingquan@scenetec.com
 * @create 2020/2/11 18:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubaccountSettleSplitResultRespDTO extends BaseResponseDTO {

    /**
     * 清算日期
     * yyyyMMdd
     */
    private String settleDate;
    /**
     * 用户账户
     * 子账户
     */
    private String userAccount;
    /**
     * 源上送批次号
     */
    private String batchNo;
    /**
     * 清算结果
     * 成功：true
     * 失败：false
     */
    private String success;
    /**
     * 0整批失败 1整批成功 2部分成功
     */
    private String batchStatus;
    /**
     * 清算结果文件域
     * 实时文件流内容，base64字符串 必填
     */
    private String content;
}
