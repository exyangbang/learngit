package cn.kingnet.utp.scheduler.data.dto;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/15
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeeIncomeAccountCollectionRespDTO extends BaseResponseDTO {

    private String statMonth;
    private long transAmount;
    private String account;

    private String transStatus;
    private String transDesc;

}
