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
public class UserPayInfo implements Serializable {

    private String industryCode;
    private String industryName;
    private String userAccount;
    private String userName;
    private String userAccType;
    private String fundAccNo;
    private String fundAccName;
    private String bankCode;
    private String bankName;
    private String receiveBankCode;
    private String orgCode;
    private String orgName;
    private String merNo;
    private String status;
    private String nature;
    private String settleAccount;
    private String userType;
    private Integer authStatus;

}
