package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IMerchantReconcileRecordHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantReconcileRecord;
import cn.kingnet.utp.service.persistence.entity.MerchantReconcileRecordCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 对账记录服务接口
 * @Author : linkaigui
 * @Create : 2019/3/27 11:24
 */
@RestController
@RequestMapping("/spi/persistence/reconcileRecord")
public class MerchantReconcileRecordHandler extends DefaultFeginExceptionHandler implements IMerchantReconcileRecordHandler {

    /**
     * 查询对账记录
     * @param settleDate 对账日期
     * @return
     */
    @Override
    public MerchantReconcileRecord queryReconcileRecordByDate(@RequestParam(value = "settleDate", required = false) String settleDate) {
        if(StringUtil.isBlank(settleDate))return null;
        return MybatisDaoImpl.run().selectOne(MerchantReconcileRecordCondition.builder().andReconcileDateEq(settleDate).build());
    }
}
