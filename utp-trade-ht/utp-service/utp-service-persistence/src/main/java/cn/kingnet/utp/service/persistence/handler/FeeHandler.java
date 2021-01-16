package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IFeeHandler;
import cn.kingnet.utp.service.persistence.entity.FeeTemplate;
import cn.kingnet.utp.service.persistence.entity.bo.FeeInfoBO;
import cn.kingnet.utp.service.persistence.mapper.FeeTemplateMapper;
import cn.kingnet.utp.service.persistence.support.FeeCalculate;
import cn.kingnet.utp.trade.common.enums.ChargeMode;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.SettleType;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : 手续费服务
 * @Author : linkaigui
 * @Create : 2019/2/25 19:00
 */
@RestController
@RequestMapping("/spi/persistence/feehandler")
@Slf4j
public class FeeHandler extends DefaultFeginExceptionHandler implements IFeeHandler {

    @Resource
    private FeeTemplateMapper feeTemplateMapper;

    /**
     * 计算手续费
     *
     * @param indFeeTemplateId 平台手续费模板Id
     * @param chnFeeTemplateId 渠道手续费模板Id
     * @return
     */
    @PostMapping("calculateFeeByIndustry")
    @Override
    public FeeInfoBO calculateFeeByIndustry(@RequestParam(value = "indFeeTemplateId", required = false) Long indFeeTemplateId, @RequestParam(value = "chnFeeTemplateId", required = false) Long chnFeeTemplateId, @RequestParam(value = "transAmount", required = false) Long transAmount) {
        FeeTemplate merFeeTemplate = feeTemplateMapper.selectById(indFeeTemplateId);
        if (merFeeTemplate == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "代付客户手续费未配置!");
        }

        FeeTemplate channelFeeTemplate = feeTemplateMapper.selectById(chnFeeTemplateId);
        if (channelFeeTemplate == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "渠道手续费未配置!");
        }

        if (transAmount == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "交易金额不能为空!");
        }

        //代付客户手续费计算
        Long merFee = FeeCalculate.compute(transAmount, merFeeTemplate);
        //20191129 业务调整 后结外扣[没有后结内扣] 无需校验发生手续费是否大于本金
        if (!SettleType.AFTER_NODE.getType().equals(merFeeTemplate.getSettleType())) {
            if (transAmount.longValue() <= merFee.longValue()) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "本金应大于手续费金额!");
            }
        }
        FeeInfoBO feeInfoBO = new FeeInfoBO();
        feeInfoBO.setTransAmount(transAmount);
        feeInfoBO.setMerFee(merFee);
        feeInfoBO.setMerChargeMode(merFeeTemplate.getChargeMode());
        feeInfoBO.setMerSettleType(merFeeTemplate.getSettleType());
        //手续费内扣
        if (ChargeMode.INNER.getMode().equals(merFeeTemplate.getChargeMode())) {
            feeInfoBO.setRealAmount(transAmount - merFee);
        } else {
            feeInfoBO.setRealAmount(transAmount);
        }
        //渠道手续费计算
        Long channelFee = FeeCalculate.compute(transAmount, channelFeeTemplate);
        feeInfoBO.setChannelFee(channelFee);
        feeInfoBO.setChannelChargeMode(channelFeeTemplate.getChargeMode());
        feeInfoBO.setChannelSettleType(channelFeeTemplate.getSettleType());
        return feeInfoBO;
    }
}
