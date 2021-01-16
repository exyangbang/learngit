package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 电子回单下载
 * @Author caohong
 * @Date 2019-03-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadElectronicReceiptReqDTO extends BaseRequestDTO {
    /**
     * 原流水号
     */
    private String origTradeId;
}
