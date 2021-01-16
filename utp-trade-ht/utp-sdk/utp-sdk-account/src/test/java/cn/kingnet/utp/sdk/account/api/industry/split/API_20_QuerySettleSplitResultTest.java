package cn.kingnet.utp.sdk.account.api.industry.split;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.EBSettleSplitResultReqDTO;
import cn.kingnet.utp.sdk.account.dto.EBSettleSplitResultRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 清算分账结果查询
 * @Author WJH
 * @Date 2018年11月04日
 */
@Slf4j
public class API_20_QuerySettleSplitResultTest extends UtpAccountTestCase {


    @Test
    public void testSettleSplitResult() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<EBSettleSplitResultRespDTO> builder = client.newEBSettleSplitResultBuilder();
            // 初始化requestBody
            EBSettleSplitResultReqDTO reqDTO = new EBSettleSplitResultReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setSettleDate("20200810");
            reqDTO.setBatchNo("1557541"); //1520581 1522271

            builder.setReqData(reqDTO);

            log.info("清算分账结果查询 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<EBSettleSplitResultRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("清算分账结果查询异常：响应结果为null", serverResponse.getThrowable());
            } else {
                EBSettleSplitResultRespDTO respDTO = serverResponse.getRespData();
                log.info("清算分账结果查询 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("清算分账结果查询 客户号:{} 清算日期：{} 批次号:{} 批次处理状态：{}", industryCode, respDTO.getSettleDate(), reqDTO.getBatchNo(),respDTO.getBatchStatus());
                    if ("true".equalsIgnoreCase(respDTO.getSuccess())) {
                        log.info("清算分账结果查询 清分文件已分账处理完成，可进行业务处理 批次处理状态:{}",respDTO.getBatchStatus());
                        String content = new String(DataUtil.inflaterAndDecode64(respDTO.getContent()));

                        log.info("清算分账结果查询 清分记录状态信息：\n{}", content);

                    } else {
                        log.info("清算分账结果查询 清分文件内记录包含有不明确的交易状态，可稍后再次尝试查询");
                    }
                } else {
                    log.error("清算分账结果查询失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("清算分账结果查询异常：{}", e.getMessage(), e);
        }
    }
}
