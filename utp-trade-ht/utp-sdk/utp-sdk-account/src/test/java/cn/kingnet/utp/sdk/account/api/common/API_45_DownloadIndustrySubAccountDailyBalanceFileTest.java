package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustrySubAccountDailyBalanceFileReqDTO;
import cn.kingnet.utp.sdk.account.dto.DownloadIndustrySubAccountDailyBalanceFileRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Description 4.5.14. 子账户日终余额对账单下载(京东定制化)
 * "按照客户号配置需要生成日终余额对账的，D+1日凌晨00点，生成D日的客户号下所有子账户的单日余额对账单。
 * 客户D+1日凌晨00:30分后可以下载D日的余额对账单，最多保留10天（参数配置），超过10天的数据自动清理，不允许下载。
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
public class API_45_DownloadIndustrySubAccountDailyBalanceFileTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<DownloadIndustrySubAccountDailyBalanceFileRespDTO> builder = client.newDownloadIndustrySubAccountDailyBalanceFileBuilder();
            // 初始化requestBody
            DownloadIndustrySubAccountDailyBalanceFileReqDTO reqDTO = DownloadIndustrySubAccountDailyBalanceFileReqDTO.builder().build();
            reqDTO.setClientTradeId(mockClientTransId());
            reqDTO.setTxDate("20200802");
            builder.setReqData(reqDTO);

            log.info("子账户日终余额对账单下载(京东定制化) 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<DownloadIndustrySubAccountDailyBalanceFileRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("子账户日终余额对账单下载(京东定制化)异常：响应结果为null", serverResponse.getThrowable());
            } else {
                DownloadIndustrySubAccountDailyBalanceFileRespDTO respDTO = serverResponse.getRespData();
                log.info("子账户日终余额对账单下载(京东定制化) 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    if("true".equalsIgnoreCase(respDTO.getSuccess())){
                        byte[] fAy = DataUtil.inflaterAndDecode64(respDTO.getContent());
                        DataUtil.byte2File(fAy, getFilePath(), buildIndustryD1SpecialReconFile(industryCode,reqDTO.getTxDate()));
                        log.info("子账户日终余额对账单下载(京东定制化)成功 ：success[{}] {} \n 内容：\n{} ",respDTO.getSuccess(),respDTO.getDesc(),new String(fAy, StandardCharsets.UTF_8));
                    }else{
                        log.error("子账户日终余额对账单下载(京东定制化)失败：success[{}] {}", respDTO.getSuccess(),respDTO.getDesc());
                    }
                } else {
                    log.error("子账户日终余额对账单下载(京东定制化)失败：status[{}] {}", respDTO.getStatus(),respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("子账户日终余额对账单下载(京东定制化)异常：{}", e.getMessage(), e);
        }
    }
    private String buildIndustryD1SpecialReconFile(String industryCode, String txDate){
        return String.format("子账户日终余额对账单(京东定制化)-%s-%s.txt",txDate,industryCode);
    }
}
