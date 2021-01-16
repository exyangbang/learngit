package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.AccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhongli
 * @date 2019-02-21
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenAccountBo {
    MerchantInfo merchantInfo;
    Account account;

    //京东定制化时 营业执照有效期及法人有效期
    AccountInfo accountInfo;
    Boolean updateFlag;
}
