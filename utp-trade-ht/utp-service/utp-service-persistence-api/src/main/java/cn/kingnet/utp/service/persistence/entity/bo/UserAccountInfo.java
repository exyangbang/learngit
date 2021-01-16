package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2020/03/27
 */
@Getter
@Setter
public class UserAccountInfo implements Serializable {

    /**
     * 虚拟账户账号
     */
    private String account;

    /**
     * 归属对象类型（1:平台|行业账户,2-企业商户 3-个人 4-手续费收入账户 5-手续费支出账户 6-归集账户 7-佣金账户 8-个体工商户账户 9-待结算账户）
     */
    private String objType;

    /**
     * 归属对象编号（行业或商户编码）
     */
    private String objCode;

    /**
     * 归属对象名称
     */
    private String objName;

    /**
     * 资金账户
     */
    private String fundAccount;

    /**
     * 账户余额（单位分）=冻结金额+可用余额
     */
    private Long balance;

    /**
     * 冻结金额（单位分）
     */
    private Long frozenAmount;

    /**
     * 可用金额（单位分）
     */
    private Long availAmount;

    /**
     * 状态（0-冻结 1-正常）
     */
    private String status;

    private String industryCode;
    private String industryName;
    /**
     * objType=2 3 8 且开通了结算账户时才有值
     */
    private String settleAccount;
    /**
     * objType=9 待结算账户时才设值（原开通待结算账户的 普通账户即结算账户）
     */
    private String origAccount;
    /**
     * merchantInfo userType 用户类型 0个人 1商户
     */
    private String userType;
    /**
     * 关联商户信息状态：参考accountStatus
     */
    private String merchantStatus;

    /**
     * 关联商户信息审核状态：审核状态0=待审核 1=已认证 2=审核驳回 9=待认证 参考merAuthStatus
     */
    private Integer merchantAuthStatus;

    private String orgCode;
    private String orgName;
}
