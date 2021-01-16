package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfoCondition;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfoCondition;
import cn.kingnet.utp.service.persistence.mapper.MerchantInfoMapper;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.enums.AccountStatus;
import cn.kingnet.utp.trade.common.enums.BindCardStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author WJH
 * @Date 2020/02/23
 */
@Service
@Slf4j
public class MerchantInfoService {

    /**
     * subAccount -> merchantInfoBO 默认缓存1min后失效
     */
    private Cache<String, MerchantInfoBo> merchantInfoBoCache = CacheBuilder.newBuilder().expireAfterWrite(20, TimeUnit.SECONDS).build();

    /**
     * 排除掉 pic图片字段
     *
     * @return
     */
    private Column[] selectIndustryColumn() {
        return SqlHelper.table(MerchantInfo.class).getFieldList().stream().map(i -> Column.create().column(i.getColumn()))
                .filter(col -> !col.getColumn().toLowerCase().endsWith("_pic")).toArray(Column[]::new);
    }

    private List<MerchantInfo> selectList(PlusEntityWrapper<MerchantInfo> plusEntityWrapper) {
        return MybatisDaoImpl.run().selectList(plusEntityWrapper.setSqlSelect(this.selectIndustryColumn()));
    }

    public List<MerchantInfo> selectList(PlusEntityWrapper<MerchantInfo> plusEntityWrapper, boolean excludePic) {
        if (excludePic) {
            return selectList(plusEntityWrapper);
        }
        return MybatisDaoImpl.run().selectList(plusEntityWrapper);
    }

    public MerchantInfo selectOne(PlusEntityWrapper<MerchantInfo> plusEntityWrapper) {
        return MybatisDaoImpl.run().selectOne(plusEntityWrapper.setSqlSelect(selectIndustryColumn()));
    }

    public MerchantInfo selectOne4AllNature(String userAccount) {
        PlusEntityWrapper<MerchantInfo> plusEntityWrapper = MerchantInfoCondition.builder().andAccountEq(userAccount).orSettleAccountEq(userAccount).build();
        return selectOne(plusEntityWrapper);
    }

    public MerchantInfo selectOne(PlusEntityWrapper<MerchantInfo> plusEntityWrapper, boolean excludePic) {
        if (excludePic) {
            return selectOne(plusEntityWrapper);
        }
        return MybatisDaoImpl.run().selectOne(plusEntityWrapper);
    }

    /**
     * 查询还未解绑的账户数量
     *
     * @param userAccount
     * @return
     */
    public Integer getUnBindMerchantAccountCount(String userAccount) {
        return MybatisDaoImpl.run().selectCount(MerchantAccountInfoCondition.builder().andAccountEq(userAccount).andBindStatusNe(BindCardStatus.UN_BIND.getStatus()).build());
    }

    public MerchantInfoBo getMerchantInfoBo(String subAccount, boolean cacheAble) {
        Assert.hasText(subAccount, () -> "参数 subAccount 不能为空");
        MerchantInfoBo merchantInfoBo = null;

        try {
            if (cacheAble) {
                merchantInfoBo = merchantInfoBoCache.get(subAccount, () -> this.getMerchantInfoBo(subAccount));
            } else {
                merchantInfoBo = this.getMerchantInfoBo(subAccount);
            }
        } catch (ExecutionException e) {
            log.error("getMerchantInfoBo({})异常:{}", subAccount, e.getMessage(), e);
        }

        return merchantInfoBo;
    }

    private MerchantInfoBo getMerchantInfoBo(String subAccount) {
        Map<String, String> params = new HashMap<>(4);
        params.put("subAccount", subAccount);
        List<MerchantInfoBo> merchantInfoBos = MybatisDaoImpl.of(MerchantInfoMapper.class).selectListBySql("getMerchantInfoBo", params);
        if (!CollectionUtils.isEmpty(merchantInfoBos)) {
            return merchantInfoBos.get(0);
        }
        return null;
    }

    public MerchantInfo getMerchantInfoByUserAccount(String industryCode, String userAccount) {
        Assert.hasText(industryCode, () -> "industryCode 参数不能为空");
        Assert.hasText(userAccount, () -> "userAccount 参数不能为空");
        PlusEntityWrapper<MerchantInfo> condition = MerchantInfoCondition.builder().andAccountEq(userAccount).andStatusNe(AccountStatus.CANCEL.getCode()).build();
        List<MerchantInfo> merchantInfoList = this.selectList(condition, false);
        if (merchantInfoList != null && merchantInfoList.size() > 1) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "数据异常：存在多个虚拟账户[" + userAccount + "]");
        }

        if (CollectionUtils.isEmpty(merchantInfoList)) {
            PlusEntityWrapper<MerchantInfo> settleCondition = MerchantInfoCondition.builder().andSettleAccountEq(userAccount).andStatusNe(AccountStatus.CANCEL.getCode()).build();
            merchantInfoList = this.selectList(settleCondition, false);
            if (merchantInfoList != null && merchantInfoList.size() > 1) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "数据异常：存在多个待结算账户[" + userAccount + "]");
            }
        }

        MerchantInfo merchantInfo = CollectionUtils.isEmpty(merchantInfoList) ? null : merchantInfoList.get(0);
        if (merchantInfo != null && !StringUtil.equals(industryCode, merchantInfo.getIndustryCode())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("已存在虚拟账户[%s]但非该平台[%s]开户", userAccount, industryCode));
        }

        return merchantInfo;
    }
}
