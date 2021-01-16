package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.AccountOrderLog;
import cn.kingnet.utp.service.persistence.entity.AccountOrderLogCondition;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/16
 */
@Service
@Slf4j
public class AccountOrderLogService {

    public List<AccountOrderLog> queryAccountOrderLog(String account, String orderId) {
        AccountOrderLogCondition condition = AccountOrderLogCondition.builder().andAccountEq(account).andOrderIdEq(orderId);
        return MybatisDaoImpl.run().selectList(condition.build());
    }

    public AccountOrderLog getAccountOrderLog(String serverTransId) {
        AccountOrderLogCondition condition = AccountOrderLogCondition.builder().andServerTransIdEq(serverTransId);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveAccountOrderLog(AccountOrderLog accountOrderLog) {
        MybatisDaoImpl.run().insert(accountOrderLog);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateAccountOrderLog(AccountOrderLog accountOrderLog) {
        MybatisDaoImpl.run().updateById(accountOrderLog);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateByServerTransId(String serverTransId, TransStatus transStatus, String channelRespMsg) {
        AccountOrderLog accountOrderLog = MybatisDaoImpl.run().selectOne(AccountOrderLogCondition.builder().andServerTransIdEq(serverTransId).build());
        if (accountOrderLog != null) {
            accountOrderLog.setTransStatus(transStatus.name());
            accountOrderLog.setRespDesc(channelRespMsg);
            accountOrderLog.setGmtModified(new Date());
            updateAccountOrderLog(accountOrderLog);
        }
    }
}
