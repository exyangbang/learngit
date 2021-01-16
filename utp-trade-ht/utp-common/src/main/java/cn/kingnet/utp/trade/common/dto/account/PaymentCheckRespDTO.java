package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author caixh
 * @Date 2020/3/23.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCheckRespDTO extends BaseResponseDTO {
    /**
     * 绑定状态
     */
    private String bindStatus;
    /**
     * 渠道返回码
     */
    private String errCode;
    /**
     * 渠道返回信息描述
     */
    private String errMsg;
}
