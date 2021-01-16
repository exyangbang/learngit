package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.OpenAccountBo;
import cn.kingnet.utp.service.persistence.mapper.IndustryMapper;
import cn.kingnet.utp.service.persistence.mapper.MerchantInfoMapper;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月10日
 */
@Service
@Slf4j
public class InnerAccountService {

    @Resource
    private TransCurrentAndHistoryService transCurrentAndHistoryService;
    @Resource
    private AccountService accountService;
    @Resource
    private ServerIdGenerate serverIdGenerate;

    @Resource
    private MerchantInfoService merchantInfoService;

    private Cache<String, UserPayInfo> userPayInfoCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();

    /**
     * T+0 单笔清算分账处理
     *
     * @param o 当前清算分账记录
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public SplitInfo processCurSplitInfo4T0(SplitInfo o, IndustryPayInfo industryPayInfo) {
        try {
            o.setGmtModified(new Date());
            //记账结算模式
            if (!SettleMode.CHARGE.getCode().equals(o.getSettleMode())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "结算方式非记账模式");
            }
            Account account = getAccountByUserAccount(o.getUserAccount());
            if (account == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户已销户");
            }
            boolean exist = transCurrentAndHistoryService.isExistByIndustryCodeAndClientTransId(o.getIndustryCode(), o.getClientTransId());
            if (exist) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水号已存在");
            }
            // 实时代付及实时记账先记账，T+n代付及记账，待T+n后处理
            if (o.getPeriod() == 0) {
                String industryAccount = industryPayInfo.getIndustryAccount();
                String industryAccName = industryPayInfo.getIndustryName();
                o.setServerTransId(serverIdGenerate.generateServerTransId());
                // 平台代付出金 及 用户打款入金
                minusAvailBalance(AccountOperSubType.PAYMENT, industryAccount, o.getAmount(), o.getUserAccount(),
                        String.format("代付客户号%s,清算日期%s,批次号%s,客户端流水号%s 的清分业务代付出金", o.getIndustryCode(), o.getSettleDate(), o.getBatchId(), o.getClientTransId()), o.getServerTransId(), account.getObjName(), o.getClientTransId());
                plusBalance(AccountOperSubType.INCOME, o.getUserAccount(), o.getAmount(), industryAccount,
                        String.format("代付客户号%s,清算日期%s,批次号%s,客户端流水号%s 的清分业务打款入金.", o.getIndustryCode(), o.getSettleDate(), o.getBatchId(), o.getClientTransId()), o.getServerTransId(), industryAccName, o.getClientTransId());
                o.setStatus(SplitStatus.SPLIT_OK.getStatus());
                o.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                o.setTransDesc("虚账户已记账,待客户自行提现");
                //放置外部统一处理（参数校验失败情况也需落库）：失败或成功都需要落库
//                createIndustry2UserTransFlow(industryPayInfo, o);
            } else {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "账期只能为0");
            }
        } catch (Exception e) {
            o.setTransDesc("账户记账失败:" + StringUtil.truncate(e.getMessage(), 200));
            o.setTransStatus(TransStatus.TRADE_FAILURE.name());
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("客户端流水[%s]:%s", o.getClientTransId(), o.getTransDesc()));
        }
        return o;
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<SplitInfo> batchProcessSplitInfo4T0(List<SplitInfo> splitInfoList, IndustryPayInfo industryPayInfo) {
        try {
            splitInfoList.forEach(splitInfo -> {
                this.processCurSplitInfo4T0(splitInfo, industryPayInfo);
            });
            return splitInfoList;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * T+1 单笔清算分账记录处理
     *
     * @param o 当前T+1 清算分账记录
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public SplitInfo processCurSplitInfo4TN(SplitInfo o) {
        IndustryPayInfo industryPayInfo = null;
        try {
            o.setGmtModified(new Date());
            industryPayInfo = getIndustryPayInfo(o.getIndustryCode());
            if (industryPayInfo == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户号关联信息为空");
            }
            //记账结算模式
            if (!SettleMode.CHARGE.getCode().equals(o.getSettleMode())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "结算方式非记账模式");
            }
            Account account = getAccountByUserAccount(o.getUserAccount());
            if (account == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户不存在");
            }
            if (VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户已销户");
            }
            boolean exist = transCurrentAndHistoryService.isExistByIndustryCodeAndClientTransId(o.getIndustryCode(), o.getClientTransId());
            if (exist) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水号已存在");
            }
            if (o.getPeriod() != 0) {
                o.setServerTransId(serverIdGenerate.generateServerTransId());
                String industryAccount = industryPayInfo.getIndustryAccount();
                String industryAccName = industryPayInfo.getIndustryName();
                minusAvailBalance(AccountOperSubType.PAYMENT, industryAccount, o.getAmount(), o.getUserAccount(),
                        String.format("代付客户号%s,清算日期%s,批次号%s,客户端流水号%s 的清分业务Tn代付出金", o.getIndustryCode(), o.getSettleDate(), o.getBatchId(), o.getClientTransId()), o.getServerTransId(), account.getObjName(), o.getClientTransId());
                plusBalance(AccountOperSubType.INCOME, o.getUserAccount(), o.getAmount(), industryAccount,
                        String.format("代付客户号%s,清算日期%s,批次号%s,客户端流水号%s 的清分业务Tn打款入金.", o.getIndustryCode(), o.getSettleDate(), o.getBatchId(), o.getClientTransId()), o.getServerTransId(), industryAccName, o.getClientTransId());
                o.setStatus(SplitStatus.SPLIT_OK.getStatus());
                o.setTransStatus(TransStatus.TRADE_SUCCESS.name());
                o.setTransDesc("Tn虚账户已记账,待客户自行提现");
            }
        } catch (Exception e) {
            o.setTransStatus(TransStatus.TRADE_FAILURE.name());
            o.setTransDesc("Tn虚账户记账失败:" + StringUtil.truncate(e.getMessage(), 200));
            log.error("代付客户号{},清算日期{},批次号{},虚账户{},客户端流水号{} 的清分业务Tn账户记账异常:{}", o.getIndustryCode(), o.getSettleDate(), o.getBatchId(), o.getUserAccount(), o.getClientTransId(), e.getMessage(), e);
        } finally {
            MybatisDaoImpl.run().updateById(o);
            TransCurrent transCurrent = this.buildTransCurrent(o.getIndustryCode(), industryPayInfo, o);
            MybatisDaoImpl.run().insert(transCurrent);
        }
        return o;

    }


    /**
     * 兼容 退汇|预付费卡，暂未删除
     *
     * @param account
     * @param ammount
     * @param serverTransId
     * @param operEnum
     * @return
     */
    public boolean isExistAccountDetail(String account, long ammount, String serverTransId, AccountOperType operEnum) {
        if (StringUtil.isNotEmpty(serverTransId)) {
            int count = MybatisDaoImpl.run().selectCount(AccountDetailCondition.builder().andAccountEq(account)
                    .andAmountEq(ammount).andServerTransIdEq(serverTransId).andOperateTypeEq(operEnum.getCode()).build());
            boolean exists = count > 0 ? true : false;
            if (exists) {
                log.warn("流水号:{} >> 资金操作:{}-[{}],虚拟账号:{},发生金额:{} 已存在.", serverTransId, operEnum.getCode(), operEnum.getDesc(), account, ammount);
            }
            return exists;
        }
        return false;
    }

