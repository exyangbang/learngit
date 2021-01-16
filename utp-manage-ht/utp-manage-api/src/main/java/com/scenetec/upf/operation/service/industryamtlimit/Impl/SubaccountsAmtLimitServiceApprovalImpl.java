package com.scenetec.upf.operation.service.industryamtlimit.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.InduAmtLimitOperationTypeEnum;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
import com.scenetec.upf.operation.model.vo.RefreshRedisDTO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.SubaccountsAmtLimitApprovalVO;
import com.scenetec.upf.operation.repository.industryamtlimit.IndustryAmtLimitMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.SubaccountsAmtLimitApprovalMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.SubaccountsAmtLimitMapper;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.industryamtlimit.SubaccountsAmtLimitApprovalService;
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
public class SubaccountsAmtLimitServiceApprovalImpl implements SubaccountsAmtLimitApprovalService {
    @Resource
    SubaccountsAmtLimitApprovalMapper subaccountsAmtLimitApprovalMapper;

    @Resource
    SubaccountsAmtLimitMapper subaccountsAmtLimitMapper;

    @Resource
    IndustryService industryService;

    @Resource
    UserService userService;


    @Resource
    RefreshOnlineTool refreshOnlineTool;

    @Resource
    IndustryAmtLimitMapper industryAmtLimitMapper;

