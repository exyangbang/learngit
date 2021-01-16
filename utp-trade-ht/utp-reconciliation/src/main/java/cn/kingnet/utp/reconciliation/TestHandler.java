package cn.kingnet.utp.reconciliation;

import cn.kingnet.framework.starter.redis.redisson.executor.RedisLockExecutor;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.NamedNode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author WJH
 * @Date 2020/04/17
 */
@RequestMapping
@RestController
@Slf4j
public class TestHandler {
    @Resource
    private RedisLockExecutor redisLockExecutor;
    private final RedisLockExecutor twoRedisLockExecutor;
    @Resource
    private RedisTemplate redisTemplate;
    private final RedisTemplate twoRedisTemplate;
    @Resource
    private RedisProperties redisProperties;
    @Resource
    private RedissonClient redissonClient;

    public TestHandler(RedisLockExecutor twoRedisLockExecutor, RedisTemplate<String, Object> twoRedisTemplate) {
        this.twoRedisLockExecutor = twoRedisLockExecutor;
        this.twoRedisTemplate = twoRedisTemplate;
    }


    private void isTrue() {
        log.error("one=twoRedisTemplate = {}", (redisTemplate == twoRedisTemplate));
        log.error("one=twoRedisLockExecutor = {}", (redisLockExecutor == twoRedisLockExecutor));
        if(redisProperties!=null && redisProperties.getSentinel()!=null) {
            List<NamedNode> masterNameList = Lists.newArrayList();

            redisTemplate.getRequiredConnectionFactory().getSentinelConnection().masters().stream().forEach(m -> {
                log.error("redisTemplate masters isMaster={} isSlave={}  redisServer = {}", m.isMaster(), m.isSlave(), JSON.toJSONString(m));
                masterNameList.add(m);
            });
            Optional.ofNullable(masterNameList).ifPresent(l -> {
                l.stream().forEach(o -> {
                    redisTemplate.getRequiredConnectionFactory().getSentinelConnection().slaves(o).stream().forEach(m -> {
                        log.error("redisTemplate slaves isMaster={} isSlave={}  redisServer = {}", m.isMaster(), m.isSlave(), JSON.toJSONString(m));
                    });
                });
            });
        }

    }

    @RequestMapping("/t/{type}/{key}/{val}")
    public Object t(@PathVariable("type") String type, @PathVariable("key") String key, @PathVariable("val") Object val) {
        isTrue();
        StringBuilder stringBuilder = new StringBuilder();
        switch (type) {
            case "1": {
                log.error("1hasKey={}", redisTemplate.hasKey(key));
                redisTemplate.boundValueOps(key).set(val);
                log.error("1getKey={}", redisTemplate.boundValueOps(key).get());
            }
            break;
            case "2": {
                log.error("2hasKey={}", twoRedisTemplate.hasKey(key));
                twoRedisTemplate.boundValueOps(key).set(val);
                log.error("2getKey={}", twoRedisTemplate.boundValueOps(key).get());
                break;
            }
            case "3": {
                try {
                    log.error("3hasKey={}", twoRedisTemplate.hasKey(key));
                    redisLockExecutor.execute(type + "_" + key, 3, val, (v) -> {
                        log.error("3v = " + v);
                        twoRedisTemplate.boundValueOps(key).set(val);
                    });
                    log.error("3getKey={}", twoRedisTemplate.boundValueOps(key).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("e.getMessage() = " + e.getMessage(), e);
                }

                break;
            }
            case "4": {

                try {
                    log.error("4hasKey={}", twoRedisTemplate.hasKey(key));
                    twoRedisLockExecutor.execute(type + "_" + key, 3, val, (v) -> {
                        log.error("4v = " + v);
                        twoRedisTemplate.boundValueOps(key).set(val);
                    });
                    log.error("4getKey={}", twoRedisTemplate.boundValueOps(key).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("e.getMessage() = " + e.getMessage(), e);
                }

            }
            break;
            case "5": {
                try {
                    log.error("redisson read start==============");
                    RBucket<Object> rBucket = redissonClient.getBucket("testk");
                    log.error("redisson read end==============" + JSON.toJSONString(rBucket.get()));
                } catch (Exception e) {
                    log.error("redisson 读取异常:", e);
                    e.printStackTrace();
                }
                try {
                    log.error("redisson write start==============");
                    RBucket<Object> rBucket = redissonClient.getBucket("testk2");
                    rBucket.set("testv2");
                    log.error("redisson write end==============" + JSON.toJSONString(rBucket.get()));
                } catch (Exception e) {
                    log.error("redisson 先读后写异常:", e);
                    e.printStackTrace();
                }
                try {
                    log.error("redisson lock start==============");
                    RLock rLock = redissonClient.getLock("lockTest");
                    rLock.lock();
                    log.error("redisson lock procession====isLocked==========" + rLock.isLocked());
                    rLock.unlock();
                    log.error("redisson lock end========isLocked======" + rLock.isLocked());
                } catch (Exception e) {
                    log.error("redisson 分布式锁操作异常:", e);
                    e.printStackTrace();
                }
            }
            default: {

            }


        }


        return null;
    }

    public static void main(String[] args) {

        System.out.println("args = " + args);

        Pair<String,String>
             triple   = Pair.of("1","2");

        System.out.println("triple = " + JSON.toJSONString(triple));

    }

}
