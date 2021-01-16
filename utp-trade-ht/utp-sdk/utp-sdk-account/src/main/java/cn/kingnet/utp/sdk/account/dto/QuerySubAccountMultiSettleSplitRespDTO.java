package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
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
public class QuerySubAccountMultiSettleSplitRespDTO extends BaseResponseDTO {

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;


}
