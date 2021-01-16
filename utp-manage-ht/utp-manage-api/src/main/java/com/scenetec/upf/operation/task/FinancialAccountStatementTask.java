package com.scenetec.upf.operation.task;

import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.financialaccountstatement.FinancialAccountStatementDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.financialaccountstatement.FinancialAccountStatementMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@Slf4j
@Service
public class FinancialAccountStatementTask {
    @Autowired
    FinancialAccountStatementMapper statementMapper;
    @Autowired
    IndustryMapper industryMapper;
    @Autowired
    FundAccountMapper fundAccountMapper;
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    UserService userService;
    /**
     * 资金账号、户名、代付客户号、代付客户名称、交易日期、入金总金额、出金总金额、
     * 当日账户余额
     * 统计可用的平台账号
     */
    // @Scheduled(cron = "0 */1 * * * ?")
     //@Scheduled(cron = "0 58 16 ? * *")//每天8 55开始统计
    @Scheduled(cron = "0 0 0 * * ?")//每天凌晨0点开始统计
    public void CapitalStatistics() throws ParseException {
        log.debug("====统计可用的平台账号 开始");
        Map tempMap = new HashMap();
        tempMap.put("industry_type", "1");
        tempMap.put("status", "1");
        List<IndustryDO> list = industryMapper.pageListAsc(tempMap);
        for (IndustryDO ind : list) {
            createFinancial(ind);
        }


    }
    @Transactional
    public void createFinancial(IndustryDO ind){
        //操作时间，当天
        AccountDO accountDO = new AccountDO();
        accountDO.setOperateType("01");//操作类型 01 入金 02 冻结 03 解冻 04 出金 '
        accountDO.setAccount(ind.getAccount());
        accountDO.setTransEndDate(getTimeEchange("yyyy-MM-dd HH:mm:ss", 0));
        accountDO.setTransBeginDate(getTimeEchange("yyyy-MM-dd HH:mm:ss", -1));
        Long inAmount = accountMapper.countSum(accountDO);//入金统计

        accountDO = new AccountDO();
        accountDO.setOperateType("04");//操作类型 01 入金 02 冻结 03 解冻 04 出金 '
        accountDO.setAccount(ind.getAccount());
        accountDO.setTransEndDate(getTimeEchange("yyyy-MM-dd HH:mm:ss", 0));
        accountDO.setTransBeginDate(getTimeEchange("yyyy-MM-dd HH:mm:ss", -1));
        Long outAmount = accountMapper.countSum(accountDO);//出金统计

        if (ind.getAccount() != null) {
            accountDO = new AccountDO();
            accountDO.setAccount(ind.getAccount());
            accountDO = accountMapper.selectOne(accountDO);

            if (accountDO != null) {
                FinancialAccountStatementDO financialDO = new FinancialAccountStatementDO();
                financialDO.setGmtCreate(new Date());
                // financialDO.setUserCreate(userService.getUserContext().getUsername());
                financialDO.setGmtModified(new Date());
                //financialDO.setUserModified(userService.getUserContext().getUsername());
                financialDO.setAccountNo(ind.getFundAccount());
                financialDO.setMerName(ind.getCustAccountName());
                financialDO.setIndustryCode(ind.getCode());
                financialDO.setIndustryName(ind.getName());
                financialDO.setTransDate(getTimeEchange("yyyyMMdd", -1));//未定
                financialDO.setInTotalAmount(inAmount);
                financialDO.setOutTotalAmount(outAmount);
                financialDO.setCurrentAccountBalance(accountDO.getBalance());
                financialDO.setId(IdGenerate.getId());
                Long res =  statementMapper.create(financialDO);
                if (res != 1L){
                    log.debug("====统计可用的平台账号报错记录:"+accountDO.getId());
                }

            }
        }
    }

    private String getTimeEchange(String pattern, Integer bDay) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(now);
        rightNow.add(Calendar.DAY_OF_YEAR, bDay);//日期-1天
        Date dt1 = rightNow.getTime();
        String reStr = dateFormat.format(dt1);
        return reStr;
    }
}
