package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryAuthAccountStatusReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryAuthAccountStatusRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.enums.MerAuthStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 企业账户鉴权绑卡审核结果查询
 * @Author WJH
 * @Date 2019/09/27
 */
@Slf4j
public class API_06_AuthEntStatusTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryAuthAccountStatusRespDTO> builder = client.newQueryAuthAccountStatusBuilder();
            // 初始化requestBody
            QueryAuthAccountStatusReqDTO reqDTO = new QueryAuthAccountStatusReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000002152");//9100001101000002151 9100001101000002152
            builder.setReqData(reqDTO);

            log.info("企业账户鉴权绑卡审核结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QueryAuthAccountStatusRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("企业账户鉴权绑卡审核结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryAuthAccountStatusRespDTO respDTO = serverResponse.getRespData();
                log.info("企业账户鉴权绑卡审核结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(respDTO.getAuthStatus());
                    log.info("企业账户鉴权绑卡审核结果查询 审核状态[{}] {}", merAuthStatus.getCode(),merAuthStatus.getValue());
                } else {
                    log.error("企业账户鉴权绑卡审核结果查询失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("企业账户鉴权绑卡审核结果查询异常：{}", e.getMessage(), e);
        }
    }

}
