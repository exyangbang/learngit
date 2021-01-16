package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IIndustryAmtLimitHandler;
import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimit;
import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimitCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/spi/persistence/industryAmtLimitHandler")
@Slf4j
public class IndustryAmtLimitHandler extends DefaultFeginExceptionHandler implements IIndustryAmtLimitHandler {

    /**
     * 平台客户 相同订单最大分账数：本地缓存默认5min失效
     */
    private static Cache<String, Integer> sameOrderMaxSplitNumCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();

    @Override
    public IndustryAmtLimit findIndustryAmtLimitByIndustryCode(String industryCode) {
        Assert.hasText(industryCode, () -> "客户号不能为空");
        return MybatisDaoImpl.run().selectOne(IndustryAmtLimitCondition.builder().andIndustryCodeEq(industryCode).build());
    }

    @Override
    public Integer findSameOrderMaxSplitNum(String industryCode) {
        Assert.hasText(industryCode, () -> "客户号不能为空");
        Integer resInt = 5;
        try {
            resInt = sameOrderMaxSplitNumCache.get(industryCode, () -> {
                IndustryAmtLimit industryAmtLimit = MybatisDaoImpl.run().selectOne(IndustryAmtLimitCondition.builder().andIndustryCodeEq(industryCode).build());
                if (null != industryAmtLimit && null != industryAmtLimit.getSameOrderMaxSpeAmt()) {
                    return Integer.valueOf(industryAmtLimit.getSameOrderMaxSpeAmt());
                }
                return 5;
            });
        } catch (ExecutionException e) {
            log.error("findSameOrderMaxSplitNum 异常:{}", e.getMessage(), e);
        }
        return resInt;
    }
}
