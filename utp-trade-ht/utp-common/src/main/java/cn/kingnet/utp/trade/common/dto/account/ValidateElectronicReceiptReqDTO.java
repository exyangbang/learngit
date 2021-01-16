package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description : 电子回单验证
 * @Author caohong
 * @Date 2019-03-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidateElectronicReceiptReqDTO extends BaseRequestDTO {


    /**
     * 原流水号
     */
    private String origTradeId;

    /**
     * 电子回单号
     */
    private String receiptNo;

    /**
     * 电子回单号pdf文件流
     */
    private String content;

}
