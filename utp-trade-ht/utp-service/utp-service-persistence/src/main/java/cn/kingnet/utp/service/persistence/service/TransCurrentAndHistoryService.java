package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.dao.SqlStatementOption;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.mapper.TransCurrentMapper;
import cn.kingnet.utp.service.persistence.mapper.TransHistoryMapper;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author WJH
 * @Date 2019/02/25
 */
@Service
@Slf4j
public class TransCurrentAndHistoryService {

    @Resource
    private TransCurrentMapper transCurrentMapper;
    @Resource
    private TransHistoryMapper transHistoryMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${cn.kingnet.utp.dSpecialReconFile}")
    private String dSpecialReconFile;

    @Value("${cn.kingnet.utp.subDailyBalanceFile}")
    private String subDailyBalanceFile;


    @PostConstruct
    public void init() {
        Assert.hasText(dSpecialReconFile, () -> "cn.kingnet.utp.dSpecialReconFile 未配置");
        Assert.hasText(subDailyBalanceFile, () -> "cn.kingnet.utp.subDailyBalanceFile 未配置");
    }

    private String buildD1SpecailReconFileName(String transDate, String industryCode) {
        return String.format("%s-%s.txt", transDate, industryCode);
    }

    private String buildSubBalanceReconFileName(String reconDate, String industryCode) {
        return String.format("%s-%s.txt", reconDate, industryCode);
    }

    private static String genRedisTransIdHashKey(String industryCode, String transId) {
        return RedisKey.fmtKey(RedisKey.TRANS_ID, industryCode, String.valueOf(Math.abs(transId.hashCode()) % 1000));
    }

