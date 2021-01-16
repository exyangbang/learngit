package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/30
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryHeader {
    /**
     * 银行客户名称
     */
    private String ClientName;
    /**
     * 银行客户号
     */
    private String ClientId;
    /**
     * 证件类型	STRING(20)	O
     */
    private String IdTpCd;
    /**
     * 证件号码	STRING(30)	O
     */
    private String IdNum;

}
