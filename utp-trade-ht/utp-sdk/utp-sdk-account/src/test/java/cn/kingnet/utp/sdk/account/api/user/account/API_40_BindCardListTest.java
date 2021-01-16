package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.BindCardListReqDTO;
import cn.kingnet.utp.sdk.account.dto.BindCardListRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 绑卡列表查询
 * @Author caixh
 * @Date 2020/3/25.
 */
@Slf4j
public class API_40_BindCardListTest extends UtpAccountTestCase {

    @Test
    public void test(){
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN),host);
            AccountClient.Builder<BindCardListRespDTO> builder = client.newBindCardListRespBuilder();
            //
            BindCardListReqDTO reqDTO = new BindCardListReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000000500");
//            reqDTO.setAcctNo("6200861111111111746");

            builder.setReqData(reqDTO);

            log.info("绑卡列表查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<BindCardListRespDTO> serverResponse = send(builder);


            if (serverResponse.getRespData() == null) {
                log.error("绑卡列表查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                BindCardListRespDTO respDTO = serverResponse.getRespData();
                log.info("绑卡列表查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("绑卡列表查询 成功");
                } else {
                    log.error("绑卡列表查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        }catch (Exception e){
            log.error("绑卡列表查询异常：{}", e.getMessage(), e);
        }
    }
}
