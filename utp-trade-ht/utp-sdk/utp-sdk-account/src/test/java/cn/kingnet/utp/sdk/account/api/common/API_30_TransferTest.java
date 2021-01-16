package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.TransferReqDTO;
import cn.kingnet.utp.sdk.account.dto.TransferRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

/**
 * @Description : 平台转账
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/21 14:22
 */
@Slf4j
public class API_30_TransferTest extends UtpAccountTestCase {

    /**
     * 平台转账
     *
     * @throws Exception
     */
    @Test
    public void test() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<TransferRespDTO> builder = client.newTransferRespBuilder();
            // 初始化requestBody
            TransferReqDTO reqDTO = new TransferReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setPayerAccNo("1010012179010000149");
            reqDTO.setPayerAccName("帝网科技账户代付平台1");
            reqDTO.setPayeeIndustryCode("002");
            reqDTO.setPayeeAccNo("1010012179010000149");
            reqDTO.setPayeeAccName("帝网科技账户代付平台1");
            reqDTO.setPayeeBankCode("323391060018");
            reqDTO.setPayAmt("100");
            reqDTO.setCallbackUrl("http://localhost:8077/test/splitCallback");
            reqDTO.setRemark("平台内部转账测试");

            builder.setReqData(reqDTO);

            log.info("平台间转账 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<TransferRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("平台间转账异常：响应结果为null", serverResponse.getThrowable());
            } else {
                TransferRespDTO respDTO = serverResponse.getRespData();
                log.info("平台间转账 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("平台间转账 平台[{}]转账给平台[{}] 成功", industryCode, reqDTO.getPayeeIndustryCode());
                } else {
                    log.error("平台间转账失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("平台间转账异常：{}", e.getMessage(), e);
        }
    }

}
