package cn.kingnet.utp.trade.common.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/30
 */
@Getter
@Setter
public class IndustryPayInfo implements Serializable {

    private String industryCode;
    private String industryName;
    private String orgCode;
    private String orgName;
    private String industryAccount;

    private String fundAccType;
    private String fundAccNo;
    private String fundAccName;
    private String fundBankCode;

    private String feeOutAccount;
    private String feeOutName;
    private String feeInAccount;
    private String feeInName;

    private String status;
    private String industryType;
    private String businessType;
    private String innerNoticeUrl;

}
