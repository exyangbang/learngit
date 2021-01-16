package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.trade.common.enums.TradeType;
import lombok.*;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @Description 清算日期|客户号（平台编号）|用户账号|客户端流水号|服务端流水号|批次号|交易日期|交易时间|交易类型|
 * 收款人账号|交易状态|交易金额|交易手续费|流水标志
 * @Author WJH
 * @Date 2020/08/07
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IndustryDSpecialReconFileBO implements Serializable {
    private String reconcileDate;
    private String industryCode;
    private String userAccount;
    private String clientTransId;
    private String serverTransId;
    private String batchId;
    private String transDate;
    private String transTime;
    private String tradeType;
    private String payeeUserAccount;
    private String payeeAcctNo;
    private String transStatus;
    private String transAmount;
    private long merFee;
    /**
     * 0-正常（实时明确交易结果的流水）
     * 1-对账差错（对账后调整交易状态的差错流水）
     * 2-退汇流水
     */
    private String flag;

    @Override
    public String toString() {
        //清算日期|客户号（平台编号）|用户账号|客户端流水号|服务端流水号|批次号|交易日期|交易时间|交易类型|收款人账号|交易状态|交易金额|交易手续费|流水标志
        return new StringJoiner("|").setEmptyValue("")
                .add(trimEmpty(reconcileDate))
                .add(trimEmpty(industryCode))
                .add(getUserAccount())
                .add(trimEmpty(clientTransId))
                .add(trimEmpty(serverTransId))
                .add(trimEmpty(batchId))
                .add(trimEmpty(transDate))
                .add(trimEmpty(transTime))
                .add(trimEmpty(tradeType))
                .add(trimEmpty(payeeAcctNo))
                .add(trimEmpty(transStatus))
                .add(trimEmpty(transAmount))
                .add(String.valueOf(merFee))
                .add(trimEmpty(flag)).toString();

    }

    private String trimEmpty(String val) {
        return val == null ? "" : val.trim();
    }

    private String getUserAccount() {
        if (TradeType.WITHDRAW.name().equals(tradeType)) {
            return trimEmpty(payeeUserAccount);
        }
        return trimEmpty(userAccount);
    }

}
