package cn.kingnet.utp.trade.common.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author sheqingquan@scenetec.com
 * @description: 绑卡信息
 * @create 2020/4/9 19:34
 */
@Getter
@Setter
public class CardInfoBo implements Serializable {
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