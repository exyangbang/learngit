package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.*;
import cn.kingnet.utp.service.persistence.mapper.AccountDetailMapper;
import cn.kingnet.utp.service.persistence.mapper.AccountMapper;
import cn.kingnet.utp.service.persistence.service.*;
import cn.kingnet.utp.service.persistence.support.VirtualAccountNoGenerate;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.InnerAccountTransferBo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月12日
 */
@RestController
@RequestMapping("/spi/persistence/account")
@Slf4j
public class AccountHandler extends DefaultFeginExceptionHandler implements IAccountHandler {

    @Resource
    InnerAccountService innerAccountService;

    @Resource
    VirtualAccountNoGenerate virtualAccountNoGenerate;

    @Resource
    ReconciliationErrorTypeService reconciliationErrorTypeService;

    @Resource
    IndustryService industryService;
    @Resource
    MerchantInfoService merchantInfoService;
    @Resource
    TransCurrentAndHistoryService transCurrentAndHistoryService;

    /**
     * 差错处理及处理状态更新
     *
     * @param id                  差错表Id
     * @param reconciliationError 差错类型
     * @param transStatus         交易类型
     * @param transStatus         校正后交易状态
     * @param remark              备注说明
     * @param serverTransId       服务端交易流水号
     * @param needUpdateTransFlow 是否需要更新交易流水
     * @return
     */
    @PostMapping("/adjustAccount4SettleCheck")
    @Override
    public boolean adjustAccount4SettleCheck(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "reconciliationError") String reconciliationError,
            @RequestParam(value = "tradeType") String tradeType,
            @RequestParam(value = "transStatus") String transStatus,
            @RequestParam(value = "remark") String remark,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "needUpdateTransFlow") boolean needUpdateTransFlow
    ) {
        log.info("[系统/人工]差错处理入参 >> 差错id:{} 差错类型:{} 交易类型:{} 变更后交易状态:{} 备注说明：{} 服务端流水号:{} 是否更新原流水状态:{}",
                id, reconciliationError, tradeType, transStatus, remark, serverTransId, needUpdateTransFlow);
        ReconciliationErrorType errorType = ReconciliationErrorType.resolve(reconciliationError);
        if (errorType == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("差错类型[%s]有误", reconciliationError));
        }
        TradeType tradeTypeObj = TradeType.resolve(tradeType);
        if (tradeTypeObj == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("交易类型[%s]有误", tradeType));
        }
        TransStatus transStatusObj = TransStatus.resolve(transStatus);
        if (transStatusObj != TransStatus.TRADE_SUCCESS && transStatusObj != TransStatus.TRADE_FAILURE) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("校正交易状态必须为明确成功或明确失败.当前为[%s]", transStatus));
        }
        reconciliationErrorTypeService.adjustAccount4SettleCheck(id, errorType, tradeTypeObj, transStatusObj, remark, serverTransId, needUpdateTransFlow);
        return true;

    }


    /**
     * =========================================V2=========================================================
     */


    @Override
    public Account findAccount(String fundAccount, String objCode) {
        Assert.hasText(fundAccount, () -> "资金账户不能为空");
        Assert.hasText(objCode, () -> "用户账号不能为空");
        return innerAccountService.getAccountByFundAccountAndObjCode(fundAccount, objCode);
    }

    @Override
    @Transactional
    public Account openAccount(@RequestBody OpenAccountBo openAccountBo) {
        return innerAccountService.openAccount(openAccountBo);
    }

    @Override
    public int cancelAccount(String userAccount) {
        return innerAccountService.cancelAccount(userAccount);
    }

    @Override
    public FundAccount findFundAccount(String fundAccount) {
        Assert.hasText(fundAccount, () -> "资金账户不能为空");
        PlusEntityWrapper<FundAccount> wrap = FundAccountCondition.builder().andBankAccountNoEq(fundAccount).build();
        return MybatisDaoImpl.run().selectOne(wrap);
    }

    @Override
    public Industry findIndustry(String code) {
        Assert.hasText(code, () -> "代付客户号不能为空");
        PlusEntityWrapper<Industry> wrap = IndustryCondition.builder().andCodeEq(code).build();
        return industryService.selectOne(wrap);
    }

    @Override
    public Industry findIndustryAll(String account) {
        Assert.hasText(account, () -> "代付客户号不能为空");
        return MybatisDaoImpl.run().selectOne(IndustryCondition.builder().andAccountEq(account).build());
    }

    @Override
    public Account findAccount(String userAccount) {
        Assert.hasText(userAccount, () -> "请求参数不规范");
        return MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(userAccount).build());
    }

    @Override
    public Account getAccount(String accountId) {
        Assert.hasText(accountId, () -> "请求参数[accountId]不能为空");
        return MybatisDaoImpl.run().selectById(Account.class, accountId);
    }

    @Override
    @GetMapping("/queryAccountByUserAccount")
    public Account queryAccountByUserAccount(@RequestParam(value = "userAccount") String userAccount) {
        return innerAccountService.getAccountByUserAccount(userAccount);
    }


    @Override
    public MerchantInfo findMerchantByAccount(String account) {
        Assert.hasText(account, () -> "虚拟账户号不能为空");
        return merchantInfoService.selectOne4AllNature(account);
    }

    @Override
    public MerchantInfo findMerchantByAccountAll(String account) {
        Assert.hasText(account, () -> "虚拟账户号不能为空");
        return MybatisDaoImpl.run().selectOne(MerchantInfoCondition.builder().andAccountEq(account).orSettleAccountEq(account).build());
    }

    @Override
    public MerchantInfo findMerchantById(Long id) {
        return MybatisDaoImpl.run().selectById(MerchantInfo.class, id);
    }

    @Override
    public void bind(@RequestBody BindBo bindBo) {
        innerAccountService.createOrUpdateMerAndMerAcc(bindBo.getMerchantInfo(), bindBo.getMerchantAccountInfo(), true);
    }

    @Override
    public void bindMerchantAndMerAcc(@RequestBody BindBo bindBo) {
        innerAccountService.bindMerchantAndMerAcc(bindBo.getMerchantInfo(), bindBo.getMerchantAccountInfo());
    }

    @Override
    public void reBind(@RequestBody BindBo bindBo) {
        innerAccountService.createOrUpdateMerAndMerAcc(bindBo.getMerchantInfo(), bindBo.getMerchantAccountInfo(), false);
    }

    @Override
    public void unBind(String userAccount, String acctNo) {
        innerAccountService.unBind(userAccount, acctNo);
    }

    /**
     * 商户账户打款验证结果更新
     *
     * @param bindBo
     */
    @Override
    public void authMerchantAccount(@RequestBody BindBo bindBo) {
        innerAccountService.authMerchantAccount(bindBo.getMerchantInfo(), bindBo.getMerchantAccountInfo());
    }

    /**
     * 入金操作
     *
     * @return
     */
    @PostMapping("/plusAccountBalance")
    @Override
    public boolean plusAccountBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "入金操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.plusBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;
    }

    /**
     * 临时内部调账入金操作，区别于不被外部同步
     *
     * @return
     */
    @PostMapping("/plusAccountBalanceInner")
    @Override
    public boolean plusAccountBalanceInner(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "内部调账入金操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.plusBalanceInner(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;
    }

    /**
     * 冻结金额入金操作
     *
     * @return
     */
    @PostMapping("/plusAccountFreezenBalance")
    @Override
    public boolean plusAccountFreezenBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "冻结金额入金操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.plusAccountFreezenBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;
    }


    /**
     * 冻结金额
     *
     * @return
     */
    @PostMapping("/freezeAccountBalance")
    @Override
    public boolean freezeAccountBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "冻结金额操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.freezeBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(),
                accountOperBo.getPeerAccNo(), accountOperBo.getRemark(), accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;
    }

    @PostMapping("/unfreezeAccountBalance")
    @Override
    public boolean unfreezeAccountBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "解冻金额操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.unfreezeBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(),
                accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;
    }

    /**
     * 出金：从可用余额出金操作
     *
     * @return
     */
    @PostMapping("/minusAccountAvailBalance")
    @Override
    public boolean minusAccountAvailBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "可用余额出金操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.minusAvailBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;

    }

    /**
     * 出金：从冻结总金额中扣减
     *
     * @return
     */
    @PostMapping("/minusAccountBalance")
    @Override
    public boolean minusAccountBalance(@RequestBody AccountOperBo accountOperBo) {
        LambdaLogger.debug(log, "扣减冻结金额操作 >> 账户操作数据:{}", JSON.toJSONString(accountOperBo));
        innerAccountService.minusBalance(accountOperBo.getAccountOperSubType(), accountOperBo.getUserAccount(), accountOperBo.getAmount(), accountOperBo.getPeerAccNo(), accountOperBo.getRemark(),
                accountOperBo.getServerTransId(), accountOperBo.getPeerAccName(), accountOperBo.getOutsideOrderId());
        return true;

    }

    /**
     * 虚拟账户命名规则
     * 总长度19位，说明如下：
     * 1、        910(3位，值固定)
     * 2、        平台编号(4位)
     * 3、        华通预留位(3位，默认填写101)
     * 4、        顺序号(9位)
     * 如：910 0001 101 000000001
     * 预付费卡的 910改为999.
     *
     * @return 虚拟账户编号
     */
    @GetMapping("/createAccountNo")
    @Override
    public String createAccountNo(@RequestParam(value = "accountNum") String accountNum) {
        return virtualAccountNoGenerate.createAccountNo();
    }

    /**
     * 查询虚账户的资金明细
     *
     * @param account         虚账户 个人或子商户 代付客户号+身份证、商户号
     * @param accountOperType 账户操作类型 为空查询全部
     * @param startDate       起始日期 yyyyMMdd
     * @param endDate         终止日期 yyyyMMdd
     * @return
     */
    @PostMapping("/queryAccountDetail")
    @Override
    public List<AccountDetail> queryAccountDetail(@RequestParam(value = "account") String account,
                                                  @RequestParam(value = "accountOperType", required = false) String accountOperType,
                                                  @RequestParam(value = "startDate", required = false) String startDate,
                                                  @RequestParam(value = "endDate", required = false) String endDate,
                                                  @RequestParam(value = "peerAccNo", required = false) String peerAccNo
    ) {

        if (StringUtil.isNotBlank(startDate)) {
            startDate = startDate + "000000";
        }
        if (StringUtil.isNotBlank(endDate)) {
            endDate = endDate + "235959";
        }
        AccountDetailCondition condition = AccountDetailCondition.builder();
        condition.andAccountEq(account);

        if (StringUtil.isNotBlank(accountOperType)) {
            condition.andOperateTypeEq(accountOperType);
        }
        if (StringUtil.isNotBlank(startDate) && StringUtil.isNotBlank(endDate)) {
            condition.andRecordTimeBetween(DateUtil.parseDate(startDate, DateUtil.FORMAT_DADETIME), DateUtil.parseDate(endDate, DateUtil.FORMAT_DADETIME));
        } else if (StringUtil.isNotBlank(startDate) && StringUtil.isBlank(endDate)) {
            condition.andRecordTimeGe(DateUtil.parseDate(startDate, DateUtil.FORMAT_DADETIME));
        } else if (StringUtil.isNotBlank(endDate) && StringUtil.isBlank(startDate)) {
            condition.andRecordTimeLe(DateUtil.parseDate(endDate, DateUtil.FORMAT_DADETIME));
        }
        if (StringUtil.isNotEmpty(peerAccNo)) {
            condition.andPeerAccNoEq(peerAccNo);
        }
        condition.orderDesc(" seq_no ");

        return MybatisDaoImpl.run().selectList(condition.build());

    }


    @PostMapping("/getAccountDetail4OrderIncome")
    @Override
    public AccountDetail getAccountDetail4OrderIncome(String account, String orderId) {
        return MybatisDaoImpl.run().selectOne(AccountDetailCondition.builder().andAccountEq(account).andOutsideOrderIdEq(orderId).build());
    }


    /**
     * 获取华通入金通知流水信息
     *
     * @param account 虚拟账号
     * @param orderId 华通核心业务流水号|即核心内部户同步中的主交易流水号SYS_REFERENCENO
     * @return
     */
    @PostMapping("/getChannelIncomeFlow")
    @Override
    public ChannelIncomeFlow getChannelIncomeFlow(@RequestParam(value = "account") String account, @RequestParam(value = "orderId") String orderId) {
        ChannelIncomeFlowCondition condition = ChannelIncomeFlowCondition.builder().andAccNoEq(account).andRidEq(orderId);
        return MybatisDaoImpl.run().selectOne(condition.build());
    }


    /**
     * 查询平台账户及其下的用户账户的资金明细
     * 20190401改为 仅能查询平台其下的用户账户资金明细
     *
     * @param industryCode    代付客户号
     * @param accountOperType 账户操作类型 为空查询全部
     * @param startDate       起始日期 yyyyMMdd
     * @param endDate         终止日期 yyyyMMdd
     * @return
     */
    @PostMapping("/queryIndustryAccountDetail")
    @Override
    public List<AccountDetail> queryIndustryAccountDetail(@RequestParam(value = "industryCode") String industryCode,
                                                          @RequestParam(value = "accountOperType", required = false) String accountOperType,
                                                          @RequestParam(value = "startDate", required = false) String startDate,
                                                          @RequestParam(value = "endDate", required = false) String endDate) {

        startDate = StringUtil.isEmpty(startDate) ? "19000101000000" : startDate + "000000";
        endDate = StringUtil.isEmpty(endDate) ? DateUtil.getFulltime() : endDate + "235959";

        Map<String, Object> param = Maps.newHashMap();
        param.put("startDate", DateUtil.parseDate(startDate, DateUtil.FORMAT_DADETIME));
        param.put("endDate", DateUtil.parseDate(endDate, DateUtil.FORMAT_DADETIME));
        param.put("operateType", accountOperType);
        param.put("industryCode", industryCode);

        List<AccountDetail> list = MybatisDaoImpl.of(AccountDetailMapper.class).selectListBySql("queryIndustryAccountDetail", param);

        if (!CollectionUtils.isEmpty(list)) {
            list = list.stream().sorted(Comparator.comparing(AccountDetail::getRecordTime)).collect(Collectors.toList());
        }
        return list;

    }

    /**
     * 内部账户转账
     */
    @PostMapping("/transferAccountBalance")
    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public ServerResponseDTO transferAccountBalance(@RequestBody InnerAccountTransferBo innerAccountTransferBo) {
        ServerResponseDTO serverResponseDTO = new ServerResponseDTO();
        try {
            if (StringUtil.isEmpty(innerAccountTransferBo.getIndustryCode())
                    || StringUtil.isEmpty(innerAccountTransferBo.getPayerAccount())
                    || StringUtil.isEmpty(innerAccountTransferBo.getPayeeAccount())
                    || innerAccountTransferBo.getAmount() == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "代付客户/付款账户/收款账户/转账金额 不能为空.");
            }
            if (innerAccountTransferBo.getAmount() <= 0) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "转账金额必须大于0");
            }

            if (innerAccountTransferBo.isFreezeFlag()) {
                LambdaLogger.debug(log, "已冻结金额转账操作： -> {}", JSON.toJSONString(innerAccountTransferBo));
                innerAccountService.minusBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
                innerAccountService.plusBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            } else {
                LambdaLogger.debug(log, "先冻结后转账操作 -> {}", JSON.toJSONString(innerAccountTransferBo));
                innerAccountService.freezeBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
                innerAccountService.minusBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
                innerAccountService.plusBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            }
            serverResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
            serverResponseDTO.setMessage("转账成功");
        } catch (Exception e) {
            LambdaLogger.error(log, "内部转账操作异常" + e.getMessage(), e);
            serverResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            serverResponseDTO.setMessage("转账异常：" + StringUtil.truncate(e.getMessage(), 200));
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "转账操作异常:" + StringUtil.truncate(e.getMessage(), 200), e);
        }
        return serverResponseDTO;
    }


    /**
     * 查询账户信息
     *
     * @param accountNo
     * @return
     */
    @Override
    public Account findAccountByNo(String accountNo) {
        Assert.hasText(accountNo, () -> "虚拟账户号不能为空");
        PlusEntityWrapper<Account> warp = AccountCondition.builder().andAccountEq(accountNo).build();
        return MybatisDaoImpl.run().selectOne(warp);
    }

    /**
     * 删除商户账户信息关联
     *
     * @param accountNo
     * @return
     */
    @Override
    public void deleteMerchantAccountInfo(String accountNo) {
        MybatisDaoImpl.run().delete(MerchantAccountInfoCondition.builder().andAccountEq(accountNo).build());
    }

    @Override
    public IndustryPayInfo getIndustryPayInfo(String industryCode) {
        return innerAccountService.getIndustryPayInfo(industryCode);
    }

    @Override
    public UserPayInfo getUserPayInfo(String userAccount) {
        return innerAccountService.getUserPayInfo(userAccount, false);
    }

    /**
     * 余额支付
     */
    @Override
    @PostMapping("/balancePayment")
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public ServerResponseDTO balancePayment(@RequestBody InnerAccountTransferBo innerAccountTransferBo) {
        ServerResponseDTO serverResponseDTO = new ServerResponseDTO();
        try {
            if (StringUtil.isEmpty(innerAccountTransferBo.getIndustryCode())
                    || StringUtil.isEmpty(innerAccountTransferBo.getPayerAccount())
                    || StringUtil.isEmpty(innerAccountTransferBo.getPayeeAccount())
                    || innerAccountTransferBo.getAmount() == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "代付客户/付款账户/收款账户/转账金额 不能为空.");
            }
            if (innerAccountTransferBo.getAmount() <= 0) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "转账金额必须大于0");
            }

            LambdaLogger.debug(log, "余额支付转账操作： -> {}", JSON.toJSONString(innerAccountTransferBo));
            innerAccountService.minusAvailBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
            if (0 == innerAccountTransferBo.getPeriod()) {
                innerAccountService.plusBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            } else { //非实时，资金入账到收款者 冻结金额 待另线程处理金额解冻
                innerAccountService.plusAccountFreezenBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            }
            serverResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
            serverResponseDTO.setMessage("余额支付成功");
        } catch (Exception e) {
            serverResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            serverResponseDTO.setMessage("余额支付异常：" + StringUtil.truncate(e.getMessage(), 200));
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "余额支付异常:" + StringUtil.truncate(e.getMessage(), 200), e);
        }
        return serverResponseDTO;
    }

    /**
     * 余额支付退款
     */
    @Override
    @PostMapping("/balancePaymentRefund")
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public ServerResponseDTO balancePaymentRefund(@RequestBody InnerAccountTransferBo innerAccountTransferBo) {
        Assert.isTrue(innerAccountTransferBo.getAmount() > 0, "退款金额必须大于0");
        Assert.isTrue(innerAccountTransferBo.getTransId() > 0, "原余额支付流水id不能为空");
        ServerResponseDTO serverResponseDTO = new ServerResponseDTO();
        try {
            LambdaLogger.debug(log, "余额支付退款操作： -> {}", JSON.toJSONString(innerAccountTransferBo));
            //已结算退款:退款者可用余额中退款
            if (innerAccountTransferBo.isPaymentSettleStatus()) {
                innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
            } else {//未结算退款：退款者冻结金额中退款
                innerAccountService.minusBalance(AccountOperSubType.REFUND, innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayeeAccountName(), innerAccountTransferBo.getOutsideOrderId());
            }
            //退款接受者：可用余额增加
            innerAccountService.plusBalance(AccountOperSubType.REFUND, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            //原交易余额支付 退款状态标识 已退款
            TransCurrent transCurrent = TransCurrent.builder().id(innerAccountTransferBo.getTransId()).refundStatus(CommonConstants.REFUND_STATUS_OK).gmtModified(new Date()).build();
            transCurrentAndHistoryService.updateCurrentOrHistoryById(transCurrent, innerAccountTransferBo.isHistoryStatus());
            serverResponseDTO.setStatus(HttpRespStatus.OK.valueStr());
            serverResponseDTO.setMessage("余额支付退款成功");
        } catch (Exception e) {
            serverResponseDTO.setStatus(HttpRespStatus.SERVER_ERROR.valueStr());
            serverResponseDTO.setMessage(StringUtil.truncate(e.getMessage(), 200));
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, StringUtil.truncate(e.getMessage(), 200), e);
        }
        return serverResponseDTO;
    }

    /**
     * 余额支付Tn结算
     *
     * @param innerAccountTransferBo
     */
    @PostMapping("/balancePaymentTnSettle")
    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void balancePaymentTnSettle(@RequestBody InnerAccountTransferBo innerAccountTransferBo) {
        if (innerAccountTransferBo.getAmount() <= 0) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "结算金额必须大于0");
        }
        if (0 != innerAccountTransferBo.getPeriod() && innerAccountTransferBo.getTransId() > 0) {
            //非实时，收款者原冻结金额入金 解冻
            innerAccountService.unfreezeBalance(AccountOperSubType.TRANSFER, innerAccountTransferBo.getPayeeAccount(), innerAccountTransferBo.getAmount(), innerAccountTransferBo.getPayerAccount(), innerAccountTransferBo.getRemark(), innerAccountTransferBo.getServerTransId(), innerAccountTransferBo.getPayerAccountName(), innerAccountTransferBo.getOutsideOrderId());
            MybatisDaoImpl.run().updateById(TransCurrent.builder().id(innerAccountTransferBo.getTransId()).paymentSettleStatus(CommonConstants.PAYMENT_SETTLE_STATUS_OK).build());
        }

    }

    /**
     * 开户认证审核
     *
     * @param accountAuditBO
     */
    @Override
    public void auditAccount(@RequestBody AccountAuditBO accountAuditBO) {
        ValidateUtils.notNull(accountAuditBO, "请求参数不规范");
        ValidateUtils.notNull(accountAuditBO.getMerchantInfo(), "商户信息不能为空!");
        ValidateUtils.hasText(accountAuditBO.getMerchantInfo().getAccount(), "虚拟账户");
        innerAccountService.updateMerchantInfo(accountAuditBO.getMerchantInfo());
    }

    @PostMapping("queryUserAccountByIndustryCode")
    @Override
    public List<UserAccountInfo> queryUserAccountByIndustryCode(String industryCode) {
        Assert.hasText(industryCode, () -> "参数 industryCode 不能为空");

        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("industryCode", industryCode);
        List<UserAccountInfo> reList = MybatisDaoImpl.of(AccountMapper.class).selectListBySql("queryUserAccountByIndustryCode", paramsMap);

        return reList;
    }

    /**
     * 通过子账户获取客户号信息
     *
     * @param subAccount
     * @return
     */
    @GetMapping("getIndustryBySubAccount")
    @Override
    public Industry getIndustryBySubAccount(@RequestParam("subAccount") String subAccount) {
        return industryService.getIndustryBySubAccount(subAccount);
    }

    /**
     * 通过子账户获取客户号信息
     *
     * @param industryCode
     * @return
     */
    @PostMapping("getIndustryAccountByCode")
    @Override
    public List<IndustryAccountBo> getIndustryAccountByCode(@RequestParam("industryCode") String industryCode) {
        List<IndustryAccountBo> list = Lists.newArrayList();
        Industry industry = MybatisDaoImpl.run().selectOne(IndustryCondition.builder().andCodeEq(industryCode).andIndustryTypeEq(VirtualAccountType.INDUSTRY.getType()).build());
        if (null == industry) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台账户信息异常");
        }
        // 1-平台账户
        IndustryAccountBo industryAccount = new IndustryAccountBo();
        industryAccount.setUserAccount(industry.getAccount());
        industryAccount.setAccType(VirtualAccountType.INDUSTRY.getType());
        list.add(industryAccount);
        // 5-手续费支出账户
        Long feeExpenditureAccountId = industry.getFeeExpenditureAccount();
        if (null != feeExpenditureAccountId) {
            Industry feeExpenditureAccount = MybatisDaoImpl.run().selectOne(IndustryCondition.builder().andIdEq(feeExpenditureAccountId).build());
            IndustryAccountBo industryFeeExpenditureAccount = new IndustryAccountBo();
            industryFeeExpenditureAccount.setUserAccount(feeExpenditureAccount.getAccount());
            industryFeeExpenditureAccount.setAccType(VirtualAccountType.FEEOUTCOME.getType());
            list.add(industryFeeExpenditureAccount);
        }
        // 10-小额打款支出账户
        Long authPaymentAccountId = industry.getAuthPaymentAccountId();
        if (null != authPaymentAccountId) {
            Industry authPaymentAccount = MybatisDaoImpl.run().selectOne(IndustryCondition.builder().andIdEq(authPaymentAccountId).build());
            IndustryAccountBo industryAuthPaymentAccount = new IndustryAccountBo();
            industryAuthPaymentAccount.setUserAccount(authPaymentAccount.getAccount());
            industryAuthPaymentAccount.setAccType(VirtualAccountType.AUTHOUTCOME.getType());
            list.add(industryAuthPaymentAccount);
        }
        return list;
    }

    /**
     * 通过功能账户获取客户号信息
     *
     * @param functionAccount
     * @return
     */
    @GetMapping("getIndustryByFunctionAccount")
    @Override
    public Industry getIndustryByFunctionAccount(@RequestParam("functionAccount") String functionAccount) {
        return industryService.getIndustryByFunctionAccount(functionAccount);
    }


}
