package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import lombok.Builder;
import lombok.Data;

/**
 * @Description
 * @Author WJH
 * @Date 2018-10-09
 */
@Data
@Builder
public class BatchRecordedRespDTO extends BaseResponseDTO {


    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success;

}
