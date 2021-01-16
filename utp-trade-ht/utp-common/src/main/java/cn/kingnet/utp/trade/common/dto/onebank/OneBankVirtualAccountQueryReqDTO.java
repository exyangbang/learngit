package cn.kingnet.utp.trade.common.dto.onebank;

import lombok.*;

import java.io.Serializable;

/**
 * @Description : 电子账户所属实体机构户查询
 * @Author : linkaigui
 * @Create : 2019/3/14 16:32
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankVirtualAccountQueryReqDTO  implements Serializable {

    private OneBankReqHead reqHead;

    private ReqBody reqBody;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqBody implements Serializable {
        /**
         * @X(.21) acctNo    虚拟账户账号	N
         */
        private String acctNo;

        /**
         * acctName	虚拟账户户名	Y	若填写，则校验账号与户名
         */
        private String acctName;
        /**
         * 来账金额	N	单位分
         */
        private Long amt;
        /**
         * 来账账号	N
         */
        private String exAcctNo;
        /**
         * 来账账户名	N
         */
        private String exAcctName;
    }
}
