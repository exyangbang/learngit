package com.scenetec.upf.operation.service.withdrawalsrecord.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.WithdrawalsRecordDO;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.status.WithdrawalsRecordStatusEnum;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.CollectionAccountWithdrawReqDTO;
import com.scenetec.upf.operation.model.vo.CollectionAccountWithdrawRespDTO;
import com.scenetec.upf.operation.model.vo.QueryCollectionAccountWithdrawReqDTO;
import com.scenetec.upf.operation.model.vo.QueryCollectionAccountWithdrawRespDTO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordExVO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordVO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.repository.withdrawalsrecord.WithdrawalsRecordMapper;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.withdrawalsrecord.WithdrawalsRecordService;
import com.scenetec.upf.operation.service.withdrawcashaccount.WithdrawCashAccountService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service
public class WithdrawalsRecordServiceImpl implements WithdrawalsRecordService {
    private Logger logger = LoggerFactory.getLogger(OnlineRequestTool.class);
    @Resource
    UserService userService;
    @Resource
    IndustryService industryService;
    @Resource
    FundAccountMapper fundAccountMapper;
    @Resource
    WithdrawCashAccountService withdrawCashAccountService;
    @Resource
    WithdrawalsRecordMapper withdrawalsRecordMapper;
    @Resource
    AccountMapper accountMapper;
    @Resource
    OnlineRequestTool onlineRequestTool;


    @Value("${withdraw.cas.account.url}")
    private String withdrawCasAccountUrl;
    @Value("${withdraw.cas.queryCollectAccountWithdraw.url}")
    private String queryCollectAccountWithdrawUrl;

    @Override
    public long create(WithdrawalsRecordVO objVo) {
        WithdrawalsRecordDO obj = new WithdrawalsRecordDO();
        logger.error("请求地址：" + withdrawCasAccountUrl + "====提现提交");
        //1.获取账户
        IndustryDO industryDO = industryService.getByAccount(objVo.getAccount());
        FundAccountDO fundAccountDO = new FundAccountDO();
        fundAccountDO.setBankAccountNo(industryDO.getFundAccount());
        fundAccountDO = fundAccountMapper.selectOne(fundAccountDO);

        //已经有提现记录待审核，不能再提交
        WithdrawalsRecordDO temObj = new WithdrawalsRecordDO();
        temObj.setAccount(industryDO.getAccount());
        temObj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        Integer resCont = withdrawalsRecordMapper.count(temObj);
        if (resCont > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "已有在审的提现记录，请先处理");
        }

        //2.虚拟账户 提现金额不能超出可用金额
        AccountDO temAccount = new AccountDO();
        temAccount.setAccount(objVo.getAccount());
        AccountDO accountDO = accountMapper.selectOne(temAccount);
        if (objVo.getAmount() < 0) {
            throw new SystemRuntimeException(ErrorCode.CASH002);
        }
        if (objVo.getAmount() > accountDO.getAvailAmount()) {
            throw new SystemRuntimeException(ErrorCode.CASH005);
        }
        //3.提现账户
        WithdrawCashAccountDO withdrawCashAccountDO = withdrawCashAccountService.getById(objVo.getReciveId());
        if (withdrawCashAccountDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMUM007);
        }
        String reqDate = DateUtilities.formatDate(new Date(), "yyyyMMdd");
        String reqTime = DateUtilities.formatDate(new Date(), "HHmmss");
        obj.setAccount(industryDO.getAccount());
        obj.setIndustryCode(industryDO.getCode());
        obj.setIndustryName(industryDO.getName());
        obj.setFundAccountName(fundAccountDO.getBankAccountName());
        obj.setFundAccountNo(fundAccountDO.getBankAccountNo());
        obj.setReciveAccountName(withdrawCashAccountDO.getAccountName());
        obj.setReciveAccountNo(withdrawCashAccountDO.getAccountNo());
        obj.setAmount(objVo.getAmount());//提现金额
        obj.setStatus(WithdrawalsRecordStatusEnum.CHAN_AVAILABLE.getValue());
        obj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        obj.setClientTransId(IdGenerate.generateServiceTransId("utp", "801"));
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setId(IdGenerate.getId());
        obj.setReciveOpBankCode(withdrawCashAccountDO.getOpBankCode());
        obj.setReciveOpBankName(withdrawCashAccountDO.getOpBankName());
        obj.setReciveClBankCode(withdrawCashAccountDO.getPayeeOpbk().toString());
        obj.setReqDate(reqDate);
        obj.setReqTime(reqTime);
        return withdrawalsRecordMapper.create(obj);
    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return withdrawalsRecordMapper.deletebyId(id);
    }

    /**
     * 提现审核
     *
     * @param objVo
     */
    @Override
