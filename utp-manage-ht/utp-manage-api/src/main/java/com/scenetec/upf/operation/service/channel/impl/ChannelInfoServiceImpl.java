package com.scenetec.upf.operation.service.channel.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.ChannelKeyEnum;
import com.scenetec.upf.operation.model.Enum.FundResourceEnum;
import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelInfoDO;
import com.scenetec.upf.operation.model.vo.ChannelInfoVO;
import com.scenetec.upf.operation.model.vo.RefreshRedisDTO;
import com.scenetec.upf.operation.repository.channel.ChannelIndustryMapper;
import com.scenetec.upf.operation.repository.channel.ChannelInfoMapper;
import com.scenetec.upf.operation.repository.channel.ChannelMerchantMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.service.channel.ChannelInfoService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.RefreshOnlineTool;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/05
 */
@Service
public class ChannelInfoServiceImpl implements ChannelInfoService {

    Logger logger = LoggerFactory.getLogger(ChannelInfoServiceImpl.class);

    @Resource
    ChannelInfoMapper mapper;

    @Resource
    ChannelMerchantMapper cmMapper;

    @Resource
    ChannelIndustryMapper ciMapper;

    @Resource
    IndustryMapper industryMapper;

    @Resource
    UserService userService;

    @Resource
    RefreshOnlineTool refreshOnlineTool;

