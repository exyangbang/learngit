package cn.kingnet.utp.sdk.account.api.industry.split;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QueryOutsideTransOrderResultReqDTO;
import cn.kingnet.utp.sdk.account.dto.QueryOutsideTransOrderResultRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 订单|支付交易流水文件上送结果查询
 * @Author WJH
 * @Date 2018年11月04日
 */
@Slf4j
public class API_18_QueryOutsideTransOrderResultTest extends UtpAccountTestCase {

    @Test
    public void testQueryOutsideTransOrderResult() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QueryOutsideTransOrderResultRespDTO> builder = client.newQueryOutsideTransOrderResultBuilder();
            // 初始化requestBody
            QueryOutsideTransOrderResultReqDTO reqDTO = new QueryOutsideTransOrderResultReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setBatchNo("1002012300001110026");
//            reqDTO.setBatchNo(mockBatchNo());

            builder.setReqData(reqDTO);
            log.info("订单/支付流水上送结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QueryOutsideTransOrderResultRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("订单/支付流水上送结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QueryOutsideTransOrderResultRespDTO respDTO = serverResponse.getRespData();
                log.info("订单/支付流水上送结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("订单/支付流水上送结果查询 客户号:{} 批次号:{} ",respDTO.getIndustryCode(),reqDTO.getBatchNo());
                    JSONArray jsonArray = JSON.parseArray(respDTO.getItems());
                    jsonArray.forEach(row->{
                        log.info("订单/支付流水上送结果查询 明细交易状态：{}",JSON.toJSONString(row));
                    });

                } else {
                    log.error("订单/支付流水上送结果查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("订单/支付流水上送结果查询异常：{}", e.getMessage(), e);
        }
    }


}
