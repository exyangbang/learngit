package cn.kingnet.utp.trade.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description  平台|功能账户 的来款账户配置
 * @Author WJH
 * @Date 2020/04/09
 */
@Data
public class IndustryAccountInfoBo implements Serializable {
    /**
     * 平台或功能账户对应的虚账户
     */
    private String account;
    /**
     * 平台客户号或功能账户客户号
     */
    private String industryCode;
    private String industryName;
    private String industryType;

    /**
     * 来款|汇款 账号
     */
    private String accountNo;
    /**
     * 来款|汇款 账户名称
     */
    private String accountName;
}
