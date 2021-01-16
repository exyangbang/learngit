package cn.kingnet.utp.trade.common.utils;

import cn.kingnet.utp.trade.common.enums.AccountType;
import cn.kingnet.utp.trade.common.enums.HTPcFlag;

/**
 * @Description
 * @Author WJH
 * @Date 2019/09/03
 */
public class AccountType2HtPcFlag {

    public static HTPcFlag getHTPcFlag(AccountType accountType) {
        if (accountType == AccountType.PUBLIC || accountType == AccountType.BILLING_CARD) {
            return HTPcFlag.PUBLIC;
        } else {
            return HTPcFlag.PRIVATE;
        }
    }

}
