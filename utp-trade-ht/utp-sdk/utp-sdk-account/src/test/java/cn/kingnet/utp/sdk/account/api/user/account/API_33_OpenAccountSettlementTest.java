package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.FreezeBalanceRespDTO;
import cn.kingnet.utp.sdk.account.dto.OpenAccountSettlementReqDTO;
import cn.kingnet.utp.sdk.account.dto.OpenAccountSettlementRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author sheqingquan@scenetec.com
 * @description: 待结算账户开户测试
 * @create 2020/2/13 10:37
 */
@Slf4j
public class API_33_OpenAccountSettlementTest extends UtpAccountTestCase {

    @Test
    public void test(){
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<OpenAccountSettlementRespDTO> builder = client.newOpenAccountSettlementBuilder();
            // 初始化requestBody
            OpenAccountSettlementReqDTO reqDTO = new OpenAccountSettlementReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setUserAccount("9100001101000000134");

            builder.setReqData(reqDTO);

            log.info("待结算账户开户 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<OpenAccountSettlementRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("待结算账户开户异常：响应结果为null", serverResponse.getThrowable());
            } else {
                OpenAccountSettlementRespDTO respDTO = serverResponse.getRespData();
                log.info("待结算账户开户 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("待结算账户开户 成功");
                } else {
                    log.error("待结算账户开户失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        }catch (Exception e){
            log.error("待结算账户开户异常：{}", e.getMessage(), e);
        }
    }
}