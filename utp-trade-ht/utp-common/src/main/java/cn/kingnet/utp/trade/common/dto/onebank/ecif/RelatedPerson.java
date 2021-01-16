package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2020/05/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatedPerson implements Serializable {

    /**
     * 关系类型	STRING(20)	Y
     * 1213	    法定代表人 legal
     * 1223	    实际控制人 actualMaster
     * 1214	    负责人 principal
     * 2234	授权代理人 authProxy
     */
    private String relTpCd;
    /**
     * 关联人中文名称	STRING(100)	O
     */
    private String chineseName;
    /**
     * 关联人证件类型	STRING(20)	O
     */
    private String idTpCd;
    /**
     * 关联人证件号码	STRING(40)	O
     */
    private String idNum;

    /**
     * 需求证件生效日期 新增
     */
    private String startDt;
    /**
     * 需求证件失效期
     */
    private String expiryDt;

    /**
     * Mobile	关联人手机号码	STRING(30)	O
     * 20201012 企业联系方式（手机号码）需要更改送至关联人信息中的法人手机号位置。
     */
    private String mobile;

}
