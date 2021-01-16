package cn.kingnet.utp.scheduler.data.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 收益手续费账户归集划转业务对象
 * @Author WJH
 * @Date 2019/08/13
 */
@Getter
@Setter
public class FeeIncomeAndCollectionBO implements Serializable {

    private String feeIndustryCode;
    private String feeIndustryName;
    private String feeIndustryAccount;
    private String feeOrgCode;
    private String feeOrgName;
    private String feeFundAccType;
    private String feeFundAccNo;
    private String feeFundAccName;
    private String feeFundOpBankCode;

    private String collectionIndustryCode;
    private String collectionIndustryName;
    private String collectionIndustryAccount;
    private String collectionFundAccType;
    private String collectionFundAccNo;
    private String collectionFundAccName;
    private String collectionFundOpBankCode;


}
