package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description: 小额打款验证绑卡状态变化通知
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/10 14:50
 */
@Getter
@Setter
public class PaymentCheckBo implements Serializable {
    /**
     * 代付客户号
     */
    private String industryCode;
    /**
     * 服务端流水号
     */
    private String serverTransId;
    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 绑定状态
     */
    private String bindStatus;
    /**
     * 渠道返回码
     */
    private String errCode;
    /**
     * 渠道返回信息描述
     */
    private String errMsg;
}