    @Override
    @Transactional
    public ChannelInfoDO create(ChannelInfoVO channelInfoVO) {
        ChannelInfoDO obj = new ChannelInfoDO();
        BeanUtils.copyProperties(channelInfoVO, obj);
        try {
            if (ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue().equals(obj.getChannelKey()) ||
                    ChannelKeyEnum.REAL_TIME_BILLING.getValue().equals(obj.getChannelKey())) {
                if (StringUtils.isBlank(obj.getChannelMerNo())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "银联商户号不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerName())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户名称不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerategory())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户类别不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerShortName())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户简称不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelCapitalSource())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "资金来源不能为空");
                }
                if (!FundResourceEnum.contains(obj.getChannelCapitalSource())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006,"资金来源类型错误");
                }
                if (StringUtils.isBlank(obj.getChannelMerNameDec())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "银联渠道名称备注不能为空");
                }
            }
            obj.setGmtCreate(new Date());
            obj.setUserCreate(userService.getUserContext().getUsername());
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            obj.setId(IdGenerate.getId());
            mapper.create(obj);
        } catch (DataAccessException e) {
            logger.error("渠道信息新增异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMCD001);
        }
        return obj;
    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        ChannelInfoDO obj = mapper.getById(id);
        ChannelIndustryDO cmObj = new ChannelIndustryDO();
        cmObj.setChannelCode(obj.getChannelCode());
        Integer num = ciMapper.count(cmObj);
        if (num != 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCD002);
        }

        RefreshRedisDTO.ChannelLimitAmountVO channelLimitAmountVO = new RefreshRedisDTO.ChannelLimitAmountVO();
        channelLimitAmountVO.setChannelCode(obj.getChannelCode());
        channelLimitAmountVO.setLimitTotalAmount(Long.parseLong(obj.getAmount()));
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setChannelLimitAmountVO(channelLimitAmountVO);
        refreshRedisDTO.setOperateType("3");
        refreshOnlineTool.RefreshQuato("01", refreshRedisDTO);
        return mapper.delete(id);
    }

    @Override
    @Transactional
    public void update(ChannelInfoVO channelInfoVO) {
        ChannelInfoDO obj = new ChannelInfoDO();
        BeanUtils.copyProperties(channelInfoVO, obj);
        try {
            if (ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue().equals(obj.getChannelKey()) ||
                    ChannelKeyEnum.REAL_TIME_BILLING.getValue().equals(obj.getChannelKey())) {
                if (StringUtils.isBlank(obj.getChannelMerNo())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "银联商户号不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerName())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户名称不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerategory())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户类别不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelMerShortName())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "商户简称不能为空");
                }
                if (StringUtils.isBlank(obj.getChannelCapitalSource())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "资金来源不能为空");
                }
                if (!FundResourceEnum.contains(obj.getChannelCapitalSource())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006,"资金来源类型错误");
                }
                if (StringUtils.isBlank(obj.getChannelMerNameDec())) {
                    throw new SystemRuntimeException(ErrorCode.BSMSC006, "银联渠道名称备注不能为空");
                }
            }
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            mapper.update(obj);
            ChannelIndustryDO channelIndustryDO = new ChannelIndustryDO();
            channelIndustryDO.setChannelCode(obj.getChannelCode());
            channelIndustryDO.setChnFeeTemplateId(obj.getChnFeeTemplateId());
            ciMapper.updateChannelFee(channelIndustryDO);
            //修改额度通知联机
            updateToOnlineReuqest(obj, "0");

        } catch (DataAccessException e) {
            throw new SystemRuntimeException(ErrorCode.BSMCD001);
        }
    }

    @Override
    public ChannelInfoDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return mapper.getById(id);
    }

    @Override
    public PageInfo<ChannelInfoDO> pageList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<ChannelInfoDO> page = mapper.pageList(query.getParameters());
        return new PageInfo<>(page);
    }


    @Override
    public List<ChannelInfoDO> list(Map<String, Object> parameters) {
        return mapper.list(parameters);
    }

    /**
     * 1.代付客户管理，添加关联--》 过滤已经被选过的渠道
     * 2.获取商户号列表  --》 银联代付（事后划账）
     *
     * @param
     * @return
     */
    @Override
    public List<ChannelInfoDO> filterList(Query querys) {

        Map map = querys.getParameters();
        List<ChannelInfoDO> list = mapper.filterList(querys.getParameters());
        if (!map.containsKey("channelKey") || StringUtils.isBlank(map.get("channelKey").toString())) {//获取渠道的列表
            List<ChannelInfoDO> tempList = new ArrayList<>();
            //如果选过银联代付（事后划账）则过滤 银联代付（实时划账）
            //如果选过银联代付（实时划账）则过滤 银联代付（事后划账）
            ChannelIndustryDO channelIndustryDO = new ChannelIndustryDO();
            channelIndustryDO.setChannelKey(ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue());
            channelIndustryDO.setIndustryCode(map.get("industryCode").toString());
            Integer aftRes = ciMapper.count(channelIndustryDO);
            channelIndustryDO.setChannelKey(ChannelKeyEnum.REAL_TIME_BILLING.getValue());
            Integer brfRes = ciMapper.count(channelIndustryDO);
            for (int i = 0; i < list.size(); i++) {
                ChannelInfoDO channelInfoDO = list.get(i);
                if (aftRes != 0 && ChannelKeyEnum.REAL_TIME_BILLING.getValue().equals(channelInfoDO.getChannelKey())) {
                    continue;
                }
                if (brfRes != 0 && ChannelKeyEnum.AFTERWARDS_PAYMENT.getValue().equals(channelInfoDO.getChannelKey())) {
                    continue;
                }
                tempList.add(channelInfoDO);
            }
            return tempList;
        }


        return list;
    }

    /**
     * 渠道商户号列表
     *
     * @param query
     * @return
     */
    @Override
    public List<ChannelInfoDO> channelMerNoList(Query query) {
        List<ChannelInfoDO> list = mapper.channelMerNoList(query.getParameters());
        return list;
    }

    /**
     * 操作类型：1:新增 0:修改 3:删除
     */
    @Override
    public void updateToOnlineReuqest(ChannelInfoDO obj, String operateType) {
        RefreshRedisDTO.ChannelLimitAmountVO channelLimitAmountVO = new RefreshRedisDTO.ChannelLimitAmountVO();
        channelLimitAmountVO.setChannelCode(obj.getChannelCode());
        channelLimitAmountVO.setLimitTotalAmount(Long.parseLong(obj.getAmount()));
        RefreshRedisDTO refreshRedisDTO = new RefreshRedisDTO();
        refreshRedisDTO.setChannelLimitAmountVO(channelLimitAmountVO);
        refreshRedisDTO.setOperateType(operateType);
        refreshOnlineTool.RefreshQuato("01", refreshRedisDTO);
    }


}
