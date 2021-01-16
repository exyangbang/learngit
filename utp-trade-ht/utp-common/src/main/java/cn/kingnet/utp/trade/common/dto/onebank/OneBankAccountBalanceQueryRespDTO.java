package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 一般户：资金账户余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/16 15:04
 */
@Setter
@Getter
@NoArgsConstructor
public class OneBankAccountBalanceQueryRespDTO extends SpBaseResponse implements Serializable {
    private String productId;
    private String currentRunningBal;
    private String accualinterestAmount;
    private String accountType;
    private String accountSerialNo;
    private String interestAmount;
    private String opendate;
    private String depositTerm;
    private Double availableBalance;
    private String openBranchCode;
    private String custAccountNo;
    private String accountStatus;
    private String lastBalance;
    private String minReservBalance;
    private String fixedCurrentFlag;
    private String interestTaxAmount;
    private String cashOrRemitFlag;
    private String accountNo;
    private String holdAmount;
    private String custNumber;
    private String openBranchName;
    private String currencyCode;

}