    /**
     * 是否已存在该操作类型的资金明细记录
     *
     * @param account                  虚拟账户号 资金账号编码4位+8位序列+2位随机码
     * @param ammount
     * @param serverTransId
     * @param operEnum                 资金操作枚举
     * @param feeAmtEqualsTransRealAmt 内扣情况：手续费和发生金额是否相等，相等情况（记录数>1）校验为存在
     * @return
     */
    private boolean isExistAccountDetail(String account, long ammount, String serverTransId, AccountOperType operEnum, boolean feeAmtEqualsTransRealAmt) {
        int count = existAccountDetailCount(account, ammount, serverTransId, operEnum);
        boolean exists;
        if (feeAmtEqualsTransRealAmt) {
            exists = count > 1 ? true : false;
        } else {
            exists = count > 0 ? true : false;
        }
        if (exists) {
            log.debug("流水号:{} >> 资金操作:{}-[{}],虚拟账号:{},发生金额:{} 已存在.", serverTransId, operEnum.getCode(), operEnum.getDesc(), account, ammount);
        }
        return exists;
    }

    private int existAccountDetailCount(String account, long ammount, String serverTransId, AccountOperType operEnum) {
        if (StringUtil.isNotEmpty(serverTransId)) {
            int count = MybatisDaoImpl.run().selectCount(AccountDetailCondition.builder().andAccountEq(account)
                    .andAmountEq(ammount).andServerTransIdEq(serverTransId).andOperateTypeEq(operEnum.getCode()).build());
            return count;
        }
        return 0;
    }

