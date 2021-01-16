package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class QuerySubAccountPayFlowRespDTO extends BaseResponseDTO {

    /**
     * 代付客户号	varchar(32)	M		代付客户号
     */
    private String industryCode;
    /**
     * 批次号	varchar(30)	M		原支付流水上送批次号
     */
    private String batchNo;
    /**
     * 批次状态 0失败 1成功
     */
    private String batchStatus;

    /**
     * json 字符串
     * userAccount	子账户	varchar(19)	M		入金子账户
     * incomeFlowId	入金流水	Varcahr(32)		M
     * transAmount	交易金额	long		M	单位分无小数点
     * linkPayFlowIds	关联的支付流水列表	varchar（1024）		M	多条用逗号隔开
     * uploadStatus	上送状态	varchar(10)		M	成功：SUCCESS | 失败：FAILURE'
     * uploadDesc	上送状态描述	varchar（1024）		M	上送状态描述
     */
    private String items;


}
