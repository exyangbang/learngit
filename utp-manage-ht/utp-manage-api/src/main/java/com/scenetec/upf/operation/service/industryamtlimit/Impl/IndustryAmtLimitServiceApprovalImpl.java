package com.scenetec.upf.operation.service.industryamtlimit.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.InduAmtLimitOperationTypeEnum;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.industry.status.IndustryTypeEnum;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
import com.scenetec.upf.operation.model.vo.RefreshRedisDTO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.repository.industryamtlimit.IndustryAmtLimitApprovalMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.IndustryAmtLimitMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.SubaccountsAmtLimitApprovalMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.SubaccountsAmtLimitMapper;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.industryamtlimit.IndustryAmtLimitApprovalService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.RefreshOnlineTool;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class IndustryAmtLimitServiceApprovalImpl implements IndustryAmtLimitApprovalService {
    @Resource
    IndustryAmtLimitApprovalMapper industryAmtLimitApprovalMapper;

    @Resource
    IndustryAmtLimitMapper industryAmtLimitMapper;

    @Resource
    IndustryService industryService;

    @Resource
    UserService userService;

    @Resource
    RefreshOnlineTool refreshOnlineTool;

    @Resource
    SubaccountsAmtLimitMapper subaccountsAmtLimitMapper;
    @Resource
    SubaccountsAmtLimitApprovalMapper approvalMapper;

    @Override
    @Transactional
    public long create(IndustryAmtLimitApprovalVO obj) {
        //1.子账户配置限额的，限额不能删除
        if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(obj.getOperationType())) {
            SubaccountsAmtLimitDO subaccountsAmtLimitDO = new SubaccountsAmtLimitDO();
            subaccountsAmtLimitDO.setIndustryCode(obj.getIndustryCode());
            Integer resCount = subaccountsAmtLimitMapper.count(subaccountsAmtLimitDO);
            if (resCount > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "已配置子账户限额,不能删除该配置");
            }
            SubaccountsAmtLimitApprovalDO subaccountsAmtLimitApprovalDO = new SubaccountsAmtLimitApprovalDO();
            subaccountsAmtLimitApprovalDO.setIndustryCode(obj.getIndustryCode());
            subaccountsAmtLimitApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            Integer approvalCount = approvalMapper.count(subaccountsAmtLimitApprovalDO);
            if (approvalCount > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "已配置子账户限额,不能删除该配置");
            }
        }

        //1.1判断代付客户是否存在
        IndustryDO industryDO = new IndustryDO();
        industryDO.setCode(obj.getIndustryCode());
        industryDO.setIndustryType(IndustryTypeEnum.CHAN_BUSINESS.getValue());
        industryDO = industryService.getOneIndustry(industryDO);
        if (industryDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCD102, "代付客户号");
        }

        //2.判断代付客户是否有在审，不能再提交
        Map map = new HashMap();
        map.put("industryCode", industryDO.getCode());
        map.put("auditStatus",AuditStatusEnum.AUDIT_UNTREATED.getValue());
        IndustryAmtLimitApprovalDO tempApp = industryAmtLimitApprovalMapper.selectByindLimit(map);
        if (tempApp != null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "该代付客户号,在审不能重复提交！");
        }

        Long IntId = IdGenerate.getId();
        //3.每个客户号只允许有一条记录,并且是新增的
        IndustryAmtLimitDO industryAmtLimitDO = new IndustryAmtLimitDO();
        industryAmtLimitDO.setIndustryId(industryDO.getId());
        industryAmtLimitDO = industryAmtLimitMapper.selectOne(industryAmtLimitDO);
        if (industryAmtLimitDO != null &&
                InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(obj.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCD100, "代付客户号");
        }
        if (!InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(obj.getOperationType())) {
            //4.任何额度都不能大于  客户单日限额
            if (obj.getIndustryDateAmt() < obj.getUnitIndividualAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "单位结算卡单笔提现/代付限额不能大于客户号单日提现/代付限额");
            }

            if (obj.getIndustryDateAmt() < obj.getPublicIndividualAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对公单笔提现/代付限额不能大于客户号单日提现/代付限额");
            }

            if (obj.getIndustryDateAmt() < obj.getPrivateIndividualAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对私单笔提现/代付限额不能大于客户号单日提现/代付限额");
            }
            if (obj.getIndustryDateAmt() < obj.getPublicSubaccountsDateAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对公子账户提现/代付单日限额不能大于客户号单日提现/代付限额");
            }
            if (obj.getIndustryDateAmt() < obj.getSubaccountsDateAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对私子账户提现/代付单日限额不能大于客户号单日提现/代付限额");
            }
            if (obj.getIndustryBalanceDateAmt() < obj.getPrivateSubaccountsBalanceDateAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对私子账户余额支付单日限额不能大于客户号余额支付单日限额");
            }
            if (obj.getIndustryBalanceDateAmt() < obj.getPublicSubaccountsBalanceDateAmt()) {
                throw new SystemRuntimeException(ErrorCode.BSMCD100, "对公子账户余额支付单日限额不能大于客户号余额支付单日限额");
            }
        }

        IndustryAmtLimitApprovalDO quotaExaApprovalDO = new IndustryAmtLimitApprovalDO();
        BeanUtils.copyProperties(obj, quotaExaApprovalDO);
        quotaExaApprovalDO.setSameOrderMaxSpeAmt(quotaExaApprovalDO.getSameOrderMaxSpeAmt() == null ? "5" : quotaExaApprovalDO.getSameOrderMaxSpeAmt());
        quotaExaApprovalDO.setSameCashMaxAmt(quotaExaApprovalDO.getSameCashMaxAmt() == null ? "3" : quotaExaApprovalDO.getSameCashMaxAmt());
        quotaExaApprovalDO.setMinuteMaxCashTranAmt(quotaExaApprovalDO.getMinuteMaxCashTranAmt() == null ? "60" : quotaExaApprovalDO.getMinuteMaxCashTranAmt());
        quotaExaApprovalDO.setGmtCreate(new Date());
        quotaExaApprovalDO.setUserCreate(userService.getUserContext().getUsername());
