package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
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
public class DownloadElectronicReceiptReqDTO extends BaseRequestDTO {
    /**
     * 原流水号
     */
    private String origTradeId;
}
