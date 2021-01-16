package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.*;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @Description
 * @Author WJH
 * @Date 2020/08/07
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IndustrySubAccountDailyBalanceReconFileBO implements Serializable {
    private String reconcileDate;
    private String industryCode;
    private String account;
    private String objType;
    private String objCode;
    private String objName;
    private Long balance;
    private Long availAmount;
    private Long frozenAmount;
    private String status;
    private Long version;


    @Override
    public String toString() {
        //交易日期|客户号（平台编号）|用户账号|账户余额|冻结金额|可用余额
        //金额单位分
        return new StringJoiner("|").setEmptyValue("")
                .add(trimEmpty(reconcileDate))
                .add(trimEmpty(industryCode))
                .add(trimEmpty(account))
                .add(trimEmpty(balance))
                .add(trimEmpty(frozenAmount))
                .add(trimEmpty(availAmount)).toString();

    }

    private String trimEmpty(String val) {
        return val == null ? "" : val.trim();
    }

    private String trimEmpty(Long val) {
        return val == null ? "0" : String.valueOf(val.longValue());
    }

}
