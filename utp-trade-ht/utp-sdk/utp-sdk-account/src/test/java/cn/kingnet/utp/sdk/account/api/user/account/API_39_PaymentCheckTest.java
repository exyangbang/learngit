package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.PaymentCheckReqDTO;
import cn.kingnet.utp.sdk.account.dto.PaymentCheckRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 对公打款验证
 * @Author caixh
 * @Date 2020/3/25.
 */
@Slf4j
public class API_39_PaymentCheckTest extends UtpAccountTestCase {

    @Test
    public void test(){
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN),host);
            AccountClient.Builder<PaymentCheckRespDTO> builder = client.newPaymentCheckRespBuilder();
            //
            PaymentCheckReqDTO reqDTO = new PaymentCheckReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000000500");
            reqDTO.setAcctNo("6200861111111111746");
            reqDTO.setAuthAmt("10");

            builder.setReqData(reqDTO);

            log.info("对公打款验证 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<PaymentCheckRespDTO> serverResponse = send(builder);


            if (serverResponse.getRespData() == null) {
                log.error("对公打款验证异常：响应结果为null", serverResponse.getThrowable());
            } else {
                PaymentCheckRespDTO respDTO = serverResponse.getRespData();
                log.info("对公打款验证 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("对公打款验证 成功");
                } else {
                    log.error("对公打款验证失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        }catch (Exception e){
            log.error("对公打款验证异常：{}", e.getMessage(), e);
        }
    }
}
