package com.scenetec.upf.operation.service.channel.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.ChannelKeyEnum;
import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.product.PayProductDO;
import com.scenetec.upf.operation.repository.channel.ChannelIndustryMapper;
import com.scenetec.upf.operation.repository.channel.ChannelInfoMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.product.PayProductMapper;
import com.scenetec.upf.operation.service.channel.ChannelIndustryService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author scenetec
 * @date 2018/10/31
 */
@Service
public class ChannelIndustryServiceImpl implements ChannelIndustryService {

    @Resource
    ChannelIndustryMapper mapper;

    @Resource
    UserService userService;

    @Resource
    IndustryMapper industryMapper;

    @Resource
    ChannelInfoMapper channelInfoMapper;

    @Resource
    PayProductMapper payProductMapper;

    /**
     * 1.代付客户号--》关联--》新增--》实时划账
     * 2.代付客户号--》关联--》新增--》事后划账
     * 两个互斥，同一个支付产品--》互斥
     *
     * @param obj
     * @return
     */
    @Override
    public long create(ChannelIndustryDO obj) {
        if (StringUtils.isBlank(obj.getChannelKey())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "渠道标识不能为空");
        }
        if (ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue().equals(obj.getChannelKey()) &&
                StringUtils.isBlank(obj.getChannelMerNo())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "渠道商户号不能为空");
        }
        ChannelIndustryDO channelIndustryDO = new ChannelIndustryDO();
        channelIndustryDO.setIndustryCode(obj.getIndustryCode());
        channelIndustryDO.setProductNo(obj.getProductNo());
        if (ChannelKeyEnum.REAL_TIME_BILLING.getValue().equals(obj.getChannelKey())) {
            channelIndustryDO.setChannelKey(ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue());
            Integer realTime = mapper.count(channelIndustryDO);
            if (realTime > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "不能添加银联代付（实时划账）");
            }
        }
        if (ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue().equals(obj.getChannelKey())) {
            channelIndustryDO.setChannelKey(ChannelKeyEnum.REAL_TIME_BILLING.getValue());
            Integer realTime = mapper.count(channelIndustryDO);
            if (realTime > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "不能添加银联代付（事后划账）");
            }
        }

        try {
            obj.setGmtCreate(new Date());
            obj.setUserCreate(userService.getUserContext().getUsername());
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            ChannelIndustryDO tempOb = new ChannelIndustryDO();
            tempOb.setIndustryCode(obj.getIndustryCode());
            tempOb.setProductNo(obj.getProductNo());
            Integer tempCout = mapper.count(tempOb) + 1;
            obj.setRoofPlacement(tempCout.longValue());
            obj.setId(IdGenerate.getId());
            obj.setChannelKey(obj.getChannelKey());
            mapper.create(obj);
        } catch (DataAccessException e) {

            throw new SystemRuntimeException(ErrorCode.BSMSC006, e.toString());
        }
        return obj.getId();
    }

    @Override
    public int delete(Long id) {
        ChannelIndustryDO obj = mapper.getById(id);
        int rest = mapper.delete(id);
        return rest;
    }

    @Override
    public void update(ChannelIndustryDO obj) {
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        mapper.update(obj);
    }

    @Override
    public ChannelIndustryDO getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public PageInfo<ChannelIndustryDO> pageList(Query query) {
        Instant start = Instant.now();
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("roof_placement asc");
        Page<ChannelIndustryDO> page = mapper.pageList(query.getParameters());
        List list = page.stream().map(channelIndustryDO -> {
            IndustryDO industryDO = industryMapper.getByCode(channelIndustryDO.getIndustryCode());
            if (industryDO != null) {
                channelIndustryDO.setIndustryName(industryDO.getName());
            }
            ChannelInfoDO channelInfoDO = channelInfoMapper.getByChannelCode(channelIndustryDO.getChannelCode());
            if (channelInfoDO != null) {
                channelIndustryDO.setChannelName(channelInfoDO.getChannelName());
            }
            PayProductDO payProductDO = payProductMapper.getByCode(channelIndustryDO.getProductNo());
            if (payProductDO != null) {
                channelIndustryDO.setProductName(payProductDO.getName());
            }
            return channelIndustryDO;
        }).collect(Collectors.toList());
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end));
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<ChannelIndustryDO> pageListGroup(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<ChannelIndustryDO> page = mapper.pageListGroup(query.getParameters());
        return new PageInfo<>(page);
    }

    @Override
    public List<ChannelIndustryDO> list(Map<String, Object> params) {
        return mapper.list(params);
    }

    /**
     * 置顶
     *
     * @param
     * @return
     */
    @Override
    public Integer roofPlacement(List arrayId) {
        for (int i = 0; i < arrayId.size(); i++) {
            Long tempId = Long.valueOf(arrayId.get(i).toString());
            ChannelIndustryDO obj = new ChannelIndustryDO();
            obj.setId(tempId);
            Integer count = mapper.count(obj);
            if (count == 0) {
                throw new SystemRuntimeException(ErrorCode.BSMCD102, "id");
            }
            Integer roofId = i + 1;
            mapper.updateRoofPlacement(tempId, roofId.longValue());
        }
        return 1;
    }
}
