package cn.kingnet.utp.sdk.account.dto;


import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description : 电子回单下载
 * @Author caohong
 * @Date 2019-03-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DownloadElectronicReceiptRespDTO extends BaseResponseDTO {


    /**
     * 电子回单号
     */
    private String receiptNo;

    /**
     * 电子回单pdf文件流
     */
    private String content;

}
