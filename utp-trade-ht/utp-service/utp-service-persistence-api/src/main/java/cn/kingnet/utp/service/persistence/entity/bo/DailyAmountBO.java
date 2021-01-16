package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhongli
 * @date 2019-03-20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyAmountBO implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间 注：yyyyMMddHHmmss
     */
    private String time;

    /**
     * id主键累计使用额度;若计算当前剩余可以用额度= fixedAmount - amount
     */
    private long amount = 0L;

    /**
     * 每日交易总限额 | 后管配置
     */
    private long fixedAmount = 0L;

    /**
     * 变动资金，-为减可用额度，+为增可用额度
     */
    private long funds = 0L;

    /**
     * 对私单笔限额 | 后管配置
     */
    private long privateEachLimitAmt;

    /**
     * 对公单笔限额 | 后管配置
     */
    private long publicEachLimitAmt;



}
