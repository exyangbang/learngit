package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.NewAuthBindEntReqDTO;
import cn.kingnet.utp.sdk.account.dto.NewAuthBindEntRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 企业鉴权、绑卡功能合并 京东
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 18:13
 */
@Slf4j
public class API_47_NewAuthBindEntTest extends UtpAccountTestCase {

	/**
	 * 测试入口
	 * @throws Exception
	 */
	@Test
	public void test() {
		try {
			AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
			AccountClient.Builder<NewAuthBindEntRespDTO> builder = client.newNewAuthBindEntBuilder();
			// 初始化requestBody
			NewAuthBindEntReqDTO reqDTO = new NewAuthBindEntReqDTO();
			reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
			reqDTO.setUserAccount("9100001101000006326");
			reqDTO.setAcctNo("100000000000000000001");
			reqDTO.setAcctName("测试企业开户（京东定制化）");
			reqDTO.setOpBankCode("307584007998");
			reqDTO.setOpBankName("建设银行");
			reqDTO.setClBankCode("");
			builder.setReqData(reqDTO);


			log.info("企业账户鉴权绑卡（京东定制化） 请求报文:{}", JSON.toJSONString(builder.getReqData()));

			ServerResponse<NewAuthBindEntRespDTO> serverResponse = send(builder);

			if (serverResponse.getRespData() == null) {
				log.error("企业账户鉴权绑卡（京东定制化）异常：响应结果为null", serverResponse.getThrowable());
			} else {
				NewAuthBindEntRespDTO respDTO = serverResponse.getRespData();
				log.info("企业账户鉴权绑卡（京东定制化） 响应报文:{}", JSON.toJSONString(respDTO));
				HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
				if (httpRespStatus.is2xxSuccessful()) {
					log.info("企业账户鉴权绑卡（京东定制化）受理成功");
				} else {
					log.error("企业账户鉴权绑卡（京东定制化）受理失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
				}
			}
		} catch (Exception e) {
			log.error("企业账户鉴权绑卡（京东定制化）异常：{}", e.getMessage(), e);
		}
	}
}
