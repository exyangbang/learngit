package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.AccountDetail;
import cn.kingnet.utp.service.persistence.mapper.AccountDetailMapper;
import cn.kingnet.utp.service.persistence.mapper.AccountMapper;
import cn.kingnet.utp.service.persistence.mapper.IndustryMapper;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.VirtualAccountStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月10日
 */
@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountDetailMapper accountDetailMapper;


    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public Account buildAccountAndUpdateBalance(AccountOperType accountOperType, String userAccount, long amount, boolean isMinusFromAvailAmount) {
        long s = System.currentTimeMillis();
        Account account = buildAccount(accountOperType, userAccount, amount, isMinusFromAvailAmount);
        int uRows = MybatisDaoImpl.of(AccountMapper.class).updateBySql("updateBalance", BeanMap.create(account));
        log.info("===》线程：{} 耗时{}ms 更新记录数:{} 版本号:{} 账户:{} 操作：{} 金额：{}", Thread.currentThread().getName(), System.currentTimeMillis() - s, uRows, account.getVersion(), userAccount, accountOperType.getDesc(), amount);
        if (uRows == 1) {
            return account;
        }
        if (uRows < 1) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("账户%s >> 操作:%s 金额:%s 更新失败", userAccount, accountOperType.getDesc(), amount));
        }
        if (uRows > 1) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "数据有误：存在多个虚拟账户:" + userAccount);
        }
        return account;
    }


    /**
     * @param accountOperType        账户操作类型 accountOperType
     * @param userAccount            账号
     * @param amount                 发生金额
     * @param isMinusFromAvailAmount 是否直接从可用余额扣减
     */
    private Account buildAccount(AccountOperType accountOperType, String userAccount, long amount, boolean isMinusFromAvailAmount) {
        if (amount < 0) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "发生金额必须为正整数");
        }
        Map<String, String> paramMap = new HashMap<>(2);
        paramMap.put("account", userAccount);
        List<Account> accountList = MybatisDaoImpl.of(AccountMapper.class).selectListBySql("getCurAccountLock", paramMap);
        Account dbAccount = CollectionUtils.isEmpty(accountList) ? null : accountList.get(0);

        if (dbAccount == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此[%s]虚拟账户", userAccount));
        }
        if (VirtualAccountStatus.CANCEL.getType().equals(dbAccount.getStatus())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("该[%s]虚拟账户已销户", userAccount));
        }
        if (dbAccount.getBalance() == null) {
            dbAccount.setBalance(0L);
        }
        if (dbAccount.getFrozenAmount() == null) {
            dbAccount.setFrozenAmount(0L);
        }
        if (dbAccount.getAvailAmount() == null) {
            dbAccount.setAvailAmount(0L);
        }
        Account.AccountBuilder builder = Account.builder().account(dbAccount.getAccount())
                .id(dbAccount.getId()).version(dbAccount.getVersion()).gmtModified(new Date());

        switch (accountOperType) {
            case PLUS_BLANCE: {
                builder.availAmount(amount).frozenAmount(0L).balance(amount);
            }
            break;
            case PLUS_BLANCE_INNER: {
                builder.availAmount(amount).frozenAmount(0L).balance(amount);
            }
            break;
            case PLUS_FREEZEN_BLANCE: {
                builder.availAmount(0L).frozenAmount(amount).balance(amount);
            }
            break;
            case MINUS_BLANCE: {
                if (isMinusFromAvailAmount) {
                    if (dbAccount.getAvailAmount() < amount) {
                        throw new PersistenceException(HttpRespStatus.BALANCE_INSUFFICIENT, "可用余额小于出金金额，暂无法可用余额中出金");
                    }
                    builder.availAmount(-amount).frozenAmount(0L).balance(-amount);
                } else {
                    if (dbAccount.getFrozenAmount() < amount) {
                        throw new PersistenceException(HttpRespStatus.BALANCE_INSUFFICIENT, "冻结总金额小于出金金额，暂无法冻结余额中出金");
                    }
                    builder.availAmount(0L).frozenAmount(-amount).balance(-amount);
                }

            }
            break;
            case FREEZEN_BLANCE: {
                if (dbAccount.getAvailAmount() < amount) {
                    throw new PersistenceException(HttpRespStatus.BALANCE_INSUFFICIENT, "可用余额小于冻结资金金额，暂无法冻结资金");
                }
                builder.availAmount(-amount).frozenAmount(amount).balance(0L);
            }
            break;
            case UNFREEZEN_BLANCE: {
                if (dbAccount.getFrozenAmount() < amount) {
                    throw new PersistenceException(HttpRespStatus.BALANCE_INSUFFICIENT, "冻结总金额小于解冻资金金额，暂无法解冻资金");
                }
                builder.availAmount(amount).frozenAmount(-amount).balance(0L);
            }
            break;
            default: {
            }
        }
        return builder.build();

    }

    /**
     * 构建操作明细对象
     *
     * @param accountOperateType 操作类型
     * @param userAccount        内部账户号
     * @param amount             发生金额
     * @param payeeAccNo         对方账户
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     * @return
     */
    private AccountDetail buildAccountDetail(String userAccount, AccountOperType accountOperateType, AccountOperSubType accountOperSubType, long amount, String payeeAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        if (amount < 0) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "发生金额必须为正整数");
        }
        AccountDetail last = getAccountDetailLastTime(userAccount);
        long lastAfterBalance = last == null ? 0L : last.getAfterBalance();
        long lastSeqNo = last == null ? 0L : last.getSeqNo();
        AccountDetail.AccountDetailBuilder accountDetailBuilder = AccountDetail.builder()
                .id(IdGenerate.getId()).account(userAccount).remark(remark).peerAccNo(payeeAccNo)
                .operateType(accountOperateType.getCode()).operateSubType(accountOperSubType.getCode())
                .seqNo(lastSeqNo + 1).serverTransId(serverTransId).recordTime(new Date())
                .peerAccName(peerAccName).outsideOrderId(outsideOrderId);

        switch (accountOperateType) {
            case PLUS_BLANCE: {
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(amount + lastAfterBalance);
            }
            break;
            case PLUS_BLANCE_INNER: {
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(amount + lastAfterBalance);
            }
            break;
            case PLUS_FREEZEN_BLANCE: {
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(amount + lastAfterBalance);
            }
            break;
            case MINUS_BLANCE: {
                if (lastAfterBalance < amount) {
                    throw new PersistenceException(HttpRespStatus.NOT_ACCEPTABLE, "账户余额不足，暂无法余额扣减");
                }
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(lastAfterBalance - amount);
            }
            break;
            case FREEZEN_BLANCE: {
                if (lastAfterBalance < amount) {
                    throw new PersistenceException(HttpRespStatus.NOT_ACCEPTABLE, "账户余额不足，暂无法冻结资金");
                }
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(lastAfterBalance);
            }
            break;
            case UNFREEZEN_BLANCE: {
                if (lastAfterBalance < amount) {
                    throw new PersistenceException(HttpRespStatus.NOT_ACCEPTABLE, "账户余额不足，暂无法解冻冻结资金");
                }
                accountDetailBuilder.amount(amount).beforeBalance(lastAfterBalance).afterBalance(lastAfterBalance);
            }
            break;
            default: {
            }
        }

        return accountDetailBuilder.build();

    }


    /**
     * 新增账户操作明细
     *
     * @param userAccount
     * @param accountOperateType
     * @param amount
     * @param peerAccNo          对方账户
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void insertAccountDetail(String userAccount, AccountOperType accountOperateType, AccountOperSubType accountOperSubType, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        AccountDetail accountDetail = buildAccountDetail(userAccount, accountOperateType, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
        log.info("操作类型[{}:{}]-->account:{},seqNo:{},amount:{},payeeAccNo:{},remark:{},serverTransId{}"
                , accountOperateType.getDesc(), accountOperSubType.getDesc(), userAccount, accountDetail.getSeqNo(), amount, peerAccNo, remark, serverTransId);
        int num = accountDetailMapper.insert(accountDetail);
    }

    /**
     * 根据账户获取其最后一次操作记录
     *
     * @param userAccount
     * @return
     */
    private AccountDetail getAccountDetailLastTime(String userAccount) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("account", userAccount);
        List<AccountDetail> list = MybatisDaoImpl.of(AccountDetailMapper.class).selectListBySql("getAccountDetailLastSeqNo", params);
        AccountDetail accountDetail = CollectionUtils.isEmpty(list) ? null : list.get(0);
        return accountDetail;
    }

    public Account getBrokerageAccount(String industryCode) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("industryCode", industryCode);
        List<Account> brokerageAccountList = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("getIndustryBrokerageAccount", params);
        if (brokerageAccountList != null && brokerageAccountList.size() > 1) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("数据错误：客户号[%s]存在多个佣金账户",industryCode));
        }
        return CollectionUtils.isEmpty(brokerageAccountList) ? null : brokerageAccountList.get(0);
    }


}
