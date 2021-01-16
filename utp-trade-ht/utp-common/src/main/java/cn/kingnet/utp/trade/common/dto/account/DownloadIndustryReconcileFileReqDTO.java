package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DownloadIndustryReconcileFileReqDTO extends BaseRequestDTO {


    /**
     * 源文件清算日期对账日期
     */
    private String settleDate;

}
