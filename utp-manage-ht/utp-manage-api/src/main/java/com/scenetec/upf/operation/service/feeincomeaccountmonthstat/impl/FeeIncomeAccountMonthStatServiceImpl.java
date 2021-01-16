package com.scenetec.upf.operation.service.feeincomeaccountmonthstat.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.CollectionStatusEnum;
import com.scenetec.upf.operation.model.Enum.TransStatusEnum;
import com.scenetec.upf.operation.model.domain.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatDO;
import com.scenetec.upf.operation.model.vo.QueryFeeIncomeAccountCollectionReqDTO;
import com.scenetec.upf.operation.model.vo.QueryFeeIncomeAccountCollectionRespDTO;
import com.scenetec.upf.operation.repository.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatMapper;
import com.scenetec.upf.operation.service.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Service
public class FeeIncomeAccountMonthStatServiceImpl implements FeeIncomeAccountMonthStatService {

    @Resource
    FeeIncomeAccountMonthStatMapper mapper;
    @Resource
    UserService userService;
    @Resource
    OnlineRequestTool onlineRequestTool;
    //重新归集
    @Value("${withdraw.cas.feeIncomeAccountMonthStat.url}")
    private String feeIncomeAccountMonthStat;
    //重新归集划转
    @Value("${withdraw.cas.feeIncomeAccountMonthCollection.url}")
    private String feeIncomeAccountMonthCollection;
    //查询结果
    @Value("${withdraw.cas.queryFeeIncomeAccountMonthCollection.url}")
    private String queryFeeIncomeAccountMonthCollection;


    /**
     * 重新归集
     * 查询手续费归集明细，针对划账失败和需要人工处理的可以发起重新归集和重新划转
     *
     * @param
     */
    @Override

