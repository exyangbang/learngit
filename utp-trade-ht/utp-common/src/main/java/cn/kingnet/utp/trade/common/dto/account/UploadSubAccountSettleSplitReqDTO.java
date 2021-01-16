package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
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
public class UploadSubAccountSettleSplitReqDTO extends BaseRequestDTO {

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
     * 出金子账户（待结算账户）
     */
    private String userAccount;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 实时文件流内容，base64字符串 必填
     * 必须deflater压缩后base64 编码字符串;
     * 文件内容格式详见：子账户清算分账文件格式
     */
    private String content;

}
