package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IIndustryHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.mapper.IndustryMapper;
import cn.kingnet.utp.service.persistence.service.*;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import static cn.kingnet.utp.trade.common.utils.MathUtil.formatAmt;

/**
 * @Description
 * @Author WJH
 * @Date 2019/02/26
 */
@RestController
@RequestMapping("/spi/persistence/industryHandler")
@Slf4j
public class IndustryHandler extends DefaultFeginExceptionHandler implements IIndustryHandler {

    @Resource
    private IndustryAmountLimitService industryAmountLimitService;
    @Resource
    private SubAccountAmountLimitService subAccountAmountLimitService;
    @Resource
    private AccountService accountService;
    @Resource
    private IndustryService industryService;
    @Resource
    private MerchantInfoService merchantInfoService;


    @GetMapping("/getIndustryByCode")
    @Override
    public Industry getIndustryByCode(String industryCode) {
        return industryService.selectOne(IndustryCondition.builder().andStatusEq(CommonConstants.STATUS_NORMAL).andCodeEq(industryCode).build());
    }

    @GetMapping("/queryAllIndustryList")
    @Override
    public List<Industry> queryAllIndustryList() {
        return industryService.selectList(IndustryCondition.builder().andStatusEq(CommonConstants.STATUS_NORMAL).build());
    }

    @GetMapping("/queryIndustryAccountInfoListByIndustryCode")
    @Override
    public List<IndustryAccountInfo> queryIndustryAccountInfoListByIndustryCode(@RequestParam("industryCode") String industryCode) {
        return MybatisDaoImpl.run().selectList(IndustryAccountInfoCondition.builder().andIndustryCodeEq(industryCode).build());
    }

