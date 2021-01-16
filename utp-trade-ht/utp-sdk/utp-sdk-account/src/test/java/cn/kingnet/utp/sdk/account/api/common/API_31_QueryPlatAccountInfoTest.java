package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.PlatAccountListReqDTO;
import cn.kingnet.utp.sdk.account.dto.PlatAccountListRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sheqingquan@scenetec.com
 * @description: 平台账户列表查询
 * @create 2020/4/9 20:12
 */
@Slf4j
public class API_31_QueryPlatAccountInfoTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<PlatAccountListRespDTO> builder = client.newQueryPlatAccountInfoBuilder();
            PlatAccountListReqDTO reqDTO = new PlatAccountListReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            builder.setReqData(reqDTO);

            log.info("平台账户列表查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<PlatAccountListRespDTO> serverResponse = send(builder);


            if (serverResponse.getRespData() == null) {
                log.error("平台账户列表查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                PlatAccountListRespDTO respDTO = serverResponse.getRespData();
                log.info("平台账户列表查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("平台账户列表查询 成功");
                } else {
                    log.error("平台账户列表查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("平台账户列表查询异常：{}", e.getMessage(), e);
        }
    }
}
