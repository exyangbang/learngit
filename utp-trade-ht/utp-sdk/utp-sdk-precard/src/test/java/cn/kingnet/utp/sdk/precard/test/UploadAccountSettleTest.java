package cn.kingnet.utp.sdk.precard.test;

import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.precard.PreCardClient;
import cn.kingnet.utp.sdk.precard.UtpPreCardTestCase;
import cn.kingnet.utp.sdk.precard.dto.UploadAccountSettleReqDTO;
import cn.kingnet.utp.sdk.precard.dto.UploadAccountSettleRespDTO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 预付费卡清算文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 19:08
 */
public class UploadAccountSettleTest extends UtpPreCardTestCase {

    /**
     * 预付费卡清算文件上送
     *
     * @throws Exception
     */
    @Test
    public void testMain(){
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            PreCardClient client = new PreCardClient(createAuthorization(AuthType.HTSIGN), host);
            PreCardClient.Builder<UploadAccountSettleRespDTO> builder = client.newUploadAccountSettleBuilder();

            UploadAccountSettleReqDTO reqDTO = new UploadAccountSettleReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setSettleDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setBatchNo(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setPayeeAcctNo("sdf21312");
            reqDTO.setPayeeName("sdf");
            reqDTO.setPayeeOpbk("1231");
            reqDTO.setShowPayerAcctNo("12039812");
            reqDTO.setShowPayerName("张三");
            reqDTO.setCallbackUrl("http://localhost:9810/test/resultCallback");
            /**
             * 实时文件流内容，base64字符串 必填
             */
            byte[] fileAy = DataUtil.fileToByte(new File("D:\\file\\ceshisettle.txt"));
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
