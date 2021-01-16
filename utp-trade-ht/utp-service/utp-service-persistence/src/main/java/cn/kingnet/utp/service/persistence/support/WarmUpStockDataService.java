//package cn.kingnet.utp.service.persistence.support;
//
//import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
//import cn.kingnet.framework.starter.mybatis.dao.SqlStatementOption;
//import cn.kingnet.utp.service.persistence.entity.*;
//import cn.kingnet.utp.service.persistence.mapper.BankAccountTransDetailMapper;
//import cn.kingnet.utp.service.persistence.service.BankAccountTransDetailService;
//import cn.kingnet.utp.service.persistence.service.IndustryService;
//import cn.kingnet.utp.service.persistence.service.TransCurrentAndHistoryService;
//import cn.kingnet.utp.trade.common.enums.RedisKey;
//import cn.kingnet.utp.trade.common.utils.StringUtil;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.google.common.collect.Maps;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//
///**
// * 加载存量数据到redis
// *
// * @Description 已转换完成无需处处理
// * @Author WJH
// * @Date 2020/04/13
// */
//@Slf4j
//@Component
//@Order(value = 10)
//@Deprecated
//public class WarmUpStockDataService implements ApplicationRunner {
//    private RedisTemplate redisTemplate;
//    private final String key = RedisKey.fmtKey(RedisKey.COMMON, "stockData", "firstTime");
//    @Resource
//    private IndustryService industryService;
//    @Resource
//    private TransCurrentAndHistoryService transCurrentAndHistoryService;
//    @Resource
//    private BankAccountTransDetailService bankAccountTransDetailService;
//
//    public WarmUpStockDataService(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        if (redisTemplate.hasKey(key)) {
//            doLoadData(false);
//        } else {
//            BoundValueOperations bOpts = redisTemplate.boundValueOps(key);
//            try {
//                log.info("开始 首次加载存量数据至Redis...");
//                bOpts.set(true);
//                doLoadData(true);
//                log.info("结束 首次加载存量数据至Redis...");
//            } catch (Exception e) {
//                bOpts.getOperations().delete(key);
//                log.error("加载存量数据至Redis异常:", e);
//            }
//        }
//    }
//
//    /**
//     * 可提供外部触发 重新加载
//     *
//     * @param firstTime
//     */
//    public void doLoadData(boolean firstTime)throws Exception {
//        if (firstTime) {
//            loadDataOfBankTransCoreNo();
//            loadDataOfTransId();
//        } else {
//            log.info("已加载过存量数据至Redis");
//        }
//    }
//
//
//    private void loadDataOfTransId() throws Exception {
//        //客户号 下的 客户端 、服务端流水
//        List<Industry> industryList = industryService.selectList(IndustryCondition.builder().build());
//        if (!CollectionUtils.isEmpty(industryList)) {
//            for (Industry o : industryList) {
//                if (StringUtil.isNotBlank(o.getCode())) {
//                    CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> transCurrentAndHistoryService.loadStockTransId2Redis(o.getCode()))
//                            .exceptionally((e) -> {
//                                log.error("加载客户号[{}]存量交易流水异常:{}", o.getCode(), e.getMessage());
//                                return false;
//                            });
//                    if (!future.get()) {
//                        throw new RuntimeException("加载存量交易流水异常");
//                    }
//                }
//            }
//        }
//    }
//
//    private void loadDataOfBankTransCoreNo() {
//        //实体账户 下的 核心流水号
//        try {
//            Map<String, String> params = Maps.newHashMap();
//            //每次加载1000条，
//            int count = MybatisDaoImpl.run().selectCount(BankAccountTransDetailCondition.builder().build());
//            Page page = new Page(1, 1000);
//            page.setTotal(count);
//            SqlStatementOption sqlStatementOption = MybatisDaoImpl.of(BankAccountTransDetailMapper.class);
//            for (int cur = page.getCurrent(); cur <= page.getPages(); cur++) {
//                List<Map<String, String>> list = sqlStatementOption.selectPageBySql("selectFundAccountCoreNo", params, cur, page.getSize());
//                if (list != null && !list.isEmpty()) {
//                    //cust_account_no,t.sys_reference_no,t.other_rid
//                    for (Map<String, String> map : list) {
//                        //待优化批量操作
//                        bankAccountTransDetailService.setRedisCoreNoHashField(map.get("cust_account_no"), map.get("sys_reference_no"), map.get("other_rid"));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.error("加载存量实体账户资金流水核心流水号 到 redis缓存异常:{}", e.getMessage(), e);
//            throw new RuntimeException("加载存量实体账户资金流水核心流水号 到 redis缓存异常", e);
//        }
//    }
//}
