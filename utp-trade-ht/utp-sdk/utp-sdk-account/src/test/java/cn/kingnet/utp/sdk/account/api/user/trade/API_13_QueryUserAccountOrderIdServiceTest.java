package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryUserAccountOrderIdReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryUserAccountOrderIdRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description 账户订单入金查询
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_13_QueryUserAccountOrderIdServiceTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryUserAccountOrderIdRespDTO> builder = client.newQueryUserAccountOrderIdRespBuilder();
            // 初始化requestBody

            QueryUserAccountOrderIdReqDTO reqDTO = QueryUserAccountOrderIdReqDTO.builder().build();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setOrderId("3261019081415595801");
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            reqDTO.setUserAccount("9100001101000001970");

            builder.setReqData(reqDTO);

            log.info("账户订单入金查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QueryUserAccountOrderIdRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("账户订单入金查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryUserAccountOrderIdRespDTO respDTO = serverResponse.getRespData();
                log.info("账户订单入金查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("账户订单入金查询 成功：{}",JSON.toJSONString(respDTO));
                } else {
                    log.error("账户订单入金查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("账户订单入金查询异常：{}", e.getMessage(), e);
        }
    }
}
