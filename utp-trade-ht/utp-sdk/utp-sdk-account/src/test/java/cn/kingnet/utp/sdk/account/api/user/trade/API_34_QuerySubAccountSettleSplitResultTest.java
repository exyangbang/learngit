package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.SubaccountSettleSplitResultReqDTO;
import cn.kingnet.utp.sdk.account.dto.SubaccountSettleSplitResultRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sheqingquan@scenetec.com
 * @description: 子账户清算分账结果查询
 * @create 2020/2/13 11:36
 */
@Slf4j
public class API_34_QuerySubAccountSettleSplitResultTest extends UtpAccountTestCase {

    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<SubaccountSettleSplitResultRespDTO> builder = client.newQuerySubAccountSettleSplitResultBuilder();
            // 初始化requestBody
            SubaccountSettleSplitResultReqDTO reqDTO = new SubaccountSettleSplitResultReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setSettleDate("20200217");
            reqDTO.setUserAccount("9100001101000000130");
            reqDTO.setBatchNo("1529301");
            builder.setReqData(reqDTO);

            log.info("子账户清算分账结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<SubaccountSettleSplitResultRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("子账户清算分账结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                SubaccountSettleSplitResultRespDTO respDTO = serverResponse.getRespData();
                log.info("子账户清算分账结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                        if("true".equals(respDTO.getSuccess())){
                            log.info("子账户清算分账结果查询 成功 处理结果成功 批次状态:{}",respDTO.getBatchStatus());
                        }else{
                            log.info("子账户清算分账结果查询 成功 处理结果失败 批次状态:{}",respDTO.getBatchStatus());
                        }
                } else {
                    log.error("子账户清算分账结果查询异常：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("子账户清算分账结果查询异常：{}", e.getMessage(), e);
        }
    }
}
