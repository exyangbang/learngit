package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.data.entity.UploadSubAccountSettleSplitDetail;
import cn.kingnet.utp.scheduler.data.entity.UploadSubAccountSettleSplitDetailCondition;
import cn.kingnet.utp.service.persistence.api.ISubAccountSettleSplitHandler;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 子账户清分处理Tn
 * @Author WJH
 * @Date 2018年11月07日
 */
@Slf4j
@Component
public class SubAccountSettleSplitTnTask {
    private final ExecutorService executorService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ISubAccountSettleSplitHandler subAccountSettleSplitHandler;
    private static final String subAccountTnSplit_zSetKey = RedisKey.fmtKey(RedisKey.SUBACCOUNT_TN_SPLIT, "ZSET_KEY");
    private static final String subAccountTnSplit_HashKey = RedisKey.fmtKey(RedisKey.SUBACCOUNT_TN_SPLIT, "HASH_KEY");
    private static final String subAccountTnSplit_CompletedHashKey = RedisKey.fmtKey(RedisKey.SUBACCOUNT_TN_SPLIT, "COMPLETED_HASH_KEY");


    public SubAccountSettleSplitTnTask() {
        this.executorService = new ThreadPoolExecutor(4, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("SubAccountSettleSplitTnTask-%d").build(), new ThreadPoolExecutor.DiscardPolicy());
    }

    /**
     * 设置当日Tn的子账户清分记录
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.subAccountSettleSplitDaily}")
    public void pushSubAccountSettleSplitDetail() {
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        try {
            log.info("设置RedisTn的子账户清分日期[{}]记录任务开启..", date);
            PlusEntityWrapper<UploadSubAccountSettleSplitDetail> condition =
                    UploadSubAccountSettleSplitDetailCondition.builder().andSplitDateEq(date).andTransStatusEq(TransStatus.PRE_CREATE.name()).andPeriodGt(0).build();
            long total = MybatisDaoImpl.run().selectCount(condition);
            if (total == 0) {
                log.warn("查无子账户Tn分账日期[{}]记录，当日无需处理Tn分账处理", date);
                return;
            }
            Page page = new Page(1, 1000);
            page.setTotal(total);
            long pages = page.getPages();
            AtomicLong atomicLong = new AtomicLong();
            BoundZSetOperations zSetOperations = redisTemplate.boundZSetOps(subAccountTnSplit_zSetKey);
            BoundHashOperations hashOperations = redisTemplate.boundHashOps(subAccountTnSplit_HashKey);
            for (int i = 1; i <= pages; i++) {
                List<UploadSubAccountSettleSplitDetail> details = MybatisDaoImpl.run().selectPage(condition, i, page.getSize());
                if (details != null && !details.isEmpty()) {
                    details.stream().filter(o -> o.getPeriod() > 0).forEach(detail -> {
                        if (hashOperations.putIfAbsent(detail.getClientTransId(), detail)) {
                            zSetOperations.add(detail.getClientTransId(), atomicLong.incrementAndGet());
                        }
                    });
                }
            }
        } catch (Exception e) {
            log.error("设置redis子账户Tn清分日期[{}]记录异常：{}", date, e.getMessage(), e);
        }

        log.info("设置RedisTn的子账户清分日期[{}]记录任务完成...", date);
    }


    /**
     * 拉取当日Tn的子账户清分记录并处理
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.subAccountSettleSplitPeriod}")
    public void pullSubAccountSettleSplitDetail() {
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        try {
            BoundZSetOperations zSetOperations = redisTemplate.boundZSetOps(subAccountTnSplit_zSetKey);
            BoundHashOperations hashOperations = redisTemplate.boundHashOps(subAccountTnSplit_HashKey);
            BoundHashOperations completedHashOpts = redisTemplate.boundHashOps(subAccountTnSplit_CompletedHashKey);
            Set<ZSetOperations.TypedTuple> zSet = zSetOperations.rangeWithScores(0, 100);
            if (zSet != null && !zSet.isEmpty()) {
                Iterator<ZSetOperations.TypedTuple> iterator = zSet.iterator();
                while (iterator.hasNext()) {
                    ZSetOperations.TypedTuple typedTuple = iterator.next();
                    String transClientId = String.valueOf(typedTuple.getValue());
                    Object detail = hashOperations.get(transClientId);
                    if (completedHashOpts.hasKey(transClientId)) {
                        log.warn("客户端流水号：{} 子账户Tn分账处理已处理，不能重复处理.", transClientId);
                        continue;
                    }
                    if (detail instanceof UploadSubAccountSettleSplitDetail) {
                        UploadSubAccountSettleSplitDetail cur = (UploadSubAccountSettleSplitDetail) detail;
                        executorService.submit(() -> {
                            try {
                                zSetOperations.remove(transClientId);
                                completedHashOpts.putIfAbsent(transClientId, cur);
                                hashOperations.delete(transClientId);
                                subAccountSettleSplitHandler.processSubAccountSettleSplitDetail4Tn(buildDetail(cur));
                                log.info("客户端流水号：{} 子账户Tn分账处理完成.", transClientId);
                            } catch (Exception e) {
                                log.error("客户端流水号：{} 子账户Tn分账处理异常：{}", transClientId, e.getMessage(), e);
                            }
                        });
                    }
                }

            }
        } catch (Exception e) {
            log.error("子账户Tn清分日期[{}]处理异常：{}", date, e.getMessage(), e);
        }
    }

    private cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail buildDetail(UploadSubAccountSettleSplitDetail detail) {
        return JSON.parseObject(JSON.toJSONBytes(detail), cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail.class);
    }

}
