package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @author zhongli
 * @date 2019-02-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenAccountReqDTO extends BaseRequestDTO {
	/**
	 * 接入方用户号（接入方系统用户的唯一标志）
	 */
	private String userNo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 证件类型
	 */
	private String idType;
	/**
	 * 证件号
	 */
	private String idCode;
	/**
	 * 用户昵称（非必填）
	 */
	private String nickName;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 邮箱（非必填）
	 */
	private String email;
	/**
	 * 性别（非必填）
	 * M男 F女
	 */
	private String sex;
	/**
	 * 国籍 、地区编码
	 */
	private String country;
	/**
	 * 职业
	 */
	private String prosession;
	/**
	 * 住所/工作地址（非必填）
	 */
	private String address;
	/**
	 * 证件有效期（非必填）
	 * yyyy-MM-dd
	 */
	private String idIndate;
	/**
	 * 个人证件正面图片
	 * Base64字符串 <200k
	 */
	private String personPicA;
	/**
	 * 个人证件反面图片
	 * Base64字符串 <200k
	 */
	private String personPicB;
	/**
	 * 账户性质：普通账户/佣金账户
	 */
	private String nature;
}
