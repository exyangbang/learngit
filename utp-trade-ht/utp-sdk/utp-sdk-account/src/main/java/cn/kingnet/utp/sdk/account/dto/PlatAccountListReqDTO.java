package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 平台账户列表查询
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 10:21
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlatAccountListReqDTO extends BaseRequestDTO {

}