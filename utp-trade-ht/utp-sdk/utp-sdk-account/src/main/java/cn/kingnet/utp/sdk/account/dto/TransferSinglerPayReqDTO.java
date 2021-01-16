package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @Description : 转账请求DTO
 * @Author : linjiazhen@scenetec.com
 * @Create : 2018/11/29 17:00
 */
@Data
public class TransferSinglerPayReqDTO extends BaseRequestDTO {
    /**请求日期*/
    private String reqDate;
    /**请求时间*/
    private String reqTime;
    /**代付金额*/
    private String payAmt;


    /**显示付款账号*/
    private String showPayerAcctNo;
    /**显示付款户名*/
    private String showPayerName;
    /**账户类型
     * @按需要第5次调整，上送报文参数acctType改为对公对对私标识 0=对私1=对公
     * @按需要第7次调整，添加一种类型 0=对私1=对公2=单位结算卡
     * */
    private String acctType;
    /**账号*/
    private String acctNo;
    /**账户名称*/
    private String accName;

    private String opBankCode;
    private String opBankName;
    private String clBankCode;
    /**回调地址*/
    private String callbackUrl;
    /**备注说明*/
    private String remark;

    /**
     * 证件类型
     */
    private  String idType;
    /**
     * 证件号
     */
    private  String idCode;

    /**
     * 营业执照号
     */
    private String businessLicenseCode;
}
