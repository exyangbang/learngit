package cn.kingnet.utp.sdk.account.api;

import cn.kingnet.utp.sdk.core.UtpClient;
import cn.kingnet.utp.sdk.core.auth.Authorization;
import cn.kingnet.utp.sdk.core.auth.impl.HtSignAuthorization;
import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public abstract class UtpAccountTestCase {
    // private static   Logger log = LoggerFactory.getLogger(UtpAccountTestCase.class);
//    protected final String host = "http://localhost:9807";
//	protected final String host = "http://192.168.10.112:9807";

//    protected final String host = "http://utptest.onebank.com.cn/sit"; //sit环境
    protected final String host = "http://utptest.onebank.com.cn";    //uat环境 对外联调环境
//    protected final String host = "https://utppre.onebank.com.cn";    //pre环境
//    protected final String host = "https://utp.onebank.com.cn";       //live环境
//    protected final String host = "http://10.11.20.134:9807";
//    protected final String host = "http://127.0.0.1:9807";

    protected final static AtomicLong atomicLong = new AtomicLong();


    protected final String industryCode = "2020122902";// JD2020090920 S123456789 20191029 20200304 UMS000001"; //20191029 0594456 0594 457 1000 Dw001 006代付 5 011 005分账
    protected final String cert_pfx_path = "JFJT.pfx";
//    protected final String cert_pfx_path = "test256.pfx";
    protected final String CERT_PASSWORD = "111111";
//    protected final String cert_pfx_path = "utp.pfx";
//protected final String CERT_PASSWORD = "123456";


    protected static <RESP extends BaseResponseDTO> ServerResponse send(UtpClient.Builder<RESP> builder) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ServerResponse<RESP> serverResponse = new ServerResponse();
        try {
            builder.execute().whenComplete((paymentResponse, throwable) -> {
                if (throwable != null) {
                    serverResponse.setThrowable(throwable);
                }
                if (paymentResponse != null) {
                    serverResponse.setRespData(paymentResponse);
                }
                countDownLatch.countDown();
            });
            countDownLatch.await(59, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException("请求响应异常:" + e.getMessage(), e);
        }
        return serverResponse;
    }


    protected Authorization createAuthorization(AuthType authType) {
        if (AuthType.HTSIGN == authType) {
            String filePath = UtpAccountTestCase.class.getClassLoader().getResource(cert_pfx_path).getPath();
            return new HtSignAuthorization(industryCode, filePath, CERT_PASSWORD);
        }
        throw new RuntimeException("不支持的认证方式");
    }

    protected String mockBatchNo() {
        return new StringBuilder(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))).append(atomicLong.incrementAndGet()).toString();
    }

    protected String mockClientTransId() {
        return IdGenerate.mockUtpClientTransId();
    }

    protected String getFilePath() {
        String filePath = UtpAccountTestCase.class.getResource("/").getPath();
        File dirFile = new File(filePath, "tmp");
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        return dirFile.getPath();
    }


}