//    @Transactional
    public void update(WithdrawalsRecordExVO objVo) {
        logger.error("请求地址：" + withdrawCasAccountUrl + "====提现审核开始");
        if (!AuditStatusEnum.contains(objVo.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        String reqDate = DateUtilities.formatDate(new Date(), "yyyyMMdd");
        String reqTime = DateUtilities.formatDate(new Date(), "HHmmss");
        WithdrawalsRecordDO obj = new WithdrawalsRecordDO();
        if (objVo.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {//审核通过
            WithdrawalsRecordDO tempObj = withdrawalsRecordMapper.getById(objVo.getId());
            //先修改库表时间,由于联机时间要对比是否正确
            WithdrawalsRecordDO ttrecObj = new WithdrawalsRecordDO();
            ttrecObj.setId(objVo.getId());
            ttrecObj.setReqDate(reqDate);//请求日期
            ttrecObj.setReqTime(reqTime);//请求时间
            int res =  withdrawalsRecordMapper.update(ttrecObj);
            if (res > 0){
                CollectionAccountWithdrawReqDTO collreq = new CollectionAccountWithdrawReqDTO();
                collreq.setId(tempObj.getId().toString());
                collreq.setReqDate(reqDate);//请求日期
                collreq.setReqTime(reqTime);//请求时间
                collreq.setClientTransId(tempObj.getClientTransId());
                collreq.setIndustryCode(tempObj.getIndustryCode());//代付客户号
                collreq.setAccount(tempObj.getAccount());//虚拟账户
                collreq.setTransAmount(tempObj.getAmount());//代付金额
                try {
                    collreq.setSign(SHA1.genWithAmple(collreq.toSHA1()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                try {
                    CollectionAccountWithdrawRespDTO serverResponseDTO = onlineRequestTool.collectionpostResquest(withdrawCasAccountUrl, collreq);
                    obj.setServerTransId(serverResponseDTO.getServerTransId());//服务端流水号
                    obj.setTransStatus(serverResponseDTO.getTransStatus() == null ? TransStatusEnum.PROCESSING.getValue() : serverResponseDTO.getTransStatus());//处理中
                } catch (Exception e) {
                    obj.setTransStatus(TransStatusEnum.TRADE_ERROR.getValue());//处理异常
                    obj.setGmtModified(new Date());
                    obj.setUserModified(userService.getUserContext().getUsername());
                    obj.setId(objVo.getId());
                    obj.setAuditStatus(objVo.getAuditStatus());
                    withdrawalsRecordMapper.update(obj);
                    logger.error("请求地址：" + withdrawCasAccountUrl + "====" + JSON.toJSONString(obj));
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, "联机处理失败");
                }
            }
        } else {
            obj.setTransStatus(TransStatusEnum.TRADE_FAILURE.getValue());//处理失败
        }
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setId(objVo.getId());

        if (AuditStatusEnum.contains(objVo.getAuditStatus()) == false) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        obj.setAuditStatus(objVo.getAuditStatus());
        withdrawalsRecordMapper.update(obj);
    }

    @Override
    public WithdrawalsRecordDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return withdrawalsRecordMapper.getById(id);
    }

    @Override
    public PageInfo<WithdrawalsRecordDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        List<WithdrawalsRecordDO> page = withdrawalsRecordMapper.listPage(obj.getParameters());
        return new PageInfo<>(page);
    }

    /**
     * 刷新提现状态
     *
     * @param objVo
     */
    public QueryCollectionAccountWithdrawRespDTO queryCollectAccountWithdrawUrl(WithdrawalsRecordExVO objVo) {
        String reqDate = DateUtilities.formatDate(new Date(), "yyyyMMdd");
        String reqTime = DateUtilities.formatDate(new Date(), "HHmmss");
        WithdrawalsRecordDO tempObj = withdrawalsRecordMapper.getById(objVo.getId());

        QueryCollectionAccountWithdrawReqDTO queryAc = new QueryCollectionAccountWithdrawReqDTO();
        queryAc.setReqDate(reqDate);
        queryAc.setReqTime(reqTime);
        queryAc.setClientTransId(IdGenerate.generateServiceTransId("utp", "801"));
        queryAc.setIndustryCode(tempObj.getIndustryCode());
        queryAc.setOrigClientTradeId(tempObj.getClientTransId());
        try {
            queryAc.setSign(SHA1.genWithAmple(queryAc.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        QueryCollectionAccountWithdrawRespDTO serverResponseDTO = onlineRequestTool.queryCollectionpostResquest(queryCollectAccountWithdrawUrl, queryAc);
        try {
            WithdrawalsRecordDO obj = new WithdrawalsRecordDO();
            obj.setTransStatus(serverResponseDTO.getTransStatus());
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            obj.setTransDesc(serverResponseDTO.getTransDesc());
            obj.setId(objVo.getId());
            withdrawalsRecordMapper.update(obj);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "数据更新失败");
        }
        return serverResponseDTO;
    }

}
