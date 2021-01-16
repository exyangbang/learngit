package cn.kingnet.product.collection;


import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.reconciliation.ReconciliationApp;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecord;
import cn.kingnet.utp.reconciliation.data.entity.MerchantReconcileRecordCondition;
import cn.kingnet.utp.reconciliation.data.entity.TransCurrent;
import cn.kingnet.utp.reconciliation.data.mapper.TransCurrentMapper;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/7 17:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReconciliationApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReconciliationAppTest {

    @Test
    public void dolownFile(){
        String channelKey = "0001";
        String reconcileDate = "20181212";
        PlusEntityWrapper<MerchantReconcileRecord> wrap = MerchantReconcileRecordCondition.builder().andChannelKeyEq(channelKey).andReconcileDateEq(reconcileDate).build();
        String updateSql = String.format("reconcile_status = '%s',gmt_modified = '%s'","1", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        MybatisDaoImpl.run().updateForSet(updateSql, wrap);
    }

    @Test
    public void getPlatMultiTransList(){
        Map<String, Object> parameterMap = new HashMap<>(4);
        parameterMap.put("minusDate", "20190409");
        parameterMap.put("reconcileDate","20190410");
        List<TransCurrent> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("getPlatMultiTransList",parameterMap);
        System.out.println(list.size());
    }
}
