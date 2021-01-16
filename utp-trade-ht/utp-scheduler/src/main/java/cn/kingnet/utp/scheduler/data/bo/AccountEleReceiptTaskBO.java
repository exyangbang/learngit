package cn.kingnet.utp.scheduler.data.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 开户电子回单PDF
 * @Author : linkaigui
 * @Create : 2020/3/17 10:57
 */
@Getter
@Setter
public class AccountEleReceiptTaskBO implements Serializable {

    /**
     * 虚拟账户
     */
    private String account;

    /**
     * 账户性质(1-平台|行业账户,2-企业商户,3-个人,4-手续费收入账户,5-手续费支出账户,6-归集账户,7-佣金账户,8-个体工商户账户,9-待结算账户)
     */
    private String nature;
}
