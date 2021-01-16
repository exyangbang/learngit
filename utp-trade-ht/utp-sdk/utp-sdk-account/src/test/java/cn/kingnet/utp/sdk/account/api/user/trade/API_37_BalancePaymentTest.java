package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.BalancePaymentReqDTO;
import cn.kingnet.utp.sdk.account.dto.BalancePaymentRespDTO;
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
 * @Description 余额支付
 * @Author WJH
 * @Date 2020/03/14
 */
@Slf4j
public class API_37_BalancePaymentTest extends UtpAccountTestCase {
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<BalancePaymentRespDTO> builder = client.newBalancePaymentBuilder();
            // 初始化requestBody
            BalancePaymentReqDTO reqDTO = new BalancePaymentReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setType("1");
            reqDTO.setPayerUserAccount("9100001101000005576");//9100001101000000711 9100001101000000718
            reqDTO.setPayeeUserAccount("9100001101000005573");
            reqDTO.setPayAmt("10");
            reqDTO.setTransNo(mockClientTransId());
            reqDTO.setShoppingInfo("余额支付测试");

            builder.setReqData(reqDTO);

            log.info("余额支付 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<BalancePaymentRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("余额支付异常：响应结果为null", serverResponse.getThrowable());
            } else {
                BalancePaymentRespDTO respDTO = serverResponse.getRespData();
                log.info("余额支付 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("余额支付 成功");
                } else {
                    log.error("余额支付失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("余额支付异常：{}", e.getMessage(), e);
        }
    }

}
