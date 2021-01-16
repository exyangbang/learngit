package cn.kingnet.utp.sdk.account.api.common;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.UploadIndustryMixPayFlowReqDTO;
import cn.kingnet.utp.sdk.account.dto.UploadIndustryMixPayFlowRespDTO;
import cn.kingnet.utp.sdk.account.tools.RsaUtils;
import cn.kingnet.utp.sdk.account.tools.SftpConfig;
import cn.kingnet.utp.sdk.account.tools.SftpService;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import cn.kingnet.utp.sdk.core.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * 融合支付流水上送
 */
@Slf4j
public class API_46_UploadIndustryMixPayFlowTest extends UtpAccountTestCase {


    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<UploadIndustryMixPayFlowRespDTO> builder = client.newUploadIndustryMixPayFlowBuilder();




            // 初始化requestBody
            UploadIndustryMixPayFlowReqDTO reqDTO = UploadIndustryMixPayFlowReqDTO.builder()
                    .reqDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE))
                    .reqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")))
                    .transDate(LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE))
                    .transTime(LocalTime.now().minusHours(8).format(DateTimeFormatter.ofPattern("HHmmss")))
                    .batchNo(mockBatchNo())
                    .mixTransId(mockClientTransId())
                    .mixTransAmount("200000")
                    .sftpPath("/utpfile/20201228-mix3.txt")
                    .callbackUrl("http://ksbisv.wangdunbao.cn/mockCallback/success200")
                    .build();

            reqDTO.setClientTradeId(mockClientTransId());

            builder.setReqData(reqDTO);

            log.info("融合支付流水上送 请求报文:{}", JSON.toJSONString(builder.getReqData()));
            ServerResponse<UploadIndustryMixPayFlowRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("融合支付流水上送异常：响应结果为null", serverResponse.getThrowable());
            } else {
                UploadIndustryMixPayFlowRespDTO respDTO = serverResponse.getRespData();
                log.info("融合支付流水上送 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("融合支付流水上送完成，受理中，待回调通知或稍后主动通过支付流水查询接口查询");
                } else {
                    log.error("融合支付流水上送失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("融合支付流水上送异常：{}", e.getMessage(), e);
        }
    }

    private Path buildMixTransDetailSftpTxt(String batchId, String tradeDate, String mixAmount) {
        String uatPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZ1e+v0MBrazWH7L0mGkEYESJq6A2ZBK5gCsV3BlMKSMa0Xw+YjVDLY/XGvOLFHn8n9fmMp/SoTWY4bmkcHxff0Bkri1YlJm6FsNarhdggdqcTT1daVc8fgh/+vgopslzCwQzB4V6Jm0WCg4HXr7TEf1fvwuzI1IgBZxwXGhD+0wIDAQAB";
        RsaUtils rsaUtils;
        try {
            PublicKey publicKey = RsaUtils.getPublicKey(uatPublicKey);
            rsaUtils = new RsaUtils(null, publicKey);
        } catch (Exception e) {
            throw new RuntimeException("publicKey error", e);
        }

        String curDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        curDate = tradeDate;
        String curTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        int rows = Integer.valueOf(mixAmount);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("H|mixpay_flow|%s|%s", mixAmount, rows));
        StringBuilder sbT = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(",");
        long rowAmount = 1L;
        String buyerName;
        String buyerId;
        for (int i = 0; i < rows; i++) {
            sb.append("\n");
            String clientTradeId = IdGenerate.mockUtpClientTransId();
            clientTradeId = clientTradeId.substring(clientTradeId.length() - 19, clientTradeId.length());
            buyerName = rsaUtils.encrypt("张三" + i);
            buyerId = rsaUtils.encrypt("buyerId14");
            sb.append(String.format("%s|%s|%s|9001|%s|0|凡客旗舰店7|%s|T恤衫9|备注说明|15606995632|Z2000133000019|A12312312412|%s|1560695123|11201|物流信息", curDate, curTime, clientTradeId, rowAmount, buyerName, buyerId));
            stringJoiner.add(clientTradeId);
        }
        System.out.println("stringJoiner = " + stringJoiner.toString());
        String fileName = batchId + ".txt";
        Path localFilePath = Paths.get(getFilePath(), fileName);
        DataUtil.byte2File(sb.toString().getBytes(StandardCharsets.UTF_8), getFilePath(), fileName);

        return localFilePath;
    }

    public static void main(String[] args)throws Exception {


//        API_46_UploadIndustryMixPayFlowTest test = new API_46_UploadIndustryMixPayFlowTest();
//        long s = System.currentTimeMillis();
//        String tradeDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
//        String batchId = "mix" + 002;
////        Path localFilePath = test.buildMixTransDetailSftpTxt(batchId, tradeDate, "100000");
//        long e = System.currentTimeMillis();
//        System.out.println("e = " + (e - s));
//
//        String remoteDirectory = "mixTrans";
//        String remoteFileName = String.format("%s-%s.txt", tradeDate, batchId);
////        test.uploadSftpTxt(remoteDirectory, remoteFileName, localFilePath);
//        long e1 = System.currentTimeMillis();
//        System.out.println("e1 = " + (e1 - e));
//
//        Path downloadLocalPath = Paths.get(remoteDirectory, "download", remoteFileName);
//        test.downloadSftpTxt(remoteDirectory, remoteFileName, downloadLocalPath);
//        long e2 = System.currentTimeMillis();
//        System.out.println("e2 = " + (e2 - e1)+"_"+downloadLocalPath.toAbsolutePath().toString());


    }

    private Path downloadSftpTxt(String remoteDirectory, String sftpFileName, Path localFilePath) {
        try {
            SftpConfig sftpConfig = new SftpConfig();
            sftpConfig.setUserName("sftpuser");
            sftpConfig.setPassword("sftpuser");
            sftpConfig.setHost("192.168.214.10");
            sftpConfig.setPort(22);
            String userRemoteDir = "sftpuser";
            SftpService sftpService = new SftpService(sftpConfig);

            SftpService.Sftp sftp1 = sftpService.connectSftp();
            Path downloadLocalPath = Paths.get(getFilePath(), "download", sftpFileName);
            sftp1.download(userRemoteDir+"/"+remoteDirectory, sftpFileName, downloadLocalPath);

            sftp1.closeSFTP();
            sftpService.closeSession();
            return downloadLocalPath;
        } catch (SftpException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String uploadSftpTxt(String remoteDirectory, String sftpFileName, Path localFilePath) {
        String remoteSftpPath;
        try {
            SftpConfig sftpConfig = new SftpConfig();
            sftpConfig.setUserName("sftpuser");
            sftpConfig.setPassword("sftpuser");
            sftpConfig.setHost("192.168.214.10");
            sftpConfig.setPort(22);

            SftpService sftpService = new SftpService(sftpConfig);

            String userRemoteDir = "sftpuser";
            SftpService.Sftp sftp = sftpService.connectSftp();
            sftp.upload(userRemoteDir+"/"+remoteDirectory, sftpFileName, localFilePath);

            sftp.closeSFTP();
            sftpService.closeSession();

            remoteSftpPath = userRemoteDir+"/"+remoteDirectory + "/" + sftpFileName;
            return remoteSftpPath;
        } catch (SftpException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
