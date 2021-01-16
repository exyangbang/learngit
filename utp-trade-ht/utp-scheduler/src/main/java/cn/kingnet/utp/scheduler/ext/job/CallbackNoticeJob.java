package cn.kingnet.utp.scheduler.ext.job;

import cn.kingnet.product.api.account.IUtpCallbackHandler;
import cn.kingnet.utp.service.persistence.entity.bo.CallbackNoticeBO;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 获取redis缓存内 回调通知
 * 每间隔periodseconds秒运行一次
 *
 * @author zhongli
 * @date 2019-02-26
 */
@Component
@Slf4j
public class CallbackNoticeJob {
    private final WorkTask workTask;
    final ExecutorService workService;
    private final ScheduledThreadPoolExecutor dispatchService;
    @Value("${cn.kingnet.utp.schedule.deposit-notice.periodseconds}")
    private String periodseconds;

    public CallbackNoticeJob(IUtpCallbackHandler utpCallbackHandler, RedisTemplate redisTemplate) {
        this.workTask = new WorkTask(utpCallbackHandler, redisTemplate);
        this.workService = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("CallbackNotice-Work-%d").build(), new ThreadPoolExecutor.DiscardPolicy());
        this.dispatchService = new ScheduledThreadPoolExecutor(4, new ThreadFactoryBuilder().setNameFormat("CallbackNotice-Dispatch-%d").build());
    }

    @PostConstruct
    public void init() {
        run();
    }

    private void run() {
        dispatchService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                workService.execute(workTask);
            }
        }, 30, Integer.valueOf(periodseconds), TimeUnit.SECONDS);
    }

    static class WorkTask implements Runnable {
        private final RedisTemplate redisTemplate;
        private final IUtpCallbackHandler utpCallbackHandler;
        private final ExecutorService callBackExecutorService;

        public WorkTask(IUtpCallbackHandler utpCallbackHandler, RedisTemplate redisTemplate) {
            this.redisTemplate = redisTemplate;
            this.utpCallbackHandler = utpCallbackHandler;
            this.callBackExecutorService = new ThreadPoolExecutor(4, 500,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(300), new ThreadFactoryBuilder().setNameFormat("callBackExecutorService-%d").build(), new ThreadPoolExecutor.DiscardPolicy());

        }


        /**
         * -----------------------------------------------------------------------------------------
         * | 从redis的有序集合中CALLBACK_NOTICE_ZSET_KEY获取一定范围的数据，并通过删除的方式锁定要操作的id  |
         * -----------------------------------------------------------------------------------------
         * /                              ＼
         * /                                ＼
         * --------------------------------               ----------------------
         * | 取到数据，通过id获取HASH中的对象 |              |未取到数据，跳过此次任务|
         * --------------------------------               -----------------------
         * /
         * /
         * -------------            ----------------------
         * | HASH中有对象|         | HASH无对象，打印错误日志 |
         * -------------            ----------------------
         * |
         * ------------------------------------
         * | 对象中获取回调URL，回调获取状态 |
         * ------------------------------------
         * |
         * ----------------------------------------------
         * | 根据回调结果更新HASH的对象回调次数和回调结果状态 |
         * -----------————-------------------------------
         */
        @Override
        public void run() {
            try {
                Set<ZSetOperations.TypedTuple<String>> result = this.redisTemplate.boundZSetOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_ZSET_KEY)).rangeWithScores(0, 200);
                if (result == null || result.size() == 0) {
                    return;
                }
                Iterator<ZSetOperations.TypedTuple<String>> it = result.iterator();
                while (it.hasNext()) {
                    ZSetOperations.TypedTuple<String> typedTuple = it.next();
                    LocalDateTime dateTime = LocalDateTime.parse(String.valueOf(typedTuple.getScore().longValue()), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                    if (dateTime.isAfter(LocalDateTime.now())) {
                        continue;
                    }
                    Long rmTotal = this.redisTemplate.boundZSetOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_ZSET_KEY)).remove(typedTuple.getValue());
                    if (rmTotal.intValue() > 0) {
                        String optionKey = typedTuple.getValue();
                        Object obj = this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).get(optionKey);
                        if (obj instanceof CallbackNoticeBO) {
                            processCurCallback((CallbackNoticeBO) obj, typedTuple.getScore());
                        } else {
                            this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).delete(optionKey);
                            log.error("id[{}]缓存对象非CallbackNoticeBO类型,删除该缓存且不再回调。缓存对象[{}]", optionKey, JSON.toJSONString(obj));
                        }
                    }
                }
            } catch (Exception e) {
                log.error("回调通知出现异常 需要人工排查：{}", e.getMessage(), e);
            }
        }

        /**
         * 回调通知下游
         *
         * @param bo
         * @return
         */
        private int callbackNotice(CallbackNoticeBO bo) {
            int callbackResult = -1;
            try {
                String url = bo.getCallbackUrl();
                boolean successCallback = utpCallbackHandler.callbackNotice(bo.getIndustryCode(), url, bo.getContent());
                if (successCallback) {
                    callbackResult = 0;
                } else {
                    callbackResult = 1;
                    bo.setRemoteExceptionCount(bo.getRemoteExceptionCount() + 1);
                    bo.setRemoteExceptionMsg("通知失败");
                    log.error("id{} >> 服务端流水号:{}>> 回调地址[{}] 第[]次通知失败:{}", bo.getId(), bo.getServerTransId(), bo.getCallbackUrl(), bo.getRemoteExceptionCount(), bo.getRemoteExceptionMsg());
                }
            } catch (Exception e) {
                callbackResult = -1;
                bo.setRemoteExceptionCount(bo.getRemoteExceptionCount() + 1);
                bo.setRemoteExceptionMsg(e.getMessage());
                log.error("id{} >> 服务端流水号:{}>> 回调地址[{}] 第{}次通知异常:{}", bo.getId(), bo.getServerTransId(), bo.getCallbackUrl(), bo.getRemoteExceptionCount(), bo.getRemoteExceptionMsg());
            }
            return callbackResult;
        }

        /**
         * 异步处理单笔回调
         *
         * @param bo
         * @param curScore
         */
        private void processCurCallback(final CallbackNoticeBO bo, Double curScore) {
            String id = bo.getId().toString();
            CompletableFuture.runAsync(() -> {
                try {
                    //先删除若通知失败|异常再补偿
                    this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).delete(id);
                    int callbackResult = this.callbackNotice(bo);
                    if (callbackResult == 0) {
                        this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).delete(id);
                    } else if (bo.getNoticeCount() >= 5) {
                        this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).delete(id);
                        log.error("回调次数超过5次，终止回调.回调信息 ==> {}", JSON.toJSONString(bo));
                    } else {//回调异常或回调失败
                        compensateNextCallback(id, bo, curScore, bo.getRemoteExceptionMsg());
                    }
                } catch (Exception e) {
                    log.error("回调通知异常 需要人工排查：{},回调次数[{}]及内容：{}", e.getMessage(), bo.getNoticeCount(), JSON.toJSONString(bo), e);
                    if (bo != null && bo.getId() != null && curScore > 0) {
                        compensateNextCallback(id, bo, curScore, "回调异常：" + e.getMessage());
                    }
                }
            }, this.callBackExecutorService);
        }

        private void compensateNextCallback(String id, CallbackNoticeBO bo, Double curScore, String compensateMessage) {
            bo.setNoticeStatus(1);
            int noticeCount = bo.getNoticeCount();
            bo.setNoticeCount(noticeCount + 1);
            String nextScope = getNextScore(noticeCount, curScore);
            bo.setNextScore(nextScope);
            bo.setRemoteExceptionMsg(compensateMessage);
            this.redisTemplate.boundZSetOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_ZSET_KEY)).add(id, Double.valueOf(nextScope));
            this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).put(id, bo);
        }


        private String getNextScore(int noticeCount, Double curScore) {
            LocalDateTime dateTime = LocalDateTime.parse(String.valueOf(curScore.longValue()), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            int intervals = getIntervals(noticeCount);
            dateTime = dateTime.plusSeconds(intervals);
            LocalDateTime now = LocalDateTime.now();
            if (!dateTime.isAfter(now)) {
                dateTime = now.plusSeconds(intervals);
            }
            //补偿下次回调数值
            return dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        }

        /**
         * 第一次间隔30秒
         * 第二次间隔1分钟
         * 第三次间隔5分钟
         * 第四次间隔15分钟
         * 第五次间隔30分钟
         *
         * @param count
         * @return
         */
        private int getIntervals(int count) {
            switch (count) {
                case 0:
                    return 30;
                case 1:
                    return 60;
                case 2:
                    return 300;
                case 3:
                    return 900;
                case 4:
                    return 1800;
                default:
                    return 3600;
            }

        }
    }
}
