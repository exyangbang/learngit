package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月03日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EBSettleSplitResultReqDTO extends BaseRequestDTO {

    /**
     * 源上送批次号
     */
    private String batchNo;

    /**
     * 源文件清算日期
     */
    private String settleDate;

}
