package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月03日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