    /**
     * 是否存在资金入金明细
     **/
    public boolean isExistAccountDetail4Plus(String account, long ammount, String serverTransId) {
        return isExistAccountDetail4Plus(account, ammount, serverTransId, false);
    }

    public boolean isExistAccountDetail4Plus(String account, long ammount, String serverTransId, boolean feeAmtEqualsTransRealAmt) {
        return isExistAccountDetail(account, ammount, serverTransId, AccountOperType.PLUS_BLANCE, feeAmtEqualsTransRealAmt);
    }

    /**
     * 是否存资金冻结明细
     **/
    public boolean isExistAccountDetail4Freezen(String account, long ammount, String serverTransId) {
        return isExistAccountDetail4Freezen(account, ammount, serverTransId, false);
    }

    public boolean isExistAccountDetail4Freezen(String account, long ammount, String serverTransId, boolean feeAmtEqualsTransRealAmt) {
        return isExistAccountDetail(account, ammount, serverTransId, AccountOperType.FREEZEN_BLANCE, feeAmtEqualsTransRealAmt);
    }

    /**
     * 是否存资金解冻明细
     **/
    public boolean isExistAccountDetail4Unfreezen(String account, long ammount, String serverTransId) {
        return isExistAccountDetail4Unfreezen(account, ammount, serverTransId, false);
    }

    public boolean isExistAccountDetail4Unfreezen(String account, long ammount, String serverTransId, boolean feeAmtEqualsTransRealAmt) {
        return isExistAccountDetail(account, ammount, serverTransId, AccountOperType.UNFREEZEN_BLANCE, feeAmtEqualsTransRealAmt);
    }

    /**
     * 是否存资金冻结金额中扣减明细
     **/
    public boolean isExistAccountDetail4Minus(String account, long ammount, String serverTransId) {
        return isExistAccountDetail4Minus(account, ammount, serverTransId, false);
    }

    public boolean isExistAccountDetail4Minus(String account, long ammount, String serverTransId, boolean feeAmtEqualsTransRealAmt) {
        return isExistAccountDetail(account, ammount, serverTransId, AccountOperType.MINUS_BLANCE, feeAmtEqualsTransRealAmt);
    }


    /**
     * =========================================V2=========================================================
     */

    /**
     * 用户类型查询 账户对象
     *
     * @param fundAccount
     * @param objCode
     * @return
     */
    public Account getAccountByFundAccountAndObjCode(String fundAccount, String objCode) {
        AccountCondition condition = AccountCondition.builder().andFundAccountEq(fundAccount).andObjCodeEq(objCode);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }

