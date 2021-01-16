package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 一般户 信息查询
 * @Author : WJH
 * @Create : 2019/07/24 14:46
 */
@Setter
@Getter
@NoArgsConstructor
public class OneBankAccountInfoQueryRespDTO extends SpBaseResponse implements Serializable {
    /**
     * 是否有后续数据	string	1	Y	0-无 1-有
     */
    private String hasMore;
    /**
     * 记录总行数	long	19	Y
     */
    private Long totalRecords;
    /**
     * 客户号	string	12
     */
    private String custNumber;
    /**
     * 客户账号	string	40
     */
    private String custAccountNo;
    /**
     * 账户名称	string	200
     */
    private String accountName;
    /**
     * 开户机构	string	10
     */
    private String openBranchCode;
    /**
     * 支付条件	string	1		0-无 1-凭密码 2-凭证件 3-凭密码+证件 4-凭密码+印签 5-凭印鉴/签名 9-不校验支付条件
     */
    private String paymentCondition;
    /**
     * 通兑范围	string	1	Y
     */
    private String interBranchRange;
    /**
     * 开户日期	string	8
     */
    private String openDate;
    /**
     * 账户销户日期	string	8
     */
    private String accountClosureDate;
    /**
     * 卡号	string	35
     */
    private String cardNumber;
    /**
     * 账户性质	string	1		参考"账户性质"
     */
    private String accountType;
    /**
     * 账户封闭冻结标志	string	1		0-否 1-是
     */
    private String fullClosed;
    /**
     * 账户只付不收标志	string	1		0-否 1-是
     */
    private String onlyPay;
    /**
     * 账户只收不付标志	string	1		0-否 1-是
     */
    private String onlyAccept;
    /**
     * 开户描述	string	200
     */
    private String description;
    /**
     * 保证金类型	string	1
     * "A-银行承兑汇票保证金
     * B-信用证保证金
     * C-保函保证金
     * D-外汇买卖保证金
     * E-衍生金融产品保证金
     * F-个人保证金
     * O-其他保证金"
     */
    private String bailType;
    /**
     * 客户账号类型	string	10		参考"账号类型"
     */
    private String custAccountType;
    /**
     * 开户渠道备注	string	200
     * "零售：HJ-APP
     * 托管：HJ-ACS
     * 58零售账户： ML_58
     * 柜面批量开对公户： ML_HT"
     */
    private String acctOpenRemark;


}
