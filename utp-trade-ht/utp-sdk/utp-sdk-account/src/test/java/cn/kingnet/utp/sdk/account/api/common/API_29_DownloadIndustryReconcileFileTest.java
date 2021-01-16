package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryReconcileFileReqDTO;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryReconcileFileRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Description 平台对账文件下载
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_29_DownloadIndustryReconcileFileTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<DownloadIndustryReconcileFileRespDTO> builder = client.newDownloadIndustryReconcileFileBuilder();
            // 初始化requestBody
            DownloadIndustryReconcileFileReqDTO  reqDTO = DownloadIndustryReconcileFileReqDTO.builder().build();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            reqDTO.setSettleDate("20200603");

            builder.setReqData(reqDTO);

            log.info("平台对账文件下载 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<DownloadIndustryReconcileFileRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("平台对账文件下载异常：响应结果为null", serverResponse.getThrowable());
            } else {
                DownloadIndustryReconcileFileRespDTO respDTO = serverResponse.getRespData();
                log.info("平台对账文件下载 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    if("true".equalsIgnoreCase(respDTO.getSuccess())){
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy, getFilePath(), buildIndustryReconcileFile(industryCode,reqDTO.getSettleDate()));
                        log.info("平台对账文件下载成功 ：success[{}] {} \n 内容：\n{} ",respDTO.getSuccess(),respDTO.getDesc(),new String(fAy, StandardCharsets.UTF_8));
                    }else{
                        log.error("平台对账文件下载失败：success[{}] {}", respDTO.getSuccess(),respDTO.getDesc());
                    }
                } else {
                    log.error("平台对账文件下载失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("平台对账文件下载异常：{}", e.getMessage(), e);
        }
    }
    private String buildIndustryReconcileFile(String industryCode,String reconcileDate){
        return String.format("平台对账文件下载_%s-%s.txt",industryCode,reconcileDate);
    }
}
