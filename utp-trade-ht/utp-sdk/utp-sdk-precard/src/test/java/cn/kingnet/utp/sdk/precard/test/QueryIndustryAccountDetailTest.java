package cn.kingnet.utp.sdk.precard.test;

import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.precard.PreCardClient;
import cn.kingnet.utp.sdk.precard.UtpPreCardTestCase;
import cn.kingnet.utp.sdk.precard.dto.QueryIndustryAccountDetailReqDTO;
import cn.kingnet.utp.sdk.precard.dto.QueryIndustryAccountDetailRespDTO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description : 平台账户资金明细查询
 * @Author : linkaigui
 * @Create : 2019/2/28 18:13
 */
public class QueryIndustryAccountDetailTest extends UtpPreCardTestCase {

    /**
     * 平台账户资金明细查询
     *
     * @throws Exception
     */
    @Test
    public void testMain(){
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            PreCardClient client = new PreCardClient(createAuthorization(AuthType.HTSIGN), host);
            PreCardClient.Builder<QueryIndustryAccountDetailRespDTO> builder = client.newQueryIndustryAccountDetailBuilder();

            QueryIndustryAccountDetailReqDTO reqDTO = new QueryIndustryAccountDetailReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setOperateType("");
            reqDTO.setStartDate("20181210");
            reqDTO.setEndDate("20181219");
            reqDTO.setPeerAccNo("");
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