    /**
     * (1)	客户号+子账户只允许有一条记录。
     *
     * @param obj
     * @return
     */
    @Override
    public long create(SubaccountsAmtLimitApprovalVO obj) {
        //如果交易限额没有配置，无法配置子账户限额配
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(obj.getOperationType())) {
            IndustryAmtLimitDO industryAmtLimitDO = new IndustryAmtLimitDO();
            industryAmtLimitDO.setIndustryCode(obj.getIndustryCode());
            Integer resCount = industryAmtLimitMapper.count(industryAmtLimitDO);
            if (resCount == 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "该客户号交易限额未配置,请先配置!");
            }
        }
        //判断代付客户是否存在
        IndustryDO industryDO = new IndustryDO();
        industryDO.setCode(obj.getIndustryCode());
        industryDO = industryService.getOneIndustry(industryDO);
        if (industryDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCD102, "代付客户号");
        }

        //判断代付客户+子账户是否有在审，不能再提交
        Map map = new HashMap();
        map.put("industryCode", industryDO.getCode());
        map.put("subAccount", obj.getSubAccount());
        map.put("auditStatus", AuditStatusEnum.AUDIT_UNTREATED.getValue());
        SubaccountsAmtLimitApprovalDO tempApp = subaccountsAmtLimitApprovalMapper.selectByindLimit(map);
        if (tempApp != null) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "该代付客户号,在审不能重复提交！");
        }
        //3.单笔限额不能大于单日限额
        if (obj.getSubaccountsDateAmt() < obj.getSubaccountsIndividualAmt()) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "单笔限额不能大于当日限额");
        }
        Long IntId = IdGenerate.getId();
        //每个客户号+子账户只允许有一条记录,并且是新增的
        SubaccountsAmtLimitDO subaccountsAmtLimitDO = new SubaccountsAmtLimitDO();
        subaccountsAmtLimitDO.setIndustryId(industryDO.getId());
        subaccountsAmtLimitDO.setSubAccount(obj.getSubAccount());
        subaccountsAmtLimitDO = subaccountsAmtLimitMapper.selectOne(subaccountsAmtLimitDO);
        if (subaccountsAmtLimitDO != null &&
                InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(obj.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCD100, "代付客户号");
        }
        Long crateRes = 1L;
        try {
            SubaccountsAmtLimitApprovalDO subaccountsAmtLimitApprovalDO = new SubaccountsAmtLimitApprovalDO();
            BeanUtils.copyProperties(obj, subaccountsAmtLimitApprovalDO);
            subaccountsAmtLimitApprovalDO.setGmtCreate(new Date());
            subaccountsAmtLimitApprovalDO.setUserCreate(userService.getUserContext().getUsername());
//            subaccountsAmtLimitApprovalDO.setGmtModified(new Date());
//            subaccountsAmtLimitApprovalDO.setUserModified(userService.getUserContext().getUsername());
            subaccountsAmtLimitApprovalDO.setId(IntId);
            subaccountsAmtLimitApprovalDO.setIndustryCode(industryDO.getCode());
            subaccountsAmtLimitApprovalDO.setIndustryId(industryDO.getId());
            subaccountsAmtLimitApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            crateRes = subaccountsAmtLimitApprovalMapper.create(subaccountsAmtLimitApprovalDO);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "限额新增是失败");
        }
        return crateRes;

    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return subaccountsAmtLimitApprovalMapper.delete(id);
    }

    @Override
    public void update(SubaccountsAmtLimitApprovalVO obj) {
        if (!AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        Map map = new HashMap();
        map.put("industryCode", obj.getIndustryCode());
        map.put("subAccount", obj.getSubAccount());
        SubaccountsAmtLimitApprovalDO tempApp = subaccountsAmtLimitApprovalMapper.selectByindLimit(map);
        if (tempApp != null && tempApp.getAuditStatus().equals(AuditStatusEnum.AUDIT_UNTREATED.getValue())) {
            SubaccountsAmtLimitApprovalDO quotaExaApprovalDO = new SubaccountsAmtLimitApprovalDO();
            BeanUtils.copyProperties(obj, quotaExaApprovalDO);
            quotaExaApprovalDO.setGmtModified(new Date());
            quotaExaApprovalDO.setUserModified(userService.getUserContext().getUsername());
            quotaExaApprovalDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            quotaExaApprovalDO.setIndustryId(null);//代付客户id不能修改
            quotaExaApprovalDO.setIndustryCode(null);//code不能修改
            quotaExaApprovalDO.setSubAccount(null);//子账号 虚拟账户账号 不能修改
            subaccountsAmtLimitApprovalMapper.update(quotaExaApprovalDO);
        } else {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "只有审核中的才能修改！");
        }

    }

    @Override
    public SubaccountsAmtLimitApprovalDO getById(Long id) {
        if (id < 0) {
            new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return subaccountsAmtLimitApprovalMapper.getById(id);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public PageInfo<SubaccountsAmtLimitApprovalDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map<String, Object> map = query.getParameters();
        Page<SubaccountsAmtLimitApprovalDO> page = subaccountsAmtLimitApprovalMapper.pageList(map);
        return new PageInfo<>(page);
    }

    /**
     * 审核
     *
     * @param obj
     */
    @Override
    @Transactional
    public void quotaExaApprovalAudit(SubaccountsAmtLimitApprovalVO obj) {
        if (!AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        try {
            SubaccountsAmtLimitApprovalDO quotaExaApprovalDO = new SubaccountsAmtLimitApprovalDO();
            quotaExaApprovalDO.setGmtModified(new Date());
            quotaExaApprovalDO.setUserModified(userService.getUserContext().getUsername());
            quotaExaApprovalDO.setId(obj.getId());
            quotaExaApprovalDO.setRemark(obj.getRemark() == "" ? null : obj.getRemark());//为空的情况，不修改原来备注
            quotaExaApprovalDO.setAuditStatus(obj.getAuditStatus());
            subaccountsAmtLimitApprovalMapper.update(quotaExaApprovalDO);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        SubaccountsAmtLimitApprovalDO sb = subaccountsAmtLimitApprovalMapper.getById(obj.getId());

        //审核通过才执行该操作，驳回则不操作
        if (AuditStatusEnum.AUDIT_PASS.getValue().equals(obj.getAuditStatus())) {
            //修改限额表
            SubaccountsAmtLimitApprovalDO tempInd = subaccountsAmtLimitApprovalMapper.getById(obj.getId());
            if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(sb.getOperationType())) {//新增操作
                SubaccountsAmtLimitDO industryAmtLimitDO = new SubaccountsAmtLimitDO();
                industryAmtLimitDO.setIndustryCode(tempInd.getIndustryCode());
                industryAmtLimitDO.setSubAccount(tempInd.getSubAccount());
                Integer resCount = subaccountsAmtLimitMapper.count(industryAmtLimitDO);
                if (resCount > 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, "该子账号限额已经存在");
                }
                BeanUtils.copyProperties(tempInd, industryAmtLimitDO);
                industryAmtLimitDO.setGmtModified(new Date());
                industryAmtLimitDO.setUserModified(userService.getUserContext().getUsername());
                industryAmtLimitDO.setId(IdGenerate.getId());
                subaccountsAmtLimitMapper.create(industryAmtLimitDO);
            }
            if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().equals(sb.getOperationType())) {//修改操作
                SubaccountsAmtLimitDO industryAmtLimitDO = new SubaccountsAmtLimitDO();
                BeanUtils.copyProperties(tempInd, industryAmtLimitDO);
                industryAmtLimitDO.setGmtModified(new Date());
                industryAmtLimitDO.setUserModified(userService.getUserContext().getUsername());
                subaccountsAmtLimitMapper.updateBysubAccount(industryAmtLimitDO);

            }
            if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(sb.getOperationType())) {//删除操作
                SubaccountsAmtLimitDO sbDo = subaccountsAmtLimitMapper.getByIdSubAccount(tempInd.getSubAccount(), tempInd.getIndustryCode());

                subaccountsAmtLimitMapper.deleteBysubAccount(tempInd.getSubAccount(), tempInd.getIndustryCode());

                RefreshRedisDTO.SubAccountLimitAmountVO subAccountLimitAmountVO = new RefreshRedisDTO.SubAccountLimitAmountVO();
                subAccountLimitAmountVO.setIndustryCode(tempInd.getIndustryCode());
                subAccountLimitAmountVO.setSubAccount(tempInd.getSubAccount());
                subAccountLimitAmountVO.setSubAccountLimitId(sbDo.getId());
                RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
                refreshRedisDTO.setSubAccountLimitAmountVO(subAccountLimitAmountVO);
                refreshRedisDTO.setOperateType("3");//删除
                refreshOnlineTool.RefreshQuato("03", refreshRedisDTO);

            }
//            SubaccountsAmtLimitDO sbDo = subaccountsAmtLimitMapper.getByIdSubAccount(tempInd.getSubAccount(),tempInd.getIndustryCode());
//            if (sbDo == null){
//                throw new SystemRuntimeException(ErrorCode.BSMPS001,"客户号不存在");
//            }


        }

    }

    /**
     * 只处理新增，修改，删除的另外处理
     *
     * @param obj
     */
    public void updateToOnlineReuqest1(SubaccountsAmtLimitApprovalVO obj) {
        SubaccountsAmtLimitApprovalDO tempInd = subaccountsAmtLimitApprovalMapper.getById(obj.getId());
        SubaccountsAmtLimitDO sbDo = subaccountsAmtLimitMapper.getByIdSubAccount(tempInd.getSubAccount(), tempInd.getIndustryCode());
        RefreshRedisDTO.SubAccountLimitAmountVO subAccountLimitAmountVO = new RefreshRedisDTO.SubAccountLimitAmountVO();
        subAccountLimitAmountVO.setIndustryCode(tempInd.getIndustryCode());
        subAccountLimitAmountVO.setSubAccount(tempInd.getSubAccount());
        subAccountLimitAmountVO.setSubAccountLimitId(sbDo.getId());
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setSubAccountLimitAmountVO(subAccountLimitAmountVO);
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().endsWith(tempInd.getOperationType())) {//增加
            refreshRedisDTO.setOperateType("1");
        }
        if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().endsWith(tempInd.getOperationType())) {//修改
            refreshRedisDTO.setOperateType("0");
        }
        refreshOnlineTool.RefreshQuato("03", refreshRedisDTO);
    }

    //通知联机，额度改变了
    @Override
    public void updateToOnlineReuqest(SubaccountsAmtLimitApprovalVO obj) {

        SubaccountsAmtLimitDO sbDo = subaccountsAmtLimitMapper.getById(obj.getId());
        SubaccountsAmtLimitApprovalDO tempInd = subaccountsAmtLimitApprovalMapper.getById(obj.getApprovalId());
        RefreshRedisDTO.SubAccountLimitAmountVO subAccountLimitAmountVO = new RefreshRedisDTO.SubAccountLimitAmountVO();
        subAccountLimitAmountVO.setIndustryCode(sbDo.getIndustryCode());
        subAccountLimitAmountVO.setSubAccount(sbDo.getSubAccount());
        subAccountLimitAmountVO.setSubAccountLimitId(sbDo.getId());
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setSubAccountLimitAmountVO(subAccountLimitAmountVO);
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().endsWith(tempInd.getOperationType())) {//增加
            refreshRedisDTO.setOperateType("1");
        }
        if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().endsWith(tempInd.getOperationType())) {//修改
            refreshRedisDTO.setOperateType("0");
        }
        refreshOnlineTool.RefreshQuato("03", refreshRedisDTO);
    }
}
