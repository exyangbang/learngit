package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 内部户：资金账户资金明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
@Getter
@Setter
@NoArgsConstructor
public class OneBankInnerAccountTransDetailQueryRespDTO extends SpBaseResponse implements Serializable {


    /**
     * 客户账号
     */
    private String custAccountNo;
    /**
     * 账务机构
     */
    private String accountBranchCode;
    /**
     * 货币代号
     */
    private String currencyCode;
    /**
     * 交易账务日期
     */
    private String txnDate;
    /**
     * 明细序号
     */
    private Long detailSerialNumber;
    /**
     * 借贷标志
     * "0-借方
     * 1-贷方"
     */
    private String drcrFlag;
    /**
     * 交易金额
     */
    private Double txnAmount;
    /**
     * 交易机构
     */
    private String txnBranchCode;
    /**
     * 操作柜员
     */
    private String tellerId;
    /**
     * 摘要代码
     */
    private String summaryCode;
    /**
     * 摘要描述
     */
    private String summaryDescription;
    /**
     * 备注信息
     */
    private String remarkDetail;
    /**
     * 主交易流水号
     */
    private String sysReferenceno;
    /**
     * 原主交易流水号
     */
    private String orgSysReferenceno;

    /**
     * 交易明细状态 0-正常             1-被冲账           2-冲账
     */
    private String reverseFlag;

    /**
     * 账户余额
     */
    private Double accountBalance;
    /**
     * 对方行名
     */
    private String otherBankName;

    /**
     * 对方账号
     */
    private String otherAccount;
    /**
     * 对方账户名称
     */
    private String otherCustName;

    /**
     * 对手方方备注
     */
    private String otherRemark;
    /**
     * 交易时间
     */
    private String txnTime;
    /**
     * 主机日期
     */
    private String sysDate;
    /**
     * 户名
     */
    private String accountName;

    /**
     * 业务流水号
     */
    private String bizReferenceno;


}
