package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.CardBinInfo;
import cn.kingnet.utp.service.persistence.entity.CardBinInfoCondition;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月08日
 */
@Service
@Slf4j
public class CardBinService {

    @Resource
    private RedisTemplate<String, CardBinInfo> redisTemplate;

    /**
     * 卡bin信息集合
     *
     * @param cardNo 银行卡
     * @return
     */
    public List<CardBinInfo> queryCardBinInfo(String cardNo) {
        List<CardBinInfo> reList = null;
        if (StringUtil.isNotEmpty(cardNo)) {
            List<CardBinInfo> list = MybatisDaoImpl.run().selectList(CardBinInfoCondition.builder()
                    .andCardnolenEq(cardNo.length())
                    .andStatusEq("1")
                    .build());
            reList = Optional.ofNullable(list).map(l ->
                    l.stream().filter(o ->
                            StringUtil.isNotEmpty(o.getBinnum()) &&
                                    StringUtil.isNotEmpty(o.getBinlen())
                    ).filter(o -> o.getBinnum().equals(cardNo.substring(0, Integer.valueOf(o.getBinlen())))
                    ).collect(Collectors.toList())
            ).orElse(null);
        }
        return reList;
    }

    /**
     * 卡号关联获取 人行清算行号
     * 匹配多条：约定取第一条
     *
     * @param cardNo
     * @return
     */
    public String getClearBankNo(String cardNo) {
        List<CardBinInfo> list = queryCardBinInfo(cardNo);
        if (CollectionUtils.isEmpty(list)) {
            log.error("查无此卡号:{} --> 关联的卡bin信息", cardNo);
            return null;
        }
        if (list.size() > 1) {
            log.warn("查此卡号:{} --> 关联的卡bin信息有多条.记录集：{}", cardNo, JSON.toJSONString(list));
        }
        return list.get(0).getClearbankno();
    }

    /**
     * 银行卡号关联的 卡bin信息
     *
     * @param cardNo 银行卡号
     * @return
     */
    public CardBinInfo getCardBinInfo(String cardNo) {
        CardBinInfo cardBinInfo = existsRedisCardBinInfo(cardNo);
        if (cardBinInfo != null) {
            return cardBinInfo;
        }
        List<CardBinInfo> list = queryCardBinInfo(cardNo);
        if (CollectionUtils.isEmpty(list)) {
            log.error("查无此卡号:{} --> 关联的卡bin信息", cardNo);
            return null;
        }
        if (list.size() > 1) {
            log.warn("查此卡号:{} --> 关联的卡bin信息有多条.记录集：{}", cardNo, JSON.toJSONString(list));
        }
        cardBinInfo = list.get(0);
        setRedisCardBinInfo(cardNo, cardBinInfo);
        return cardBinInfo;
    }

    private String fmtCardNoKey(String cardNo){
        return RedisKey.COMMON.fmtKey("cardBinInfo",cardNo);
    }

    /**
     * 默认缓存12小时
     */
    private void setRedisCardBinInfo(String cardNo, CardBinInfo cardBinInfo) {
        try {
            if (cardBinInfo != null) {
                redisTemplate.boundValueOps(fmtCardNoKey(cardNo)).set(cardBinInfo, 12, TimeUnit.HOURS);
            }
        } catch (Exception e) {
            log.error("缓存银行卡[{}]的卡bin信息异常:{}", cardNo, e.getMessage());
        }
    }

    private CardBinInfo existsRedisCardBinInfo(String cardNo) {
        if (StringUtil.isNotBlank(cardNo)) {
            String key = fmtCardNoKey(cardNo);
            if (redisTemplate.hasKey(key)) {
                CardBinInfo cardBinInfo = redisTemplate.boundValueOps(key).get();
                return Optional.ofNullable(cardBinInfo).orElseGet(()->null);
            }
        }
        return null;
    }


}
