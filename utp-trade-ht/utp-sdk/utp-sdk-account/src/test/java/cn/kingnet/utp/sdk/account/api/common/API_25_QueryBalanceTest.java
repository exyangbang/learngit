package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryBalanceReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryBalanceRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 账户余额查询
 * @Author WJH
 * @Date 2018年09月14日
 */
@Slf4j
public class API_25_QueryBalanceTest extends UtpAccountTestCase {

    @Test
    public void testQueryBalance() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryBalanceRespDTO> builder = client.newQueryBalanceBuilder();
            // 初始化requestBody
            QueryBalanceReqDTO reqDTO = new QueryBalanceReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
//            reqDTO.setUserAccount("9100001101000001245");
            reqDTO.setIndustryCode("UMS000001");


            builder.setReqData(reqDTO);
            log.info("账户余额查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<QueryBalanceRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("账户余额查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryBalanceRespDTO respDTO = serverResponse.getRespData();
                log.info("账户余额查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("账户余额查询 总余额[{}]=可用余额[{}]+冻结金额[{}]",respDTO.getBalance(),respDTO.getAvailAmount(),respDTO.getFrozenAmount());
                } else {
                    log.error("账户余额查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("账户余额查询异常：{}", e.getMessage(), e);
        }
    }
}
