package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class BatchRecordedRespDTO extends BaseResponseDTO {


    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;

}
