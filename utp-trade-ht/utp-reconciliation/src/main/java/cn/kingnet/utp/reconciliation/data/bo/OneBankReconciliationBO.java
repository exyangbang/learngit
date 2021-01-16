package cn.kingnet.utp.reconciliation.data.bo;

import lombok.Data;

/**
 * @Description : 对账单对象
 * 渠道请求流水号|渠道请求日期|渠道请求时间|业务流水号|交易金额|交易币种|手续费金额|手续费币种|交易类型|产品代码
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 16:34
 */
@Data
public class OneBankReconciliationBO {

    /**渠道请求流水号*/
    private String reqTradeId;

    /**渠道请求日期*/
    private String reqDate;

    /**渠道请求时间*/
    private String reqTime;

    /**业务流水号*/
    private String bizSeqNo;

    /**交易金额*/
    private String amount;

    /**交易币种*/
    private String ccy;

    /**手续费金额*/
    private String feeAmount;

    /**手续费币种*/
    private String feeCcy;

    /**交易类型*/
    private String payTransType;

    /**产品代码*/
    private String productCode;

    /**邮路编码*/
    private String payRouteCode;

    /**付款人账号*/
    private String payerAcctNo;

    /**付款人名称*/
    private String payerName;

    /**付款人开户行号*/
    private String payerOpbk;

    /**付款人开户行名*/
    private String payerOpbkName;

    /**付款人清算行号*/
    private String payerClearBank;

    /**付款人清算行名*/
    private String payerClearBankName;

    /**收款人账号*/
    private String payeeAcctNo;

    /**收款人名称*/
    private String payeeName;

    /**收款人开户行号*/
    private String payeeOpbk;

    /**收款人开户行名*/
    private String payeeOpbkName;

    /**收款人清算行号*/
    private String payeeClearBank;

    /**收款人清算行名*/
    private String payeeClearBankName;

    /**手工提入账号*/
    private String manualPayeeAcctNo;

    /**手工提入户名*/
    private String manualPayeeAcctName;

    /**备注*/
    private String remark;

    /**类别*/
    private String category;

    /**入账账号*/
    private String autoPayeeAcctNo;

    /**入账户名*/
    private String autoPayeeAcctName;
}
