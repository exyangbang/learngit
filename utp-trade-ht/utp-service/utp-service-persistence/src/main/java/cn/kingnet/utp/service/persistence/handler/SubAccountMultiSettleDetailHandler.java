package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.ISubAccountMultiSettleDetailHandler;
import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetail;
import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetailCondition;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountMultiSettleDetailBo;
import cn.kingnet.utp.service.persistence.service.SubAccountMultiSettleDetailService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author WJH
 * @Date 2020/03/27
 */
@RestController
@RequestMapping("/spi/persistence/subAccountMultiSettleDetail")
public class SubAccountMultiSettleDetailHandler extends DefaultFeginExceptionHandler implements ISubAccountMultiSettleDetailHandler {


    @Resource
    private SubAccountMultiSettleDetailService subAccountMultiSettleDetailService;

    @Override
    @GetMapping("/existsSubAccountMultiSettleDetail")
    public boolean existsSubAccountMultiSettleDetail(String industryCode, String settleDate, String batchNo) {
        Assert.hasText(industryCode, () -> "参数 industryCode 不能为空 ");
        Assert.hasText(settleDate, () -> "参数 settleDate 不能为空 ");
        Assert.hasText(batchNo, () -> "参数 batchNo 不能为空 ");
        PlusEntityWrapper<SubAccountMulTiSettleDetail> plusEntityWrapper =
                SubAccountMulTiSettleDetailCondition.builder().andIndustryCodeEq(industryCode).andSettleDateEq(settleDate).andBatchNoEq(batchNo).build();
        int count = MybatisDaoImpl.run().selectCount(plusEntityWrapper);
        return count > 0;
    }

    @Override
    @GetMapping("/existsTransStatusSubAccountMultiSettleDetail")
    public boolean existsTransStatusSubAccountMultiSettleDetail(String industryCode, String settleDate, String batchNo,String transStatus) {
        Assert.hasText(industryCode, () -> "参数 industryCode 不能为空 ");
        Assert.hasText(settleDate, () -> "参数 settleDate 不能为空 ");
        Assert.hasText(batchNo, () -> "参数 batchNo 不能为空 ");
        Assert.hasText(transStatus, () -> "参数 transStatus 不能为空 ");
        PlusEntityWrapper<SubAccountMulTiSettleDetail> plusEntityWrapper =
                SubAccountMulTiSettleDetailCondition.builder().andIndustryCodeEq(industryCode).andSettleDateEq(settleDate).andBatchNoEq(batchNo)
                        .andTransStatusEq(transStatus).build();
        int count = MybatisDaoImpl.run().selectCount(plusEntityWrapper);
        return count > 0;
    }



    @Override
    @GetMapping("/querySubAccountMultiSettleDetail")
    public List<SubAccountMulTiSettleDetail> querySubAccountMultiSettleDetail(String industryCode, String settleDate, String batchNo) {
        Assert.hasText(industryCode, () -> "参数 industryCode 不能为空 ");
        Assert.hasText(settleDate, () -> "参数 settleDate 不能为空 ");
        Assert.hasText(batchNo, () -> "参数 batchNo 不能为空 ");
        PlusEntityWrapper<SubAccountMulTiSettleDetail> plusEntityWrapper =
                SubAccountMulTiSettleDetailCondition.builder().andIndustryCodeEq(industryCode).andSettleDateEq(settleDate).andBatchNoEq(batchNo).build();
        List<SubAccountMulTiSettleDetail> list = MybatisDaoImpl.run().selectList(plusEntityWrapper);
        return list;
    }

    @Override
    @PostMapping("/saveSubAccountMultiSettleDetail")
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void saveSubAccountMultiSettleDetail(@RequestBody SubAccountMultiSettleDetailBo subAccountMultiSettleDetailBo) {
        Assert.notNull(subAccountMultiSettleDetailBo, () -> "参数 subAccountMultiSettleDetailBo 不能为空");
        if (!CollectionUtils.isEmpty(subAccountMultiSettleDetailBo.getSubAccountMulTiSettleDetailList())) {
            MybatisDaoImpl.run().insertBatch(subAccountMultiSettleDetailBo.getSubAccountMulTiSettleDetailList(), 100);

            //异步处理
            CompletableFuture.runAsync(()->{
                subAccountMultiSettleDetailService.processSubAccountMulSettleDetail(subAccountMultiSettleDetailBo);
            });
        }

    }
}
