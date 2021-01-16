package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

/**
 * @Description: 企业证件认证鉴权绑卡返回
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 16:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthBindEntRespDTO extends BaseResponseDTO {

	/**
	 * 账户状态
	 */
	private String accountStatus;

}
