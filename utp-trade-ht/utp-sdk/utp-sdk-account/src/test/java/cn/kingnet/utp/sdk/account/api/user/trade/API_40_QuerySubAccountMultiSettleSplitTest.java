package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QuerySubAccountMultiSettleSplitReqDTO;
import cn.kingnet.utp.sdk.account.dto.QuerySubAccountMultiSettleSplitRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author WJH
 * @description: 子账户多级分账结果查询
 * @create 2020/03/29
 */
@Slf4j
public class API_40_QuerySubAccountMultiSettleSplitTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QuerySubAccountMultiSettleSplitRespDTO> builder = client.newQuerySubAccountMultiSettleSplitBuilder();
            // 初始化requestBody
            QuerySubAccountMultiSettleSplitReqDTO reqDTO = new QuerySubAccountMultiSettleSplitReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setSettleDate("20200729");
            reqDTO.setBatchNo("0924261");
            builder.setReqData(reqDTO);

            log.info("子账户多级分账结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QuerySubAccountMultiSettleSplitRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("子账户多级分账结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QuerySubAccountMultiSettleSplitRespDTO respDTO = serverResponse.getRespData();
                log.info("子账户多级分账结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("子账户多级分账结果查询 成功 处理结果：{}",respDTO.getSuccess());
                } else {
                    log.error("子账户多级分账结果查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("子账户多级分账结果查询异常：{}", e.getMessage(), e);
        }
    }
}
