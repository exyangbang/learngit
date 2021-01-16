package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.OpenAccountEntReqDTO;
import cn.kingnet.utp.sdk.account.dto.OpenAccountRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 企业开户
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/30 14:21
 */
@Slf4j
public class API_02_OpenAccountEntTest extends UtpAccountTestCase {

	/**
	 * 测试入口
	 * @throws Exception
	 */
	@Test
	public void test() {
		try {
			AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
			AccountClient.Builder<OpenAccountRespDTO> builder = client.newOpenAccountEntBuilder();
			// 初始化requestBody
			OpenAccountEntReqDTO reqDTO = new OpenAccountEntReqDTO();
			reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
			reqDTO.setUserNo("1111111111111111111");
			reqDTO.setPersonName("测试企业法人");
			reqDTO.setEnterpriseName("测试企业开户");
			reqDTO.setRegAddress("厦门万达");
			reqDTO.setPersonIdType("101");
			reqDTO.setPersonIdCode("111111111111111111");
			reqDTO.setBusinessLicenseCode("00000000000000000");
			reqDTO.setNickName("测试企业开户");
			reqDTO.setMobile("15396396895");
			reqDTO.setEmail("645014281@qq.com");
			reqDTO.setNature("2");
			reqDTO.setCountry("CHN");
			reqDTO.setOccupation("C2031");
			builder.setReqData(reqDTO);

			log.info("企业开户 请求报文:{}", JSON.toJSONString(builder.getReqData()));

			for(int i=0;i<2;i++) {
				ServerResponse<OpenAccountRespDTO> serverResponse = send(builder);

				if (serverResponse.getRespData() == null) {
					log.error("企业开户异常：响应结果为null", serverResponse.getThrowable());
				} else {
					OpenAccountRespDTO respDTO = serverResponse.getRespData();
					log.info("企业开户 响应报文:{}", JSON.toJSONString(respDTO));
					HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
					if (httpRespStatus.is2xxSuccessful()) {
						log.info("企业开户 虚拟账户[{}]", respDTO.getUserAccount());
					} else {
						log.error("企业开户失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
					}
				}
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			log.error("企业开户异常：{}", e.getMessage(), e);
		}
	}
}
