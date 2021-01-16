package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
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
public class DownloadIndustryD1SpecailReconFileReqDTO extends BaseRequestDTO {


    /**
     * 交易日期（yyyyMMdd）
     */
    private String txDate;

}
