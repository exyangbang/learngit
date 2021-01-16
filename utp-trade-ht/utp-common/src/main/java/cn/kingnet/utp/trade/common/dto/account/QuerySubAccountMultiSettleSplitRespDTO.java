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
public class QuerySubAccountMultiSettleSplitRespDTO extends BaseResponseDTO {

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;


}
