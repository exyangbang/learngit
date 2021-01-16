package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.SplitPaymentRefundReqDTO;
import cn.kingnet.utp.sdk.account.dto.SplitPaymentRefundRespDTO;
import cn.kingnet.utp.sdk.account.dto.SplitPaymentReqDTO;
import cn.kingnet.utp.sdk.account.dto.SplitPaymentRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Description 单笔实时分账退款
 * @Author caixh
 * @Date 2020/07/01
 */
@Slf4j
public class API_42_SplitPaymentRefundTest extends UtpAccountTestCase {
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);

            for(int i=0;i<2;i++) {
//                CompletableFuture.runAsync(() -> {


                    AccountClient.Builder<SplitPaymentRefundRespDTO> builder = client.newSplitPaymentRefundBuilder();
                    // 初始化requestBody


                    SplitPaymentRefundReqDTO reqDTO = new SplitPaymentRefundReqDTO();

                    reqDTO.setPayAmt("4");
                    reqDTO.setRemark("20200415105418");
                    reqDTO.setOrigClientTradeId("A0000000010");


                    reqDTO.setClientTradeId(mockClientTransId());
                    builder.setReqData(reqDTO);

                    log.info("单笔实时分账退款 请求报文:{}", JSON.toJSONString(builder.getReqData()));

                    ServerResponse<SplitPaymentRefundRespDTO> serverResponse = send(builder);

                    if (serverResponse.getRespData() == null) {
                        log.error("单笔实时分账退款异常：响应结果为null", serverResponse.getThrowable());
                    } else {
                        SplitPaymentRefundRespDTO respDTO = serverResponse.getRespData();
                        log.info("单笔实时分账退款 响应报文:{}", JSON.toJSONString(respDTO));
                        HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                        if (httpRespStatus.is2xxSuccessful()) {
                            log.info("单笔实时分账退款 成功");
                        } else {
                            log.error("单笔实时分账退款失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                        }
                    }
//                });
            }

//            Thread.sleep(90000);
        } catch (Exception e) {
            log.error("单笔实时分账退款异常：{}", e.getMessage(), e);
        }
    }



}
