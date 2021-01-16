package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description: 企业证件认证鉴权绑卡请求
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 16:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthBindEntReqDTO extends BaseRequestDTO {

	/**
	 * 虚拟账户(用户开户账户) M
	 */
	private String userAccount;
	/**
	 * 账号(认证账号) M
	 */
	private String acctNo;
	/**
	 * 账户名称 M
	 */
	private String acctName;
	/**
	 * 开户行号 M
	 */
	private String opBankCode;
	/**
	 * 开户行名称 M
	 */
	private String opBankName;
	/**
	 * 清算行号 M
	 */
	private String clBankCode;
	/**
	 * 营业执照图片 M
	 * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
	 */
	private String businessLicensePic;
	/**
	 * 法人证件正面照 M
	 * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
	 */
	private String personPicA;
	/**
	 * 法人证件反面照 M
	 * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
	 */
	private String personPicB;
	/**
	 * 认证回调地址 M
	 */
	private String callbackUrl;
	/**
	 * 开户许可证
	 * 不支持绑定多张卡的客户,该字段必传;支持绑定多张卡的客户，只需要在绑定第一张卡上送
	 */
	private String licensePic;
}