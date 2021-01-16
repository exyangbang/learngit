package cn.kingnet.utp.sdk.account.api.industry.split;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.QuerySplitPayFlowResultReqDTO;
import cn.kingnet.utp.sdk.account.dto.QuerySplitPayFlowResultRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description 分账-支付流水关联补登文件处理结果查询
 * @Author WJH
 * @Date 2018年11月04日
 */
@Slf4j
public class API_22_QuerySplitPayFlowResultTest extends UtpAccountTestCase {

     
    @Test
    public void testQuerySplitPayFlowResult() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<QuerySplitPayFlowResultRespDTO> builder = client.newQuerySplitPayFlowResultBuilder();
            // 初始化requestBody
            QuerySplitPayFlowResultReqDTO reqDTO = new QuerySplitPayFlowResultReqDTO();
            reqDTO.setClientTradeId(IdGenerate.mockUtpClientTransId());
            reqDTO.setBatchNo("1435081");

            builder.setReqData(reqDTO);

            log.info("分账-支付流水关联补登文件处理结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<QuerySplitPayFlowResultRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("分账-支付流水关联补登文件处理结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                QuerySplitPayFlowResultRespDTO respDTO = serverResponse.getRespData();
                log.info("分账-支付流水关联补登文件处理结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("分账-支付流水关联补登文件处理结果查询 客户号:{} 批次号:{} ", industryCode, reqDTO.getBatchNo());
                    JSONArray itmes = JSON.parseArray(respDTO.getItems());
                    log.info("分账-支付流水关联补登文件处理结果查询 结果：\n{}", JSON.toJSONString(itmes));
                } else {
                    log.error("分账-支付流水关联补登文件处理结果查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("分账-支付流水关联补登文件处理结果查询异常：{}", e.getMessage(), e);
        }
    }

}
