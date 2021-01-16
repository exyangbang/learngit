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
public class CommonPayInfo implements Serializable {
    /**
     * 归属平台客户号
     **/
    private String industryCode;
    /**
     * 归属平台客户名称
     **/
    private String industryName;
    /**
     * 归属机构编码
     **/
    private String orgCode;
    /**
     * 归属机构编码名称
     **/
    private String orgName;

    /***虚账户类型**/
    private String accountType;
    /***虚账户号**/
    private String accountNo;
    /***虚账户名称**/
    private String accountName;
    /***银行账号**/
    private String bankAccountNo;
    /***银行账户名称**/
    private String bankAccountName;

    /**
     * 开户行 行号
     **/
    private String openBankCode;
    /**
     * 开户行 名称
     **/
    private String openBankName;
    /**
     * 清算行 行号
     */
    private String receiveBankCode;


    public static CommonPayInfo build(UserPayInfo userPayInfo){
        CommonPayInfo commonPayInfo = new CommonPayInfo();
        commonPayInfo.setIndustryCode(userPayInfo.getIndustryCode());
        commonPayInfo.setIndustryName(userPayInfo.getIndustryName());
        commonPayInfo.setOrgCode(userPayInfo.getOrgCode());
        commonPayInfo.setOrgName(userPayInfo.getOrgName());

        commonPayInfo.setAccountType(userPayInfo.getNature());
        commonPayInfo.setAccountNo(userPayInfo.getUserAccount());
        commonPayInfo.setAccountName(userPayInfo.getUserName());
        commonPayInfo.setBankAccountNo(userPayInfo.getFundAccNo());
        commonPayInfo.setBankAccountName(userPayInfo.getFundAccName());

        commonPayInfo.setOpenBankCode(userPayInfo.getBankCode());
        commonPayInfo.setOpenBankName(userPayInfo.getBankName());
        commonPayInfo.setReceiveBankCode(userPayInfo.getReceiveBankCode());

        return commonPayInfo;
    }
    public static CommonPayInfo build(IndustryPayInfo industryPayInfo){
        CommonPayInfo commonPayInfo = new CommonPayInfo();
        commonPayInfo.setIndustryCode(industryPayInfo.getIndustryCode());
        commonPayInfo.setIndustryName(industryPayInfo.getIndustryName());
        commonPayInfo.setOrgCode(industryPayInfo.getOrgCode());
        commonPayInfo.setOrgName(industryPayInfo.getOrgName());

        commonPayInfo.setAccountType(industryPayInfo.getIndustryType());
        commonPayInfo.setAccountNo(industryPayInfo.getIndustryAccount());
        commonPayInfo.setAccountName(industryPayInfo.getIndustryName());
        commonPayInfo.setBankAccountNo(industryPayInfo.getFundAccNo());
        commonPayInfo.setBankAccountName(industryPayInfo.getFundAccName());

        //目前平台的开户行和名称只能为华通
        commonPayInfo.setOpenBankCode("323391060018");
        commonPayInfo.setOpenBankName("福建华通银行");
        commonPayInfo.setReceiveBankCode(industryPayInfo.getFundBankCode());

        return commonPayInfo;
    }

}
