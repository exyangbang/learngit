package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.TransferUser2IndustryReqDTO;
import cn.kingnet.utp.sdk.account.dto.TransferUser2IndustryRespDTO;
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
 * @Description 转账（用户-代付客户平台转账）
 * @Author WJH
 * @Date 2019/09/27
 */
@Slf4j
public class API_10_TransferUser2IndustryServiceTest extends UtpAccountTestCase {

    /**
     * 转账（用户-平台转账）
     *
     * @throws Exception
     */
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<TransferUser2IndustryRespDTO> builder = client.newTransferUser2IndustryRespBuilder();
            // 初始化requestBody
            TransferUser2IndustryReqDTO reqDTO = new TransferUser2IndustryReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setPayerUserAccount("9100001101000001970");
            reqDTO.setPayAmt("8");
            reqDTO.setRemark("转账（用户-平台转账） 转账测试");

            builder.setReqData(reqDTO);


            log.info("转账（用户-平台转账） 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<TransferUser2IndustryRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("转账（用户-平台转账）异常：响应结果为null", serverResponse.getThrowable());
            } else {
                TransferUser2IndustryRespDTO respDTO = serverResponse.getRespData();
                log.info("转账（用户-平台转账） 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("转账（用户-平台转账） 成功");
                } else {
                    log.error("转账（用户-平台转账）失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("转账（用户-平台转账）异常：{}", e.getMessage(), e);
        }
    }

}
