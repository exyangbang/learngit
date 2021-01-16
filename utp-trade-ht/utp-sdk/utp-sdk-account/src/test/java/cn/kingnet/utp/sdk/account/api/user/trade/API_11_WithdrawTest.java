package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.WithdrawReqDTO;
import cn.kingnet.utp.sdk.account.dto.WithdrawRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 账户提现
 * @Author WJH
 * @Date 2018年09月14日
 */
@Slf4j
public class API_11_WithdrawTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<WithdrawRespDTO> builder = client.newWithdrawRespBuilder();
            // 初始化requestBody
            WithdrawReqDTO reqDTO = new WithdrawReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setUserAccount("9100001101000005660");//9100001101000003385 9100001101000003404
            reqDTO.setPayAmt("300");
            reqDTO.setCallbackUrl("http://localhost:8077/test/splitCallback");
            reqDTO.setRemark("子账户单日限额测试");
            reqDTO.setAcctNo("6229807711500006537");

//            {"showPayerAcctNo":"","reqDate":"20200318","userAccount":"9100001101000000690","mobile":"18559565656",
//                    "clientTradeId":"20200318161902","callbackUrl":"http://192.168.214.16:8989/vc/test/call",
//                    "remark":"测试","reqTime":"161902","showPayerName":"","payAmt":"100"}
//


            builder.setReqData(reqDTO);


            log.info("账户提现 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<WithdrawRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("账户提现异常：响应结果为null", serverResponse.getThrowable());
            } else {
                WithdrawRespDTO respDTO = serverResponse.getRespData();
                log.info("账户提现 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("账户提现 受理成功，待回调通知或稍后交易结果查询 获取最终交易状态");
                } else {
                    log.error("账户提现失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("账户提现异常：{}", e.getMessage(), e);
        }
    }
}
