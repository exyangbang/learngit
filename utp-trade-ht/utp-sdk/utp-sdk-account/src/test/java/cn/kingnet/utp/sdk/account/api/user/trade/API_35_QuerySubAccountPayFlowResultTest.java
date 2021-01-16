package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QuerySubAccountPayFlowRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/12
 */
@Slf4j
public class API_35_QuerySubAccountPayFlowResultTest extends UtpAccountTestCase {
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QuerySubAccountPayFlowRespDTO> builder = client.newQuerySubAccountPayFlowBuilder();
            // 初始化requestBody
            QuerySubAccountPayFlowRespDTO reqDTO = new QuerySubAccountPayFlowRespDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setBatchNo("1509011");

            builder.setReqData(reqDTO);

            log.info("查询子账户入金流水报备结果 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QuerySubAccountPayFlowRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("查询子账户入金流水报备结果异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QuerySubAccountPayFlowRespDTO respDTO = serverResponse.getRespData();
                log.info("查询子账户入金流水报备结果 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("查询子账户入金流水报备结果 成功 ,处理批次状态：{}",respDTO.getBatchStatus());
                } else {
                    log.error("查询子账户入金流水报备结果失败：status[{}] 处理批次状态  异常信息:{}", respDTO.getStatus(),respDTO.getBatchStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("查询子账户入金流水报备结果异常：{}", e.getMessage(), e);
        }
    }

}
