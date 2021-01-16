package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.service.persistence.service.OutsideTransOrderService;
import cn.kingnet.utp.service.persistence.vo.MixTransInfoAndFilePathVO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.PayMode;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2019/05/29
 */
@RestController
@RequestMapping("/spi/persistence/outsideTransOrder")
@Slf4j
public class OutsideTransOrderHandler extends DefaultFeginExceptionHandler implements IOutsideTransOrderHandler {

    @Resource
    private CommonRedisService commonRedisService;

    @Resource
    private OutsideTransOrderService outsideTransOrderService;

    @Override
    public boolean isExistIndustryANdBatchId(String industryCode, String batchId) {
        return outsideTransOrderService.isExistIndustryANdBatchId(industryCode, batchId);
    }

    @Override
    public boolean isExistIndustryANdTransOrderId4Success(String industryCode, String transOrderId) {
        return outsideTransOrderService.isExistIndustryANdTransOrderId4Success(industryCode, transOrderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOutsideTransOrderList(@RequestBody List<OutsideTransOrderVo> list) {
        List<OutsideTransOrder> outsideTransOrders = list.parallelStream().map(OutsideTransOrder::of).collect(Collectors.toList());
        MybatisDaoImpl.run().insertBatch(outsideTransOrders, 100);
    }

    @Override
    @PostMapping("saveOutsideTransOrder")
    public void saveOutsideTransOrder(@RequestBody OutsideTransOrderVo outsideTransOrderVo,@RequestParam("isUpdate")boolean isUpdate){
        if(isUpdate){
            Assert.notNull(outsideTransOrderVo.getId(),"主键id不能为空");
            MybatisDaoImpl.run().updateById(OutsideTransOrder.of(outsideTransOrderVo));
        }else{
            MybatisDaoImpl.run().insert(OutsideTransOrder.of(outsideTransOrderVo));
        }
    }


    @Override
    public boolean validTransOrderIds(String industryCode, String transOrderIds, long splitAmount, Boolean isBrokerageAccount, Long maxBrokerageRate) {
        List<String> orderList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(transOrderIds);

        List<OutsideTransOrder> reList = outsideTransOrderService.selectByTransOrderIdsAndSuccess(industryCode, transOrderIds);
        if (reList == null || orderList.size() != reList.size()) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "支付订单号未能完全匹配");
        }

        long curSumOrdersAmount = reList.stream().mapToLong(OutsideTransOrder::getTransAmount).sum();
        if (curSumOrdersAmount < splitAmount) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "分账金额不能大于关联支付订单总额，暂不能分账");
        }

        if (isBrokerageAccount && maxBrokerageRate != null && maxBrokerageRate > 0) {
            //最大佣金金额
            long maxBrokerageAmount = BigDecimal.valueOf(curSumOrdersAmount).multiply(BigDecimal.valueOf(maxBrokerageRate).divide(new BigDecimal(100000))).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
            if (splitAmount > maxBrokerageAmount) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户号佣金户转账金额不能大于该客户号上限佣金比例抽成金额");
            }
        }
        return true;
    }

    @Override
    public List<OutsideTransOrder> queryOutsideTransOrderList(String industryCode, String batchNo) {
        return MybatisDaoImpl.run().selectList(OutsideTransOrder.builder().industryCode(industryCode).batchId(batchNo).build());
    }

    /**
     * 根据订单编号查询已分账次数
     *
     * @param transOrderId
     * @return
     */
    @Override
    public Integer queryLinkedSplitNumByTransOrderId(String industryCode, String transOrderId) {
        return outsideTransOrderService.queryLinkedSplitNumByTransOrderId(industryCode, transOrderId);
    }

    @Override
    public OutsideTransOrder selectByTransOrderIdAndSuccess(String industryCode, String transOrderId) {
        return outsideTransOrderService.selectByTransOrderIdAndSuccess(industryCode, transOrderId);
    }

    @Override
    public List<OutsideTransOrder> selectByTransOrderIdsAndSuccess(String industryCode, String transOrderIds) {
        ValidateUtils.hasText(industryCode, "客户号");
        ValidateUtils.hasText(transOrderIds, "支付订单号");
        return outsideTransOrderService.selectByTransOrderIdsAndSuccess(industryCode, transOrderIds);
    }

    @Override
    public String queryFilePathById(long id) {
        ValidateUtils.notNull(id, "参数[id]不能为空");
        OutsideTransOrder outsideTransOrder = MybatisDaoImpl.run().selectById(OutsideTransOrder.class, id);
        if (!outsideTransOrder.getPayMode().equals(PayMode.NOPAYFLOW.getType())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "支付方式不匹配");
        }
        return outsideTransOrder.getRemark();
    }

    @Override
    @PostMapping("updateSplitStatusAndLinkedSplitNum")
    @Transactional(rollbackFor = Exception.class)
    public void updateSplitStatusAndLinkedSplitNum(String industryCode, String transOrderIds) {
        outsideTransOrderService.updateSplitStatusAndLinkedSplitNum(industryCode, transOrderIds);
    }


    @PostMapping("parseMixTransDetailTxtFileAsync")
    @Override
    @Async
    public void parseMixTransDetailTxtFileAsync(@RequestBody MixTransInfoAndFilePathVO mixTransInfoAndFilePathVO) {
        Assert.notNull(mixTransInfoAndFilePathVO.getVo(), "融合支付记录不能为空");
        Assert.notNull(mixTransInfoAndFilePathVO.getLocalPath(), "下载融合明细文件不能为空");
        outsideTransOrderService.parseMixTransDetailTxtFileAsync(mixTransInfoAndFilePathVO.getVo(),
                mixTransInfoAndFilePathVO.getLocalPath(), mixTransInfoAndFilePathVO.getClientTransId(), mixTransInfoAndFilePathVO.getServerTransId());
    }

}
