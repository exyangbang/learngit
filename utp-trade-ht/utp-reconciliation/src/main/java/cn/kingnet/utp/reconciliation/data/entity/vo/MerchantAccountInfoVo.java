package cn.kingnet.utp.reconciliation.data.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MerchantAccountInfoVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商户号
     */
    private String merNo;

    /**
     * 虚拟账号
     */
    private String account;

    /**
     * 账户类型
     */
    private String accountType;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 开户行行号
     */
    private String bankCode;

    /**
     * 开户行行名称
     */
    private String bankName;

    /**
     * 接收行号/结算结构代码
     */
    private String receiveBankCode;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 随机小额打款金额
     */
    private Long authAmt;

    /**
     * 绑卡状态0=正常 1=打款处理中 2=打款失败 3=打款成功待验证 4=验证失败 5冻结 6解绑
     */
    private String bindStatus;

    /**
     * 验证次数
     */
    private Integer authCount;

    /**
     * 请求绑卡时间
     */
    private Date reqBindDate;

    /**
     * 冻结时间
     */
    private Date freezeDate;

    /**
     * 渠道打款响应码
     */
    private String channelRespCode;

    /**
     * 渠道打款响应描述
     */
    private String channelRespMsg;
}
