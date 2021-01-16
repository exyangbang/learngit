package cn.kingnet.utp.service.persistence.support;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrderCondition;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.service.persistence.service.OutsideTransOrderService;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 外部支付流水存量数据重新加载转换
 *
 * @Description
 * @Author WJH
 * @Date 2020/10/20
 */
@Slf4j
@Component
@Order(value = 12)
public class OutsideTransFlowDataReloadService implements ApplicationRunner {
    private RedisTemplate redisTemplate;
    private final String key = RedisKey.fmtKey(RedisKey.COMMON, "transFlowIdReload", "firstTime");

    private OutsideTransOrderService outsideTransOrderService;
    private CommonRedisService commonRedisService;

    public OutsideTransFlowDataReloadService(CommonRedisService commonRedisService, OutsideTransOrderService outsideTransOrderService) {
        this.commonRedisService = commonRedisService;
        this.outsideTransOrderService = outsideTransOrderService;
        this.redisTemplate = commonRedisService.getRedisTemplate();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (redisTemplate.hasKey(key)) {
            doLoadData(false);
        } else {
            BoundValueOperations bOpts = redisTemplate.boundValueOps(key);
            try {
                log.info("开始 首次加载存量订单支付流水转换数据至Redis...");
                bOpts.set(true);
                doLoadData(true);
                log.info("结束 首次加载存量订单支付流水转换数据至Redis...");
            } catch (Exception e) {
                bOpts.getOperations().delete(key);
                log.error("首次加载存量订单支付流水转换数据至Redis:", e);
            }
        }
    }

    /**
     * 可提供外部触发 重新加载
     *
     * @param firstTime
     */
    public void doLoadData(boolean firstTime) throws Exception {
        if (firstTime) {
            reloadTransFlowIdOfSuccess();
        } else {
            log.info("已加载存量订单支付流水转换数据至Redis");
        }
    }


    private void reloadTransFlowIdOfSuccess() {
        //外部支付流水成功的支付流水->支付流水对象 [原先存储transFlowsId 改为存储对象]
        try {
            //每次加载1000条，
            PlusEntityWrapper<OutsideTransOrder> condition = OutsideTransOrderCondition.builder().andUploadStatusEq("SUCCESS").build();
            int totalRows = MybatisDaoImpl.run().selectCount(condition);
            int pageSize = 1000;

            Page page = new Page(1, pageSize);
            page.setTotal(totalRows);

            RedisSerializer hashValueSerializer = redisTemplate.getHashValueSerializer();

            for (int curPage = page.getCurrent(); curPage <= page.getPages(); curPage++) {
                long startTime = System.currentTimeMillis();
                List<OutsideTransOrder> list = MybatisDaoImpl.run().selectPage(condition, curPage, pageSize);
                if (list != null && !list.isEmpty()) {
                    this.redisTemplate.executePipelined((RedisCallback<OutsideTransOrder>) conn -> {
                        conn.openPipeline();
                        for (OutsideTransOrder order : list) {
                            if (order != null && StringUtil.isNoneBlank(order.getIndustryCode(), order.getTransOrderId())) {
                                String hashKey = commonRedisService.genOutSideTransOrderHashKey(order.getIndustryCode(), order.getTransOrderId(), false);
                                conn.hashCommands().hSet(hashKey.getBytes(), order.getTransOrderId().getBytes(), hashValueSerializer.serialize(order));
                            }
                        }
                        return null;
                    });
                }
                log.info("共[{}]成功记录每页{}条共[{}]页，当前第[{}]页转换存储完成.耗时[{}]ms", totalRows, pageSize, page.getPages(), curPage, (System.currentTimeMillis() - startTime));
            }
        } catch (Exception e) {
            log.error("加载存量订单支付流水转换数据至Redis异常:{}", e.getMessage(), e);
            throw new RuntimeException("加载存量订单支付流水转换数据至Redis异常", e);
        }
    }
}
