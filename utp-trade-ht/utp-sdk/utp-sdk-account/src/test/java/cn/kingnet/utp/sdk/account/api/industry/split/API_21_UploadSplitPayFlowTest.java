package cn.kingnet.utp.sdk.account.api.industry.split;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UploadSplitPayFlowReqDTO;
import cn.kingnet.utp.sdk.account.dto.UploadSplitPayFlowRespDTO;
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
 * @Description 分账-支付流水信息补登文件上送
 * @Author WJH
 * @Date 2018年11月04日
 */
@Slf4j
@Deprecated
public class API_21_UploadSplitPayFlowTest extends UtpAccountTestCase {

    /**
     * 分账-支付流水信息补登文件上送
     *
     * @throws Exception
     */
    @Test
    public void testUploadSplitPayFlow() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<UploadSplitPayFlowRespDTO> builder = client.newUploadSplitPayFlowBuilder();
            // 初始化requestBody
            UploadSplitPayFlowReqDTO reqDTO = new UploadSplitPayFlowReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setReqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
            reqDTO.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
//            reqDTO.setBatchNo("9999");
            reqDTO.setBatchNo(mockBatchNo());

            /**
             * 实时文件流内容，base64字符串 必填
             */
            File file = buildUploadSplitPayFile(reqDTO);
            byte[] fileAy = DataUtil.fileToByte(file);
            String content = DataUtil.deflaterAndEncode64(fileAy);
            reqDTO.setContent(content);
            builder.setReqData(reqDTO);

            log.info("分账-支付流水关联补登文件上送 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<UploadSplitPayFlowRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("分账-支付流水关联补登文件上送异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UploadSplitPayFlowRespDTO respDTO = serverResponse.getRespData();
                log.info("分账-支付流水关联补登文件上送 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("分账-支付流水关联补登文件上送 客户号：{} 批次号:{} 受理状态[{}],若受理成功，最终清算结果通过回调通知或主动结果查询获取", industryCode, respDTO.getBatchNo(), respDTO.getSuccess());
                } else {
                    log.error("分账-支付流水关联补登文件上送失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("分账-支付流水关联补登文件上送异常：{}", e.getMessage(), e);
        }
    }


    public File buildUploadSplitPayFile(UploadSplitPayFlowReqDTO reqDTO) {
        //清算日期|原客户端流水号|用户账户|金额|结算方式|账期|备注信息|原支付订单号列表|扩展字段2|扩展字段3
        String curDate = reqDTO.getReqDate();
        String userAccount = "9100001101000001245";
        String outsideTransOrderIds = "2019092910UTP1178137661719728130,2019092910UTP1178137661719728131";
        String[] orgiClientIds = new String[]{"2019092911UTP1178148174856040451","2019092911UTP1178148174856040452"};

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("H|split_pay|%s|%s", curDate, orgiClientIds.length));
        for(int i=0;i<orgiClientIds.length;i++) {
            sb.append("\n");
            sb.append(String.format("%s|%s|%s|50|0|1|备注说明%s|%s|扩展2|扩展3", curDate, orgiClientIds[i], userAccount,i, outsideTransOrderIds));
        }
        String filePath = getFilePath();
        String fileName = buildFileName(industryCode, curDate, reqDTO.getBatchNo());
        DataUtil.byte2File(sb.toString().getBytes(StandardCharsets.UTF_8), filePath, fileName);
        return new File(filePath, fileName);

    }


    private String buildFileName(String industryCode, String reqDate, String batchNo) {
        return String.format("splitPay-%s-%s-%s.txt", industryCode, reqDate, batchNo);
    }


}
