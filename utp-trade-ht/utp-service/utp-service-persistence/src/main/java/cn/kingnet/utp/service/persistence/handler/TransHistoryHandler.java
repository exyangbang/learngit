package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.ITransHistoryHandler;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.TransCurrentCondition;
import cn.kingnet.utp.service.persistence.entity.TransHistory;
import cn.kingnet.utp.service.persistence.entity.TransHistoryCondition;
import cn.kingnet.utp.service.persistence.entity.vo.TransCurrentVo;
import cn.kingnet.utp.service.persistence.service.TransCurrentAndHistoryService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Description 历史交易流水处理接口实现
 * @Author WJH
 * @Date 2018年09月09日
 */
@RestController
@RequestMapping("/spi/persistence/transHistory")
public class TransHistoryHandler extends DefaultFeginExceptionHandler implements ITransHistoryHandler {

    @Resource
    private TransCurrentAndHistoryService transCurrentAndHistoryService;

    /**
     * 保存历史流水信息
     *
     * @param transHistoryList
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTransHistory(@RequestBody(required = false) List<TransHistory> transHistoryList) {
        if (!CollectionUtils.isEmpty(transHistoryList)) {
            MybatisDaoImpl.run().insertBatch(transHistoryList, 100);
        }
    }

    @Override
    public List<TransHistory> queryByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                             @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                             @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台代码不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与服务端流水不能同时为空");
        }
        TransHistoryCondition condition = TransHistoryCondition.builder().andIndustryCodeEq(industryCode);
        if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
            condition.andClientTransIdEq(clientTransId).andServerTransIdEq(serverTransId);
        } else if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(serverTransId)) {
            condition.andClientTransIdEq(clientTransId);
        } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
            condition.andServerTransIdEq(serverTransId);
        }
        List<TransHistory> list = MybatisDaoImpl.run().selectList(condition.build());

        return list;
    }

    /**
     * 获取对账记录
     *
     * @param industryCode 平台代码
     * @param settleDate   对账日期
     * @return
     */
    @Override
    public List<TransHistory> querySettleDataByIndustryCodeAndDate(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                   @RequestParam(value = "settleDate", required = false) String settleDate) {
        if (StringUtil.isBlank(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户号不能为空");
        }
        if (StringUtil.isBlank(settleDate)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "对账文件日期不能为空");
        }
        PlusEntityWrapper<TransHistory> plusEntityWrapper = TransHistoryCondition.builder().andIndustryCodeEq(industryCode)
                .andReconcileStatusEq(TrueOrFalseStatus.TRUE.value()).andTransStatusEq(TransStatus.TRADE_SUCCESS.name()).andReconcileDateEq(settleDate).orderDesc(TransHistory::getTransTime).build();
        List<TransHistory> list = MybatisDaoImpl.run().selectList(plusEntityWrapper);
        return list;
    }

    /**
     * 行业代码 + 客户端流水号 或者 行业代码 + 批次号 是否存在
     *
     * @param industryCode
     * @param clientTransId
     * @param batchId
     * @return
     */
    @Override
    public boolean isExistByIndustryCodeAndClientTransIdOrBatchId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                  @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                  @RequestParam(value = "batchId", required = false) String batchId) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "行业代码不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(batchId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与批次号不能同时为空");
        }
        TransHistoryCondition condition = TransHistoryCondition.builder().andIndustryCodeEq(industryCode);
        if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isNotEmpty(batchId)) {
            condition.and().andClientTransIdEq(clientTransId).orServerBatchNoEq(batchId);
        } else if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(batchId)) {
            condition.andClientTransIdEq(clientTransId);
        } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(batchId)) {
            condition.andServerBatchNoEq(batchId);
        }
        int count = MybatisDaoImpl.run().selectCount(condition.build());
        return count > 0 ? true : false;
    }

    /**
     * 查询下载平台对账单数据
     *
     * @param industryCode
     * @param reconcileDate
     * @return
     */
    @GetMapping("/downloadReconcileData")
    @Override
    public List<TransCurrentVo> downloadReconcileData(@RequestParam(value = "industryCode") String industryCode,
                                                      @RequestParam(value = "reconcileDate") String reconcileDate) {
        List<TransCurrentVo> transCurrentVoList = Lists.newArrayList();

        List<TransHistory> historyList = MybatisDaoImpl.run().selectList(TransHistoryCondition.builder()
                .andIndustryCodeEq(industryCode).andReconcileDateEq(reconcileDate).andReconcileStatusEq(TrueOrFalseStatus.TRUE.value())
                .andTransStatusEq(TransStatus.TRADE_SUCCESS.name()).build());
        Optional.ofNullable(historyList).ifPresent(l -> l.forEach(o -> {
            TransCurrentVo currentVo = new TransCurrentVo();
            BeanUtils.copyProperties(o.buildVo(), currentVo);
            transCurrentVoList.add(currentVo);
        }));
        if (CollectionUtils.isEmpty(transCurrentVoList)) {
            List<TransCurrent> currentList = MybatisDaoImpl.run().selectList(TransCurrentCondition.builder()
                    .andIndustryCodeEq(industryCode)
                    .andReconcileDateEq(reconcileDate)
                    .andReconcileStatusEq(TrueOrFalseStatus.TRUE.value())
                    .andTransStatusEq(TransStatus.TRADE_SUCCESS.name()).build());
            Optional.ofNullable(currentList).ifPresent(l -> l.forEach(o -> {
                transCurrentVoList.add(o.buildVo());
            }));
        }
        return transCurrentVoList;
    }

    @PostMapping("/downloadIndustryD1SpecailReconFile")
    @Override
    public byte[] downloadIndustryD1SpecailReconFile(@RequestParam("industryCode") String industryCode, @RequestParam("txDate") String txDate) {
        return transCurrentAndHistoryService.downloadIndustryD1SpecailReconFile(industryCode, txDate);
    }

    @PostMapping("/downloadIndustrySubAccountDailyBalanceFile")
    @Override
    public byte[] downloadIndustrySubAccountDailyBalanceFile(@RequestParam("industryCode") String industryCode, @RequestParam("txDate") String txDate) {
        return transCurrentAndHistoryService.downloadIndustrySubAccountDailyBalanceFile(industryCode, txDate);
    }


}
