package cn.kingnet.utp.sdk.precard.test;

import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.precard.PreCardClient;
import cn.kingnet.utp.sdk.precard.UtpPreCardTestCase;
import cn.kingnet.utp.sdk.precard.dto.UploadAccountEntryReqDTO;
import cn.kingnet.utp.sdk.precard.dto.UploadAccountEntryRespDTO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 预付费卡入账文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/17 11:59
 */
public class UploadAccountEntryTest extends UtpPreCardTestCase {

    /**
     * 预付费卡入账文件上送
     *
     * @throws Exception
     */
    @Test
    public void testMain() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            PreCardClient client = new PreCardClient(createAuthorization(AuthType.HTSIGN), host);
            PreCardClient.Builder<UploadAccountEntryRespDTO> builder = client.newUploadAccountEntryBuilder();

            UploadAccountEntryReqDTO reqDTO = new UploadAccountEntryReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setBatchNo(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setEntryDate("20190106");
            reqDTO.setCallbackUrl("http://localhost:9810/test/resultCallback");
            /**
             * 实时文件流内容，base64字符串 必填
             */
            byte[] fileAy = DataUtil.fileToByte(new File("D:\\file\\abcd.txt"));
            String content = DataUtil.deflaterAndEncode64(fileAy);
            reqDTO.setContent(content);

            builder.setReqData(reqDTO);

            long start = System.currentTimeMillis();
            builder.execute().whenComplete((respDTO, throwable) -> {
                System.out.println("总共耗时："+ (System.currentTimeMillis() - start));
                if (throwable != null) {
                    throwable.printStackTrace();
                }
                if (respDTO != null) {
                    System.out.println(JSON.toJSONString(respDTO));
                }
                latch.countDown();
            });
            latch.await(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