    /**
     * 虚拟账号获取虚账账户信息
     *
     * @param userAccount 虚拟账号
     * @return
     */
    public Account getAccountByUserAccount(String userAccount) {
        return MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(userAccount).build());
    }

    /**
     * 虚拟账户 入金操作
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void plusBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.PLUS_BLANCE, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.PLUS_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void plusBalanceInner(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.PLUS_BLANCE_INNER, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.PLUS_BLANCE_INNER, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    /**
     * 虚拟账户 冻结金额入金操作
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void plusAccountFreezenBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.PLUS_FREEZEN_BLANCE, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.PLUS_FREEZEN_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    /**
     * 虚拟账户 冻结总余额出金操作
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void minusBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.MINUS_BLANCE, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.MINUS_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    /**
     * 虚拟账户 可用金额出金操作
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void minusAvailBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.MINUS_BLANCE, userAccount, amount, true);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.MINUS_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    /**
     * 虚拟账户 冻结金额
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void freezeBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.FREEZEN_BLANCE, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.FREEZEN_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    /**
     * 虚拟账户 解冻金额
     *
     * @param accountOperSubType 账户操作子类型
     * @param userAccount        账户账号
     * @param amount             发生金额
     * @param peerAccNo          对方账号
     * @param remark             备注说明
     * @param serverTransId      服务端交易流水号
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void unfreezeBalance(AccountOperSubType accountOperSubType, String userAccount, long amount, String peerAccNo, String remark, String serverTransId, String peerAccName, String outsideOrderId) {
        Account account = accountService.buildAccountAndUpdateBalance(AccountOperType.UNFREEZEN_BLANCE, userAccount, amount, false);
        accountService.insertAccountDetail(account.getAccount(), AccountOperType.UNFREEZEN_BLANCE, accountOperSubType, amount, peerAccNo, remark, serverTransId, peerAccName, outsideOrderId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createOrUpdateMerAndMerAcc(MerchantInfo merchantInfo, MerchantAccountInfo merchantAccountInfo, boolean isNew) {
        MybatisDaoImpl.run().update(merchantInfo, AccountCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).build());
        MybatisDaoImpl.run().insert(merchantAccountInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void bindMerchantAndMerAcc(MerchantInfo merchantInfo, MerchantAccountInfo merchantAccountInfo) {
        MybatisDaoImpl.run().update(merchantInfo, AccountCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).build());
        Integer count = MybatisDaoImpl.run().selectCount(MerchantAccountInfoCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).andAccountNoEq(merchantAccountInfo.getAccountNo()).build());
        //卡号不存在，则新增
        if (count == 0) {
            MybatisDaoImpl.run().insert(merchantAccountInfo);
        } else {
            MybatisDaoImpl.run().update(merchantAccountInfo, MerchantAccountInfoCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).andAccountNoEq(merchantAccountInfo.getAccountNo()).build());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void authMerchantAccount(MerchantInfo merchantInfo, MerchantAccountInfo merchantAccountInfo) {
        if (merchantInfo != null) {
            MybatisDaoImpl.run().update(merchantInfo, AccountCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).build());
        }
        MybatisDaoImpl.run().update(merchantAccountInfo, MerchantAccountInfoCondition.builder()
                .andAccountEq(merchantAccountInfo.getAccount()).andAccountNoEq(merchantAccountInfo.getAccountNo()).build());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateMerchantInfo(MerchantInfo merchantInfo) {
        String account = merchantInfo.getAccount();
        merchantInfo.setAccount(null);
        MybatisDaoImpl.run().update(merchantInfo, AccountCondition.builder().andAccountEq(account).build());
    }

    @Transactional(rollbackFor = Exception.class)
    public Account openAccount(OpenAccountBo openAccountBo) {
        Account account = openAccountBo.getAccount();
        MerchantInfo merchantInfo = openAccountBo.getMerchantInfo();
        AccountInfo accountInfo = openAccountBo.getAccountInfo();
        Boolean updateFlag = openAccountBo.getUpdateFlag();
        if (updateFlag == null || !updateFlag.booleanValue()) {
            account.setGmtCreate(new Date());
            account.setBalance(0L);
            account.setFrozenAmount(0L);
            account.setAvailAmount(0L);
            account.setStatus(VirtualAccountStatus.NORMAL.getType());
            account.setVersion(0L);
            MybatisDaoImpl.run().insert(account);
            MybatisDaoImpl.run().insert(merchantInfo);
            if (accountInfo != null) {
                MybatisDaoImpl.run().insert(accountInfo);
            }
        } else {//更新
            MybatisDaoImpl.run().update(account, AccountCondition.builder().andAccountEq(account.getAccount()).andStatusNe(AccountStatus.CANCEL).build());
            MybatisDaoImpl.run().updateById(merchantInfo);
            if (accountInfo != null) {
                MybatisDaoImpl.run().update(accountInfo, AccountInfoCondition.builder().andAccountEq(accountInfo.getAccount()).build());
            }
        }
        return account;
    }

    @Transactional(rollbackFor = Exception.class)
    public void unBind(String userAccount, String acctNo) {
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        if (null != merchantInfo) {
            //支持绑定多张卡
            if (StringUtil.isNoneBlank(acctNo)) {
                MybatisDaoImpl.run().update(MerchantAccountInfo.builder().bindStatus(BindCardStatus.UN_BIND.getStatus()).gmtModified(new Date()).build(), MerchantAccountInfoCondition.builder().andAccountEq(userAccount).andAccountNoEq(acctNo).build());
                //对于绑定多张卡的，需要判断所有卡解绑成功后，账户状态就变更为2-已开户未绑卡
                Integer count = merchantInfoService.getUnBindMerchantAccountCount(userAccount);
                if (count == 0) {
                    unBindMerchantInfo(merchantInfo, userAccount);
                }
            } else {
                unBindMerchantInfo(merchantInfo, userAccount);
                MybatisDaoImpl.run().update(MerchantAccountInfo.builder().bindStatus(BindCardStatus.UN_BIND.getStatus()).gmtModified(new Date()).build(), MerchantAccountInfoCondition.builder().andAccountEq(userAccount).build());
            }
        } else {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此账户[%s]", userAccount));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public int cancelAccount(String userAccount) {
        MybatisDaoImpl.run().update(Account.builder().status(VirtualAccountStatus.CANCEL.getType()).bankClientStatus(BankClientStatus.CANCELED_UNREPORTED.getStatus()).build(), AccountCondition.builder().andAccountEq(userAccount).build());
        return MybatisDaoImpl.run().update(MerchantInfo.builder().status(AccountStatus.CANCEL.getCode().toString()).build(), MerchantInfoCondition.builder().andAccountEq(userAccount).build());
    }

    /**
     * 账户状态就变更为2-已开户未绑卡
     *
     * @param merchantInfo
     */
    private void unBindMerchantInfo(MerchantInfo merchantInfo, String userAccount) {
        if (VirtualAccountType.SELFEMPLOYED.getType().equals(merchantInfo.getNature())) {//个体工商户
            MybatisDaoImpl.run().update(MerchantInfo.builder().status(AccountStatus.OPEN_UNBIND.getCode().toString()).build(), MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        } else if (UserType.ONE.getType().equals(merchantInfo.getUserType())) {//个人账户
            MybatisDaoImpl.run().update(MerchantInfo.builder().status(AccountStatus.OPEN_UNBIND.getCode().toString()).build(), MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        } else {
            MybatisDaoImpl.run().update(MerchantInfo.builder().status(AccountStatus.OPEN_UNBIND.getCode().toString()).build(), MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        }

    }

    public IndustryPayInfo getIndustryPayInfo(String industryCode) {
        Map<String, String> params = new HashMap<>(4);
        params.put("industryCode", industryCode);
        List<IndustryPayInfo> list = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("getIndustryPayInfo", params);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public UserPayInfo getUserPayInfo(String userAccount, boolean cacheAble) {
        Assert.hasText(userAccount, "参数userAccount不能为空");
        UserPayInfo userPayInfo = null;
        try {
            if(cacheAble) {
                userPayInfo = userPayInfoCache.get(userAccount, () -> this.getUserPayInfo(userAccount));
            }else{
                userPayInfo = this.getUserPayInfo(userAccount);
            }
        } catch (ExecutionException e) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查询子账户支付信息异常:" + e.getMessage());
        }
        return userPayInfo;
    }

    private UserPayInfo getUserPayInfo(String userAccount) {
        Map<String, String> params = new HashMap<>(4);
        params.put("userAccount", userAccount);
        List<UserPayInfo> list = MybatisDaoImpl.of(MerchantInfoMapper.class).selectListBySql("getUserPayInfo", params);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public TransCurrent buildTransCurrent(String industryCode, IndustryPayInfo industryPayInfo, SplitInfo splitInfo) {
        if (industryPayInfo == null) {
            industryPayInfo = new IndustryPayInfo();
            industryPayInfo.setIndustryCode(industryCode);
        }
        UserPayInfo userPayInfo = this.getUserPayInfo(splitInfo.getUserAccount(),true);
        if (userPayInfo == null) {
            userPayInfo = new UserPayInfo();
        }
        String transDate = DateUtil.getCurrentDate();
        String transTime = DateUtil.getCurrentTime();
        return TransCurrent.builder()
                .id(IdGenerate.getId())
                .channelKey(ChannelKey.HT_CKEY.getKey())
                .channelCode(String.format("%s%s", ChannelKey.HT_CKEY.getKey(), ProductNo.ACCOUNT.getNo()))
                .channelName(ChannelKey.HT_CKEY.getName())
                .clientTransId(splitInfo.getClientTransId())
                .clientTransTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .currency("CNY")
                .orgCode(industryPayInfo.getOrgCode())
                .orgName(industryPayInfo.getOrgName())
                .serverTransId(splitInfo.getServerTransId())
                .productCode(ProductCode.ACCOUNT.name())
                .tradeType(TradeType.SPLIT_PAYMENT.getCode())
                .transAmount(splitInfo.getAmount())
                .transCallbackUrl(null)
                .transDate(transDate)
                .transTime(transTime)
                .merNo(industryPayInfo.getIndustryAccount())
                .userCode(null)
                .accNo(industryPayInfo.getFundAccNo())
                .merFee(0L)
                .channelFee(0L)
                .realAmount(splitInfo.getAmount())
                .pcFlag(userPayInfo.getUserAccType())
                .userType(AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()) == null ? null : AccountType.getAccountTypeByCode(userPayInfo.getUserAccType()).getValue())
                .payerAcctNo(industryPayInfo.getFundAccNo())
                .payerName(industryPayInfo.getFundAccName())
                .payeeAcctNo(userPayInfo.getFundAccNo())
                .payeeName(userPayInfo.getFundAccName())
                .industryCode(industryPayInfo.getIndustryCode())
                .transStatus(splitInfo == null ? TransStatus.TRADE_FAILURE.name() : splitInfo.getTransStatus())
                .respMessage(splitInfo.getTransDesc())
                .reconcileStatus(CommonConstants.RECONCILE_STATUS_UNDO)
                .revokeStatus(CommonConstants.REVOKE_STATUS_UNDO)
                .refundStatus(CommonConstants.REFUND_STATUS_UNDO)
                .gmtCreate(DateUtil.getSystemDate())
                .gmtModified(DateUtil.getSystemDate())
                .merSettleType(SettleType.AFTER_NODE.getType())
                .merChargeMode(ChargeMode.BUCKLE.getMode())
                .channelSettleType(SettleType.AFTER_NODE.getType())
                .channelChargeMode(ChargeMode.BUCKLE.getMode())
                .payerAccount(industryPayInfo.getIndustryAccount())
                .payeeAccount(userPayInfo.getUserAccount())
                .feeAccount(industryPayInfo.getFeeOutAccount())
                .incomeAccount(industryPayInfo.getFeeInAccount())
                .needChannelReconcile(TrueOrFalseStatus.FALSE.value())
                .showPayerAccountNo(industryPayInfo.getIndustryAccount())
                .showPayerAccountName(industryPayInfo.getIndustryName())
                .showPayeeAccountNo(userPayInfo.getUserAccount())
                .showPayeeAccountName(userPayInfo.getUserName())
                .feeAccountName(industryPayInfo.getFeeOutName())
                .elcMakeFlag(ElcMakeFlag.NOT_MAKE.getFlag())
                .incomeAccountName(industryPayInfo.getFeeInName())
                .payerOpbkName(CommonConstants.payerOpbkName)
                .payeeOpbkName(CommonConstants.payerOpbkName)
                .description(splitInfo.getTransDesc())
                .summaryDescription("分账交易")
                .serverBatchNo(splitInfo.getBatchId())
                .splitInfoId(splitInfo.getId())
                .build();
    }

}
