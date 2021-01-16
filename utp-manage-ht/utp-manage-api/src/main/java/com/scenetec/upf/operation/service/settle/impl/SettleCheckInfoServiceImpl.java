package com.scenetec.upf.operation.service.settle.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.ProductNoEnum;
import com.scenetec.upf.operation.model.Enum.TradeTypeEnum;
import com.scenetec.upf.operation.model.domain.product.PayProductDO;
import com.scenetec.upf.operation.model.domain.settle.SettleCheckInfoDO;

import com.scenetec.upf.operation.repository.product.PayProductMapper;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.settle.SettleCheckInfoMapper;
import com.scenetec.upf.operation.service.settle.SettleCheckInfoService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Service
public class SettleCheckInfoServiceImpl implements SettleCheckInfoService {
    @Resource
    PayProductMapper payProductMapper;
    @Resource
    SettleCheckInfoMapper mapper;

    @Override
    public long create(SettleCheckInfoDO obj) {
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public void update(SettleCheckInfoDO obj) {
        mapper.update(obj);

    }

    /**
     * 修改状态 人工处理审核状态（0-待审核 1-审核通过 2-审核驳回）
     *
     * @param obj
     */
    @Override
    @Transactional
    public void updateAuditStatus(SettleCheckInfoDO obj) {
        if (obj == null || obj.getAuditStatus() == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        SettleCheckInfoDO tempObj = new SettleCheckInfoDO();
        tempObj.setAuditStatus(obj.getAuditStatus());
        tempObj.setTransStatus(obj.getTransStatus());
        tempObj.setRemark(obj.getRemark());
        for (int i = 0; i < obj.getTempIdList().size(); i++) {
            String idStr = obj.getTempIdList().get(i).toString();
            Long idTemp = new Long(idStr);
            SettleCheckInfoDO settleCheckInfoDO = mapper.getById(idTemp);
            if (settleCheckInfoDO.getErrorType().equals("b") || settleCheckInfoDO.getErrorType().equals("g")) {
                throw new SystemRuntimeException(ErrorCode.PERR001);
            }
            tempObj.setId(idTemp);
            mapper.update(tempObj);
        }
    }

    @Override
    public SettleCheckInfoDO getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public PageInfo<SettleCheckInfoDO> list(Query query) {
        if (query != null &&
                query.getParameters() != null &&
                query.getParameters().get("errorType") != null &&
                query.getParameters().get("errorType").equals("e")) {
            //f状态目前也是按照 平台多流水处理
            Map<String, Object> tem = query.getParameters();
            tem.put("fErrorType", "f");
            query.setParameters(tem);
        }

        Map map = query.getParameters();
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<SettleCheckInfoDO> page = mapper.list(map);
        return new PageInfo<>(page);
    }


    @Override
    public PageInfo<SettleCheckInfoDO> listDownload(Query query) {
        if (query != null &&
                query.getParameters() != null &&
                query.getParameters().get("errorType") != null &&
                query.getParameters().get("errorType").equals("e")) {
            //f状态目前也是按照 平台多流水处理
            Map<String, Object> tem = query.getParameters();
            tem.put("fErrorType", "f");
            query.setParameters(tem);
        }
        Map map = query.getParameters();
        Page<SettleCheckInfoDO> page = mapper.list(map);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        if (parameters.get("errorType") != null &&
                        parameters.get("errorType").equals("e")) {
            //f状态目前也是按照 平台多流水处理
            Map<String, Object> tem = parameters;
            tem.put("fErrorType", "f");
            parameters =tem;
        }
        Map<String, Long> map = mapper.countSum(parameters);
        return map;
    }
}
