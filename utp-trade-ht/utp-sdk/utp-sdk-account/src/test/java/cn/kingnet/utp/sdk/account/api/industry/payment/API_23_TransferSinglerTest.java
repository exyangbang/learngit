package cn.kingnet.utp.sdk.account.api.industry.payment;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.TransferSinglerPayReqDTO;
import cn.kingnet.utp.sdk.account.dto.TransferSinglerPayRespDTO;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @Description : 单笔实时代付
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/21 14:22
 */
@Slf4j
public class API_23_TransferSinglerTest extends UtpAccountTestCase {

    final AtomicLong succAtomicLong = new AtomicLong();
    final AtomicLong failAtomicLong = new AtomicLong();
    final AtomicLong nullAtomicLong = new AtomicLong();
    final AtomicLong totalAtomicLong = new AtomicLong();

    /**
     * 单笔实时代付
     *
     * @throws Exception
     */
    @Test
    public void test() {
        try {
            //是否压测标识
            boolean isPressureTest = false;
            int continueSeconds = 10;
            int tps = 30;

            //请求总笔数
            int totalReqRows = isPressureTest ? tps * continueSeconds : 1;

            ExecutorService executorService = Executors.newFixedThreadPool(50);
            final CountDownLatch continueSecondsLatch = new CountDownLatch(continueSeconds);

            ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);

            final CountDownLatch respLatch = new CountDownLatch(totalReqRows);
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);

            if (totalReqRows == 1) {
                doTransferSingler(client, respLatch);
            } else {
                schedule.scheduleAtFixedRate(() -> {
                    if (continueSecondsLatch.getCount() < 1) {
                        return;
                    }
                    continueSecondsLatch.countDown();
                    //每秒发起N笔请求
                    Stream.iterate(1, i -> i++).limit(tps).forEach(i -> {
                        executorService.submit(() -> {
                            doTransferSingler(client, respLatch);
                        });
                    });
                }, 1, 1, TimeUnit.SECONDS);

            }

            respLatch.await();

            log.info(" <<===请求总笔数:{} succ:{},fail:{},null:{}", totalAtomicLong.get(), succAtomicLong.get(), failAtomicLong.get(), nullAtomicLong.get());

            executorService.shutdown();
            schedule.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doTransferSingler(AccountClient client, CountDownLatch latch) {
        AccountClient.Builder<TransferSinglerPayRespDTO> builder = client.newTransferSinglerPayRespBuilder();
        // 初始化requestBody
        TransferSinglerPayReqDTO reqDTO = new TransferSinglerPayReqDTO();
        reqDTO.setClientTradeId(IdGenerate.mockUtpClientTransId());
        reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));

//        {"opBankCode":"307584007998","idType":"101","idCode":"341126197709218366","accName":"全渠道","businessLicenseCode":"",
//                "remark":"备注/附言","reqTime":"163009","payAmt":"400","showPayerAcctNo":"9100001101000000433",
//                "acctNo":"6216261000000000018","reqDate":"20190807","acctType":"0","opBankName":"平安银行",
//                "clientTradeId":"20190807163009","callbackUrl":"http://125.77.254.130:8899/mockCallback",
//                "clBankCode":"307584007998","showPayerName":"实时代付个人显示付款户名"}
        reqDTO.setOpBankCode("307584007998");
        reqDTO.setIdType("101");
        reqDTO.setIdCode("341126197709218366");

        reqDTO.setBusinessLicenseCode("123");
        reqDTO.setRemark(Thread.currentThread().getName() + "单笔实时代付");
        reqDTO.setShowPayerAcctNo("9100001101000000248");
        reqDTO.setAcctNo("6216261000000000018");
        reqDTO.setAccName("全渠道");
        reqDTO.setAcctType("2");
        reqDTO.setOpBankName("平安银行");
        reqDTO.setClBankCode("307584007998");
        reqDTO.setShowPayerName("显示付款户名");
        reqDTO.setCallbackUrl("http://125.77.254.130:8899/mockCallback");
        reqDTO.setPayAmt("100");
        builder.setReqData(reqDTO);

        String threadName = Thread.currentThread().getName();
        log.info("===>> 线程名:{} >> 请求数:{}", threadName, totalAtomicLong.incrementAndGet());
        builder.execute().whenComplete((paymentResponse, throwable) -> {
            if (throwable != null || paymentResponse == null) {
                log.error("---1exception---线程:{} << 状态码[{}] null计数[{}] 异常:{}", threadName, paymentResponse == null ? null : paymentResponse.getStatus(), nullAtomicLong.incrementAndGet(), throwable.getMessage());
            } else if (paymentResponse != null && "200".equals(paymentResponse.getStatus())) {
                log.info("---2processing---线程:{} << 状态码[{}] 成功计数[{}] 响应:{}", threadName, paymentResponse.getStatus(), succAtomicLong.incrementAndGet(), JSON.toJSONString(paymentResponse));
            } else {
                log.error("---3failure---线程:{} << 状态码[{}] 失败计数[{}] 响应:{}", threadName, paymentResponse.getStatus(), failAtomicLong.incrementAndGet(), JSON.toJSONString(paymentResponse));
            }

            latch.countDown();
        });

    }

}
