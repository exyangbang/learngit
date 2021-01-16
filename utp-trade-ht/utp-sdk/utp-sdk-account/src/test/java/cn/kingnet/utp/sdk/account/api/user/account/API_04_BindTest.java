package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.BindReqDTO;
import cn.kingnet.utp.sdk.account.dto.BindRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 个人绑卡
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 18:13
 */
@Slf4j
public class API_04_BindTest extends UtpAccountTestCase {


	@Test
	public void test() {
		try {
			AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
			AccountClient.Builder<BindRespDTO> builder = client.newBindRespDTOBuilder();
			// 初始化requestBody
			BindReqDTO reqDTO = new BindReqDTO();
			reqDTO.setClientTradeId(mockClientTransId());
			reqDTO.setUserAccount("9100001101000002158");
			reqDTO.setVerifyType("4");
			reqDTO.setAcctNo("6226090000000048");
			reqDTO.setMobile("18100000000");
			reqDTO.setRemark("备注");

//            张三
//            证件号：510265790128303
//            手机号：18100000000
//            银行卡号：6226090000000048

			builder.setReqData(reqDTO);



            log.info("个人账户绑卡 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<BindRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("个人账户绑卡异常：响应结果为null", serverResponse.getThrowable());
            } else {
                BindRespDTO respDTO = serverResponse.getRespData();
                log.info("个人账户绑卡 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("个人账户绑卡 绑卡成功 ");
                } else {
                    log.error("个人账户绑卡失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("个人账户绑卡异常：{}", e.getMessage(), e);
        }
	}
}
