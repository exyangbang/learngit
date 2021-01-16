package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: sheqingquan@scenetec.com
 * @Description: 接口用户账户资金冻结/解冻信息
 * @Date: 2019/10/19 10:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreeFundsOpeApprovalBo implements Serializable {
	/**虚拟账户账号**/
	private String userAccount;

	/**冻结金额（单位分）**/
	private Long amount;

	/**服务端交易流水号**/
	private String serverTransId;

	/**客户端交易流水号**/
	private String clientTradeId;

	/**操作类型：0-冻结 1-解冻**/
	private String operationType;

	/**冻结的id**/
	private Long freezeId;

	/**冻结状态（0-待审核 1-审核通过 2-审核驳回）**/
	private String unfreezeStatus;
}