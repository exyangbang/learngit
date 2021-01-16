package com.scenetec.upf.operation.service.freezingfundsopeapproval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.FreezeTypeEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.freezingfundsopeapproval.FreezingFundsOpeApprovalDO;
import com.scenetec.upf.operation.model.vo.FreezenBalanceReqDTO;
import com.scenetec.upf.operation.model.vo.FreezenBalanceRespDTO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.freezingfundsopeapproval.FreezingFundsOpeApprovalMapper;
import com.scenetec.upf.operation.service.freezingfundsopeapproval.FreezingFundsOpeApprovalService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FreezingFundsOpeApprovalServiceImpl implements FreezingFundsOpeApprovalService {
    Logger logger = LoggerFactory.getLogger(FreezingFundsOpeApprovalServiceImpl.class);
    @Resource
    private AccountMapper accountMapper;

    @Resource
    private FreezingFundsOpeApprovalMapper mapper;

    @Resource
    private UserService userService;

    @Resource
    private OnlineRequestTool onlineRequestTool;

    @Value("${account.innerManage.freezenBalance.url}")
    private String freeUrl;

    @Override
    @Transactional
    public Long create(FreezingFundsOpeApprovalDO freezingDo) {
        FreezingFundsOpeApprovalDO freezingFundsOpeApprovalDO = new FreezingFundsOpeApprovalDO();
        Long pid = IdGenerate.getId();
        AccountDO accountDO = new AccountDO();
        accountDO.setAccount(freezingDo.getAccount());
        accountDO = accountMapper.selectOne(accountDO);
        if (accountDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "账号不存在");
        }
        //冻结
        if (FreezeTypeEnum.FREEZE_TYPE.getCode().equals(freezingDo.getOperationType())) {
            //判断账户余额
            if (freezingDo.getFrozenAmount() < 0
                    || freezingDo.getFrozenAmount() > accountDO.getAvailAmount()) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "冻结金额不能大于可用余额");
            }
            //如果有再审的金额累计超过可用余额也不能通过
            Long sun = mapper.sumOfFrozenAmount(freezingDo.getAccount()) + freezingDo.getFrozenAmount();
            if (sun > accountDO.getAvailAmount()) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "冻结金额总和不能大于可用余额");
            }
        }
        //解冻
        Long freeId = null;
        String unfreezeStatus = null;
        if (FreezeTypeEnum.FREEZE_TYPE_REJECTED.getCode().equals(freezingDo.getOperationType())) {
            if (freezingDo.getId() != null && freezingDo.getId() > 0) {
                FreezingFundsOpeApprovalDO obj = mapper.getById(freezingDo.getId());
                freezingDo.setFrozenAmount(obj.getFrozenAmount());
                //不能解冻的条件--》!=审核驳回
                FreezingFundsOpeApprovalDO freeObj = new FreezingFundsOpeApprovalDO();
                freeObj.setUnfreezeStatus(AuditStatusEnum.AUDIT_REJECT.getValue());//!=审核驳回
                freeObj.setFreezeId(freezingDo.getId());
                Integer resFee = mapper.count(freeObj);
                if (resFee > 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, freezingDo.getAccount() + "解冻已经存在！");
                }
                freeId = freezingDo.getId();
                unfreezeStatus = AuditStatusEnum.AUDIT_UNTREATED.getValue();
                FreezingFundsOpeApprovalDO tem = new FreezingFundsOpeApprovalDO();
                tem.setUnfreezeStatus(unfreezeStatus);
                tem.setId(freeId);
                mapper.update(tem);
            }

        }
        //判断操作类型
        Boolean bool = FreezeTypeEnum.contains(freezingDo.getOperationType());
        if (!bool) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "操作类型错误");
        }
        try {
            BeanUtils.copyProperties(freezingDo, freezingFundsOpeApprovalDO);
            freezingFundsOpeApprovalDO.setId(pid);
            freezingFundsOpeApprovalDO.setAddUsr("0");//后管发起
            freezingFundsOpeApprovalDO.setClinetTransId(IdGenerate.getIdStr());
            freezingFundsOpeApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            freezingFundsOpeApprovalDO.setGmtCreate(new Date());
            freezingFundsOpeApprovalDO.setUserCreate(userService.getUserContext().getUsername());
            freezingFundsOpeApprovalDO.setFreezeId(freeId);//记录冻结的id
            return mapper.create(freezingFundsOpeApprovalDO);
        } catch (Exception e) {
            logger.error("信息添加异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC008);
        }

    }

    /**
     * 审批
     *
     * @param freezingFundsOpeApprovalDO
     */
    @Override
    @Transactional
    public void update(FreezingFundsOpeApprovalDO freezingFundsOpeApprovalDO) {
        FreezingFundsOpeApprovalDO temFreeDO = mapper.getById(freezingFundsOpeApprovalDO.getId());
        //审核中并且是后管发起的才能审核
        if (AuditStatusEnum.AUDIT_UNTREATED.getValue().equals(temFreeDO.getAuditStatus())
                && temFreeDO.getAddUsr().equals("0")) {
            //审核通过
            if (AuditStatusEnum.AUDIT_PASS.getValue().equals(freezingFundsOpeApprovalDO.getAuditStatus())) {
                if (FreezeTypeEnum.FREEZE_TYPE.getCode().equals(freezingFundsOpeApprovalDO.getOperationType())) {
                    //判断账户余额
                    AccountDO accountDO = new AccountDO();
                    accountDO.setAccount(freezingFundsOpeApprovalDO.getAccount());
                    accountDO = accountMapper.selectOne(accountDO);
                    if (freezingFundsOpeApprovalDO.getFrozenAmount() < 0
                            || freezingFundsOpeApprovalDO.getFrozenAmount() > accountDO.getAvailAmount()) {
                        throw new SystemRuntimeException(ErrorCode.BSMSC006, "冻结金额不能大于可用余额");
                    }

                }
                FreezenBalanceReqDTO reqDTO = new FreezenBalanceReqDTO();
                reqDTO.setIndustryCode(temFreeDO.getCode());
                reqDTO.setClientTransId(temFreeDO.getClinetTransId());
                reqDTO.setUserAccount(temFreeDO.getAccount());
                reqDTO.setFrozenAmount(temFreeDO.getFrozenAmount());
                reqDTO.setOperationType(temFreeDO.getOperationType());
                reqDTO.setAuditRemark(freezingFundsOpeApprovalDO.getAuditRemark());
                reqDTO.setAuditStatus(freezingFundsOpeApprovalDO.getAuditStatus());
                try {
                    reqDTO.setSign(SHA1.genWithAmple(reqDTO.toSHA1()));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                FreezenBalanceRespDTO freezenBalanceRespDTO = onlineRequestTool.freezenBalanceReuqet(freeUrl, reqDTO);
                try {
                    FreezingFundsOpeApprovalDO temf = new FreezingFundsOpeApprovalDO();
                    temf.setGmtModified(new Date());
                    temf.setUserModified(userService.getUserContext().getUsername());
                    temf.setAuditStatus(freezingFundsOpeApprovalDO.getAuditStatus());
                    temf.setAuditRemark(freezingFundsOpeApprovalDO.getAuditRemark());
                    temf.setServerTransId(freezenBalanceRespDTO.getServerTransId());
                    temf.setClinetTransId(freezenBalanceRespDTO.getClientTransId());
                    temf.setAccount(freezenBalanceRespDTO.getUserAccount());
                    temf.setFrozenAmount(freezenBalanceRespDTO.getFrozenAmount());
                    temf.setOperationType(freezenBalanceRespDTO.getOperationType());
                    mapper.updateByClientTransIdAndAccount(temf);
                } catch (Exception e) {
                    logger.error("信息更新异常", e);
                    throw new SystemRuntimeException(ErrorCode.BSMSC007);
                }

            }
            //审核驳回
            if (AuditStatusEnum.AUDIT_REJECT.getValue().equals(freezingFundsOpeApprovalDO.getAuditStatus())) {
                try {
                    FreezingFundsOpeApprovalDO temf = new FreezingFundsOpeApprovalDO();
                    temf.setGmtModified(new Date());
                    temf.setUserModified(userService.getUserContext().getUsername());
                    temf.setId(freezingFundsOpeApprovalDO.getId());
                    temf.setAuditStatus(freezingFundsOpeApprovalDO.getAuditStatus());
                    temf.setAuditRemark(freezingFundsOpeApprovalDO.getAuditRemark());
                    mapper.update(temf);

                } catch (Exception e) {
                    logger.error("信息更新异常", e);
                    throw new SystemRuntimeException(ErrorCode.BSMSC007);
                }
            }
            //解冻
            if (FreezeTypeEnum.FREEZE_TYPE_REJECTED.getCode().equals( temFreeDO.getOperationType())){
                try {
                FreezingFundsOpeApprovalDO freeDO = new FreezingFundsOpeApprovalDO();
                freeDO.setId(temFreeDO.getFreezeId());
                freeDO.setUnfreezeStatus(freezingFundsOpeApprovalDO.getAuditStatus());
                mapper.update(freeDO);
                } catch (Exception e) {
                    logger.error("信息更新异常", e);
                    throw new SystemRuntimeException(ErrorCode.BSMSC007);
                }
            }
        }
    }

    @Override
    public PageInfo<FreezingFundsOpeApprovalDO> pageList(Query query) {
        try {
            query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
            query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
            PageHelper.startPage(query.getPageNo(), query.getPageSize());
            PageHelper.orderBy("gmt_create desc");
            Map map = query.getParameters();
            map.put("addUsr", 0);//后管发起
            List<FreezingFundsOpeApprovalDO> list = mapper.listPage(map);
            return new PageInfo<>(list);
        } catch (Exception e) {
            logger.error("信息获取异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC009);
        }

    }
}
