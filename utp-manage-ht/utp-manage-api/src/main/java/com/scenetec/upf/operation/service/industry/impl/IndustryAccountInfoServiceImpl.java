package com.scenetec.upf.operation.service.industry.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.industry.IndustryAccountInfoDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.industry.status.IndustryTypeEnum;
import com.scenetec.upf.operation.repository.industry.IndustryAccountInfoMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.whitelist.WhiteListMapper;
import com.scenetec.upf.operation.service.industry.IndustryAccountInfoService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/06
 */
@Service
public class IndustryAccountInfoServiceImpl implements IndustryAccountInfoService {

    @Resource
    IndustryAccountInfoMapper mapper;

    @Resource
    WhiteListMapper whiteListMapper;

    @Resource
    UserService userService;
    @Resource
    IndustryMapper industryMapper;

    /**
     * 来款账户限制规则：
     * 客户管理--》来款账户 如果两个客户号对应的资金账户一样  他们的来款账户不能一样
     * 功能账户--》来款账户 如果资金账户相同的情况，平台账户绑定的来款账户不能和功能账户绑定的来款账户一样，
     * 功能账户绑定的来款账户可以一样
     *
     * @param obj
     * @return
     */
    @Override
    public long create(IndustryAccountInfoDO obj) {
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        IndustryDO industryDO = new IndustryDO();
        industryDO.setCode(obj.getIndustryCode());
        IndustryDO tempDo = industryMapper.selectFundAccount(industryDO);
        if (tempDo == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC009);
        }
        //同一个资金账户下，平台类型的来款账户是否已经存在
        int resInt = mapper.checkByAccountNo(tempDo.getFundAccount(), obj.getAccountNo(), IndustryTypeEnum.CHAN_BUSINESS.getValue());
        if (resInt != 0) {
            throw new SystemRuntimeException(ErrorCode.BSMIM004);
        }
        //同一资金账户下如果是客户管理的来款账户必须检查 功能账户配置的来款账户的 不能一样
        if (IndustryTypeEnum.CHAN_BUSINESS.getValue().equals(obj.getIndustryType())) {
            resInt = mapper.checkByAccountNo(tempDo.getFundAccount(), obj.getAccountNo(), null);
            if (resInt != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM004);
            }
        }
        //如果是非客户管理的来款账户必须检查是否已经绑定同一个账号
        if (!IndustryTypeEnum.CHAN_BUSINESS.getValue().equals(obj.getIndustryType())) {
            IndustryAccountInfoDO infoDO = new IndustryAccountInfoDO();
            infoDO.setIndustryCode(obj.getIndustryCode());
            infoDO.setIndustryType(obj.getIndustryType());
            infoDO.setAccountNo(obj.getAccountNo());
            resInt = mapper.count(infoDO);
            if (resInt != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM004);
            }
        }
        String typeStr = obj.getIndustryType();
        if (!IndustryTypeEnum.contains(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMIM005);
        }
        if (StringUtils.isBlank(obj.getAccountNo())) {
            throw new SystemRuntimeException(ErrorCode.BSMIM007);
        }
        obj.setId(IdGenerate.getId());
        return mapper.create(obj);
    }

    @Override
    public int delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public int deleteByIndustryCode(String code, String industryType) {
        return mapper.deleteByIndustryCode(code, industryType);
    }

    /**
     * @param obj
     */
    @Override
    public void update(IndustryAccountInfoDO obj) {
        String typeStr = obj.getIndustryType();
        if (!IndustryTypeEnum.contains(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMIM005);
        }
        if (StringUtils.isBlank(obj.getAccountNo())) {
            throw new SystemRuntimeException(ErrorCode.BSMIM007);
        }
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        IndustryAccountInfoDO ad = mapper.getById(obj.getId());
        if (!ad.getAccountNo().equals(obj.getAccountNo())) {
            IndustryDO industryDO = new IndustryDO();
            industryDO.setCode(obj.getIndustryCode());
            IndustryDO tempDo = industryMapper.selectFundAccount(industryDO);
            if (tempDo == null) {
                throw new SystemRuntimeException(ErrorCode.BSMSC009);
            }
            int resInt = mapper.checkByAccountNo(tempDo.getFundAccount(), obj.getAccountNo(), IndustryTypeEnum.CHAN_BUSINESS.getValue());
            if (resInt != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM004);
            }
            //同一资金账户下如果是客户管理的来款账户必须检查 功能账户配置的来款账户的 不能一样
            if (IndustryTypeEnum.CHAN_BUSINESS.getValue().equals(obj.getIndustryType())) {
                resInt = mapper.checkByAccountNo(tempDo.getFundAccount(), obj.getAccountNo(), null);
                if (resInt != 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMIM004);
                }
            }
            //如果是非客户管理的来款账户必须检查是否已经绑定同一个账号
            if (!IndustryTypeEnum.CHAN_BUSINESS.getValue().equals(obj.getIndustryType())) {
                IndustryAccountInfoDO infoDO = new IndustryAccountInfoDO();
                infoDO.setIndustryCode(obj.getIndustryCode());
                infoDO.setIndustryType(obj.getIndustryType());
                infoDO.setAccountNo(obj.getAccountNo());
                resInt = mapper.count(infoDO);
                if (resInt != 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMIM004);
                }
            }
        }
        mapper.update(obj);
    }

    @Override
    public IndustryAccountInfoDO getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public PageInfo<IndustryAccountInfoDO> pageList(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        Map<String, Object> map = query.getParameters();
        String typeStr = (String) map.get("industryType");
        if (!IndustryTypeEnum.contains(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMIM005);
        }
        Page<IndustryAccountInfoDO> page = mapper.pageList(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public List<IndustryAccountInfoDO> list(Map<String, Object> params) {
        PageHelper.orderBy("gmt_modified desc");
        String typeStr = (String) params.get("industryType");
        if (StringUtils.isBlank(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMCD101, "industryType");
        }
        if (!IndustryTypeEnum.contains(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMIM005);
        }
        return mapper.list(params);
    }
}
