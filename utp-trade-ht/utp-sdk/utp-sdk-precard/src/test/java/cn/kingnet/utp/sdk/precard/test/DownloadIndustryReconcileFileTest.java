package cn.kingnet.utp.sdk.precard.test;

import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.core.utils.StringUtil;
import cn.kingnet.utp.sdk.precard.PreCardClient;
import cn.kingnet.utp.sdk.precard.UtpPreCardTestCase;
import cn.kingnet.utp.sdk.precard.dto.DownloadIndustryReconcileFileReqDTO;
import cn.kingnet.utp.sdk.precard.dto.DownloadIndustryReconcileFileRespDTO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 平台对账文件下载
 * @Author : linkaigui
 * @Create : 2019/2/28 18:06
 */
public class DownloadIndustryReconcileFileTest extends UtpPreCardTestCase {

    /**
     * 平台对账文件下载
     *
     * @throws Exception
     */
    @Test
    public void test() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            PreCardClient client = new PreCardClient(createAuthorization(AuthType.HTSIGN), host);
            PreCardClient.Builder<DownloadIndustryReconcileFileRespDTO> builder = client.newDownloadIndustryReconcileFileBuilder();

            // 初始化requestBody
            DownloadIndustryReconcileFileReqDTO reqDTO = DownloadIndustryReconcileFileReqDTO.builder().build();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setSettleDate("20181106");

            builder.setReqData(reqDTO);

            long start = System.currentTimeMillis();
            builder.execute().whenComplete((respDTO, throwable) -> {
                System.out.println("总共耗时："+ (System.currentTimeMillis() - start));
                if (throwable != null) {
                    throwable.printStackTrace();
                }
                if (respDTO != null) {
                    System.out.println(JSON.toJSONString(respDTO));
                    if("true".equalsIgnoreCase(respDTO.getSuccess()) && !StringUtil.isEmpty(respDTO.getContent())){
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy,"D:\\settle",String.format("%s_reconcile.txt",reqDTO.getSettleDate()));
                        try {
                            System.out.println(new String(fAy,"utf-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                latch.countDown();
            });
            latch.await(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
