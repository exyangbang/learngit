package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description 电商清算分账文件上送
 * @Author WJH
 * @Date 2018年10月29日
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadSettleSplitReqDTO extends BaseRequestDTO {



    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

    /**
     * 结果回调地址
     */
    private String callbackUrl;


}
