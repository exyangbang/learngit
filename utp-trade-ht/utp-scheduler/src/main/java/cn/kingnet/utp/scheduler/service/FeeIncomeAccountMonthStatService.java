package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthStat;
import cn.kingnet.utp.scheduler.data.entity.FeeIncomeAccountMonthStatCondition;
import cn.kingnet.utp.scheduler.data.mapper.FeeIncomeAccountMonthStatMapper;
import cn.kingnet.utp.trade.common.enums.CollectionStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/21
 */
@Service
@Slf4j
public class FeeIncomeAccountMonthStatService {

    @Transactional(rollbackFor = Exception.class)
    public void feeIncomeAccountMonthStat(final String statMonth, final String account) {
        LambdaLogger.info(log, "手续费收益账户月[{}]统计 开始执行...", statMonth);
        long sTime = System.currentTimeMillis();
        try {
            try {
                LocalDate.parse(statMonth + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
            } catch (Exception e) {
                throw new SchedulerException(HttpRespStatus.BAD_REQUEST, "statMonth参数格式yyyyMM错误");
            }

            Map<String, Object> params = new HashMap(2);
            params.put("statMonth", statMonth);
            params.put("account", account);
            List<FeeIncomeAccountMonthStat> list = MybatisDaoImpl.of(FeeIncomeAccountMonthStatMapper.class).selectListBySql("feeIncomeAccountMonthStatList", params);
            if (CollectionUtils.isEmpty(list)) {
                LambdaLogger.info(log, "手续费收益账户月[{}]统计 执行完成,统计账户数:{},用时{}ms", statMonth, 0, System.currentTimeMillis() - sTime);
                return;
            }

            PlusEntityWrapper<FeeIncomeAccountMonthStat> plusEntityWrapper = FeeIncomeAccountMonthStatCondition.builder().andStatMonthEq(statMonth).build();
            List<FeeIncomeAccountMonthStat> existsList = MybatisDaoImpl.run().selectList(plusEntityWrapper);
            List<String> collectedList = new ArrayList<>();
            Map<String, Long> unCollectedMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(existsList)) {
                existsList.stream().forEach(o -> {
                    if (CollectionStatus.COLLECTED.getStatus().equals(o.getCollectionStatus()) || TransStatus.TRADE_SUCCESS.name().equals(o.getTransStatus()) || TransStatus.PROCESSING.name().equals(o.getTransStatus())) {
                        collectedList.add(o.getAccount());
                    }{
                        unCollectedMap.put(o.getAccount(), o.getId());
                    }
                });
            }
            List<FeeIncomeAccountMonthStat> updateList = new ArrayList<>();
            List<FeeIncomeAccountMonthStat> insertList = new ArrayList<>();
            Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
            Set unCollectedSet = unCollectedMap.keySet();
            list.stream().forEach(o -> {
                if (collectedList.contains(o.getAccount())) {
                    LambdaLogger.warn(log, "月份[{}]收益账户[{}]{} 已归集划转成功或归集划转处理中，不能再次归集统计.", statMonth, o.getAccount(), o.getName());
                }
                else if (unCollectedSet.contains(o.getAccount())) {
                    o.setId(unCollectedMap.get(o.getAccount()));
                    o.setGmtModified(date);
                    o.setCollectionStatus(CollectionStatus.UN_COLLECT.getStatus());
                    //重置上次划转数值为空
                    o.setRemark("重新归集成功[未划转]");
                    o.setTransDesc(null);
                    o.setTransStatus(null);
                    o.setServerTransId(null);
                    updateList.add(o);
                } else {
                    o.setId(IdGenerate.getId());
                    o.setStatMonth(statMonth);
                    o.setCollectionStatus(CollectionStatus.UN_COLLECT.getStatus());
                    o.setGmtCreate(date);
                    o.setGmtModified(date);
                    insertList.add(o);
                }
            });
            if (!CollectionUtils.isEmpty(insertList)) {
                MybatisDaoImpl.run().insertBatch(insertList, 100);
            }
            if (!CollectionUtils.isEmpty(updateList)) {
                MybatisDaoImpl.run().updateBatchById(updateList, 100);
            }
            LambdaLogger.info(log, "手续费收益账户月[{}]统计 执行完成,统计新增账户数:{},更新用户数：{},用时{}ms", statMonth, insertList.size(), updateList.size(), System.currentTimeMillis() - sTime);
        } catch (Exception e) {
            log.error("手续费收益账户月[{}]统计 异常终止执行，异常：[{}]", statMonth, e.getMessage(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, String.format("手续费收益账户月[%s]统计 异常终止执行，异常：[%s]", statMonth, e.getMessage()));
        }

    }
}
