package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryD1SpecailReconFileRespDTO;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryD1SpecailReconFileReqDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Description "D+1日凌晨12:30生成D日对账文件，京东于凌晨1点可以通过该接口下载对应的客户号的对账文件。
 * D+1日凌晨12:30生成D日对账文件，对账文件包含以下几部分内容：
 *  D日交易明确成功及明确失败的交易记录。
 *  D日进行处理的差错交易记录。
 *  D日进行处理的退汇的交易记录。
 * "
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_44_DownloadIndustryD1SpecialReconFileTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<DownloadIndustryD1SpecailReconFileRespDTO> builder = client.newDownloadIndustryD1SpecailReconFileBuilder();
            // 初始化requestBody
            DownloadIndustryD1SpecailReconFileReqDTO reqDTO = DownloadIndustryD1SpecailReconFileReqDTO.builder().build();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setTxDate("20200820");
            builder.setReqData(reqDTO);

            log.info("D日对账文件下载(京东定制化) 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<DownloadIndustryD1SpecailReconFileRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("D日对账文件下载(京东定制化)异常：响应结果为null", serverResponse.getThrowable());
            } else {
                DownloadIndustryD1SpecailReconFileRespDTO respDTO = serverResponse.getRespData();
                log.info("D日对账文件下载(京东定制化) 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    if("true".equalsIgnoreCase(respDTO.getSuccess())){
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy, getFilePath(), buildIndustryD1SpecialReconFile(industryCode,reqDTO.getTxDate()));
                        log.info("D日对账文件下载(京东定制化)成功 ：success[{}] {} \n 内容：\n{} ",respDTO.getSuccess(),respDTO.getDesc(),new String(fAy, StandardCharsets.UTF_8));
                    }else{
                        log.error("D日对账文件下载(京东定制化)失败：success[{}] {}", respDTO.getSuccess(),respDTO.getDesc());
                    }
                } else {
                    log.error("D日对账文件下载(京东定制化)失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("D日对账文件下载(京东定制化)异常：{}", e.getMessage(), e);
        }
    }
    private String buildIndustryD1SpecialReconFile(String industryCode, String txDate){
        return String.format("D日对账文件(京东定制化)-%s-%s.txt",txDate,industryCode);
    }
}
