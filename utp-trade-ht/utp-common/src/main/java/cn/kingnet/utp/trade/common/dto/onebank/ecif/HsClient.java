package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/30
 */
@Getter
@Setter
public class HsClient implements Serializable {
    /**
     * 客户号	INT(8)	O  查询成功且不为空则 已存在
     */
    private String ClientId;
    /**
     * 客户名称	STRING(200)	O
     */
    private String ClientName;
    /**
     * 客户类型	STRING(1)	O
     */
    private String ClientCode;
    /**
     * 客户状态	STRING(20)	O
     */
    private String ClientStTpCd;
    /**
     * 客户分类	STRING(20)	O
     */
    private String ClientCatTpCd;
    /**
     * 疑似客户类型	STRING(20)	O
     */
    private String SuspectTpCd;
    /**
     * 手机号	STRING(20)
     */
    private String Mobile;


}
