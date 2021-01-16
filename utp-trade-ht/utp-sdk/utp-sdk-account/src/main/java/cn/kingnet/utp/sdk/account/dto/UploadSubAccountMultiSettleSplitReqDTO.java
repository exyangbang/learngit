package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description 上送子账户多级分账文件
 * @Author WJH
 * @Date 2020/02/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class UploadSubAccountMultiSettleSplitReqDTO extends BaseRequestDTO {

    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;

    /**
     * 清算日期yyyyMMdd
     */
    private String settleDate;
    /**
     * 类型：1结算 2退款 3撤销
     */
    private String type;
    /**
     * 出金子账户（type=1或3时 出金子账户，子账户多级分账文件域的第一条分账记录的分账转出账户必须和该账户一致）
     */
    private String userAccount;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 实时文件流内容，base64字符串 必填
     * 必须deflater压缩后base64 编码字符串;
     * 文件内容格式详见：子账户多级清算分账文件格式
     */
    private String content;

}
