package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.FreezeBalanceReqDTO;
import cn.kingnet.utp.sdk.account.dto.FreezeBalanceRespDTO;
import cn.kingnet.utp.sdk.account.dto.WithdrawReqDTO;
import cn.kingnet.utp.sdk.account.dto.WithdrawRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 用户账户资金冻结/解冻
 * @Author WJH
 * @Date 2018年09月14日
 */
@Slf4j
public class API_31_FreezeBalanceTest extends UtpAccountTestCase {

	@Test
	public void test() {
		try {
			AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
			AccountClient.Builder<FreezeBalanceRespDTO> builder = client.newFreezeBalanceBuilder();
			// 初始化requestBody
			FreezeBalanceReqDTO reqDTO = new FreezeBalanceReqDTO();
			reqDTO.setClientTradeId(mockClientTransId());
			reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			reqDTO.setUserAccount("9100001101000000390");
			reqDTO.setAmount("100");
			reqDTO.setType("0");
			reqDTO.setOrigTradeId(mockClientTransId());

			builder.setReqData(reqDTO);

			log.info("用户账户资金冻结/解冻 请求报文:{}", JSON.toJSONString(builder.getReqData()));

			ServerResponse<FreezeBalanceRespDTO> serverResponse = send(builder);

			if (serverResponse.getRespData() == null) {
				log.error("用户账户资金冻结/解冻异常：响应结果为null", serverResponse.getThrowable());
			} else {
				FreezeBalanceRespDTO respDTO = serverResponse.getRespData();
				log.info("用户账户资金冻结/解冻 响应报文:{}", JSON.toJSONString(respDTO));
				HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
				if (httpRespStatus.is2xxSuccessful()) {
					log.info("用户账户资金冻结/解冻 成功");
				} else {
					log.error("用户账户资金冻结/解冻失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
				}
			}
		} catch (Exception e) {
			log.error("用户账户资金冻结/解冻异常：{}", e.getMessage(), e);
		}
	}
}