    @PostMapping("/syncFundAccountBalance")
    @Override
    public void syncFundAccountBalance(@RequestParam("fundAccount") String fundAccount, @RequestParam("accountBalance") Long accountBalance) {
        MybatisDaoImpl.run().updateForSet(String.format("current_balance=%s,synchronization_time='%s'",
                accountBalance, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                FundAccountCondition.builder().andBankAccountNoEq(fundAccount).build());

    }

    /**
     * 获取代付客户号归属资金账户信息
     *
     * @param industryCode
     * @return
     */
    @GetMapping("/getFundAccountByIndustryCode")
    @Override
    public FundAccount getFundAccountByIndustryCode(@RequestParam("industryCode") String industryCode) {
        List<FundAccount> list = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("getFundAccountByIndustryCode", new HashMap<String, Object>(2) {{
            put("industryCode", industryCode);
        }});
        if (list == null || list.size() != 1) {
            throw new PersistenceException(HttpRespStatus.FORBIDDEN, "代付客户号关联资金账户不唯一");
        }
        return list.get(0);
    }

    @PostMapping("/validIndustryLimitAmt")
    @Override
    public boolean validIndustryLimitAmt(String industryCode, @RequestBody(required = false) AccountType payeeAccType, long transAmount, String transDate) {
        long dailyAvailableAmount = industryAmountLimitService.getIndustryDailyAvailableAmount(industryCode, transDate, 0L);
        //当日限额
        if (transAmount > dailyAvailableAmount) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]单日额度不足,当前剩余额度[%s元]", industryCode, formatAmt(dailyAvailableAmount)));
        }
        if (payeeAccType == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "收款方账户类型参数不能为空");
        }
        //单笔限额
        industryAmountLimitService.isOverLimitEachAmount(industryCode, transDate, payeeAccType, transAmount);
        return true;
    }

    @PostMapping("/validSubAccountLimitAmt")
    @Override
    public boolean validSubAccountLimitAmt(String industryCode, String subAccount, long transAmount, String transDate) {
        long dailyAvailableAmount = subAccountAmountLimitService.getSubAccountDailyAvailableAmount(industryCode, subAccount, transDate, 0L);
        //当日限额
        if (transAmount > dailyAvailableAmount) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]下子账户[%s]单日额度不足,当前剩余额度[%s元]", industryCode, subAccount, formatAmt(dailyAvailableAmount)));
        }
        //单笔限额
        if (subAccountAmountLimitService.isOverLimitEachAmount(industryCode, subAccount, transDate, transAmount)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]下子账户[%s]交易金额[%s元]超出单笔限额", industryCode, subAccount, formatAmt(transAmount)));
        }
        return true;
    }

    @PostMapping("getIndustryBrokerageMerchantInfo")
    @Override
    public MerchantInfo getIndustryBrokerageMerchantInfo(@RequestParam("industryCode") String industryCode) {
        PlusEntityWrapper<MerchantInfo> plusEntityWrapper = MerchantInfoCondition.builder().andIndustryCodeEq(industryCode)
                .andNatureEq(VirtualAccountType.BROKERAGE.getType()).andStatusNe(AccountStatus.CANCEL.getCode().toString()).build();
       List<MerchantInfo> list = merchantInfoService.selectList(plusEntityWrapper,false);
        if (list != null && list.size() > 1) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("数据错误：客户号[%s]存在多个佣金账户",industryCode));
        }
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @PostMapping("/validCashMaxTranAmt")
    @Override
    public boolean validCashMaxTranAmt(@RequestParam("industryCode") String industryCode, @RequestParam("userAccount") String userAccount, @RequestParam("transAmount") long transAmount) {
        industryAmountLimitService.validCashMaxTranAmt(industryCode, userAccount, transAmount);
        return true;
    }

    @PostMapping("/validSubAccountOpenMax")
    @Override
    public boolean validSubAccountOpenMax(@RequestParam("industryCode") String industryCode, @RequestParam("idCode") String idCode,
                                          @RequestParam("subAccountOpenMax") Integer subAccountOpenMax, @RequestParam("nature") String nature, @RequestParam("userType") String usertype) {
        Assert.hasText(industryCode, "参数[industryCode]不能为空");
        Assert.hasText(idCode, "参数[idCode]不能为空");
        Assert.hasText(nature, "参数[nature]不能为空");
        Assert.hasText(nature, "参数[userType]不能为空");
        Assert.notNull(subAccountOpenMax, "参数[subAccountOpenMax]不能为空");

        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(nature);
        UserType userType = UserType.getUserType(usertype);
        if(userType==null){
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST,"userType["+usertype+"]类型暂不支持");
        }

        //业务调整企业商户的开立数校验的是 营业执照 其他依然为 证件号码
        if (VirtualAccountType.MERCHANT.equals(virtualAccountType) || VirtualAccountType.PERSON.equals(virtualAccountType)
                || VirtualAccountType.BROKERAGE.equals(virtualAccountType) || VirtualAccountType.SELFEMPLOYED.equals(virtualAccountType)
                || VirtualAccountType.SETTLEACCOUNT.equals(virtualAccountType)) {

            MerchantInfoCondition builder = MerchantInfoCondition.builder().andIndustryCodeEq(industryCode).andStatusNe(AccountStatus.CANCEL.getCode());
            if (userType== UserType.MER) {
                builder.andBusLicCodeEq(idCode).andUserTypeEq(userType.getType());
            } else {
                builder.andIdCodeEq(idCode).andUserTypeEq(userType.getType());
            }

            //查询相同代付客户号，相同证件号的商户数量
            Integer merCount = MybatisDaoImpl.run().selectCount(builder.build());
            //是否超出二级账户最大开立数量
            return merCount >= subAccountOpenMax;
        }
        return false;
    }

    @PostMapping("existsIndustryAccountInfo")
    @Override
    public boolean existsIndustryAccountInfo(@RequestParam("industryCode") String industryCode, @RequestParam("accountNo") String accountNo, @RequestParam("accountName") String accountName) {
        PlusEntityWrapper<IndustryAccountInfo> plusEntityWrapper = IndustryAccountInfoCondition.builder()
                .andIndustryCodeEq(industryCode).andAccountNoEq(accountNo).andAccountNameEq(accountName).andIndustryTypeEq(VirtualAccountType.INDUSTRY.getType()).build();
        Integer count = MybatisDaoImpl.run().selectCount(plusEntityWrapper);
        return count > 0;
    }

    @PostMapping("/validBalancePayLimitAmt")
    @Override
    public boolean validBalancePayLimitAmt(@RequestParam("industryCode") String industryCode, @RequestParam("subAccount") String subAccount, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate) {

        long industryBalancePayDailyAvailableAmount = industryAmountLimitService.getIndustryBalancePayDailyAvailableAmount(industryCode, transDate, 0L);
        //校验余额支付 客户号当日限额
        if (transAmount > industryBalancePayDailyAvailableAmount) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]余额支付单日额度不足,当前剩余可用额度[%s元]", industryCode, formatAmt(industryBalancePayDailyAvailableAmount)));
        }

        long subAccountBalancePayDailyAvailableAmount = subAccountAmountLimitService.getSubAccountBalancePayDailyAvailableAmount(industryCode, subAccount, transDate, 0L);
        //校验余额支付 子账户当日限额
        if (transAmount > subAccountBalancePayDailyAvailableAmount) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]下子账户余额支付[%s]单日额度不足,当前剩余可用额度[%s元]", industryCode, subAccount, formatAmt(subAccountBalancePayDailyAvailableAmount)));
        }

        return true;
    }

    @PostMapping("/accumulateBalancePayAmount")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void accumulateBalancePayAmount(@RequestParam("industryCode") String industryCode, @RequestParam("subAccount") String subAccount, @RequestParam("transAmount") long transAmount, @RequestParam("transDate") String transDate) {
        //增加客户号余额支付单日累计交易额
        industryAmountLimitService.accumulateIndustryBalancePayAmount(industryCode, transAmount, transDate);
        //增加子账户余额支付单日累计交易额
        subAccountAmountLimitService.accumulateSubAccountBalancePayAmount(industryCode, subAccount, transAmount, transDate);
    }

    @Override
    @PostMapping("/getMerchantInfoByUserAccount")
    public MerchantInfo getMerchantInfoByUserAccount(@RequestParam("industryCode")String industryCode, @RequestParam("userAccount")String userAccount){
        return merchantInfoService.getMerchantInfoByUserAccount(industryCode,userAccount);
    }


}
