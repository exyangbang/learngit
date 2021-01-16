package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadIndustryReconcileFileReqDTO extends BaseRequestDTO {


    /**
     * 源文件清算日期对账日期
     */
    private String settleDate;

}
