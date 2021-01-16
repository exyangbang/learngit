package cn.kingnet.utp.sdk.account.api.user.account;

import cn.kingnet.utp.sdk.account.AccountClient;
import cn.kingnet.utp.sdk.account.api.UtpAccountTestCase;
import cn.kingnet.utp.sdk.account.dto.OpenAccountSelfemployedReqDTO;
import cn.kingnet.utp.sdk.account.dto.OpenAccountSelfemployedRespDTO;
import cn.kingnet.utp.sdk.core.dto.ServerResponse;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.enums.HttpRespStatus;
import cn.kingnet.utp.sdk.core.utils.DataUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.Base64;

/**
 * @Description: 个体工商户
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 10:20
 */
@Slf4j
public class API_01_OpenAccountSelfemployedTest extends UtpAccountTestCase {

    /**
     * 测试入口
     *
     * @throws Exception
     */
    @Test
    public void test() {
        try {
            AccountClient client = new AccountClient(createAuthorization(AuthType.HTSIGN), host);
            AccountClient.Builder<OpenAccountSelfemployedRespDTO> builder = client.newOpenAccountSelfemployedRespBuilder();
            // 初始化requestBody
            OpenAccountSelfemployedReqDTO reqDTO = new OpenAccountSelfemployedReqDTO();
            reqDTO.setClientTradeId(String.valueOf(System.currentTimeMillis()));
            //            张三
//            证件号：510265790128303
//            手机号：18100000000
//            银行卡号：6226090000000048
            reqDTO.setClientTradeId("HT20200609103511379280224");
            reqDTO.setUserNo("888080000000254940");
            reqDTO.setName("张庆芬");
            reqDTO.setIdType("101");
            reqDTO.setSex("M");
            reqDTO.setCountry("CHN");
            reqDTO.setProsession("40000");
            reqDTO.setAddress("北京市大兴区亦庄经济开发区");
            reqDTO.setIdIndate("2026-12-31");
            reqDTO.setIdCode("220104199507210027");
            reqDTO.setNature("8");
            reqDTO.setMobile("18666992853");
            String picA = Base64.getEncoder().encodeToString(DataUtil.fileToByte(new File("D:\\picAA.png")));
            String picB = Base64.getEncoder().encodeToString(DataUtil.fileToByte(new File("D:\\picBB.png")));

            reqDTO.setPersonPicA(picA);
            reqDTO.setPersonPicB(picB);
            reqDTO.setEmail("645014281@qq.com");
            builder.setReqData(reqDTO);

            log.info("个体工商户 请求报文:{}", JSON.toJSONString(builder.getReqData()));

            ServerResponse<OpenAccountSelfemployedRespDTO> serverResponse = send(builder);

            if (serverResponse.getRespData() == null) {
                log.error("个体工商户异常：响应结果为null", serverResponse.getThrowable());
            } else {
                OpenAccountSelfemployedRespDTO respDTO = serverResponse.getRespData();
                log.info("个体工商户 响应报文:{}", JSON.toJSONString(respDTO));
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(respDTO.getStatus());
                if (httpRespStatus.is2xxSuccessful()) {
                    log.info("个体工商户 虚拟账户[{}]", respDTO.getUserAccount());
                } else {
                    log.error("个体工商户失败：status[{}] {}", respDTO.getStatus(), respDTO.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("个体工商户异常：{}", e.getMessage(), e);
        }
    }
}
