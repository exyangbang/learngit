package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryAccountStatusReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryAccountStatusRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AccountStatus;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 账户状态查询
 * @Author WJH
 * @Date 2019/09/27
 */
@Slf4j
public class API_03_QueryAccountStatusTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryAccountStatusRespDTO> builder = client.newQueryAccountStatusBuilder();
            // 初始化requestBody
            QueryAccountStatusReqDTO reqDTO = new QueryAccountStatusReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000002152");//9100001101000002151 9100001101000002152
            builder.setReqData(reqDTO);

            log.info("账户状态查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QueryAccountStatusRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("账户状态查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryAccountStatusRespDTO respDTO = serverResponse.getRespData();
                log.info("账户状态查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    AccountStatus accountStatus = AccountStatus.getEnum(respDTO.getAccountStatus());
                    log.info("账户状态查询 账户状态[{}] {}", accountStatus.getCode(),accountStatus.getValue());
                } else {
                    log.error("账户状态查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("账户状态查询异常：{}", e.getMessage(), e);
        }
    }

}
