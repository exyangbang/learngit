package cn.kingnet.utp.sdk.account.api.industry.split;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UploadOutsideTransOrderReqDTO;
import cn.kingnet.utp.sdk.account.dto.UploadOutsideTransOrderRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.core.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 订单/支付 流水文件上送 || 是清分操作前的 前置必要文件
 * @Author WJH
 * @Date 2018年11月04日
 */
@Slf4j
public class API_17_UploadOutsideTransOrderTest extends UtpAccountTestCase {


    @Test
    public void testTmpMul(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0;i<500;i++){
            if(i!=0 && i%5==0){
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            CompletableFuture.runAsync(()->{
                testUploadOutsideTransOrder();
            },executorService);
            System.out.println("i = " + i);

        }

        System.out.println("executorService = 执行完成");
        executorService.shutdown();

    }

    @Test
    public void testUploadOutsideTransOrder() {

        try {
            String fileName = buildUploadFile();

            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<UploadOutsideTransOrderRespDTO> builder = client.newUploadOutsideTransOrderBuilder();
            // 初始化requestBody
            UploadOutsideTransOrderReqDTO reqDTO = new UploadOutsideTransOrderReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
//            reqDTO.setBatchNo("9999");
            reqDTO.setBatchNo(mockBatchNo());

            /**
             * 实时文件流内容，base64字符串 必填
             */
            byte[] fileAy = DataUtil.fileToByte(new File(getFilePath(), fileName));
            String content = DataUtil.deflaterAndEncode64(fileAy);
            reqDTO.setContent(content);
            builder.setReqData(reqDTO);

            log.info("订单/支付流水上送 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<UploadOutsideTransOrderRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("订单/支付流水上送异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UploadOutsideTransOrderRespDTO respDTO = serverResponse.getRespData();
                log.info("订单/支付流水上送 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("订单/支付流水上送 批次号[{}] 上送报备成功，批次状态:{}", reqDTO.getBatchNo(), respDTO.getBatchStatus());
                } else {
                    log.error("订单/支付流水上送失败：status[{}]，批次状态：{} 失败信息：{}", respDTO.getStatus(), respDTO.getBatchStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("订单/支付流水上送异常：{}", e.getMessage(), e);
        }

    }

    private AtomicLong atomicLong = new AtomicLong(0);

    public String buildUploadFile() {
        String curDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String curTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        int rows = 1000;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("H|pay_flow|%s|%s", curDate, rows));
        StringBuilder sbT = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int i = 0; i < rows; i++) {
            sb.append("\n");
            String clientTradeId = IdGenerate.mockUtpClientTransId();
            clientTradeId = clientTradeId.substring(clientTradeId.length() - 19, clientTradeId.length());
            sb.append(String.format("%s|%s|%s|9001|%s|0|凡客旗舰店|张三%s|T恤衫|备注说明|15606995632|Z2000133000019|A12312312412|buyerId123|1560695123|11201|物流信息", curDate, curTime, clientTradeId, (1000 + i), i));
            stringJoiner.add(clientTradeId);
        }
        System.out.println("stringJoiner = " + stringJoiner.toString());
        String fileName = buildFileName(atomicLong.incrementAndGet());
        DataUtil.byte2File(sb.toString().getBytes(StandardCharsets.UTF_8), getFilePath(), fileName);

        return fileName;
    }


    private String buildFileName(Long indexNum) {
        return String.format("transOrder-%s-%04d.txt", LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE), indexNum);
    }


}
