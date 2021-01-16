package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.*;

import java.io.Serializable;

/**
 * @Description: 1-平台账户|5-手续费支出账户|10-小额打款支出账户
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/9 14:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndustryAccountBo implements Serializable {
    /**
     * 虚拟账号 M
     */
    private String userAccount;
    /**
     * 账户类型 M
     * 1	平台账户
     * 5	手续费支出账户
     * 10   小额打款支出账户
     */
    private String accType;
}