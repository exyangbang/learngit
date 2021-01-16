package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 华通银行账户明细同步日志
 * @Author WJH
 * @Date 2019年01月22日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndustrySyncLogReqDTO extends BaseRequestDTO {

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 起始同步日期yyyyMMdd
     *
     */
    private String startDate;

}
