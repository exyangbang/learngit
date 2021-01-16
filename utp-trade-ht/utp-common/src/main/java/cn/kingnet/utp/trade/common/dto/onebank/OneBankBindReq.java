package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**鉴权绑卡
 * @author zhongli
 * @date 2019-02-20
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OneBankBindReq  extends SpBaseRequest implements Serializable {
    /**
     * 交易流水号
     */
    private String clientTradeId;
    /**
     * yyyyMMdd
     * 交易日期
     */
    private String tradeDate;
    /**
     * HHmmss
     * 交易时间
     */
    private String tradeTime;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 账号类型 2是卡号，3是账号
     */
    private String acctType = "3";

    private OneBankAccountVerificationReq oneBankAccountVerificationReq;

    private FundAccType fundAccType;
    /**
     * 账户验证
     */
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OneBankAccountVerificationReq {
        /**版本号 */
        private String version;
        /**原渠道编码 */
        private String srcChlCode;
        /**渠道编码 */
        private String chlCode;
        /**产品代码 */
        private String productCode;
        /**路由类型 */
        private String payRouteType;
        /**路由编码 */
        private String payRouteCode;
        /**委托日期 */
        private String reqDate;
        /**委托时间 */
        private String reqTime;
        /**联网行编号 */
        private String lwhbh;
        /**输入方式 */
        private String entryMode;
        /**验证类型 */
        private String verifyType;
        /**是否验证账户类型 */
        private String verifyAcctType;
        /**强制行外验证 */
        private String forceOuterValidate;
        /**客户号 */
        private String customerNo;
        /**证件类型 */
        private String idType;
        /**证件号 */
        private String idCode;
        /**卡类型 */
        private String cardType;
        /**账户类型 */
        private String acctType;
        /**账号 */
        private String acctNo;
        /**户名 */
        private String acctName;
        /**手机号 */
        private String phone;
        /**账号密码 */
        private String pwd;
        /**接收行行号 */
        private String recvbank;
        /**cvv2 */
        private String cvv2;
        /**有效期 */
        private String validate;
        /**币种 */
        private String ccy;
        /**法人编号 */
        private String personCode;
        /**柜员 */
        private String inputUser;
        /**授权柜员 */
        private String grantUser;
        /**短信码 */
        private String smsCode;
        /**绑定关系标识号 */
        private String bindId;
        /**备注/附言 */
        private String remark;
        /**扩展域 */
        private String exts;
    }
}