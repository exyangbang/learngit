package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 渠道日交易限额
 *
 * @author zhongli
 * @date 2019-03-20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelAmountLimitBO implements Serializable {
    /**
     * 渠道编码
     */
    private String channelCode;
    /**
     * 创建时间 注：yyyyMMdd
     */
    private String date;

    /**
     * id主键累计交易金额;若计算当前剩余可以用额度= dailyLimitTotalAmount - accumulateAmount
     */
    private long accumulateAmount ;

    /**
     * 每日交易总限额 | 后管配置
     */
    private long dailyLimitTotalAmount ;

    /**
     * 变动资金，-为减可用额度，+为增可用额度
     */
    private long transAmount ;

}
