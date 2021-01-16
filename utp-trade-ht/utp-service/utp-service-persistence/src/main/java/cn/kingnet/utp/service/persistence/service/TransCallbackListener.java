package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.TransCallbackLog;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/22
 */
@Component
@Slf4j
public class TransCallbackListener implements MessageListener {

    @Resource
    private RedisTemplate redisTemplate;
    private ExecutorService executorService;

    public TransCallbackListener() {
        executorService = new ThreadPoolExecutor(2, 4, 0, TimeUnit.MICROSECONDS, new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("TransCallbackListener-%s").build());
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        try {
            Object callbackResp = redisTemplate.getValueSerializer().deserialize(message.getBody());
            if (callbackResp != null) {
                String key = RedisKey.fmtKey(RedisKey.TOPIC_HT_CALLBACK_RESP, String.valueOf(callbackResp.hashCode()));
                ValueOperations opsForValue = redisTemplate.opsForValue();
                if (!opsForValue.getOperations().hasKey(key)) {
                    opsForValue.set(key, callbackResp, 30, TimeUnit.SECONDS);
                    saveTransCallbackLog(callbackResp);
                }
            }
        } catch (SerializationException e) {
            log.error("序列化异常：{}", e.getMessage(), e);
        }

    }

    @Async
    public void saveTransCallbackLog(Object resp) {
        executorService.submit(() -> {
            try {
                String callbackResp = resp instanceof String ? (String) resp : JSON.toJSONString(resp);
                Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
                TransCallbackLog transCallbackLog = TransCallbackLog.builder().id(IdGenerate.getId()).callbackResp(callbackResp).gmtCreate(date).gmtModified(date).build();
                MybatisDaoImpl.run().insert(transCallbackLog);
            } catch (Exception e) {
                log.error("持久化银行回调内容异常：{}", e.getMessage(), e);
            }
        });

    }


}
