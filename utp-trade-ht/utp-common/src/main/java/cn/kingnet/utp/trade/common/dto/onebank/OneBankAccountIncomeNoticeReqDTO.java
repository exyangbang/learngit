package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : 华通内部户入金通知
 * @Author : linkaigui
 * @Create : 2019/3/14 19:31
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankAccountIncomeNoticeReqDTO  extends SpBaseRequest implements Serializable {

    private OneBankReqHead reqHead;

    private ReqBody reqBody;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBody implements Serializable {
        //X(.32)	acctNo	虚拟账户账号	N
        private String acctNo;
        //X(.90)	acctName	虚拟账户客户姓名	Y
        private String acctName;
        //X(.15)	amt	充值金额	N
        private Long amt;
        //X(.34)	coreNo	核心主交易流水	N [华通核心流水号 = 银行资金明细(SysReferenceNo)  ]
        private String coreNo;
        //X(.32)	rid	请求业务流水号	N [下游订单入金流水报备匹配字段 即二级账户入金通知的 外部业务流水号]
        private String rid;
        //X(.32)	exAcctNo	来账账号	N
        private String exAcctNo;
        //X(.90)	exAcctName	来账户名	N
        private String exAcctName;
        //X(.20)	clearBankno	来账账号清算行号	N
        private String clearBankno;
        //X(.90)	bankName	来账账号行名	N
        private String bankName;
        //X(.34)	tranNo	支付系统业务流水号	N
        private String tranNo;
        //X(.8)	tranDate	对账日期	N
        private String tranDate;
        //X(.32)	autoPayeeAcctNo	入账账户	N
        private String autoPayeeAcctNo;
        //X(.90)	autoPayeeAcctName	入账户名	N
        private String autoPayeeAcctName;
        //X(.32)	manualPayeeAcctNo	手工提入账户	Y
        private String manualPayeeAcctNo;
        //X(.90)	manualPayeeAcctName	手工提入户名	Y
        private String manualPayeeAcctName;
        //X(2)	bizFlag	业务状态	N
        private String bizFlag;
        //X(.255)	remark	备注	Y
        private String remark;
    }
}
