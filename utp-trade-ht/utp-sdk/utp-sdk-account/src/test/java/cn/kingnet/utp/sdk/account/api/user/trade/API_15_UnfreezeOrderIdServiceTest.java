package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UnfreezeOrderIdReqDTO;
import cn.kingnet.utp.sdk.account.dto.UnfreezeOrderIdRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description 订单金额解冻
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_15_UnfreezeOrderIdServiceTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<UnfreezeOrderIdRespDTO> builder = client.newUnfreezeOrderIdRespBuilder();
            // 初始化requestBody

            UnfreezeOrderIdReqDTO reqDTO = UnfreezeOrderIdReqDTO.builder().build();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setOrderId("20190625HM030603671100000000150001");
            reqDTO.setPayAmt("100");
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            reqDTO.setUserAccount("9100001101000001970");

            builder.setReqData(reqDTO);

            log.info("订单金额解冻 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<UnfreezeOrderIdRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("订单金额解冻异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UnfreezeOrderIdRespDTO respDTO = serverResponse.getRespData();
                log.info("订单金额解冻 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("订单金额解冻 成功：{}",JSON.toJSONString(respDTO));
                } else {
                    log.error("订单金额解冻失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("订单金额解冻异常：{}", e.getMessage(), e);
        }
    }
}
