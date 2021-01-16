package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.IndustryCondition;
import cn.kingnet.utp.service.persistence.mapper.IndustryMapper;
import cn.kingnet.utp.trade.common.bo.IndustryAccountInfoBo;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.VirtualAccountType;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/23
 */
@Service
@Slf4j
public class IndustryService {

    /**
     * 排除掉 pic图片字段
     *
     * @return
     */
    private Column[] selectIndustryColumn() {
        List<Column> columnList = SqlHelper.table(Industry.class).getFieldList().stream().map(i -> Column.create().column(i.getColumn()))
                .filter(col -> !col.getColumn().toLowerCase().endsWith("_pic"))
                .collect(Collectors.toList());
        columnList.add(Column.create().column("ID"));
        return columnList.toArray(new Column[0]);
    }


    public List<Industry> selectList(PlusEntityWrapper<Industry> industryPlusEntityWrapper) {
        return MybatisDaoImpl.run().selectList(industryPlusEntityWrapper.setSqlSelect(this.selectIndustryColumn()));
    }

    public Industry selectOne(PlusEntityWrapper<Industry> industryPlusEntityWrapper) {
        return MybatisDaoImpl.run().selectOne(industryPlusEntityWrapper.setSqlSelect(selectIndustryColumn()));
    }

    public Industry selectOne(PlusEntityWrapper<Industry> industryPlusEntityWrapper, boolean excludePic) {
        if (excludePic) {
            return selectOne(industryPlusEntityWrapper);
        }
        return MybatisDaoImpl.run().selectOne(industryPlusEntityWrapper);
    }

    /**
     * 获取子账户归属的 平台客户信息 [业务规定 线上查找必定唯一]
     *
     * @param subAccount
     * @return
     */
    public Industry getIndustryBySubAccount(String subAccount) {
        Assert.hasText(subAccount, () -> "参数 subAccount 不能为空");
        Map<String, String> params = new HashMap<>(4);
        params.put("subAccount", subAccount);
        List<Industry> industryList = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("getIndustryBySubAccount", params);
        Industry platformIndustry = null;
        if (!CollectionUtils.isEmpty(industryList)) {
            if (industryList.size() > 1) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "二级子账户至多被一个客户平台关联");
            }
            platformIndustry = industryList.get(0);
        }
        return platformIndustry;
    }

    /**
     * 获取 功能账户 的基础信息，主要是实体账户
     *
     * @param functionAccount
     * @return
     */
    public Industry getIndustryByFunctionAccount(String functionAccount) {
        Assert.hasText(functionAccount, () -> "参数 functionAccount 不能为空");
        PlusEntityWrapper<Industry> plusEntityWrapper = IndustryCondition.builder().andAccountEq(functionAccount).build();
        Industry functionIndustry = selectOne(plusEntityWrapper);
        Industry platformIndustry = null;
        if (functionIndustry != null) {
            VirtualAccountType industryType = VirtualAccountType.resolve(functionIndustry.getIndustryType());
            IndustryCondition condition = IndustryCondition.builder();
            switch (industryType) {
                case INDUSTRY: {
                    condition = null;
                    platformIndustry = functionIndustry;
                    break;
                }
                case FEEINCOME: {
                    condition.andProcessingFeeIncomeAccountEq(functionIndustry.getId());
                    break;
                }
                case FEEOUTCOME: {
                    condition.andFeeExpenditureAccountEq(functionIndustry.getId());
                    break;
                }
                case COLLECTION: {
                    condition.andCollectionIndustryIdEq(functionIndustry.getId());
                    break;
                }
                case AUTHOUTCOME: {
                    condition.andAuthPaymentAccountIdEq(functionIndustry.getId());
                    break;
                }
                default: {
                    condition = null;
                    log.error("暂不支持的 功能账户[{}]类型[{}:{}]", functionAccount, industryType.getType(), industryType.getDesc());
                }
            }
            if (condition != null) {
                //业务上可能存在不合理的，功能账户可能会被多个平台账户关联使用.
                //  注意：目前业务确认开放的功能账户手续费支出和小额打款仅能被某个平台关联
                List<Industry> industryList = selectList(condition.build());
                if (!CollectionUtils.isEmpty(industryList)) {
                    if (industryList.size() > 1) {
                        String linkedIndustryStr = industryList.stream().map(i -> String.format("%s:%s", i.getCode(), i.getName()))
                                .collect(Collectors.joining(","));
                        log.error("[{}:{}]功能账户至多被一个客户平台关联[]", functionAccount, industryType.getDesc(), linkedIndustryStr);
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "功能账户至多被一个客户平台关联");
                    }
                    platformIndustry = industryList.get(0);
                }
            }
        }
        return platformIndustry;


    }

    /**
     * 获取该客户号下 关联 功能账户的 汇款（来款）账户
     *
     * @param industryCode
     * @return
     */
    public Multimap<String, String> selectFunctionAccountRemitterMap(String industryCode) {
        Assert.hasText(industryCode, () -> "参数 industryCode 不能为空");
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("industryCode", industryCode);
        List<IndustryAccountInfoBo> boList = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("selectFunctionAccountRemitterList", paramsMap);
        Multimap<String, String> functionAccountRemitterMultimap = HashMultimap.create();
        if (!CollectionUtils.isEmpty(boList)) {
            boList.stream().forEach(bo -> {
                functionAccountRemitterMultimap.put(bo.getAccount(), bo.getAccountNo());
            });
        }
        return functionAccountRemitterMultimap;
    }
}
