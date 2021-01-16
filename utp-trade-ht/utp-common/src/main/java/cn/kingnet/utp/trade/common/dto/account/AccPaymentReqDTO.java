package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 子账户单笔付款
 * @Author : linkaigui
 * @Create : 2020/5/14 10:26
 */
@Getter
@Setter
public class AccPaymentReqDTO extends BaseRequestDTO {

    /**请求日期*/
    private String reqDate;

    /**请求时间*/
    private String reqTime;

    /**付款子账户*/
    private String userAccount;

    /**付款金额*/
    private String payAmt;

    /**显示付款账号*/
    private String showPayerAcctNo;

    /**显示付款户名*/
    private String showPayerName;

    /**收款人账户类型*/
    private String payeeAcctType;

    /**收款人账号*/
    private String payeeAcctNo;

    /**收款人账户名称*/
    private String payeeAccName;

    /**收款人开户行号*/
    private String opBankCode;

    /**收款人开户行名称*/
    private String opBankName;

    /**清算行行号*/
    private String clBankCode;

    /**收款人证件类型*/
    private String idType;

    /**收款人证件号*/
    private String idCode;

    /**营业执照号*/
    private String businessLicenseCode;

    /**备注说明*/
    private String remark;

    /**支付订单号列表*/
    private String tradeOrderIds;

    /**回调地址*/
    private String callbackUrl;
}
