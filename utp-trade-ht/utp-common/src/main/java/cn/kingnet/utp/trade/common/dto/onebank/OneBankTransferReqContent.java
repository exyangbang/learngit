package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhongli
 * @date 2018/10/16
 */
@Setter
@Getter
public class OneBankTransferReqContent implements Serializable {
    /**产品代码*/
    private String productCode;
    /**源渠道编码*/
    private String srcChlCode;
    /**渠道编码*/
    private String chlCode;
    /**请求日期*/
    private String reqDate;
    /**请求时间*/
    private String reqTime;
    /**机构号*/
    private String orgId;
    /**卡类型*/
    private String cardType;
    /**路由类型*/
    private String payRouteFlag;
    /**路由编码*/
    private String payRouteCode;
    /**账户类型*/
    private String acctType;
    /**付款人账号*/
    private String payerAcctNo;
    /**付款人名称*/
    private String payerName;
    /**付款人地址*/
    private String payerAddr;
    /**付款人清算行行号*/
    private String payerOpbk;
    /**收款人账号*/
    private String payeeAcctNo;
    /**收款人名称*/
    private String payeeName;
    /**收款人清算行行号*/
    private String payeeOpbk;
    /**收款人地址*/
    private String payeeAddr;
    /**实际付款账号*/
    private String realpayerAcctNo;
    /**实际付款户名*/
    private String realpayerName;
    /**收付款方替换标志*/
    private String replacement;
    /**替换收款方户名*/
    private String rplpayeeName;
    /**替换付款方户名*/
    private String rplpayerName;
    /**手机号*/
    private String phone;
    /**证件类型*/
    private String idType;
    /**证件号*/
    private String idCode;
    /**卡号*/
    private String cardNo;
    /**币种*/
    private String ccy;
    /**交易金额*/
    private String amount;
    /**法人编码*/
    private String personCode;
    /**柜员*/
    private String inputUser;
    /**授权柜员*/
    private String grantUser;
    /**手续费收取方式*/
    private String feeType;
    /**手续费金额*/
    private String feeAmount;
    /**手续费币种*/
    private String feeCurrency;
    /**手续费扣账账号*/
    private String feePayeracc;
    /**手续费扣账账号网点*/
    private String feePayerorgid;
    /**手续费收款账号网点*/
    private String feePayeeorgid;
    /**费项代码*/
    private String paymentCode;
    /**前台通知地址*/
    private String noticeAddr;
    /**退汇标识*/
    private String returnFlag;
    /**摘要码*/
    private String paySummaryCode;
    /**异步通知服务id*/
    private String bizCharactCode;
    /**异步通知场景id*/
    private String transScenario;
    /**备注/附言*/
    private String remark;
    /**附加域*/
    private String addtion;
    /**其他信息*/
    private String otherMsg;
    /**业务类型*/
    private String busiType;
    /**业务种类*/
    private String busiKind;
    /**商户号|银联渠道必填*/
    private String merID;
    /**省*/
    private String prov;
    /**城市*/
    private String city;
    /**用途*/
    private String purpose;
    /**对公对私标志*/
    private String pc_flag;
    /**付款人客户号*/
    private String customerNo;
    /**批次号*/
    private String batchNo;
    /**收款人客户号*/
    private String payeeCustomerNo;
    /**可疑账号确认标识*/
    private String doubtfulAcctEnter;
    /**请求方备用域1*/
    private String reqReserved1;
    /**请求方备用域2*/
    private String reqReserved2;
    /**请求方备用域3*/
    private String reqReserved3;
    /**付款人开户行号*/
    private String payerSubBank;
    /**收款人开户行号*/
    private String payeeSubBank;
    /**业务特征识别码*/
    private String busiFeatureCode;
    /**渠道交易日期*/
    private String channelTxnDate;
    /**短信特征码*/
    private String msg_code;
    /**是否验密*/
    private String checkPasswordFlag;
    /**交易密码*/
    private String password;
    /**产品协议代码*/
    private String busiProduct;
    /**到账时效*/
    private String transTiming;
    /**业务发起者*/
    private String sender;
    /**核心备注附言*/
    private String hostRemark;
    /**紧急标志*/
    private String priority;
    /**待冻结分类码*/
    private String holdProductCode;
    /**待冻结金额*/
    private String holdAmount;
    /**待冻结到期日*/
    private String holdStopDate;
    /**冻结原因*/
    private String holdReason;
    /**原解冻编号*/
    private String unholdAmount;
    /**解冻金额*/
    private String oraginHoldSerialNo;
    /**商户名称	String	40		N			业务要求选送**/
    private String merName;
    /**商户简称	String	8		N			业务要求选送**/
    private String merAbbr;
    /**商户类别	String	4		N			业务要求选送**/
    private String merCatCode;
    /**资金来源	String	2		N			业务要求选送**/
    private String sourcesOfFunds;

}
