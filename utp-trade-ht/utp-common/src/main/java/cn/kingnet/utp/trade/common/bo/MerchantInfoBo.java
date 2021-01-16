package cn.kingnet.utp.trade.common.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2020/04/01
 */
@Data
public class MerchantInfoBo implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 虚拟账户
     */
    private String account;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 所属收单机构代码
     */
    private String orgCode;

    /**
     * 所属收单机构名称
     */
    private String orgName;

    /**
     * 所属行业代码
     */
    private String industryCode;

    /**
     * 所属行业名称
     */
    private String industryName;
    /**
     * 商户状态 0未开户 1已开户已绑卡 2已开户未绑卡 3已销户 4冻结
     */
    private String status;


    /**
     * 用户类型|0-个人 1-商户
     */
    private String userType;

    /**
     * 审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
     */
    private Integer authStatus;

    /**
     * 账户性质(1-平台|行业账户,2-企业商户,3-个人,4-手续费收入账户,5-手续费支出账户,6-归集账户,7-佣金账户,8-个体工商户账户,9-待结算账户)
     */
    private String nature;

    /**
     * 待结算虚拟账户
     */
    private String settleAccount;

    /**
     * FIXME 是否待结算账户：是待结算账户主体 虚账户取值应为 settleAccount
     */
    public boolean isSettleAccountFlag() {
        return "9".equals(nature);
    }

    /**
     * 真实原入参查询的虚账户
     *
     * @return
     */
    public String getOrigRealAccount() {
        return isSettleAccountFlag() ? this.getSettleAccount() : this.getAccount();
    }

}
