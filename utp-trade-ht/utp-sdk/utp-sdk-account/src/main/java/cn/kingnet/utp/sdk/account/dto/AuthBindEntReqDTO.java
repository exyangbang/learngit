package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 企业证件认证鉴权绑卡请求
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 16:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthBindEntReqDTO extends BaseRequestDTO {

	/**
	 * 虚拟账户(用户开户账户)
	 */
	private String userAccount;
	/**
	 * 账号(认证账号)
	 */
	private String acctNo;
	/**
	 * 账户名称
	 */
	private String acctName;
	/**
	 * 开户行号
	 */
	private String opBankCode;
	/**
	 * 开户行名称
	 */
	private String opBankName;
	/**
	 * 清算行号
	 */
	private String clBankCode;
	/**
	 * 营业执照图片
	 */
	private String businessLicensePic;
	/**
	 * 法人证件正面照
	 */
	private String personPicA;
	/**
	 * 法人证件反面照
	 */
	private String personPicB;
	/**
	 * 认证回调地址
	 */
	private String callbackUrl;
	/**
	 * 开户许可证
	 */
	private String licensePic;
}