//        quotaExaApprovalDO.setGmtModified(new Date());
//        quotaExaApprovalDO.setUserModified(userService.getUserContext().getUsername());
        quotaExaApprovalDO.setId(IntId);
        quotaExaApprovalDO.setIndustryCode(industryDO.getCode());
        quotaExaApprovalDO.setIndustryName(industryDO.getName());
        quotaExaApprovalDO.setIndustryId(industryDO.getId());
        quotaExaApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        return industryAmtLimitApprovalMapper.create(quotaExaApprovalDO);
    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return industryAmtLimitApprovalMapper.delete(id);
    }

    @Override
    public void update(IndustryAmtLimitApprovalVO obj) {
        if (!AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        Map map = new HashMap();
        map.put("industryCode", obj.getIndustryCode());
        IndustryAmtLimitApprovalDO tempApp = industryAmtLimitApprovalMapper.selectByindLimit(map);
        if (tempApp != null && tempApp.getAuditStatus().equals(AuditStatusEnum.AUDIT_UNTREATED.getValue())) {
            IndustryAmtLimitApprovalDO quotaExaApprovalDO = new IndustryAmtLimitApprovalDO();
            BeanUtils.copyProperties(obj, quotaExaApprovalDO);
            quotaExaApprovalDO.setGmtModified(new Date());
            quotaExaApprovalDO.setUserModified(userService.getUserContext().getUsername());
            quotaExaApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            quotaExaApprovalDO.setIndustryId(null);//代付客户id不能修改
            quotaExaApprovalDO.setIndustryCode(null);//code不能修改
            industryAmtLimitApprovalMapper.update(quotaExaApprovalDO);
        } else {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "只有审核中的才能修改！");
        }

    }

    @Override
    public IndustryAmtLimitApprovalDO getById(Long id) {
        if (id < 0) {
            new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return industryAmtLimitApprovalMapper.getById(id);
    }

    @Override
    public PageInfo<IndustryAmtLimitApprovalDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map<String, Object> map = query.getParameters();
//        PageHelper.orderBy("gmt_create desc");
        Page<IndustryAmtLimitApprovalDO> page = industryAmtLimitApprovalMapper.pageList(map);
        return new PageInfo<>(page);
    }

    /**
     * 审核
     *
     * @param obj
     */
    @Override
    @Transactional
    public void quotaExaApprovalAudit(IndustryAmtLimitApprovalVO obj) {
        if (!AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        try {
            IndustryAmtLimitApprovalDO quotaExaApprovalDO = new IndustryAmtLimitApprovalDO();
            quotaExaApprovalDO.setGmtModified(new Date());
            quotaExaApprovalDO.setUserModified(userService.getUserContext().getUsername());
            quotaExaApprovalDO.setId(obj.getId());
            quotaExaApprovalDO.setRemark(obj.getRemark() == "" ? null : obj.getRemark());//为空的情况，不修改原来备注
            quotaExaApprovalDO.setAuditStatus(obj.getAuditStatus());
            industryAmtLimitApprovalMapper.update(quotaExaApprovalDO);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        //审核通过才执行该操作，驳回则不操作
        if (AuditStatusEnum.AUDIT_PASS.getValue().equals(obj.getAuditStatus())) {
            //修改限额表
            IndustryAmtLimitApprovalDO tempInd = industryAmtLimitApprovalMapper.getById(obj.getId());
            if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(tempInd.getOperationType())) {//新增操作
                IndustryAmtLimitDO industryAmtLimitDO = new IndustryAmtLimitDO();
                industryAmtLimitDO.setIndustryCode(tempInd.getIndustryCode());
                Integer resCount = industryAmtLimitMapper.count(industryAmtLimitDO);
                if (resCount > 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, "该代付客户号限额已经存在");
                }
                try {
                    BeanUtils.copyProperties(tempInd, industryAmtLimitDO);
                    industryAmtLimitDO.setGmtModified(new Date());
                    industryAmtLimitDO.setUserModified(userService.getUserContext().getUsername());
                    industryAmtLimitDO.setId(IdGenerate.getId());
                    industryAmtLimitMapper.create(industryAmtLimitDO);
                }catch (Exception e){
                    throw new  SystemRuntimeException(ErrorCode.BSMSC008);
                }

            }
            if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().equals(tempInd.getOperationType())) {//修改操作
                try {
                    IndustryAmtLimitDO industryAmtLimitDO = new IndustryAmtLimitDO();
                    BeanUtils.copyProperties(tempInd, industryAmtLimitDO);
                    industryAmtLimitDO.setGmtModified(new Date());
                    industryAmtLimitDO.setUserModified(userService.getUserContext().getUsername());
//                industryAmtLimitDO.setIndustryId(null);//代付客户id不能修改
//                industryAmtLimitDO.setIndustryCode(null);//code不能修改
                    industryAmtLimitMapper.updateByindustryCode(industryAmtLimitDO);
                }catch (Exception e){
                    throw new  SystemRuntimeException(ErrorCode.BSMSC007);
                }


            }
            if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(tempInd.getOperationType())) {//删除操作
                IndustryAmtLimitDO sbDo = new IndustryAmtLimitDO();
                sbDo.setIndustryCode(tempInd.getIndustryCode());
                sbDo = industryAmtLimitMapper.selectOne(sbDo);

                industryAmtLimitMapper.deleteByIndustryCode(tempInd.getIndustryCode());//删除
                //通知联机
                RefreshRedisDTO.IndustryLimitAmountVO industryLimitAmountVO = new RefreshRedisDTO.IndustryLimitAmountVO();
                industryLimitAmountVO.setIndustryCode(tempInd.getIndustryCode());
                industryLimitAmountVO.setIndustryLimitId(sbDo.getId());
                RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
                refreshRedisDTO.setIndustryLimitAmountVO(industryLimitAmountVO);
                refreshRedisDTO.setOperateType("3");//删除
                refreshOnlineTool.RefreshQuato("02", refreshRedisDTO);
            }

        }


    }

    /**
     * 删除另外处理，这个是新增和修改
     *
     * @param obj
     */
    public void updateToOnlineReuqest1(IndustryAmtLimitApprovalVO obj) {
        //通知联机，额度改变了
        IndustryAmtLimitApprovalDO tempInd = industryAmtLimitApprovalMapper.getById(obj.getId());
        IndustryAmtLimitDO sbDo = new IndustryAmtLimitDO();
        sbDo.setIndustryCode(tempInd.getIndustryCode());
        sbDo = industryAmtLimitMapper.selectOne(sbDo);

        RefreshRedisDTO.IndustryLimitAmountVO industryLimitAmountVO = new RefreshRedisDTO.IndustryLimitAmountVO();
        industryLimitAmountVO.setIndustryCode(tempInd.getIndustryCode());
        industryLimitAmountVO.setIndustryLimitId(sbDo.getId());
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setIndustryLimitAmountVO(industryLimitAmountVO);
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().endsWith(tempInd.getOperationType())) {//增加
            refreshRedisDTO.setOperateType("1");
        }
        if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().endsWith(tempInd.getOperationType())) {//修改
            refreshRedisDTO.setOperateType("0");
        }
        refreshOnlineTool.RefreshQuato("02", refreshRedisDTO);
    }

    /**
     * 刷新状态通知联机
     *
     * @param obj
     */
    @Override
    public void updateToOnlineReuqest(IndustryAmtLimitApprovalVO obj) {
        //通知联机，额度改变了
        IndustryAmtLimitDO sbDo = industryAmtLimitMapper.getById(obj.getId());
        IndustryAmtLimitApprovalDO tempInd = industryAmtLimitApprovalMapper.getById(obj.getApprovalId());

        RefreshRedisDTO.IndustryLimitAmountVO industryLimitAmountVO = new RefreshRedisDTO.IndustryLimitAmountVO();
        industryLimitAmountVO.setIndustryCode(sbDo.getIndustryCode());
        industryLimitAmountVO.setIndustryLimitId(sbDo.getId());
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setIndustryLimitAmountVO(industryLimitAmountVO);
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().endsWith(tempInd.getOperationType())) {//增加
            refreshRedisDTO.setOperateType("1");
        }
        if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().endsWith(tempInd.getOperationType())) {//修改
            refreshRedisDTO.setOperateType("0");
        }
        refreshOnlineTool.RefreshQuato("02", refreshRedisDTO);
    }
}
