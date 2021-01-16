package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : 一般户：资金账户资金明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneBankAccountTransDetailQueryRespDTO extends SpBaseResponse implements Serializable {

    /**
     * 卡号
     */
    private String cardNumber;
    /**
     * 客户账号
     */
    private String custAccountNo;

    /**
     * 客户账户类型
     */
    private String custAccountType;
    /**
     * 子账户序号
     */
    private String subAccountSerialNo;
    /**
     * 交易账务日期
     */
    private String txnDate;

    /**
     * 交易起息日期
     */
    private String valueDate;
    /**
     * 交易自然日期
     **/
    private String natureDate;
    /**
     * 明细序号
     */
    private Long detailSerialNumber;
    /**
     * 借贷标志
     */
    private String drcrFlag;
    /**
     * 货币代号
     */
    private String currencyCode;
    /**
     * 现转标志
     */
    private String cashOrremit;
    /**
     * 交易金额
     */
    private Double txnAmount;
    /**
     * 账户余额
     */
    private Double accountBalance;
    /**
     * 交易机构
     */
    private String txnBranchCode;
    /**
     * 操作柜员
     */
    private String tellerId;
    /**
     * 柜员流水号
     */
    private String tellerSequenceNo;
    /**
     * 系统调用流水号
     */
    private String sysReferenceno;
    /**
     * 业务流水号
     */
    private String bizReferenceno;
    /**
     * 原系统调用流水号
     */
    private String orgSysReferenceno;
    /**
     * 原业务流水号
     */
    private String orgBizReferenceno;
    /**
     * 凭证种类
     */
    private String inventoryType;

    /**
     * 凭证序号
     */
    private String invenSerialNumber;
    /**
     * 对方行名
     */
    private String otherBankName;
    /**
     * 对方机构名称
     */
    private String otherBranchName;

    /**
     * 对方账号
     */
    private String otherCustAccountNo;

    /**
     * 对方客户名称
     */
    private String otherCustName;


    /**
     * 对手方方备注
     */
    private String remark;
    /**
     * 冲正标志
     */
    private String reversedFlag;
    /**
     * 摘要代码
     */
    private String summaryCode;
    /**
     * 摘要描述
     */
    private String summaryDescription;
    /**
     * 备注信息
     */
    private String remarkDetail;
    /**
     * TOKEN
     */
    private String token;
    /**
     * OTHER_TOKEN
     */
    private String otherToken;
    /**
     * 合作伙伴Id
     */
    private String txnPartnerId;


}
