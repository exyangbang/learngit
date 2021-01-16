package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UnBindReqDTO;
import cn.kingnet.utp.sdk.account.dto.UnBindRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 个人|企业 解除绑定卡 解绑
 * @Author WJH
 * @Create 2019/5/29 18:13
 */
@Slf4j
public class API_07_UnBindTest extends UtpAccountTestCase {


	@Test
	public void test() {
		try {
			AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
			AccountClient.Builder<UnBindRespDTO> builder = client.newUnBindRespBuilder();
			// 初始化requestBody
			UnBindReqDTO reqDTO = new UnBindReqDTO();
			reqDTO.setClientTradeId(mockClientTransId());
			reqDTO.setUserAccount("9100001101000000555");
			reqDTO.setAcctNo("6200861111111111715");

			builder.setReqData(reqDTO);

            log.info("个人|企业账户解绑 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<UnBindRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("个人|企业账户解绑异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UnBindRespDTO respDTO = serverResponse.getRespData();
                log.info("个人|企业账户解绑 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("个人|企业账户解绑 解绑成功 ");
                } else {
                    log.error("个人|企业账户解绑失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("个人|企业账户解绑异常：{}", e.getMessage(), e);
        }
	}
}
