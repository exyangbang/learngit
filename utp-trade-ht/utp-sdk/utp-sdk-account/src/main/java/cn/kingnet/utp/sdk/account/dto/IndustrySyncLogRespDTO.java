package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 华通银行账户明细同步日志
 * @Author WJH
 * @Date 2019-01-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndustrySyncLogRespDTO extends BaseResponseDTO {

    /**
     * 代付客户号
     */
    private String industryCode;
    /**
     * 同步起始日期 yyyyMMdd
     */
    private String startDate;

    /**
     * boolean 重置标识	成功-true 失败-false
     */
    private String success;

}
