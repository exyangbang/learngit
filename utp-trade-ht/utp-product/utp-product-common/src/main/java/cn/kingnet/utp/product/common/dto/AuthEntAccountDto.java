package cn.kingnet.utp.product.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhongli
 * @date 2019-03-12
 */
@Setter
@Getter
public class AuthEntAccountDto implements Serializable {
	private static final String appid = "utp-manager-ht";
	public static final String secret = "mh7d3scgRHvk0AO6";
	/**
	 * 记录ID
	 */
	private String id;
	/**
	 * 审核结果 1=审核成功 2=审核失败
	 */
	private Integer authStatus;
	/**
	 * 审核备注
	 */
	private String authRemark;
	/**
	 * 签名
	 */
	private String sign;

	/**
	 * 修改人
	 */
	private String userModified;

	public String[] toSHA1(String secret) {
		return new String[]{"appid=" + appid, "secret=" + secret, "id=" + id, "authStatus=" + authStatus.toString(),
				"authRemark=" + authRemark};
	}
}
