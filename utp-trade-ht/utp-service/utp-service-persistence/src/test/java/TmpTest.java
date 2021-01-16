import cn.kingnet.utp.service.persistence.ServicePersistenceApp;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.mapper.OutsideTransOrderCustomMapper;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/28
 */
@SpringBootTest(classes = ServicePersistenceApp.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TmpTest {

    @Resource
    private OutsideTransOrderCustomMapper mapper;

    @Test
    public void test() {

        List<OutsideTransOrder> list = new ArrayList<>();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 10 * 10000; i++) {
            OutsideTransOrder vo = OutsideTransOrder.builder()
                    .id(IdGenerate.getId()).transDate("20201228").transTime("121212")
                    .reqDate("20201228").reqTime("111111").industryCode("20200304").batchId(IdGenerate.generateServerTransId("utp", "01"))
                    .transAmount(10L).build();
            list.add(vo);
        }

        long s2 = System.currentTimeMillis();
        System.out.println("s2 = " + (s2 - s1));
        int num = mapper.insertBatch(list);
        long s3 = System.currentTimeMillis();
        System.out.println("num = " + num + "__" + (s3 - s2));


    }
}
