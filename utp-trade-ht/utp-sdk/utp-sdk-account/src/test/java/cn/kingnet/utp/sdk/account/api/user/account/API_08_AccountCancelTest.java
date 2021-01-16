package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.AccountCancelReqDTO;
import cn.kingnet.utp.sdk.account.dto.AccountCancelRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 个人|企业账户销户
 * @Author WJH
 * @Date 2019/09/27
 */
@Slf4j
public class API_08_AccountCancelTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<AccountCancelRespDTO> builder = client.newAccountCancelBuilder();
            // 初始化requestBody
            AccountCancelReqDTO reqDTO = new AccountCancelReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000002152");//9100001101000002151 9100001101000002152
            builder.setReqData(reqDTO);

            log.info("个人|企业账户销户 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<AccountCancelRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("个人|企业账户销户异常：响应结果为null", serverResponse.getThrowable());
            } else {
                AccountCancelRespDTO respDTO = serverResponse.getRespData();
                log.info("个人|企业账户销户 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("个人|企业账户销户成功");
                } else {
                    log.error("个人|企业账户销户失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("个人|企业账户销户异常：{}", e.getMessage(), e);
        }
    }

}