    public void feeIncomeAccountMonthStat(List<String> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                Long tid = Long.valueOf(list.get(i));
                reAggregation(tid);
            }
        } catch (DataAccessException e) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "重新归集错误");
        }

    }

    @Transactional
    public void reAggregation(Long tid) {
        FeeIncomeAccountMonthStatDO temStatDo = mapper.getById(tid);
        if (temStatDo == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "该笔归集信息不存在");
        }
        if (TransStatusEnum.PROCESSING.getValue().equals(temStatDo.getTransStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "处理中不能重复发起");
        }
        if (TransStatusEnum.TRADE_SUCCESS.getValue().equals(temStatDo.getTransStatus())
                || "1".equals(temStatDo.getCollectionStatus())) {//已划账
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "已划账不能重复发起");
        }
        MultiValueMap<String, String> temMap = new LinkedMultiValueMap<>();
        temMap.add("account", temStatDo.getAccount());
        temMap.add("statMonth", temStatDo.getStatMonth());
        onlineRequestTool.postResquestCollection(feeIncomeAccountMonthStat, temMap);
        try {
            FeeIncomeAccountMonthStatDO updaeFeeDo = new FeeIncomeAccountMonthStatDO();
            updaeFeeDo.setGmtModified(new Date());
            updaeFeeDo.setUserModified(userService.getUserContext().getUsername());
            updaeFeeDo.setId(tid);
            mapper.update(updaeFeeDo);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "重新归集失败");
        }

    }

    /**
     * 重新归集划转
     * 查询手续费归集明细，针对划账失败和需要人工处理的可以发起重新归集和重新划转
     *
     * @param
     */
    @Override
    public void feeIncomeAccountMonthCollection(List<String> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                Long tid = Long.valueOf(list.get(i));
                reCentralizationAndTransfer(tid);
            }
        } catch (DataAccessException e) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "重新归集划转错误");
        }

    }

    @Transactional
    public void reCentralizationAndTransfer(Long tid) {
        FeeIncomeAccountMonthStatDO temStatDo = mapper.getById(tid);
        if (temStatDo == null) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "该笔归集信息不存在");
        }
        if (TransStatusEnum.PROCESSING.getValue().equals(temStatDo.getTransStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, temStatDo.getAccount() + ":处理中不能重复发起");
        }
        if (TransStatusEnum.TRADE_SUCCESS.getValue().equals(temStatDo.getTransStatus())
                || "1".equals(temStatDo.getCollectionStatus())) {//已划账
            throw new SystemRuntimeException(ErrorCode.BSMSC006, temStatDo.getAccount() + ":已划账不能重复发起");
        }
        MultiValueMap<String, String> temMap = new LinkedMultiValueMap<>();
        temMap.add("feeStatId", temStatDo.getId().toString());
        onlineRequestTool.postResquestCollection(feeIncomeAccountMonthCollection, temMap);
        try {
            FeeIncomeAccountMonthStatDO updaeFeeDo = new FeeIncomeAccountMonthStatDO();
            updaeFeeDo.setGmtModified(new Date());
            updaeFeeDo.setUserModified(userService.getUserContext().getUsername());
            updaeFeeDo.setId(tid);
            mapper.update(updaeFeeDo);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "重新归集划转失败");
        }

    }

    /**
     * 归集查询
     *
     * @param id
     * @return
     */
    @Override
    public QueryFeeIncomeAccountCollectionRespDTO queryFeeIncomeAccountMonthCollection(Long id) {
        FeeIncomeAccountMonthStatDO temStatDo = mapper.getById(id);
        if (StringUtils.isBlank(temStatDo.getServerTransId())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "服务端流水号为空不能发起查询");
        }
        if (StringUtils.isBlank(temStatDo.getAccount())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "手续费收益账户号为空不能发起查询");
        }
        String reqDate = DateUtilities.formatDate(new Date(), "yyyyMMdd");
        String reqTime = DateUtilities.formatDate(new Date(), "HHmmss");
        QueryFeeIncomeAccountCollectionReqDTO reqDTO = new QueryFeeIncomeAccountCollectionReqDTO();
        reqDTO.setReqDate(reqDate);
        reqDTO.setReqTime(reqTime);
        reqDTO.setClientTransId(IdGenerate.getIdStr());
        reqDTO.setAccount(temStatDo.getAccount());
        reqDTO.setOrigServerTradeId(temStatDo.getServerTransId());
        try {
            reqDTO.setSign(SHA1.genWithAmple(reqDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        QueryFeeIncomeAccountCollectionRespDTO respDTO = onlineRequestTool.queryFeeIncomeAccountCollectionResquest(queryFeeIncomeAccountMonthCollection, reqDTO);
        return respDTO;

    }

    /**
     * 人工核查
     * collection_status == 9 --》人工核查，通过人工确认
     * 修改
     * collection_status=1
     * trans_status = TRADE_SUCCESS
     * remark 备注说明
     *
     * @param feeIncomeAccountMonthStatDO
     */
    @Override
    public void feeManualVerification(FeeIncomeAccountMonthStatDO feeIncomeAccountMonthStatDO) {
        FeeIncomeAccountMonthStatDO tempfee = new FeeIncomeAccountMonthStatDO();
        tempfee.setId(feeIncomeAccountMonthStatDO.getId());
        tempfee.setCollectionStatus(CollectionStatusEnum.TRANSFERRED.getValue());//已划转
        tempfee.setRemark(feeIncomeAccountMonthStatDO.getRemark());//备注
        tempfee.setTransStatus(TransStatusEnum.TRADE_SUCCESS.getValue());//交易状态
        tempfee.setGmtModified(new Date());
        tempfee.setUserModified(userService.getUserContext().getUsername());
        mapper.update(tempfee);
    }

    @Override
    public PageInfo<FeeIncomeAccountMonthStatDO> list(Query query) {
        try {
            query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
            query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
            PageHelper.startPage(query.getPageNo(), query.getPageSize());
            PageHelper.orderBy("gmt_modified desc");
            Map parMap = query.getParameters();
            Page<FeeIncomeAccountMonthStatDO> page = mapper.pageList(parMap);
            return new PageInfo<>(page);
        } catch (Exception e) {
            System.out.println(e);
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "数据获取失败");
        }
    }

    @Override
    public Map<String, Long> countSumCollect(Map<String, Object> parameters) {
        try {
            Map map = mapper.countSumCollect(parameters);
            Long incomeAmount = Long.valueOf(map.get("incomeAmount").toString());
            Long outcomeAmount = Long.valueOf(map.get("outcomeAmount").toString());
            Long totalAmount = incomeAmount - outcomeAmount;
            map.put("totalAmount", totalAmount);
            return map;
        } catch (Exception e) {
            System.out.println(e);
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "数据获取失败");
        }

    }
}
