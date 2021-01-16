package cn.kingnet.utp.sdk.account.api.user.trade;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UploadSubAccountPayFlowReqDTO;
import cn.kingnet.utp.sdk.account.dto.UploadSubAccountPayFlowRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 子账户入金流水报备
 * @Author WJH
 * @Date 2020/02/12
 */
@Slf4j
public class API_32_UploadSubAccountPayFlowTest extends UtpAccountTestCase {
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<UploadSubAccountPayFlowRespDTO> builder = client.newUploadSubAccountPayFlowBuilder();
            // 初始化requestBody
            UploadSubAccountPayFlowReqDTO reqDTO = new UploadSubAccountPayFlowReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
//            reqDTO.setUserAccount("9100001101000000390");
            reqDTO.setBatchNo(mockBatchNo());

            byte[] fileAy = DataUtil.fileToByte(buildUploadSubAccountPayFlowFile(reqDTO));
            String content = DataUtil.deflaterAndEncode64(fileAy);
            reqDTO.setContent(content);

            builder.setReqData(reqDTO);

            log.info("子账户入金流水报备文件 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<UploadSubAccountPayFlowRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("子账户入金流水报备文件异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UploadSubAccountPayFlowRespDTO respDTO = serverResponse.getRespData();
                log.info("子账户入金流水报备文件 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    if("true".equals(respDTO.getSuccess())){
                        log.info("子账户入金流水报备文件上送成功且批次状态[{}]",respDTO.getBatchStatus());
                    }else{
                        log.info("子账户入金流水报备文件上送失败且批次状态[{}]",respDTO.getBatchStatus());
                    }
                } else {
                    log.error("子账户入金流水报备文件上送异常：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("子账户入金流水报备文件异常：{}", e.getMessage(), e);
        }
    }

    public File buildUploadSubAccountPayFlowFile(UploadSubAccountPayFlowReqDTO reqDTO) {
        String tradeDate = reqDTO.getReqDate();
        String batchNo = reqDTO.getBatchNo();
        int rows = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("H|subaccount_pay_flow|%s|%s", tradeDate, rows));

        //序号|子账户|入金流水号|入金金额|关联支付流水列表|备注说明
        sb.append("\n").append(String.format("%s|%s|%s|%s|%s|%s",
                1, "9100001101000000641", "20200415EM0306056Y1100000001605592", 100, "1292684750154891266,1292684750154891267", "备注说明"));
        sb.append("\n").append(String.format("%s|%s|%s|%s|%s|%s",
                2, "9100001101000000605", "20200413EM0306056Y1100000001605321", 200, "1292684750154891269,1292684750154891268", "备注说明"));

//        for (int i = 0; i < rows; i++) {
//            sb.append("\n");
//            String clientTradeId = mockClientTransId();
//
//            sb.append(String.format("%s|%s|%s|%s|%s|%s", i+1, clientTradeId, userAccount, 100, i, outsideTransOrderIds));
//        }
        DataUtil.byte2File(sb.toString().getBytes(StandardCharsets.UTF_8), getFilePath(), buildFileName(industryCode, batchNo));
        return new File(getFilePath(), buildFileName(industryCode, batchNo));
    }


    private String buildFileName(String industryCode, String batchNo) {
        return String.format("orderIncome-%s-%s.txt", industryCode, batchNo);
    }
}
