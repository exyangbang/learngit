package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.AccountCondition;
import cn.kingnet.utp.service.persistence.entity.AccountEntryDetail;
import cn.kingnet.utp.service.persistence.entity.CommonDictionary;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.IndustryCondition;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfoCondition;
import cn.kingnet.utp.service.persistence.support.VirtualAccountNoGenerate;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.UserType;
import cn.kingnet.utp.trade.common.enums.VirtualAccountType;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description : 预付卡入账服务
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/5 13:23
 */
@Service
@Slf4j
public class AccountEntryService {

    @Resource
    private CommonDictionaryService commonDictionaryService;

    /**
     * 数据字典中的：默认机构
     */
    private CommonDictionary defaultOrg;

    @Resource
    private InnerAccountService innerAccountService;

    @Resource
    private VirtualAccountNoGenerate virtualAccountNoGenerate;
    @Resource
    private IndustryService industryService;
    @Resource
    private MerchantInfoService merchantInfoService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED )
    public Account processAccountEntry(AccountEntryDetail accountEntryDetail) {
        //根据代付客户号获取资金帐号
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(accountEntryDetail.getIndustryCode()).build());
        //创建虚拟帐号
        Account account = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andFundAccountEq(industry.getFundAccount()).andObjCodeEq(accountEntryDetail.getMerNo()).andObjTypeEq(VirtualAccountType.MERCHANT.getType()).build());
        if(account == null){
            account = this.convertMerAccount(true,VirtualAccountType.MERCHANT,accountEntryDetail,industry.getFundAccount(),null);
            MybatisDaoImpl.run().insert(account);
        }

        accountEntryDetail.setUserAccount(account.getAccount());

        //账户不存在或者账户状态非正常，则不处理
        if (!CommonConstants.STATUS_NORMAL.equals(account.getStatus())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("%s账户不存在或不可用", account.getAccount()));
        }

        //创建商户基本信息
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(account.getAccount()).build());
        if(merchantInfo == null){
            merchantInfo = this.convertMerchantInfo(true,UserType.MER, accountEntryDetail,account,industry);
            MybatisDaoImpl.run().insert(merchantInfo);
        }

        //账户不存在或者账户状态非正常，则不处理
        if (!CommonConstants.STATUS_NORMAL.equals(merchantInfo.getStatus())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("%s用户不存在或不可用", accountEntryDetail.getMerNo()));
        }

        //平台虚拟账户出金
        innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT,accountEntryDetail.getPayerAccount(),accountEntryDetail.getAmount(),accountEntryDetail.getAccountNo(),String.format("平台%s,入账日期%s,批次号%s 的入账处理打款出金.",accountEntryDetail.getIndustryCode(), accountEntryDetail.getEntryDate(), accountEntryDetail.getBatchId()),accountEntryDetail.getBatchId(),null,null);
        //商户虚拟账户入金
        innerAccountService.plusBalance(AccountOperSubType.PAYMENT,account.getAccount(),accountEntryDetail.getAmount(),accountEntryDetail.getAccountNo(),String.format("平台%s,入账日期%s,批次号%s 的入账处理打款入金.", accountEntryDetail.getIndustryCode(), accountEntryDetail.getEntryDate(), accountEntryDetail.getBatchId()),accountEntryDetail.getBatchId(),null,null);

        return account;
    }

    private MerchantInfo convertMerchantInfo(boolean isCreate,UserType userType, AccountEntryDetail accountEntryDetail,Account account,Industry industry) {
        return MerchantInfo.builder()
                .id(isCreate ? IdWorker.getId() : null)
                .merNo(accountEntryDetail.getMerNo())
                .merName(StringUtil.isBlank(accountEntryDetail.getAccountName()) ? accountEntryDetail.getMerNo() : accountEntryDetail.getAccountName())
                .userType(userType.getType())
                .orgCode(getDefaultOrg().getKey())
                .orgName(getDefaultOrg().getValue())
                .industryCode(accountEntryDetail.getIndustryCode())
                .industryName(industry.getName())
                .status(CommonConstants.STATUS_NORMAL)
                .account(account.getAccount())
                .gmtCreate(isCreate ? new Date() : null)
                .gmtModified(new Date())
                .build();
    }

    private Account convertMerAccount(boolean isCreate,VirtualAccountType virtualAccountType,AccountEntryDetail accountEntryDetail, String funAccount,String accountNo) {
        return Account.builder()
                .id(isCreate ? IdGenerate.getId() : null)
                .objType(virtualAccountType.getType())
                .objCode(accountEntryDetail.getMerNo())
                .objName(StringUtil.isBlank(accountEntryDetail.getAccountName()) ? accountEntryDetail.getMerNo() : accountEntryDetail.getAccountName())
                .account(isCreate ? virtualAccountNoGenerate.createPrecardAccountNo() : accountNo)
                .status(CommonConstants.STATUS_NORMAL)
                .fundAccount(funAccount)
                .gmtCreate(isCreate ? new Date() : null)
                .gmtModified(new Date())
                .build();
    }

    private CommonDictionary getDefaultOrg() {
        if (defaultOrg == null) {
            defaultOrg = commonDictionaryService.getDefaultOrg();
        }
        return defaultOrg;
    }
}
