package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.TransferUser2UserReqDTO;
import cn.kingnet.utp.sdk.account.dto.TransferUser2UserRespDTO;
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
 * @Description 用户间转账（用户-用户转账）
 * @Author WJH
 * @Date 2019/09/27
 */
@Slf4j
public class API_09_TransferUser2UserServiceTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<TransferUser2UserRespDTO> builder = client.newTransferUser2UserRespBuilder();
            // 初始化requestBody
            TransferUser2UserReqDTO reqDTO = new TransferUser2UserReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
            reqDTO.setPayerUserAccount("9100001101000001245");
            reqDTO.setPayeeUserAccount("9100001101000001970");
            reqDTO.setPayAmt("10");
            reqDTO.setRemark("用户-用户 转账测试");

            builder.setReqData(reqDTO);

            log.info("用户间转账（用户-用户转账） 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<TransferUser2UserRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("用户间转账（用户-用户转账）异常：响应结果为null", serverResponse.getThrowable());
            } else {
                TransferUser2UserRespDTO respDTO = serverResponse.getRespData();
                log.info("用户间转账（用户-用户转账） 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("用户间转账（用户-用户转账） 成功");
                } else {
                    log.error("用户间转账（用户-用户转账）失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("用户间转账（用户-用户转账）异常：{}", e.getMessage(), e);
        }
    }

}
