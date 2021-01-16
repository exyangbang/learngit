package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.utp.service.persistence.entity.bo.CallbackNoticeBO;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * 将通知信息存储到redis
 *
 * @author zhongli
 * @date 2019-02-25
 */
@Service
@Slf4j
public class MsgNoticeService {
    RedisTemplate redisTemplate;

    public MsgNoticeService(RedisTemplate redisTemplate) {
        this.redisTemplate = new RedisTemplate();
        this.redisTemplate.setConnectionFactory(redisTemplate.getRequiredConnectionFactory());
        this.redisTemplate.setKeySerializer(redisTemplate.getKeySerializer());
        this.redisTemplate.setHashKeySerializer(redisTemplate.getHashKeySerializer());
        this.redisTemplate.setDefaultSerializer(redisTemplate.getDefaultSerializer());
        this.redisTemplate.setValueSerializer(redisTemplate.getValueSerializer());
        this.redisTemplate.setHashValueSerializer(redisTemplate.getHashValueSerializer());
        this.redisTemplate.setEnableTransactionSupport(true);
        this.redisTemplate.afterPropertiesSet();
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveNoticeCallbackMessage(String callbackUrl, String industryCode, String serverTransId, Map<String, Object> content) {
        log.info("redis保存回调通知信息 流水号:{}>> 代付客户号[{}] 回调地址[{}] 回调通知报文：{}", serverTransId, industryCode, callbackUrl, JSON.toJSONString(content));
        if (StringUtil.isBlank(callbackUrl)) {
            log.error("流水号:{}>> 代付客户号[{}] 回调地址为空,暂无法通知下游合作商,请联系管理员配置.", serverTransId, industryCode);
            return;
        }
        callbackUrl = callbackUrl.trim();
        if (callbackUrl.toLowerCase().startsWith("http") || callbackUrl.toLowerCase().startsWith("https")) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            CallbackNoticeBO bo = CallbackNoticeBO.builder().id(IdWorker.getId()).industryCode(industryCode).serverTransId(serverTransId)
                    .callbackUrl(callbackUrl).content(content).noticeStatus(0).noticeCount(0).time(time).build();
            this.redisTemplate.boundHashOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_HASH_KEY)).put(bo.getId().toString(), bo);
            this.redisTemplate.boundZSetOps(RedisKey.fmtKey(RedisKey.CALLBACK_NOTICE_ZSET_KEY)).add(bo.getId().toString(), Double.valueOf(time));
        } else {
            log.error("流水号:{}>> 代付客户号[{}] 非http|https开头回调地址[{}] ,暂无法通知下游合作商,请联系管理员核实.", serverTransId, industryCode, callbackUrl);
        }
    }

}
