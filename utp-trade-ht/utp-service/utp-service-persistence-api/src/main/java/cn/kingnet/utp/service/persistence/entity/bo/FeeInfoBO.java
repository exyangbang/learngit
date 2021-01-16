package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.trade.common.enums.ChargeMode;
import cn.kingnet.utp.trade.common.enums.SettleType;
import lombok.Data;

@Data
public class FeeInfoBO {
    /**
     * 交易金额
     */
    private Long transAmount;
    /**
     * 实际提现金额(交易金额-商户手续费)
     */
    private Long realAmount;
    /**
     * 商户手续费
     */
    private Long merFee;
    /**
     * 商户结算类型(实时、后结)
     */
    private String merSettleType;
    /**
     * 商户收费模式（内扣、外扣）
     */
    private String merChargeMode;
    /**
     * 渠道手续费
     */
    private Long channelFee;
    /**
     * 渠道结算类型(实时、后结)
     */
    private String channelSettleType;
    /**
     * 渠道收费模式（内扣、外扣）
     */
    private String channelChargeMode;

    public static FeeInfoBO buildNoConfigFeeInfoBO(Long transAmount){
        FeeInfoBO feeInfoBO = new FeeInfoBO();
        feeInfoBO.setTransAmount(transAmount);
        feeInfoBO.setRealAmount(transAmount);
        feeInfoBO.setMerFee(0L);
        feeInfoBO.setMerSettleType(SettleType.AFTER_NODE.getType());
        feeInfoBO.setMerChargeMode(ChargeMode.BUCKLE.getMode());
        feeInfoBO.setChannelFee(0L);
        feeInfoBO.setChannelSettleType(SettleType.AFTER_NODE.getType());
        feeInfoBO.setChannelChargeMode(ChargeMode.BUCKLE.getMode());
        return feeInfoBO;
    }
}
