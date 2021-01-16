package cn.kingnet.utp.sdk.precard.test;

import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.core.utils.StringUtil;
import cn.kingnet.utp.sdk.precard.PreCardClient;
import cn.kingnet.utp.sdk.precard.UtpPreCardTestCase;
import cn.kingnet.utp.sdk.precard.dto.QueryAccountEntryReqDTO;
import cn.kingnet.utp.sdk.precard.dto.QueryAccountEntryRespDTO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 预付费卡入账结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/18 15:09
 */
public class QueryAccountEntryTest extends UtpPreCardTestCase {

    /**
     * 预付费卡入账结果查询
     *
     * @throws Exception
     */
    @Test
    public void testMain(){
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            PreCardClient client = new PreCardClient(createAuthorization(AuthType.HTSIGN), host);
            PreCardClient.Builder<QueryAccountEntryRespDTO> builder = client.newQueryAccountEntryBuilder();

            QueryAccountEntryReqDTO reqDTO = new QueryAccountEntryReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setBatchNo("185421");
            reqDTO.setEntryDate("20181219");
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
                        DataUtil.byte2File(fAy,"D:\\file",String.format("%s_%s.txt",respDTO.getEntryDate(),respDTO.getBatchNo()));
                        try {
                            System.out.println(new String(fAy,"utf-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                latch.countDown();
            });
            latch.await(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
