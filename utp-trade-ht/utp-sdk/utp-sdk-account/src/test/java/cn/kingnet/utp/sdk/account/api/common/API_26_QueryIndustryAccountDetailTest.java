package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryIndustryAccountDetailReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryIndustryAccountDetailRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Description : 平台账户资金明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/21 15:12
 */
@Slf4j
public class API_26_QueryIndustryAccountDetailTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryIndustryAccountDetailRespDTO> builder = client.newQueryIndustryAccountDetailBuilder();
            // 初始化requestBody
            QueryIndustryAccountDetailReqDTO reqDTO = QueryIndustryAccountDetailReqDTO.builder().build();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setStartDate("20190117");
            reqDTO.setEndDate("20190518");
//            reqDTO.setOperateType("01");

            builder.setReqData(reqDTO);

            log.info("平台账户资金明细查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<QueryIndustryAccountDetailRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("平台账户资金明细查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryIndustryAccountDetailRespDTO respDTO = serverResponse.getRespData();
                log.info("平台账户资金明细查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("平台账户资金明细查询 客户号:{} 资金明细items：{}",respDTO.getIndustryCode(),JSON.parseArray(respDTO.getItems()));
                } else {
                    log.error("平台账户资金明细查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("平台账户资金明细查询异常：{}", e.getMessage(), e);
        }
    }
}