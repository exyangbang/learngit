package cn.kingnet.utp.trade.common.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/25
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonOrOrgHotspotReqDTO implements Serializable {

	/**
	 * 虚拟账户id M
	 */
	private String id;
	/**
	 * 虚拟账户号 M
	 */
	private String account;
	/**
	 * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户） M
	 */
	private String type;
	/**
	 * 归属对象编号（行业或商户编码） M
	 */
	private String code;
	/**
	 * 归属对象名称 M
	 */
	private String name;
	/**
	 * 资金账户 M
	 */
	private String fundAccount;
}