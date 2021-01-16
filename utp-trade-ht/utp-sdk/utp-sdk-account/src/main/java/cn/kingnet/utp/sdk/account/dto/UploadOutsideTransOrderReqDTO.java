package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description 上送外部支付订单流水 请求
 * @Author WJH
 * @Date 2018年10月29日
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadOutsideTransOrderReqDTO extends BaseRequestDTO {

    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;


}
