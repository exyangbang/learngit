package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description: 平台账户列表查询
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 10:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlatAccountListRespDTO extends BaseResponseDTO {
    /**
     * 平台账户信息Json字符串
     */
    private String accountList;
}