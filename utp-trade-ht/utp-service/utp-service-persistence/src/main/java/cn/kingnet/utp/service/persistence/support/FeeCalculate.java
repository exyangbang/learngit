package cn.kingnet.utp.service.persistence.support;

import cn.kingnet.utp.service.persistence.entity.FeeTemplate;
import cn.kingnet.utp.service.persistence.vo.FeeTemplateIntervalVo;
import cn.kingnet.utp.trade.common.enums.CalculateMode;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @Description : 手续费计算类
 * @Author : linkaigui
 * @Create : 2019/2/25 18:59
 */
public class FeeCalculate {

    public static Long compute(Long transAmount, FeeTemplate feeTemplate) {
        CalculateMode calculateMode = CalculateMode.getCalculateByMode(feeTemplate.getCalculateMode());
        switch (calculateMode) {
            case MODE1:
                return FixQuotaBiFunction.apply(transAmount, feeTemplate);
            case MODE2:
                return FixRateBiFunction.apply(transAmount, feeTemplate);
            case MODE3:
                return IntervalBiFunction.apply(transAmount, feeTemplate);
            default:
                return Long.valueOf(0L);
        }
    }

    /**
     * 1.按笔定额
     */
    public static final BiFunction<Long, FeeTemplate, Long> FixQuotaBiFunction = (transAmount, feeTemplate) -> feeTemplate.getFee() == null ? Long.valueOf(0L) : feeTemplate.getFee();

    /**
     * 2.按固定费率
     */
    public static final BiFunction<Long, FeeTemplate, Long> FixRateBiFunction = (transAmount, feeTemplate) -> {
        if (transAmount.longValue() == 0) return Long.valueOf(0L);
        Long feeRate = feeTemplate.getFee(); //费率

        long fee = 0L;
        //有配置费率情况根据费率计算手续费
        if (feeRate != null && feeRate.longValue() >= 0){
            fee = BigDecimal.valueOf(transAmount).multiply(BigDecimal.valueOf(feeRate).divide(new BigDecimal(100000))).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        }

        //如果小于最低手续费，取最低手续费
        fee = feeTemplate.getMinFee() != null && fee < feeTemplate.getMinFee().longValue() ? feeTemplate.getMinFee().longValue() : fee;

        //如果大于最高手续费，取最高手续费
        fee = feeTemplate.getMaxFee() != null && fee > feeTemplate.getMaxFee().longValue() ? feeTemplate.getMaxFee().longValue() : fee;

        return Long.valueOf(fee);
    };

    /**
     * 3.按笔定额-区间
     */
    public static final BiFunction<Long, FeeTemplate, Long> IntervalBiFunction = (transAmount, feeTemplate) -> {
        String content = feeTemplate.getContent();
        if (StringUtil.isBlank(content)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("手续费模板 '%s' 未设置区间", feeTemplate.getName()));
        }
        List<FeeTemplateIntervalVo> feeTemplateIntervalVoList = JSONArray.parseArray(content, FeeTemplateIntervalVo.class);
        if (feeTemplateIntervalVoList == null || feeTemplateIntervalVoList.isEmpty()) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("手续费模板 '%s' 未设置区间", feeTemplate.getName()));
        }

        Optional<FeeTemplateIntervalVo> feeTemplateIntervalOptional = feeTemplateIntervalVoList.stream().filter(intervalVo -> intervalVo.getFirstSection() <= transAmount.longValue() && transAmount.longValue() < intervalVo.getSecondSection()).findFirst();

        if (!feeTemplateIntervalOptional.isPresent()) return Long.valueOf(0L);

        FeeTemplateIntervalVo feeTemplateIntervalVo = feeTemplateIntervalOptional.get();

        if("amount".equals(feeTemplateIntervalVo.getType())){
            return feeTemplateIntervalVo.getPriceSection() == null ? Long.valueOf(0L) : feeTemplateIntervalVo.getPriceSection();
        }

        Long feeRate = feeTemplateIntervalVo.getPriceSection(); //费率
        if (feeRate != null && feeRate.longValue() >= 0){
            return BigDecimal.valueOf(transAmount).multiply(BigDecimal.valueOf(feeRate).divide(new BigDecimal(100000))).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        }

        return Long.valueOf(0L);
    };
}
