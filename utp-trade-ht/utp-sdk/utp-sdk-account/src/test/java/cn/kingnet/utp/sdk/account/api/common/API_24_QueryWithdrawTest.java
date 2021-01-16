package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryWithdrawReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryWithdrawRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 交易结果查询
 * @Author WJH
 * @Date 2018年09月14日
 */
@Slf4j
public class API_24_QueryWithdrawTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryWithdrawRespDTO> builder = client.newQueryWithdrawRespBuilder();
            // 初始化requestBody
            QueryWithdrawReqDTO reqDTO = new QueryWithdrawReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate("20200727");
            reqDTO.setOrigServerTradeId("20200727HM030449287670989701885954");
//            reqDTO.setOrigClientTradeId("2020072217UTP1285865405714010113");

            builder.setReqData(reqDTO);

            log.info("交易结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<QueryWithdrawRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("交易结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryWithdrawRespDTO respDTO = serverResponse.getRespData();
                log.info("交易结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("交易结果查询 交易状态[{}]-{}", respDTO.getTransStatus(), respDTO.getStatusDesc());
                } else {
                    log.error("交易结果查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("交易结果查询异常：{}", e.getMessage(), e);
        }
    }
}
