package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.*;
import cn.kingnet.utp.trade.common.bo.AccountOperBo;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.InnerAccountTransferBo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月12日
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/account")
public interface IAccountHandler {


    /**
     * 差错处理及处理状态更新
     *
     * @param id                  差错表Id
     * @param reconciliationError 差错类型
     * @param transStatus         交易类型
     * @param transStatus         校正后交易状态
     * @param remark              备注说明
     * @param serverTransId       服务端交易流水号
     * @return
     */
    @PostMapping("/adjustAccount4SettleCheck")
    boolean adjustAccount4SettleCheck(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "reconciliationError") String reconciliationError,
            @RequestParam(value = "tradeType") String tradeType,
            @RequestParam(value = "transStatus") String transStatus,
            @RequestParam(value = "remark") String remark,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "needUpdateTransFlow") boolean needUpdateTransFlow);


    /**=========================================V2=========================================================*/

    /**
     * V2 通过资金账户和上送用户号获取平台虚拟账户
     * 20191128：调整统一实体账户下：唯一标志objCode一一对应一个虚账户
     *
     * @param fundAccount
     * @return
     */
    @GetMapping("/find/open/account")
    Account findAccount(@RequestParam(value = "fundAccount") String fundAccount,
                        @RequestParam("objCode") String objCode);


    /**
     * V2 创建虚拟账户
     *
     * @param openAccountBo
     * @return
     */
    @PostMapping("/create/open/account")
    Account openAccount(@RequestBody OpenAccountBo openAccountBo);

    /**
     * V2 销户 虚拟账户
     *
     * @param userAccount
     * @return
     */
    @PostMapping("/create/cancel/account")
    int cancelAccount(@RequestParam(value = "userAccount") String userAccount);

    /**
     * V2 查找资金账户信息
     *
     * @param fundAccount
     * @return
     */
    @GetMapping("/find/fund")
    FundAccount findFundAccount(@RequestParam(value = "fundAccount") String fundAccount);

    /**
     * V2 查询代付客户信息
     *
     * @param code
     * @return
     */
    @GetMapping("/find/industry")
    Industry findIndustry(@RequestParam(value = "code") String code);

    /**
     * V2 查询代付客户信息(包含图片信息)
     * @param account
     * @return
     */
    @GetMapping("/find/industry/all")
    Industry findIndustryAll(@RequestParam(value = "account") String account);

    @GetMapping("/find/account/by/account")
    Account findAccount(@RequestParam(value = "userAccount") String userAccount);

    @GetMapping("/find/account/by/accountId")
    Account getAccount(@RequestParam(value = "accountId") String accountId);

    /**
     * 虚拟账号获取虚拟账户信息
     *
     * @param userAccount
     * @return
     */
    @GetMapping("/queryAccountByUserAccount")
    Account queryAccountByUserAccount(@RequestParam(value = "userAccount") String userAccount);


    /**
     * V2 查找商户账户信息
     *
     * @param account
     * @return
     */
    @GetMapping("/find/mer/info")
    MerchantInfo findMerchantByAccount(@RequestParam(value = "account") String account);

    /**
     * V2 查找商户账户信息(包含图片信息)
     *
     * @param account
     * @return
     */
    @GetMapping("/find/mer/info/all")
    MerchantInfo findMerchantByAccountAll(@RequestParam(value = "account") String account);

    /**
     * V2
     *
     * @param id
     * @return
     */
    @GetMapping("/find/mer/info/by/id")
    MerchantInfo findMerchantById(@RequestParam(value = "id") Long id);

    /**
     * V2 鉴权绑卡(已过期，详见：{@link #bindMerchantAndMerAcc})
     *
     * @param bindBo
     */
    @Deprecated
    @PostMapping("/bind/merAndMerAcc")
    void bind(@RequestBody BindBo bindBo);

    /**
     * V2 鉴权绑卡
     *
     * @param bindBo
     */
    @PostMapping("/bind/merchantAndMerAcc")
    void bindMerchantAndMerAcc(@RequestBody BindBo bindBo);

    @Deprecated
    @PostMapping("/re/bind/merAndMerAcc")
    void reBind(@RequestBody BindBo bindBo);

    @PostMapping("/un/bind/merAndMerAcc")
    void unBind(@RequestParam(value = "userAccount") String userAccount,
                @RequestParam(value = "acctNo", required = false) String acctNo);


    /**
     * 商户账户打款验证结果更新
     *
     * @param bindBo
     */
    @PostMapping("/authMerchantAccount")
    void authMerchantAccount(@RequestBody BindBo bindBo);

    /**
     * 入金操作
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/plusAccountBalance")
    boolean plusAccountBalance(@RequestBody AccountOperBo accountOperBo);

    /**
     * 临时内部调账入金操作，区别于不被外部同步
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/plusAccountBalanceInner")
    boolean plusAccountBalanceInner(@RequestBody AccountOperBo accountOperBo);

    /**
     * 冻结金额入金操作
     *
     * @return
     */
    @PostMapping("/plusAccountFreezenBalance")
    boolean plusAccountFreezenBalance(@RequestBody AccountOperBo accountOperBo);


    /**
     * 冻结金额
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/freezeAccountBalance")
    boolean freezeAccountBalance(@RequestBody AccountOperBo accountOperBo);

    /**
     * 解冻金额
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/unfreezeAccountBalance")
    boolean unfreezeAccountBalance(@RequestBody AccountOperBo accountOperBo);

    /**
     * 出金:可用余额中出金
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/minusAccountAvailBalance")
    boolean minusAccountAvailBalance(@RequestBody AccountOperBo accountOperBo);

    /**
     * 出金：冻结总金额中出金
     *
     * @param accountOperBo 账户操作对象
     * @return
     */
    @PostMapping("/minusAccountBalance")
    boolean minusAccountBalance(@RequestBody AccountOperBo accountOperBo);

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
    String createAccountNo(@RequestParam(value = "accountNum") String accountNum);

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
    List<AccountDetail> queryAccountDetail(@RequestParam(value = "account") String account,
                                           @RequestParam(value = "accountOperType", required = false) String accountOperType,
                                           @RequestParam(value = "startDate", required = false) String startDate,
                                           @RequestParam(value = "endDate", required = false) String endDate,
                                           @RequestParam(value = "peerAccNo", required = false) String peerAccNo)
    ;


    @PostMapping("/getAccountDetail4OrderIncome")
    AccountDetail getAccountDetail4OrderIncome(@RequestParam(value = "account") String account, @RequestParam(value = "orderId") String orderId);

    /**
     * 获取华通入金通知流水信息
     *
     * @param account 虚拟账号
     * @param orderId 华通核心业务流水号|即核心内部户同步中的主交易流水号SYS_REFERENCENO
     * @return
     */
    @PostMapping("/getChannelIncomeFlow")
    ChannelIncomeFlow getChannelIncomeFlow(@RequestParam(value = "account") String account, @RequestParam(value = "orderId") String orderId);


    /**
     * 查询平台账户及其下的用户账户的资金明细
     *
     * @param industryCode    代付客户号
     * @param accountOperType 账户操作类型 为空查询全部
     * @param startDate       起始日期 yyyyMMdd
     * @param endDate         终止日期 yyyyMMdd
     * @return
     */
    @PostMapping("/queryIndustryAccountDetail")
    List<AccountDetail> queryIndustryAccountDetail(@RequestParam(value = "industryCode") String industryCode,
                                                   @RequestParam(value = "accountOperType", required = false) String accountOperType,
                                                   @RequestParam(value = "startDate", required = false) String startDate,
                                                   @RequestParam(value = "endDate", required = false) String endDate);

    /**
     * 内部账户转账
     */
    @PostMapping("/transferAccountBalance")
    ServerResponseDTO transferAccountBalance(@RequestBody InnerAccountTransferBo innerAccountTransferBo);


    /**
     * 查询账户信息
     *
     * @return
     */
    @PostMapping("/findAccountByNo")
    Account findAccountByNo(@RequestParam(value = "accountNo") String accountNo);

    /**
     * 删除商户账户信息关联
     *
     * @return
     */
    @PostMapping("/deleteMerchantAccountInfo")
    void deleteMerchantAccountInfo(@RequestParam(value = "accountNo") String accountNo);

    /**
     * 获取平台支付关联信息
     *
     * @param industryCode
     * @return
     */
    @GetMapping("/getIndustryPayInfo")
    IndustryPayInfo getIndustryPayInfo(@RequestParam("industryCode") String industryCode);

    /**
     * 获取用户账户支付关联信息
     *
     * @param userAccount
     * @return
     */
    @GetMapping("/getUserPayInfo")
    UserPayInfo getUserPayInfo(@RequestParam("userAccount") String userAccount);

    /**
     * 余额支付
     */
    @PostMapping("/balancePayment")
    ServerResponseDTO balancePayment(@RequestBody InnerAccountTransferBo innerAccountTransferBo);

    /**
     * 余额支付退款
     */
    @PostMapping("/balancePaymentRefund")
    ServerResponseDTO balancePaymentRefund(@RequestBody InnerAccountTransferBo innerAccountTransferBo);

    /**
     * 余额支付Tn结算
     *
     * @param innerAccountTransferBo
     */
    @PostMapping("/balancePaymentTnSettle")
    void balancePaymentTnSettle(@RequestBody InnerAccountTransferBo innerAccountTransferBo);

    /**
     * 开户认证审核
     *
     * @param accountAuditBO
     */
    @PostMapping("/audit")
    void auditAccount(@RequestBody AccountAuditBO accountAuditBO);

    /**
     * 查询 客户号下所有子账户
     *
     * @param industryCode
     * @return
     */
    @PostMapping("queryUserAccountByIndustryCode")
    List<UserAccountInfo> queryUserAccountByIndustryCode(@RequestParam(value = "industryCode", required = false) String industryCode);

    /**
     * 通过子账户获取客户号信息
     *
     * @param subAccount
     * @return
     */
    @GetMapping("getIndustryBySubAccount")
    Industry getIndustryBySubAccount(@RequestParam("subAccount") String subAccount);

    /**
     * 通过功能账户获取客户号信息
     *
     * @param functionAccount
     * @return
     */
    @GetMapping("getIndustryByFunctionAccount")
    Industry getIndustryByFunctionAccount(@RequestParam("functionAccount") String functionAccount);

    /**
     * 平台账户列表查询
     *
     * @param industryCode
     * @return
     */
    @PostMapping("getIndustryAccountByCode")
    List<IndustryAccountBo> getIndustryAccountByCode(@RequestParam("industryCode") String industryCode);

}
