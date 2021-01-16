package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 内部户：资金账户余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/16 15:04
 */
@Setter
@Getter
@NoArgsConstructor
public class OneBankInnerAccountBalanceQueryRespDTO extends SpBaseResponse implements Serializable {

    /**
     * 待销账序号
     */
    private String suspendBillNumber;

    /**
     * 账号 Y
     */
    private String subaccount;

    /**
     * 户名 Y
     */
    private String accountName;
    /**
     * 科目 Y
     */
    private String businessCode;
    /**
     * 账户营业机构 Y
     */
    private String accountBranchCode;

    /**
     * 待销业务种类 1-一次核销 2-多次核销
     */
    private String suspendedBillType;
    /**
     * 待销账存入方式 0-多次存入 1-一次存入
     */
    private String suspendBillDepositMode;
    /**
     * 余额方向	string	1		0-借方 1-贷方
     */
    private String balanceDirection;
    /**
     * 货币代号	string	3
     */
    private String currencyCode;
    /**
     * 账户余额	decimal	21，2 单位元
     */
    private Double accountBalance;
    /**
     * 上期余额	decimal	21，2 单位元
     */
    private Double lastTermBalance;
    /**
     * 备注信息	string	200
     */
    private String remarkDetail;
    /**
     * 手工记账标志	string	1		0-非手工记账 1-允许手工记账
     */
    private String permitHand;

    /**
     * 账户状态	string	1		"A 正常
     * B 停用
     * C 关闭"
     */
    private String accountStatus;

    /**
     * 挂销账状态	string	1
     * "A 正常
     * C 关闭"
     */
    private String suspendedBillStatus;


}
