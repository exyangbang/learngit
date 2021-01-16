package com.scenetec.upf.operation.service.trade.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.trade.TransHistoryDO;
import com.scenetec.upf.operation.model.domain.trade.TransReexchangeDO;
import com.scenetec.upf.operation.repository.trade.TransHistoryMapper;
import com.scenetec.upf.operation.repository.trade.TransReexchangeMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.trade.TransReexchangeService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description : 退汇流水信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 17:58
 */
@Service
@Slf4j
public class TransReexchangeServiceImpl implements TransReexchangeService {

    @Resource
    private TransHistoryMapper transHistoryMapper;

    @Resource
    private TransReexchangeMapper transReexchangeMapper;

    @Resource
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(TransReexchangeDO transReexchangeDO) {
        if (transReexchangeDO == null || StringUtils.isBlank(transReexchangeDO.getServerTransId())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "服务端流水号不能为空!");
        }
        if (transReexchangeDO.getRealAmount() == null || transReexchangeDO.getRealAmount() <= 0)
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "交易金额须大于零的整数!");
        int count = transReexchangeMapper.countByServerTransId(transReexchangeDO.getServerTransId());
        if (count > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "该笔退汇流水已存在!");
        }
        TransHistoryDO transHistoryDO = transHistoryMapper.findOneByServerTransId(transReexchangeDO.getServerTransId());
        if (transHistoryDO == null || StringUtils.isBlank(transHistoryDO.getServerTransId()))
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "服务端流水号不存在!");

        if (!transReexchangeDO.getServerTransId().equals(transHistoryDO.getServerTransId())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "服务端流水号不一致!");
        }
//用户对用户的，用户对代付客户的都不允许退汇
        if (!"1".equals(transHistoryDO.getNeedChannelReconcile())
                || "TRANSFER_USER2USER".equals(transReexchangeDO.getTradeType())
                || "TRANSFER_USER2INDUSTRY".equals(transReexchangeDO.getTradeType())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "该笔交易不允许退汇!");
        }

        if (StringUtils.isBlank(transReexchangeDO.getTransDate()) || !transReexchangeDO.getTransDate().equals(transHistoryDO.getTransDate())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "交易日期不一致!");
        }

        if (StringUtils.isBlank(transReexchangeDO.getReconcileDate()) || !transReexchangeDO.getReconcileDate().equals(transHistoryDO.getReconcileDate())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "清算日期不一致!");
        }

        if (StringUtils.isBlank(transReexchangeDO.getPayeeAcctNo()) ||
                !transReexchangeDO.getPayeeAcctNo().equals(transHistoryDO.getShowPayeeAccountNo().trim())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "收款方帐号不一致!");
        }

        if (StringUtils.isBlank(transReexchangeDO.getPayeeName()) || !transReexchangeDO.getPayeeName().equals(transHistoryDO.getShowPayeeAccountName())) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "收款方户名不一致!");
        }

        if (!"1".equals(transHistoryDO.getReconcileStatus()))
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "交易未对账,不能做退汇!");

        if (!"TRADE_SUCCESS".equals(transHistoryDO.getTransStatus()))
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "交易状态为" + transHistoryDO.getTransStatus() + ",不能做退汇!");

        if ((transReexchangeDO.getRealAmount() - transHistoryDO.getRealAmount()) != 0)
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "交易金额不一致!");

        //退汇交易流水处理
        transReexchangeDO.setChannelKey(transHistoryDO.getChannelKey());
        transReexchangeDO.setChannelCode(transHistoryDO.getChannelCode());
        transReexchangeDO.setChannelName(transHistoryDO.getChannelName());
        transReexchangeDO.setMerNo(transHistoryDO.getMerNo());
        transReexchangeDO.setClientTransId(transHistoryDO.getClientTransId());
        transReexchangeDO.setClientTransTime(transHistoryDO.getClientTransTime());
        transReexchangeDO.setServerTransId(transHistoryDO.getServerTransId());
        transReexchangeDO.setProductCode(transHistoryDO.getProductCode());
        transReexchangeDO.setTradeType(transHistoryDO.getTradeType());
        transReexchangeDO.setOrgCode(transHistoryDO.getOrgCode());
        transReexchangeDO.setOrgName(transHistoryDO.getOrgName());
        transReexchangeDO.setServerBatchNo(transHistoryDO.getServerBatchNo());
        transReexchangeDO.setServerLinkId(transHistoryDO.getServerLinkId());
        transReexchangeDO.setTransAmount(transHistoryDO.getTransAmount());
        transReexchangeDO.setRealAmount(transHistoryDO.getRealAmount());
        transReexchangeDO.setTransStatus(transHistoryDO.getTransStatus());
        transReexchangeDO.setTransDate(transHistoryDO.getTransDate());
        transReexchangeDO.setTransTime(transHistoryDO.getTransTime());
        transReexchangeDO.setReconcileStatus(transHistoryDO.getReconcileStatus());
        transReexchangeDO.setReconcileDate(transHistoryDO.getReconcileDate());
        transReexchangeDO.setReconcileTime(transHistoryDO.getReconcileTime());
        transReexchangeDO.setPayeeAcctNo(transHistoryDO.getPayeeAcctNo());
        transReexchangeDO.setPayeeName(transHistoryDO.getPayeeName());
        transReexchangeDO.setPayerAcctNo(transHistoryDO.getPayerAcctNo());
        transReexchangeDO.setPayerName(transHistoryDO.getPayerAcctNo());
        transReexchangeDO.setIndustryCode(transHistoryDO.getIndustryCode());
        transReexchangeDO.setChannelSettleDate(transHistoryDO.getChannelSettleDate());
        transReexchangeDO.setSolveStatus("0");
        transReexchangeDO.setGmtCreate(new Date());
        transReexchangeDO.setUserCreate(userService.getUserContext().getUsername());
        transReexchangeDO.setGmtModified(new Date());
        transReexchangeDO.setUserModified(userService.getUserContext().getUsername());
        transReexchangeDO.setId(IdGenerate.getId());
        return transReexchangeMapper.insert(transReexchangeDO);
    }

    @Override
    public PageInfo<TransReexchangeDO> pageReexchange(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<TransReexchangeDO> page = transReexchangeMapper.pageReexchange(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<TransReexchangeDO> pageReexchangeDownload(Query query) {
        Page<TransReexchangeDO> page = transReexchangeMapper.pageReexchange(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        return transReexchangeMapper.totalCountReexchange(parameters);
    }

    /**
     * 查询列表(不分页)
     *
     * @param transReexchangeDO
     * @return
     */
    @Override
    public List<TransReexchangeDO> list(TransReexchangeDO transReexchangeDO) {
        return transReexchangeMapper.list(transReexchangeDO);
    }
}
