package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryAccountDetailFileReqDTO;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustryAccountDetailFileRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AccountOperType;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Description 账户对账文件下载[接入代付客户平台下所有账户资金明细下载]
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_27_DownloadIndustryAccountDetailFileTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<DownloadIndustryAccountDetailFileRespDTO> builder = client.newDownloadIndustryAccountDetailFileBuilder();
            // 初始化requestBody
            DownloadIndustryAccountDetailFileReqDTO reqDTO = DownloadIndustryAccountDetailFileReqDTO.builder().build();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setOperateType(AccountOperType.PLUS_BLANCE.getCode());
            reqDTO.setStartDate("20190101");
            reqDTO.setEndDate("20190929");

            builder.setReqData(reqDTO);

            log.info("账户对账文件下载 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<DownloadIndustryAccountDetailFileRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("账户对账文件下载异常：响应结果为null", serverResponse.getThrowable());
            } else {
                DownloadIndustryAccountDetailFileRespDTO respDTO = serverResponse.getRespData();
                log.info("账户对账文件下载 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    if("true".equalsIgnoreCase(respDTO.getSuccess())){
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy, getFilePath(), buildIndustryAccountDetailFile(industryCode,reqDTO.getStartDate(),reqDTO.getEndDate()));
                        log.info("账户对账文件下载成功 ：success[{}] {} \n 内容：\n{} ",respDTO.getSuccess(),respDTO.getDesc(),new String(fAy, StandardCharsets.UTF_8));
                    }else{
                        log.error("账户对账文件下载失败：success[{}] {}", respDTO.getSuccess(),respDTO.getDesc());
                    }
                } else {
                    log.error("账户对账文件下载失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("账户对账文件下载异常：{}", e.getMessage(), e);
        }
    }
    private String buildIndustryAccountDetailFile(String industryCode,String startDate,String endDate){
        return String.format("账户对账文件下载_%s-%s-%s.txt",industryCode,startDate,endDate);
    }
}
