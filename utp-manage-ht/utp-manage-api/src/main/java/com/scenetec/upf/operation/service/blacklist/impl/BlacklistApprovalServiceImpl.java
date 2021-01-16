package com.scenetec.upf.operation.service.blacklist.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.InduAmtLimitOperationTypeEnum;
import com.scenetec.upf.operation.model.Enum.ObjTypeEnum;
import com.scenetec.upf.operation.model.domain.blacklisapproval.BlacklistApprovalDO;
import com.scenetec.upf.operation.model.domain.blacklist.BlacklistDO;
import com.scenetec.upf.operation.model.vo.BlacklistOperationRecordVO;
import com.scenetec.upf.operation.repository.blacklisapproval.BlacklistApprovalMapper;
import com.scenetec.upf.operation.repository.blacklist.BlacklistMapper;
import com.scenetec.upf.operation.service.blacklist.BlacklistApprovalService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BlacklistApprovalServiceImpl implements BlacklistApprovalService {
    Logger logger = LoggerFactory.getLogger(BlacklistApprovalServiceImpl.class);
    @Resource
    BlacklistApprovalMapper mapper;
    @Resource
    BlacklistMapper blacklistMapper;
    @Resource
    UserService userService;

    /**
     * 先区分obj_type 1:个人2:企业
     *
     * @param blacklistOperationRecordVO
     * @return
     */
    @Override
    public Long create(BlacklistOperationRecordVO blacklistOperationRecordVO) {
        Boolean resBoolean = InduAmtLimitOperationTypeEnum.contains(blacklistOperationRecordVO.getOperationType());
        Boolean objBoolean = ObjTypeEnum.contains(blacklistOperationRecordVO.getObjType());
        if (!resBoolean || !objBoolean) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (ObjTypeEnum.OBJ_TYPE_PER.getValue().equals(blacklistOperationRecordVO.getObjType())) {//个人
            personal(blacklistOperationRecordVO);
        }
        if (ObjTypeEnum.OBJ_TYPE_ENT.getValue().equals(blacklistOperationRecordVO.getObjType())) {//企业
            enterprise(blacklistOperationRecordVO);
        }
        try {
            BlacklistApprovalDO black = new BlacklistApprovalDO();
            BeanUtils.copyProperties(blacklistOperationRecordVO, black);
            black.setId(IdGenerate.getId());
            black.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            black.setGmtCreate(new Date());
            black.setUserCreate(userService.getUserContext().getUsername());
            return mapper.create(black);
        } catch (Exception e) {
            logger.error("信息更新异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC007);
        }

    }

    /**
     * 个人
     *
     * @param blacklistOperationRecordVO
     */
    public void personal(BlacklistOperationRecordVO blacklistOperationRecordVO) {
        //新增情况
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode()
                .equals(blacklistOperationRecordVO.getOperationType())) {
            BlacklistDO blacklistDO = new BlacklistDO();
            blacklistDO.setIdCode(blacklistOperationRecordVO.getIdCode());
            Integer resInt = blacklistMapper.count(blacklistDO);
            if (resInt > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "该证件号已经存在不能重复添加");
            }
        }
        //如果有同一个证件号在审不能重复提交
        BlacklistApprovalDO appResDo = new BlacklistApprovalDO();
        appResDo.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        appResDo.setIdCode(blacklistOperationRecordVO.getIdCode());
        Integer appRes = mapper.count(appResDo);
        if (appRes > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "该证件号在审，请先处理!");
        }
    }

    /**
     * 企业
     *
     * @param blacklistOperationRecordVO
     */
    public void enterprise(BlacklistOperationRecordVO blacklistOperationRecordVO) {
        //新增情况
        if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode()
                .equals(blacklistOperationRecordVO.getOperationType())) {
            BlacklistDO blacklistDO = new BlacklistDO();
            blacklistDO.setBusLicCode(blacklistOperationRecordVO.getBusLicCode());
            Integer resInt = blacklistMapper.count(blacklistDO);
            if (resInt > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "该营业执照证件号已经存在不能重复添加");
            }
        }
        //如果有同一个证件号在审不能重复提交
        BlacklistApprovalDO appResDo = new BlacklistApprovalDO();
        appResDo.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        appResDo.setBusLicCode(blacklistOperationRecordVO.getBusLicCode());
        Integer appRes = mapper.count(appResDo);
        if (appRes > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "该营业执照证件号在审，请先处理!");
        }
    }

    /**
     * 审批
     *
     * @param blacklistOperationRecordVO
     */
    @Override
    @Transactional
    public void update(BlacklistOperationRecordVO blacklistOperationRecordVO) {
        if (blacklistOperationRecordVO.getId() == null || blacklistOperationRecordVO.getId() < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        Boolean resBoolean = AuditStatusEnum.contains(blacklistOperationRecordVO.getAuditStatus());
        if (!resBoolean) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        String auditStatus = blacklistOperationRecordVO.getAuditStatus();
        BlacklistApprovalDO temBlackDo = mapper.getById(blacklistOperationRecordVO.getId());
        if (AuditStatusEnum.AUDIT_UNTREATED.getValue().equals(temBlackDo.getAuditStatus())) {//待审核情况下才受理
            if (AuditStatusEnum.AUDIT_PASS.getValue().equals(auditStatus)) {//审核通过
                //新增
                String operationType = temBlackDo.getOperationType();
                if (InduAmtLimitOperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(operationType)) {
                    try {
                        BlacklistDO blacklistDO = new BlacklistDO();
                        if (ObjTypeEnum.OBJ_TYPE_PER.getValue().equals(temBlackDo.getObjType())) {//个人
                            blacklistDO.setName(temBlackDo.getName());
                            blacklistDO.setIdCode(temBlackDo.getIdCode());
                        }
                        if (ObjTypeEnum.OBJ_TYPE_ENT.getValue().equals(temBlackDo.getObjType())) {//企业
                            blacklistDO.setBusLicCode(temBlackDo.getBusLicCode());
                            blacklistDO.setEntName(temBlackDo.getEntName());
                        }
                        blacklistDO.setObjType(temBlackDo.getObjType());
                        blacklistDO.setId(IdGenerate.getId());
                        blacklistDO.setGmtCreate(new Date());
                        blacklistDO.setGmtModified(new Date());
                        blacklistDO.setUserCreate(userService.getUserContext().getUsername());
                        blacklistDO.setUserModified(userService.getUserContext().getUsername());
                        blacklistDO.setRemark(
                                blacklistOperationRecordVO.getRemark() == "" ?
                                        temBlackDo.getRemark() : blacklistOperationRecordVO.getRemark());
                        blacklistMapper.create(blacklistDO);
                    } catch (Exception e) {
                        logger.error("信息添加异常", e);
                        throw new SystemRuntimeException(ErrorCode.BSMSC008);
                    }
                }
                //删除
                if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(operationType)) {
                    try {
                        if (ObjTypeEnum.OBJ_TYPE_PER.getValue().equals(temBlackDo.getObjType())) {//个人
                            String idCode = temBlackDo.getIdCode();
                            blacklistMapper.deleteByIdCode(idCode);
                        }
                        if (ObjTypeEnum.OBJ_TYPE_ENT.getValue().equals(temBlackDo.getObjType())) {//企业
                            String idCode = temBlackDo.getBusLicCode();
                            blacklistMapper.deleteByBusLicCode(idCode);
                        }

                    } catch (Exception e) {
                        logger.error("信息更新异常", e);
                        throw new SystemRuntimeException(ErrorCode.BSMSC007);
                    }
                }
                //修改
                if (InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode().equals(operationType)) {
                    try {
                        BlacklistDO blacklistDO = new BlacklistDO();
                        blacklistDO.setGmtModified(new Date());
                        blacklistDO.setUserModified(userService.getUserContext().getUsername());
                        blacklistDO.setRemark(
                                blacklistOperationRecordVO.getRemark() == "" ?
                                        temBlackDo.getRemark() : blacklistOperationRecordVO.getRemark());
                        if (ObjTypeEnum.OBJ_TYPE_PER.getValue().equals(temBlackDo.getObjType())) {//个人
                            blacklistDO.setIdCode(temBlackDo.getIdCode());
                            blacklistDO.setName(temBlackDo.getName());
                            blacklistDO.setObjType(temBlackDo.getObjType());
                            blacklistMapper.updateByIdCode(blacklistDO);
                        }
                        if (ObjTypeEnum.OBJ_TYPE_ENT.getValue().equals(temBlackDo.getObjType())) {//企业
                            blacklistDO.setBusLicCode(temBlackDo.getBusLicCode());
                            blacklistDO.setEntName(temBlackDo.getEntName());
                            blacklistDO.setObjType(temBlackDo.getObjType());
                            blacklistMapper.updateByBusLicCode(blacklistDO);
                        }
                    } catch (Exception e) {
                        logger.error("信息更新异常", e);
                        throw new SystemRuntimeException(ErrorCode.BSMSC007);
                    }
                }
            }
            try {
                BlacklistApprovalDO blacklistApprovalDO = new BlacklistApprovalDO();
                blacklistApprovalDO.setId(blacklistOperationRecordVO.getId());
                blacklistApprovalDO.setAuditStatus(auditStatus);
                blacklistApprovalDO.setGmtModified(new Date());
                blacklistApprovalDO.setUserModified(userService.getUserContext().getUsername());
                blacklistApprovalDO.setRemark(blacklistOperationRecordVO.getRemark());
                blacklistApprovalDO.setRemark(
                        blacklistOperationRecordVO.getRemark() == "" ?
                                temBlackDo.getRemark() : blacklistOperationRecordVO.getRemark());
                mapper.update(blacklistApprovalDO);
            } catch (Exception e) {
                logger.error("信息更新异常", e);
                throw new SystemRuntimeException(ErrorCode.BSMSC007);
            }
        }
    }

    @Override
    public PageInfo<BlacklistApprovalDO> pageList(Query query) {
        try {
            query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
            query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
            PageHelper.startPage(query.getPageNo(), query.getPageSize());
            List<BlacklistApprovalDO> page = mapper.pageList(query.getParameters());
            return new PageInfo<>(page);
        } catch (Exception e) {
            logger.error("信息获取异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC009);
        }
    }

}
