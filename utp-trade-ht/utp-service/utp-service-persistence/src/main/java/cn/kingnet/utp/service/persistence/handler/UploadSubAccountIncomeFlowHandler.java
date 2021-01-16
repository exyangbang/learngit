package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IUploadSubAccountIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountIncomeFlow;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountIncomeFlowCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/12
 */
@RestController
@RequestMapping("/spi/persistence/uploadSubAccountIncomeFlow")
public class UploadSubAccountIncomeFlowHandler extends DefaultFeginExceptionHandler implements IUploadSubAccountIncomeFlowHandler {

    @GetMapping("isExistIncomeFlowId")
    @Override
    public boolean isExistIncomeFlowId(String subAccount,String incomeFlowId) {
        int count = MybatisDaoImpl.run().selectCount(UploadSubAccountIncomeFlowCondition.builder().andSubAccountEq(subAccount).andIncomeFlowIdEq(incomeFlowId).build());
        return count > 0;
    }

    @GetMapping("isExistBatchNo")
    @Override
    public boolean isExistBatchNo(String batchNo) {
        int count = MybatisDaoImpl.run().selectCount(UploadSubAccountIncomeFlowCondition.builder().andBatchNoEq(batchNo).build());
        return count > 0;
    }

    @PostMapping("save")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody List<UploadSubAccountIncomeFlow> uploadSubAccountIncomeFlowList) {
        MybatisDaoImpl.run().insertBatch(uploadSubAccountIncomeFlowList, 100);
    }

    @Override
    @PostMapping("queryByIndustryAndBatchNo")
    public List<UploadSubAccountIncomeFlow> queryByIndustryAndBatchNo( String industryCode,  String batchNo) {
        return MybatisDaoImpl.run().selectList(UploadSubAccountIncomeFlowCondition.builder().andIndustryCodeEq(industryCode).andBatchNoEq(batchNo).build());
    }
}
