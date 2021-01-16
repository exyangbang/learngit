package cn.kingnet.utp.channel.onebank;

import cn.kingnet.utp.trade.common.dto.onebank.OneBankBindReq;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.junit.Test;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/12 12:07
 */
public class ServiceTests {

    @Test
    public void test1(){
        OneBankBindReq bindReq = new OneBankBindReq();
        ValidateUtils.validate(bindReq);
//        ChannelOnebankApp indexServiceApplicationTests = new ChannelOnebankApp();
//        try {
//            Enumeration<URL> urls = indexServiceApplicationTests.getClass().getClassLoader().getResources("META-INF/spring.factories");
//            System.out.println("urls:" + urls);
//            while(urls.hasMoreElements()){
//                URL url = urls.nextElement();
//                System.out.println("urlItem:"+url);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
