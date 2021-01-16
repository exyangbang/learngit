package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.DownloadElectronicReceiptReqDTO;
import cn.kingnet.utp.sdk.account.dto.DownloadElectronicReceiptRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * @Description : 电子回单PDF文件下载
 * @Author : caohong
 * @Create : 2019-03-21
 */
@Slf4j
public class API_28_DownloadElectronicReceiptTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<DownloadElectronicReceiptRespDTO> builder = client.newDownloadElectronicReceiptBuilder();
            // 初始化requestBody
            DownloadElectronicReceiptReqDTO reqDTO = new DownloadElectronicReceiptReqDTO();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setOrigTradeId("20190807HM030449158939605664337921");
//            20190807HM030449158939605664337921
//            20190903HM030449168778328916733954

            builder.setReqData(reqDTO);

            log.info("电子回单PDF文件下载 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<DownloadElectronicReceiptRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("电子回单PDF文件下载异常：响应结果为null", serverResponse.getThrowable());
            } else {
                DownloadElectronicReceiptRespDTO respDTO = serverResponse.getRespData();
                log.info("电子回单PDF文件下载 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy, getFilePath(), buildIndustryAccountDetailFile(industryCode,reqDTO.getOrigTradeId()));
                        log.info("电子回单PDF文件下载成功,电子回单号：{} 文件存放目录:{}{}{}",respDTO.getReceiptNo(),getFilePath(), File.separator,buildIndustryAccountDetailFile(industryCode,reqDTO.getOrigTradeId()));
                } else {
                    log.error("电子回单PDF文件下载失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("电子回单PDF文件下载异常：{}", e.getMessage(), e);
        }
    }
    private String buildIndustryAccountDetailFile(String industryCode,String origTradeId){
        return String.format("电子回单PDF文件下载_%s-%s.pdf",industryCode,origTradeId);
    }
}