    public void setRedisTransIdHashField(String industryCode, String clientTransId, String serverTransId) {
        if (StringUtil.isBlank(industryCode)) {
            return;
        }
        if (StringUtil.isNotBlank(clientTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, clientTransId)).putIfAbsent(clientTransId, serverTransId);
        }
        if (StringUtil.isNotBlank(serverTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, serverTransId)).putIfAbsent(serverTransId, clientTransId);
        }
    }

    private String getRedisTransIdHashField(String industryCode, String clientTransId, String serverTransId) {
        String transId = null;
        if (StringUtil.isNotBlank(industryCode)) {
            if (StringUtil.isNotBlank(clientTransId)) {
                transId = (String) redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, clientTransId)).get(clientTransId);
            } else if (StringUtil.isNotBlank(serverTransId)) {
                transId = (String) redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, serverTransId)).get(serverTransId);
            }
        }
        return transId;
    }

    public void delRedisClientTransIdAndServerTransId(String industryCode, String clientTransId, String serverTransId) {
        if (StringUtil.isBlank(industryCode)) {
            return;
        }
        if (StringUtil.isNotBlank(clientTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, clientTransId)).delete(clientTransId);
        }
        if (StringUtil.isNotBlank(serverTransId)) {
            redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, serverTransId)).delete(serverTransId);
        }
    }

    private boolean existsRedisClientTransId(String industryCode, String clientTransId) {
        return redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, clientTransId)).hasKey(clientTransId);
    }

    private boolean existsRedisServerTransId(String industryCode, String serverTransId) {
        return redisTemplate.boundHashOps(genRedisTransIdHashKey(industryCode, serverTransId)).hasKey(serverTransId);
    }

    /**
     * 加载存量交易流水id到redis todo 加载存量数据
     */
    public boolean loadStockTransId2Redis(String industryCode) {
        boolean tf = false;
        try {
            Assert.hasText(industryCode, () -> "参数 industryCode 不能为空");
            //每次加载1000条，加载当前表和历史表的 合集 selectIndustryTransId select industryCode,clientTransId,serverTransId from t
            Map<String, String> params = Maps.newHashMap();
            params.put("industryCode", industryCode);
            int count = selectCountIndustryCodeAndClientTransIdOrServerTransId(industryCode, null, null);
            Page page = new Page(1, 1000);
            page.setTotal(count);
            SqlStatementOption sqlStatementOption = MybatisDaoImpl.of(TransCurrentMapper.class);
            for (int cur = page.getCurrent(); cur <= page.getPages(); cur++) {
                //client_trans_id,t.server_trans_id
                List<Map<String, String>> list = sqlStatementOption.selectPageBySql("selectIndustryTransId", params, cur, page.getSize());
                if (list != null && !list.isEmpty()) {
                    for (Map<String, String> map : list) {
                        //待优化批量操作
                        setRedisTransIdHashField(industryCode, map.get("client_trans_id"), map.get("server_trans_id"));
                    }
                }
            }
            tf = true;
        } catch (Exception e) {
            log.error("加载客户号[{}]存量交易流水Id 到 redis缓存异常:{}", industryCode, e.getMessage(), e);
        }
        return tf;
    }

    public boolean isExistByIndustryCodeAndClientTransId(String industryCode, String clientTransId) {
        Assert.hasText(industryCode, () -> "平台客户号 参数不能为空");
        Assert.isTrue(StringUtil.isNotBlank(clientTransId), () -> "客户端流水不能为空");

        boolean exist = existsRedisClientTransId(industryCode, clientTransId);
        if (!exist) {
            exist = transCurrentMapper.selectCount(TransCurrentCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId).build()) > 0;
        }
        if (!exist) {
            exist = transHistoryMapper.selectCount(TransHistoryCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId).build()) > 0;
        }
        return exist;
    }

    public boolean existIndustryCodeAndClientTransIdOrServerTransId(String industryCode, String clientTransId, String serverTransId) {
        Assert.hasText(industryCode, () -> "平台客户号 参数不能为空");
        Assert.isTrue(StringUtil.isNotBlank(clientTransId) || StringUtil.isNotBlank(serverTransId), () -> "客户端流水与服务端流水不能同时为空");
        if (StringUtil.isNotBlank(clientTransId) && StringUtil.isNotBlank(serverTransId)) {
            String redisServerTransId = getRedisTransIdHashField(industryCode, clientTransId, null);
            if (serverTransId.equals(redisServerTransId)) {
                return true;
            }
        } else if (StringUtil.isNotBlank(clientTransId) && existsRedisClientTransId(industryCode, clientTransId)) {
            return true;
        } else if (StringUtil.isNotBlank(serverTransId) && existsRedisServerTransId(industryCode, serverTransId)) {
            return true;
        }
        int count = selectCountIndustryCodeAndClientTransIdOrServerTransId(industryCode, clientTransId, serverTransId);
        return count > 0;
    }

    private int selectCountIndustryCodeAndClientTransIdOrServerTransId(String industryCode, String clientTransId, String serverTransId) {
        Map<String, String> params = Maps.newHashMap();
        params.put("industryCode", industryCode);
        params.put("clientTransId", clientTransId);
        params.put("serverTransId", serverTransId);
        List<Integer> list = MybatisDaoImpl.of(TransCurrentMapper.class).selectListBySql("selectCountIndustryCodeAndClientTransIdOrServerTransId", params);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }


    public TransCurrent getByIndustryAndClientTransIdOrServerTransId(String industryCode, String clientTransId, String serverTransId) {
        TransCurrent transCurrent = null;
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台代码不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与服务端流水不能同时为空");
        }

        TransCurrentCondition condition = TransCurrentCondition.builder().andIndustryCodeEq(industryCode);
        if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(serverTransId)) {
            condition.andClientTransIdEq(clientTransId);
        } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
            condition.andServerTransIdEq(serverTransId);
        } else {
            condition.andClientTransIdEq(clientTransId).andServerTransIdEq(serverTransId);
        }
        transCurrent = MybatisDaoImpl.run().selectOne(condition.build());

        //查历史表
        if (transCurrent == null) {
            TransHistoryCondition conditionHistory = TransHistoryCondition.builder().andIndustryCodeEq(industryCode);
            if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(serverTransId)) {
                conditionHistory.andClientTransIdEq(clientTransId);
            } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
                conditionHistory.andServerTransIdEq(serverTransId);
            } else {
                conditionHistory.andClientTransIdEq(clientTransId).andServerTransIdEq(serverTransId);
            }
            TransHistory transHistory = MybatisDaoImpl.run().selectOne(conditionHistory.build());
            if (transHistory != null) {
                //兼容存量历史表该字段可能非1 该状态为1即为历史表中数据
                transHistory.setHistoryStatus(TrueOrFalseStatus.TRUE.value());
                transCurrent = new TransCurrent();
                BeanUtils.copyProperties(transHistory, transCurrent);
            }
        }
        //查交易参数失败记录表
        if (transCurrent == null) {
            TransParamFailCondition conditionHistory = TransParamFailCondition.builder().andIndustryCodeEq(industryCode);
            if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(serverTransId)) {
                conditionHistory.andClientTransIdEq(clientTransId);
            } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
                conditionHistory.andServerTransIdEq(serverTransId);
            } else {
                conditionHistory.andClientTransIdEq(clientTransId).andServerTransIdEq(serverTransId);
            }
            TransParamFail transParamFail = MybatisDaoImpl.run().selectOne(conditionHistory.build());
            if (transParamFail != null) {
                transCurrent = new TransCurrent();
                BeanUtils.copyProperties(transParamFail, transCurrent);
            }
        }
        return transCurrent;
    }

    public boolean existIndustryAndSuccessOrderId(String industryCode, String orderId) {
        TransCurrentCondition condition = TransCurrentCondition.builder().andIndustryCodeEq(industryCode).andOrderIdEq(orderId).andTransStatusEq(TransStatus.TRADE_SUCCESS.name());
        boolean exist = MybatisDaoImpl.run().selectCount(condition.build()) > 0;
        if (!exist) {
            TransHistoryCondition conditionHistory = TransHistoryCondition.builder().andIndustryCodeEq(industryCode).andOrderIdEq(orderId).andTransStatusEq(TransStatus.TRADE_SUCCESS.name());
            exist = MybatisDaoImpl.run().selectCount(conditionHistory.build()) > 0;
        }
        return exist;
    }

    public void updateCurrentOrHistoryById(TransCurrent transCurrent, boolean historyStatus) {
        Assert.notNull(transCurrent, "参数transCurrent 不能为空");
        Assert.isTrue(transCurrent.getId() != null && transCurrent.getId().longValue() > 0, "参数transCurrent.id 不能为空且大于0");
        if (historyStatus) {
            TransHistory transHistory = new TransHistory();
            BeanUtils.copyProperties(transCurrent, transHistory);
            MybatisDaoImpl.run().updateById(transHistory);
        } else {
            MybatisDaoImpl.run().updateById(transCurrent);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void insert(TransCurrent transCurrent) {
        MybatisDaoImpl.run().insert(transCurrent);
        this.setRedisTransIdHashField(transCurrent.getIndustryCode(), transCurrent.getClientTransId(), transCurrent.getServerTransId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(List<TransCurrent> transCurrentList) {
        MybatisDaoImpl.run().insertBatch(transCurrentList, 100);
        transCurrentList.stream().forEach(o -> {
            this.setRedisTransIdHashField(o.getIndustryCode(), o.getClientTransId(), o.getServerTransId());
        });
    }

    public boolean setSplitPaymentRedfund(String origClientTradeId) {
        String key = "SplitPaymentRedfund_" + origClientTradeId;
        boolean isSet = redisTemplate.opsForValue().setIfAbsent(key, System.currentTimeMillis() + 120000);
        if (isSet) {
            redisTemplate.expire(key, 2, TimeUnit.MINUTES);
        } else {
            long setTime = (Long) redisTemplate.opsForValue().get(key);
            if (setTime < System.currentTimeMillis()) {
                //没有设置过期时间,且时间已过
                redisTemplate.opsForValue().set(key, System.currentTimeMillis() + 120000, 2, TimeUnit.MINUTES);
                isSet = true;
            }
        }
        return isSet;
    }

    public boolean deleteSplitPaymentRedfund(String origClientTradeId) {
        String key = "SplitPaymentRedfund_" + origClientTradeId;
        return redisTemplate.delete(key);
    }

    public void updateRefundById(TransCurrent transCurrent, String historyStatus) {
        Assert.notNull(transCurrent, "参数transCurrent 不能为空");
        Assert.isTrue(transCurrent.getId() != null && transCurrent.getId().longValue() > 0, "参数transCurrent.id 不能为空且大于0");
        if (TrueOrFalseStatus.TRUE.value().equals(historyStatus)) {
            TransHistoryCondition transHistoryCondition = TransHistoryCondition.builder().andIdEq(transCurrent.getId());
            TransHistory transHistory = MybatisDaoImpl.run().selectOne(transHistoryCondition.build());
            Long refundAmount = transHistory.getRefundAmount() + transCurrent.getRefundAmount();
            if (refundAmount > transHistory.getTransAmount()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "总的退款金额不能超过分账金额");
            } else if (refundAmount.longValue() == transHistory.getTransAmount().longValue()) {
                transHistory.setRefundStatus(CommonConstants.REFUND_STATUS_OK);
            } else {
                transHistory.setRefundStatus(CommonConstants.REFUND_STATUS_PART_OK);
            }
            transHistory.setRefundAmount(refundAmount);
            transHistory.setGmtModified(new Date());
            MybatisDaoImpl.run().updateById(transHistory);
        } else {
            TransCurrentCondition transCurrentCondition = TransCurrentCondition.builder().andIdEq(transCurrent.getId());
            TransCurrent tc = MybatisDaoImpl.run().selectOne(transCurrentCondition.build());
            Long refundAmount = tc.getRefundAmount() + transCurrent.getRefundAmount();
            if (refundAmount > tc.getTransAmount()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "总的退款金额不能超过分账金额");
            } else if (refundAmount.longValue() == tc.getTransAmount().longValue()) {
                tc.setRefundStatus(CommonConstants.REFUND_STATUS_OK);
            } else {
                tc.setRefundStatus(CommonConstants.REFUND_STATUS_PART_OK);
            }
            tc.setRefundAmount(refundAmount);
            tc.setGmtModified(new Date());
            MybatisDaoImpl.run().updateById(tc);
        }

    }

    public void saveTransParamFail(TransParamFail transParamFail) {
        MybatisDaoImpl.run().insert(transParamFail);
        this.setRedisTransIdHashField(transParamFail.getIndustryCode(), transParamFail.getClientTransId(), transParamFail.getServerTransId());
    }

    /**
     *   4.5.13. D日对账文件下载(京东定制化)
     * @param industryCode
     * @param txDate
     * @return
     */
    public byte[] downloadIndustryD1SpecailReconFile(String industryCode, String txDate) {
        Path d1SpecialRootPath = Paths.get(dSpecialReconFile, txDate);
        if (!Files.exists(d1SpecialRootPath)) {
            throw new TradeException(HttpRespStatus.MULTIPLE_CHOICES, "未出D日对账文件");
        }
        Path D1ReconFilePath = Paths.get(dSpecialReconFile, txDate, buildD1SpecailReconFileName(txDate, industryCode));
        if (Files.notExists(D1ReconFilePath)) {
            throw new TradeException(HttpRespStatus.MULTIPLE_CHOICES, "未出D日对账文件");
        }
        try {
            return Files.readAllBytes(D1ReconFilePath);
        } catch (IOException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "读取D日对账文件失败:" + e.getMessage(), e);
        }

    }

    /**
     * 4.5.14. 子账户日终余额对账单下载(京东定制化)
     * @param industryCode
     * @param txDate
     * @return
     */
    public byte[] downloadIndustrySubAccountDailyBalanceFile(String industryCode, String txDate) {
        Path subDailyBalanceRootPath = Paths.get(subDailyBalanceFile, txDate);
        if (!Files.exists(subDailyBalanceRootPath)) {
            throw new TradeException(HttpRespStatus.MULTIPLE_CHOICES, "未出子账户余额对账文件");
        }
        Path balanceReconFilePath = Paths.get(subDailyBalanceFile, txDate, buildSubBalanceReconFileName(txDate, industryCode));
        if (Files.notExists(balanceReconFilePath)) {
            throw new TradeException(HttpRespStatus.MULTIPLE_CHOICES, "未出子账户余额对账文件");
        }
        try {
            return Files.readAllBytes(balanceReconFilePath);
        } catch (IOException e) {
            throw new TradeException(HttpRespStatus.SERVER_ERROR, "读取子账户余额对账文件失败:" + e.getMessage(), e);
        }

    }
}
