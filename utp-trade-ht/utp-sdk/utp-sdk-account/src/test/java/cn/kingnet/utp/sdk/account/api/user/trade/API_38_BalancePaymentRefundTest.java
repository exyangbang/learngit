package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.BalancePaymentRefundReqDTO;
import cn.kingnet.utp.sdk.account.dto.BalancePaymentRefundRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 余额支付退款退款
 * @Author WJH
 * @Date 2020/03/14
 */
@Slf4j
public class API_38_BalancePaymentRefundTest extends UtpAccountTestCase {
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<BalancePaymentRefundRespDTO> builder = client.newBalancePaymentRefundBuilder();
            // 初始化requestBody
            BalancePaymentRefundReqDTO reqDTO = new BalancePaymentRefundReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setOrigClientTradeId("2020031515UTP1239096286343671809");
//            reqDTO.setOrigServerTradeId("20200314EM030449238835665232551938");
            reqDTO.setPayAmt("3");

            builder.setReqData(reqDTO);

            log.info("余额支付退款 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<BalancePaymentRefundRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("余额支付退款异常：响应结果为null", serverResponse.getThrowable());
            } else {
                BalancePaymentRefundRespDTO respDTO = serverResponse.getRespData();
                log.info("余额支付退款 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("余额支付退款 成功");
                } else {
                    log.error("余额支付退款失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("余额支付退款异常：{}", e.getMessage(), e);
        }
    }

}
