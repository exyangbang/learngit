package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.enums.AccountType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 代付客户相关信息接口
 * @Author WJH
 * @Date 2019/02/26
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/industryHandler")
public interface IIndustryHandler {

    /**
     * 获取代付客户信息集合
     *
     * @param industryCode 代付客户号为空查全部，其他精确查找
     * @return
     */
    @GetMapping("/getIndustryByCode")
    Industry getIndustryByCode(@RequestParam("industryCode") String industryCode);

    /**
     * 获取所有代付客户信息集合
     *
     * @return
     */
    @GetMapping("/queryAllIndustryList")
    List<Industry> queryAllIndustryList();

    /**
     * 获取代付客户号配置来款账户集合
     *
     * @param industryCode
     * @return
     */
    @GetMapping("/queryIndustryAccountInfoListByIndustryCode")
    List<IndustryAccountInfo> queryIndustryAccountInfoListByIndustryCode(@RequestParam("industryCode") String industryCode);

    /**
     * 同步资金账户的当前余额
     *
     * @param fundAccount
     * @param accountBalance
     */
    @PostMapping("/syncFundAccountBalance")
    void syncFundAccountBalance(@RequestParam("fundAccount") String fundAccount, @RequestParam("accountBalance") Long accountBalance);

    /**
     * 获取代付客户号归属资金账户信息
     *
     * @param industryCode
     * @return
     */
    @GetMapping("/getFundAccountByIndustryCode")
    FundAccount getFundAccountByIndustryCode(@RequestParam("industryCode") String industryCode);

    /**
     * 验证客户号 限额 |当日 单笔(对公、对私、单位结算卡)
     *
     * @param industryCode 客户号
     * @param payeeAccType 对公|对私|单位结算卡 类型
     * @param transAmount  交易金额 单位分
     * @param transDate    交易日期 yyyyMMdd
     * @return
     */
    @PostMapping("/validIndustryLimitAmt")
    boolean validIndustryLimitAmt(@RequestParam("industryCode") String industryCode, @RequestBody(required = false) AccountType payeeAccType, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate);

    /**
     * 验证客户号子账户 限额 |当日&单笔限额
     *
     * @param industryCode 客户号
     * @param subAccount   子账户虚拟账号
     * @param transAmount  交易金额 单位分
     * @param transDate    交易日期 yyyyMMdd
     * @return
     */
    @PostMapping("/validSubAccountLimitAmt")
    boolean validSubAccountLimitAmt(@RequestParam("industryCode") String industryCode, @RequestParam("subAccount") String subAccount, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate);

    /**
     * 获取客户号 开通的 佣金账户信息
     *
     * @param industryCode
     * @return
     */
    @PostMapping("getIndustryBrokerageMerchantInfo")
    MerchantInfo getIndustryBrokerageMerchantInfo(@RequestParam("industryCode") String industryCode);

    /**
     * 校验同一平台下的同一用户连续相同提现金额次数限制
     * 校验同一平台下每分钟累计不超过数值限制
     *
     * @param industryCode
     * @param userAccount
     * @param transAmount
     * @return
     */
    @PostMapping("validCashMaxTranAmt")
    boolean validCashMaxTranAmt(@RequestParam("industryCode") String industryCode, @RequestParam("userAccount") String userAccount, @RequestParam("transAmount") long transAmount);

    /**
     * 相同证件的二级账户最大开立数量校验
     *
     * @param industryCode
     * @param idCode
     * @param subAccountOpenMax
     * @param nature
     * @return
     */
    @PostMapping("validSubAccountOpenMax")
    boolean validSubAccountOpenMax(@RequestParam("industryCode") String industryCode, @RequestParam("idCode") String idCode,
                                   @RequestParam("subAccountOpenMax") Integer subAccountOpenMax, @RequestParam("nature") String nature, @RequestParam("userType") String usertype);

    /**
     * 平台客户是否配置该来款账户名称
     *
     * @param industryCode
     * @param accountName
     * @return
     */
    @PostMapping("existsIndustryAccountInfo")
    boolean existsIndustryAccountInfo(@RequestParam("industryCode") String industryCode,@RequestParam("accountNo") String accountNo,  @RequestParam("accountName") String accountName);

    /**
     * 验证余额支付交易 客户号单日及子账户对公&对私单日限额
     *
     * @param industryCode 客户号
     * @param subAccount   子账户虚拟账号(对公|对私)
     * @param transAmount  交易金额 单位分
     * @param transDate    交易日期 yyyyMMdd
     * @return
     */
    @PostMapping("/validBalancePayLimitAmt")
    boolean validBalancePayLimitAmt(@RequestParam("industryCode") String industryCode, @RequestParam("subAccount") String subAccount, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate);

    /**
     * 余额支付交易成功后 累计客户号单日&子账户对公|对私单日累计交易额度
     *
     * @param industryCode 客户号
     * @param subAccount   子账户虚拟账号(对公|对私)
     * @param transAmount  交易金额 单位分
     * @param transDate    交易日期 yyyyMMdd
     * @return
     */
    @PostMapping("/accumulateBalancePayAmount")
    void accumulateBalancePayAmount(@RequestParam("industryCode") String industryCode, @RequestParam("subAccount") String subAccount, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate);

    /**
     *  查找平台客户开户信息 包含相关图片信息
     * @param industryCode
     * @param userAccount
     * @return
     */
    @PostMapping("/getMerchantInfoByUserAccount")
    MerchantInfo getMerchantInfoByUserAccount(@RequestParam("industryCode")String industryCode, @RequestParam("userAccount")String userAccount);
}
